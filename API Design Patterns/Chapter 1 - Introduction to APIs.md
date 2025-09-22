O design de APIs é complicado. Afinal, se fosse fácil, provavelmente haveria pouca necessidade deste livro. Mas antes de começarmos a explorar as ferramentas e os padrões que tornam o design de APIs um pouco mais gerenciável, precisamos primeiro concordar com alguns termos fundamentais e alinhar as expectativas sobre este livro. Nos próximos dois capítulos, abordaremos alguns conteúdos introdutórios que servirão como base para o restante do livro.

Começaremos no capítulo 1 definindo em detalhes o que queremos dizer com uma API. Mais importante ainda, investigaremos como são boas APIs e como distingui-las de APIs ruins. Em seguida, no capítulo 2, analisaremos mais de perto o que entendemos por padrão de design e a anatomia dos padrões descritos ao longo do livro, com objetivo final de utilizar esses padrões para construir APIs consistentemente boas.

## Introduction to APIs
*This chapter covers*
- What are interfaces?
- What are APIs?
- What is resource orientation?
- What makes an API "good"?

É bem provável que, ao pegar esse livro, já estejamos familiarizado com o conceito geral de uma API. Além disso, provavelmente já sabemos o que API significa interface de programação de aplicações, então o foco deste capítulo será explorar com mais profundidade o que esses conceitos básicos realmente significam, assim como por que eles são importantes. Vamos começar examinando mais de perto essa ideia de uma API.

## 1.1 What are web APIs?
Uma API define a forma como sistemas computacionais interagem. E como pouquíssimos sistemas existem isoladamente, não é surpresa que APIs estejam em toda parte. Podemos encontrá-las nas bibliotecas que usamos por meio de gerenciadores de pacotes de linguagem (por exemplo, uma biblioteca de criptografia que fornece um método como *encrypt(input: string): string*) e, tecnicamente, até mesmo no código que escrevemos nós mesmos, mesmo que ele nunca tenha sido feito para ser usado para outras pessoas.

Mas existe um tipo especial de API que é projetado para ser exposto pela rede e utilizado remotamente por muitas pessoas diferentes. São essas APIs que são o foco deste livro, frequentemente chamadas de "APIs web". 

As APIs web são interessantes por vários motivos, mas talvez o aspecto mais intrigante dessa categoria especial seja o fato de que quem constrói a API tem muito controle, enquanto quem a utiliza tem relativamente pouco. Quando usamos uma biblioteca, lidamos com cópias locais dela, o que significa que os desenvolvedores podem fazer o que quiserem, quando quiserem, sem prejudicar os usuários. Já as APIs web são diferentes porque não há cópias locais. Quando os desenvolvedores fazem alterações, essas mudanças são impostas aos usuários, quer eles queiram ou não.

Por exemplo, imagine uma chamada de API web que permite criptografar dados. Se a equipe responsável decidir usar um algoritmo diferente para criptografar suas informações, não teremos escolha. Ao chamar o método de criptografia, nossos dados serão processados com o novo algoritmo. Em um exemplo mais extremo, a equipe pode simplesmente desligar a API e ignorar suas requisições. Nesse momento, a nossa aplicação deixará de funcionar repentinamente, e não há muito o que possamos fazer a respeito.

No entanto, as desvantagens de uma API web para os consumidores geralmente são os principais benefícios para quem a desenvolve: eles conseguem manter controle total sobre a API. Por exemplo, se uma API de criptografia utilizasse um novo algoritmo supersecreto, a equipe  que o criou provavelmente não gostaria de simplesmente distribuir esse código ao mundo na forma de uma biblioteca. Em vez disso, prefeririam usar uma API web, o que permitira expor a funcionalidade do algoritmo secreto sem revelar sua valiosa propriedade intelectual.

Em outras situações, um sistemas pode exigir um poder computacional extraordinário, o que levaria tempo demais para ser executado se fosse distribuído, o que levaria tempo demais para ser executado se fosse distribuído como uma biblioteca e rodasse em um computador pessoal ou laptop. Nesses casos, construir uma API web permite oferecer funcionalidades poderosas enquanto oculta dos consumidores os requisitos computacionais envolvidos. 

