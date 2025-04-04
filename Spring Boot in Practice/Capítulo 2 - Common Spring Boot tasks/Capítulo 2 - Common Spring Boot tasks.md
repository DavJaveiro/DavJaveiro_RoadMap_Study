*This chapter covers*
- Gerenciando configurações em uma aplicação Spring Boot;
- Criando configurações personalizadas com @ConfigurationProperties;
- Explorando a interface *CommandLineRunner* para executar código de inicialização;
- Compreendendo o log padrão do Spring Boot e configurando o Log4j2;
- Validando dados de usuário em uma aplicação Spring Boot usando Bean Validation;

Até esse ponto, aprendemos um pouco sobre o que é o Spring Boot e seu propósito de melhorar a experiência de desenvolvimento de aplicações ao abstrair configurações de baixo nível.

Neste capítulo, nos aprofundaremos nesse entendimento explorando alguns conceitos fundamentais, como **gerenciamento de configuração da aplicação** e **criação de configurações personalizadas**. Além disso, usaremos o Spring Boot para executar tarefas comuns, que serão frequentemente utilizadas no desenvolvimento de aplicações Spring Boot.

## 2.1 Managing configurations
O gerenciamento de configurações é uma parte essencial de qualquer aplicação, e as aplicações **Spring Boot** não são exceção. Dependendo da forma como desenvolvemos e gerenciamos nossas aplicações, pode haver múltiplos ambientes (por exemplo, **dev**, **test**, staging e prod) dentro da nossa organização.

Por exemplo, podemos ter um ambiente para desenvolvimento, um para testes, um para homologação *staging* e outra para produção. Para todos esses ambientes, o código da aplicação geralmente permanece o mesmo, mas é necessário gerenciar diferentes configurações para cada um. Um exemplo comum é que as **configurações do banco de dados** ou as configurações de segurança variam entre os ambientes. Além disso, à medida que a aplicação cresce e novas funcionalidades são adicionadas, a gestão dessas configurações se torna mais complexa.

O Spring Boot oferece várias abordagens para externalizar configurações, sem a necessidade de alterar o código-fonte da aplicação. Entre essas abordagens estão:
- Arquivos de propriedades *.properties*;
- Arquivos YAML (*.yml*);
- Variáveis de ambiente;
- Argumento de linha de comando.

Nas próximas seções, exploraremos essas abordagens e aprenderemos a configurar corretamente uma aplicação Spring Boot. Em todas as subseções seguintes, os conceitos serão explicados em detalhes. Caso precise consultar o código, podemos baixar o projeto Spring Boot nos links do repositório Github fornecidos.

### 2.1.1 Using the SpringApplication class
Podemos usar a classe *SpringApplication* do Spring Boot para definir configurações na nossa aplicação. Essa classe fornece o método *setDefaultProperties()* que aceita uma instância de *java.util.Properties* ou *java.util.Map<String, Object>*, permitindo definir as configurações da aplicação. 

Podemos configurar todas as propriedades da aplicação dentro dessas estruturas. Essa abordagem é útil para **configurações estáticas**, ou seja, configurações que são definidas uma única vez e não precisam ser alteradas. Vamos explicar isso com um exemplo.

Em nosso arquivo *properties*, é possível importar arquivos adicionais de configuração (como arquivos *.properties* ou *.yml* que contenham outras configurações) usando a propriedade *spring.config.import* do Spring Boot.

Por exemplo, podemos adicionar a seguinte configuração no *application.properties:*
```properties
spring.config.import=classpath:additional-application.properties
```

Isso fará com que o Spring Boot carregue as configurações presentes no arquivo *additional-application.properties*.

**Atenção:** se esse arquivo não existir no classpath, o Spring Boot lançará uma exceção do tipo *ConfigDataLocationNotFoundException*. 

Com base na configuração da nossa aplicação, podemos optar por ignorar alguns arquivos de configuração e permitir que a aplicação continue o processo de inicialização normalmente. 

