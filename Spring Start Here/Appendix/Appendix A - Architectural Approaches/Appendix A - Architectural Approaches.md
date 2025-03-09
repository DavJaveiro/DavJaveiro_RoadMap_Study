Neste apêndice, discutimos alguns conceitos arquiteturais que encontraremos. Para entender completamente tudo o que discutimos neste livro, precisamos pelo menos estar ciente e ter uma visão geral de alto nível desses conceitos. Vou guiá-lo pelos conceitos de monolito, arquitetura orientada a serviços e microsserviços. Também vou indicar outros recursos que podemos usar para aprofundar nosso conhecimento sobre esses assuntos.

Esses tópicos são complexos; muitos livros e dezenas de apresentações já foram feitos sobre eles, então não posso dizer que vou torná-lo um especialista em apenas algumas páginas, mas ler isso ajudará a entender por que usamos o Spring em cenários específicos que discutimos no livro. Vamos usar um cenário de aplicativo como exemplo e discutir a mudança nas abordagens arquiteturais desde os primórdios do desenvolvimento de software até os dias atuais.

## A.1 The monolithic approach
Nesta seção, discutimos o que é um #monolito. Entenderemos por que, nos primórdios do desenvolvimento de software, os desenvolvedores projetavam aplicativos de forma #monolítica, e isso servirá como base para, nas próximas seções, compreender por que outros **estilos arquiteturais** surgiram. 

Quando os desenvolvedores se referem a um aplicativo #monolítico ou #monolito, isso significa que ele consistem em um único #componente que é implantado e executado. Esse componente implementas todas as suas funcionalidades. Por exemplo, considere um aplicativo para gerenciar uma livraria. Os usuários administram os produtos vendidos pela loja, as faturas, as entregas e os clientes. Na figura A.1, o sistema apresentado é um monolito, pois todas essas funcionalidades fazem parte do mesmo processo.

![[Appendix A - Architectural Approaches.png]]

**NOTA:** um fluxo de negócio é algo que o usuário espera realizar no aplicativo. Por exemplo, quando o dono da loja vende livros, o fluxo pode ser o seguinte: a funcionalidade de **produtos** reserva alguns livros do estoque, a funcionalidade de **faturamento** cria uma fatura para esses livros e a funcionalidade de **entregas** planeja quando entregar os livros e notifica os clientes. 

Incialmente, todas as aplicações eram desenvolvidas de forma monolítica, e essa abordagem funcionava muito bem nos primórdios do desenvolvimento de software. Na década de 1990, a internet era apenas uma rede formada por alguns computadores, mas, em poucos anos, transformou-se em uma rede com bilhões de dispositivos. Hoje, a tecnologia não é mais exclusiva para especialistas, ela é para todos. E essa mudança implicou um crescimento significativo no número de usuários e na quantidade de dados processados por muitos sistemas. Trinta anos atrás, conseguir chamar um táxi de qualquer lugar onde estivéssemos ou até mesmo enviar uma mensagem da rua enquanto esperávamos para atravessar a via não era algo que poderíamos imaginar ser possível.

Para lidar com essa mudança no número de usuários e no crescimento dos dados, os aplicativos precisaram de mais recursos, e usar apenas um processo torna a gestão desses recursos mais difícil. O número de usuários e a quantidade de dados não são as únicas que mudaram com o tempo; as pessoas começaram a usar aplicativos para quase tudo o que desejam fazer remotamente. Por exemplo, hoje podemos gerenciar nossas contas bancárias enquanto toma um cappuccino no nosso café favorito. Embora isso pareça fácil, implica mais riscos de segurança. Os sistemas que oferecem esses serviços precisam ser bem protegidos e confiáveis.

