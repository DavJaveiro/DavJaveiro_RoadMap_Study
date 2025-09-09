Para implementar REST APIs, na maioria dos capítulos deste livro, usaremos o Spring Boot. Por ser um framework conhecido e popular.

Neste capítulo, discutiremos o processo de design de uma API RESTful. Também nos concentraremos na implementação prática da API usando o Spring Framework, uma escolha popular para a construção de APIs RESTfUL.

Ao final deste capítulo, você terá o conhecimento necessário para **projetar e criar uma API RESTful** seguindo as melhores práticas.

Neste capítulo, abordaremos os seguintes tópicos:
- **Design da Product API**
- **Implementação da API usando Spring Boot**

## Technical requirements
Para acompanhar e utilizar os exemplos de código conforme apresentados no livro, precisamos do seguinte:
- Conhecimento intermediário da linguagem de plataforma Java;
- Pelo menos conhecimento básico de Spring Boot ou de um framework semelhante Java 21 e Maven 3.9.0 instalados.
- Conhecimento básico de uma ferramenta para chamadas de REST APIs, como o curl, é recomendado.

Neste capítulo, aplicaremos os princípios REST para criar nossa API. Podemos acessar o código deste capítulo no GitHub. 

## Design da Product API
A Product API que vamos desenvolver é uma API para gerenciamento de produtos. Nossa API oferecerá várias operações, que serão detalhadas durante a fase de design. 

Investir tempo suficiente no design adequado da API antes de começar a escrever o código pode economizar muito tempo posteriormente, evitando refatorações custosas e arriscadas.

A etapa de design deve incluir os seguintes pontos:
	- **Definição dos requisitos:** compreender os casos de uso e quem utilizará a API é essencial para criar uma API que contenha tudo o que é necessário, e nada além disso. Um bom entendimento dos requisitos permite evitar mudanças quebráveis pelo maior tempo possível. No capítulo 5, falaremos sobre como evoluir nossa API e garantir a compatibilidade retroativa. 
	- **Identificação dos recursos:** os recursos geralmente são entidades do domínio, como usuários ou produtos. Relações entre múltiplas entidades são frequentemente representadas por uma estrutura de URI hierárquica. 
	- **Definição da estrutura dos recursos:** após identificar os recursos, é necessário definir os campos e relacionamentos desses recursos;
	- **Design dos endpoints:** com os recursos e o domínio definidos, o próximo passo é identificar quais endpoints devem ser expostos, como devem ser expostos e quais métodos HTTP devem ser usados para cada finalidade. 
	- **Tratamento de erros:** ter respostas de erro claras com **códigos de erro padrão** ajuda o cliente a reagir corretamente ao erro.
	- **Segurança**: é essencial impedir que agentes maliciosos acessem recursos para os quais não estão autorizados. 

**Definindo os requisitos**
Os requisitos da API podem ser divididos em **funcionais** e **não funcionais:**
- **Requisitos Funcionais:** descrevem as funções e características específicas que o software deve executar. Exemplos incluem **validação de dados**, **processamento de dados** e **interações com o sistema.**
- **Requisitos Não Funcionais:** também conhecidos como **atributos de qualidade** ou **requisitos de qualidade de software**, especificam as qualidades ou características que o software deve possuir. Exemplos incluem **desempenho** (tempo de resposta e vazão), confiabilidade, segurança, escalabilidade, usabilidade e manutenibilidade.

Neste capítulo, vamos operar apenas com os requisitos funcionais. Abordaremos alguns dos requisitos não funcionais nos capítulos 7 e 10.

Como mencionado anteriormente, nossa API REST de exemplo será uma **Product API** e terá os seguintes requisitos:
- **Criação de produto**: a API deve permitir que os usuários criem novos produtos fornecendo informações necessárias como **SKU** (Stock Keeping Unit, neste contexto o identificador único do produto), **nome**, **descrição** e **preço**.
- **Consulta de produto:** a API deve fornecer endpoints para recuperar informações detalhadas sobre um produto específico, identificado pelo seu SKU.
- **Atualização de produto:** os usuários devem poder atualizar informações de produtos existentes, como **nome**, **descrição** ou **preço.**
- **Atualização da descrição**: a API deve fornecer um endpoint para atualizar **somente a descrição** do produto. 
- **Exclusão de produto:** deve permitir que os usuários excluam um produto do sistema, identificado pelo seu SKU.
- **Restrição de SKU único:** A API deve impor uma restrição para garantir que cada produto tenha um SKU único, evitando duplicatas com o mesmo identificador. 