## 1.2 Why do APIs matter?
Não é incomum que softwares sejam projetados e desenvolvidos exclusivamente para uso humano, e não há nada fundamentalmente errado nisso. No entanto, nos últimos anos temos visto um foco crescente na automação, onde buscamos criar programas de computador que façam o que nós humanos fazemos, só que mais rápido. Infelizmente, é nesse ponto que o software *exclusivo para humanos* começa a se tornar um problema.

Quando projetamos algo exclusivamente para uso humano, com interações que envolvem mouse e teclado, tendemos a confundir o layout e os aspectos visuais do sistema com os dados brutos e as funcionalidades. Isso é um problema porque é difícil explicar a um computador como interagir com uma interface gráfica. E o problema piora quando mudanças visuais exigem que o computador *reaprenda* como interagir com essa nova interface. Na prática, embora essas mudanças possam parecerr apenas cosméticas para nós, elas são completamente irreconhecíveis para um computador. Em outras palavras, para um computador, não existe algo como *mudança apenas estéticas.*

APIs são interfaces projetadas especificamente para computadores, com propriedades importantes que facilitam seu uso por máquinas. Por exemplo, essas  interfaces não têm aspectos visuais, então não há preocupação com mudanças superficiais. Além disso, elas geralmente evoluem de forma *compatível*, o que significa que não  é necessário reaprender nada quando há alterações. <span style="background:#d3f8b6">Em resumo, APIs oferecem uma forma de falar a linguagem que os computadores precisam para interagir de maneira segura e estável</span>. 

Mas isso não se limita   à automação simples. As APIs também abrem caminho para a composição, permitindo que tratemos funcionalidades como blocos de montar Lego, juntando peças de maneiras inovadoras para construir soluções muito maiores do que a soma de suas partes. Para completar o ciclo, essas novas composições de APIs também podem se tornar blocos reutilizáveis, possibilitando projetos futuros ainda mais complexos e extraordinários.

Mas isso nos leva a uma pergunta importante: como garantir que as APIs que construímos se encaixem como peças de Lego? Vamos recomeçar explorando uma estratégia para  isso, chamada de **orientação a recursos**.

## 1.3 What are resource-oriented APIs?
Muitas APIs web que existem hoje funcionam um pouco como servos: pedimos que elas façam algo e elas simplesmente executam. Por exemplo, se quisermos saber a previsão do tempo para nossa cidade natal, podemos *ordernar* à API web que execute algo como *predictWeather(postalCode=10011)*, como se fosse um servo. Esse estilo de comandar outro computador chamando uma sub-rotina ou método pré-configurado é frequentemente chamado de *chamada de procedimento remoto* (RPC), porque estamos, na prática, chamando uma função de biblioteca (ou procedimento) para ser executada em outro computador que pode estar bem distante (ou remoto).  

O aspecto crítico de APIs deste tipo é o foco principal nas ações que estão sendo realizadas. Ou seja, pensamos em calcular a previsão do tempo, criptografar dados ou enviar um e-mail, sempre com ênfase em *fazer* algo.

Então, por que nem todas as APIs seguem o estilo RPC? Umas das principais razões tem a ver com a ideia de *estado*, onde chamadas de API podem ser *com estado* (stateful) ou *sem estado* *stateless*. Uma chamada de API é considerada sem estado quando pode ser feita de forma independente de todas as outras requisições, sem qualquer contexto ou dado adicional. Por exemplo, uma chamada de API para prever o tempo envolve apenas uma entrada independente (o código postal) e, portanto, seria considerada sem estado.

Por outro lado, uma API web que armazena as cidades favoritas de um usuário e fornece previsões para essas cidades não recebe entradas em tempo de execução, mas exige que o usuário já tenha armazenado as cidade de interesse. Como resultado, esse tipo de requisição, que depende de chamadas anteriores ou dados previamente salvos, seria considerada com estado.

Acontece que APIs no estilo RPC funcionam muito  bem para funcionalidades sem estado, mas tendem a ser menos adequadas quando introduzimos métodos de API com estado.  

**NOTA** se já estiver familiarizado com REST, este pode ser um bom momento para destacar que esta seção não trata especificamente de REST e APIs RESTful, mas sim de APIs que enfatizam *recursos* (como a maioria das APIs RESTful faz). Em outras palavras, embora haja bastante sobreposição com o tema REST, esta seção é um pouco mais geral do que apenas REST.

