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

