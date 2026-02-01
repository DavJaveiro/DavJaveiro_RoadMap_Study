O node é um ambiente de tempo de execução de código aberto e multiplataforma no qual os desenvolvedores podem criar serviços de back-end usando a linguagem JavaScript. Ele foi desenvolvido com base no V8, o mecanismo JavaScript do navegador da Web Chrome, e tem dezenas de módulos integrados que foram projetados para serem <span style="background:#affad1">usados de forma assíncrona com uma abordagem orientada a eventos que é comumente conhecida como modelo sem bloqueio</span>. Os desenvolvedores do Node podem usar eventos e funções de manipulador para executar com eficiência várias operações em paralelo, <span style="background:#b1ffff">sem precisar lidar com a complexidade de vários processos e threads</span>.

Começaremos com uma introdução ao Node, como ele funciona e por que é popular. Aprenderemos os conceitos básicos da CLI do Node, como usar módulos e pacotes e como executar operações síncronas e assíncronas. Discutiremos os fundamentos do modelo sem bloqueio orientado por eventos do Node e aprenderemos como callbacks, promises, and events can be used to handle the result of an asynchronous operation.

## Introducing Node
Ryan Dahl iniciou o projeto Node em 2009 depois de se inspirar no desempenho do mecanismo V8 JavaScript no navegador da Web Google Chrome. O V8 usa um modelo orientado por eventos, o que o torna eficiente no tratamento de conexões e solicitações simultâneas. Ryan queria trazer essa mesma arquitetura de alto desempenho e orientada por eventos para os aplicativos do lado do servidor. O modelo orientado a eventos é o primeiro e mais importante conceito we need to understand about Node (and the V8 engine as well). Explicarei isso brevemente neste capítulo e o ampliarei no Capítulo 3.

Decidi dar uma olhada no Node e aprender mais sobre ele depois de assistir à apresentação que Ryan Dahl fez para apresentá-lo. Acho que você também se beneficiará se começar por aí. Pesquise no YouTube por "Ryan Dahl introduction to Node". O Node mudou significativamente desde então, portanto, não se concentre nos exemplos, mas sim nos conceitos e nas explicações.

Em sua essência, o Node permite que nós utilizemos a linguagem JavaScript em qualquer máquina sem precisar de um navegador Web. O Node é geralmente definido como "JavaScript" em servidores back-end. Antes do Node, isso não era comum ou fácil. O JavaScript era algo voltado para o front-end. O Node oferece muito mais do que a capacidade de executar JavaScript em servidores. De fato, a execução real do JavaScript é feita pelo mecanismo V8 JavaScript, não pelo Node. O Node é apenas uma interface para o V8 quando se trata de executar código JavaScript.

O V8 é o mecanismo JavaScript de código aberto do Google que pode compilar e executar código JavaScript. Ele é usado no Node, bem como no Chrome e em alguns outros navegadores. Ele também é utilizado no Deno, the new JavaScript runtime that was created by Ryan Dahl in 2018.

Uma diferença fundamental de entender, é que o JS não tem uma etapa de compilação separada como o *javac*. O V8 decide em **tempo de execução** o que vale a pena otimizar.

| Aspecto                  | JVM                         | V8                                                   |
| ------------------------ | --------------------------- | ---------------------------------------------------- |
| Linguagem alvo           | Java (tipada)               | JavaScript (dinâmica)                                |
| Estabilidade do código   | Estrutura previsível        | Tipos mudam toda hora                                |
| Estratégia de otimização | Baseada em tipos conhecidos | Baseada em suposições (speculative optimization)     |
| Desempenho               | Muito consistente           | Pode ser muito rápido ou cair se a otimização falhar |
| Warmup                   | Sim                         | MUITO mais sensível                                  |

O Node é melhor definido como um ambiente de tempo de execução de servidor que envolve o V8 e fornece módulos para ajudar os desenvolvedores a criar e executar aplicativos de software eficientes com JavaScript. A palavra-chave nessa definição é eficiente. O Node adota e expande o mesmo modelo orientado a eventos do V8. A maioria dos módulos internos do Node <span style="background:#affad1">é orientada por eventos e pode ser usada de forma assíncrona sem bloquear a thread principal de execução em que seu código é executado</span>. 

Uma thread é basicamente um pequeno processo em um processo maior. Um processo pode criar várias threads de execução, cada um associado a um núcleo da CPU. Os threads podem compartilhar memória e recursos dentro do processo maior. Na programação multithread, as operações lentas são executadas em threads separados. <span style="background:#affad1">No Node, temos um único thread principal para o nosso código, e todas as operações lentas são executadas fora dessa thread principal, de forma assíncrona. </span>

Precisamos ler o conteúdo de uma arquivo externo? Podemos fazer isso de forma assíncrona sem bloquear a thread principal única. Precisamos iniciar um servidor Web? Trabalhar com soquetes de Rede? Analisar, compactor ou criptografar dados? Toda operação lenta de baixo nível tem uma API assícrona para usarmos sem bloquear as outras operações. 

Não precisamos lidar com vários threads para fazer coisas em paralelo com o Node. Não desperdiçamos recursos com threads manuais ociosos aguardando operações lentas. Codificamos em uma thread e usamos APIs assíncronas, e o Node se encarrega de executar as operações assíncronas de forma eficiente fora da sua thread principal.

Qualquer código que precise ser executado após uma operação lenta pode ser gerenciado com eventos e manipuladores de eventos. Um evento é um sinal de que algo aconteceu e que uma determinada ação precisa ser executada. A ação pode ser definida em uma função de manipulador de eventos que é associada ao evento. Toda vez que o evento for sinalizado, a nossa função manipuladora será executada. Essa é basicamente a essência do que significa orientado por eventos. 

## The JavaScript Language
Depois de considerar linguagens de programação como Python, Lua e Haskell, Ryan Dahl escolheu a linguagem JavaScript para o Node porque era uma boa opção. Ela é simples, flexível e popular, mas o mais importante é que as funções JavaScript **são cidadãos de primeira classe que podemos tratar como quaisquer outros objetos (números ou cadeias de caracteres).** Podemos armazená-las em variáveis, passá-las para outras funções por meio de argumentos e até mesmo retorná-las de outras funções, tudo isso preservando seu estado. O Node aproveitou isso para implementar seu tratamento de operações assíncronas.

Apesar dos problemas históricos do JavaScript, acredito que hoje ele é uma linguagem decente que pode ser ainda melhor com o uso do *TypeScript* (que discutiremos no Capítulo 10).

Além de simplificar a implementação de operações assíncronas, o fato de o JavaScript ser a linguagem de programação dos navegadores deu ao Node a vantagem de ter **uma única linguagem em toda a stack** (frontend e backend). Isso traz alguns benefícios sutis, mas importantes:
