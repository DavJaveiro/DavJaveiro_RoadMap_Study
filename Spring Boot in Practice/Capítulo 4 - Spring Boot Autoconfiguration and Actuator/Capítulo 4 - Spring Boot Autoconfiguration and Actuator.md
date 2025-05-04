**This chapter covers**
- [ ] *Introducing Spring Boot autoconfiguration, various types of conditional annotation, and in-edpth discussion.*
- [ ] *An overview of Spring Boot DevTools, how to configure it, and its various purposes*;
- [ ] *Introducing Spring Boot FailureAnalyzer and how to define a custom application-specific FailureAnalyzer*;
- [ ] *An ind-depth discussion on Spring Boot Actuator and how to define custom metrics*;

Já aprendemos bastante sobre Spring Boot nos últimos três capítulos. Agora temos uma base sólida em Spring Boot, tendo visto várias funcionalidades do framework e diversas tarefas comuns que precisamos realizar diariamente. Também aprendemos como se comunicar e usar um banco de dados em uma aplicação Spring Boot.

Neste capítulo, exploraremos dois conceitos principais do Spring Boot: a **autoconfiguração do Spring Boot** e o **Spring Boot Actuator**. Aprenderemos vários blocos de construção da autoconfiguração do Spring Boot e exploraremos como ela funciona em uma aplicação. Vamos explorar diversas anotações condicionais (*conditional annotations*), que são a base da autoconfiguração do Spring Boot. Em seguida, descobriremos o Spring Boot Actuator, que permite monitor a saúde da nossa aplicação e interagir com ela.

## 4.1 Understanding Spring Boot autoconfiguration
- [ ] 4.1.1 Understanding *@Conditional* annotation
- [ ] 4.1.2 Deep dive into autoconfiguration

A **autoconfiguration** do Spring Boot é provavelmente a característica mais importante e uma das principais razões por trás da popularidade do **Spring Boot**. Como o nome sugere, a **autoconfiguration** configura automaticamente os componentes da aplicação que precisaríamos ao desenvolver uma aplicação **Spring**. Ela faz uma suposição sensata sobre os componentes da aplicação e tenta fornecer uma configuração padrão com a qual inicializa a aplicação. Por exemplo, se incluirmos a dependência **spring-boot-starter-web** em nosso arquivo de configuração de **build**, então o **Spring Boot** assuma que precisamos de um **webserver** para executar a aplicação web. Assim, ele configura automaticamente o **webserver Apache Tomcat**. 

Outra característica interessante é a sua flexibilidade. Se a **autoconfiguração** determina que o desenvolvedor configurou explicitamente um componente da aplicação, ela simplesmente recua e não configura automaticamente esse componente específico, utilizando em vez disso a configuração fornecida pelo desenvolvedor.

Por exemplo, ao usar a dependência **spring-boot-starter-web**, o **Spring Boot** utiliza o **Apache Tomcat** como o **web server** padrão. No entanto, se configurarmos um **web server** diferente e excluirmos o **Apache Tomcat**, o **Spring Boot** desiste de sua configuração padrão com **Tomcat** e passa a usar o **web server** definido pelo usuário. 

O trecho a seguir mostra a configuração do **Jetty web server** em uma aplicação **Spring Boot**, substituindo o **Tomcat** padrão:
```json
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency
```

Imagine que estamos trabalhando em uma organização onde <span style="background:#d4b106">equipes de desenvolvimento estão trabalhando em vários projetos</span> usando o **Spring framework**. Em determinado momento, um dos desenvolvedores percebe que alguns **beans** de configuração do **Spring** <span style="background:#d4b106">são utilizados por todas as equipes</span> e estão <span style="background:#d4b106">duplicados entre os projetos</span>. Diante disso, o desenvolvedor pode decidir extrair essas configurações duplicadas em uma configuração comum de **application context**, conforme mostrado no seguinte exemplo:

```java
@Configuration
public class CommonApplicationContextConfiguration {

	// Creates a Spring Bean of type RelationalDataSourceConfiguration
	
	@Bean
		public RelationalDataSourceConfiguration dataSourceConfiguration() {
			return new RelationalDataSourceConfiguration();
		}

		// Other commoly used Spring bean definitions
}
```
A anotação *@Configuration* indica que essa é uma classe de configuração.

