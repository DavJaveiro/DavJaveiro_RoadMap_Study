A história dos serviços web é uma jornada fascinante através da evolução das formas pelas quais os sistemas são construídos, distribuídos e dimensionados.

Inicialmente, a abordagem monolítica, que envolvia desenvolver tudo dentro de uma única aplicação e máquina, foi o método arquitetural padrão por muitos anos. Contudo, a necessidade de dividir o software em componentes distintos com responsabilidades separadas transformou a maneira como projetamos e implementamos sistemas.

A necessidade de integrar sistemas distribuídos compostos por softwares executando em máquinas distintas existe desde os primórdios da computação, e sua importância está aumentando, à medida que a forma como desenvolvemos software evolui dos monólitos em direção a arquiteturas mais distribuídas.

A disseminação global da internet, especialmente da World Wide Web, trouxe a padronização de protocolos de comunicação, como o Internet Protocol (IP), Transmission Control Protocol (TCP) e Hypertext Transfer Protocol (HTTP). O sucesso da WWW e seu suporte por diferentes dispositivos, sistemas operacionais e aplicações levou à ideia de que a infraestrutura da web poderia ser usada para conectar aplicações em geral. Foi nesse momento que o termo web services passou a ser adotado para designar o uso de tecnologias web na criação de APIs.

Neste livro, você adquirirá os conhecimentos necessários para estar pronto para desenvolver e dominar a criação de web services RESTful, partindo dos conceitos até a implementação completa, seguindo as melhores práticas do mercado.

Vamos iniciar compreendendo o que é a arquitetura Representational State Transfer (REST) e os serviços RESTful API, como esses termos diferem entre si, os princípios, níveis de maturidade e diretrizes, bem como o projeto que criaremos ao longo destes capítulos para aplicar esse conhecimento.

O seguintes tópicos serão abordados neste capítulo:
- Por que REST?
- Princípios da arquitetura REST
- Níveis de um API RESTful
- Representação de dados com JavaScript Object Notation (JSON)
- A importância de diretrizes para o desenvolvimento de APIs REST
- Casos de uso comuns de APIs REST
- Impacto da arquitetura no design de APIs REST
- Alternativas ao REST

## Why REST?
Para entender por que o REST é o estilo arquitetural dominante na maioria dos serviços web, precisamos compreender o que estava disponível antes da ascensão do REST e os desafios que tornaram essa mudança tão importante na forma como os serviços distribuídos são construídos. 

## The pre-REST era
Antes do REST, o cenário de serviços web era dominado por protocolos como o Simple Object Access Protocol (SOAP) e o Extensible Markup Language-Remote Procedure Call (XML-RPC). Esses eram padrões poderosos, mas complexos, que permitiam uma comunicação detalhada entre clientes e servidores. No entanto, frequentemente eram vistos como inconvenientes devido à sua natureza verbosa e aos requisitos rígidos impostos aos desenvolvedores.

O SOAP, por exemplo, exigia que os desenvolvedores escrevessem extensos documentos XML com chamadas e respostas específicas. Tornou-se notório por sua complexidade e dificuldade de depuração. Da mesma forma, o XML-RPC, embora mais simples que o SOAP, ainda envolvia uma sobrecarga significativa para requisições e respostas simples (por exemplo, formatação XML verbosa e complexa, serialização e desserialização, um protocolo baseado em texto e complexidade de análise sintática). Tanto o SOAP quanto o XML-RPC utilizavam o protocolo HTTP apenas como meio de transporte, duplicando, cada um à sua maneira, diversas funcionalidades já oferecidas pelo próprio protocolo HTTP e suportadas pela infraestrutura web existente. 

Para superar esses desafios e melhorar a forma como os sistemas se comunicam entre si, o REST foi criado e tem sido amplamente implementado desde a sua concepção.

## Understanding REST
O REST foi criado em 2000 por Roy Fielding em sua tese de doutorado. Eles propôs um novo jeito de construir serviços web que fossem mais simples, eficiente e escalável, em comparação com tecnologias antigas como SOAP e XML-RPC.

O REST aproveita o protocolo HTTP da forma como ele foi planejado, usando métodos como GET, POST, códigos de status, cache, etc. - para tornar a comunicação entre sistemas mais natural e alinhada com a própria estrutura da web.

