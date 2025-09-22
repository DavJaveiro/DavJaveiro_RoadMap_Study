*This chapter covers*
- What an API design pattern is
- Why API design patterns are important
- The anatomy and structure of an API design pattern
- Designing an API with and without design patterns

Now that we have a grasp of what APIs are and what makes them "good", we can explore how we might apply different patterns when building an API. We'll start by exploring what API design patterns are, why they matter, and how they'll be described in later chapters. Finally, we'll look at an example API and see how using pre-build API design patterns can save lots of time and future headaches.

## 2.1 O que são padrões de design de API?
Precisamos primeiramente fazer uma pergunta simples: **o que é um padrão de design?**
Se considerarmos que design de software se refere à estrutura ou organização de um código escrito para resolver um problema, então um **padrão de design de software** é o que acontece quando uma determinada estrutura pode ser aplicada repetidamente a muitos problemas semelhantes, com apenas **pequenos ajustes** para se adaptar a diferentes cenários.

Isso significa que o padrão não é uma biblioteca pronta que usamos para resolver um problema específico, mas sim uma **espécie de plano ou modelo** para <span style="background:#fff88f">resolver problemas com estruturas semelhantes</span>.

Se isso ainda parece abstrato, vamos concretizar com uma analogia: imagine que queremos construir um **galpão ou quintal**. Existem várias opções, desde o que fazíamos há séculos até o que fazemos hoje com a ajuda de empresas. Quatro opções comuns seriam:
- **Comprar um galpão pré-fabricado** e colocá-lo no quintal;
- **Comprar um kit de galpão** (com planta e materiais) e montá-lo nós mesmos.
- **Comprar apenas a planta,** e modificar o design conforme necessário e construir por conta própria;
- **Projetar e construir tudo do zero.**

Essa analogia mostra como padrões de design funcionam: eles são como plantas reutilizáveis que podemos adaptar conforme o contexto, sem precisar reinventar tudo do zero. No mundo das APIs, isso significa usar **estruturas comprovadas** para criar interfaces consistentes, previsíveis e fáceis de usar.

Se pensarmos nesses exemplos em termos de equivalentes no mundo do software, eles variam desde o uso de um pacote de software pronto até a criação de um sistema totalmente personalizado para resolver nosso problema. Na **tabela 2.1**, vemos que essas opções se tornam **progressivamente mais difíceis**, mas também oferecem **mais flexibilidade** à medida que avançamos na lista. Em outras palavras, quanto **menos difícil, menos flexível**; quanto **mais difícil, mais flexível.**

Engenheiros de software geralmente escolhem a opção "construir do zero". Às vezes isso é necessário, especialmente quando o problema é novo. Outras vezes, uma escolha é feita após uma análise de custo-benefício, porque o problema é **diferente o suficiente** <span style="background:#d3f8b6">para impedir o uso de soluções prontas</span>. E há casos em que já conhecemos uma biblioteca que resolve exatamente (ou quase) o problema, então optamos por usar algo já existente.

Curiosamente, as opções intermediárias, como customizar software existente ou usar um documento de design, são **menos comuns**, mas poderiam ser usadas com excelentes resultados. E é aí que entram os padrões de design.

**Padrões de design são como plantas aplicadas ao software**, assim como uma planta de galpão traz dimensões, localização de portas e janelas, e materiais do telhado, <span style="background:#affad1">um padrão de design traz especificações e detalhes para o código</span>. Normalmente, isso significa definir uma estrutura de alto nível e os detalhes de como essa estrutura resolve um problema específico.

Mas raramente um padrão de design é usado sozinho. Na maioria das vezes, ele foca em **componentes específicos**, não no sistema inteiro. Ou seja, a planta foca no formato do telhado  ou no design da janela, e não no galpão completo. Isso pode parecer uma limitação, mas é uma vantagem se quisermos construir algo parecido com um galpão, mas não exatamente um galpão. Ter plantas de componentes individuais permite misturar e combinar para montar exatamente o que precisamos.

Se quisermos adicionar log de depuração ao nosso sistema, provavelmente vamos querer **uma única forma de registrar mensagens**. Há varias maneiras de fazer isso (como usar uma variável global), mas existe um padrão de design específico para esse problema: o Singleton Pattern.

Esse padrão, descrito no clássico *Design Patterns*, garante que **apenas uma instância de uma classe seja criada**. A planta envolve:
- um construtor privado
- um método estático chamado *getInstance()*
- Esse método retorna sempre a mesma instância, criando-a apenas se ainda não existir.

Esse padrão não resolve tudo sozinho (uma classe singleton que não faz nada não ajuda muito), mas é uma **solução bem definida e testada** para esse problema específico.

Agora que entendemos o que são padrões de design de software, podemos perguntar: **o que são padrões de design de API?**

Usando a definição de API do capítulo 1, um **padrão de design de API** é simplesmente um **padrão de design aplicado à interface de uma API**, em vez de ao software como um todo. Ou seja, são modelos para projetar e estruturar APIs.