Para entender melhor isso, vamos considerar um exemplo de uma API com estado *stateful* para reservas de voos. Na tabela 1.1, vemos uma lista de chamadas RPC para interagir com planos de viagem aérea, cobrindo ações como agendar novas reservas, visualizar reservas existentes e cancelar viagens indesejadas.

**Tabela 1.1 — Resumo dos métodos de uma API de reserva de voos**

|Método|Descrição|
|---|---|
|`ScheduleFlight()`|Agenda um novo voo|
|`GetFlightDetails()`|Exibe informações sobre um voo específico|
|`ShowAllBookings()`|Mostra todos os planos de viagem atualmente reservados|
|`CancelReservation()`|Cancela uma reserva de voo existente|
|`RescheduleFlight()`|Reagenda um voo existente para outra data ou horário|
|`UpgradeTrip()`|Faz upgrade da classe econômica para a primeira classe|

Esse tipo de API exige que o sistema mantenha informações entre chamadas, como os voos já reservados, o que caracteriza seu comportamento como *com estado*. Ou seja, o método precisa saber quem é o usuário, quais voos ele já reservou, ou se ele tem créditos acumulados, por exemplo, ou seja, se depende de informações anteriormente conhecida, então ela é #stateful. Ela exige um estado de contexto para funcionar corretamente.

Cada uma dessas chamadas RPC é bastante descritiva, mas não há como escapar da necessidade de memorizar os métodos da API, cada um com diferenças sutis entre si. Por exemplo, às vezes um método fala sobre um *voo* (como RescheduleFlight()), e outras vezes opera sobre uma *reserva* (como CancelReservation()). Também precisamos lembrar qual das muitas formas sinônimas de uma ação foi usada. Por exemplo, temos que lembrar se a maneira de ver todas as nossas reservas é *showFlights*, *ShowAllFlights()*, *ListFlights()* ou *ListAllFlights()* (nesse caso, é *ShowAllFlights()*).

Mas o que podemos fazer para resolver isso? A resposta está na **padronização**:
A **orientação a recursos** busca resolver esse problema oferecendo um conjunto padrões de blocos de construção para usar no design de uma API em duas áreas principais:
- **Recursos:** APIs orientadas a recursos se baseiam na ideia de *recursos*, que são os conceitos-chave que armazenamos e com os quais interagimos, padronizando os *objetos* que a API gerencia. 
- **Ações padronizadas**:  em vez de usar nomes arbitrariness de métodos RPC para qualquer ação que imaginarmos, APIs orientadas a recursos limitam as ações a um conjunto pequeno e padronizado (descrito na tabela 1.2), que se aplicam a cada recurso para formar ações úteis na API.
Pensando de outra forma, APIs orientadas a recursos são, na verdade, um tipo especial de API estilo RPC, onde cada chamada segue um padrão claro e padronizado: *< StandardMethod > < Resource > ()*.

📋 **Tabela 1.1 — Exemplos de métodos em uma API de reserva de voos**

|Método|Descrição|
|---|---|
|`ScheduleFlight()`|Agenda um novo voo|
|`GetFlightDetails()`|Exibe informações sobre um voo específico|
|`ShowAllBookings()`|Mostra todos os planos de viagem atualmente reservados|
|`CancelReservation()`|Cancela uma reserva de voo existente|
|`RescheduleFlight()`|Reagenda um voo existente para outra data ou horário|
|`UpgradeTrip()`|Faz upgrade da classe econômica para a primeira classe|

🔧 **Tabela 1.2 — Métodos padronizados e seus significados**

|RPC|Descrição|
|---|---|
|`Create<Resource>()`|Cria um novo recurso|
|`Get<Resource>()`|Exibe informações sobre um recurso específico|
|`List<Resources>()`|Mostra uma lista de todos os recursos existentes|
|`Delete<Resource>()`|Exclui um recurso existente|
|`Update<Resource>()`|Atualiza um recurso existente no lugar|

Essa abordagem ajuda a tornar as APIs mais previsíveis, fáceis de aprender e reutilizáveis, como montar um sistema com peças de Lego.

