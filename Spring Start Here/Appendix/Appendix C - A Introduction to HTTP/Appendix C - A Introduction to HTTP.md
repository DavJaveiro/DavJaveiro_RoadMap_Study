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

<<<<<<< HEAD
O trecho de código a seguir detalhe uma requisição HTTP:

POST /servlet/default.jsp HTTP/1.1 - Essa requisição específica o método e o caminho (path);


**Diferentes headears com valoress que podem ser adicionados nos dados de uma requisição:**
Accept: text/plain; text/html                    
Accept-Language: en-gb                           
Connection: Keep-Alive                           
Host: localhost                                  
Referer: http://localhost/ch8/SendDetails.html   
User-Agent: Mozilla/4.0 (MSIE 4.01;Windows 98)   
Content-Length: 33                               
Content-Type: application/x-www-form-urlencoded  Accept-Encoding: gzip, deflate  

**Parâmetro de requisição que pode ser utilizado para transferir dados de requisição**:
lastName=Einstein&firstName=Albert

A URI (Uniform Resource Identifier) da requisição identifica um recurso no lado do servidor com o qual o cliente deseja trabalhar. A URI é a parte da requisição HTTP que a maioria das pessoas conhece, pois precisamos escrever uma URI na barra de endereços do navegador toda vez que acessamos um site. A URI tem um formato como o próximo trecho. No trecho <server_location> é o endereço de rede do sistema onde o aplicativo do servidor está em execução, *application_port* é o número da porta que identifica a instância do aplicativo servidor em execução, e *resource_path* é um caminho que o desenvolvedor associou a um recurso específico. O cliente precisa solicitar um caminho específico para trabalhar com um recurso particular.

Uma vez que o cliente identifica o recurso na requisição, ele utiliza um verbo chamado **método de requisição HTTP** para especificar o que fará com o recurso. A maneira como o cliente especifica o método depende de como a chamada é enviada ao servidor. Por exemplo, se a chamada for feita diretamente pelo navegador, quando digitamos um endereço na barra de endereços, o navegador enviará uma requisição GET. Na maioria dos casos, quando clicamos em um botão de envio em um formulário em uma página da web, o navegador usa **POST**. O desenvolvedor da página web decide qual método o navegador deve usar ao enviar uma requisição originada como resultado do envio de um formulário. Uma requisição HTTP também pode ser enviada por um script escrito em uma linguagem do lado do cliente, como JavaScript. Nesse caso, o desenvolvedor do script decide qual método HTTP a requisição irá utilizar. 
Os métodos HTTP que encontraremos com mais frequência em aplicativos web são os seguintes:
- GET - Expressa a intenção do cliente de obter alguns dados do servidor;
- POST - Expressa a intenção do cliente de adicionar dados nos ervidor;
- PUT - Expressa a intenção do cliente de alterar dados no servidor;
- DELETE - Expressa a intenção do cliente de remover alguns dados do servidor.

=======
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
Nesta seção, discutimos a **resposta** HTTP. O **HTTP** é o protocolo que permite que o cliente se comunique com o **server** em uma aplicação web. Após tratar a **request** do client na aplicação, é hora de implementar a **resposta** do servidor. Em resposta a uma requisição do cliente, o server envia o seguinte:
- **Response status** - um número inteiro entre 100 e 599 que define uma representação breve do resultado da request;
- **Response headers** (opcional) - semelhante aos **request parameters**, representam dados no formato **key-value pair**. São projetados para enviar uma pequena quantidade de dados (entre 10 e 50 caracteres) do server para o client em resposta a uma request. Eles servem para fornecer informações adicionais sobre a resposta enviada pelo servidor ao cliente. Eles não contêm o conteúdo principal da resposta, mas os metadados que ajudam a interpretar e processar os dados corretamente. Algumas funções comuns dos responses headers incluem:
	- **Indicar o tipo de conteúdo:** define se a resposta é JSON, HTML, XML, entre outros (*content-type*);
	- **Controle de cache:** informa como e por quanto tempo a resposta pode ser armazenada (*cache-control*)
	- **Autenticação e segurança:** pode incluir tokens de autorização ou políticas de segurança (**Authorization, Strict-Trasnport-Security**);
	- **Encodificação:** especifica a compreensão usada para otimizar a transferência de dados (content-enconding);
	- **Definir cookies:** permite o armazenamento de informações do usuário entre requisições *Set-Cookie*.

- **Response Body** - uma forma do server enviar uma quantidade maior de dados (podendo ser arquivos inteiros) de volta ao cliente.

**HTTP/1.1 200 OK**: A resposta HTTP especifica a versão do HTTP, o código de resposta e a mensagem. 

**A resposta HTTP pode enviar dados por meio dos cabeçalhos de resposta.**
Server: Microsoft-IIS/4.0
Date: Mon, 14 May 2012 13:13:33 GMT
Content-Type: text/html
Last-Modified: Mon, 14 May 2012 13:03:42 GMT
Content-Length: 112

O status da resposta é o único <span style="background:#d4b106">detalhe obrigatório</span> que um servidor deve fornecer em resposta a uma solicitação do cliente. O status informa ao cliente se o servidor entendeu a solicitação e tudo correu bem, ou se houve algum problema durante o processamento da requisição. Por exemplo, o servidor retorna um código de status que começa com 2 para indicar que tudo ocorreu corretamente. 