Para isso, pode configurar a propriedade:
spring.config.on-not-found=ignore

Isso garante que, se um arquivo de configuração especificado não for encontrado, o Spring Boot não lançara uma exceção *ConfigDataLocationNotFoundException* e seguirá com o bootstrap da aplicação.

### 2.1.2 Using @PropertySource
Em nossas classes de configuração do Spring, podemos especificar a anotação *@PropertySource* com a localização do arquivo de propriedades para carregar as configurações. O exemplo a seguir demonstra essa abordagem:
```java
@Configuration
@PropertySource("classpath:dbConfig.properties")
public class DbConfiguration {

	@Autowired
	private Enviroment env;
}
```

O trecho de código no Listing 2.2 define uma classe de configuração do Spring que contém a anotação *@PropertySource*, permitindo a leitura de propriedade do arquivo dbConfig.properties localizado no classpath da aplicação.
```properties
user=sa
password=p@sswOrd
```

Além disso, foi realizada a injeção da instância do **Spring Environment** usando *@Autowired*, permitindo o acesso às propriedades definidas no arquivo *dbConfig.properties*.

Agora, vamos acessar a classe DbConfiguration para recuperar as configurações definidas, conforme demonstrado no exemplo:

Ao iniciarmos a aplicação, seremos notificados através de um print na tela o usuário e a senha das propriedades no console da aplicação.

## 2.1.3 Config data file
O Spring Boot permite definir as propriedades de configuração da aplicação nos arquivos *application.properties*. Essa abordagem é a mais utilizada para configurar uma aplicação Spring Boot.

Por padrão, os projetos gerados pelo Spring Initializr já incluem um arquivo *application.properties* vazio.

As configurações definidas nesses arquivos são carregadas no **Spring Environment**, permitindo o acesso à instância do **Environment** dentro das classes da aplicação. Além disso, essas propriedades também podem ser utilizadas por meio da anotação *@Value*.

**Properties or YML file**
O Spring Boot permite que especifiquemos as configurações da aplicação tanto em arquivos properties quanto em arquivos YML. Em um arquivo properties, podemos definir as propriedades no formato de par chave-valor, como mostrado abaixo, onde a chave da propriedade é separada do valor pelo símbolo =:
```properties
server.port=8081
spring.datasource.username=sa
spring.datasource.password=password
```

As mesmas propriedades podem ser configuradas em um arquivo YML da seguinte forma:
```yml
server:
  port: 8081
spring:
  datasource:
    username: sa
    password: password
```
A escolha entre usar arquivos properties ou YML é uma preferência do desenvolvedor. O Spring Boot funciona de forma similar com ambos os tipos de arquivo (com algumas exceções). Algumas pessoas preferem usar YML devido à maior clareza e à capacidade de representar dados hierárquicos de forma mais natural. Além disso, é menos repetitivo e tem capacidades aprimoradas para suportar estruturas de dados como listas, maps e outras.

No entanto, se você optar por usar arquivos YML na sua aplicação, deve ter cuidado com a sintaxe. É relativamente fácil esquecer um espaço extra ou definir uma indentação incorreta no arquivo YML. Adicionalmente, é muito mais fácil encontrar propriedades específicas pelo nome completo quando se usa o formato .properties. Com YML, você sempre precisa encontrar a propriedade desejada manualmente.

Se precisarmos alterar o nome do arquivo de *application.properties* para outros nomes personalizados, podemos fazer isso facilmente. É possível customizar o nome do arquivo *application.properties* usando a propriedade *spring.config.name*.

Em nossa aplicação Spring Boot, vamos criar um arquivo sbip.yml na pasta resources e definir a configuração *server.port* com o valor 8081.

Podemos construir a aplicação usando o comando *mvn package* a partir do local onde está o nosso arquivo *pom.xml*. No pom.xml, especificamos o tipo de empacotamento como JAR. 

