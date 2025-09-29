Este capítulo cobrirá:
- desenhando e projetando RESTful Web Services with Spring Boot
- Tratamento de exceções em RESTful Web Services
- Desenvolvimento de casos de teste unitário para testar RESTful Web services
- Documentação dos RESTful Web services através do OpenAPI
- Implementação de diferentes estratégias de versionamento para RESTful Web Services
- Técnicas para garantir a segurança dos RESTful Web Services

Na arquitetura baseada em microservices, é uma prática comum expor funcionalidades da aplicação por meio de RESTful APIs. Essas APIs podem então ser acessadas por uma variedade de dispositivos de aplicação, como aplicações desktop, dispositivos móveis, bem como outras APIs.

Neste capítulo, vamos apresentar o design e a construção de RESTful APIs com Spring Boot. Aprenderemos a documentar a API, para que os consumidores da API possam encontrar os detalhes necessários sobre ela, como as estruturas de request e response, e os métodos HTTP. Finalmente, aprenderemos a desenvolver casos de testes unitários para testar a API. Por último, veremos como proteger a nossa API RESTful. 

## 7.1 Developing a RESTful API with Spring Boot
Uma API RESTful (também conhecida como REST API) é uma interface de programaçao de aplicações que segue as restrições do estilo arquitetural REST, REST é um acrônimo para *representational state transfer* e foi criado por Roy Fielding. Em uma REST API, quando um cliente solicita um recurso ao servidor, o servidor fornece uma representação do estado do recurso solicitado ao cliente. Essa representação pode ser entregue em vários formatos, como JSON, texto puro, HTML e outros. Entretanto, o JSON é o formato mais amplamente utilizado no contexto de APIs REST.

O Spring Boot oferece suporte embutido no framework para projetar e construir REST APIs. O Spring Boot é um dos frameworks mais populares no ecossistema Java para o desenvolvimento de REST APIs. Nesta seção, exploraremos o desenvolvimento de uma API RESTful com Spring Boot.

### 7.1.1 Technique: Developing a RESTful API using Spring Boot
Nesta técnica, demonstraremos como desenvolver uma API RESTful utilizando o Spring Boot.

**Problem**
Anteriormente, utilizamos a aplicação Spring Boot Course Tracker com Thymeleaf como frontend. Agora, é necessário expor a aplicação Course Tracker como uma API RESTful. Expor a funcionalidade do backend da aplicação por meio de uma API RESTful permite o desacoplamento entre o backend e a interface do usuário (frontend). Essa abordagem de projeto permite que escolhamos os frameworks de frontend (por exemplo, Angular, React, Vue, etc.) de nossa preferência, sem ficar rigidamente acoplado ao backend.

**Solução**
Projetar APIs RESTful com Spring Boot é relativamente simples, pois o framework oferece suporte embutido para essa finalidade. Hoje em dia, o Spring Boot é a escolha padrão (de facto) entre os desenvolvedores Java para construir APIs RESTful. 

**Tabela 7.1** Pontos de extremidade REST expostos pela API Course Tracker  

|**Endpoint**|**Tipo de operação**|**Finalidade**|
|---|---|---|
|`/courses/`|GET|Retorna todos os cursos disponíveis na aplicação|
|`/courses/{id}`|GET|Retorna um curso com o ID fornecido|
|`/courses/category/{name}`|GET|Retorna a lista de cursos com o nome da categoria fornecida|
|`/courses/`|POST|Cria um novo curso|
|`/courses/{id}`|PUT|Atualiza o curso com o ID fornecido|
|`/courses/{id}`|DELETE|Exclui um curso com o ID fornecido|
|`/courses/`|DELETE|Exclui todos os cursos da aplicação|
A Tabela 7.1 contém os pontos de extremidade REST que permitem executar operações CRUD na aplicação Course Tracker. Para manter o exemplo simples, introduzimos apenas um número limitado de endpoints. Em uma aplicação em produção, podemos definir mais endpoints REST. Por exemplo, poderia haver endpoints adicionais do tipo GET que permitem filtrar os dados da aplicação conforme as necessidades específicas. No entanto, para demonstrar os conceitos, utilizaremos esses endpoints ao longo deste capítulo, pois eles cobrem as operações fundamentais (CRUD) suportadas pela maioria das APIs. 