Os **princípios fundamentais do REST** são:
- Sem estado (statelessness): cada requisição contém todas as informações necessárias;
- Interface uniforme: padronização na forma como os recursos são acessados.
- Cacheável: respostas podem ser armazenadas para melhorar o desempenho.
- Arquitetura cliente-servidor: separação entre interface e lógica de negócios. 

Quando uma API web segue todos esses princípios, ela é chamada de **RESTful API**.
Ou seja:
REST = estilo arquitetural
RESTful API = uma API que implementa corretamente esse estilo


## Unpacking RESTful
As APIs RESTful representam uma abordagem para projetar serviços web que seguem os princípios do REST, portanto, **não são a mesma coisa**.

Enquanto o REST fornece o **framework teórico** para a construção de sistemas escaláveis e interoperáveis, as APIs RESTful colocam esses princípios em prática, permitindo que os desenvolvedores criem APIs robustas, flexíveis, fáceis de entender, manter e estender.

A introdução das APIs RESTful marcou uma mudança significativa no cenário de serviços web, já que os desenvolvedores adotaram rapidamente o REST devido à sua simplicidade e á forma como facilitou o desenvolvimento de aplicações web escaláveis e com bom desempenho. As APIs RESTful tornaram-se a espinha dorsal da comunicação web, impulsionando desde plataformas de mídias sociais até sites de comércio eletrônico.

Agora que temos uma compreensão clara de REST e RESTful, vamos nos aprofundar nos princípios da arquitetura REST. Isso nos dará uma visão mais clara desses princípios fundamentais e de como implementá-los.

## Principles of REST architecture
Imagine um sistema de bibliotecas onde cada livro é um recurso identificado por um número ISBN - esse é o URI (identificação do recurso).
Quando desejamos pegar um livro emprestado, recebe uma representação do recurso (como uma ficha com título, autor, etc.). 
Essa ficha vem com instruções claras sobre como proceder (exÇ "apresente no balcão"), isso representa **mensagens auto-descritivas**.
Além disso, o catálogo da biblioteca sugere que outros livros do mesmo autor ou da mesma categoria, isso simula o **HATEOAS**, guiando-nos para próximos passos com base no estado atual da aplicação.

Em resumo, a interface uniforme torna as APIs RESTful previsíveis, padronizadas e fáceis de usar, porque todos os recursos são acessados e manipulados da mesma forma, seguindo convenções claras e bem definidas.

## Client-server separation
Esse princípio promove a separação de responsabilidades ao dividir as preocupações da interface do usuário das preocupações com o armazenamento de dados. Essa separação permite que os componentes cliente e servidor evoluam independentemente, resultando em uma arquitetura de aplicação mais flexível e escalável.
![image-20259718969.png](RESTful%20Web%20Services%20with%20Java/Part%20I%20-%20Steps%20to%20a%20Great%20API/Chapter%201-%20Understanding%20RESTful%20Core%20Concepts/1%20-%20Understanding%20RESTful%20Core%20Concepts/image-20259718969.png)
**Exemplo:** um usuário envia um formulário em um site com seus dados para finalizar uma compra (cliente enviando a requisição); esse envio será feito no formato **JSON**, utilizando o verbo HTTP POST, e será recebido pelo servidor. O servidor receberá os dados, criará um novo recurso com as informações do cliente, armazenará esses dados, realizará um novo pedido e retornará ao usuário uma resposta apropriada (por exemplo, um código de status HTTP 201 Created e os detalhes do pedido criado).

Esse fluxo ilustra claramente a separação entre cliente e servidor: o cliente se preocupa apenas com a interface e envio dos dados, enquanto o servidor lida com a lógica de negócio, persistência e resposta, ambos podendo ser desenvolvidos e atualizados independentemente, desde que a interface (API) permaneça compatível.

## Statelessness
Em um serviço RESTful, cada requisição de um cliente para um servidor deve conter todas as informações que o servidor precisa para atender à requisição. O servidor não armazena nenhum estado de sessão sobre o cliente, o que significa que cada requisição é independente e isolada. 

**Exemplo:** cada vez que solicitamos um café em uma cafeteria, fornecemos todos os detalhes do pedido. O barista não precisa lembrar dos seus pedidos anteriores; eles simplesmente prepara o café com base apenas no pedido atual.

## Cacheability
As respostas devem, de forma implícita ou explícita, definir se são cacheáveis ou não. Isso ajuda a melhorar a eficiência da rede ao reduzir as interações entre cliente e servidor para recursos solicitados com frequência.