Após construir a aplicação com sucesso, execute o JAR executável usando o comando:
java -jar < nomeDoJar>

Seremos notificado que a aplicação iniciou na porta HTTP padrão 8080. Podemos parar a aplicação com o comando Ctrl-C e reiniciar com o comando abaixo:

Por padrão, o Spring Boot lê o arquivo *application.properties* ou *application.yml* dos seguintes locais:
1. A raiz do classpath;
2. O pacote */config* dentro do classpath
3. O diretório atual;
4. O subdiretório */config* dentro do diretório atual;
5. Diretórios filhos imediatos do subdiretório */config*.

Nota sobre as propriedades *spring.config.name* e *spring.config.location*
O Spring Boot carrega as propriedades *spring.config.name* e **spring.config.location** nas fases iniciais da inicialização da aplicação, antes mesmo dos arquivos **properties ou .yml**. Por isso, você **não pode** definir essas configurações dentro dos arquivos `application.properties` ou `application.yml`.
Para configurar essas propriedades, você pode usar:

- O método `SpringApplication.setDefaultProperties()`
    
- Variáveis de ambiente do sistema operacional (**OS environment variables**)
    
- Argumentos de linha de comando (**command-line arguments**), na hora de rodar a aplicação
    
Nos exemplos acima, utilizamos as opções de **argumentos de linha de comando**.

**Argumentos de Linha de Comando**
O **Spring Boot** permite que especifiquemos configurações diretamente como argumentos de linha de comando.

Isso significa que, ao criar um arquivo #JAR da aplicação, podemos passar essa propriedade como argumentos na hora de executar o JAR.

Por exemplo, nesta seção, as propriedades *spring.config.name* e *spring.config.location* foram especificadas diretamente na linha de comando ao executar a aplicação:
```cmd
java -jar minha-aplicação.jar --spring.config.name=meu-arquivo --spring.config.location=file:C:/config/
```

Este comando instrui o Spring Boot a:
- Procurar um arquivo de configuração chamado *meu-arquivo.properties* ou *meu-arquivo.yml*;
- Buscar esse arquivo no diretório C:/config/

Isso é útil quando queremos definir configurações sem alterar o código-fonte da aplicação.

O Spring Boot também permite que especifiquemos arquivos properties para um profile específico.

Os profiles do Spring permitem segregar partes da configuração da aplicação e torná-las disponíveis apenas em um determinado ambiente (por exemplo, um profile para o ambiente de **teste** ou um profile para o ambiente de produção).

Portanto, podemos definir arquivos de configuração adicionais dedicados a um profile, além do arquivo *application.properties* ou *.yml* padrão.

Os arquivos de propriedades específicos de um *profile* seguem o formato:
```
application-{profile}.properties
application-{profile}.yml
```

Por exemplo, se tivermos dois profiles -dev e test - podemos manter dois arquivos properties diferentes com os nomes:
- *application-dev.properties*;
- *application-test.properties*;

Portanto, dependendo do profile ativo, a porta da aplicação iniciará em Dev ou Test.
Podemos ativar um profile usando a propriedade do Spring Boot:
*spring.profile.active=dev*


### 2.1.4 OS environment variable

Podemos especificar as configurações como uma variável de ambiente e utilizar o nome dessa variável de ambiente no arquivo de configuração (config data file).

No arquivo *application.properties*, foi declarada a seguinte propriedade personalizada chamada **app.timeout**, conforme mostrado no trecho a seguir:
```properties
app.timeout=${TIMEOUT}
```

A variável de ambiente APP_TIMEOUT está configurada com o valor 30. No Windows, podemos definir uma variável de ambiente usando o comando *set < VAR>= < VALOR>* no prompt de comando...


## 2.2 Creating custom properties with *@ConfigurationProperties*
O Sring Boot oferece uma grande variedade de propriedades nativas para configurar diversos recursos da aplicação. O exemplo mais simples é a propriedade *server.port*, que utilizamos na seção anterior para definir a porta HTTP na qual a aplicação Spring Boot deve ser executada.  A propriedade *server.port* é uma propriedade embutida do Spring Boot. Podemos encontrar uma lista completa dessas propriedades na documentação oficial do Spring Boot.