Todas essas mudanças trouxeram alterações na forma como os aplicativos são criados e desenvolvidos. Vamos considerar apenas o aumento no número de usuários para simplificar nossa discussão. O que podemos fazer para permitir que seu aplicativo atende mais requisições? **Poderíamos executar o mesmo aplicativos em múltiplos sistemas**. Dessa forma, várias instâncias do aplicativo em execução dividirão as requisições entre si, de modo que o sistema possa lidar com uma carga maior. Chamamos essa abordagem de *escalabilidade horizontal*.

Assumindo um crescimento linear para simplificar: se uma instância do aplicativo em execução fosse capaz de lidar com 50.000 requisições simultâneas, três instâncias do aplicativo em execução deveriam ser capazes de responder a 150.000 requisições concorrentes. 

Outro aspecto que consideramos é que, em geral, um aplicativo está em constante evolução. Quando fazemos uma única e pequena alteração em um aplicativo monolítico, é necessário **reimplantar** tudo. Ao mesmo tempo, com uma arquitetura de #microsserviços, nós nos beneficiamos ao reimplantar apenas o serviço onde a alteração foi realizada. Essa simplificação também é uma vantagem para o sistema.

Há algum problema em continuar usando uma abordagem monolítica para projetar um aplicativo? Pode ser que não haja nenhum problema. Assim como ocorre com qualquer outra tecnologia ou técnica, projetar seu aplicativo como um monólito pode ser a melhor abordagem para o nosso cenário. Discutiremos casos em que um monolito não é a escolha certa, mas não quero que tenhamos a impressão de que usar uma arquitetura monolítica está errado ou que as abordagens que apresento representam uma maneira melhor de desenvolver aplicativos.