## Identificando os recursos
Uma API REST pode ter um ou mais **resources**, e também pode adotar uma estrutura URI hierárquica. 

A estrutura hierárquica de URI é uma forma de organizar os recursos em uma hierarquia de URLs que reflete as relações entre esses recursos. Nessa estrutura, os recursos são organizados em um formato semelhante a uma árvore, onde cada segmento da URL representa um nível da hierárquia. 
Vamos usar o seguinte exemplo:
```json
https://example.com/blog/posts/12
```

Nesta URI, temos:
- https://example.com - é a base URL
- /blog - representa o resource de nível superior, indicando que estamos acessando a seção de blog de um site.
- /posts - é um sub-resource dentro do resource /blog, representando uma coleção de postagens.
- /12 é uma postagem específica identificada por seu identificador único.

Os **resources** devem ser substantivos, não verbos. Por exemplo, /products/create não deve ser usado; em vez disso, deve-se utilizar o método HTTP correspondente para essa ação. Isso é essencial para aderir ao nível 2 do Richardson Maturity Mode.

Em inglês, muitos verbos também podem ser usados como substantivos — por exemplo, `/products/quote`. Quando fazemos uma requisição **POST** para esse recurso, significa “criar uma cotação”. A parte verbal da ação é representada pelo método HTTP correto.

Os #resources correspondem a entidades de negócio, e a API geralmente trabalha com múltiplas entidades do mesmo tipo. Ao criar ou listar recursos (entidades) de um determinado tipo, estamos lidando com uma coleção de objetos. Para recursos de coleção, usamos a forma plural do substantivo, por exemplo, products em vez de product, pois queremos suportar operações sobre a coleção de produtos. 

---
A **RFC 3986** define uma **URI** como uma sequência compacta de caracteres que identifica um recurso abstrato ou físico. Segundo a **RFC 1738**, uma **URL** é um tipo específico de URI que representa a **localização** de um recurso acessível via internet. Assim, uma URI pode ser classificada como **localizador**, **nome**, ou ambos — com o termo **URL** referindo-se ao subconjunto das URIs.

A **RFC 2141** define ainda os **URNs** como outro tipo de URI que nomeia um recurso de forma **persistente** e **independente de localização**.

---
No nosso caso, temos apenas um recurso, que é o product, então utilizamos apenas /products.

Agora que identificamos os recursos, **o próximo passo é definir a estrutura do recurso.** 

## Defining the resource structure
Após identificar os **resources**, devemos identificar os atributos desses recursos e quaisquer **relacionamentos** importantes na API. 
Os atributos representam os campos de dados associados ao recurso. É importante considerar os tipos de dados, restrições e se os atributos são obrigatórios ou opcionais para cada recurso.

Um relacionamento indica como os recursos estão relacionados entre si e se possuem alguma estrutura hierárquica ou aninhada. Por exemplo, um user pode ter múltiplos orders associados a ele, ou um product pode pertencer a uma category específica.

No nosso caso, temos apenas um recurso, que é o #product, e ele deve possuir os seguintes atributos:
- name
- sku: chave única do produto
- description: uma descrição do produto
- price: o preço do produto

Também podemos definir as regras para esses atributos nesta etapa:
- name: campo obrigatório, com uma string de comprimento entre 3 e 255 caracteres;
- sku: campo obrigatório, com o padrão AA9999
- description: campo obrigatório, com uma string de comprimento entre 10 e 255 caracteres.
- price: campo obrigatório, com um valor maior que 0

## Designing the endpoints
Para projetar os endpoints, é importante conhecer os HTTP methods e os HTTP status codes.
Antes de falar sobre isso, porém, devemos dar um passo atrás e entender como tudo começou.
Os HTTP methods e princípios que vamos compartilhar aqui seguem as diretrizes da Microsoft mencionadas no capítulo anterior. Qualquer diretriz REST deve estar em conformidade com o padrão da internet conhecido como RFC 9110, a versão atualizada da RFC 2616.