Vale notar que o uso de cache traz o risco de o cliente visualizar uma versão desatualizada do recurso, especialmente se ele muda com frequência. <mark style="background: #FFB86CA6;">No entanto, muitas vezes aceitamos esse risco em troca de uma performance melhor. </mark>
**Exemplo:** um recurso solicitado milhares de vezes por dia é elegível para caching, já que isso reduzirá drasticamente o uso de recursos do banco de dados (DB) e melhorará o tempo de resposta. 

## Layered System
Uma arquitetura RESTful pode consistir em hierarquias em camadas, que podem incluir **load balancers, caches ou authentication gateways**. Esse sistema em camadas garante que um cliente normalmente não consiga distinguir se está conectado diretamente ao servidor final ou a um intermediário no caminho. O sistema em camadas é uma das principais restrições da arquitetura RESTful e oferece diversos benefícios:
- **Modularidade:** o sistema em camadas permite organizar sua aplicação em camadas lógicas, cada uma com um papel e responsabilidade específicos. Isso torna o sistema mais fácil de entender, desenvolver e manter.
- **Separação de responsabilidades:** cada camada pode focar em suas próprias tarefas. Por exemplo, uma camada de #authentication pode lidar com todos os aspectos de autenticação e nada mais. Essa separação de responsabilidades leva a um código mais limpo e fácil de manter.
- **Intercambiabilidade:** se uma camada for projetada e implementada de forma modular, ela pode ser substituída ou atualizada sem afetar as outras camadas. Isso é especialmente útil quando se deseja atualizar ou melhorar uma parte específica do sistema.
- **Escalabilidade:** é possível escalar diferentes camadas de forma independente, com base em sua carga e requisitos de desempenho. Por exemplo, se a nossa camada de aplicação estiver enfrentando uma carga elevada, podemos adicionar mais servidores a essa camada sem precisar escalar a camada de banco de dados. 
- **Segurança:** ao segmentar o sistema em camadas, é possível aplicar controles de segurança apropriados a cada uma delas. Por exemplo, podemos colocar um firewall entre as camadas para controlar o tráfego e proteger camadas sensíveis contra possíveis ataques.

**Exemplo:** quando enviamos uma carta, ela passa por vários escritórios postais (camadas) antes de chegar ao destino. Da mesma forma, uma requisição RESTful pode passar por verificações de segurança e **load balancers** sem que o cliente tenha conhecimento disso. 

## Code on demand
Os servidores podem estender a funcionalidade do cliente transferindo **código executável**. Essa é uma funcionalidade opcional que é usada com moderação no contexto de APIs, pois é difícil de implementar de forma confiável e segura.

**Exemplo:** uma aplicação web pode solicitar que o navegador baixa e execute um **calendar widget**. O widget é um trecho de código executável que estende a funcionalidade do navegador.

Agora que entendemos os princípios da arquitetura REST, vamos aprender como alcançar a excelência em uma API RESTful por meio dos níveis explicados pelo **Richardson Maturity Model**

## Level of a RESTful API
Uma forma de entender o conceito de **RESTfulness** é por meio do Richardson Maturity Model, que descreve vários níveis de conformidade com os princípios REST no design de APIs.

O modelo consiste em **quatro níveis**, cada um representando uma progressão rumo a um design mais RESTful:
![image-2025983652343.png](RESTful%20Web%20Services%20with%20Java/Part%20I%20-%20Steps%20to%20a%20Great%20API/Chapter%201-%20Understanding%20RESTful%20Core%20Concepts/1%20-%20Understanding%20RESTful%20Core%20Concepts/image-2025983652343.png)

**Level 0 - the swamp of Plain Old XML (POX)**: Neste nível, as APIs são caracterizadas por um único URI para todas as operações, normalmente utilizando requisições HTTP POST. Os payloads são frequentemente baseados em XML, e não há distinção entre diferentes tipos de recursos ou métodos HTTP. Esse nível carece dos princípios fundamentais do REST, como a identificação de recursos e a separação de responsabilidades.

**Level 1 - resources:** este nível introduz o conceito de resources, onde cada entidade no sistema é representada um URI único. No entanto, os métodos HTTP não são totalmente utilizados, e as operações são geralmente realizadas por meio de uma combinação de requisições HTTP POST e GET.
Embora os resources sejam identificados, a API ainda carece de uma interface uniforme e da previsibilidade associadas ao design RESTful.

