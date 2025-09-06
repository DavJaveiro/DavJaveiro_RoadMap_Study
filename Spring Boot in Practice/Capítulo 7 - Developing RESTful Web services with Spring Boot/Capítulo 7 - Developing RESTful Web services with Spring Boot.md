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

Os métodos definidos no trecho 7.3 são autoexplicativos. Eles contêm declarações de métodos que nos permitem realizar as operações CRUD na aplicação. Vamos agora fornecer uma implementação padrão que concretize esses métodos.

Geralmente, é uma boa prática definir uma interface contendo as operações suportadas pela API. Essa interface estabelece um contrato entre o **controlador** e as **operações disponibilizadas** na camada de serviço. Em seguida, podemos criar uma classe concreta que implemente essas operações. Além disso, na classe controladora (controller), utiliza-se o nome da interface em vez de especificar a classe de implementação concreta. No futuro, caso seja necessário fornecer uma implementação diferente para a camada de serviço, a classe controladora não será afetada, pois ela utiliza a interface e não está vinculada a uma implementação específica. O trecho 7.4 mostra a classe *DefaulttProductRepository*.

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