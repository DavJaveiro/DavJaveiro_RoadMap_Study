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
Loggin is an essential aspect of an application. A log contains important events of application activity and provides useful information on application behavior. <span style="background:#b1ffff">Based on the logging configuration</span>, log statements <span style="background:#b1ffff">can be logged in various mediums</span>, such as in the **console**, **files**, and **database**. However, console and file-based logging are the dominant types and are most frequently used in an application.

In this section, we'll first understand and explore the default Spring Boot logging mechanism. We'll then explore how to customize the logging in we Spring Boot application with other logging frameworks.

### 2.4.1 Technique: understanding and customizing default Spring Boot logging in a Spring Boot application
In this technique, we'll discuss Spring Boot default logging mechanisms and configurations for customizing logging in a Spring Boot application.

**Problem**
You want to understand and customize the default logging in a Spring Boot application.

**Solution**
By default, Spring Boot provides a console logging facility for all Spring Boot applications. This console log prints the log statements in the command prompt or terminal at application startup or when you perform any other activity in the application for which logging is enabled.

Spring Boot uses the Apache commons logging framework for its internal logging purposes. It also supports other popular logging framework, such as Logback, Log4j2, and java.util.logging.

If we are using any of the Spring Boot starter dependencies, **then by default Spring Boot uses de Logback logging framework**. This is because Spring Boot starter dependencies have a transitive dependency with *spring-boot-starter-logging* starter dependency, which includes the Logback dependencies. The following listing shows the Logback dependencies internally used by Spring Boot:

Once the project setup is done, you can start the application using the IDE's launch option or by using the mvn spring-boot:run Maven command. You can see the startup log in the console, as shown:
![[Capítulo 2 - Common Spring Boot tasks.png]]

- *Date and Time*: Date and time of logging;
- *Log level:* Logging level. Possible values include **FATAL, ERROR, WARN, INFO, DEBUG, and TRACE**. A logging level demonstrates the importance of the log statement. For instance, any log statement logged with FATAL or ERROR indicate some serious issues in the application processing, wheres INFO or DEBU, for example, indicate typical regular application activities, which you can likely ignore.
- *Process ID* - Process ID of the application;
- *Separator* - A separator --- to indicate the start of the actual log messages;
- *Thread name* - Name of a thread performing the logging. A Spring Boot application contains multiple threads. Some of the threads could be application threads, and you might be starting a few threads for various reasons. Por exemplo, se estivermos executando capacidades de processamento assíncrono do Spring Boot, podemos criar um TaskExecutor e atribuir um nome às threads do pool de threads subjacente. Assim, nesses casos, veremos o nome personalizado da thread conforme configurado.
- *Logger name* - Abbreviated source class name;
- *Message* - The actual log message.
![[Capítulo 2 - Common Spring Boot tasks-1.png]]

The %clr is a conversion word that is used to configure the color-coding. Spring Boot uses the *org.springframework.boot.logging.logback.ColorConverter* class for this purpose.

For example: %clr(${PID:- }) {magenta} prints the process ID in **magenta** color. This default logging pattern is specified in the Spring Boot Logback logging configuration file.

You can customize the default logging pattern with a different logging format. For example, the following listing shows a custom loggin pattern by configuration the *logging.pattern.console* property in the application.properties.file.

Custom loggin pattern in the application.properties file:
```properties
logging.pattern.console=%clr(%d{dd-MM-yyyy HH:mm:ss.SSS}){yellow} 
%clr(${PID:- }){green} %magenta([%thread]) %highlight([%-5level]) 
%clr(%-40.40logger{39}){cyan} %msg%n  
```
Configuring a custom logging pattern in Spring Boot application

If we restart the application, we'll notice a different logging format printed in the console.

**Appender e Logger no sistema de logs**
Se estamos começando agora com logs, é bom entendermos alguns termos básicos:
- #Logger: um logger é um componente do sistema de logs que tem a função de registrar as mensagens de log. Ele faz usando um ou mais **appenders**. Podemos criar vários loggers com diferentes níveis de log (como erro, aviso, informação) dependendo da nossa necessidade.
- #Appender: o appender é quem define duas coisas principais:
	1. Para onde as mensagens de log serão enviadas;
	2. Qual formato elas terão;