Nesta seção, discutiremos as propriedades personalizadas, que são específicas da sua aplicação. Dependendo da complexidade e dos recursos da sua aplicação, pode ser necessário configurar propriedades personalizadas. Por exemplo, podemos **definir a URL de um serviço web REST externo** ou uma flag booleano para ativar ou desativar um recurso específico. 

A prática, de definir a URL de um serviço REST no arquivo *properties* de uma aplicação é amplamente utilizada para facilitar a configuração e manutenção da aplicação, permitindo que as URLS ou outras configurações externas sejam alteradas sem a necessidade de modificar o código-fonte.

A boa notícia é que podemos configurar qualquer quantidade de propriedades nos arquivos de configuração da nossa aplicação, e o Spring Boot garantirá que elas sejam carregadas e estejam disponíveis em tempo de execução. Na seção anterior, vimos como o Spring Boot vincula as propriedades configuradas à instância de *Environment* do Spring, e que usamos *autowire* na classe para acessá-las.

Embora essa abordagem funcione muito bem, ela apresenta algumas desvantagens:
1. Não há *type-safety* nas propriedades configuradas, o que pode levar a problemas em tempo de execução. Por exemplo, suponha que estejamos capturando uma URL ou um endereço de e-mail em nosso arquivo de propriedades. Não há uma forma de impor *type-safety* para essas propriedades, pois não há validação.
2. Você precisa acessar os valores das propriedades individualmente com a anotação *@Value* ou através da instância do *Spring Environment*.

O Spring Boot oferece uma abordagem alternativa que permite definir beans definitions fortemente tipadas, garantindo **type-safety** e validando a configuração da nossa aplicação.

### 2.2.1 Technique: Defining custom properties with @ConfigurationProperties in a Spring Boot application

Nesta técnica, introduziremos a definição de propriedades personalizadas com *@ConfigurationProperties* em uma aplicação Spring Boot.

**Problem**
Precisamos definir propriedades personalizadas em nossa aplicação Spring Boot que sejam fortemente tipadas *type-safe* e possam ser validadas.

**Solution**
Nesta técnica, discutiremos como definir propriedades personalizadas em nossa aplicação Spring Boot e acessar essas propriedades nas classes de nossa aplicação sem usar a anotação @Value ou uma instância de Environment. Para isso, precisamos adicionar a seguinte configuração adicional no arquivo pom.xml, conforme mostrado na listagem a seguir:
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-configuration-processor</artifactId>
<optional>true</optional>
</dependency>
```
Precisamos de um processador de configuração do Spring Boot para gerar metadados sobre classes que estão anotadas com a anotação *@ConfigurationProperties*. Esses metadados são então usados por IDEs para fornecer suporte a autocompletar e documentação para as propriedades no arquivo *application.properties* ou *application.yml*. Aprenderemos mais sobre a anotação *@ConfigurationProperties* em breve. Em seguida, vamos definir as seguintes propriedades personalizadas na nossa aplicação Spring Boot, conforme mostrado na listagem a seguir:
```properties
app.sbip.ct.name=CourseTracker
app.sbip.ct.ip=127.0.0.1
app.sbip.ct.port=9090
app.sbip.ct.security.enabled=true
app.sbip.ct.security.token=asddf998hhyqthgtYYtggghg9908jjh7ttr
app.sbip.ct.security.roles=USER,ADMIN
```
Observe que essas não são propriedades internas do Spring Boot, mas sim propriedades personalizadas específicas para a nossa aplicação. Você precisa especificar essas propriedades em nosso arquivo *application.properties*. Vamos definir uma classe Java que represente essas propriedades, conforme mostrado na listagem a seguir:

Vamos explicar as mudanças na classe *AppProperties* da listagem 2.13:
- Essa classe está anotada com *@ConstructorBinding* e *@ConfigurationProperties*. Forneceremos mais detalhes sobre essas duas anotações na seção de discussão. Além disso, definimos o prefixo para as propriedades como *app.sbip.ct*.
- Definimos algumas variáveis com o nome das propriedades (por exemplo, *name*, *ip* e *port*). Para as propriedades relacionadas à segurança, definimos a classe estática *Security* dentro da classe *AppProperties*. Isso ocorre porque as propriedades estão aninhadas dessa forma. Por exemplo, a propriedade chamada *app.sbip.ct.security.enabled* é representada pela propriedade *enabled* na classe *Security*.

- Você forneceu documentação Java para essas variáveis para que as IDEs possam exibir essa documentação no arquivo *application.properties*.

Até agora, **definimos nossas propriedades e a classe associada que mapeia essas propriedades**. Vamos agora definir outra classe que utiliza as propriedades configuradas, conforme mostrado na listagem a seguir.

```java
@Service  
public class AppService {  
  