A listagem 4.2, acima, apresenta uma configuração de exemplo da *CommonApplicationContextConfiguration*:
- A classe de configuração *CommonApplicationContextConfiguration* reside em um projeto separado e é publicado como um componente Maven ou Gradle independente. Assim, outras equipes podem utilizá-la como uma dependência em seus projetos.
- A classe *RelationaDataSourceConfiguration* fornece uma configuração de fonte de dados relacional que inicializa o banco de dados e retorna uma fonte de dados. Como a maioria das equipes utiliza um banco de dados relacional, faz sentido extrair e manter essa configuração separadamente. Além disso, para simplificar, fornecemos apenas uma configuração, mas a classe **CommonApplicationContextConfiguration** pode conter outras configurações comuns, como a definição do bean do gerenciador de transações do Spring.

**Por que isso é útil?**
1. **Evita duplicação** - se 5 equipes precisam da mesma configuração de **DataSource**, em vez de cada uma criar sua própria versão, todas usam essa classe centralizada. 
2. **Facilita a manutenção** - Se a configuração do banco de dados mudar (ex.: novo driver, ajuste de pool de conexões), atualizamos **apenas essa classe**, e todos os projetos que a usam herdam a mudança; 
3. **Promove consistência** - garante que todos os projetos usem a mesma configuração padrão, reduzindo erros.

**Como outros projetos usam essa configuração?**
1. **Empacotando como dependência**
	- Essa classe é colocada em um projeto separado  (ex.: **common-spring-config**) e publica em um repositório Maven/Gradle.
	- Outros projetos adicionam essa dependência no **pom.xml** (Maven) ou **build.gradle** (Gradle);

O exemplo está alinhado com o **Princípio de Responsabilidade única (SRP - Single Responsilbility Principle)**, que é o primeiro dos princípios SOLID de design de software orientado a objetos. 

Outras equipes que precisarem usar a **CommonApplicationContextConfiguration** podem importar essa configuração comum em suas classes de configuração específicas, conforme mostrado na listagem a seguir:
```java
@Configuration
@Import(CommonApplicationContextConfiguration.class)
public class CommonPaymentContextConfiguration {
	// Definições de beans para as equipes de pagamento\
}
```

Importa os **beans** do Spring definidos na classe *CommonApplicationContextConfiguration*. 

As equipes podem definir definições de beans específicas do projeto em seus respectivos arquivos de configuração.  Essa abordagem funciona bem na maioria dos cenários, mas há um problema: se uma equipe quiser usar todos os beans definidos na **CommonApplicationContextConfiguration**, exceto uma definição específica de **bean**?
Por exemplo, uma equipe desejar usar todos os beans definidos na **CommonApplicationContextConfiguration**, mas não o **RelationalDataSourceConfiguration**, pois eles não utilizam um banco de **dados relacional**. Assim, deve haver alguma forma de informar ao Spring que importar a configuração **CommonApplicationContextConfiguration** está correto, mas que o **bean** em específico, não deve ser criado.

Como podemos alcançar isso? A anotação *@Conditional* do Spring tema a resposta para essa questão. Vamos analisar isso em detalhes na próxima seção. 

### 4.1.1 Understanding @Conditional annotation
O framework Spring fornece uma anotação *@Conditional* que pode ser colocada em *@Bean*, *@Component* e *@Configuration* para influenciar a criação dos componentes gerenciados pelo Spring. A anotação *@Conditional* aceita um parâmetro da classe **Condition**. A interface **Condition** possui um método chamado **matches(..)** que retorna um valor booleano. Um valor **true** indica que deve-se continuar avaliando ou criando um *@Bean, @Component* ou *@Configuration*. Um valor **false** significa que não deve prosseguir com a criação do *@Bean*, *@Component* ou *@Configuration*. 

Em nossas implementações personalizadas de **Condition**, implementamos a interface **Condition** e definimos o método **matches(..)**.

Agora, vamos examinar como usar a anotação **@Conditional** no **bean** *RelationalDataSourceConfiguration*. A seguinte listagem mostra a classe de configuração *CommonApplicationContextConfiguration* modificada que utiliza a anotação *@Conditional*. 

```java
@Configuration
public class CommonApplicationContextConfiguration {

	@Bean
	@Conditional(RelationDatabaseCondition.class)
	public RelationalDataSourceConfiguration dataSourceConfiguration() {
		return new RelationalDataSourceConfiguration();
	}

}
```