Existem vários tipos de **appenders**, dependendo do destino das mensagens:
- *ConsoleAppender:* mostra os logs no console da aplicação;
- *FileAppender:* grava os logs em um arquivo;
- *RollingFileAppender:* além de gravar, ele também cuida da rotação do arquivo (por exemplo, cria um novo a cada dia ou quando o arquivo fica grande);
- *SMTPAppender:* envia as mensagens de log por e-mail para um endereço definido.

Por padrão, o Spring Boot registra logs nos níveis **INFO**, **WARN e ERROR**. Se precisarmos de outros níveis de log, como *TRACE* ou *DEBUG*, podemos configurá-los nas propriedades correspondentes no arquivo *.properties*. Por exemplo, para habilitar declarações de depuração, podemos configurar *debug-true* no arquivo. Da mesma forma é possível ativar o modo de rastreamento configurando *trace=true* no mesmo arquivo.

Embora o log no console funciona bem durante o desenvolvimento, em uma aplicação de produção, é necessário registrar os logs em um arquivo, para que possam ser consultados no futuro. Além disso, apenas salvar os logs em um arquivo não é suficiente. Também é importante gerenciar os arquivos de log com base no tamanho e na duração (ou seja, determinar qual deve ser o tamanho máximo de um arquivo de log e por quanto tempo as informações devem continuar sendo gravadas no arquivo existente).

Existem políticas baseadas em tamanho e em tempo para alternar o arquivo de log para um novo arquivo. Por exemplo, podemos optar por alternar para um novo arquivo de log assim que o arquivo atual atingir um tamanho específico (por exemplo, 10MB). Também é possível alternar para um novo arquivo de log diariamente, independentemente do tamanho do arquivo. 

A maneira mais simples de configurar o registro de logs em um arquivo é definindo as propriedades logging.file.name ou logging.file.path no arquivo *.properties*. A propriedade *logging.file.name* permite especificar o nome de um arquivo de log onde os registros devem ser feitos. Por exemplo:
*logging.file.name=application.log*;

Se quisermos configurar o arquivo de log em um diretório diferente do diretório raiz do projeto, é possível especificar a propriedade *logging.file.path* com o valor do caminho desejado. Por exemplo, configurar *logging.file.path=C:/sbip/logs* gerará um arquivo de log chamado *spring.log* no diretório informado. 

O Spring Boot oferece funcionalidades avançadas de registro, facilitando a gestão do *rollover* de arquivos de log com base no tamanho ou na idade do arquivo. A configuração das propriedades *logging.logback.rollingpolicy.max-file-size* e *logging.logback.rolling.policy.max-history* no arquivo *application.properties* permite controle total sobre esses componentes.

**Discussion**
Utilizando esta técnica, aprendemos sobre as configurações de *logging* padrão no Spring Boot. Vimos como configurar e gerenciar registros baseados em arquivos utilizando os parâmetros fornecidos pelo próprio Spring Boot. 

