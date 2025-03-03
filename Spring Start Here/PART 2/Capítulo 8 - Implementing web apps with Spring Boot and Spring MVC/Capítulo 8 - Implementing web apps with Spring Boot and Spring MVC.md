*This chapter covers*
- Using a template engine to implement dynamic views;
- Sending data from client to server through HTTP requests;
- Using GET and POST HTTP methods for your HTTP requests;

## 8.1 Implementing web apps with a dynamic view
Suponha que tenhamos que implementar a página do carrinho de uma loja online. Esta página não deve exibir os mesmos dados para todos. Ela também não exibe a mesma informação todas as vezes para o mesmo usuário. Esta página mostra precisamente os produtos que um usuário específico adicionou ao seu carrinho. 

Nesta seção, vamos implementar um aplicativo web com uma visualização dinâmica. A maioria dos aplicativos hoje em dia precisa exibir dados dinâmicos para o usuário. Agora, para uma solicitação do usuário expressa por meio de uma solicitação HTTP enviada pelo navegador, o aplicativo web recebe alguns dados, processa-os e, em seguida, envia de volta uma resposta HTTP que o navegador precisa exibir.
![[Capítulo 8 - Implementing web apps with Spring Boot and Spring MVC.png]]

Vamos revisar o fluxo do Spring MVC e depois trabalhar em um exemplo para demonstrar como a view pode obter valores dinâmicos do controlador. No exemplo que implementamos no final do capítulo 7, <span style="background:#affad1">o conteúdo do navegador era o mesmo para cada solicitação HTTP para nossa página</span>. Lembre-se do fluxo do Spring MVC (figura 8.3):

1. O cliente envia uma solicitação HTTP para o servidor web.
    
2. O *dispatcher servlet* usa o *handler mapping* para descobrir qual ação do controlador chamar.
    
3. O dispatcher servlet chama a ação do controlador.
    
4. Depois de executar a ação associada à solicitação HTTP, <span style="background:#b1ffff">o controlador retorna o nome da view</span> que o dispatcher servlet precisa renderizar na resposta HTTP.
    
5. A resposta é enviada de volta ao cliente.

O número 4 é onde precisamos fazer uma alteração. Queremos que o controlador não apenas retorne o nome da view, mas de alguma forma também envie dados para a view. A view incorporará esses dados para definir a resposta HTTP. Desta forma, se o servidor enviar uma lista de um produto e a página exibir a lista, a página exibirá um produto. Se o controlador enviar dois produtos para a mesma view, agora os dados exibidos serão diferentes porque a página exibirá dois produtos (o comportamento que você observou na figura 8.1).

Deixe-me mostrar como enviar dados do controlador para a view em um projeto agora. Você pode encontrar este exemplo no projeto “sq-ch8-ex1”. Este exemplo é simples para permitir que você se concentre na sintaxe. Mas você pode usar essa abordagem para enviar qualquer dado do controlador para a view.

Vamos supor, por agora, que queremos enviar um nome e imprimi-lo com uma cor específica. Em um cenário do mundo real, você talvez precise imprimir o nome do usuário em algum lugar na página. Como você faz isso? Como obter dados que podem ser diferentes de uma solicitação para outra e imprimi-los na página?

Vamos adicionar um mecanismo de template às dependências no arquivo pom.xml. Usaremos um mecanismo de template chamado #Thymeleaf. O mecanismo de template é uma dependência que nos permite enviar facilmente dados do controlador para a view e exibir esses dados de uma maneira específica. Os templates usados com o Thymeleaf são arquivos HTML estáticos simples. Precisamos adicionar o Thymeleaf em nosso pom.xml...

```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
Na listagem 8.1, encontramos a definição do controlador. Nós anotamos o método para mapear a ação para um caminho de solicitação específico usando *@RequestMapping*. 

Agora também definimos um **parâmetro para o método**. Esse parâmetro do tipo Model armazena os dados que queremos que o controlador envie para a view. Nessa instância de Model, adicionamos os valores que queremos enviar para a view e identificamos cada um deles com um nome único (também chamado de chave). Para adicionar um novo valor que o controlar envia para a view, chamamos o método addAttribute(). O primeiro parâmetro do método addAttribute() é a chave; o segundo parâmetro é o valor.

```java
@Controller 
public class MainController {