Na aplicação Tá Salgado, estamos gerenciando os detalhes do curso. Portanto, definiremos a entidade de negócio *Course*. O trecho de código a seguir mostra essa classe.
```java
package com.manning.sbip.ch07.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME")     
    private String name;
    
    @Column(name = "CATEGORY")
    private String category;
    
    @Column(name = "RATING")
    private int rating;
    
    @Column(name = "DESCRIPTION")
    private String description;
}
```

The Course is a Java #POJO that models the course details in the application with fields such as course id, name, category, rating, and description. Next, let's define the *CourseRepository* interface, which lets us manage the courses in the database.

```java
public interface CourseRepository extends JpaRepository<Course, Long> {  
    List<Course> findAllByCategory(String description);  
}
```

Vamos  agora definir a camada #service de nossa aplicação. Nós definiremos a camada service com uma interface que forneça as operações suportadas em nossa aplicação.
```java
public interface CourseService {
	Course  createCourse(Course course);
	Optional<Course> getCourseById(long courseId);
	Iterable<Course> getCourseByCategory(String category);
	Iterable<Course> getCourses();
	void updateCourse(long courseId, Course couurse);
	void deleteCourseById(long courseId);
	void deleteCourses();
}
```

Os métodos definidos no trecho acima são autoexplicativos. Eles contêm declarações de métodos que nos permitem realizar as operações CRUD na aplicação. Vamos agora fornecer uma implementação padrão que concretize esses métodos.

Geralmente, é uma boa prática definir uma interface contendo as operações suportadas pela API. Essa interface estabelece um contrato entre o **controlador** e as **operações disponibilizadas** na camada de serviço. Em seguida, podemos criar uma classe concreta que implemente essas operações. Além disso, na classe controladora (controller), utiliza-se o nome da interface em vez de especificar a classe de implementação concreta. No futuro, caso seja necessário fornecer uma implementação diferente para a camada de serviço, <span style="background:#affad1">a classe controladora não será afetada</span>, pois ela utiliza a interface e não está vinculada a uma implementação específica. O trecho 7.4 mostra a classe *DefaulttProductRepository*.

```java
@Service  
public class DefaultProductService implements ProductService {  
  
    private final ProductRepository productRepository;  
  
    public DefaultProductService(ProductRepository productRepository) {  
        this.productRepository = productRepository;  
    }  
    public Product createProduct(Product product) {  
        return productRepository.save(product);  
    }  
    public Optional<Product> findProductById(Long courseId){  
        return Optional.ofNullable(productRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException(  
                ("Produto não encontrado"))));  
    }  
    public Iterable<Product> findAllProductsById() {  
        return productRepository.findAll();  
    }  
    public Product updateProduct(Product product) {  
        return productRepository.save(product);  
    }  
    public void deleteProductById(Long courseId) {  
        productRepository.deleteById(courseId);  
    }}
```

Nós vamos agora definir o *CourseController*, ele irá definir os endpoints REST. Um controlador Spring contém um ou mais endpoints e recebe as requisições do cliente. Em seguida, opcionalmente, utiliza os serviços oferecidos pela camada de serviço e gera uma resposta. Ele encapsula essa resposta em um modelo (model) e a compartilha com a camada de visualização (view layer). 

Um *RestController* também realiza uma atividade semelhante. No entanto, em vez de encapsular a resposta em um modelo e enviá-la à camada de visualização, ele vincula diretamente a resposta ao *body* da resposta HTTP, que é então retornado ao solicitante do endpoint.

