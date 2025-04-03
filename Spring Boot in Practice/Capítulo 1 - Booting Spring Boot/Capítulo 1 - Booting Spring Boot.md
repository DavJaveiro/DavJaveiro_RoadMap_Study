A Parte 1 deste livro consiste o Capítulo 1, que apresenta a gente ao **Spring Boot** e a algumas de suas características mais importantes. O capítulo 1 aborda uma visão geral do Spring Boot, seus diversos componentes e alguns de seus recursos fundamentais, como os **Spring Boot Starters**, a **autoconfiguração**, o *Actuator* e os **analisadores de falhas** #failure-analyzers. Também exploramos a estrutura do projeto e os diversos elementos de uma aplicação Spring Boot. Além disso, o Capítulo 1 discute a criação de um arquivo JAR executável a partir de uma aplicação Spring Boot e explora os componentes desse arquivo JAR.

*This chapter covers*
- Introducing Spring Boot
- Project structure and various elements of a generated project;
- Creating an executable JAR file and the generated JAR structure;
- An overview of Spring Boot starter, autoconfiguration, failure analyzer, and actuator;
- Introducing Spring Boot developer tools to increase developer productivity

O Spring Boot é o framework Java mais popular disponível no mercado! Ele revolucionou a forma como as aplicações Spring, ou mais especificamente, as aplicações Java, são desenvolvidas atualmente. O Spring Boot é uma extensão de código aberto do **Spring Framework**, projetada para simplificar o desenvolvimento de aplicações Spring. A popularidade do Spring Boot é atribuída principalmente à sua capacidade de criar, em pouco tempo, aplicações baseadas no Spring que são autosuficientes, prontas para produção e fáceis de executar, sem que precisemos nos preocupar excessivamente com os perigos da configuração. 

## 1.1 Introducing Spring Boot
Nesta seção, apresentaremos o framework **Spring Boot** e responderemos brevemente a algumas perguntas comuns sobre ele. Discutiremos por que precisamos do framework Spring Boot, faremos uma introdução ao mesmo, exploraremos os diversos recursos que ele oferece e abordaremos os diferentes componentes do framework.

### 1.1.1 Why Spring Boot?
À medida que embarcamos nesta bela jornada para nos familiarizarmos com o **Spring Boot**, a primeira pergunta que surge é: por que devemos aprendê-lo em primeiro lugar? Para responder a essa pergunta, vamos entender qual problema o **Spring Boot** promete resolver.

O **Spring Framework** começou sua trajetória com o objetivo de **simplificar o desenvolvimento de aplicações empresariais Java**. Ele se tornou imensamente popular devido às suas estratégias simplificadas de desenvolvimento e à natureza robusta do framework, que "levanta pesos pesados" para os desenvolvedores. No entanto, à medida que o uso do Spring como framework aumentou, também cresceu a necessidade de simplificar ainda mais o processo de desenvolvimento de aplicações Spring.

Embora o Spring ofereça um grande suporte aos desenvolvedores, permitindo que eles se concentrem apenas na resolução de seus problemas de negócio, antes do **Spring Boot** ainda havia uma quantidade significativa de trabalho que os desenvolvedores precisavam realizar para fazer as coisas funcionarem. Por exemplo, aqui estão alguns desafios que enfrentaremos ao começar a desenvolver uma aplicação Web baseada no Spring:
- Compreender conceitos relacionados ao Servlet e ao descritor de implantação *web.xml*;
- Familiarizar-se com as estruturas de diretórios WAR e EAR para empacotar os componentes da aplicação;
- Entender conceitos específicos do servidor de aplicação, como domínio, porta, threads e fontes de dados, durante a implantação da aplicação.
- Lidar com estratégias complexas de carregamento de classes, conceitos de monitoramento e gerenciamento de aplicações, além de instalações de logging.

Esses desafios adicionam complexidade ao desenvolvimento, aumentando o tempo e o esforço necessários para configurar e implantar uma aplicação Spring. É aqui que o **Spring Boot** entra em cena, prometendo eliminar grande parte dessa complexidade e permitir que os desenvolvedores foquem no que realmente importa: a lógica de negócios da aplicação.