A anotação *@Conditional* garante que o **bean** seja criado apenas se a **RelationalDatabaseCondition** avaliá-lo como **true**.

Essa configuração é similar à que vimos na listagem 4.2, com a exceção de que a criação do bean *DataSourceConfiguration* agora depende da condição **RelationalDatabaseCondition**. A seguinte listagem define essa condição:
```java
public class RelationDatabaseCondition implements Condition {

	@Override
	public boolean matches(ConditionText conditionConteext, AnnotatedTypeMetada annotatedTypeMetada) {
		return isMySQlDatabase();
	}

	private boolean isMySQLDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return true;
		}
		cath(ClassNotFoundException e) {
			return false;
		}
	}
}
```

No Spring, às vezes só queremos criar um *@Bean*, *@Component*, ou *@Configuration* se uma condição for verdadeira.
O Spring criou a anotação *@Conditional* exatamente para isso.
- Colocamos o @Conditional em cima do que queremos criar;
- Passamos uma classe de condição (uma classe Java que implemente a interface **Condition**);
- Essa classe de condição define: *"devo criar ou não esse bean?*



### Como funciona a classe de condição?
O que o Spring espera é que criemos uma classe que implemente a interface **Condition**.

Essa interface tem um método:
```java
boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
```
- Se retornarmos true, o Spring vai criar o Bean/Component/Configuração;
- Se retornarmos false, o Spring não vai criar.

**Exemplo do Livro**
1. Temos uma configuração:
```java
@Configuration
public class CommonApplicationContextConfiguration {
	@Bean
	@Conditional(RelationDataBaseCondition.class)
	public RelationalDataSourceConfiguration dataSourceConfiguuration() {
		return new RelationalDataSourceConfiguration();
	}
}
```
Aqui, o Spring só vai criar esse RelationalDataSourceConfiguration se a classe **RelationalDatabaseCondition** retornar "ok".

E a classe de condição é essa aqui:
```java
public class RelationDatabaseCondition implements Condition {

	public boolean matches(ConditionContext conditionContext, AnnotatetedTypeMetadata metadata) {
		return isMySQlDatabase();
	}

	private boolean isMySQlDatabase() {
		try { // tenta carregar o driver do MySQL
			Class.forName("com.mysql.jdbc.Driver");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
```
- Ela tenta carregar a classe *com.mysql.jdbc.Driver* usando *Class.forName(...)*;
- Se essa classe existe no projeto, no classpatch, ele entende que estamos usando MySQL, então retorna o método true;
- Se não existir, retorna *false*.

Outro exemplo simples:

**1. Crio a classe de condição:**
```java
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// Pegando o nome do sistema operacional
		String osName = System.getProperty("os.name");

		// Se o nome do sistema operacional contiver Windows, retornamos tru
		return osName != null && osName.contains("Windows");
	}
}
```

2. **Crio a configuração usando essa condição:**
```java
@Configuration
public class MyConfiguration {
	@Bean
	@Conditional(WindowsCondition.class)
	public String windowsOnlyBean() {
		return "Este bem só existe no Windows!"
	}
}
```

Aqui o Spring vai:
- Verificar se a condição *WindowsCondition* é verdadeira;
- Se for, ele cria o Bean *windowsOnlyBean*;
- Se não for, o Bean simplesmente não existe no contexto da aplicação.

---

## 4.1.1 Continuando
Portanto, no exemplo anterior, do MySQL, ele não olha o DataSource diretamente.
O que ele faz é:
- **Checar se a classe *com.mysql.jdbc.Driver* existe no classpath**
Ou seja:
- Se o projeto importou (via Maven, Gradle ou outro) o driver do MySQL;
- Então essa classe estará disponível no classpath;
- Se a classe está disponível, é um sinal que queremos utilizar o MySQl

- Fornecemos uma implementação da interface **Condition**. Essa interface possui um método **matches()** que retorna um valor booleano;
- Validamos se a classe do driver MySQL está presente no **classpath** da aplicação. Se a classe do driver estiver disponível, a condição retorna true para indicar que um banco de dados relacional está disponível.