```java
@RestController
@RequestMapping("/products/")
public class ProductController {...}
```
A anotação *RequestMapping* especifica a rota ou o caminho da API. Neste  exemplo, definimos o caminho /products/, de forma que todas as requisições HTTP para o caminho /products/ sejam direcionadas para este controller.

#RestController - indica que a classe é um controlador REST, combinando *@Controller* e *@ResponseBody*. Isso significa que os métodos retornam dados (JSON/XML) diretamente na resposta HTTP. 

#RequestMapping("/products/")  - define a rota base da classe. Ou seja, todos os endpoints dentro desse controller começarão com /products/.

```java
@GetMapping
public Iterable<Product> getProducts() {
	return productService.findAllProducts();
}
```
#GetMapping é uma forma *encurtada* de dizer **@RequestMapping(method= RequestMethod.GET**. Como nenhum caminho foi especificado dentro de GetMapping, esse método será chamado quando alguém fizer uma requisição **HTTP GET** para a URL base do controller.

```java
@GetMapping("{id}")
public Optional<Product> getProductById(@PathVariable("id") long productId) {
	return productService.getProductById(productId);
}
```

@GetMapping define que a rota vai aceitar URLs no formato */courses/{id}*. 
{id} é um **path variable**, ou seja, uma parte da URL que varia.

**Discussão**
Com essa técnica, aprendemos a criar uma API RESTful completa. Mantivemos a aplicação extremamente simples para demonstrar os conceitos. Vamos agora discutir algumas práticas recomendadas que seguimos ao projetar a API REST.

Utilizamos JSON para aceitar as requisições e, de forma semelhante, respondemos com JSON na resposta. Essa é uma prática recomendada. APIs REST devem aceitar cargas de requisição (request payloads) em formato JSON e fornecer respostas também em #JSON.

O #JSON é amplamente utilizado para armazenar e transferir dados. O Spring Boot oferece suporte embutido para realizar o mapeamento entre JSON e POJOs (objetos Java simples) e vice-versa. Por exemplo, se observamos no trecho 7.6, enviou-se uma requisição JSON como carga útil para criar um novo curso na aplicação. No entanto, o endpoint POST aceita uma instância de Course. O Spring Boot realiza essa desserialização internamente para nós. Por padrão, ele utiliza a biblioteca Jackson para realizar esse mapeamento.

Outro ponto importante a destacar é o uso de substantivos ao definir os caminhos dos endpoints. É uma prática recomendada utilizar a forma plural do substantivo (por exemplo, Courses, Persons, Vehicles, etc.) para definir as rotas. Não devemos usar verbos nos caminhos das rotas, pois o método da requisição HTTP já possui um verbo (por exemplo, GET, POST, etc.) que define a ação. Permitir que desenvolvedores utilizem verbos nos caminhos torna esses caminhos mais longos e inconsistentes. Por exemplo, para obter os detalhes de um curso, um desenvolvedor pode usar /getCourses, enquanto outro pode usar /retrieveCourses. Entretanto, o verbo "get" ou "retrieve" já está definido pelo método HTTP GET. Assim, especificar o verbo no caminho da rota torna-o redundante. Portanto, GET /courses/ é o caminho do endpoint preferido para obter todos os cursos. Da mesma forma, POST /courses/ é o endpoint apropriado para criar um novo curso.

Vamos agora apresentar um diagrama de fluxo de alto nível que mostra o processamento de requisições e respostas em uma API REST em uma aplicação Spring Boot. A figura 7.1 mostra esse diagrama.