Se seguirmos esse caminho de RPCs especiais e limitadas, isso significa que, em vez da variedade de métodos RPC mostrados na tabela 1.1, poderíamos definir um único recurso (por exemplo, `FlightReservation`) e obter funcionalidade equivalente usando o conjunto de métodos padronizados mostrado na tabela 1.3.

A padronização é claramente mais organizada, mas isso significa que todas as APIs orientadas a recursos são necessariamente melhores do que APIs orientadas a RPC? Na verdade, não. Em alguns cenários, APIs orientadas a RPC serão mais adequadas (especialmente quando o método da API é sem estado). Em muitos outros casos, no entanto, APIs orientadas a recursos serão muito mais fáceis de aprender, entender e memorizar pelos usuários. Isso acontece porque a padronização oferecida pelas APIs orientadas a recursos permite combinar o que você já sabe (por exemplo, o conjunto de métodos padrão) com o que é fácil de aprender (por exemplo, o nome de um novo recurso), possibilitando começar a interagir com a API imediatamente.

Colocando isso de forma mais numérica: se você já conhece cinco métodos padrão, então, graças ao poder de um padrão confiável, aprender sobre um novo recurso é praticamente o mesmo que aprender cinco novos métodos RPC.

É claro que nem toda API é igual, e é um pouco simplista definir a complexidade de uma API com base no tamanho da lista de “coisas para aprender”. Por outro lado, existe um princípio importante aqui: o poder dos padrões. Parece que aprender sobre peças que podem ser combinadas e montadas em coisas mais complexas que seguem um padrão definido tende a ser mais fácil do que aprender sobre coisas complexas já prontas que seguem um design personalizado a cada vez.

Como APIs orientadas a recursos exploram o poder de padrões de design já testados e comprovados, elas geralmente são mais fáceis de aprender e, por isso, “melhores” do que suas equivalentes orientadas a RPC. Mas isso nos leva a uma pergunta importante: o que significa “melhor” nesse contexto? Como sabemos se uma API é “boa”? O que “boa” realmente quer dizer?

## 1.4 What makes an API *good*?
Antes de explorarmos os diferentes aspectos que tendem a tornar uma API *boa*, primeiro precisamos entender por que uma API existe. Em outras palavras, qual é o propósito de construir uma API em primeiro lugar? Muitas vezes, isso se resume a dois motivos simples:
1. Temos alguma funcionalidade que certos usuários desejam.
2. Esses usuários querem usar essa funcionalidade de forma programática.

Por exemplo, podemos ter um sistema incrível para traduzir textos de um idioma para outro. Provavelmente há muitas pessoas no mundo que desejam essa capacidade, mas isso, por si só, não é suficiente. Afinal, poderíamos lançar um aplicativo móvel de tradução que oferecesse esses sistema incrível, em vez de uma API. Para justificar a existência de uma API, as pessoas que desejam essa funcionalidade também precisam querer escrever um programa que a utilize. 

Diante desse dois critérios, para onde isso nos leva quando pensamos nas qualidades desejáveis de uma API?

### 1.4.1 Operational
Começando pelo ponto mais importante: não importa como será a interface final, o sistema como um todo precisa ser **operacional**. Em outras palavras, ele precisa fazer aquilo que os usuários realmente desejam. Se estamos falando de um sistema que pretende traduzir textos de um idioma para outro, ele precisa de fato ser capaz de realizar essa tradução.
Além disso, a maioria dos sistemas provavelmente terá muitos requisitos **não operacionais**. Por exemplo, se nosso sistema traduz textos, pode haver exigências relacionadas à latência (como: a tarefa de tradução deve levar alguns milissegundos, não alguns dias) ou à precisão (como: as traduções não devem ser enganosas ou incorretas).
Esses dois aspectos - o que o sistema faz e como ele se comporta, juntos constituem o que chamamos de **aspectos operacionais** de um sistema. 

### 1.4.2 Expressive
Se é importante que um sistema seja capaz de fazer algo, é igualmente importante que a interface desse sistema permita aos usuários expressar claramente e de forma simples o que desejam fazer. Em outras palavras, se o sistema traduz textos de um idioma para outro, a API deve ser projetada de modo que haja uma maneira clara e simples de realizar essa ação. Nesse caso, poderia ser uma chamada RPC chamada TranslateText().