Como o foco está na **interface**, e não na implementação, a maioria dos padrões de API se concentram exclusivamente na interface. Às vezes, eles também especificam aspectos de comportamento da API. Por exemplo, um padrão pode definir que uma chamada RPC seja eventualmente consistente, o que significa que os dados retornados podem estar ligeiramente desatualizados (como quando são lidos de um cache em vez do banco de dados principal).

Por que devemos nos importar com os padrões?

## 2.2 Why are API design patterns important?
Como já aprendemos, padrões de design de API são úteis na construção de APIs, assim como plantas são úteis na construção de um galpão: eles funcionam como blocos de construção pré-projetadas que podemos usar em nossos projetos. O que ainda não exploramos é por que precisamos dessas plantas pré-projetadas em primeiro lugar. Será que não somos todos inteligentes o suficiente para construir boas APIs? Será que não conhecimentos melhor nossos próprios problemas técnicos e de negócio? Embora isso muitas vezes seja verdade, acontece que algumas das técnicas que usamos para construir softwares bem projetados não funcionam tão bem quando estamos construindo APIs. Mais espeficificamente, a abordagem iterativa, defendida especialmente pelo processo de desenvolvimento ágil, é **díficil de aplicar** ao projetar APIs. Para entender o porquê, precisamos observar dois aspectos dos sistemas de software. Primeiro, precisamos explorar a **flexibilidade (ou rigidez)** das várias interfaces em geral, e depois entender qual é o efeito do **público da interface** sobre nossa capacidade de fazer mudanças e iterar no design geral. Vamos começar olhando para a flexibilidade.

Como vimos no capítulo 1, APIs são um tipo especial de interface feitas principalmente para que sistemas computacionais possam interagir entre si. Embora ter acesso programático a um sistema seja muito valioso, isso também é muito mais **frágil e rígido**, pois mudanças na interface podem facilmente causar falhas para quem a utiliza. Por exemplo, mudar o nome de um campo em uma API causaria uma falha em qualquer código escrito pelos usuários antes da mudanças. Do ponto de vista do servidor da API, o código antigo está pedindo algo usando um  nome que nao existe mais. Esse é um cenário bem diferente de outros tipos de interface, como interfaces gráficas (GUIs), que são usadas principalmente por humanos e, como resultado, são muito mais resilientes a mudanças. Isso significa que, mesmo que uma mudança seja frustrante ou esteticamente desagradável, normalmente não causará uma falha catastrófica que nos impeça de usar a interface por completo. Por exemplo, mudar a cor ou a localização de um botão em uma página web pode ser feio e inconveniente, mas ainda conseguimos descobrir como fazer o que precisamos com a interface.

Costumamos nos referir a esse aspecto de uma interface como sua **flexibilidade**, dizendo que interfaces onde os usuários conseguem se adaptar facilmente às mudanças são flexíveis, e aquelas onde até pequenas mudanças (como renomear campos) causam falhas completas são rígidas. Essa distinção é importante porque a capacidade de fazer muitas mudanças depende, em grande parte, da flexibilidade da interface. O mais importante é que podemos ver que **interfaces rígidas dificultam muito** nossa capacidade de iterar rumo a um bom design, como faríamos em outros projetos de software. Isso significa que muitas vezes **ficamos presos** às decisões de design — boas ou ruins. Isso pode levar você a pensar que a rigidez das APIs implica que **nunca poderemos usar um processo de desenvolvimento iterativo**, mas isso **nem sempre é verdade**, graças a outro aspecto importante das interfaces: a **visibilidade**.

Geralmente, podemos dividir a maioria das interfaces em duas categorias: aquelas que os usuários podem ver e interagir (no software, geralmente chamadas de **frontend**) e aquelas que eles não podem ver (geralmente chamadas de **backend**). Por exemplo, podemos ver facilmente a interface gráfica do Facebook ao abrir o navegador; no entanto, **não temos acesso** a como o Facebook armazena nosso grafo social e outros dados. Usando termos mais formais para esse aspecto da visibilidade, podemos dizer que o **frontend** (a parte que todos os usuários veem e interagem) é geralmente considerado **público**, e o **backend** (visível apenas para um grupo interno menor) é considerado **privado**. Essa distinção é importante porque **determina em parte nossa capacidade de fazer mudanças** em diferentes tipos de interface — especialmente nas rígidas, como APIs.

Se fizermos uma mudança em uma interface pública, **o mundo inteiro verá** e poderá ser afetado por ela. Como o público é tão grande, fazer mudanças de forma descuidada pode resultar em usuários irritados ou frustrados. Embora isso certamente se aplique a interfaces rígidas como APIs, também se aplica a interfaces flexíveis da mesma forma. Por exemplo, nos primeiros dias do Facebook, grandes mudanças funcionais ou de design causavam revolta entre estudantes universitários por algumas semanas. <span style="background:#d3f8b6">Mas e se a interface **não for pública**? É um grande problema fazer mudanças em interfaces de backend que só são vistas por membros de um grupo interno privado?</span> Nesse cenário, o número de usuários afetados por uma mudança é **muito menor**, possivelmente limitado a pessoas da mesma equipe ou do mesmo escritório, então parece que **recuperamos um pouco mais de liberdade** para fazer mudanças. Isso é uma ótima notícia, porque significa que **podemos iterar rapidamente** rumo a um design ideal, aplicando **princípios ágeis** ao longo do caminho.
Então, por que APIs são especiais? Acontece que, ao projetarmos muitas APIs (que são **rígidas por definição**) e as compartilharmos com o mundo, estamos realmente diante de um **pior cenário possível** em relação aos dois aspectos. Isso significa que **fazer mudanças é muito mais difícil** do que em qualquer outra combinação dessas duas propriedades (como resumido na **tabela 2.2**).