    private final AppProperties appProperties;  
  
    @Autowired  
    public AppService(AppProperties appProperties) {  
        this.appProperties = appProperties;  
    }  
  
    public AppProperties getAppProperties() {  
        return this.appProperties;  
    }  
}
```

A classe definia na listagem 2.14 está  anotada com *@Service* do Spring para defini-la como um serviço e deve ser escaneada automaticamente pelo Spring Boot. A mudança mais notável é que injetamos *autowired* a instância de *appProperties* nesta classe. O Spring Boot garante que todas as propriedades configuradas no arquivo *application.properties* sejam lidas, validadas e vinculadas à instância de *AppProperties*. Essa instância é então injetada na classe de serviço. Vamos usar essa classe de serviço e acessar a instância de *AppProperties*, conforme mostrado na listagem a seguir. 

---
Estamos utilizando o padrão de design de desacoplamento. Ele é adotado a vários padrões e conceitos, incluindo:
- **Dependency Injection (DI):** reduz o acoplamento entre componentes ao permitir que as dependências sejam injetadas em vez de instanciadas diretamente.
- **Inversion of Control (IoC)** - um princípio que transfere o controle da criação e gerenciamento de dependências para um container, como no Spring Framework.
- **Interface Segregation Principle (ISP) -** Parte do SOLID, sugere que interfaces devem ser específicas para cada cliente, evitando dependências desnecessárias;
- **Event-Driven Architecture -** usa eventos para comunicação entre componentes, reduzindo o acoplamento direto.
- **Observer Pattern -** permite que objetos sejam notificados sobre mudanças de estado sem depender diretamente uns dos outros.
- **Hexagonal Architecture (Ports and Adapters)** - separa a lógica de negócio da infraestrutura, permitindo que diferentes tecnologias sejam usadas sem impactar o núcleo da aplicação.

---
Na listagem 2.15, usamos a anotação *@EnableConfigurationProperties(AppProperties.class)*. Essa anotação garante que as classes com *@ConfigurationProperties* sejam registradas no contêiner do Spring. Uma desvantagem dessa anotação é que precisamos especificar nossas classes anotadas com *@ConfigurationProperties* junto com a anotação.

Se tiver mais classes anotadas com *@ConfigurationProperties*, podemos usar a alternativa *@ConfigurationPropertiesScan* e especificar um pacote base para que o Spring Boot possa escanear e encontrar as classes anotadas com *@ConfigurationProperties*. Nesse caso, não é necessário especificar explicitamente as classes *@ConfigurationProperties*.

Observe que essa anotação não identifica classes que também estão anotadas ou meta-anotadas com a anotações *@Component*. Se iniciarmos a aplicação, podemos verificar que as propriedades configuradas são impressas no console da aplicação.

**Discussion**
O *@ConfigurationProperties* do Spring Boot fornece uma abordagem fortemente tipada e estruturada para configurar propriedades personalizadas da aplicação. Já percebemos como é fácil configurar, validar e usar um conjunto de propriedades em nossa aplicação Spring Boot. Juntamente com o *spring.config.import* e a anotação *@ConfigurationProperties*, podemos separar logicamente as propriedades da aplicação em vários arquivos bom base em suas categorias.

A anotação *@ConfigurationProperties* permite externalizar configurações de forma fortemente tipada e estruturada. Podemos adicionar essa anotação à definição de uma classe (como demonstrado nesta técnica) ou a um método anotado com *@Bean* em uma classe Spring *@Configuration*. A vinculação das propriedades à classe pode ser feita por meio de métodos *setters* para as variáveis de membro ou através de vinculação via construtor.

Neste exemplo, fornecemos um prefixo chamado *app.sbip.ct*. Esse prefixo é usado junto com as propriedades que definimos na classe. Assim, a propriedade *name* é usada como *app.sbip.ct.name*. 

Neste exemplo, usamos o *@ConstructorBinding*, especificando explicitamente essa anotação na classe POJO. Essa anotação indica que as propriedades de configuração devem ser vinculadas usando os argumentos do construtor, em vez de chamar *setter*. Essa anotação pode ser especificada no nível da classe ou em um construtor específico. Se houver apenas um construtor, podemos especificar a anotação no nível da classe. No entanto, se houver múltiplos construtores, podemos usar a anotação em um construtor específico.

Ou seja, quando o Spring Boot carregar as configurações do *application.properties* ou *application.yml*, ele usará o construtor da classe para injetar os valores, garantindo *imutabilidade* (já que os campos são *final* e não possuem setters). 

Caso precise usar vinculação via setter em vez de vinculação via construtor, você pode especificar métodos setters para as variáveis de membro. Se estiver buscando imutabilidade na sua classe de configuração de propriedades, deve usar *@ConstructorBinding* sem fornecer métodos setters. Assim, uma vez que as propriedades sejam vinculadas à instância POJO, não há como modificá-las. Opcionalmente, podemos usar a anotação *@DefaultValue* nos parâmetros se precisar definir um valor padrão para uma ou mais propriedades. A listagem a seguir demonstra isso.

**AppProperties class constructor with *@DefaultValue* annotation**
```java
public AppProperties(String name, String ip, @DefaultValue("8080") int port, Security security) {
	this.name = name;
	this.ip = ip;
	this.port = port;
	this.security = security;
}
```

## 2.3 Executing code on Spring Boot application startup
Às vezes, precisamos executar código personalizado durante a inicialização de uma aplicação Spring Boot. Por exemplo, pode ser necessário executar um script de inicialização do banco de dados antes que a aplicação termine sua inicialização <span style="background:#d4b106">ou consumir um serviço REST para carregar dados para sua aplicação</span>. 

O *CommandLineRunner* e o *ApplicationRunner* são duas interfaces do Spring Boot que fornecem um único método *run(..)* e são invocados logo antes de a aplicação Spring Boot concluir sua inicialização. Esses métodos são invocados apenas uma vez no momento da inicialização da aplicação Spring Boot.

Nesta seção, exploraremos o uso da interface *CommandLineRunner* em uma aplicação Spring Boot. A interface *ApplicationRunner* é bastante semelhante à interface *CommandLineRunner*.

### 2.3.1 Technique: Using CommandLineRunner to execute code at Spring Boot application startup
In this techinique, we'll introduce you to the *CommandLineRunner*.

**Problem**
You want to use *CommandLineRunner* to execute some application initialization code at the Spring Boot application startup.

**Solution**
You can configure *CommandLineRunner* in several ways. The following list shows the approaches to configure a *CommandLinerRunner* in a Spring Boot application:
- In the Spring Boot main class that implements the *CommandLineRunner* **interface**;
- By providing the *CommandLinerRuner* implementation as a bean definition using the *@Bean* annotation.
- By providing the *CommandLineRunner* as a Spring Component using the *@Component* annotation.

In this technique, you'll see the aforementioned  *CommandLineRunner* configuration approaches with examples. After creating or importing the Spring Boot project, implement the *CommandLineRunner* interface in your Spring Boot main class, as shown in the following listing.

To keep the example simple, you are logging a statement in the console. Once the Spring Boot application starts, it logs the statement in the console, as shown in figure 2.1.

You can also define a *CommandLineRunner* as a Spring *@Bean* definition, as shown in listing 2.18;

In listing 2.18, you defined a Spring bean that provides an implementation of the *CommandLineRunner* is a functional interface with a single method called *run(String... args)*. The run method accepts a String varargs. You can supply the command line arguments, you can use the IDE to pass the arguments. 

Para fornecer argumentos, você pode usar a IDE para passá-los. Além disso, você pode empacotar a aplicação usando o comando mvn package e executá-la utilizando o comando java -jar < appname> < args>.

Essa implementação com *@Bean* gera o mesmo resultado que a alternativa apresentada na *Listing 2.17*. A vantagem dessa abordagem é que não precisamos, obrigatoriamente, implementar a interface *CommandLineRunner*.

Até agora, a implementação de *CommandLineRunner* foi feita diretamente na classe principal do Spring Boot. No entanto, uma abordagem alternativa é criar essa implementação em uma classe separada e anotá-la com *@Component*. Isso mantém o código relacionado ao CommandLineRunner isolado em um arquivo Java específico, evitando que a classe principal do Spring Boot fique sobrecarregada com essa lógica. 

As anotações @Bean e @Component permitem que instruamos o Spring a criar instâncias das classes anotadas, mas o modo como cada uma é usada é um pouco diferente.

Geralmente usamos a anotação *@Bean* quando **não temos acesso ao código fonte de classe** que desejamos registrar como um bean. Nesse caso, declaramos um método dentro de uma classe de configuração (geralmente anotada com *@Configuration*) utiliza *@Bean* nesse método e retorna manualmente uma nova instância da classe desejada.

Já a anotação *@Component* é usada quando temos acesso ao arquivo Java da classe. Nesse cenário, basta anotar diretamente a classe com *@Component*, e o Spring detectará e gerenciará automaticamente essa classe como um bean durante o processo de escaneamento de componentes (*component scanning*).

A listagem a seguir mostra uma implementação simples de *CommandLineRunner* que registra uma mensagem no log do console:
```java
package com.manning.sbip.ch02.commandline;