Para simplificar, mantivemos a *RelationalDatabaseCondition* direta, com apenas uma validação.  Essa única validação deve ser suficiente para transmitir a ideia por trás da anotação *@Condition*. Normalmente, podemos implementar uma condição para criar beans de duas formas diferentes:
1. Avaliar o classpath para verificar a presença de bibliotecas específicas;
2. Validar se determinadas propriedades estão configuradas na aplicação. No método *matches(..)*, temos uma instância de *ConditionContext*, que fornece acesso às propriedades da aplicação configuradas. Assim, podemos acessar todas as propriedades configuradas no arquivo *application.properties*.

Embora a anotação *@Condition* funcione bem, ela é uma anotação de baixo nível. O Spring Boot fornece diversas anotações *@Condition* de alto nível que se destinam a tipos específicos de condições. A tabela 4.1 resuma algumas das anotações *@Conditional* mais populares, as anotações mais utilizadas com frequência, estão destacadas em negrito.

## 4.1.2 Deep dive into autoconfiguration
Cada projeto Spring Boot possui uma dependência no módulo *spring-boot-autoconfiguration*. Ele contém a chave para a magia de autoconfiguração do Spring Boot. Ele contém a chave para a magia de autoconfiguração do Spring Boot. Este JAR contém um arquivo chamado *spring.factories* dentro da pasta **META-INF**. A listagem a seguir mostra algumas das classes de autoconfiguração.

Se explorarmos o arquivo *spring.factories* dentro do JAR, encontraremos uma seção chamada Auto Configure, que contém detalhes de autoconfiguração para vários componentes do Spring Boot e bibliotecas de terceiros com as quais o Spring Boot se integra. Essas classes de autoconfiguração são arquivos de configuração do Spring que utilizam as anotações *@Conditional*. 

Na próxima seção, estudaremos a *DataSourceAutoConfiguration*, que configura uma fonte de dados (data source) em uma aplicação Spring Boot.

```java
@Configuration
@ConditionalOnClass({ DataSource.class, EmbeddedDatabaseType.class})
@EnabledConfigurationProperties(DataSourceProperties.class)
```
Essa configuração é carregada se as classes *DataSource* e *EmbeddedDatabaseType* estiverem presentes no classpath.

```java
@Import({DataSourcePoolMetadataProvidersConfiguration.class, DataSourceInitializationConfiguration.class})
```
O DataSourceAutoConfiguration também importa as classes de configuração *DataSourcePoolMetaadataProvidersConfiguration.class* e *DataSourceInitializationConfiguration.class*.

```java
public class DataSourceAutoConfiguration {
	@Configuration

	@Conditional(EmbeddedDatabaseCondition.class)
	@ConditionalOnMissingBean({DataSource.class, XADataSource.class})
	@Impooprt(EmbeddedDataSourceConfiguration.class)
	protected static class EmbeddedDatabaseConfiguration {}
}
```

```java
@Configuration
@Conditional(PooledDataSourceCondition.class)
@ConditionalOnMissingBean({ DataSource.class, XADataSource.class})
@Import({DataSourceConfiguration.Hikari.class, DataSourceConfiguration.Tomcat.class, DataSourceConfiguration.Dbcp2.class, DataSourceConfiguration.Generic.class, DataSourceJmxConfiguration.class})
protected static class PooledDataSourceConfiguration {

}
```
Existem várias configurações anotadas na classe *DataSourceAutoconfiguration*:
- A classe *DataSourceAutoConfiguration* está configurada com a anotação *@Configuration*. Isso indica que se trata de uma classe de configuração padrão do Spring. 

- Ela utiliza a anotação *@ConditionalOnClass* para indicar que a configuração de *DataSourceAutoConfiguration* só deve ser avaliada se as classes *DataSource.class* e *EmbeddedDatabaseType.class* estiverem presentes no classpath.

- A anotação *EnableConfigurationProperties(DataSourceProperties.class)* garante que as propriedades específicas da fonte de dados (datasource) fornecidas no arquivo *application.properties* sejam automaticamente convertidas em uma instância de classe *DataSourceProperties*. Por exemplo, as propriedades *spring.datasource.* configuradas no arquivo *application.properties* são automaticamente mapeadas para *DataSourceProperties*. Na seção 2.2 do capítulo 2, discutimos detalhadamente o uso da anotação. 

- A anotação *@Import* inclui duas configurações adicionais na classe atual: *DataSourcePoolMetadataProvidersConfiguration* e *DataSourceInitializationConfiguration*, dentro da *DataSourceAutoConfiguration*.