Este nível já apresenta um avanço em relação ao Nível 0, pois começa a tratar entidades como recursos distintos.

**Level 2 - HTTP verbs**: Neste nível, as APIs começam a utilizar os métodos HTTP - GET, POST, PUT, DELENTE, para realizar as operações CRUD (Create, Read, Update, Delete) sobre os #resources.

Cada método HTTP corresponde a uma ação específica, oferecendo uma interface mais intuitiva e padronizada para interagir com a API. No entanto, os **hypermedia links** ainda estão ausentes, o que limita a **descobribilidade e a flexibidade** da API. 

**Level 3 - Hypermedia controls (HATEOAS)**: o nível mais alto de RESTfulness, o nível 3, introduz o conceito de HATEOAS (Hypermedia As The Engine of Application State). Além de utilizar os métodos HTTP, APIs RESTful nesse nível incluem **hypermedia links** nas respostas, permitindo que os clientes naveguem pela API de forma dinâmica.

Ao fornecer links para recursos e ações relacionadas, o #HATEOAS reduz o acoplamento entre cliente e servidor, aumentando a **flexibilidade** e a escalabilidade.

Cada nível do Richardson Maturity Model representa uma progressão rumo a um design mais RESTful. 

**Exemplo sobre o HATEOAS:** imagine que realizamos uma requisição para obter os dados de um cliente. Uma resposta tradicional em JSON seria algo assim:
```json
{
	"nome": "Leandro"
}
```

Com HATEOAS, a resposta incluiria também links úteis:
```JSON
{
  "nome": "Leandro",
  "links": [
    {
      "rel": "self",
      "href": "http://api.exemplo.com/clientes/1"
    },
    {
      "rel": "pedidos",
      "href": "http://api.exemplo.com/clientes/1/pedidos"
    }
  ]
}
```

Esses links dizem ao cliente: "Aqui está o recurso atual, e aqui estão os próximos passos que podemos seguir." Isso torna a navegação **dinâmica e adaptável,** reduz o acoplamento entre cliente e servidor, e melhora a escalabilidade.

## Representando dados com JSON
JSON é um formato de dados simples, projetado para facilitar a leitura e escrita por humanos, ao mesmo tempo em que é direto para máquinas processarem e criarem. 
Um pequeno detalhe que pode passar despercebido por usuários humanos é que o JSON não suporte comentários.
Ele é baseado em um subconjunto da linguagem de programação JavaScript e é completamente independente de linguagem, com parses disponíveis para praticamente todas as linguagens de programação. 

Um documento JSON é construído a partir de duas estruturas:
- **Uma coleção de pares nome/valor:** em várias linguagens, isso é implementado como um object, record, struct, dictionary, hash table, keyed list ou associative array.
- **Uma lista ordenada de valores:** na maioria das linguagens, isso é implementado como um **array**, vector, list ou sequence.

Aqui está um exemplo simples de um documento JSON para um objeto book:
```java
{
  "book": {
    "title": "Mastering RESTful JSON Essentials",
    "author": "Multiple Authors",
    "published": true,
    "edition": 1,
    "tags": ["programming", "web", "json"]
  }
}
```

O valor do campo **book** é uma estrutura de **object** contendo pares nome/valor. O valor do campo **tags** é uma lista de valores sem nome.

**Por que JSON é preferido em APIs RESTful?**
JSON e XML são ambos formatos usados para troca de dados, mas possuem características distintas que podem tornar um mais adequado que o outro em determinadas aplicações, especialmente em **APIs RESTful**.

Motivos do JSON ser preferido:
- **Performance**: a natureza leve do JSON permite que ele seja **parseado** mais rapidamente do que o XML, o que é crucial para o desempenho de APIs RESTful.
- **Simplicidade:** a sintaxe mais simples do JSON facilita a leitura, escrita, parsing e geração programática.
- **Compatibilidade com a Web:** pode ser compatível com **JavaScript** e por o desenvolvimento web moderno depender fortemente dessa linguagem, o JSON se alinha bem com as tecnologias da web.

Embora tanto JSON quanto XML tenham seu espaço, a eficiëncia, simplicidade e afinidade com a web tornam o JSON a escolha preferida de muitos devs para o desenvolvimento de APIs RESTful.

Além disso, existem formatos binários estruturados para troca de dados, como o ProtoBuf, que oferecem desempenho superior ao JSON por eliminarem a necessidade de text #parsing. No entanto, esses formatos binários não são tão amplamente utilizados nem tão universalmente suportados.