// imports

@Order(1)
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    protected final Logger logger = LogFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLineRunner executed as a Spring Component");
    }
}

```
O component scan do spring Boot consegue detectar essa classe porque ela está anotada com *@Component*. Isso significa que o Spring criará *MyCommandLineRunner* durante a inicialização do aplicativo. 

Quando iniciarmos a aplicação, a mensagem definida no método *run()* será exibida no console, pois o *CommandLineRunner* é executado automaticamente assim que o contexto da aplicação é carregado. Essa é uma forma prática de executar código logo após a inicialização da aplicação. 

You can also configure multiple *CommandLineRunner* implementations and decide the execution order base on the *@Order* annotation. Notice that the *Order(1)* annotation is specified in listing 2.19. For instance, the following listing shows another *CommandLinerRunner* implementation that is ordered with order value two.

If you start the application, you can see that both the log statements are printed in the console based on their defined order, as shown in figure 2.2.

**Discussion**
The *CommandLineRunner* is a useful feature that is frequently used to perform several application initialization activities. In a *CommandLinerRunner* implementation, you also have acess to the command line arguments through the args parameter. Thus, you can control the *CommandLineRunner* implementation behavior externally through the supplied arguments.

In a *CommandLineRunner* implementations you can also autowire any dependency using Spring's dependy injection mechanism. 

## 2.4 Customizing logging in a Spring Boot application