Esse tipo de coisa pode parecer óbvio, mas na prática pode ser mais complicado do que parece.

Um exemplo dessa complicação oculta é quando uma API já oferece determinada funcionalidade, mas, por descuido nosso, não percebemos que os usuários a desejavam, e, por isso, não criamos uma forma expressiva para que eles a acessassem. Cenários como esse geralmente se manifestam como **gambiarras**, onde os usuários fazem coisas incomuns para acessar funcionalidades *escondidas*.

Por exemplo, se uma API oferece a capacidade de traduzir textos de um idioma para outro, é possível que um usuário force a API a agir como um **detector de idioma**, mesmo que ele não esteja interessado em traduzir nada. Como podemos imaginar, seria muito melhor se os usuários tivessem uma chamada RPC chamada *DetectLanguage()* em vez de fazer várias chamadas tentando advinhar o idioma.

```js
function detectLanguage(inputText: string): string {
  const supportedLanguages: string[] = ['en', 'es', ... ];
  for (let language of supportedLanguages) {
    let translatedText = TranslateApi.TranslateText({
      // Isso assume que a API em questão define um método TranslateText
      // que recebe um texto de entrada e um idioma de destino para traduzir.
      text: inputText,
      targetLanguage: language
    });
    if (translatedText == inputText) {
      // Se o texto traduzido for igual ao texto original,
      // sabemos que os dois idiomas são iguais.
      return language;
    }
  }

  // Se não encontrarmos um texto traduzido igual ao original,
  // retornamos null, indicando que não conseguimos detectar o idioma.
  return null;
}
```

Como esse exemplo mostra, APIs oferecem determinada funcionalidade mas não facilitam o acesso a ela para os usuários **não são muito boas**. Por outro lado, APIs expressivas permitem que os usuários indiquem claramente o que querem fazer (por exemplo, traduzir texto) e até como querem que isso seja feito (por exemplo, em  até 150 milissegundos, com 95% de precisão).

### 1.4.3 Simple
Uma das coisas mais importantes relacionadas à usabilidade de qualquer sistema é a **simplicidade**. Embora seja fácil argumentar que tornar algo simples significa **reduzir o número de elementos** (como métodos RPC, recursos etc.) em uma API, infelizmente isso raramente é verdade. Por exemplo, uma API pode depender de um único método chamado **ExecuteAction()** que lida com toda a funcionalidade; no entanto, isso não simplifica de fato. Em vez disso, apenas transfere a complexidade de vários métodos RPC para uma única chamada cheia de configurações.

Então, como seria uma API realmente simples?
Em vez de tentar reduzir excessivamente o número de métodos, **uma API deve buscar expor a funcionalidade que os usuários desejam da forma mais direta possível**, tornando-a o mais simples possível, mas não mais simples do que o necessário. Por exemplo, imagine que uma API de tradução queira adicionar a capacidade de detectar o idioma de um texto de entrada. Poderíamos fazer isso retornando o idioma detectado na resposta de uma tradução, mas isso esconde a funcionalidade dentro de um método que foi projetado para outro propósito. Em vez disso, faria muito mais sentido criar um método específico para isso, como **DetectLanguage()**. (Vale notar que também poderíamos incluir o idioma detectado ao traduzir conteúdo, mas isso seria para outro propósito).

Outra abordagem comum sobre simplicidade vem de um velho ditado sobre o *caso comum*:
"Torne o caso comum rápido".
Mas aqui o foco é na usabilidade, com espaço para casos avançados. A reformulação seria:
"*Torne o caso comum incrível e o caso avançado possível.*"

Isso significa que, sempre que adicionarmos algo que possa complicar a API para beneficiar usuários avançados, o ideal  é manter essa complexidade oculta para o usuário típico, que só está interessado no uso mais comum. Isso mantém os cenários frequentes  **simples e fáceis**, enquanto ainda permite funcionalidades avançadas para quem precisa.