Existem muitos termos técnicos por aí. E se, em vez disso, pudéssemos simplesmente escrever a lógica de negócios da sua aplicação, criar um arquivo executável e rodá-lo diretamente na linha de comando? Você não precisaria definir configurações XML complicadas, realizar a implantação em um servidor de aplicação ou lidar com outros *malabarismos* técnicos. Todas essas peças do quebra-cabeça seriam misteriosamente resolvidas por algum mago experiente - o que seria impressionante, certo? 

O **Spring Boot** foi introduzido como um subprojeto sob o **Spring Framework** para proporcionar aos desenvolvedores uma experiência de inicialização rápida e isentá-los da maioria dos problemas relacionados à configuração. À medida que avançamos em nossa jornada com Spring Boot, perceberemos como ele aborda de forma fluida várias questões de configuração e integração. Por exemplo, em seu projeto Spring Boot, não seremos forçados a definir um arquivo de descritor de implantação *web.xml*. Também não seremos obrigado a usar um servidor de aplicação para executar sua aplicação, a menos que decidamos rodá-la em um. Na maior parte do tempo, a configuração padrão do Spring Boot pode atender facilmente às suas necessidades.

### 1.1.2 What is Spring Boot?
O Spring Boot foi lançado em abril de 2014 para reduzir parte da sobrecarga no desenvolvimento de uma aplicação web Java. Ele permitiu que os desenvolvedores se concentrassem mais na lógica de negócios, em vez de códigos técnicos repetitivos e suas configurações associadas. O Spring Boot tem como objetivo criar aplicações baseadas no Spring, prontas para produção e autossuficientes, com poucas alterações de configuração por parte do desenvolvedor da aplicação. Ele adota uma abordagem opinativa *opinionated* do Spring Framework, permitindo que os desenvolvedores iniciem rapidamente com o que precisam. Ele fornece uma camada adicional entre o Spring Framework e o usuário para simplificar certos aspectos da configuração.

O **Spring Framework** adota uma abordagem #opinionated em vários aspectos, mas com um equilíbrio interessante. Isso significa que ele oferece convenções e diretrizes bem estabelecidas para configurar e desenvolver aplicações, o que ajuda a evitar decisões repetitivas e promove boas práticas. 

O Spring, por outro lado, não é totalmente rígido. Ele segue o princípio de *pouca opinião* (ou "low-opinionated") quando necessário, oferecendo flexibilidade para os desenvolvedores personalizarem suas configurações e sobreporem padrões conforme as necessidades específicas do projeto. Isso faz com que o Spring seja uma combinação de estrutura orientada por padrões e adaptabilidade.

A Figura 1.1 mostra como o Spring Boot se posiciona entre você, como desenvolvedor da aplicação, e o Spring Framework. Como uma camada intermediãria, o Spring Boot realiza muitas configurações que, caso contrário, precisaríamos fazer manualmente se interagisse diretamente com o Spring Framework.

![[Capítulo 1 - Booting Spring Boot.png]]

### 1.1.3 Spring Boot core features
O Spring Boot possui várias características notáveis que o destacam em meio a outros frameworks:
- **Inicialização rápida (Fast bootstrapping)** - um dos principais objetivos do Spring Boot é proporcionar uma experiência de inicialização rápida no desenvolvimento de aplicações Spring. Imagine que desejamos construir aplicação web usando o Spring de forma tradicional. Provavelmente, seguiremos os passos descritos:

1. Configurar um projeto Maven ou Gradle com as dependências do Spring MVC;
2. Configurar o #DispatcherServlet  Spring MVC;
3. Empacotar os componentes da aplicação em um arquivo WAR;
4. Implantar o arquivo WAR em um contêiner de servlet (por exemplo, Apache Tomcat);

Com o #Spring-Boot, podemos gerar uma aplicação especificando apenas as dependências necessárias para a nossa aplicação, e o Spring Boot cuida do restante.
- **Autoconfiguração** - o Spring Boot configura automaticamente os componentes mínimos de uma aplicação. Ele faz isso com base na presença de arquivos JAR no classpatch ou nas propriedades configuradas nos diversos arquivos de propriedades. Por exemplo, se o Spring Boot detectar a presença de um driver de banco de dados JAR (por exemplo, H2 in-memory database JAR) no classpath, ele configura automaticamente a fonte de dados correspondente para conectar o banco de dados.