![image-2025971654326.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%207%20-%20Developing%20RESTful%20Web%20services%20with%20Spring%20Boot/Cap%C3%ADtulo%207%20-%20Developing%20RESTful%20Web%20services%20with%20Spring%20Boot/image-2025971654326.png)
Figura 7.1 Diagrama de fluxo de comunicação em uma API REST. Um usuário invoca um endpoint REST, que é tratado pelo Controlador REST. O controlador, então, utiliza a camada de serviço para processar a requisição. A camada de serviço depende do repositório para se comunicar com o banco de dados. Após receber uma resposta do repositório, ela é processada pela camada de serviço e encaminhada ao controlador. O controlador pode realizar processamentos adicionais, e a resposta final é fornecida ao cliente da API.

No trecho 7.5, utilizamos a anotação *@RestController* no lugar da anotação *@Controller* usada anteriormente. A anotação *@RestController* é uma anotação de conveniência que é meta-anotada com as anotações *@Controller* e *@ResponseBody*. A anotação *@ResponseBody* indica que o valor de retorno de um método deve ser vinculado diretamente ao corpo da resposta HTTP. 

Embora a API funcione bem e atenda ao propóstio, atualmente não há tratamento de exceções. Por exemplo, vamos tentar excluir um curso que não existe na aplicação. Notaremos que será exibido um erro com um grande e feio rastreamento de pilha (stack trace). Corrigiremos isso na próxima técnica.

## 7.2 Managing exceptions in a Spring Boot RESTful API
Exceções são inevitáveis no código de software. Diversos fatores podem causar um cenário excepcional em nosso código. Por exemplo, na API RESTful que projetamos, um usuário pode tentar acessar ou excluir um curso com  um ID inexistente. Ele também pode enviar um payload JSON malformado para criar um novo curso através do endpoint POST. Todos esses cenários geram exceções na API. Nesta seção, discutiremos como lidar com esses exceções e fornecer uma resposta significativa ao usuário, especificando os detalhes da exceção.

### 7.2.1 Technique: Handling exceptions in a RESTful API
In this technique, we'll discuss how to handle exceptions in a RESTful API.

**Problem**
A API RESTful definida anteriormente não é capaz de lidar com erros, pois não há tratamento de exceções em vigor. Ela apresenta ao usuário um grande rastreamento de pilha que não é intuitivo e expõe detalhes internos do aplicativo. Você precisa tratar as exceções e garantir o fornecimento de respostas de erro significativas. 

**Solution**
O tratamento de exceções é um aspecto importante de uma API RESTful. Normalmente, nossas APIs serão consumidas por uma variedade de consumidores e a capacidade de fornecer uma resposta de erro significativa no caso de um cenário de exceção torna a nossa API robusta e fácil de usar. 

Na API projetada, não tratamos as exceções e o mecanismo padrão de tratamento de exceções do Spring Boot está em vigor. Por exemplo, a exclusão de um curso que não existe no aplicativo apresenta uma mensagem de erro, conforme mostrado na listagem a seguir:

Expor ao **caller** informações sobre a **tech stack** usado na implementação da API, é considerado uma falha de segurança. Além disso, o HTTP response code também é genérico (500 Internal Server Error), o que indica que ocorreu um erro no lado do servidor. Nesta técnica, vamos melhorar a **Course Tracker RESTful API** implementando exception handling na API.

Para começar, vamos primeiro discutir os tipos de exceptions que podemos encontrar em nossa aplicação. Para esta API, podemos ter apenas alguns cenários de exceção. Por exemplo, pode ser que um usuário tente buscar, atualizar ou deletar um **course** que não existe na aplicação. Isso deve resultar em um HTTP 404 Not Found error, já que o recurso solicitado não existe na aplicação. Também é possível que o usuário envie um JSON payload incompleto/incorreto. Isso resulta em um HTTP 400 Bad Request status code, já que a requisição do usuário não pode ser processada porque o servidor não conseguiu fazer o **parse** da requisição, pois ela está malformada.

Para lidar com o primeiro cenário, vamos criar uma **custom exception** chamada **CourseNotFoundException**, conforme mostrado no listing a seguir:
```java
package com.manning.sbip.ch07.exception;
public class CourseNotFoundException extends RuntimeException {
private static final long serialVersionUID = 5071646428281007896L;
public CourseNotFoundException(String message) {
super(message);
}
}
```