- Na classe *DataSourceAutoConfiguration*, existem duas configurações internas: *EmbeddedDatabaseConfiguration* e *PooledDataSourceConfiguration*. A primeira cria uma configuração de banco de dados embutido (embedded) se a condição *EmbeddedDatabaseConditiion* for verdadeira e ainda não tenhamos configurado explicitamente um bean de *DataSource* ou *XDataSource*. A *PooledDataSourceConfiguration* cria um pool de conexões de banco de dados se a condição *PooledDataSourceCondition* for verdadeira e nenhum bean de *DataSource* ou *XADataSource* já esteja configurado.

## 4.2 Using Spring Boot DevTools
O Spring Boot fornece um **kit de desenvolvedor** que oferece um conjunto adicional de recursos voltados para o tempo de desenvolvimento. Essas ferramentas podem ser usadas para proporcionar uma experiência mais agradável no desenvolvimento de aplicações Spring Boot e aumentar a produtividade dos desenvolvedores. Em resumo, esse kit é popularmente conhecido como **Spring Boot DevTools**.

Podemos habilitar o suporte ao DevTools em nossa aplicação adicionando a seguinte dependência no arquivo *pom.xml*:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
Observamos que o **DevTools** é adicionado como uma dependência opcional. Isso evita que a dependência do DevTools seja aplicada transitivamente a outros módulos que dependem do nosso projeto.

### 4.2.1 Property defaults
O Spring Boot e algumas de suas bibliotecas de apoio suportam o uso de **cache** para melhorar o desempenho. Por exemplo, o mecanismo de templates **Thymeleaf** pode armazenar em cache os templates HTML para evitar que sejam analisados novamente (*reparsing*). Embora o uso de cache funcione bem em aplicações de produção, ele pode ser contraproducente durante o desenvolvimento, já que precisamos visualizar as alterações mais recentes. 

O DevTools desativa todas as opções de cache por padrão. 

### 4.2.2 Automatic restart
In a typical development setup you make changes yo your application, and to view those changes, you restart the application, Spring Boot DevTools makes developer life a little easier by automatically restarting the application whenever there is an application classpath change. This provides a quick feedback loop for the code changes, as you can almost immediately validate your latest changes.

O Spring Boot usa dois carregadores de classes (classes loaders) separados para implementar a funcionalidade de reinicialização automática. O primeiro, conhecido como carregador de classes base (base class loader), carrega as classes que têm menor probabilidade de mudar. Por exemplo, as bibliotecas de terceiros das quais nossa aplicação depende normalmente não mudam. O outro carregador de classes, conhecido como carregador de classes de inicialização (restart class loader), carrega as classes que estamos desenvolvendo. Esse carregador de classes de reinicialização é descartado sempre que há uma alteração em alguma classe, sendo então criado um novo. 

### 4.2.3 Live reload
O Spring Boot DevTools fornece um servidor LiveReload embutido que pode ser usado para acionar a atualização do navegador quando um recurso é alterado. Para utilizar essa funcionalidade, o navegador precisa ter a extensão LiveReload instalada. 

## 4.3 Creating a custom failure analyzer
No capítulo 1, aprendemos o conceito de um *FailureAnalyzer* no Spring Boot. Como o nome indica, ele detecta uma falha ou exceção na aplicação e fornece uma mensagem detalhada que é útil para o desenvolvedor entender melhor o problema. Por exemplo, é comum tentarmos iniciar múltiplas instâncias de uma aplicação Spring Boot que utilizam a mesma porta HTTP. Neste caso, o Spring Boot exibe uma mensagem de erro bem formatada informando que não é possível iniciar a segunda instância na mesma porta HTTP, pois ela já está em uso. O Spring Boot faz isso com a ajuda de uma infraestrutura de análise de falhas integrada. Além disso, ele também permite que estendamos o conceito de um analisador de falhas, possibilitando que aproveitemos os benefícios.

Há duas razões pelas quais um *FailureAnalyzer* seja útil:
- Ele permite que forneçamos uma mensagem de erro detalhada sobre o problema real e ajuda a identificar qual ação pode ser tomada para resolver a questão e determinar sua causa raiz;
- Ele oferece a oportunidade de realizar validações na inicialização da aplicação e reportar quaisquer erros o mais cedo possível. Por exemplo, vamos supor que nossa aplicação dependa de um serviço REST externo que fornece dados críticos para o funcionamento da aplicação. Pode ser útil validar a acessibilidade desse serviço durante a inicialização e garantir que a nossa aplicação possa operar conforme esperado. No entanto, se o serviço não estiver acessível, podemos optar por não iniciar a aplicação, já que sem esse serviço REST ela pode não funcionar como desejado.