Simplificando: esse cenário de “**o pior dos dois mundos**” (rígido e difícil de mudar) torna os **padrões de design reutilizáveis e comprovados ainda mais importantes** na construção de APIs do que em outros tipos de software. Enquanto o código geralmente é privado e fora de vista na maioria dos projetos de software, **as decisões de design em uma API são visíveis**, mostradas a todos os usuários do serviço. Como isso **limita seriamente nossa capacidade de fazer melhorias incrementais**, **confiar em padrões existentes que já foram testados ao longo do tempo** é extremamente valioso para **acertar desde o início**, em vez de apenas “acertar eventualmente”, como acontece na maioria dos softwares.

Agora que exploramos algumas das razões pelas quais esses padrões de design são importantes, vamos analisar um padrão de design de API **dissecando-o e explorando seus vários componentes**.


## 2.3 Anatomy of an API design pattern
Como a maioria dos elementos no design de software, os padrões de design de API são compostos por vários **componentes diferentes**, cada um responsável por um aspecto distinto do consumo do próprio padrão. Obviamente, o componente principal foca em como o padrão funciona, mas há outros componentes voltados para os aspectos menos técnicos do consumo de um padrão de design. Esses aspectos incluem descobrir que existe um padrão para um determinado conjunto de problemas, entender se o padrão é adequado para o problema que você está enfrentando e compreender por que o padrão faz as coisas de uma determinada maneira em vez de usar uma alternativa (possivelmente mais simples).

Como essa “lição de anatomia” pode ficar um pouco complicada, vamos imaginar que estamos construindo um serviço que armazena dados e que os clientes desse serviço <span style="background:#d3f8b6">querem uma API pela qual possam extrair seus dados</span>. Vamos usar esse cenário de exemplo para guiar nossa discussão por cada um dos componentes do padrão que exploraremos a seguir, começando pelo início: o nome.

### 2.3.1 Name and synopsis
Cada padrão de design no catálogo possui um nome, atribuído para identificar de forma única o padrão dentro do catálogo. O nome será suficientemente descritivo para transmitir o que o padrão faz, mas não tão longo que seja difícil de gritar em meio a uma sala barulhenta. Por exemplo, ao descrever um padrão que resolve nosso cenário de exemplo de exportação de dados, poderíamos chamá-lo de “Padrão de importação, exportação, backup, restauração, instantâneo e reversão”, mas provavelmente é melhor nomeá-lo como “Padrão de Entrada/Saída” ou simplesmente “Padrão IO”.

Embora o nome por si só geralmente seja suficiente para entender e identificar o padrão, às vezes ele não é suficientemente detalhado para explicar adequadamente o problema que o padrão aborda. Para garantir que haja uma introdução curta e simples ao próprio padrão, haverá também um breve resumo do padrão logo após o nome, que trará uma descrição concisa do problema que ele pretende resolver. Por exemplo, poderíamos dizer que o padrão de entrada/saída **“oferece uma forma estruturada de mover dados para ou a partir de uma variedade de fontes e destinos de armazenamento”.**

Em resumo, o objetivo geral desta seção é facilitar a identificação rápida de se um determinado padrão merece uma investigação mais aprofundada como uma possível solução para um problema específico.

### 2.3.2 Motivation
Como o objetivo de um padrão de design de API é fornecer uma solução para uma categoria de problemas, um bom ponto de partida é a definição do espaço de problema que o padrão pretende cobrir. **Esta seção tem como objetivo explicar o problema fundamental para que seja fácil entender por que precisamos de um padrão para ele em primeiro lugar**. Isso significa que primeiro precisamos de uma declaração de problema detalhada, que geralmente vem na forma de um objetivo focado no usuário. No caso do nosso exemplo de exportação de dados, podemos ter um cenário em que um usuário “deseja exportar alguns dados do serviço para outro sistema de armazenamento externo”.
Depois disso, devemos nos aprofundar um pouco mais nos detalhes do que os usuários desejam realizar. Por exemplo, podemos descobrir que os usuários precisam exportar seus dados para uma variedade de sistemas de armazenamento, não apenas para o S3 da Amazon. <span style="background:#fff88f">Eles também podem precisar aplicar restrições adicionais sobre como os dados são exportados</span>, como se devem ser comprimidos ou <span style="background:#affad1">criptografados antes da transmissão</span>. Esses requisitos terão um impacto direto no próprio padrão de design, portanto é importante que articulemos esses detalhes do problema que estamos abordando com este padrão específico.
Em seguida, uma vez que compreendemos melhor os objetivos do usuário, precisamos explorar os casos extremos que provavelmente surgirão no curso normal da implementação real. Por exemplo, devemos entender como o sistema deve se comportar quando os dados forem muito grandes (e o que significa “muito grande”, já que essas palavras geralmente representam números diferentes para pessoas diferentes). Também devemos explorar como o sistema deve reagir em cenários de falha. Por exemplo, quando uma tarefa de exportação falha, devemos descrever se ela deve ser repetida. Esses cenários incomuns provavelmente serão muito mais comuns do que normalmente esperamos, e mesmo que não precisemos decidir como lidar com cada cenário imediatamente, é fundamental que o padrão registre essas lacunas para que possam eventualmente ser preenchidas por uma implementação.