Em muitos casos, as pessoas julgam erroneamente o uso de um monolito. Sempre que ouço desenvolvedores reclamando que seus aplicativos monolíticos são difíceis de manter. A verdade é que o problema provavelmente não está no fato de o aplicativo ser um monólito. Código desorganizado ( #messy-code) é provavelmente a principal causa de dificuldade na manutenção. Ou o fato de os desenvolvedores terem misturado responsabilidades e não terem usado abstrações adequadamente pode ser o motivo pelo qual o aplicativo se tornou difícil de se manter. Mas um aplicativo monolítico não precisa ser necessariamente desorganizado. Com a evolução do software, há situações em que uma abordagem monolítica deixa de funcionar, então precisamos encontrar alternativas.

Dentro do componente monolítico, podemos ter várias classes, pacotes e módulos organizados de forma lógica. Um monólito não impede que a gente divida o nosso código em várias classes ou camadas, mas todas essas partes são empacotadas e implantadas juntas como uma única unidade, logo, a característica de um monólito é o fato do aplicativo ser implantado ( #deploy) como um único componente executável (por exemplo, um único arquivo #jar ou #war em Java).

Outro detalhe é que, em um sistema *monolítico*, o conceito de monólito não impede o consumo de APIs REST externas ou use bibliotecas como #OpenFeign para se comunicar com serviços externos. Na prática, muitos sistemas monolíticos consomem APIs REST de terceiros ou até mesmo de outros sistemas internos para realizar tarefas específicas. Por exemplo:
- Um sistema monolítico pode consumir API REST de pagamento (como Stripe ou Paypal) para processar transações;
- Pode usar uma API de geolocalização para calcular distâncias ou endereços;
- Pode interagir com serviços de terceiros para enviar e-mails ou notificações push.

Dividir a lógica interna do sistema em serviços separados e fazer com que o monólito consuma esses serviços via APIs REST começa a se aproximar de uma arquitetura de microsserviços.

## A.2 Using a service-oriented architecture
Nesta seção, discutimos a **arquitetura orientada a serviços**. Usaremos o exemplo da seção 1.1 para demonstrar que a abordagem monolítica tem limitações e que, em algumas circunstâncias, precisamos adotar um estilo diferente para projetar seu aplicativo. Uma **arquitetura orientada a serviços** resolve os problemas apresentados, mas também discutiremos as dificuldades que essa nova abordagem acrescenta ao desenvolvimento do aplicativo. 

Voltamos ao nosso caso do aplicativo para vender livros. Temos quatro funcionalidades principais cobertas pelo aplicativo:
**produtos**, **entregas**, **faturamento** e **clientes**. O que frequentemente acontece em aplicativos do mundo real é que nem todas as funcionalidades consomem recursos de forma igual. Algumas consomem mais do que outras, possivelmente porque são mais complexas ou usadas com mais frequência.

Com um aplicativo monolítico, não podemos decidir que apenas uma parte do app deve ser escalada. No nosso caso, ou escalamos todas as quatro funcionalidades, ou nenhuma delas. Para gerenciar melhor os recursos, gostaríamos de escalar apenas as funcionalidades que realmente precisam de mais recursos e evitar escalar as outras. 

![[Appendix A - Architectural Approaches-1.png]]

Podemos fazer algo para nos permitir escalar apenas a funcionalidade de **produtos**, mas não as outras? Sim, podemos dividir o monólito em vários serviços. Vamos mudar a arquitetura do aplicativo de um **monólito** para uma **arquitetura orientada a serviços (SOA)**. Em vez de termos apenas um processo para todas as funcionalidades, na SOA temos múltiplos processos implementando as funcionalidades. Assim, podemos decidir escalar apenas o serviço que implementa a funcionalidade que precisa de mais recurso.

![[Appendix A - Architectural Approaches-2.png]]

O **SOA** também tem a vantagem de isolar melhor as responsabilidaades: agora sabemos que há um aplicativo dedicado para o faturamento e outro aplicativo dedicado para as entregas, e assim por diante, e é mais fácil manter as implementações desacopladas e mais coesas. Como consequência também fica mais fácil gerenciar as equipes que trabalham no sistema, pois podemos atribuir serviços específicos para cada equipe, em vez de ter várias equipes trabalhando no mesmo aplicativo. 

À primeira vista, pode parecer simples. Com todas essas vantagens, por que nem todos os aplicativos foram desenvolvidos assim desde o início? Por que ainda afirmar que um monólito ainda é uma solução válida em alguns casos? Para entender as respostas a essas perguntas, vamos discutir as complexidades introduzidas ao utilizar uma arquitetura SOA (Service-Oriented Architecture). Aqui estão algumas áreas em que encontramos diferentes desafios ao trabalhar com SOAs:
1. Comunicação entre os serviços;
2. Segurança;
3. Persistência de dados;
4. Deploy.

### A.2.1 Complexidade ocasionada pela comunicação entre os serviços
As funcionalidades ainda precisam ser comunicar para implementar o fluxo da lógica de negócios. Anteriormente, com uma abordagem monolítica, elas faziam parte da mesma aplicação, o que tornava simples conectar duas funcionalidades por meio de uma chamada de método. No entanto, agora que temos processos diferentes, essa <span style="background:#d4b106">comunicação se torna mais complexa</span>. 

As funcionalidades agora precisam ser comunicar via rede. Um dos princípios essenciais que você precisa ter em mente é que <span style="background:#d4b106">a rede não é totalmente confiável.</span> Muitos caem na armadilha de esquecer de considerar o que acontece se, em algum momento, a comunicação entre dois componentes falhar. Infelizmente, ao contrário da abordagem monolítica, qualquer chamada entre dois componentes pode falhar em algum ponto em uma arquitetura SOA. Dependendo da aplicação, os desenvolvedores utilizam diferentes técnicas ou padrões para resolver esse problema, como repetição de chamadas, **circuit breakers** ou o uso de **caches**. 

Um segundo aspecto a considerar é que existem diversas opções para estabelecer comunicação entre os serviços. Podemos utilizar serviçõs REST, GraphQL, SOAP, gRPC, *message brokers JMS*, Kafka e assim por diante. Qual é a melhor abordagem? Claro, em qualquer cenário, uma ou mais dessas abordagens podem ser adequadas. É possível encontrar longos debates e discussões em diversos livros sobre como escolher a solução mais apropriada para cenários típicos.

Portanto, em uma **arquitetura orientada a serviços (SOA - Service-Oriented Architecture)** ou em arquiteturas modernas como #microsserviços, os módulos são implementados como **serviços independentes**, cada um rodando em sua própria aplicação ou processo. Esses serviços são projetados para serem autossuficientes e podem ser implantados separadamente. A comunicação entre eles ocorre por meio de **interfaces bem definidas**, geralmente usando protocolos de rede, como HTTP, mensagens assíncronas, ou outros mecanismos de integração.


### A 2.2 Complexity added to the security of the system
A divisão de funcionalidades em serviços separados traz muitos benefícios, como escalabilidade e modularidade, mas também aumenta a complexidade das configurações de segurança. Para proteger os dados transmitidos entre os serviços, devemos:
1. **Criptografar** informações sensiveis;
2. Garantir a **integridade** dos dados usando assinaturas digitais ou hashes;
3. Implementar **autenticação e autorizaçao** robustas;
4. Proteger contra ataques comuns, como MitM e DoS.

![[Appendix A - Architectural Approaches-3.png]]

Se os detalhes do cartão de crédito não estiverem **criptografados**, eles podem ser interceptados e roubados durante a transmissão pela rede. Isso ocorre porque as informações trafegam em texto simples (plaintext), tornando-as vulneráveis a ataques.


## A.2.3 Complexity added for the data persistence
Na maioria dos casos, um aplicativo precisa de uma maneira de armazenar dados. Os bancos de dados são uma forma popular de implementar persistência em aplicativos. Com uma abordagem monolítica, o aplicativo tinha um único banco de dados para armazenar os dados, como apresentado na figura A.9. Chamamos isso de arquitetura three-tier architecture, pois consiste em três camadas: o cliente, o backend e o banco de dados usado para persistência. 
![[Appendix A - Architectural Approaches-4.png]]

Com a SOA, agora temos múltiplos serviços que precisam armazenar dados. E com mais serviços, também temos mais opções de design. Devemos usar apenas um banco de dados compartilhado por todos os serviços? Ou devemos ter um banco de dados para cada serviço? A figura A.10 visualiza essas opções. 
![[Appendix A - Architectural Approaches-5.png]]
A maioria acredita que compartilhar um banco de dados é uma má prática. Com base na minha própria experiência ao dividir um monólito em vários serviços, posso dizer que ter um banco de dados compartilhado pode se tornar um pesadelo de implantação. No entanto, ter banco de dados individuais para cada serviço também traz dificuldades. Como veremos quando formos discutir transações, é muito mais fácil garantir consistência de dados com um único banco de dados. Quando há vários bancos de dados independentes, é desafiador garantir que os dados permaneçam consistentes entre todos eles.

## A.2.4 Complexity added in the deployment of the system
Talvez o desafio mais fácil de perceber seja que estamos adicionando muita complexidade à implantação do sistema. Agora também mais serviços, e, como aprendemos em parágrafos anteriores, pode haver múltiplos bancos de dados também. Quando consideramos, além disso, que garantir a segurança do sistema adicionará ainda mais configurações, fica claro o quanto a implantação do sistema se torna mais complexa.

Por que um monólito tem uma conotação negativa?
Podemos perceber que as arquiteturas SOA não são necessariamente fáceis, então pode se perguntar por que a arquitetura monolítica tende a ser associada a algo negativo. A realidade é que, para alguns sistemas, um monólito faz mais sentido do que uma arquitetura SOA.

Pode parecer estranho olhar para trás, para a época em que esses princípios e práticas não existiam, e às vezes até vejo desenvolvedores culparem aqueles que começaram a implementação de sistemas antigos quando surgem problemas. Mas a verdade é que não é culpa das pessoas que usaram as ferramentas e práticas que todos consideravam as melhores naquela época.

Hoje, muitos desenvolvedores associam código bagunçado e mal escrito ao conceito de monólito. No entanto, aplicativos monolíticos podem ser modulares e seu código pode ser limpo, assim como aplicativos orientados a serviços podem ser bagunçados e mal projetados.

## A.3 From microservices to serverless
Nesta seção, discutiremos os #microsserviços. Os #microsserviços são uma implementação específica da #SOA (Service-Oriented Architecture). Um microservice geralmente é projetado com uma única responsabilidade e possui sua própria capacidade de persistência de dados (não compartilha banco de dados).

Com o tempo, a forma como implantamos aplicações mudou. A arquitetura de software não está relacionada apenas à funcionalidade da aplicação. Um arquiteto de software sábio sabe adaptar a arquitetura do sistema tanto à maneira como as equipes trabalham no sistema quanto à forma como o sistema é implantado. Podemos ter ouvido falar sobre o movimento **DevOps**, que aborda tanto como implantamos o software quanto como trabalhamos no desenvolvimento de software. Hoje, implantamos aplicações na nuvem usando máquinas virtuais ou ambientes containerizados, e essas abordagens geralmente implicam a necessidade de tornar as aplicações menores.

Claro, essa evolução trouxe outra incerteza: **quão pequeno um serviço deve ser?** Muitos debateram essa questão em livros, artigos e discussões.

A minimização dos serviços foi tão longe que hoje podemos implementar uma funcionalidade simples com apenas algumas linhas de código e implantá-la em um ambiente. Um evento, como uma requisição HTTP, um temporizador ou uma mensagem, dispara essa funcionalidade e a faz executar. Chamamos essas pequenas implementações de **funções serverless**. O termo, sem servidor não implica que a função não seja executada em um servidor. Porém, como tudo relacionado à infraestrutura é abstraído e oculto, e nos concentramos apenas no código que implementa sua lógica e nos eventos que a acionam, parece que nenhum servidor existe. 

**A.4 Leitura complementar**  
A arquitetura de software e sua evolução é um tema fantástico e complexo. Não acredito que algum dia haverá livros suficientes para abordar completamente este assunto. Incluí esta discussão no livro para ajudá-lo a entender as referências que farei a esses conceitos. Ainda assim, você pode querer se aprofundar mais nesses temas, então aqui está uma lista de livros da minha estante. Os livros estão na ordem em que recomendo que você os leia.

1. **Microservices in Action**, de Morgan Bruce e Paulo A. Pereira (Manning, 2018), é um excelente livro para começar quando se está aprendendo sobre microservices. No livro, você encontrará todos os tópicos fundamentais sobre microservices discutidos com exemplos úteis.
2. **Microservices Patterns**, de Chris Richardson (Manning, 2018), é um livro que recomendo que você leia após estudar profundamente **Microservices in Action**. O autor apresenta uma abordagem pragmática sobre como desenvolver aplicativos prontos para produção utilizando microservices.

3. **Spring Microservices in Action**, de John Carnell e Illary Huaylupo Sánchez (Manning, 2020), ajuda você a entender melhor como aplicar o framework **Spring** para construir microservices.

4. **Microservices Security in Action**, de Prabath Siriwardena e Nuwan Dias (Manning, 2020), detalha o que significa aplicar segurança em uma arquitetura de microservices. A segurança é um aspecto crucial de qualquer sistema, e você sempre precisa considerá-la desde as etapas iniciais do processo de desenvolvimento. O livro explica a segurança desde os fundamentos, e lê-lo proporcionará uma compreensão mais clara dos aspectos que você precisa ter em mente ao lidar com a segurança em microservices.

5. **Monolith to Microservices**, de Sam Newman (O’Reilly Media, 2020), trata de padrões para transformar uma arquitetura monolítica em microservices. O livro também discute se você realmente precisa usar microservices e como tomar essa decisão.