### 4.3.1 Technique: Creating a custom Spring Boot FailureAnalyzer
In this technique, we'll demonstrate how to create a custom FailureAnalyzer

**Problem**: Nossa aplicação possui uma dependência em relação a um serviço REST externo. Precisamos garantir que esse serviço seja acessível no momento em que a aplicação é iniciada. Além disso, é necessário fornecer uma mensagem detalhada caso o serviço não esteja acessível.

**Solution**: O Spring Boot fornece uma infraestrutura de análise de falhas que permite definir lógica personalizada para realizar validações específicas da sua aplicação e também relatar erros dessas validações. Assim, podemos aproveitar essa infraestrutura para verificar a acessibilidade da API REST e reportar qualquer erro já no momento da inicialização da aplicação.

Para demonstrar como criar um analisador de falhas personalizado, vamos considerar o seguinte cenário: suponha que nossa aplicação busque detalhes sobre cães de uma API externa chamada DOG API e exiba informações na interface da aplicação. Desejamos validar se essa URL está acessível no momento em que a aplicação é iniciada. Para isso, realizaremos as seguintes atividades:
- Usaremos o evento *ContextRefreshedEvent* do Spring Boot para acionar a validação. O Spring Boot publica esse evento assim que o *ApplicationContext* é atualizado (após a inicialização completa do contexto).

- Se a API não estiver disponível, lançaremos uma exceção personalizada chamada *UrlNotAccesibleException*;

- Em seguida, definiremos um **FailureAnalyzer** personalizado chamado *UrlNotAccessibleFailureAnalyzer*, que será invocado quando a exceção *UrlNotAccessibleException* ocorrer.

- Por fim, registraremos o *UrlNotAcessibleFailureAnalyzer* por meio do arquivo *spring.factories*, para que o Spring Boot registre o seu analisador de falhas personalizado. O *spring.factories* é um arquivo especial localizado na pasta *src/main/resources/META-INF* da nossa aplicação e é automaticamente carregado pelo Spring no momento da inicialização. Esse arquivo contém referências a várias classes de configuração. 

```java
@Getter
public class UrlNotAccessibleException extends RuntimeException {
    private String url;
    public UrlNotAccessibleException(String url) {
        this(url, null);
    }
    public UrlNotAccessibleException(String url, Throwable cause) {
        super("URL " + url + " is not accessible", cause);
        this.url = url;
    }
}
```
Extensão de *RunTimeException*: a nossa classe é uma classe de exceção não verificada (uncheked). 

Na listagem acima, estamos definindo uma *RunTimeException* que será usada caso a URL não esteja acessível. Em seguida, vamos definir a classe *UrlAccessibilityHandler*:

```java
package com.manning.sbip.ch04.listener;
//imports
@Component
public class UrlAccessibilityHandler {
	@Value("${api.url:https://dog.ceo/}")
	    private String url;
	@EventListener(classes = ContextRefreshedEvent.class)
	    public void listen() {
	        // For demonstration purpose, we are throwing
	        // the exception assuming the site is not reachable
	        throw new UrlNotAccessibleException(url);
	    }
}
```
Na listagem acima, definimos a classe *UrlAccessibilityHandler* como um componente do Spring. Além disso, definimos um ouvinte de evento *event listener* que é invocado assim que o Spring Boot publica o evento *ContextRefreshedEvent*. Por simplicidade e fins de demonstração, estamos lançando a exceção *UrlNotAccessibleException*, assumindo que a URL não está acessível.

Linha do tempo:
1. Aplicação inicia -> *SpringApplication.run(...)*
2. Spring dispara o evento *ContextRefreshedEvent*
3. *UrlAccessibilityHandler.listen()* é chamado automaticamente (por causa do *@EventListener*).