Como mostrado anteriormente, em serviços RESTful, o JSON desempenha um papel crucial como meio de troca de dados. O REST não prescreve nenhuma linguagem específica para representar os dados dos recursos. No entanto, graças à sua facilidade de uso e suporte ubíquo, o JSON é a escolha natural para a maioria das APIs RESTful.

Quando os clientes fazem requisições aos servidores, eles podem enviar JSON no corpo da requisição. O servidor então processa esse JSON, realiza as operações necessárias e também pode retornar JSON no corpo da resposta. Esse formato consistente permite uma troca de dados clara e estruturada.

A funcionalidade do JSON em serviços REST inclui:
- **Serialização:** converter um objeto em uma string JSON para enviá-lo pela rede. Por exemplo:
```java
String serializedJson = objectMapper.writeValueAsString(bookDetails);
```

- **Desserialização:** converter uma string JSON recebida pela rede em um objeto. Por exemplo:
```java
BookDetails bookDetails = objectMapper.readValue(json, BookDetails.class);
```

- **Troca de dados:** atuar como meio de intercâmbio de dados entre cliente e servidor.

Esses exemplos mostram o uso do **ObjectMapper** da biblioteca #Jackson para serializar e desserializar JSON, com base no exemplo do livro apresentado anteriormente nesta seção. Essa biblioteca já está incluída no framework Spring Web, mas também pode ser importada separadamente, se necessário. 

Vimos a importância do JSON e a mudança que ele trouxe em comparação ao anteriormente utilizado XML. Agora, aprenderemos um dos passos cruciais para dominar o desenvolvimento de ótimas APIs REST: seguir diretrizes bem estabelecidas.

## A importância das diretrizes em APIs REST
As diretrizes funcionam como um roteiro para os desenvolvedores, delineando boas práticas e padrões que devem ser seguidos durante o processo de desenvolvimento de uma API. Elas são um conjunto de regras que visam evitar erros comuns e promover a excelência no design de APIs. Aqui estão alguns dos aspectos mais importantes de seguir diretrizes bem estabelecidas:
- - **Consistência e previsibilidade**: Os desenvolvedores garantem um nível de consistência que torna as APIs previsíveis e mais fáceis de entender. Essa uniformidade é essencial tanto para os desenvolvedores que criam as APIs quanto para os usuários que as consomem.
- - **Interoperabilidade**: As diretrizes geralmente enfatizam o uso de protocolos e formatos de dados padrão, o que promove a interoperabilidade entre diferentes plataformas e tecnologias. Isso é especialmente importante em um ecossistema diverso, onde as APIs atuam como ponte entre vários componentes de software.
- - **Escalabilidade**: APIs bem projetadas que seguem diretrizes têm maior probabilidade de serem escaláveis, lidando com cargas crescentes e acomodando o crescimento sem exigir grandes reformulações ou refatorações.
- - **Segurança**: Este é um aspecto fundamental no desenvolvimento de APIs, e as diretrizes fornecem estratégias para proteger as APIs contra ameaças comuns, garantindo a segurança de dados e serviços sensíveis.

## Relevância de mercado ao seguir diretrizes
A adesão às diretrizes tem impacto direto no mercado. APIs bem projetadas que seguem boas práticas podem gerar os seguintes resultados:
- Adoção aumentada: APIs fáceis de entender e integrar podem rapidamente ganhar popularidade entre desenvolvedores, levando à ampla adoção e a uma base de usuários maior.
- Interoperabilidade aprimorada: Em mercados como o da saúde, onde o compartilhamento de dados é vital, as diretrizes garantem que diferentes sistemas possam se comunicar de forma eficaz, melhorando o atendimento ao paciente e a eficiência operacional.
- Conformidade regulatória: Especialmente em setores regulados, seguir diretrizes ajuda as organizações a cumprir normas legais, evitando penalidades e promovendo confiança entre os stakeholders.


**Casos de uso comuns de APIs REST**
A seguir, exploramos alguns casos de uso comuns para APIs REST com exemplos que ilustram suas aplicações práticas:

