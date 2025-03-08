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