RFC significa *Request for Comments*. A RFC específica HTTP, TCP, IP, SMTP e muitos outros protocolos essenciais da internet.
A dissertação de **Fielding**, intitulada _Architectural Styles and the Design of Network-based Software Architectures_, foi uma fonte importante para a **RFC 2616**, definindo o protocolo **HTTP/1.1**.

### HTTP methods (verbs)
O HTTP define vários métodos (também conhecidos como verbos) que indicam a ação a ser realizada sobre um recurso. Os métodos HTTP mais utilizados em APIs RESTful são os seguintes:
- **GET:** as requisições com o método GET são usadas para recuperar representações de recursos, **e não devem alterar o estado do servidor**. Elas são seguras e idempotentes, o que significa que não têm efeitos colaterais no servidor e podem ser repetidas sem alterar seu estado. (Pense no método **get** de um **Map** em Java.)
- **POST:** as requisições com o método POST são usadas para criar novos recursos ou, de forma geral, enviar dados para serem processados pelo servidor. Elas não são idempotentes, o que significa que cada requisição é única e pode ter efeitos colaterais no servidor. (Pense no operador ++ em Java; o resultado será diferente se for avaliado várias vezes).
- **PUT:** essas requisições são normalmente usadas para criar ou atualizar toda a representação de um recurso. Elas são idempotentes, o que significa que enviar a mesma requisição várias vezes deve ter o mesmo efeito que enviá-la uma única vez.
- **PATCH:** é semelhante a PUT, mas usado para aplicar modificações parciais a um recurso. É frequentemente utilizado quando se deseja atualizar apenas alguns campos de um recurso. (Pense em um método setter de um Java Bean ou POJO).
- **DELETE:** esse método é usado para remover um recurso do servidor. Ele também é idempotente, ou seja, enviar a mesma requisição várias vezes deve resultar no mesmo estado do servidor.

## Status code HTTP
Os códigos de status HTTP são números de três dígitos que um servidor envia de volta ao cliente após receber uma requisição. Eles indicam o resultado da requisição e fornecem informações sobre o estado do servidor ou do recurso solicitado. Todos os códigos de status HTTP são agrupados da seguinte forma:
- 1xx informativo - Indica que a requisição foi recebida e está sendo processada.- **2xx Sucesso**: Indica que a requisição foi recebida, compreendida e processada com sucesso pelo servidor.
- **3xx Redirecionamento**: Indica que é necessário realizar uma ação adicional para completar a requisição. O cliente pode precisar ser redirecionado para um URI diferente.    
- **4xx Erro do Cliente**: Indica que houve um erro na requisição feita pelo cliente.
- **5xx Erro do Servidor**: Indica que houve um erro no lado do servidor ao processar a requisição.

### Definindo os endpoints da nossa API
Vamos definir os endpoints para o recurso que identificamos na etapa anterior. Usaremos os métodos HTTP com o recurso **products** (produtos) para garantir que possamos realizar todas as operações necessárias conforme descrito na fase de requisitos.

**GET /products**: esse endpoint será responsável por retornar uma **lista de produtos**. Devemos retornar um código de status HTTP 200 (OK) junto com os produtos.

**PUT /products/{id}**: esse endpoint será responsável por criar ou atualizar um produto. O método PUT é idempotente, ou seja, podemos chamá-lo várias vezes e o resultado será o mesmo. Em caso de sucesso, devemos retornar:
- 201 Created se o produto não existir;
- 200 ok se o produto já existir.

Também podemos retornar 202 Accepted se o produto fosse processado futuramente como uma tarefa assíncrona, o que não é o caso aqui.

Se decidíssemos usar o método POST, precisaríamos escolher entre lançar uma exceção caso o produto já exista, essa exceção poderia ser 409 Conflict e ter outro endpoint responsável por atualizar o recurso, já que isso é um requisito. 

Em vez disso, podemos usar o método PUT, que pode criar ou atualizar o recurso.

De acordo com a RFC 9110, Seção 9.3.4:
	"A diferença fundamental entre os métodos POST e PUT é destacada pela intenção diferente da representação incluída. O recurso-alvo em uma requisição POST deve lidar com a representação conforme sua própria semântica, enquanto a representação incluída em uma requisição PUT é definida como substituindo o estado do recurso-alvo. Assim, a intenção do PUT é idempotente e visível para intermediários, embora o efeito exato seja conhecido apenas pelo servidor de origem."