### 2.3.3 Overview
Agora estamos chegando à parte divertida: explicar o que o padrão de design recomenda como solução para o espaço do problema. Neste ponto, não estamos mais focados em definir o problema, mas sim em oferecer uma descrição de alto nível da solução. Isso significa que começamos a explorar as táticas que usaremos para abordar o problema e os métodos que utilizaremos para isso. Por exemplo, no nosso cenário de exportação de dados, esta seção descreveria os vários componentes e suas responsabilidades, como um componente para descrever os detalhes de quais dados exportar, outro para descrever o sistema de armazenamento que atuará como destino dos dados exportados, e ainda outro para descrever as configurações de criptografia e compressão aplicadas antes de enviar os dados para esse destino.

Em muitos casos, a definição do problema e a lista de requisitos da solução ditarão um esboço geral da solução. Nesses casos, o objetivo da visão geral é articular explicitamente esse esboço, em vez de deixá-lo subentendido a partir da descrição do problema, independentemente de quão óbvia a solução possa parecer. Por exemplo, se estivermos definindo um padrão para pesquisar em uma lista de recursos, parece bastante óbvio ter um parâmetro de consulta; no entanto, outros aspectos (como o formato desse parâmetro ou as garantias de consistência da pesquisa) podem não ser tão óbvios e merecem uma discussão mais aprofundada. Afinal, mesmo soluções óbvias podem ter implicações sutis que valem a pena serem abordadas e, como dizem, o diabo está nos detalhes.

Outras vezes, embora o problema esteja bem definido, pode não haver uma única solução óbvia, mas sim várias opções diferentes, cada uma com seus próprios prós e contras. Por exemplo, <span style="background:#affad1">existem muitas maneiras diferentes de modelar relacionamentos muitos-para-muitos em uma API</span>, cada uma com seus diferentes benefícios e desvantagens; no entanto, é importante que uma API escolha uma opção e a aplique de forma consistente. Em casos como esse, a visão geral discutirá cada uma das diferentes opções e a estratégia empregada pelo padrão recomendado. Esta seção pode conter uma breve discussão sobre os benefícios e desvantagens das outras opções possíveis mencionadas, mas a maior parte dessa discussão será deixada para a seção de compensações no final da descrição do padrão.

### 2.3.4 Implementation
Chegamos à parte mais importante de todo padrão de design: como implementá-lo. Neste ponto, devemos compreender completamente o espaço do problema que estamos tentando resolver e ter uma ideia das táticas e estratégias de alto nível que usaremos para solucioná-lo. A parte mais importante desta seção será **definição da interface em forma de código**, que explicará como seria uma API que utiliza esse padrão para resolver um problema. As definições da API se concentrarão na **estrutura dos recursos** e nas várias formas específicas de interagir com esses recursos. Isso incluirá uma variedade de elementos, como os **campos presentes nos recursos ou nas requisições**, o **formato dos dados** que podem ser inseridos nesses campos (por exemplo, strings codificadas em Base64), bem como **como os recursos se relacionam entre si** (por exemplo, relações hierárquicas).
Em muitos casos, a superfície da API e as definições de campos por si só podem não ser suficientes para explicar como a API realmente funciona. Em outras palavras, embora a estrutura e a lista de campos possam parecer claras, o **comportamento dessas estruturas** e a **interação entre os diferentes campos** podem ser muito mais complexos do que simples e óbvios. Nesses casos, precisaremos de uma discussão mais detalhada sobre esses aspectos não tão evidentes do design. Por exemplo, ao exportar dados, podemos especificar uma forma de **comprimir os dados** antes de enviá-los ao serviço de armazenamento, usando um campo do tipo string para indicar o algoritmo de compressão. Nessa situação, o padrão pode discutir os **valores possíveis para esse campo** (ele pode usar o mesmo formato do cabeçalho HTTP `Accept-Encoding`), o que fazer quando uma **opção inválida for fornecida** (pode retornar um erro), e o que significa quando uma **requisição deixa esse campo em branco** (pode usar compressão padrão com gzip).