Embora o *logging* com Logback funcione perfeitamente em projetos Spring Boot, pode ser que precisemos configurar outros frameworks de *logging* amplamente utilizados em nossa aplicação Spring. Por exemplo, você pode ter mais familiaridade com outros frameworks, como o Log4j2 ([https://logging.apache.org/log4j/2.x/](https://logging.apache.org/log4j/2.x/)), ou talvez sua organização adote um framework específico como padrão.

Vamos demonstrar isso desabilitando a configuração do Logback e substituir por outro framework de *logging*. Na próxima técnica, aprenderemos a configurar o Log4j2 em nossa aplicação. 

### 2.4.2 Technique: Using Log4j2 to configure logging in a Spring Boot application
In this technique, we'll demonstrate how to use Log4j2 logging in a Spring Boot application.

**Problem**
We need to configure Log4j2 as the logging framework in me Spring Boot application.

**Solution**
Configuring Log4j2 in a Spring Boot application is straightforward. To start with, you need to exclude the default *spring-boot-starter-logging* dependency and provide the Log4j2 starter dependency in your build configuration file. You can then provide the Log4j2 logging configuration either in properties, XML, YAML, or JSON format for Spring Boot to load and configure the logging. Using this technique, we'll use XML to define the logging configuration.

We need to perform two additional changes to start with the Log4j2 logging configuration:
- Remove all the logging configurations you've added to the *application.properties* file. You can remove all properties that start whit the logging prefix;
- You also need exclude the *spring-boot-starter-logging* dependency from the *spring-boot-starter-web* dependency in the pom.xml file. 

As alterações no *pom.xml* acima garantem que as dependências relacionadas ao **Logback** sejam removidas e que as dependências do *Log4j2* estejam disponíveis no *classpath*.

Podemos fornecer configurações do Log4j2 como *appender*, *loggers* e configurações associadas, em um arquivo no formato XML ou YML. Essa configuração em XML precisa ser criada na pasta *src\main\resources* com o nome *log4j2.xml* ou *log4j2-spring.xml*. Esse arquivo de configuração encapsula toda a configuração de *logging* que será utilizada em nossa aplicação Spring Boot.

Embora o Spring Boot ofereça ambas as operações para definir configurações - seja com *log4j2.xml* ou *log4j2-spring.xml* - recomenda-se o uso deste último sempre que possível. Isso porque o Spring Boot consegue ter um controle melhor sobre a inicialização de *logging*. A listagem a seguir mostra um exemplo:

Podemos consultar a documentação embutida para entender os diversos parâmetros de configuração. O Log4j2 é um framework de logging poderoso e cheio de recursos. A configuração acima representa a configuração básica necessária para demonstrar a integração do Log4j2 com o Spring Boot.

Vamos adicionar a implementação do *CommandLineRunner* na classe principal do Spring Boot para incluir instruções de log no lugar de instruções *System.out*. A listagem a seguir mostra a classse principal do Spring Boot modificada.

O *CommandLineRunner* é útil para executarmos alguma **lógica de inicialização** (como carregar dados no banco, imprimir logs, testar conexões, etc.);

``` java
@SpringBootApplication  
public class CourseTrackerApplication {  
  
    private static Logger logger = LoggerFactory.getLogger(CourseTrackerApplication.class);  
  
    public static void main(String[] args) {  
        SpringApplication.run(CourseTrackerApplication.class, args);  
        logger.info("CourseTrackerApplication started successfully with Log4j2 configuration");  
    }}
```
- A primeira mudança foi a criação de uma instância de logger utilizando o método *LoggerFactory.getLogger*. Se observamos os imports, veremos que a classe *LoggerFactory* importada é da biblioteca *SLF4J*. O Simple Logging Facade do Java (SLF4J) fornece uma abstração para diversos frameworks de log, permitindo que conectemos o framework de nossa preferência, por exemplo, *Log4j2* no momento de build da aplicação. 
- A segunda mudança é que, ao invés de usar a instrução *System.out*, estamos usando a instância de logger recém-criada para registrar as mensagens.

Se você iniciar a aplicação, verá que o arquivo **application-log4j2.log** é gerado na pasta `logs` do diretório raiz do seu projeto. E poderá ver que a mensagem de log configurada foi impressa junto com outras mensagens de inicialização da aplicação.

**Discussion**
Nesta técnica, aprendemos a configurar um dos frameworks de logging mais populares e amplamente utilizados no ecossistema Java. O Log4j2 é um dos frmeworks de logging mais estáveis e oferece diversos recursos úteis. 

Podemos ver outros tipos de appenders, como o JDBC appender; filters e outros recursos que estão disponíveis.

#JDBCAppender é um tipo de *appender* que permite **armazenar logs diretamente em um banco de dados** ao invés de arquivos, consoles e outros destinos.

Ao invés de gravar as mensagens de log em arquivos .log, podemos configurar o Log4j2 para inserir cada entrada de log como uma linha em uma table ade banco de dados, como por exemplo:
```sql
INSERT INTO logs (data_hora, nivel, logger, mensagem) VALUES (...);
```


Exemplo básico de configuração:
```xml
<Appenders>
    <JDBC name="DatabaseAppender" tableName="application_logs">
        <ConnectionFactory class="com.exemplo.MyConnectionFactory"/>
        <Column name="date" isEventTimestamp="true"/>
        <Column name="level" pattern="%level"/>
        <Column name="logger" pattern="%logger"/>
        <Column name="message" pattern="%message"/>
    </JDBC>
</Appenders>
```

Aqui, o *ConnectionFactory* é uma classe que criamos para retornar uma conexão com JDBC com o banco.

## 2.5 Validate user data using Bean Validation
Frequentemente, é necessário validar os dados inseridos pelo usuário para garantir que atendem aos requisitos de negócio. Por exemplo, podemos querer verificar se determinados campos não estão vazios (noempty) ou validar o comprimento mínimo e máximo dos valores permitidos para esses campos. Além disso, pode ser necessário implementar validações personalizadas para os dados do usuário. Um exemplo comum é a criação de uma regra personalizada de validação de senha para garantir que a senha informada pelo usuário atenda a certos critérios de segurança. 

Para esse tipo de necessidade, o *Bean Validation* é o padrão de fato utilizado no ecossistema Java. Essa especificação Java permite que definamos validações de forma declarativa, utilizando anotações simples diretamente nas classes do nosso modelo. Além disso, o Bean Validation também oferece suporte para a criação de validadores personalizados, de maneira extensível.

A implementação de referência dessa especificação é o *Hibernate Validator*, que é amplamente utilizada em projetos Java.

O **Spring Boot** facilita a integração com o Bean Validation por meio de uma dependência específica chamada *spring-boot-starter-validation*. Esse *starter dependency* permite que utilizemos o Hibernate Validator em nossa aplicação de forma simples e automática, sem a necessidade de configurações adicionais complexas.

### 2.5.1 Technique: Using built-in Bean Validation annotations to validate business entity in a Spring Boot application
In this technique, we'll discuss how to use bean validation to validate the business entities.

**Problem**
You want to validate business entities using the Java Bean Validation framework in your Spring Boot application.

**Solution**
Lets us demonstrate the usage of bean validation in Spring Boot with a example.

In this Maven project, we've added the *spring-boot-starter-validation* dependency, as shown in the following listing.

**Spring Boot starter validation Maven dependency**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

To start with, let us add a new entity named *Course*. A *course* contain an **id**, **name**, **category**, **rating** and **description**, as shown in the following listing.

<**The course entity**>
```java
public class Course {
	private long id;
	private String name;
	private String category;

	@Min(value = 1, message = "A course should have a minimum of 1 rating")
	@Max(value = 5, message = "A course should have a maximum of 5 rating")
	private int rating;

	private String description;

	// Constructor, Getter, and Setters
}
```

Adicionalmente, incluímos duas validações para o campo de avaliação (rating). Uma avaliação pode ter o valor mínimo de 1 e um valor máximo de 5. Caso essas restrições não sejam atendidas, a mensagem definida na anotação será exibida como mensagem de erro. Vamos validar essas restrições definindo um *CommandLineRunner*, conforme mostrado na listagem a seguir.

No listing 2.31, criamos um curso e definimos o valor da avaliação *rating* do curso como 0. Além disso, obtemos uma instância do validator e fornecemos a instância do curso para validação de restrições (*constraint validation*). O *validator* realiza a validação e retorna o conjunto de violações de restrição (*constraint violations*) no objeto fornecido. Neste exemplo, a validação da restrição *@Min* é violada, e o *ConstraintViolation* associado é retornado. Em seguida, registramos esse erro de validação no console.

### ✅ Como você faria normalmente no Spring?
Podemos deixar o Spring cuidar automaticamente do validator, a criação manual do *Validator* é didática, utilizada geralmente para explicar como funciona o Bean Validation por baixo dos panos.

No dia a dia com Spring Boot, o próprio framework já gerencia e **injeta automaticamente** o *Validator* quando precisarmos. Seja via *@Valid* em métodos de *controller*, *serviços* ou até dentro de formulário em aplicações web.

```java
@Service
@Validated
public class CourseService {
	public void createCourse(@Valid Course course) {
		// aqui, o Spring automaticamente valida o objeto
		// se houver violações, um MethodArgumentNotValidException será lançada
	}
}
```