O status HTTP é uma representação resumida do resultado da requisição completa (incluindo se o servidor conseguiu lidar com a lógica de negócio da solicitação). Não precisamos decorar todos os códigos de status em detalhes. Os que encontramos com mais frequência são:
- **Começando com 2:** significa que o servidor processou a requisição corretamente. O processamento foi bem-sucedido e o servidor executou o que o cliente solicitou.
- **Começando com 4:** indica que há algo errado com a requisição do cliente (é um problema do lado do cliente). Por exemplo, o cliente requisitou um recurso que não existe, ou enviou parâmetros inesperados.
- **Começando com 5:** significa que algo deu errado do lado do servidor. Por exemplo, o servidor tentou se conectar a um banco de dados, mas ele não estava acessível. Nesse caso, o servidor retorna um status informando ao cliente que não conseguiu concluir a requisição, mas não por culpa do cliente.

Diferentes valores que começam com 2 são variações de mensagens que indicam que o servidor processou corretamente a solicitação do cliente. Alguns exemplos são:
- **200 - OK** é o status de resposta mais conhecido e direto. Ele simplesmente informa ao cliente que o servidor não encontrou problemas ao processar sua solicitação.
- **201 - CREATED** pode ser usado, por exemplo, em resposta a uma requisição POST para informar ao cliente que o servidor conseguiu adicionar o recurso solicitado. Nem sempre é obrigatório adicionar esse nível de detalhe ao status da resposta, e é por isso que o 200 geralmente é o status mais usado para indicar que tudo está certo.  
- **204 - No Content** pode informar ao cliente que ele não deve esperar um corpo de resposta (response body) para essa resposta.

Quando um código de status HTTP começa com 4, o servidor informa ao cliente que houve um problema com a solicitação. O cliente fez algo errado ao requisitar um recurso específico. Pode ser que o recurso não exista (o conhecido 404 - Not Found) ou que alguma validação dos dados tenha falhado. Alguns dos códigos de erro do cliente mais comuns são:
- **400 Bad Request** - um status genérico frequentemente usado para representar qualquer tipo de problema a solicitação HTTP (por exemplo, validação dos dados ou problema ao ler um valor específico no corpo da solicitação ou em um parâmetro de solicitação);
- **401 Não Autorizado** - Um status geralmente usado para informar ao cliente que a solicitação precisa de autenticação;
- **403 Proibido** - Um status geralmente enviado pelo servidor para informar ao cliente que ele não está autorizado a executar sua solicitação;
- **404 Não encontrado** - um status enviado pelo servidor para informar ao cliente que o recurso solicitado não existe.

Quando o status de resposta começa com 5xx, significa que algo deu errado no lado do servidor, mas o problema é do próprio servidor. O cliente enviou uma solicitação válida, mas o servidor não conseguiu completá-la por algum motivo. O status mais utilizado nessa categoria é o **500 Erro Interno do Servidor**. Esse status de resposta é um valor genérico de erro que o servidor envia para informar ao cliente que ocorreu um problema durante o processamento da solicitação pelo backend.

Opcionalmente, o servidor pode enviar dados de volta para o cliente como resposta, seja por meio de cabeçalhos da resposta ou pelo corpo da resposta.

## C.4 The HTTP session
Vamos falar sobre a sessão HTTP, um mecanismo que permite a um servidor armazenar dados entre múltiplas interações de requisição e resposta com o mesmo cliente. Lembre-se de que, no HTTP, cada requisição é independente das outras. Em outras palavras, uma requisição não tem conhecimento de requisições anteriores, futuras ou simultâneas. Uma requisição não pode compartilhar dados com outras requisições ou acessar os detalhes da resposta do backend para elas.

No entanto, existem cenários em que o servidor precisa correlacionar algumas requisições. Um bom exemplo é a funcionalidade de carrinho de compras em uma loja online. Um usuário adiciona vários itens ao carrinho. Para adicionar um item, o cliente faz uma requisição. Para adicionar um segundo item, o cliente faz outra requisição. <span style="background:#d4b106">O servidor precisa de uma maneira de saber que o mesmo cliente adicionou previamente um item ao mesmo carrinho</span>.

Uma maneira de implementar esse comportamento é utilizando a sessão HTTP. O backend atribui um identificador único chamado de *session ID* ao cliente e o associa a um espaço na memória do aplicativo. Cada requisição que o cliente enviar após receber o **session ID** deve conter esse identificador no cabeçalho da requisição. Dessa forma, <span style="background:#d4b106">o aplicativo backend sabe como associar as requisições específicas da sessão</span>. 

A sessão HTTP geralmente termina após um período de inatividade do cliente. Esse tempo pode ser configurado, geralmente tanto no contêiner servlet quanto no aplicativo. Se a sessão durar muito tempo, o servidor consumirá muita memória. Na maioria dos aplicativos, <span style="background:#d4b106">uma sessão termina após menos de uma hora sem novas requisições do cliente</span>. 

Se um cliente enviar uma nova requisição após a sessão ter terminado, o servidor iniciará uma nova sessão para esse cliente.