	@RequestMapping("/home")
	public String home(Model page) {
		page.addAttribute("username", "katy");
		page.addAttribute("color", "red");
		return "home.html";
	}
}
```
- *@Controller* - a annotation marks this class as Spring MVC controller and adds a bean of this type to the Spring context.
- The action method defines a parameter of type Model that stores the data the controller sends to the view.

O que estamos fazendo é chamado de **mock** ou **stub**.

- #Mock - quando simulamos um comportamento específico de um objeto ou serviço, muitas vezes usando bibliotecas como Mockito;
- #Stub - Quando fornecemos respostas pré-definidas para métodos, sem lógica complexa.

Como estamos definindo valores diretamente no *Model*, isso pode ser considerado um *Stub*, pois os dados não vêm de uma fonte real (como do banco de dados), mas são fixos no código para fins de teste ou demonstração.

Para definir a view, precisamos adicionar um novo arquivo *home.html* na pasta *resources/templates* do nosso projeto Spring Boot. Preste atenção à pequena diferença: no capítulo 7, adicionamos o arquivo HTML na pasta “resources/static” porque criamos uma visualização estática. Agora que estamos usando um mecanismo de template para criar uma visualização dinâmica, você precisa adicionar o arquivo HTML na pasta “resources/templates” em vez disso.

A listagem abaixo mostra o conteúdo do arquivo *home.html*. A primeira coisa importante a notar no conteúdo do arquivo é a tag < html> onde foi adicionado o atributo xmlns:th="http://www.thymeleaf.org" essa definição é equivalente a um import em Java. isso nos permite utilizar o prefixo *th* para nos referir a recursos específicos fornecidos *Thymeleaf* na view.

Um pouco mais adiante na view, você encontra dois lugares onde usei esse prefixo “th” para referir-se aos dados do controlador na view. Com a sintaxe `${attribute_key}`, você se refere a qualquer um dos atributos que você envia do controlador usando a instância Model. Por exemplo, usei `${username}` para obter o valor do atributo “username” e `${color}` para obter o valor do atributo “color”.

### 8.1.1 Getting data on the HTTP request
Nesta seção, discutimos como o cliente envia dados para o servidor através de solicitações HTTP. Em aplicativos, muitas vezes precisamos dar ao cliente a capacidade de enviar informações para o servidor. Esses dados são processados e, em seguida, exibidos na view, como aprendemos na seção 8.1. Aqui estão alguns exemplos de casos de uso onde o cliente precisa enviar dados para o servidor:

- Ao implementar a funcionalidade de pedido de uma loja online. O cliente precisa enviar ao servidor os produtos que o usuário está solicitando. Em seguida, o servidor cuida do processamento do pedido.
- Ao implementar um fórum web onde permitimos que os usuários adicionem e editem novas postagens. O clientee envia os detalhes da postagem ao servidor, que armazena ou altera esses detalhes no banco de dados.
- Ao implementar a funcionalidade de login de um aplicativo. Os usuários inserem suas credenciais, que precisam ser validadas. O cliente envia as credenciais ao servidor, e o servidor valida essas informações.

Na maioria dos casos, para enviar dados por meio da requisição HTTP, utilizamos uma das seguintes abordagens:
- **Um parâmetro de requisição HTTP (request parameters)**: representa uma forma simples de enviar valores do cliente para o servidor no formato de pares chave-valor. Para enviar parâmetros de requisição HTTP, precisamos anexar à URI em uma expressão de consulta de requisição. Esta abordagem deve ser utilizada apenas para enviar uma pequena quantidade de dados.
- **Um cabeçalho de requisição HTTP** é semelhante aos parâmetros de requisição, pois os cabeçalhos de requisição são enviados por meio do cabeçalho HTTP. A grande diferença é que eles não aparecem na URI, mas ainda assim não podemos enviar grandes quantidades de dados usando cabeçalhos HTTP.
- **Uma variável de caminho** envia dados por meio do próprio caminho da requisição. É semelhante à abordagem de parâmetros de requisição: utilizamos uma variável de caminho para enviar uma pequena quantidade de dados. No entanto, devemos usar variáveis de caminho quando o valor que estamos enviando é obrigatório.
- **O corpo da requisição HTTP** é usado principalmente para enviar uma maior quantidade de dados (formatados como uma string, mas às vezes até dados binários, como um arquivo.) 

Portanto, <span style="background:#d4b106">existem diversas formas de enviar dados para o servidor por meio de uma requisição HTTP</span>, cada uma dessas formas tem suas características específicas e é adequada para cenários diferentes, dependendo da quantidade de dados, do tipo de informação e das boas práticas de desenvolvimento.

Portanto:
**1. Parâmetros de Consulta (Query Parameters)**
- **Como funciona:** os dados são enviados como paras chave-valor anexados à URL, após o símbolo *?*. Por exemplo:
```
https://example.com/api/products?category=books&price=20
```
- **Quando usar:** 
	- Para enviar pequenas quantidades de dados;
	- Quando os dados são opcionais ou usados para filtrar resultados (como em buscas);

- **Vantagens:**
	- Simples de implementar e depurar, pois os dados aparecem diretamente na URL.

- **Dessvantagens:**
	- Não é adequado para grandes volumes de dados ou informações sensíveis (pois a URL pode ser armazenada em logs ou históricos do navegador). 

---

**2. Cabeçalhos HTTP (HTTP Headers)**
- **Como funciona:** os dados são enviados no cabeçalho da requisição HTTP, em vez do corpo ou da URL. Por exemplo:
```
GET /api/resource HTTP/1.1
Host: example.com
Authorization: Bearer token123
```
- **Quando usar:**
	- Para enviar metadados ou informações de controle, como tokens de autenticação (*Authorization*), idioma preferido (*Accept-Language*) ou tipos de conteúdo aceitos (*Accept*).

- **Vantagens:**
	- Mantém a URL limpa, pois os dados não aparecem nela;
	- Útil para informações que não fazem parte do "conteúdo principal" da requisição;

- **Desvantagens:**
	- Não é adequado para grandes quantidades de dados.

---

**3. Variáveis de Caminho (Path Variables)**
- Como funciona: os dados são incluídos diretamente no caminho da URL. Por exemplo:
```
https://example.com/api/users/123/orders/456
```
Aqui, *123* e *456* são variáveis de caminho que representam o ID do usuário e o ID do pedido, respectivamente.

- **Quando usar:**
	- Quando os dados são obrigatórios e fazem parte da estrutura lógica da requisição (como IDs de recursos). 

- **Vatagens:**
	- URLs mais limpas e semânticas.
	- Ideal para APIs RESTful, onde os recursos são identificados pelo caminho;

- **Desvantagens:**
	- Limitado a pequenas quantidades de dados e geralmente usado apenas para identificadores ou valores simples.

---
**4. Corpo da Requisição (Request Body)**
- **Como funciona:** os dados são enviados no corpo da requisição HTTP, geralmente formatados como JSON, XML ou outros formatos. Por exemplo:
```JSON
POST /api/users HTTP/1.1
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "securepassword"
}
```
- **Quando usar:**
    - Para enviar grandes quantidades de dados ou informações complexas.
    - Quando os dados são sensíveis ou não devem aparecer na URL.
- **Vantagens:**
    - Adequado para envio de dados estruturados ou binários (como arquivos).
    - Mantém a URL limpa e segura.
- **Desvantagens:**
    - Requer um pouco mais de configuração no cliente e no servidor para processar o corpo da requisição.

---

### 8.1.2 Using request parameters to send from client to server
Os **request parameters** são usados nos seguintes cenários:
- Quando a quantidade de dados enviados não é grande. Os parâmetros são definidos utilizando **variáveis de consulta (query parameters)**, como mostrado no exemplo desta seção. No entanto, essa abordagem impõe um limite de aproximadamente 2.000 caracteres.
- Quando é necessário enviar **dados opcionais**. O uso de parâmetros de requisição permite lidar de forma elegante com valores que o cliente pode não enviar. O servidor já espera que determinados parâmetros possam não ser fornecidos na requisição.

Um caso de uso comum para **parâmetros de requisição** é a definição de **critérios de busca e filtragem**. Suponhamos que o nosso aplicativo exiba detalhes de produtos em uma tabela, onde cada produto é identificado por um nome, um preço e uma marca. Nós desejamos que o usuário pesquise produtos com base em qualquer um desses critérios.

O usuário pode optar por buscar apenas pelo **preço**,  pelo **nome e a marca**, ou por qualquer outra combinação. Para esse tipo de cenário, **parâmetros de requisição são a escolha ideal**. O aplicativo envia cada um desses valores (nome, preço e marca) como **parâmetros opcionais**, e o cliente só precisa incluir na requisição os valores que deseja utilizar na busca.

Vamos utilizar um **parâmetro de requisição** modificando o exemplo anterior para que a cor na qual o nome de usuário será exibido seja recebido pelo cliente. A Listagem 8.3 mostra como alterar a classe do **Controller** para obter esse valor como um **parâmetro de requisição.**

Para obter o valor de um **parâmetro de requisição**, basta adicionar um novo parâmetro ao método de ação do **controller** e anotá-lo com *@RequestParam*. Essa anotação instrui o **Spring** a recuperar o valor do **Parâmetro HTTP** que possui o mesmo nome do parâmetro definido no método. 

![[Capítulo 8 - Implementing web apps with Spring Boot and Spring MVC-1.png]]
http://example.com/products<span style="background:#d4b106">?brand=honda</span> -> This is a query parameter expression. You use it to define request parameters in the path. He, the client sends a parameter identified with a key "brand" having the value *honda*.
The server returns all the products produced by the brand the user requested. 

![[Capítulo 8 - Implementing web apps with Spring Boot and Spring MVC-2.png]]
http://example.com/products<span style="background:#d4b106">?brand=honda&price=7000</span> -> The client can also send the price request parameter. This parameter is optional. The server searches by its value only if the client sends it.

![[Capítulo 8 - Implementing web apps with Spring Boot and Spring MVC-3.png]]


```java
public cclass MainController {
	@RequestMapping("/home")
	public String home(
		@RequestParam String color, Model page) {
			page.addAttribute("username", "Katy");
			page.addAttribute("color", color);
			return "home.html";
		}
	)
}
```
Você pode adicionar um novo parâmetro ao controller para obter este parâmetro também. O próximo trecho de código mostra essa alteração. 
```java
@Controller
public class MainController {
	@RequestMapping("/home")
	public String home(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String color,
			Model page) {
		page.addAttribute("username", name);
		page.addAttribute("color", color);
		return "home.html";
		}
		
		)
}
```

*http://localhost:8080/home?color=blue&name=Jane*

? - The request parameter query starts here.


<font color="#fbd5b5">color</font> - this is the key (or name) of the request parameters;
<font color="#fbd5b5">blue</font> - This is request parameter's value.

**name** - this is the key (or name) of the request parameters;
**Jane** - this is request parameter's value.

*@RequestParam(required = false)* -> isto indica que o parâmetro é **opcional**. Por padrão, quando usamos o *@RequestParam*, o Spring exige que o parâmetro esteja presente na requisição. Se ele não for passado, ocorrerá um erro *404 Bad Request*. No entanto, ao definir *required = false*, o Spring não exigirá esse parâmetro, e ele poderá ser **omitido** sem causar erro.


**NOTA:** Por padrão, um parâmetro de requisição *@RequestParam* é obrigatório. Se o cliente não fornecer um valor para ele, o servidor retornará uma resposta com o status HTTP 400 Bad Request.
Se desejar que o parâmetro seja opcional, você deve definir explicitamente isso na anotação, usando o atributo *required = false*.

### 8.1.3 Using path variables to send data from client to server
São partes variáveis do caminho da URL, usados para identificar recursos específicos. São comumente utilizados em APis RESTful. Portanto, os valores das variáveis são diretamente inseridos na **URL do caminho** (path):
http://localhost:8080/home/blue

Não identificamos mais o valor com uma **chave** como faz nos #request-parameters. Em vez disso, o valor é extraído diretamente de uma posição específica na URL do caminho *path*.

No servidor, esse valor é recuperado da URL com base na posição exata em que foi definido. É possível ter mais de um **path variable**, mas, geralmente, é melhor evitar o uso de mais de dois. Se houver mais de dois valores como **path variables**, a URL pode se tornar difícil de ler.

Por isso, prefiro utilizar **request parameters** quando há mais de dois valores, conforme discutido na seção 8.2.1.

Além disso, **path variables** não devem ser usadas para valores opcionais. Recomendamos o seu uso  apenas para parâmetros obrigatórios. Se houver valores opcionais a serem enviados na requisição HTTP, o ideal é usar **request parameters**, conforme discutido na seção 8.2.1.

A Tabela 8.1 compara as abordagens de **request parameters** e **path variables**..

**Request parameters**
- Can be used with optional values;
- It is recommended that you avoid a large number os parameters. If you need to use more than three, i recommend you use the request body, as you'll learn in chapter 10. Avoid sending more than three query parameters for readability;
- Some developers <span style="background:#affad1">consider the query expression more difficult to read than the path expression</span>.

**Path Variables**
- Should not be used with optional values;
- Always avoid sending more than three path variables. It's even better if you keep a maximum of two.
- Easier to read than a query expression. For a publicly exposed website, it's also easier for search engines (e.g., Google) to index the pages. This advantage might make the website easier to find through a search engine.

Quando a página que estamos criando depende de apenas um ou dois valores essenciais para o resultado final, é melhor colocá-los diretamente no *path variables*. Isso torna a requisição mais legível, a URL mais fácil de encontrar ao adicioná-lo aos favoritos no navegador e também melhora a indexação por mecanismos de busca (caso isso seja relevante para sua aplicação).

Para referenciar uma **path variable** em uma ação do **controller**, basta atribuir um nome a ela e adicioná-la à **URL** dentro de **chaves({})**. Em seguida, usamos a anotação *@PathVariable* para associar o parâmetro do método no **controller** ao valor extraído da URL.

```java
@Controller
public class MainController {
	@RequestMapping("/home/{color}")
	public String home(
		@PathVariable String color, 
		Model page) {
			page.addAttribute("username", "katy");
			page.addAttribute("color", color);
			return "home.html";
		}
	)
}
```
Marcamos o parâmetro onde nós queremos obter o valor da path variable com a annotation *@PathVariable*. O nome do parâmetro deve ser o mesmo do nome da variável no path.

![[Capítulo 8 - Implementing web apps with Spring Boot and Spring MVC-4.png]]

- The {color} path variable represents the value provided in the path;
- The action method's parameter with the name of the path variable, annotated with @PathVariable, gets the value from the path.

## 8.2 Using the GET and POST HTTP methods
Nesta seção, discutiremos os métodos HTTP e como o cliente os utiliza para indicar a ação que deseja realizar sobre um recurso - seja **criação**, **alteração**, **recuperação** ou **exclusão**.

Uma requisição HTTP é identificada por um **caminho (path)** e um **verbo (método HTTP)**. Até agora, mencionamos apenas o caminho e, sem perceber, utilizamos o método HTTP GET. Esse método serve para indicar que o cliente deseja apenas recuperar dados, sem modificá-los nos servidor.

No entanto, uma aplicação precisa fazer mais do que apenas buscar informações. Ela também precisar **modificar**, **adicionar e excluir dados**, exigindo o uso de outros métodos HTTP.

**NOTA:** Tome cuidado! Podemos usar um método HTTP de forma diferente do seu propósito original, mas isso está errado.

Por exemplo, tecnicamente é possível usar um **HTTP GET** para implementar uma funcionalidade que altere os dados, mas sessa é uma **péssima prática**.

Nunca devemos utilizar um método HTTP para algo diferente da sua finalidade original.

Até agora, utilizamos o **caminho da requisição** para direcionar a chamada a uma ação específica do controlador. No entanto, em cenários mais complexos, é possível **atribuir o mesmo caminho a múltiplas ações** dentro do controlador, desde que cada uma utilize um método HTTP diferente.