- **Opiniático** - O Spring Boot é opiniático. Ele configura automaticamente vários componentes para iniciar uma aplicação Spring. O Spring Boot faz isso por meio de um conjunto de dependências iniciais (*start dependencies*). Uma dependência inicial foca em uma área específica do desenvolvimento de aplicações e fornece as dependências relacionadas. Por exemplo, se precisarmos desenvolver <span style="background:#d4b106">uma aplicação web</span>, podemos configurar a dependência *spring-boot-starter-web*, que garante que todas as dependências relacionadas ao desenvolvimento de aplicações web, como *spring-web* e *spring-webmvc*, estejam disponíveis no classpath da aplicação. 

- **Autossuficiente** *Standalone* - as aplicações Spring Boot incorporam um servidor web, permitindo que elas sejam executadas de forma independente e não necessariamente exijam um servidor web ou de aplicação externo. Isso possibilita que as aplicações Spring Boot sejam empacotadas como um arquivo JAR executável e executadas com o comando *java -jar*. Essa característica também facilita a containerização das aplicações Spring Boot e as torna candidatas ideais para o desenvolvimento de aplicações nativas em nuvem. 

- **Prontas para produção (Production-ready)** - o Spring Boot oferece várias funcionalidades úteis prontas para produção *out of the box*, que permitem monitorar e gerenciar a aplicação assim que ela é implementada em produção. Entre essas funcionalidades estão verificações de saúde *health checks*, despejos de threads e outras métricas.

### 1.1.4 Spring Boot components
O Spring Boot consiste em vários componentes, cada um focado em uma área específica do desenvolvimento de aplicações. Alguns desses componentes são fundamentais e os utilizamos frequentemente em praticamente todos os projetos Spring Boot. Por exemplo, o Spring-boot é o componente principal que estará presente na maioria dos projetos Spring Boot. A figura 1.2 mostra os componentes do Spring Boot, e a lista a seguir discute brevemente esses componentes:
- **Spring-boot**: este é o componente principal do Spring Boot, que fornece suporte para outros componentes. Por exemplo, ele contém a classe **SpringApplication**, que inclui vários métodos estáticos para criar uma aplicação Spring Boot autossuficiente *standalone*. Ele também oferece suporte para servidores web embutidos (por exemplo, Tomcat) e suporte para configurações de aplicação externalizadas.
- **Spring-boot-autoconfigure:** este componente fornece o suporte necessário para a configuração automática de uma aplicação Spring Boot. O autoconfiguration do Spring Boot deduz e configura os beans do Spring com base nas dependências presentes no classpath e nas propriedades configuradas. No entanto, a autoconfiguração se afasta das configurações padrão caso detecte beans configurados pelo usuário com configurações personalizadas.

![[Capítulo 1 - Booting Spring Boot-1.png]]


- **Spring Boot Starters -** os starters são um conjunto de descritores de dependências pré-empacotados fornecidos para facilitar o trabalho do desenvolvedor. Um **spring boot starter** auxilia na disponibilização de um conjunto de tecnologias do Spring e outras relacionadas, que, de outra forma, o desenvolvedor precisaria gerenciar manualmente.

- **Spring Boot CLI -** é uma ferramenta de linha de comando voltada para desenvolvedores que compila e executa códigos Groovy. Além disso, pode monitorar arquivos em busca de alterações, eliminando a necessidade de reiniciar a aplicação e cada modificação. Essa ferramenta isenta o desenvolvedor da necessidade de gerenciar dependências com **Maven** ou **Gradle** e permite a prototipagem de dependências e outras questões relacionadas à build. Consulte o Apêndice A para aprender a utilizar o **Spring Boot CLI**.

- **Spring Boot Actuator** - esse componente fornece endpoints do Actuator para interagir, monitorar e auditar uma aplicação Spring Boot. Um #Actuator no Spring Boot pode ser gerenciado via JMX ou endpoints HTTP. O Spring Boot já disponibiliza uma lista predefinida de endpoints do Actuator, cobrindo diversos aspectos da aplicação. Casso essa lista não atenda às suas necessidades, é possível criar endpoints personalizados específicos para sua aplicação. O **Spring Boot Actuator** também oferece configurações que permitem escolher quais **endpoints do Actuator** habilitar e disponibiliza diferentes formas de protegê-lo contra acessos não autorizados.