A interpretação adequada de uma requisição PUT presume que o agente do usuário sabe qual recurso-alvo deseja manipular.

**DELETE /products/{id}**: 
Este endpoint é utilizado para remover o produto. Podemos retornar 204 (No Content) no caso de o produto ser removido. Mesmo que o produto não exista, ainda podemos retornar 204, já que o método é idempotente, o que significa que enviar a mesma requisição várias vezes deve resultar no mesmo estado no servidor.

**PATCH /products/{id}**: esse endpoint deve ser usado para atualizar a descrição de um produto. Como se trata de uma atualização parcial de um recurso, é recomendado utilizar o método PATCH. O que método PATCH foi introduzido na RFC 5789 como uma atualização parcial que **não precisa ser idempotente.**

Se o produto **não existir**, podemos retornar um erro 404 (Not Found). Em caso de sucesso, podemos retornar os dados atualizados do produto e um código de status HTTP 200 (OK).

**GET /products/{id}**: esse endpoint é responsável por retornar os detalhes de um único produto pelo ID. Se o produto não existir, podemos retornar um erro 404 (não encontrado). Em caso de sucesso, devemos retornar a representação do produto e um status HTTP 200. Agora que definimos nossos endpoints, vamos ver os possíveis erros que podemos encontrar e como podemos nos preparar para eles de forma eficaz.

**Tratamentos de erros:**
A preparação para problemas comuns por meio da definição de possíveis erros pode nos ajudar a implementar uma API mais confiável. Já discutimos alguns erros na etapa anterior; no entanto, vamos nos aprofundar e ver os códigos de status HTTP mais comuns no intervalo 4xx. Os códigos de status HTTP mais comuns no intervalo 4xx, que indicam erros do cliente, são os seguintes: 
- **400 Bad Request**: Esse código de status indica que o servidor não conseguiu entender a solicitação do cliente devido a uma sintaxe inválida ou a uma mensagem de solicitação malformada.
- **401 Não autorizado**: esse código de status indica que o cliente precisa se autenticar para acessar o recurso solicitado.
- **403 Forbidden (Proibido):** esse código indica que o cliente está autenticado, mas não tem permissão para acessar o recurso solicitado. Pode ser devido a permissões insuficientes ou restrições de controle de acesso impostas pelo servidor.
- **404 Not Found:** o servidor não conseguiu encontrar o recurso solicitado. É comumente usado para indicar que o URI fornecido pelo cliente não corresponde a nenhum recurso conhecido no servidor.
- **404 Method Not Allowed**: esse código indica que o método HTTP usado pelo cliente não é compatível com o recurso solicitado. Por exemplo, tentar usar uma solicitação POST em um recurso que só aceita solicitações GET. 
- **409 Conflito:** esse código de status indica que a solicitação não pode ser concluída devido a um conflito com o estado atual do recurso. Normalmente, ocorre quando o cliente tentar criar ou atualizar um recurso, mas o servidor detecta um conflito com o estado atual do recurso; por exemplo, quando duas solicitações tentam atualizar os detalhes do mesmo produto simultaneamente, um status 409 pode ser retornado se as alterações de uma solicitação entrarem em conflito com a outra devido a uma incompatibilidade de versão: esse código de status indica que o servidor estende a solicitação, mas não pode processá-la devido a erros semânticos ou falhas de validação na carga útil da solicitação. Geralmente é usado para indicar erros de validação nos dados da solicitação, por exemplo, ao tentar comprar um produto que está fora de estoque.

- **422 Entidade não processável:** esse código de status indica que o servidor entende a solicitação, mas não pode processá-lo devido a **erros semânticos** ou falhas de validação na carga útil da solicitação. Geralmente é usado para indicar erros de validação nos dados da solicitação, por exemplo, ao tentar comprar um produto que está fora de estoque, 
- **429 Too Many Requests (muito)**: esse código de status indica que o cliente excedeu o limite de taxa ou a cota imposta pelo servidor para o número de solicitações permitidas em um determinado período de tempo. Geralmente é usado para evitar abuso ou uso excessivo dos recursos do servidor, limitando a taxa de solicitações de entrada de um único cliente ou endereço IP. <mark style="background: #FF5582A6;">Esse erro é normalmente tratado por um gateway de API usando uma estratégia de limitação de taxa, conforme abordaremos no Capítulo 6</mark>.

