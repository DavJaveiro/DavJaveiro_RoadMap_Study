Neste aplicativo, discutimos os aspectos essenciais do HTTP que todo desenvolvedor precisa conhecer. Felizmente, não precisamos ser um especialista em HTTP nem saber seu documento de referência de cor para desenvolver ótimas aplicações web. Ao longo de nossa jornada como desenvolvedor, aprenderemos outros aspectos do HTTP, mas quero garantir que tenhamos todas as informações necessárias para compreender os exemplos abordados neste livros começando pelo capítulo 7.

**Por que aprender sobre HTTP em um livro sobre Spring?** Porque hoje, a maioria das aplicações que desenvolvemos com um framework (como o Spring) são aplicações web, e essas aplicações utilizam o protocolo HTTP.

Começaremos explicando o que é o HTTP, analisando sua definição de forma visual. Em seguida, discutiremos os detalhes que precisamos saber sobre as requisições HTTP feitas por um cliente e como o servidor responde a elas.

---

## C.1 What is HTTP
Nesta seção, discutimos o que é HTTP. Prefiro definições simples, então a descrevo como a forma pela qual um cliente se comunica com o servidor em uma aplicação web. As aplicações preferem ter métodos rígidos para "se comunicar", e os protocolos oferecem as regras necessárias para que possam trocar informações. Vamos analisar analisar a definição de HTTP com auxílio de uma representação visual.

HTTP é um protocolo sem estado, baseado em texto, do tipo requisição-resposta, que utiliza o modelo de computação cliente-servidor.

## C.2 The HTTP request as a language between client and server
Nesta seção, discutimos a **requisição HTTP**. Nas aplicações que implementamos com Spring, será necessário utilizar a **requisição HTTP** para enviar dados do cliente para o servidor. Se você implementar o cliente, precisará adicionar dados na **requisição HTTP**. Se implementarmos o servidor, precisaremos extrair dados da requisição. De qualquer forma, é essencial compreender a **requisição HTTP**.

A **requisição HTTP** possui um formato simples. Os aspectos que devemos levar em consideração são os seguintes:
1. O URI da requisição - o cliente utiliza o caminho (path) para informar ao servidor qual recurso está sendo solicitado. O URI de uma requisição pode ser semelhante a este: `http://www.maning.com/books/pring-start-here`.
2. O **método da requisição:** um verbo que o cliente usa para indicar qual ação deseja executar com o recurso solicitado. Por exemplo, quando digitamos um endereço na barra de endereços de um navegador, ele sempre utiliza um método HTTP chamado **GET**. Em outras situações, como veremos nos próximos parágrafos, o cliente pode enviar uma requisição HTTP utilizando outros métodos, como **POST**, **PUT** ou **DELETE**.
3. Os parâmetros da requisição (opcionais) - dados em pequena quantidade que o cliente envia ao servidor junto com a requisição. Quando digo "pequena quantidade", refiro-me a algo que possa ser expresso em cerca de 10 a 50 caracteres. Os parâmetros da requisição não são obrigatórios. Eles também são conhecidos como *query paramters* e são enviados no URI por meio da adição de uma expressão de consulta *query string*. Portanto, colocamos no final da URL de uma requisição HTTP para filtrar, buscar ou passar dados para o servidor. Eles aparecem depois de um ? na URL e têm a forma: ?chave=valor.  Por exemplo, imaginamos uma URL como um endereço de restaurante delivery: `https://api.exemplo.com.restaurantes`. Essa URL sem nada nos fornece todos os restaurantes. Mas se quisermos apenas os que possuem comida japonesa, precisamos adicionar uma query parameter: `https://api.exemplo.com/restaurante?cozinha=japonesa`, portanto ? aqui inicia a seção de query parameteres. Vários parâmetros são separados por &: `https://api.exemplo.com/produtos?categoria=livres&ordem=preco`. Portanto, Query parameters são parecidas com cláusulas Where no SQL.
4. **Os cabeçalhos da requisição (opcionais)** - dados em pequena quantidade enviados no cabeçalho da requisição. Diferentemente dos parâmetros da requisição, esses valores não ficam visíveis no URI. Portanto, eles são informações adicionais enviadas junto com uma requisição (ou resposta) HTTP. São essenciais para definir como a requisição deve ser processada, ou como a resposta deve ser interpretada. Os cabeçalhos servem para:
	1. **Autenticação** - enviar um token de acesso;
	2. **Identificar o tipo de conteúdo** - JSON, XML, HTML, etc;
	3. **Definir linguagem ou codificação** - UTF-8, pt-BR
	4. **Controlar cache, cookies, etc** - Cache-control, Cookie
	5. **Informar o tamanho da requisição** - Content-Length
	Exemplo de uso real: suponha que estejamos enviando uma requisição para um endpoint protegido por token JWT:
```json
GET /usuario/perfil
Host: api.site.com
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
Content-Type: application/json
```
Os cabeçalhos dizem: quem somos nós (autorização), o idioma da carta e o formato do conteúdo.

5. **O corpo da requisição (opcional)** - uma quantidade maior de dados que o cliente envia ao servidor dentro da própria requisição. Quando o cliente precisa enviar informações que possuem algumas centenas de caracteres ou mais, ele pode utilizar o corpo da requisição (request body). O uso do corpo não é obrigatório. 

- **GET** - Express the client's intention to obtain some data from the server;
- **POST** - Express the client's intention to add data on the server
- **PUT** - Express the client's intention to change data on the server
- **DELETE** - Express the client's intention to remove some data from the server

**NOTA:** sempre lembre-se de que os verbos não são uma restrição para o que implementamos. O protocolo HTTP não pode impedir que você implemente uma funcionalidade HTTP GET que altere dados no backend.  

Os métodos HTTP Options e PATCH são menos comuns, mas ainda relevantes. O método OPTIONS permite que um cliente descubra quais parâmetros o servidor suporta para requisições, sendo frequentemente utilizado em implementações de segurança, especialmente no contexto de CORS (Cross-Origin Resource Sharing). O autor menciona que há uma excelente discussão sobre isso no capítulo 10 de *Spring Security in Action*.

O método PATCH é usado quando apenas parte dos dados de um recurso precisa ser alterada, enquanto o método PUT substitui completamente um recurso ou cria um novo quando ele não existe. Apesar dessa diferença, muitos desenvolvedores ainda optam pelo PUT em situações onde o PATCH seria mais apropriado.

A URI e o método HTTP são obrigatórios. O cliente precisa indicar qual recurso está utilizando (por meio da URI) e o que está fazendo com esse recurso (o método) ao fazer uma requisição HTTP. 

Por exemplo, a requisição representada no próximo trecho pode ser uma forma de instruir o servidor a retornar todos os produtos que ele gerencia. Consideramos aqui que *produto* é um recurso gerenciado pelo servidor:
GET http://example.com/products

A requisição representada no próximo trecho pode significar que o cliente deseja remover todos os produtos do servidor:
**DELETE**: *http://example.com/products*

Mas às vezes, o cliente também precisar enviar dados junto com a requisição. O servidor necessita desses dados para concluir a solicitação. Imagine que o cliente não queira excluir todos os produtos, mas apenas um específico. Nesse caso, ele precisa informar ao servidor qual produto deve ser excluído e enviar esse detalhe na requisição. A requisição HTTP poderia ser semelhante à apresentada no próximo trecho, em que o cliente usa um parâmetro para indicar ao servidor que deseja deletar o produto **Beer** (Cerveja):
**DELETE**: http://example.com/products?product=Beer

O cliente pode usar parâmetros de requisição, cabeçalhos de requisição ou o corpo da requisição para enviar dados ao servidor. Utilizamos os parâmetros de requisição para enviar pequenas quantidades de dados individuais. Se for necessário trocar uma quantidade maior de informações, a melhor forma de enviá-las é por meio do **corpo da requisição HTTP**. Nos capítulos 7 a 10, utilizaremos ambas as abordagens para enviar dados do cliente para o servidor dentro da requisição HTTP.

## C.3 The HTTP response: The way the server responds
Nesta seção, discutiremos a resposta HTTP. O HTTP é o protocol