Por exemplo, imagine que nossa API de tradução inclua o conceito de um **modelo de aprendizado de máquina** a ser usado na tradução de texto. Em vez de especificar o idioma de destino diretamente, o usuário escolheria um modelo baseado nesse idioma, usando-o como “motor de tradução”. Embora essa funcionalidade ofereça **muito mais flexibilidade e controle**, ela também é **bem mais complexa**, como mostrado no novo caso comum da figura 1.3

Como podemos ver, acabamos tornando **muito mais difícil** traduzir um texto ao adicionar suporte para funcionalidades mais avançadas. Para enxergar isso com mais clareza, compare o código mostrado na **listagem 1.2** com a simplicidade de chamar `TranslateText("Hello world", "es")`
```ts
function translateText(inputText: string, targetLanguage: string): string {
  let sourceLanguage = TranslateAPI.DetectLanguage(inputText);
  let model = TranslateApi.ListModels({
    filter: `sourceLanguage:${sourceLanguage} targetLanguage:${targetLanguage}`,
  })[0];

  return TranslateApi.TranslateText({
    text: inputText,
    modelId: model.id
  });
}
```
Como poderíamos projetar essa API para que fosse o mais simples possível — mas não mais simples — e ainda tornar o caso comum incrível e o caso avançado possível?

Como o caso comum envolve usuários que **não se importam com o modelo específico**, poderíamos projetar a API para aceitar **ou** um `targetLanguage` **ou** um `modelId`. O caso avançado continuaria funcionando (na verdade, o código da listagem 1.2 ainda funcionaria), mas o caso comum ficaria **muito mais simples**, usando apenas o parâmetro `targetLanguage` e deixando `modelId` indefinido.

📄 **Listagem 1.3 — Traduzindo texto para um idioma de destino (caso comum)**
```ts
function translateText(inputText: string, targetLanguage: string, modelId?: string): string {
  return TranslateApi.TranslateText({
    text: inputText,
    targetLanguage: targetLanguage,
    modelId: modelId,
  });
}
```

### 1.4.4 Predictable
Embora surpresas na vida possam ser divertidas, um lugar onde elas definitivamente não pertencem são nas APIs, seja na definição da interface ou no comportamento por trás dela. É como aquele velho ditado sobre investimentos:
*Se está emocionante, você está fazendo errado.*

Mas o que queremos dizer com APIs sem surpresas?
APIs previsíveis se baseiam em padrões repetiidos, aplicados tanto à definição da itnerface quanto ao comportamento. Por exemplo, se uma API de tradução de texto tem um método *TranslateText()* que recebe o conteúdo de entrada em um campo chamado **text**, então, ao adicionarmos um método **DetectLanguage()**, o campo de entrada também deve se chamar **text** e não **inputText**, **content** ou **textContent**.

Embora isso pareça óbvio, lembre-se de que muitas APIs são construídas por **equipes diferentes**, e a escolha dos nomes dos campos pode ser **arbitrária**. Isso significa que, quando pessoas diferentes são responsáveis por partes diferentes da API, é bem possível que façam escolhas distintas — e acabamos com uma API **inconsistente** (e, portanto, surpreendente).

Mesmo que essa inconsistência pareça insignificante, ela é **mais importante do que parece**. Isso porque é raro que os usuários de uma API leiam toda a documentação com atenção. Em vez disso, eles leem **apenas o suficiente para fazer o que precisam**. Isso significa que, se alguém aprende que um campo se chama `text` em uma requisição, é quase certo que vai **assumir** que o mesmo nome será usado em outra. Se essa suposição falhar (por exemplo, porque o campo se chama `inputText` em outro lugar), a produtividade despenca — e o usuário precisa parar tudo para descobrir o que deu errado.

📌 A conclusão é clara: APIs que seguem **padrões repetidos e previsíveis** (como nomes consistentes de campos) são **mais fáceis e rápidas de aprender** — e, portanto, **melhores**. <span style="background:#d3f8b6">E os mesmos benefícios se aplicam a padrões mais complexos, como os métodos padronizados que vimos nas APIs orientadas a recursos</span>.

Esse é o propósito central do livro: APIs construídas com padrões bem definidos, claros e simples tendem a ser previsíveis e fáceis de aprender, o que leva a APIs melhores no geral. 

Agora que temos uma boa compreensão sobre o que torna uma API *boa*, podemos começar a pensar em padrões de alto nível para usar no design desses interfaces.