Essa CourseNotFoundException é lançada sempre que os usuários da API tentam acessar um curso que não existe no aplicativo. Vamos agora redefinir a classe CourseServiceImpl para realizar uso deste tratamento de exceção.

Agora que lançamos uma exception, o que vem a seguir? Precisamos definir um **exception handler** que intercepte a exception lançada e execute a lógica de custom exception handling. Por exemplo, para uma unhandled exception, o HTTP responde code 500 Internal Server Error é retornado. No entanto, se um course como courseId fornecido não existir na aplicação, o HTTP error code apropriado deve ser 404 Not Found. Este último HTTP Response code informa ao API consumer que o course que ele está acessando não existe.

Vamos definir a classe GlobalExceptionHandler, que estabelece os ExceptionHandlers da nossa aplicação.

#GlobalExceptionHandler é uma classe anotada com #ControllerAdvice que funciona como uma rede de segurança para toda a nossa aplicação. Ela tem métodos que são acionados apenas quando uma exceção específica acontece em **qualquer um dos nossos controllers.**


Na classe do Listing 7.11, definimos algumas implementações de ExceptionHandler que tratam as exceptions que podem ser lançadas durante o processamento das requisições. Vamos explorar essa classe em detalhes:
- Essa classe está anotada com *@ControllerAdvice*. Essa anotação é um *@Component* especializado que permite declarar o *@ExceptionHandler*. A anotação *@ControllerAdvice* possibilita escrever código global que se aplica a um conjunto de *controllers* e *RestControllers*. Assim, o **ExceptionHandler** definido no Listing 7.11 se aplica a todos os *controllers* da aplicação. 
- Essa classe estende a ResponseEntityExceptionHandler, que é uma classe base para classes anotadas com @ControllerAdvice e que fornecem um tratamento centralizado de exceptions em todos os métodos anotados com *@RequestMapping* por meio dos métodos **@ExceptionHandler**. Essa classe já provê lógica de exception handling para uma variedade de exceptions que podem ocorrer na aplicação.

Portanto a GlobalExceptionHandler tem como função interceptar um tipo específico de erro que pode acontecer em qualquer lugar de nossa aplicação. O CourseNotFoundException  e transformá-lo em uma resposta HTTP bonita e padronizada para o cliente, em vez de deixar o servidor quebrar e mostrar um erro feio.