Em nossa implementação de API, devemos ser capazes de lidar com alguns erros:
- Quando um produto não existe, devemos retornar um 404 Not Found;
- Quando a carga útil (payload) não atende aos requisitos, por exemplo, devemos retornar 400 Bad Request com os detalhes, por exemplo, se um número negativo for fornecido para o preço do produto.

Os códigos de status HTTP 401 e 403 relacionados à segurança serão abordados no Capítulo 7. Nos próximos capítulos, trataremos da segurança e da documentação como tópicos separados e os abordaremos de frente. Entretanto, para a iteração de desenvolvimento representada por este capítulo, concluímos nossa fase de design. 

## API implementation using Spring Boot.

Spring Boot é o framework Java mais popular para aplicações de microsserviços. Ele fornece contêineres de servlet embutidos, como **Tomcat**, **Jetty** e **Undertow**. Embutir um contêiner permite empacotar sua aplicação como um arquivo **JAR executável**, que pode ser executado diretamente sem a necessidade de implantar sua aplicação em um servidor de aplicações separado. Vamos usar o **Tomcat**, pois é o padrão.

Nossa aplicação fornecerá alguns **endpoints** e usará um banco de dados SQL. Utilizaremos o H2, que é um banco de dados leve e de código aberto. Ele pode funcionar tanto como banco de dados **in-memory** quanto como banco baseado em **fylesistem**, tornando-o facilmente utilizável em ambientes de desenvolvimento sem a necessidade de infraestrutura adicional. 

Vamos utilizar uma dependência do Spring Data para integrar com a camada de persistência, mas como esse não é o foco do livro, não entraremos em detalhes. Recomendamos o livro _Persistence Best Practices for Java Applications_, de Otávio Santana e Karina Varela, da Packt Publishing, que aborda mais sobre a camada de persistência. Para adicionar a dependência do Spring Data, inclua a seguinte entrada no seu arquivo `pom.xml`:

```java
<dependency>
<groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Como nossa API é uma aplicação web, também vamos usar o Spring Web para criar nossos endpoints REST e Bean Validation para validar a entrada do usuário, o que será abordado neste capítulo.

Utilizaremos o design da Clean Architecture:
A **Clean Architecture** foi criada por **Robert C. Martin**, que foi influenciado por outras arquiteturas bem conhecidas, como a **Onion Architecture** de **Jeffrey Palermo** e a **Hexagonal Architecture** (também conhecida como _ports and adapters_) de **Alistair Cockburn**.

A Clean Architecture compartilha um objetivo semelhante ao dessas outras arquiteturas: a separação de responsabilidades por meio da divisão do software em **camadas.** A principal distinção da Clean Architecture está em sua definição clara de camadas, ou seja, de responsabilidades, facilitando uma melhor organização e compreensão do sistema.

**Entidades:** essa camada contém as entidades comerciais ou os objetos de domínio do aplicativo. 
**Use Cases:** essa camada contém a lógica comercial ou os casos de uso específicos do aplicativo. Essa camada representa o comportamento do aplicativo em termos de ações ou operações que os usuários podem executar.
**Interface Adapters:** essa camada é responsável por adaptar a representação interna do aplicativo a interfaces externas, como UIs, APIs REST, bancos de dados ou serviços de terceiros.
**Estrutura e drivers:** essa camada inclui bibliotecas, estruturas e código de infraestrutura que lidam com preocupações externas, como renderização de interface do usuário, acesso a banco de dados, servidores da Web e APIs EXTERNAS.

Em nosso aplicativo, usaremos apenas três camadas: entidades, casos de uso e adaptadores de interface. Isso de deve ao fato de que, em nosso aplicativo, decidimos que não queremos nos desacoplar completamente da estrutura do Spring. 

## Criando os endpoints da nossa Product API

Entendo a estrutura da aplicação utilizada pelo autor. Adapter #hexagonal. 

Pensemos em nossa aplicação (domain + usecase) como o centro de um hexágono. Existem duas formas de interagir com ela:
- **De fora para dentro (inbound)**: o mundo externo inicia uma ação na nossa aplicação;
- **De dentro para fora (outbound):** nossa aplicação inicia uma ação no mundo externo.

1. #inbound (Portas de Entrada / Driving Adapters), essa paste contém os adaptadores que acionam a nossa aplicação. Eles são a porta de entrada. 