Por fim, esta seção incluirá uma **definição de API de exemplo**, com comentários explicando como deve ser uma API que implementa corretamente esse padrão. Isso será definido em código, com comentários explicando os comportamentos dos diversos campos, e se baseará em um **exemplo específico de cenário** que ilustra o problema abordado pelo padrão. Esta seção quase certamente será a **mais longa e detalhada**.

### 2.3.5 Trade-offs
Neste ponto, já entendemos o que um padrão de design nos oferece, mas ainda discutimos o que ele nos tira, o que, na verdade, é bastante importante. Falando de forma direta, pode simplesmente haver coisas que **não são possíveis** se o padrão de design for implementado conforme projetado. Nesses casos, é muito importante entender **quais sacrifícios são necessários** para alcançar os benefícios que vêm ao se confiar em um padrão de design. As possibilidades aqui são bastante variadas, indo desde **limitações funcionais** (por exemplo, é impossível exportar dados diretamente como um download para o usuário em um navegador web), até **complexidade aumentada** (por exemplo, é necessário digitar muito mais para descrever para onde você quer enviar seus dados), e até mesmo aspectos mais técnicos como **consistência de dados** (por exemplo, você pode ver dados que estão um pouco desatualizados, mas não pode saber com certeza). Portanto, a discussão pode variar desde explicações simples até uma exploração detalhada das **limitações sutis** ao se confiar em um determinado padrão de design.

Além disso, embora um determinado padrão de design muitas vezes se encaixe perfeitamente no espaço do problema, certamente haverá cenários em que ele **se encaixa quase perfeitamente, mas não totalmente**. Nesses casos, é importante entender **quais consequências surgirão** ao se confiar em um padrão de design que está nesse ponto único: **não é o padrão errado**, mas **também não é o padrão perfeito**. Esta seção discutirá as consequências de **desalinhamentos sutis** como esse.

Agora que temos uma compreensão melhor de como os padrões de design de API serão estruturados e explicados, vamos mudar de direção e observar **a diferença que esses padrões podem fazer** ao construir uma API que, à primeira vista, parece simples.

## 2.4 Case study: Twapi, a Twitter-like API
Se você não está familiarizado com o Twitter, pense nele como um lugar onde você pode compartilhar mensagens curtas com outras pessoas — só isso. É um pouco assustador pensar que um negócio inteiro é construído com base em todo mundo criando mensagens minúsculas, mas aparentemente isso é suficiente para justificar uma empresa de tecnologia multibilionária. O que não é mencionado aqui é que, mesmo com um conceito extremamente simples, há uma grande complexidade escondida sob a superfície. Para entender melhor isso, vamos começar explorando como seria uma API para o Twitter, que chamaremos de **Twapi**.

### 2.4.1 Visão geral
Com o Twapi, nossa principal responsabilidade é permitir que as pessoas publiquem novas mensagens e visualizem mensagens publicadas por outras pessoas. À primeira vista, isso parece bem simples, mas como você pode imaginar, há algumas armadilhas ocultas das quais devemos estar cientes. Vamos começar assumindo que temos uma chamada de API simples para criar uma mensagem no Twapi. Depois disso, veremos duas ações adicionais que essa API pode precisar realizar: listar muitas mensagens e exportar todas as mensagens para um sistema de armazenamento diferente.

Antes de começarmos, há duas coisas importantes a considerar. Primeiro, esta será apenas uma API de exemplo. Isso significa que o foco permanecerá na **forma como definimos a interface** e não em como a implementação realmente funciona. Em termos de programação, é como dizer que vamos falar apenas sobre a definição da função e **deixar o corpo da função para ser preenchido depois**. Segundo, esta será nossa primeira incursão na análise de uma definição de API. Se você ainda não leu a seção “Sobre este livro”, talvez este seja um bom momento para fazê-lo, para que o formato no estilo TypeScript não seja tão surpreendente.

### 2.4.2 Listando mensagens
Se podemos criar mensagens, parece bastante razoável que vamos querer listar essas mensagens que criamos. Além disso, vamos querer ver as mensagens criadas por nossos amigos e, indo um passo além, talvez queiramos ver uma longa lista de mensagens que seja uma coleção priorizada das mensagens populares dos nossos amigos (algo como um feed de notícias). Vamos começar definindo um método  de API simples para fazer isso, sem depender de nenhum padrão de design.

**SEM PADRÕES DE DESIGN**
Começamos do início, precisamos enviar uma requisição pedindo para listar um monte de mensagens. Para isso, precisamos saber de quem são as mensagens que queremos, o que chamaremos de "parent" (pai ou origem). Em resposta, queremos que nossa API envie de volta uma lista simples de mensagens. Essa interação está ilustrada na figura 2.1.

Agora que entendemos o fluxo envolvido na listagem dessas mensagens, vamos formalizá-lo em uma definição real de API.