- #ControllerAdvice: essa é a anotação mais importante. Ela diz ao Spring: "Ei, essa classe não é um controller comum. Ela é um conselheiro global. Fique de olho nela, porque ela tem instruções sobre como lidar com erros que podem acontecer em qualquer controller da aplicação."
- #ResponseEntityExceptionHandler: essa classe do Spring já vem com vários métodos prontos para lidar com erros web comuns. Ao estendê-la, herdamos toda essa inteligência e podemos adicionar nossos próprios tratamentos de erro, como estamos fazendo.
- #ExceptionHandler(value= { CourseNotFoundException.class}): esse é o gatilho. Ele diz, método, você só deve executar quando um erro do tipo exato CourseNotFoundException for lançado em algum lugar. Se qualquer outro erro acontecer, esse método será ignorado.
- **public ResponseEntity< ? > handlerCourseNotFound(CourseNotFoundException**: esta é a assinatura do método que trata o erro. 
- return super.handlerExceptionInternal(...) é essa linha que constrói a resposta final. Estamos chamando um método útil da classe pai. 

**Discussion**
A capacidade de uma API RESTful de lidar com diversos erros de usuário e responder com os códigos de status HTTP e mensagens de erro apropriados a torna robusta e fácil de usar. Isso também deixa a aplicação mais aderente ao próprio paradigma RESTful.

Ao projetar APIs, é uma prática comum primeiro identificar os possíveis cenários de erro na aplicação. Em seguida, podemos definir classes de exceção personalizadas que representem esses cenários identificados. Uma das vantagens de projetar uma exceção personalizada é que ela permite modelar a exceção de uma forma mais adequada e oferece flexibilidade para capturar vários detalhes sobre ela.

Depois, podemos definir um #ExceptionHandler que intercepte essas classes de exceção e permita criar uma resposta de erro personalizada. Por exemplo, tentamos definir um #exception handler que trate cargas de requisição inválidas (wrong request payloads) e responda com o HTTP 400 Bad Request. Isso é deixado como exercício para os leitores.

## 7.3 Testing a RESTful API
Nas técnicas anteriores, aprendemos a construir uma RESTful API. Depois de concluir o desenvolvimento, a próxima tarefa é testar os endpoints da API para garantir que ela esteja funcionando conforme o esperado. Existem múltiplas formas de testar uma REST API, como mostrado na figura 7.2

Figura 7.2 Opções para testar uma RESTful API. As utilidades de **command line** incluem cURL, HTTPie. 
As ferramentas baseadas em GUI incluem Postman, SoapUI. 
O unit testing (testes unitários) pode ser feito com Spring Boot MockMVC em conjunto com o JUnit.

Até agora, discutimos o uso da ferramenta de command line HTTPie, que pode ser utilizada para acessar os endpoints. Também podemos usar o cURL para testar os endpoints. 

No REST API testing, o Postman é amplamente utilizado para desenvolvedores de API para testar as APIs.

Na próxima seção, dicutiremos como testar uma REST API por meio de integration testing. Sem´re é uma best practice escrever test cases para os entpoins que são executados enquanto construímos nossa API. 

### 7.3.1 Techinque: testing a RESTful API in a Spring Boot application
**Solution**
Em uma aplicação típica, para testar nossas classes, podemos instanciá-las e invocar os métodos definidos nelas ou utilizar **mocking frameworks**, como o Mockito, para mockar a classe e outros componentes.

Em uma aplicação Spring MVC, podemos definir test cases de forma semelhante. No entanto, isso não verifica alguns recursos importantes do MVC framework, como request mapping, validation, data binding, @ExceptionHandler, entre outros.

O **Spring MVC** fornece um **testing framework** que disponibiliza capacidades de teste abrangentes para aplicações baseadas em **Spring MVC**, sem a necessidade de um servidor real. Esse framework, também conhecido como **MockMVC**, realiza o tratamento de requisições **MVC** por meio de objetos de requisição e resposta **mock**.

Nesta técnica, vamos mostrar como usar o Spring MockMVC framework em uma aplicação Spring Boot para testar uma REST API. Definiremos integration test cases para os APIS endpoints que criamos nas técnicas anteriores.

Vamos começar definindo o primeiro test case, que cria um curso em nossa aplicação Course Tracker.

[[ProductsApiApplicationTests.java]]
- A anotação **@SpringBootTest** indica que a classe anotada executa Spring Boot-based tests e fornece o suporte de ambiente necessário para rodar os test cases. Ela cria o Spring application.context, que instancia os Spring beans necessários para executar os testes.
- A anotação **@AutoConfigureMockMvc** habilita e auto-configura o **MockMVC** framework. Essa anotação faz o trabalho pesado para fornecer o suporte necessário, permitindo que simplesmente façamos o **autowire** de uma instância de **MockMVC** e a utilizemos no teste.
- A anotação **@ExtendWith(SpringExtension.class)** integra o **Spring TestContext Framework** com o modelo de programação Jupiter do Junit 5. @ExtendWith é uma anotação do Junit 5 que permite especificar a extension a ser usada para executar o test case.
- Fizemos o autowire do CourseService e da instância MockMvc na classe.
- Utilizamos a instância mockMvc para executar uma operação HTTP POST com um curso de exemplo.


**A ação e as verificações (O Act e o Assert)**
```java
MockHttpServletResponse response = mockMvc.perform(post("/courses/"))
	.contentType("application/json")
	.content(objectMapper.writeValueAsString(course)))

```

Uma vez que a requisição é disparada, usamos o **andExpect** para verificar vários atributos. Usamos o jsonpath para extrair os valores da resposta JSON. Por fim, validamos o código de status da resposta HTTP. Agora, vamos fornecer o caso de teste para obter o curso pelo ID. A listagem a seguir mostra esse caso de teste.

**Discussion**
Spring MockMVC framework provides an excellent way to test Spring MVC-based applications. Moreover, Spring Boot autoconfiguration of MockMVC has simplified defining the test cases even further. O Spring também oferece um cliente de teste alternativo chamado WebTestClient, que permite verificar a resposta de uma forma muito mais eficaz. Demonstraremos o uso do WebTestClient no próximo capítulo.

## 7.4 Documenting a RESTful API
Como parte do desenvolvimento moderno de aplicações, APIs desempenham um papel crítico no sucesso de uma aplicação. À medida que os recursos da aplicação são consumidos por uma variedade de dispositivos, é importante que as APIs sejam documentadas. Além disso, uma API representa um contrato entre um provedor de API e os seus consumidores. Portanto, uma boa API deve garantir que os detalhes da API estejam disponíveis para seus consumidores, para que eles possam desenvolver seu código de acordo. Esses detalhes incluem a estrutura de HTTP request e response, o HTTP status code que um endpoint retorna, configurações de segurança e vários outros detalhes. Nesta seção, discutiremos a documentação das RESTful APIs por meio do OpenAPI, que é o padrão mais popular e de fato para documentação de RESTful  API.

### 7.4.1 Technique: Documenting a RESTful API with OpenAPI
In this technique,  we'll learn how to document a RESTful API.

**Problem**
The Course Tracker API is currently undocumented, e não há meios além da exploração do código-fonte da aplicação para descobrir os detalhes relacionados à API. Precisamos documentar essa API com OpenAPI, para que os consumidores da API possam encontrar as informações necessárias sobre ela.

**Solution**
A #openapi specification fornece uma abordagem padronizada para documentar RESTful APIs, permitindo que os consumidores da API descubram os detalhes e capacidades da API de forma consistente. A especificação OpenAPI é independente de linguagem (language-agnostic), o que significa que não está limitada apenas ao Spring Boot, estando disponível também para outras linguagens e frameworks. Por exemplos, podemos usar OpenAPI para documentar uma API RESTful desenvolvidaa com uma aplicação Spring Boot, e o mesmo é possível para uma RESTful API desenvolvida com Express JS.

Nesta seção, demonstraremos como documentar a Course Tracker API com OpenAPI. Para isso, vaamos adicionar primeiramente a dependência Maven no arquivo pom.xml:
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>
```

A biblioteca *springdoc-openapi* automatiza a geração da documentação da API em um projeto Spring Boot. Ela faz isso inspecionando a aplicação Spring Boot em tempo de execução para inferir a semântica da API com base nas configurações do Spring, estrutura das classes e outras anotações.

A dependência **springdoc-openapi-ui** fornece a integração entre Spring Boot e Swagger UI. Ela implementa automaticamente o **swagger-ui** na aplicação Spring Boot e o disponibiliza em  ``http://{server}:{port}/{context-path}/swagger-ui.html.`` 

Vamos esclarecer as diferenças entre o #Swagger e #openapi:
- **OpenAPI** é a especificação que dita as diretrizes para a documentação da API.
- **Swagger** é a ferramenta que implementa essa especificação.
O Swagger é composto poro vários componentes, como:
- **Swagger Editor**
- **Swagger UI**
- **Swagger Codegen**
- E outros módulos...

Para documentar a API, anotamos os endpoints com diversas anotações. Essas anotações contêm detalhes personalizados sobre o endpoint, como:
- A finalidade do entpoin;
- O código de status HTTP que ele retorna;
- E outras informações relevantes.

Mostrando o *CourseController* atualizado com as anotações do OpenAPI:
```java
@RestController
@RequestMapping("/courses/")
@Tag(name = "Course Controller, description = "This REST controller provide services to manage courses in the Course Tracker application")
public class CourseController {
		private CourseService courseService;
		
		@Autowired
		public CourseController(CourseService courseService) {
			this.courseService = courseService;
		}
		
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		@Operation(summary = "Provides all courses available in the Course Tracker application")
		public Iterable<Course> getAllCourses() {
			return courseService.getCourses();
		}
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		@Operation(summary = "Provides course details for the supplied course id from the Course Tracker application")
		public Optional<Course> getCourseById(@PathVariable("id") long courseId)
		{
			return courseService.getCourseById(courseId);
		}
		
		@PostMapping()
		@ResponseStatus(code = HttpStatus.CREATED)
		@Operation(summary = "Creates a new course in the Course Tracker application")
		public Course createCourse(@Valid @RequestBody Course course) {return courseService.createCourse(course);}
		
		
		@DeleteMapping("{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		@Operation(summary = "Delete the course details for the supplied course id from the Course Tracker Application")
		public void deleteCourseById(@PathVariable("id") long courseId) {
			courseService.deleteCourseById(courseId);
		}
		
		@DeleteMapping
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		@Operation(summary = "Deletes all courses from the Course Tracker application")
		public void deleteCourses(){
			courseService.deteleteCourses();
		}
}
```

Na listagem acima, anotamos a classe com *@Tag* e os endpoints com as anotações *@ResponseStatus* e *@Operation*.

Observe que o código de status HTTP é fundamental para o consumidor da API implementar a lógica da sua aplicação, pois ele define o estado da chamada da API. Por isso, devemos ter cuidado ao determinar o código de status HTTP para os endpoints.
Por fim, a anotação *@Operation* captura detalhes sobre a finalidade do endpoint.

Agora vamos capturar alguns detalhes personalizados sobre a API, como versão da API, título, descrição, informações de licença e outros. Isso pode ser feito definindo um bean Spring do tipo *OpenAPI*.

O código abaixo mostra a definição do bean *OpenAPI*. Para simplificar, esse bean foi definido na classe principal do Spring Boot, conforme mostrado abaixo. Em uma aplicação típica, o ideal é definir uma classe de configuração Spring separada que contenha essa definição com *@Bean*.

```java
@Bean  
public OpenAPI customOpenAPI(@Value("${app.description}") String appDescription,  
       @Value("${app.version}") String appVersion) {  
  
    return new OpenAPI().info(new Info().title("Course Tracker API").version(appVersion)  
          .description(appDescription).termsOfService("http://swagger.io/terms/")  
          .license(new License().name("Apache 2.0").url("http://springdoc.org")));  
  
}
```
Definimos o bean *OpenAPI*, que contém os detalhes personalizados da API.
Na listagem 7.19, definimos as propriedades **app.description** e **app.version** no arquivo application.properties.

```json
app.description=Spring Boot Course Tracker API
app.version=v1
```

**Discussão**
O OpenAPI é a escolha padrão (de facto) para documentar RESTful APIs. Como vimos no exemplo anterior, ao adicionar algumas dependências, você obtém uma documentação da API em formato html bastante útil, que captura os detalhes da API.

No entanto, um problema com o HTML é que ele é difícil de compartilhar com os consumidores da API. Para lidar com isso, o **Swagger** também permite extrair a documentação da API em formato JSON.

Podemos recuperar esse JSON acesso a URL:
`http://localhost:8080/v3/api-docs`

Swagger provides de Swagger Editor, which allows you to import this JSON and renders the same HTML layout.


## Implementing RESTful API versioning