- **Integração com serviços de terceiros**: Sincronização de dados entre diferentes plataformas, como sistemas de **CRM** e **ERP**
- **Serviços de redes sociais**: Habilitação de interações sociais e compartilhamento de conteúdo em diversas plataformas
- **Transações de e-commerce**: Gerenciamento de listagens de produtos, pedidos e pagamentos
- **Internet das Coisas (IoT)**: Conexão e controle remoto de dispositivos inteligentes
- **Monitoramento de saúde e fitness**: Agregação de dados de diversos dispositivos de saúde e bem-estar.

## Impacto da arquitetura no design de APIs REST
A necessidade de projetar e implementar APIs pode surgir em diversos contextos. O objetivo que se deseja alcançar com uma API e o papel que ela desempenha dentro da arquitetura da aplicação ou sistema em desenvolvimento influenciam a importância relativa dos diversos aspectos descritos nos capítulos deste livro.

Essa combinação única de aspectos arquiteturais também impacta a escolha de abordagens e técnicas para implementar APIs.

As seções seguintes apresentam os padrões mais comuns.

**APIs públicas entre organizações**

As **APIs** consumidas além dos limites organizacionais estão mais próximas da aplicação original das tecnologias web.

Controlar todos os **clientes da API** é inviável. **APIs públicas** com inúmeros consumidores independentes frequentemente priorizam a **compatibilidade retroativa** em detrimento de outros objetivos de design. A introdução de mudanças incompatíveis acarreta um custo substancial associado ao suporte simultâneo de múltiplas versões da API.

Por fim, **APIs públicas** exigem **padrões de segurança mais elevados** em comparação com APIs internas.

**APIs frontend-para-backend desenvolvidas por uma única equipe**
A maioria das aplicações contemporâneas é composta por um componente **frontend** operando em um dispositivo do usuário final (navegador web ou aplicativo móvel) e um componente **backend**, normalmente implantado em uma infraestrutura de nuvem ou servidor.

Em muitos casos, tanto o backend quanto o frontend correspondente são desenvolvidos por uma única equipe ágil. Nesse cenário, mudanças na API podem ser refletidas rapidamente em ambos os lados, e a importância da **compatibilidade retroativa** pode ser menor.

Ainda assim, mesmo nessa situação, pode haver clientes fora do controle da equipe utilizando uma versão antiga da API — por exemplo, aplicativos móveis que não foram atualizados recentemente.

**APIs frontend-para-backend** também são consideradas **APIs públicas**, pois os clientes estão fora do nosso controle, exigindo que sejam tratadas como tal do ponto de vista da **segurança**.

**APIs que interconectam microserviços**

As equipes de desenvolvimento de **microserviços** devem manter autonomia para avançar rapidamente. Elas precisam prestar atenção à **documentação** e à **compatibilidade retroativa** de suas APIs para evitar interrupções em outros serviços conectados.

<mark style="background: #FFB86CA6;">Ao contrário das APIs públicas, dentro de uma organização é possível rastrear o uso das APIs internas de microserviços e suas versões.</mark>

Soluções que gerenciam as **especificações formais** das diversas APIs utilizadas dentro de uma organização — conhecidas como **schema registries** — podem ajudar a equilibrar o ritmo de desenvolvimento com a estabilidade da solução de negócios como um todo.

Com múltiplos serviços implementando múltiplas APIs dentro de uma única organização, muitas vezes é vantajoso delegar algumas responsabilidades da API para componentes de infraestrutura, como um **service mesh**.

Na próxima seção, você aprenderá sobre estilos de API que podem ser preferíveis ao REST em certos cenários.  
Lembre-se: não importa o quão bem você implemente uma API RESTful se estiver usando-a no contexto errado.

## Sobre o projeto
Neste livro, desenvolveremos um projeto para aplicar os conceitos mencionados neste capítulo, proporcionando prática e experiência **hands-on**. 

Construiremos duas **APIs** que irão se comunicar entre si.
- A primeira será a **Product API**, que será apresentada no Capítulo 2. Como o nome sugere, essa API será focada em operações relacionadas a produtos, como leitura de dados de produtos e adição de novos produtos. 
- A segunda será a **Order Management API**, introduzida no Capítulo 4. Ela será responsável por armazenar os pedidos que contêm os produtos gerenciados pela primeira API, permitindo que ambas se comuniquem. 

Ao longo dos capítulos, você poderá implementar essas APIs, aplicar a maioria das **melhores práticas** mencionadas neste capítulo, evoluí-las, documentá-las, testá-las e versioná-las para garantir **compatibilidade retroativa**, além de implementar ferramentas de **tracing** e realizar o **deploy na nuvem**.