```ts
// primeiro, definimos o serviço de API como uma classe abstratas. Essa é simplesmente uma coleção de métodos de API definidos como funções do TypeScript
abstract class Twapi {

	// Podemos usar variáveis estáticas do TypeScript para armazenar metadados sobre a API, como o nome ou a versão.
  static version = "v1"; 
  static title = "Twapi API";

	// Aqui contamos com funções especiais de wrapper paraa definir o método HTTP (GET) e o padrão de URL (/users/<user-id>/messages) que devem ser mapeados para essa função.
  @get("/{parent-users}/**/messages")
  ListMessages(req: ListMessagesRequest): ListMessagesResponse;
}

interface ListMessagesRequest {
  parent: string;
}

interface ListMessagesResponse {
  messages: string[];
}
```

Como podemos ver, essa definição de API é bem simples. Ela aceita um único parâmetro e retorna uma lista de mensagens correspondentes. Mas vamos imaginar que implantamos isso com nossa API.

À medida que mais e mais pessoas usam o serviço, essa lista de mensagens pode começar a ficar **muito longa**. Isso pode não ser um grande problema quando as respostas têm dezenas ou centenas de mensagens, mas e quando começamos a entrar na casa dos milhares, centenas de milhares ou até milhões? Uma única resposta HTTP contendo 500.000 mensagens, com cada mensagem tendo até 140 caracteres, pode significar até **70 megabytes de dados**! Isso parece bastante pesado para um usuário comum de API lidar, sem mencionar o fato de que uma única requisição HTTP fará com que os servidores de banco de dados do Twapi enviem 70 megabytes de dados.

Então, o que podemos fazer? A resposta óbvia é permitir que a API divida respostas muito grandes em partes menores e permita que os usuários solicitem todas as mensagens em blocos, uma de cada vez. Para fazer isso, podemos recorrer ao padrão de paginação.

**Pagination Pattern**
Como veremos no capítulo 25, o padrão de paginação é uma forma de recuperar uma longa lista de itens em partes menores e mais gerenciáveis, em vez de enviar a lista inteira de uma só vez. Esse padrão depende de campos adicionais tanto na requisição quanto na resposta; no entanto, eles devem parecer bastante simples. O fluxo geral desse padrão é mostrado abaixo...

1. Me retorne a lista de mensagens? Aqui está a página 1. The next page is page 2.
2. Me retorne a página 2? Aqui está a página 2, a próxima página é a página 3.
3. Pode me retornar a página 3? Aqui está. Não há mais páginas...

```java
public abstract class Twapi {
	public static final String VERSION = "v1";
	public static final String TITLE = "Twapi API";

	// Simulação de uma anotação para rota GEDT
	@GetMapping("/{parent}/messages")
	public abstract ListMessagesResponse listMessages(ListMessagesRequest req);
}

public class ListMessagesRequest {
    private String parent;
    private String pageToken;
    private Integer maxPageSize; // Usamos Integer para permitir null (opcional)

    // Getters e Setters
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(Integer maxPageSize) {
        this.maxPageSize = maxPageSize;
    }
}

import java.util.List;

public class ListMessagesResponse {
    private List<Message> results;
    private String nextPageToken;

    // Getters e Setters
    public List<Message> getResults() {
        return results;
    }

    public void setResults(List<Message> results) {
        this.results = results;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}

public class Message {
    // Defina os campos conforme necessário
}

```

**O que acontece se não começarmos com o padrão?**
Com essas pequenas alterações no serviço de API, na verdade montamos um método de API capaz de suportar um aumento repentino no número de mensagens Twapi postadas. Mas isso deixa uma pergunta óbvia sem resposta: por que eu deveria me preocupar em seguir esse padrão desde o início? Por que não simplesmente adicionar esses campos mais tarde, quando o problema surgir? Em outras palavras, por que consertar algo que ainda não está quebrado?

Como veremos mais adiante, ao explorarmos a compatibilidade retroativa, a razão é simples: evitar que softwares existentes deixem de funcionar.

Neste caso, mudar de um design original mais simples (que envia todos os dados em uma única resposta) para depender do padrão de paginação (dividindo os dados em partes menores) pode parecer uma mudança inofensiva, mas na verdade causaria mau funcionamento em softwares já existentes. **O código antigo esperaria que todos os dados solicitados viessem em uma única resposta, e não em partes**.

Como resultado, surgem dois grandes problemas:
1. Como o software anterior espera que todos os dados venham em uma única requisição, ele não tem como acessar os dados que aparecem nas páginas seguintes. Ou seja, o código escrito antes da mudança fica limitado apenas ao primeiro bloco de dados.
2. Como os consumidores existentes não sabem como obter os blocos adicionais de dados, ficam com a impressão de que receberam tudo, mesmo tendo apenas uma pequena parte. Esse mal-entendido pode levar a erros difíceis de detectar. Por exemplo, ao tentar calcular uma média de valores, o consumidor pode obter um resultado aparentemente correto, mas que na verdade é apenas a média do primeiro bloco de dados. **Isso provavelmente levará a um valor incorreto, mas sem gerar um erro evidente. Como consequência, esse bug pode passar despercebido por muito tempo.**

Agora que vimos o exemplo de listagem de mensagens, vamos explorar por que pode ser vantajoso usar um padrão de design ao exportar dados.

