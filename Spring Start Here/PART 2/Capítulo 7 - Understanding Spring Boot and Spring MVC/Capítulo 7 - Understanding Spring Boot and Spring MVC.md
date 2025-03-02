*This chapter covers*
- Implementing your first web app;
- Using Spring Boot in developing Spring apps;
- Understanding the Spring MVC architecture.

Now that you know all the needed Spring basics, let's focus on web apps and how you use Spring to implement them. You can use all the Spring capabilities we've discussed to implement any kind of app. But often with Spring, the applications you implements are web apps. In chapters 1 through 6, we discussed the Spring context and aspects that are mandatory for understanding what comes next in the book (including what you'll).

O Spring torna o desenvolvimento de aplicativos web direto e acessível. Neste capítulo, vamos começar discutindo o que são os aplicativos web e como eles funcionam.

Para implementar aplicativos web, usaremos um projeto do ecossistema Spring chamado *Spring Boot*. Na seção 7.2, discutiremos o Spring Boot e por que ele é essencial nas implementações de aplicativos. Na seção 7.3, abordaremos a arquitetura padrão de um aplicativo web simples desenvolvido com Spring e implementaremos um aplicativo web utilizando o Spring Boot. Ao final deste capítulo, entenderemos como um aplicativo web funciona e seremos capazes de implementar um aplicativo web básico com o Spring.

O principal objetivo deste capítulo é compreender os fundamentos que sustem a implementação de aplicativos web. Nos capítulos 8 e 9, implementaremos as principais funcionalidades encontradas na maioria dos aplicativos web em produção. No entanto, tudo o que discutiremos nos próximos capítulos se baseia nos conceitos apresentados neste capítulo.

## What is a web app?
Nesta seção, vamos explorar o que é um aplicativo web. Tenho certeza de que você utiliza aplicativos web diariamente. Provavelmente, você deixou algumas abas abertas no navegador antes de começar a ler este capítulo. Talvez você nem esteja lendo este livro em papel e esteja utilizando o aplicativo web **Manning liveBook** para isso.

Qualquer aplicativo que você acessa por meio do seu navegador web é um aplicativo web. Anos atrás, usávamos aplicativos de desktop instalados em nossos computadores para quase tudo o que fazíamos (figura 7.1). Com o tempo, a maioria desses aplicativos passou a ser acessível por meio de um navegador web. Acessar um aplicativo no navegador torna seu uso mais conveniente. Você não precisa instalar nada e pode utilizá-lo a partir de qualquer dispositivo com acesso à internet, como um tablet ou smartphone.

Nesta seção, quero garantir que tenhamos uma visão clara do que vamos implementar. O que é um aplicativo web e o que precisamos para construir a executar tal aplicativo? Uma vez que você tiver uma compreensão clara do que é um aplicativo web, continuaremos implementando um usando o Spring.

### 7.1.1 A general overview of a web app
Nesta seção, faremos uma análise de alto nível do que é um aplicativo web do ponto de vista técnico. Essa visão geral nos permitirá discutir em mais detalhes as opções disponíveis para criar aplicativos web.

Primeiramente, um aplicativo web é composto por duas partes:
- **O lado do cliente** é o que o usuário interage diretamente. Um navegador web representa o lado cliente de um aplicativo web. O navegador envia solicitações para um servidor web, recebe respostas dele e fornece uma maneira para o usuário interagir com o aplicativo. Também nos referimos ao lado cliente de um aplicativo web como **frontend**.
- **O lado servidor** recebe as solicitações do cliente e retorna dados em resposta. O lado servidor implementa a lógica que processa e, às vezes, armazena os dados solicitados pelo cliente antes de enviar respostas. Também nos referimos ao lado servidor de um aplicativo web como **backend.**

Ao discutir aplicativos web, geralmente nos referimos a um cliente e um servidor, mas é importante ter em mente que o backend atende vários clientes simultaneamente. Diversas pessoas podem usar o mesmo aplicativo ao mesmo tempo, em diferentes plataformas. Os usuários podem acessar o aplicativo por meio de um navegador em um computador, telefone, tablet e assim por diante.


![[Capítulo 7 - Understanding Spring Boot and Spring MVC.png]]

### 7.1.2 Different fashions of implementing a web app with Spring
Nesta seção, discutiremos os dois principais designs que podemos usar para implementar um aplicativo web. Implementaremos aplicativos dessas duas maneiras nos capítulos 8 a 10, e abordaremos os detalhes de implementação à medida que avançaremos na implementação de cada um. 

Por enquanto, quero que você conheça duas opções e tenha uma compreensão geral dessas abordagens. É importante saber como podemos criar nossos aplicativos web para evitar confusões mais tarde, quando estiver implementando os exemplos.

Classificamos as abordagens para criar um aplicativo web da seguinte forma:
1. **Aplicativos em que o backend fornece a visualização totalmente preparada** em resposta à solicitação de um cliente. O navegador interpreta diretamente os dados recebidos do backend e exibe essas informações ao usuário nesses aplicativos. Discutiremos essa abordagem e implementaremos um aplicativo simples para demonstrá-lo neste capítulo. Em seguida, continuaremos nossa discussão com detalhes mais complexos relevantes para aplicativos em produção nos capítulos 8 e 9.
2. **Aplicativos que utilizam a separação entre frontend e backend.** Para esses aplicativos, o backend serve apenas os dados brutos. O navegador não exibe diretamente os dados contidos na resposta do backend. Em vez disso, o navegador executa um aplicativo frontend separado, que obtém as respostas do backend, processa os dados e instrui o navegador sobre o que exibir. Discutiremos essa abordagem e implementaremos examplos dela no capítulo 9.

A figura 7.4 apresenta a primeira abordagem, na qual o aplicativo não utiliza uma separação entre frontend e backend. Para esses aplicativos, quase tudo ocorre no lado do backend. O backend recebe solicitações que representam as ações do usuário e executa alguma lógica. No final, o servidor responde com o que o navegador precisa exibir. O backend responde com os dados em formatos que o navegador pode interpretar e exibir, como HTML e CSS, imagens e assim por diante. Ele também pode enviar scripts escritos em linguagens que o navegador pode entender e executar (como JavaScript).

Encontraremos ambas as abordagens em aplicativos de produção. Às vezes, os desenvolvedores se referem à abordagem de separação entre frontend e backend como sendo uma abordagem moderna. A separação entre frontend e backend ajuda a tornar o desenvolvimento mais fácil de gerenciar para aplicativos maiores. Equipes diferentes assumem a responsabilidade de implementar o backend e o frontend, permitindo que mais desenvolvedores colaborem no desenvolvimento dos aplicativos. Além disso, a implementação do frontend e do backend pode ser gerenciada de forma independente. Para um aplicativo maior, essa flexibilidade também é um benefício interessante. 

A outra abordagem, que não utiliza a separação entre frontend e backend, é mais adequada principalmente para aplicativos menores. Após discutir detalhadamente ambas as abordagens, vou ensinar as vantagens de cada método, e você saberá quando escolher uma abordagem com base nas necessidades do seu aplicativo.

## 7.1.3 Using a servlet containter in web app development

Nesta seção, analisamos mais profundamente o que e por que você precisa para construir um aplicativo web com o Spring. Até agora, vimos que um aplicativo web possui um frontend e um backend. No entanto, ainda não discutimos explicitamente a implementação de um aplicativo web com o Spring. Claro, nosso objetivo é aprender o Spring e implementar aplicativos com ele, então precisamos dar um passo adiante e descobrir o que é necessário para desenvolver aplicativos web com o framework.

Um dos aspectos mais importantes a considerar é a comunicação entre o cliente e o servidor. Um navegador web utiliza um protocolo chamado *Hypertext Transfer Protocol (HTTP)* para se comunicar com o servidor pela rede. Esse protocolo descreve com precisão como o cliente e o servidor trocam dados pela rede. No entanto, a menos que você esteja apaixonado por redes, não é necessário entender detalhadamente como o HTTP funciona para escrever aplicativos web. Como desenvolvedor de software, espera-se que você saiba que os componentes do aplicativo web utilizam esse protocolo para trocar dados de forma *requisição-resposta*. O cliente envia uma solicitação ao servidor, e o servidor responde. O cliente aguarda a resposta após cada solicitação enviada. No apêndice C, encontraremos todos os detalhes necessário sobre o HTTP para compreender as discussões nos capítulos 7 a 9.

Mas isso significa que nosso aplicativo precisa saber como processar as mensagens HTTP? Bem, podemos implementar essa funcionalidade se desejarmos, mas, ao menos que queira se divertir escrevendo funcionalidades de baixo nível, utilizaremos um componente já projetado para entender o HTTP.

Na verdade, o que precisamos não é apenas algo que entenda HTTP, mas algo que possa traduzir a requisição e a resposta HTTP para um aplicativo Java. Esse "algo" é um **contêiner de servlets** (às vezes chamado de servidor web): um tradutor de mensagens HTTP para o nosso aplicativo Java. Dessa forma, nosso aplicativo Java não precisar se preocupar em implementar a camada de comunicação. 


**NOTE:** We use Tomcat for the examples in this book, but you can use its alternatives for your Spring app. The list of solutions used inn real-world apps is long. Among these, you find Jetty, JBoss, and Payara.

O Tomcat é um **contêiner de servlet** que implementa as especificações Java Servlet e JavaServer Pages (JSP) da Oracle Corporation. Basicamente ele serve como uma ponte entre o servidor web e os nossos aplicativos Java. Quando uma requisição HTTP é recebida, o Tomcat a traduz em um objeto request que pode ser manipulado por servlets ou páginas JSP. Após o processamento, a resposta é convertida de volta em uma resposta HTTP para ser enviada de volta ao cliente.

Mas, se isso é tudo o que um **servlet container** faz, por que ele é chamado de "servlet container?"O que é um #servlet? Um servlet não é nada mais do que um objeto Java que interage diretamente com o *servlet container*. Quando o servlet container recebe uma requisição HTTP, ele chama um método do **objeto servlet** e fornece a requisição como parâmetro. O mesmo método também recebe, como parâmetro, uma representação da resposta HTTP, que o servlet utiliza para configurar a resposta enviada de volta ao cliente que fez a requisição. 

![[Capítulo 7 - Understanding Spring Boot and Spring MVC-1.png]]

1. O cliente usa o protocolo HTTP para se comunicar com o aplicativo do lado do servidor;
2. Um servidor web cuida do que é necessário para se comunicar com o cliente usando o protocolo HTTP;
3. O servidor web recebe as requisições do cliente e as transforma em objetos que a aplicação compreende. Ele também obtém os detalhes da aplicação Spring e os envia de volta ao cliente em um formato adequado de resposta HTTP.
4. O aplicativo Spring implementa a lógica solicitada pelo cliente, mas não consegue receber ass requisições HTTP por conta própria.

Algum tempo atrás, o servlet era o componente mais crítico de um aplicativo web backend do ponto de vista do desenvolvedor. Suponha que um desenvolvedor precisasse implementar uma nova página acessível em um caminho específico da URL (por exemplo, `/home/profile/edit`) para um aplicativo web. Ele precisava criar uma nova instância de servlet, configurá-la no contêiner de servlets e atribuí-la a um caminho específico.

O servlet continha a lógica associada à requisição do usuário e também a capacidade de preparar uma resposta, incluindo informações para o navegador sobre como exibi-la. Para cada caminho que o cliente web pudesse chamar, o desenvolvedor precisava adicionar a instância no contêiner de servlets e configurá-la.

Como esse tipo de componente gerencia instâncias de servlets dentro de seu contexto, ele é chamado de *contêiner de servlets*. Basicamente, ele mantém um contexto de instâncias de servlets  que controla, assim como Spring faz com seus beans. Por essa razão, um componente como o **Tomcat** é chamado de contêiner de servlets.

Como aprenderemos neste capítulo, normalmente não criamos instância de servlets manualmente. Usaremos um **servlet** nas aplicações desenvolvidas com Spring, mas não precisaremos escrevê-las por conta própria, então não é necessário focar no aprendizado de implementação de servlets.

No entanto, é importante lembrar que o #servlet é o **ponto de entrada** para a lógica da nossa aplicação. Ele é o componente com o qual o **contêiner de servlets** (no nosso caso, o **Tomcat**) interage diretamente. É através dele que os dados da requisição entram na aplicação e a resposta retorna pelo Tomcat para o cliente.

![[Capítulo 7 - Understanding Spring Boot and Spring MVC-2.png]]
The Spring web app defines a servlet object. We register this object, so Tomcat call it for any path of the client's request. This servlet becomes the entry point to our app's logic.


## 7.2 The magic of Spring Boot
Para criar uma aplicação web com Spring, precisaríamos configurar um **contêiner de servlets**, criar uma *instância de servlet* e garantir que essa instância esteja corretamente configurada para que o **Tomcat** a chame sempre que houver uma requisição do cliente. 

Que dor de cabeça ter que escrever tantas configurações! Muitos anos atrás, quando eu ensinava **Spring 3** (a versão mais recente do Spring na época) e configurávamos aplicações web, essa era a parte que tanto os alunos quanto eu mais odiávamos.

Nesta seção, discutiremos o **Spring Boot**, uma ferramenta para a implementação de aplicações modernas com Spring. O Spring Boot se tornou um dos projetos mais apreciados no ecossistema Spring porque facilita a criação de aplicações, permitindo que foquemos na lógica de negócio, eliminando grande parte do código que antes era necessário para configurações.

Isso é especialmente útil no contexto de **arquiteturas orientadas a serviços (SOA)** e microsserviços, onde as aplicações são criadas com mais frequência (como discutido no Apêndice A). Evitar a dor de cabeça de escrever inúmeras configurações faz uma grande diferença. 

Aqui estão as funcionalidades mais críticas do Spring Boot, na minha opinião, e o que elas oferecem:
- **Criação simplificada de projetos** — Você pode usar um serviço de inicialização de projetos para obter um esqueleto de aplicação vazio, mas já configurado
- **Starters de dependências** — O **Spring Boot** agrupa certas dependências usadas para um propósito específico em **starters**. Isso significa que você não precisa descobrir todas as dependências essenciais para uma determinada funcionalidade nem se preocupar com as versões corretas para garantir compatibilidade.
- **Autoconfiguração baseada em dependências** — Com base nas dependências que você adiciona ao projeto, o **Spring Boot** define algumas configurações padrão. Em vez de escrever todas as configurações manualmente, você só precisa modificar aquelas que não atendem às suas necessidades. Muitas vezes, essas mudanças exigem pouco ou nenhum código.

Agora, vamos aprofundar essas funcionalidades essenciais do **Spring Boot** e aplicá-las na prática. O primeiro exemplo será a nossa primeira aplicação web com **Spring**.

## 7.2.1 Using a project initialization service to create a Spring Boot project
Nesta seção, discutimos o uso de um serviço de inicialização de projetos para criar um projeto Spring Boot. Algumas pessoas não dão muita importância ao serviço de inicialização de projetos, mas não posso expressar o quanto sou grato por essa funcionalidade existir. Como desenvolvedor, você não cria múltiplos projetos todos os dias, então pode não perceber a grande vantagem desse recurso. Para estudantes e professores que escrevem vários projetos Spring Boot diariamente, esse recurso poupa horas de trabalho em ações repetitivas e insignificantes que seriam necessárias caso você começasse um projeto do zero. Para entender como isso pode ajudá-lo, vamos usar um serviço de inicialização de projetos para criar um projeto chamado **“sq-ch7-ex1”**.

Algumas IDEs se integram diretamente a um serviço de inicialização de projetos, enquanto outras não. Por exemplo, no **IntelliJ Ultimate** ou no **STS (Spring Tool Suite)**, você encontrará esse recurso disponível ao criar um novo projeto (figura 7.9). No entanto, se você usar o **IntelliJ Community**, essa funcionalidade não está presente.

Se a sua IDE suporta esse recurso, provavelmente você o encontrará nomeado como **Spring Initializr** no menu de criação de projetos. No entanto, se a sua IDE não oferece integração direta com um serviço de inicialização de projetos Spring Boot, você pode usar esse recurso acessando **http://start.spring.io** diretamente no seu navegador. Esse serviço ajudará você a criar um projeto que pode ser importado para qualquer IDE. Vamos usar essa abordagem para criar nosso primeiro projeto.

A lista a seguir resume os passos que seguiremos para criar o projeto Spring Boot usando o **start.spring.io** (figura 7.10):

1. Acesse **start.spring.io** em um navegador web.
2. Selecione as propriedades do projeto (linguagem, versão, ferramenta de build, etc.).
3. Selecione as dependências necessárias que deseja adicionar ao seu projeto.
4. Use o botão **Generate** para baixar o projeto compactado.
5. Descompacte o projeto e abra-o na sua IDE.

Uma vez que você acessa **start.spring.io** em um navegador, encontrará uma interface semelhante à da figura 7.11. Você precisará especificar algumas propriedades do projeto, como a ferramenta de build que prefere entre **Maven** e **Gradle**, e a versão do Java que deseja usar. O Spring Boot também oferece a possibilidade de alterar a sintaxe do seu aplicativo para **Kotlin** ou **Groovy**.

...

**The APP's Main Class Created By Start.Spring.IO**
A primeira coisa a observar é a **classe principal** da aplicação. Descompacte o arquivo baixado e abra-o na sua IDE. Você pode notar que o **Spring Initializr** adicionou a classe **Main** ao seu aplicativo, além de algumas configurações no arquivo **pom.xml** . A classe principal de um aplicativo Spring Boot é anotada com a anotação **`@SpringBootApplication`** , e ela se parece com o trecho de código a seguir:
[[SqCh7Ex1Application.java]]
```java
package org.example.sqch7ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation defines the Main class of a Spring Boot app
public class SqCh7Ex1Application {
    public static void main(String[] args) {
        SpringApplication.run(SqCh7Ex1Application.class, args);
    }
}
```

O **Spring Initializr** gerou todo esse código. Neste livro, focaremos apenas no que é relevante para nossos exemplos. Por exemplo, não detalharei o que o método **`SpringApplication.run()`** faz ou como exatamente o Spring Boot utiliza a anotação **`@SpringBootApplication`** . Esses detalhes não são relevantes para o que você está aprendendo agora. O **Spring Boot** é um assunto extenso, suficiente para um livro inteiro. No entanto, em algum momento, você provavelmente vai querer entender em detalhes como os aplicativos Spring Boot funcionam, e para isso recomendo que leia:

- **"Spring Boot in Action"** de Craig Walls (Manning, 2015)
- **"Spring Boot: Up and Running"** de Mark Heckler (O’Reilly Media, 2021).

Esses livros fornecem uma compreensão mais profunda sobre o funcionamento interno do Spring Boot e são ótimos recursos para quando você quiser se aprofundar no assunto.

**The Spring Boot Mavem Parent Configured By Start.Spring.Io**
Em segundo lugar, vamos examinar o arquivo **`pom.xml`** . Se você abrir o arquivo **`pom.xml`** do seu projeto, verá que o serviço de inicialização de projetos também adicionou alguns detalhes importantes aqui. Um dos detalhes mais relevantes é o nó **Spring Boot parent** , que se parece com o trecho de código a seguir:
```java
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.4.RELEASE</version>
    <relativePath/>
</parent>
```

- O spring-boot-start-parent fornece versões compatíveis para as dependências do projeto.
- Na maioria dos casos, não precisamos especificar versões manualmente, pois o Spring Boot escolhe automaticamente versões testadas e compatíveis.
- Essa abordagem simplifica o desenvolvimento, evita conflitos de versão e facilita atualizações.

**THE SPRING BOOT MAVEN PLUGIN CONFIGURED BY START.SPRING.IO**
A seguir, vamos examinar o **plugin do Spring Boot Maven** , que é configurado automaticamente pelo **start.spring.io** ao criar o projeto. Você também encontra esse plugin configurado no arquivo **`pom.xml`** . O trecho de código a seguir mostra a declaração do plugin, que geralmente está localizada no final do arquivo `pom.xml`, dentro das tags `<build> <plugins> … </plugins></build>`. Esse plugin é responsável por adicionar parte das configurações padrão que você observará no seu projeto:
```java
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

## 7.2.2 Using dependency starters to simplify the dependency management
Agora que você aprendeu a usar um serviço de inicialização de projetos do **Spring Boot** e tem uma visão mais clara do projeto que criou, vamos focar na segunda grande vantagem que o **Spring Boot** oferece: **starters de dependências**.

Os *starter dependency* economiza muito tempo e são uma funcionalidade valiosa do Spring Boot. Um *start dependency* é um grupo de dependências que adicionamos para configurar nossa aplicação para um propósito específico. No arquivo *pom.xml* do nosso projeto, o *starter* parece uma dependência comum, como mostrado no trecho de código a seguir. Observe o nome da dependência: <span style="background:#d4b106">um starter geralmente começa com</span> "spring-boot-starter", seguido de um nome relevante que descreve a funcionalidade adicionada à aplicação.

```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Portanto, os Spring Boot Starters são um conjunto de dependências pré-configuradas  que facilitam o desenvolvimento de aplicações Spring Boot. Em vez de ter que escolher e configurar manualmente um monte de dependências, basta incluirmos um starter em nosso projeto, e ele trará consigo todas as bibliotecas necessárias para uma funcionalidade específica. Isso acelera muito o processo de desenvolvimento.

Por exemplo, se você quiser criar uma aplicação web, pode adicionar a dependência `spring-boot-starter-web` no seu projeto, e ela trará consigo todas as dependências necessárias para uma aplicação web, como Spring MVC, Tomcat (o servidor de aplicações), entre outras...

Suponha que você queira adicionar capacidades web ao seu aplicativo. No passado, para configurar um aplicativo web Spring, você precisava adicionar todas as dependências necessárias ao seu arquivo pom.xml e garantir que suas versões fossem compatíveis umas com as outras. Configurar todas as dependências necessárias não é uma tarefa fácil. Cuidar da compatibilidade das versões é ainda mais complicado.

Com os starters de dependência, não solicitamos dependências diretamente. Solicitamos capacidades (figura 7.14). Você adiciona um starter de dependência para uma capacidade específica que precisa, como funcionalidades web, um banco de dados ou segurança. O Spring Boot garante adicionar as dependências corretas ao seu aplicativo com a versão compatível adequada para a capacidade solicitada. Podemos dizer que os starters de dependência são grupos de dependências compatíveis orientados por capacidades.

### 7.2.3 Using autoconfiguration by convention based on dependencies
O Spring Boot também fornece autoconfiguração para sua aplicação. Dizemos que ele aplica o princípio de convenção sobre configuração. Nesta seção, discutimos o que é convenção sobre configuração e como o Spring Boot nos ajuda aplicando este princípio. De todas as funcionalidades do Spring Boot discutidas neste capítulo, a autoconfiguração é provavelmente a mais apreciada e conhecida.

Simplesmente inicie o seu aplicativo e você entenderá o porquê. Sim, eu sei, você ainda nem escreveu nada—apenas baixou o projeto e o abriu em seu IDE. Mas você pode iniciar o aplicativo, e verá que ele inicializa uma instância do Tomcat por padrão, acessível na porta 8080.

Baseado nas dependências que você adicionou, o Spring Boot percebe o que você espera do seu aplicativo e fornece algumas configurações padrão. O Spring Boot oferece as configurações que são geralmente usadas para as capacidades que você solicitou ao adicionar as dependências.

Por exemplo, o Spring sabe que, quando você adicionou a dependência web, você precisa de um contêiner de servlets e configura uma instância do Tomcat para você, porque, na maioria dos casos, os desenvolvedores usam essa implementação. Para o Spring Boot, o **Tomcat** é a convenção para um contêiner de servlets.

A convenção representa a maneira mais usada de configurar o aplicativo para um propósito específico. O Spring Boot configura o aplicativo por convenção, de modo que agora você só precisa mudar aqueles lugares onde seu aplicativo necessita de uma configuração mais particular. Com essa abordagem, você escreverá menos código de configuração (se houver algum).

## 7.3 Implementing a web app with Spring MVC
Nesta seção, vamos implementar nossa primeira página da web em um aplicativo Spring web. É verdade que já temos um projeto Spring Boot com as configurações padrão, mas esse aplicativo apenas inicia um servidor Tomcat. Essas configurações ainda não fazem do nosso aplicativo um aplicativo web! Ainda precisamos implementar as páginas que alguém pode acessar usando um navegador web.

Continuamos implementando o projeto "sq-ch7-ex1" para adicionar uma página da web com conteúdo estático. Com essas mudanças, aprenderemos a implementar uma página da web e como seu aplicativo Spring funciona nos bastidores.

Para adicionar uma página da web ao nosso aplicativo, vamos seguir os dois passos seguintes:
1. Escrever um documento HTML com o conteúdo que precisamos que seja exibido pelo navegador;
2. Escrever um controlador com uma ação para a página da web criada no ponto 1.

![[Capítulo 7 - Understanding Spring Boot and Spring MVC-3.png]]

No projeto "sq-ch7-ex1", começamos adicionando uma página da web estática com o conteúdo que queremos exibir no navegador. Esta página da web é apenas um documento HTML e, para o nosso exemplo, a página exibe apenas um texto curto em um cabeçalho. A listagem a seguir mostra como deve ser o conteúdo deste arquivo. Precisamos adicionar o arquivo na pasta `resource/static` do nosso projeto Maven. Esta pasta é o local padrão onde o aplicativo Spring Boot espera encontrar as páginas para renderização.

```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Home Page</title>
</head>
<body>
	<h1>Welcome!</h1>
</body>
</html>
```

O segundo passo é escrever um controlador com o método que vincula a solicitação HTTP à página que desejamos que nosso aplicativo forneça em resposta. O controlador é um componente do aplicativo web que contém métodos (frequentemente chamados de ações) executados para uma solicitação HTTP específica. No final, a ação do controlador retorna uma referência à página da web que o aplicativo retorna em resposta. Vamos manter nosso primeiro exemplo simples e não faremos o controlador executar nenhuma lógica específica para a solicitação por enquanto. Apenas configuraremos uma ação para retornar em resposta ao conteúdo do documento [[home.html]] que criamos e armazenamos na pasta  "resources/static" no primeiro passo.

Para marcar uma como controlador, precisamos apenas usar a anotação *@Controller*, uma anotação de estereótipo (como *@Component* e *@Service*, discutidas no capítulo 4). Isso significa que o Spring também adicionará um bean dessa classe ao seu contexto para gerenciá-lo. Dentro dessa classe, podemos definir ações do controlador, que são métodos associados a solicitações HTTP específicas.

Suponha que você queira que o navegador exiba o conteúdo desta página quando o usuário acessar o caminho /home. Para obter este resultado, anotamos o método de ação com a anotação *@RequestMapping* especificando o caminho como valor da anotação: *@RequestMapping("/home")*. O método precisa retornar, como uma string, o nome do documento que desejamos que o aplicativo envie como resposta. A listagem a seguir mostra a classe do controlador e a ação que ela implementa.

- *@Controller* -> we annotate the class with de @Controller stereotype annotation;
- *@RequestMapping("/home")* -> we use the @RequestMapping annotation to associate the action with a HTTP request path;
- *return "home.html";* -> we return the HTML document name that contain the details we want the browser to display;

Eu sei que você tem muitas perguntas agora! Todos os meus alunos têm neste ponto quando ensino Spring em sala de aula - perguntas como estas:

1. Esse método pode fazer algo além de retornar o nome do arquivo HTML?
2. Ele pode receber parâmetros?
3. Eu vi exemplos na web usando anotações diferentes de @RequestMapping; elas são melhores?
4. A página HTML pode conter conteúdo dinâmico?

Responderemos a todas essas perguntas com exemplos no capítulo 8. Mas, por enquanto, peço que você se concentre neste aplicativo simples para entender o que acabamos de escrever. Primeiro, você precisa saber <span style="background:#d4b106">como o Spring gerencia a solicitação</span> e <span style="background:#b1ffff">chama essa ação do controlador que implementamos</span>. Compreender corretamente a maneira como o framework gerencia a solicitação web é uma habilidade valiosa que o ajudará a aprender os detalhes mais rapidamente e a implementar qualquer recurso que você precise em um aplicativo web.

Agora iniciamos o aplicativo, analisamos seu comportamento e discutimos, com visuais, o mecanismo por trás do aplicativo que torna esse resultado possível. Ao iniciar o aplicativo, você verá o log. Ele informa que o Tomcat foi iniciado e a porta que ele usa no console do aplicativo. Se você usar a configuração padrão (não configurou algo não explicado neste capítulo), o Tomcat usa a porta 8080.

Tomcat iniciado na(s) porta(s): 8080 (http) com o caminho de contexto ''

Abra uma janela do navegador no mesmo computador onde você executa o aplicativo e escreva o seguinte endereço na barra de endereços: http://localhost:8080/home (figura 7.16). Não se esqueça de escrever o caminho /home que você mapeou com a ação do controlador; caso contrário, você receberá um erro e uma resposta HTTP com o status "404 Not Found".

Agora que você viu o comportamento do aplicativo, vamos discutir o mecanismo por trás dele. O Spring possui um <span style="background:#b1ffff">conjunto de componentes que interagem entre</span> si para obter o resultado que você observou. A figura 7.18 apresenta esses componentes e o fluxo em que eles gerenciam uma solicitação HTTP.

![[Capítulo 7 - Understanding Spring Boot and Spring MVC-4.png]]
1. The client makes an HTTP Request;
2. O Tomcat recebe a solicitação HTTP do cliente. O Tomcat precisa chamar um componente servlet para a solicitação HTTP. No caso do Spring MVC, <span style="background:#d4b106">o Tomcat chama um servlet configurado pelo Spring Boot</span>. Chamamos esse servlet de #DispatcherServlet. 
3. O dispatcher servlet é o ponto de entrada do aplicativo web Spring. (É aquele servlet que discutimos na figura 7.8 anteriormente neste capítulo); **O Tomcat chama o dispatcher servlet para qualquer solicitação HTTP que ele recebe.** A responsabilidade do dispatcher servlet **é gerenciar a solicitação dentro do aplicativo Spring**. Ele precisa encontrar qual ação do controlador chamar para a solicitação e o que enviar de volta em resposta ao cliente. Esse servlet também é conhecido como "front-controller". 
4. A primeira coisa que o *dispacther servlet* precisa fazer é encontrar uma ação do controlador para chamar para a solicitação. Para descobrir qual ação do controlador chamar, o *dispatcher servlet* delega a um componente chamado *handler mapping*.  O **handler mapping** encontra a ação do controlador que associamos à solicitação com a anotação *@RequestMapping.*
5. Depois de descobrir qual ação do controlador chamar, o *dispatcher servlet* chama essa ação específica do controlador. Se o **handler mapping** não conseguir encontrar nenhuma ação associada à solicitação, o aplicativo responde ao cliente com um status HTTP "404 Not Found". <span style="background:#affad1">O controlador retorna o nome da página que precisa ser renderizada para a resposta ao dispatcher servlet</span>. Referimos a está página HTML também como "a view".
6. Neste momento, o **dispatcher servlet** precisa encontrar a view com o nome recebido do controlador para obter seu conteúdo e enviá-lo como resposta. O dispatcher servlet delega a responsabilidade de obter o conteúdo da view para um componente chamado *view Resolver*. 
7. The dispatcher servlet returns the rendered view in the HTTP response.