- **spring-boot-actuator-autoconfigure -** este componente fornece suporte para autoconfigurar os endpoints do actuator com base no classpath, o Spring Boot configura automaticamente o MetricsEndpoint.

- **spring-boot-devtools** - este componente contém um toolkit adicional para desenvolvedores, proporcionando uma experiência de desenvolvimento fluida para aplicações **Spring Boot**. O toolkit inclui recursos como detecção automática de alterações no código da aplicação e um servidor **LiveReload** para atualizar automaticamente qualquer mudança em arquivos HTML no navegador. As ferramentas de desenvolvimento são projetadas par aumentar a produtividade dos desenvolvedores.

## 1.2 Code examples
Discutiremos os exemplos de código e as tecnologias que utilizaremos para desenvolver os exemplos. Abordaremos o sistema de build, a linguagem de programação e o banco de dados que usaremos neste livro. Também introduziremos o *Lombok*, que nos ajuda a simplificar as definições de classes #POJO com anotações simples.

### 1.2.1 Maven vs. Gradle
O **Spring Boot** permite que criemos um projeto Spring Boot usando tanto o *Apache Maven* quanto o *Gradle* como ferramentas de build. Na ferramenta Spring INitializr, podemos escolher o sistema de build de nossa preferência e gerar o projeto. Neste livro, usaremos o **Apache Maven** como o sistema de build preferido, já que a maioria dos leitores está familiarizada com o **Apache Maven**. 

### 1.2.2 Java vs. Kotlin
Podemos usar tanto Java quanto Kotlin como linguagens de programação em nosso projeto **Spring Boot**. O **Spring Framework 5.0** incorporou suporte para **Kotlin**, e desde então há um esforço constante para fornecer um melhor suporte ao **Kotlin** no **Spring Framework**. Por exemplo, no **Spring Security 5.3**, a equipe do Spring introduziu uma versão em #Kotlin de nossa linguagem específica de domínio DSL para o Spring Security. 

### 1.2.3 Suporte a banco de dados
Vários eexemplos de código neste livro exisgem acesso a bancos de dados para demonstrar os conceitos. O **Spring Boot** estende suporte a uma variedade de bancos de dados SQL e NoSQL. Para facilitar o teste dos exemplos de código, usaremos um banco de dados SQL em memória H2 em todos os nossos exemplos de código.

### 1.2.4 Lombok
O #Lombok é uma biblioteca Java que gera automaticamente construtores, métodos *getter*, *setter*, *toString* e outros com base na presença de algumas anotações na classe de objeto Java simples (Plain Old Java Object - POJO). Tudo o que precisamos fazer é usar a anotação apropriada na classe POJO. Por exemplo, para gerar um método *getter* para todas as variáveis de membro na classe *POJO*, podemos especificar com a anotação @Getter na classe. Usaremos o #Lombok neste livro nos exemplos de código.

Se não estiver interessado em usar o #Lombok, pode simplesmente fornecer os métodos #getter, #setter e os construtores, conforme aplicável ao código. Os exemplos de código devem funcionar conforme o esperado.

---
# #Record
O Java 14 introduziu o conceitos de *records* na linguagem Java. Os *records* são classes de dados imutáveis que exigem que especifiquemos apenas o tipo e o nome dos campos. O compilador Java pode então gerar os métodos *equals*, *hashCode*, *toString*. Ele também gera campos privados finais, métodos getter e um construtor público. Se não desejamos utilizar recursos de frameworks de terceiros, podemos considerar o uso dos *records* do Java.

Um *record* pode ser definido da seguinte forma:
```java
public record Course(int id, String name, String description, int rating) {}
```
O compilador gera o construtor público com todos os campos definidos e fornece métodos *getter* com os mesmos nomes dos campos, além dos métodos *equals* e *hashCode*. 

---
## 1.3 Introdução ao Spring Boot
Agora que temos uma visão geral do Spring Boot e conhecemos o propósito do framework, nesta seção, vamos gerar um projeto Spring Boot e explorar as diversas partes do projeto gerado.