### 2.4.3 Exporting data
Em algum momento, os usuários do serviço Twapi podem querer a capacidade de exportar todas as suas mensagens. Assim como na listagem de mensagens, devemos considerar que a quantidade de dados a ser exportada pode se tornar bastante grande (possivelmente centenas de MB). Além disso, diferentemente da listagem, devemos levar em conta que pode haver muitos sistemas de armazenamento diferentes no destino desses dados, e o ideal seria termos uma forma de integrar com novos sistemas conforme eles se tornem populares.

Além disso, pode haver várias transformações que desejamos aplicar aos dados antes da exportação, como criptografar, comprimir ou anonimizar partes específicas conforme necessário. Por fim, tudo isso provavelmente não funcionará bem de forma síncrona, o que significa que precisamos de uma maneira de expressar que há um trabalho pendente (ou seja, a exportação dos dados) sendo executado em segundo plano, permitindo que o consumidor acompanhe o progresso.

Vamos começar criando uma implementação simples para essa API e analisar alguns dos problemas que podem surgir no futuro.

**With no design pattern**
Como mencionado, temos algumas preocupações principais: grandes volumes de dados, o destino final dos dados, as diversas transformações ou configurações (como compressão ou criptografia) e, por fim, a natureza assíncrona da API.

Como estamos apenas tentando lançar uma API básica para exportar mensagens do Twapi, a opção mais simples que cobre a maioria desses fatores é acionar a geração de um arquivo compactado que poderá ser baixado futuramente. Em resumo, quando alguém faz uma requisição para essa API, a resposta não contém os dados em si. Em vez disso, ela traz um ponteiro para onde os dados poderão ser baixados em algum momento no futuro.
```java
import java.util.Objects;

// Simulação de uma anotação POST (estilo Spring)
@interface Post {
    String value();
}

public abstract class Twapi {

    public static final String VERSION = "v1";
    public static final String TITLE = "Twapi API";

    @Post("/{parent}/messages:export")
    public abstract ExportMessagesResponse exportMessages(ExportMessagesRequest req);

    // Classe interna representando a requisição
    public static class ExportMessagesRequest {
        // O usuário pai das mensagens a serem exportadas
        private String parent;

        public ExportMessagesRequest() {}

        public ExportMessagesRequest(String parent) {
            this.parent = parent;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "ExportMessagesRequest{parent='" + parent + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ExportMessagesRequest)) return false;
            ExportMessagesRequest that = (ExportMessagesRequest) o;
            return Objects.equals(parent, that.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent);
        }
    }

    // Classe interna representando a resposta
    public static class ExportMessagesResponse {
        // Localização do arquivo compactado contendo as mensagens solicitadas
        private String exportDownloadUri;

        public ExportMessagesResponse() {}

        public ExportMessagesResponse(String exportDownloadUri) {
            this.exportDownloadUri = exportDownloadUri;
        }

        public String getExportDownloadUri() {
            return exportDownloadUri;
        }

        public void setExportDownloadUri(String exportDownloadUri) {
            this.exportDownloadUri = exportDownloadUri;
        }

        @Override
        public String toString() {
            return "ExportMessagesResponse{exportDownloadUri='" + exportDownloadUri + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ExportMessagesResponse)) return false;
            ExportMessagesResponse that = (ExportMessagesResponse) o;
            return Objects.equals(exportDownloadUri, that.exportDownloadUri);
        }

        @Override
        public int hashCode() {
            return Objects.hash(exportDownloadUri);
        }
    }
}
```

Essa API realmente realiza a tarefa principal (exportar os dados) e também algumas tarefas secundárias (como recuperação assíncrona), mas deixa de atender a alguns aspectos importantes.

Primeiro, não temos como definir configurações adicionais sobre os dados envolvidos. Por exemplo, não tivemos a chance de escolher o formato de compressão ou as chaves e o algoritmo a serem usados na criptografia dos dados

Em seguida, não conseguimos escolher o destino final dos dados. Em vez disso, simplesmente recebemos uma indicação de onde poderíamos encontrá-los futuramente.

Por fim, ao analisarmos mais de perto, fica claro que a natureza assíncrona da interface é apenas parcialmente útil: embora o serviço retorne de forma assíncrona um local de onde os dados podem ser baixados, não há como monitorar o progresso da operação de exportação, nem como abortá-la caso o usuário perca o interesse nos dados.

**Padrão de Importação/Exportação**
Como veremos no capítulo 28, o padrão de importação/exportação é voltado para problemas como este: temos uma certa quantidade de dados em nosso serviço de API e os consumidores querem uma forma de obter esses dados (ou inseri-los). No entanto, diferente do padrão de paginação que discutimos anteriormente, esse padrão depende de outros, como o padrão de operações de longa duração (discutido no capítulo 13), para funcionar corretamente.

Vamos começar definindo a API e depois analisar mais de perto como cada parte funciona em conjunto. Assim como antes, tenha em mente que não entraremos em todos os detalhes de cada aspecto do padrão, mas tentaremos oferecer uma visão geral dos elementos relevantes.