## 4.4 Spring Boot Actuator
Além dos recursos principais para desenvolver aplicações, o Spring Boot também oferece um conjunto de funcionalidades para suporte operacional da nossa aplicação. Um aplicativo é considerado operacional quando está em produção e atendendo aos seus clientes ou usuários. Para gerenciar um serviço contínuo aos nossos clientes, precisamos monitorar e administrar a nossa aplicação. Esse monitoramento e gerenciamento incluem verificar a integridade da aplicação, desempenho, tráfego de entrada e saída, auditoria, diversas métricas do aplicativo, reiniciar a aplicação, alterar o nível de log e muito mais. Os diversos dados de monitoramento e métricas permitem analisar o comportamento da aplicação e agir conforme necessário.

O Spring Boot Actuator traz essas capacidades de monitoramento e gerenciamento para nossa aplicação Spring Boot. O principal benefício do Spring Boot Actuator é que podemos obter muitos recursos prontos para produção em nossa aplicação sem precisar implementá-los explicitamente.

## 4.4.1 Technique: Configuring Spring Boot Actuator in a Spring Boot application
In this technique, we'll demonstrate how to configure Spring Boot Actuator.

**Problem**
Utilizamos o Actuator quando já temos uma aplicação implantada e em execução em produção. Agora, precisamos monitorar o status de integridade da aplicação configurando o **Spring Boot Actuator** em nosso projeto Spring Boot.

**Solution**
Podemos ativar o suporte do Spring Boot Actuator em nossa aplicação Spring Boot adicionando a dependência *spring-boot-starter-actuator* no arquivo de configuração pom.xml.

A dependência inclui as bibliotecas **spring-boot-actuator-autoconfigure** e **micrometer-core** no projeto.
- A primeira dependência (**spring-boot-actuator-autoconfigure**) fornece o suporte principal do Actuator.
- A segunda (**micrometer-core**) adiciona a integração com o **Micrometer**, uma ferramenta para capturar métricas da aplicação.

No arquivo *application.properties*, incluímos a propriedade:

```json
management.endpoints.web.exposure.include=*
```

Essa configuração ativa **todos os endpoints do Actuator** via HTTP. 

Se não desejamos expor todos os endpoints, podemos listar apenas os necessários, separados por vírgulas. Por exemplo:
```json
management.endpoints.web.exposure.include=info,health
```
Neste caso, apenas os endpoints */info* e */health* estarão acessíveis. 

Ao iniciarmos a aplicação, podemos acessar a seguinte URL:
http://localhost:8080/actuator/health

Isso permite verificar o endpoint */health* do Actuator. A figura 4.2 (ou saída no console) mostrará o status de integridade da aplicação:
![[Capítulo 4 - Spring Boot Autoconfiguration and Actuator.png]]

O endpoint */health* retorna um status *UP*, indicando que:
1. A aplicação está saudável (tudo funcionando corretamente);
2. Todos os componentes necessários (bancos de dados, serviços externos, etc.) estão acessíveis.

Mais adiante, exploraremos:
- Outros status de saúde (como DOWN, OUT_OF_SERVICE).
- Como criar um **HealthIndicator personalizado** para monitorar componentes específicos da nossas aplicação.

Além disso, veremos:
- **Outros endpoints úteis** do Actuator (como *metrics, info, env*);
- **Customizações avançadas** para adaptar o monitoramento às nossas necessidades.

### 4.4.2 Understanding Spring Boot Actuator endpoints
Um **endpoint do Actuator** permite monitorar e gerenciar nossa aplicação. Na técnica anterior, vimos o endpoint health que possibilita verificar o status de integridade da aplicação. O Spring Boot oferece vários endpoints prontos para uso, além de permitir a criação de endpoints personalizados específicos para nossa aplicação.

Os endpoints do Actuator podem ser acessados via HTTP ou JMX (Java Management Extensions), e podemos configurá-los como **habilitados, desabilitados** ou **expostos**.

- **Habilitar/Desabilitar**: controla se um endpoint específico estará disponível na aplicação. Por exemplo, por padrão o endpoint */shutdown* (que encerra a aplicação) vem desabilitado por motivos de segurança, mas podemos habilitá-lo manualmente se necessário.
- **Exposição**: define se um endpoint estará disponível via HTTP, JMX ou ambos. Por padrão, apenas */health* e */info* são expostos via HTTP, enquanto todos os endpoints built-in são expostos via JMX por padrão (considerado mais seguro que HTTP).

O Spring Boot inclui uma **página de descoberta** que lista todos os endpoints Actuator disponíveis. Por padrão, ela está acessível em:
http://localhost:8080/actuator