### 1.3.2 Estrutura do projeto Spring Boot
A estrutura de um projeto Spring Boot gerado é relativamente simples e consiste apenas dois componentes necessários para prosseguir com o desenvolvimento de aplicativos Spring Boot. Ele contém os seguintes componentes:
- Um arquivo *pom.xml* que contém as dependências selecionadas durante a geração do projeto;
- Um arquivo de wrapper do Maven (Maven wrapper) que permite construir o projeto sem instalar o Maven na nossa máquina local.
- Uma estrutura de pacotes que contém os arquivos Java de origem e testes. O pacote de origem contém uma classe Java com o método *main*, e o pacote de testes possui uma classe de teste vazia.
- Uma pasta *resources* para manter artefatos adicionais do projeto e um arquivo *application-properties* vazio.

---
**Dependência do Starter do Spring Boot**
Uma dependência **Spring Boot Starter** tem como objetivo tornar o desenvolvimento de aplicações **Spring Boot** fácil, rápido e eficiente. Se temos experiência anterior no desenvolvimento de aplicativos Java com uma ferramenta de build, como **Apache Maven** ou **Gradle**, pode se lembrar que gerenciar dependências é um dos principais desafios para um desenvolvedor de aplicativo .

O primeiro desafio é identificar as bibliotecas (dependências) necessárias para desenvolver um componente específico de sua aplicação. Depois de identificá-las, é preciso encontrar as versões corretas destas bibliotecas. Mesmo que encontremos as bibliotecas e versões adequadas, no mundo dinâmico do desenvolvimento de software, é relativamente fácil ficar desatualizado em relação às versões. Para piorar os problemas, as dependências que escolhemos têm suas próprias dependências, ou mais precisamente, **dependências transitivas**. Em alguns casos, precisamos até controlá-las. A dependência **Spring Boot Starter** é uma solução no **Spring Boot** para aliviar todos os problemas mencionados acima.

Uma dependência **starter** agrupa um conjunto de dependências que precisamos para desenvolver uma parte de nossa aplicação. Se optarmos por desenvolver um aplicativo web com o **Spring Boot**, provavelmente escolheremos **spring-boot-starter-web**. Ela garante que todas as dependências necessárias para desenvolver um aplicativo web estejam disponíveis em nossa aplicação. Claro, isso é opinativo, e receberemos o conjunto de dependências que a equipe do **Spring** recomenda. A parte chave é que **ficamos livres dos problemas de controle de versão de dependências, atualizações e muitos outros problemas.**

Uma dependências **starter** pode depender de outra dependência **starter**. 

---
No projeto gerado, incluímos duas dependências **starter:** spring-boot-starter-web e spring-boot-starter-test. A dependência **web starter** inclui os JARs necessários para construir um aplicativo web, enquanto a dependência de teste permite que escrevamos casos de teste para nossa aplicação.

Na seção final do **pom.xml** apresentado na listagem 1.1, podemos encontrar o plugin **spring-boot-maven-plugin**. Esse plugin é fornecido para facilitar a vida do desenvolvedor, simplificando várias atividades de gerenciamento de aplicação. 

**Spring Boot Main Class**
Em geral, para executar um aplicativo web, construímos e empacotamos os componentes da aplicação em um arquivo de arquivo WAR ou EAR e o implanta em um servidor web (por exemplo, Apache Tomcat) ou servidor de aplicativos (Red Hat JBoss). O Spring Boot simplifica esse processo até certo ponto. Ele não obriga a criarmos um WAR ou EAR da nossa aplicação. Em vez disso, ele permite que executemos a aplicação Spring Boot como uma aplicação Java convencional, usando um método **main()** padrão.

Embora o **Spring Boot** siga uma abordagem familiar para manter as coisas simples para os desenvolvedores, ele realiza uma quantidade considerável de trabalho pesado nos bastidores. Por exemplo, um aplicativo web baseado em Servlet só pode ser executado em um contêiner de Servlet, como **Apache Tomcat** ou **Jetty**. Assim, quando iniciamos sua aplicação **Spring Boot** usando o método **main()**, o **Spring Boot** inicia uma instância embutida do servidor **Apache Tomcat** e executa o aplicativo web dentro dele.

Se explorarmos mais a dependência **spring-boot-starter-web**, podemos encontrar que ela possui uma dependência transitiva no módulo **spring-boot-starter-tomcat**. Podemos executar o comando mvn dependency:tree a partir do caminho onde o arquivo pom.xml está localizado para explorar a árvore de dependências da aplicação.