```java
public class Twapi {

    // Versão da API
    public static final String VERSION = "v1";

    // Título da API
    public static final String TITLE = "Twapi API";

    /**
     * Método que simula a exportação de mensagens.
     * Este método representa uma operação assíncrona que retorna um objeto Operation,
     * contendo a resposta e os metadados da exportação.
     */
    public Operation<ExportMessagesResponse, ExportMessagesMetadata> exportMessages(ExportMessagesRequest req) {
        // Aqui você iniciaria a operação de exportação e retornaria um identificador de operação.
        // Para fins de exemplo, vamos apenas retornar um objeto fictício.
        ExportMessagesMetadata metadata = new ExportMessagesMetadata(0); // progresso inicial
        ExportMessagesResponse response = new ExportMessagesResponse(req.outputConfig);
        return new Operation<>(response, metadata);
    }

    // Classe que representa a requisição de exportação
    public static class ExportMessagesRequest {
        // Identificador do usuário cujas mensagens serão exportadas
        public String parent;

        // Configuração de saída (destino, compressão, criptografia)
        public MessageOutputConfig outputConfig;

        public ExportMessagesRequest(String parent, MessageOutputConfig outputConfig) {
            this.parent = parent;
            this.outputConfig = outputConfig;
        }
    }

    // Classe que define como os dados devem ser exportados
    public static class MessageOutputConfig {
        public Destination destination;
        public CompressionConfig compressionConfig; // opcional
        public EncryptionConfig encryptionConfig;   // opcional

        public MessageOutputConfig(Destination destination,
                                   CompressionConfig compressionConfig,
                                   EncryptionConfig encryptionConfig) {
            this.destination = destination;
            this.compressionConfig = compressionConfig;
            this.encryptionConfig = encryptionConfig;
        }
    }

    // Classe que representa a resposta da exportação
    public static class ExportMessagesResponse {
        public MessageOutputConfig outputConfig;

        public ExportMessagesResponse(MessageOutputConfig outputConfig) {
            this.outputConfig = outputConfig;
        }
    }

    // Metadados da operação de exportação
    public static class ExportMessagesMetadata {
        // Percentual de progresso da operação (0 a 100)
        public int progressPercent;

        public ExportMessagesMetadata(int progressPercent) {
            this.progressPercent = progressPercent;
        }
    }

    // Classe genérica que representa uma operação assíncrona
    public static class Operation<TResponse, TMetadata> {
        public TResponse response;
        public TMetadata metadata;

        public Operation(TResponse response, TMetadata metadata) {
            this.response = response;
            this.metadata = metadata;
        }
    }

    // Classes auxiliares (simuladas) para destino, compressão e criptografia
    public static class Destination {
        // Exemplo: caminho do arquivo, bucket de armazenamento, etc.
    }

    public static class CompressionConfig {
        // Exemplo: tipo de compressão (gzip, zip, etc.)
    }

    public static class EncryptionConfig {
        // Exemplo: chave de criptografia, algoritmo, etc.
    }
}
```

Primeiro, ao depender de uma interface encapsulada de configuração de saída, conseguimos aceitar diversos parâmetros no momento da requisição e reutilizar esse mesmo conteúdo na resposta como uma forma de confirmação para o consumidor.

Em seguida, dentro dessa configuração, conseguimos definir várias opções diferentes de configuração, que veremos com mais detalhes na listagem 2.5.

Por fim, conseguimos acompanhar o progresso da operação de exportação usando as informações de metadados da operação de longa duração, que armazenam o progresso da operação como uma porcentagem (0% significando “não iniciado” e 100% significando “concluído”).

Dito isso, você pode ter notado que alguns dos blocos de construção usados na definição anterior da API não foram definidos. Vamos agora definir exatamente como eles são, oferecendo também alguns exemplos de configuração.

compressionLevel: number; } interface EncryptionConfig { // Todos os tipos de configuração de criptografia // podem ser definidos aqui, ou essa interface pode ser // estendida da mesma forma que CompressionConfig. }

Aqui podemos ver as várias formas de definir as opções de configuração, como os destinos dos dados ou como os dados devem ser comprimidos. A única coisa que falta é entender exatamente como funciona essa parte de operação de longa duração.

Exploraremos esse padrão com muito mais profundidade no capítulo 28, mas por enquanto, vamos apenas apresentar uma definição simples de API para essas interfaces, de modo que tenhamos pelo menos uma compreensão geral do que elas fazem.


**O que acontece se não começarmos com o padrão?**
Diferente do exemplo anterior, onde as abordagens com e sem padrão pareciam bastante semelhantes, neste cenário as duas opções diferem significativamente na superfície da API resultante. Como resultado, a resposta para essa pergunta é clarA: se precisarmos da funcionalidade oferecida (como diferentes destinos de exportação, configurações separadas, etc.), começar com uma abordagem sem padrão resultará em **mudanças quebráveis** para os consumidores.

Ao iniciar com uma abordagem orientada por padrão para esse problema, **a API evolui de forma suave e compatível à medida que novas funcionalidades são necessárias**.