1. @EnableAutoConfiguration :
Esta anotação habilita a configuração automática do Spring Boot, que tenta configurar
automaticamente sua aplicacao com base nas dependências presentes no classpath. Por
exemplo, se o spring-boot-starter-web estiver no classpath, o Spring Boot assume que você
está desenvolvendo um aplicativo web e configura automaticamente componentes como o
servidor Tomcat embutido e as configurações relacionadas ao MVC (Model-View-Controller).

2. @ComponentScan :
Esta anotacao instrui o Spring a escanear o pacote atual (e seus subpacotes) em busca de
classes anotadas com estereótipos como @Controller, @Service, @Repository, ou
@Component . Essas classes sao automaticamente registradas como beans no contexto do
Spring .

3. @SpringBootConfiguration :
Essa anotaçao é uma variante especializada da anotacao @Configuration do Spring . Ela indica
que a classe é uma fonte de definições de beans e configurações específicas para a aplicação
Spring Boot .

Além disso, observe que a classe principal da aplicação Spring Boot precisa estar no pacote raiz da nossa aplicação, pois a anotação *@SpringBootApplication* é configurada nesse classe. A anotação *@SpringBootApplication* usa o pacote raiz como base package. Esse base package e todos os seus subpacotes são automaticamente escaneados pelo Spring Boot para carregar componentes Spring (por exemplo, classes configuradas com @Component, @Configuration e outras anotações do Spring), além de outros tipos. 

A classe *SpringApplication* tenta criar uma instância de **ApplicationContext** com base nas dependências JAR presentes no **classpath**. Uma aplicação web Spring Boot pode ser do tipo Servlet-based ou reativa. Aproveitando as técnicas de carregamento de classes do Spring e com base na disponibilidade das classes no classpath, o Spring deduz o tipo da aplicação atual. Assim que o tipo da aplicação é identificado, o Spring Boot aplica a seguinte estratégia para carregar o application context:

- Se a aplicação for identificada como uma aplicação web baseada em **Servlet**, o Spring Boot tenta criar uma instância da classe `AnnotationConfigServletWebServerApplicationContext`.
    
- Alternativamente, se a aplicação for do tipo **reativo**, o Spring Boot cria uma instância da classe `AnnotationConfigReactiveWebServerApplicationContext`.
    
- Se a aplicação não for nem baseada em **Servlet** nem **reativa**, o Spring Boot tenta criar uma instância da classe `AnnotationConfigApplicationContext`.

Você inicia uma aplicação Spring Boot usando o método estático `run()` da classe `SpringApplication`. Embora o uso desse método seja conveniente, o Spring Boot também permite criar uma instância da classe `SpringApplication` para personalizar o modo de **bootstrap** da aplicação. Por exemplo, se você já sabe o tipo da aplicação, pode defini-lo diretamente na instância de `SpringApplication`, conforme mostrado no exemplo a seguir.

**Configuration Management With the Application Properties File**
O Spring Initialzr gera um arquivo *application.properties* vazio na pasta. Esse arquivo de propriedades permite externalizar várias configurações da aplicação (por exemplo, detalhes do servidor ou do banco de dados). Embora existam várias maneiras de externalizar as propriedades de uma aplicação Spring Boot, essa é a abordagem mais utilizada.

O arquivo permite especificar configurações no formato chave-valor, onde uma chave é separada do valor correspondente pelo caractere =. 

Para ver o arquivo *application.properties* em prática, podemos modificar o valor de *server.port* na aplicação para uma porta HTTP diferente. 

### 1.3.3 Creating an executable JAR file
A maneira mais fácil de criar um arquivo JAR executável a partir do nosso projeto Spring Boot é usando o comando *mvn package*. Com base nessa seleção, um arquivo **JAR** é criado no diretório target do projeto. O arquivo JAR gerado pode ser executado a partir da linha de comando usando *java -jar*, iniciando a aplicação. 

Por padrão, o **goal** package do Maven não gera um JAR ou WAR executável automaticamente. Quem realiza essa tarefa é o goal repackage do spring-boot-maven-plugin, que se vincula à fase de *package* e prepara o arquivo executável.

