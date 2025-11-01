#flashcards/ReactiveSpringBoot

This chapter covers
- Introducing reactive programming with Spring WebFlux;
- Developing reactive RESTful APIs with annotated controller and functional endpoints;
- Accessing reactive RESTful APIs with WebClient
- Developing Spring Boot applications with RSocket
- Using WebSocket and Spring Boot to develop application

O Spring Framework oferece uma pilha de tecnologia alternativa com o **Spring WebFlux** para desenvolver aplicações reativas. O Spring WebFlux, que é baseado no **Project Reactor**, oferece utilitários que permitem projetar aplicações reativas com controles como **nonblocking, backpressure**, e escrita de código de forma **declarativa**. Ele também fornece o utilitário **WebClient** com uma fluent API para consumir as APIs.

Neste capítulo, veremos os protocolos **RSocket** e **WebSOCKET**, que oferecem <span style="background:#b1ffff">suporte à comunicação</span> **bidirecional** entre as partes comunicantes. Por fim, demonstraremos como usar esses protocolos em uma aplicação Spring Boot.

## 8.1 Introduction to reactive programming
**Programação reativa** é a programação com fluxo de dados assíncronos. Vamos abordar o conceito de fluxo de dados assíncrono discutindo os termos assíncrono e fluxo de dados (data stream).

Um fluxo de dados refere-se a uma sequência de dados em que as informações são **emitidas**, uma após a outra, dentro de um **intervalo de tempo**. Esse fluxo pode ser criado a partir de diversas fontes: **entradas de usuário**, **propriedades**, **caches**, **bancos de dados**, entre outros.
Vamos entender melhor esse conceito por meio de uma comparação entre o **processamento de dados tradicional** e o **processamento baseado em fluxos** (*stream processing*). 

![image-20251064126891.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251064126891.png)
Na figura, temos o método tradicional de processamento de dados, onde uma requisição do usuário é recebida pela aplicação, e os dados solicitados são recuperados do banco de dados pela aplicação. Em seguida, esses dados recuperados são **processados** e **retornados ao usuário**.

Já, ao lado direito, demonstramos o **processamento de fluxo (stream processing).** Nesse modelo, a aplicação se inscreve (subscribe) em um **fluxo de dados** (data stream) e recebe os dados assim que eles estão disponíveis. A aplicação então processa os dados e publica o resultado em outro fluxo. Na figura, há um fluxo de números ao qual a aplicação está inscrita. À medida que a aplicação recebe o fluxo de dados, ela processa cada elemento multiplicando por dois, e os resultados são publicados em outro fluxo.

Agora, vamos discutir o conceito de **processamento assíncrono**. O termo assíncrono significa que, para uma requisição, a resposta associada é retornada apenas quando estiver pronta, sem que a thread chamadora precisar aguardar por ela. A figura 8.2 mostra uma comparação entre o **processamento síncrono (syncronous)** e o **assíncrono**":

![image-20251062133192.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251062133192.png)

Antes de prosseguirmos, vamos discutir um **exemplo do mundo real** de **fluxos de dados assíncronos**. Os **eventos de clique do mouse** são um exemplo clássico. Os usuários de uma aplicação podem **clicar em um botão** e **gerar um evento**, que pode ser observado e reagido através de alguma ação na aplicação. Podemos imaginar esses eventos como um fluxo contínuo de eventos assíncronos. 

Logo, um fluxo (stream) é uma **sequência contínua de eventos ordenados no tempo**. Um fluxo pode emitir três tipos de sinais:
- um valor,
- um erro, ou
- um sinal de conclusão (complete signal)

O valor indica que o fluxo **emitiu uma informação** sobre a qual uma função pode ser aplicada para realizar alguma ação.
O erro significa que o fluxo **produziu uma falha**, permitindo acionar um **mecanismo de tratamento de erros( erros handling)**.
Por fim, o sinal de conclusão marca o fim do fluxo. 

Os eventos são **emitidos de forma assíncrona**, e nós ouvimos (listen) esses eventos definindo funções que reagem quando eles ocorrem, por exemplo:
- uma função para os dados emitidos
- uma para erros, e
- outra para a conclusão do fluxo.

Na programação reativa, esse ato de "ouvir" é chamado de **subscribing**. As **funções** que reagem aos eventos são chamadas de **observers** (observadores), e o fluxo de dados é o **observable** (observável), que está sendo observado. Este conceito é conhecido como o **padrão de projeto Observer (observer design pattern)**.

**Note**
O #SpringWebFlux e a programação reativa em geral, é um tema extenso, e está além do escopo deste texto oferecer uma discussão mais aprofundada sobre o assunto.

Neste capítulo, nosso objetivo é introduzir a programação reativa e demonstrar como desenvolver aplicações reativas com Spring Boot. 

### 8.1.1 Backpressure
Vamos aprender outro conceito importante na programação reativa: o #backpressure.

No entanto, antes de discutir esse conceito, é importante entender as noções de métodos push e pull em uma relação de produtor e consumidor. 

Um consumidor se inscreve (subscribes) para receber dados de um **produtor**, e o **produtor envia (pushes)** esses dados ao consumidor. 
![image-20251061830250.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251061830250.png)

Na figura cima, um produtor    envia (pushes) eventos para o consumidor inscrito (subscribed  consumer). Essa configuração funciona bem quando a taxa de consumo do consumidor é igual à taxa de envio do produtor. 

No entanto, o que acontece se o consumidor processar os eventos mais lentamente do que o produtor os envia? Nesse caso, o consumidor pode colocar os eventos em uma fila (buffer) para armazená-los temporariamente.

![image-20251062249380.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-20251062249380.png)

O consumidor pode escolher entre um **buffer limitado** (bounded) ou um buffer ilimitado (unbounded) para armazenar os eventos adicionais.

Com um **bounded buffer**, alguns eventos serão descartados, pois o buffer possui **espaço limitado**. Neste caso, o produtor pode precisar reenviar os eventos perdidos, o que implica sobrecarga adicional de rede, processamento de CPU e uma configuração mais complexa de processamento de eventos.

Por outro lado, um **unbounded buffer** pode levar a um **erro de falta de memória (out of memory error)** se o buffer se encher rapidamente de eventos, podendo causar a indisponibilidade da aplicação. 

Para evitar esse problema, podemos optar pelo método pull em vez do push. 
No método pull, o consumidor solicita eventos ao produtor de acordo com sua capacidade de processamento, conforme mostrado na figura 8.6.

Na figura 8.6, o consumidor solicita três eventos ao produtor, e este retorna três eventos. Esse processo permite que o consumidor **decida dinamicamente quantos eventos deseja receber do produtor**, com base em sua capacidade,  e isso é conhecido como backpressure.

### 8.1.2 Benefits of reactive programming
- **No Blocking** - normalmente, no modelo de programação traidiconal, os desenvolvedores escrevem códigos bloqueantes. Por exemplo, a thread chamadora precisa aguardar os dados ao acessar uma API remota ou realizar uma chamada ao banco de dados. Embora funcione, este apresenta problemas de **escalabilidade e desempenho**, além de **desperdiçar recursos do sistema** apenas esperando os dados. O modelo reativo elimina esses gargalos.

- **Melhor modelo assíncrono na JVM** - O Java oferece duas abordagens principais para **programação assíncrona:** 
	- Callback
	- Future
Com #Callback, um método assíncrono recebe um **parâmetro extra** que é **invocado quando o resultado está disponível.** Com **Future**, os métodos assíncronos retornam imediatamente um Future< T>, enquanto o valor T é computador de forma assíncrona e encapsulado dentro do Future. O resultado dentro do **Future** só fica acessível **quando estiver pronto**.

- **Callbacks** são difíceis de compor e podem gerar o famoso **callback hell** (aninhamento excessivo e difícil de gerenciar).
- **Futures** são uma melhoria, mas ainda **não oferecem uma boa composição** de operações assíncronas.
- No modelo reativo, o código é **declarativo** — você define **o que deve ser feito**, e não **como deve ser feito**. Isso torna o código **mais legível** e **melhor estruturado**.
    
- Existe um **conjunto rico de operadores** que podem ser aplicados ao **data stream**.
    
- O **processamento** (ou as operações) **só começam quando o método `subscribe()` é invocado** no fluxo.
    
- O **conceito de backpressure** permite que o **consumidor sinalize ao produtor** quando a **taxa de emissão está muito alta**.

## 8.2 Understanding Project Reactor
> [!PDF|yellow] [[Spring Boot in Practice.pdf#page=380&selection=9,0,9,74&color=yellow|The Reactor is a fully nonblocking reactive programming model for the JVM.]]
> > The Reactor is a fully nonblocking reactive programming model for the JVM.
> O Reactor é um modelo de programação reativa totalmente nonblocking para a JVM. Ele é baseado em Reactive Stream

**Reactive Streams** é um padrão e uma especificação para bibliotecas orientadas a Stream. Ele processa um número potencialmente ilimitado de elementos em uma sequência e também permite a passagem assíncrona de elementos entre **operators** com **nonblocking backpressure**. 

A Reactive Streams API é relativamente simples e fornece quatro interfaces principais, conforme mostrado abaixo:
```java
public interface Publisher<T> {
	public void subscribe(Subscriber<? super T> s);
}

public interface Subscribe<T> {
	public void onSubscribe(Subscription s);
	public void onNext(T t);
	public void onError(Throwable t);
	public void onComplete();
}

public interface Subscription {
	public void request(long n);
	public void cancel();
}

public interfaace Processor<T, R> extends Subscrbier<T>, Publiser<R> {
}
```

- **Publisher -** um publisher é um provedor de um número potencialmente ilimitado de elementos sequenciados e  os publica de  acordo com a demanda de seus subscribes. O método subscribe() da interface Publisher permite que os **subscribers** se inscrevam no produto.

- **Subscriber** - um subscriber decide quando e quantos elementos ele é capaz e está disposto a receber. O método **onNext()** permite que o subscriber processe os dados recebidos, onError() trata os erros, onComplete() finaliza as tarefas, e onSubscribe() realiza a inscrição com parâmetros.

- **Subscription** - uma **subscription** representa o relacionamento entre um subscriber e o produtor. O subscriber tem controle sobre quando os elementos são solicitados e quando não são mais necessários. O método **request()** é usado para solicitar os dados, e o método cancel() é usado para cancelar as inscrições. 

- **Processor** - um processor representa uma etapa de processamento e está vinculado tanto às especificações de publisher quanto às de subscriber.

The Figure 8.7 shows the communication between the Subscriber, Publisher, and Subscription interfaces.

![image-202510102746843.png](Spring%20Boot%20in%20Practice/Cap%C3%ADtulo%208%20-%20Reactive%20Spring%20Boot%20application%20development/Chapter%208%20-%20Reactive%20Spring%20Boot%20application%20development/image-202510102746843.png)

Vamos discutir como essas APIs se comunicam entre si:
1. Um #subscriber usa o método **subscribe()** da interface **Publisher** para adicionar uma **subscription** a um publisher.
2. Um publisher usa o método **onSubscribe()** da interface Subscriber para enviar a Subscription ao subscribe.
3. Um subscribe usa os métodos **request()** ou **cancel()** da interface **Subscription** para solicitar ou cancelar dados do publisher.
4. O publisher usa os métodos **onNext()**, **onComplete()** e **onError()** da interface **Subscriber** para enviar dados ou um erro a um subscriber por meio da subscription.

O principal componente da biblioteca #Reactor é o módulo **reactor-core**, que é construído sobre as especificações de **Reactive Stream** e voltado para o Java 8. O #reactor fornece tipos reativos componíveis, como **Flux** e **Mono**, que implementam a interface **Publisher**.

Um #Flux é um publisher padrão que representa uma sequência assíncrona de 0 a N itens emitidos, opcionalmente terminada por um erro ou um sinal de conclusão.

Um #Mono é um publisher especializado que emite no máximo um item através do sinal **onNext**, que é então finalizado por um **onComplete** (Mono bem-sucedido) ou emite apenas um único sinal **onError**.


---
Modelo de caso para a geração de  cupons via API:

Quando um cliente realizar a compra, o nosso sistema precisa:
1. Gerar o cupom fiscal
2. Salvar no banco de dados
3. Gerar o QR code
4. Retornar o link de download do pdf

Em um modelo #reativo, cada uma dessas etapas pode ser um **Publisher** emitindo dados (cupom -> QR -> PDF), e o sistema reage conforme os dados chegam, sem bloquear a thread principal. 

```java
public Mono<CupomResponse> processarCupom(Pedido pedido) {
	return gerarCupom(pedido)
		.flatMap(this::salvarNoBanco)
		.flatMap(this::gerarQRCode)
		.flatMap(this::gerarPDF)
		.map(this::enviarLinkCliente);
}
```


No exemplo de código, acima, cada etapa retorna um **Mono** (um resultado assíncrono).  O Reactor (por trás) gerencia as assinaturas (subscribe()), garantindo que tudo flua naturalmente sem bloquear o servidor. Se algo der errado (ex: erro no QR), o Reactor chama onError automaticamente.

**Caso 2: Notificações ou streaming em tempo real**
Se quisermos mostrar em tempo real o status da geração de cupons, podemos usar um Flux:
```java
Flux<StatusProcessamento> statusTream = cupomService.streamStatusGeracao();
```

Cada evento novo ("Cupom gerado", "QR Code Criado", "PDF pronto"), seria emitido por esse Flux, e os clientes conectados via **WebSocket ou SSE (Server-Sent Events)** receberiam as atualizações imediatamente, sem precisar ficar recarregando a página.

**Caso 3: Escalabilidade**
O modelo reativo baseado em Publisher e Subscriber permite que a aplicação lide com **milhares de requisições simultâneas** de forma leve. Enquanto o modelo tradicional usa **threads bloqueadas** (esperando resposta do banco, API etc.), o modelo reativo libera a thread  e só reage quando o dado realmente chega, economizando recursos do servidor...



## 8.3 Introducing Spring WebFlux
O Spring Framework 5. introduziu um novo framework que oferece suporte ao desenvolvimento de aplicações **Web reativas** no Spring. Isso é feito por meio do Spring WebFlux. É uma biblioteca totalmente nonblocking e baseada no Project Reactor. Seu foco são servidores Web como Netty, undertow e Servlet 3.1+ containers.

O **Spring WebFlux** fornece dois modelos de programação:
1. **Annotated Controllers** - modelo consistente com o framework Spring MVC, permitindo o uso do mesmo conjunto de anotações disponíveis no Spring MVC;
2. **Functional Endpoints -** modelo leve baseado em **lambda** e em **programação funcional.** Esse modelo oferece um pequeno conjunto de bibliotecas que uma aplicação pode usar para rotear e manipular requisições HTTP.

### 8.3.1 Technique: Developing a reactive RESTful API with annotated controllers
In this technique, we'll discuss how to develop a reactive RESTful API with annotated controllers.

The Course Tracker REST API developed previously is a blocking API and uses Spring MVC. We need to use reactive stack to build a nonblocking, scalable API with Spring WebFlux.

**Solution**
To develop a reactive nonblocking RESTful API, in this techninque, we'll use Spring WebFlux annotated controller model. As we've discussed previosuly, this approach uses the same Spring MVC  to build the API. Thus, you can use the familiar *@GetMapping*, @PostMapping, and other annotations to design the API. 

**Using MongoDB database**
In this chapter, we'll use a reactive MongoDB database. You need not install and configure MongoDB to continue with this technique, as we'll usa embedded MongoDB database. We only require the Spring Data Reactive MongoDB and Embedded MongoDB dependencies for MongoDB support. Note that  you can also continue to use the H2 database along with de <span style="background:#affad1">Spring Data R2DBC dependenc</span>y if you don't want to use MongoDB. 

The `spring-boot-starter-webflux` dependency provides necessary support for Spring WebFlux framework. Lastly, the `reactor-test` dependency provides necessary support (classes and methods) to test reactive applications. Next, we'll define the *CourseRepository* interfaces shown in the following sniped code:
```java
@Repository
public interface CourseRepository extends ReactiveCrudRepository<Course, string> {
	Flux<Course> findAllByCategory(String category);
}
```

We've also defined a custom method *findAllByCategory(Stirng category)* that returns a *Flux* of courses that matches the supplied category. Let's noew define the Course domain model shown in the following listing.

**Recordando alguns conceitos**
#ReactiveCrudRepository: é uma **interface base do Spring Data** projetada para trabalhar de forma **reativa e não bloqueante** com banco de dados. Enquanto o **CrudRepository** (tradicional) retorna listas ou entidades diretamente, o **ReactiveCrudRepository** retorna **Publishers reativos**, ou seja, tipos do **Project Reactor** (Mono e Flux).

Portanto, **ReactiveCrudRepository** trabalha com #streams reativas.

**Tipos reativos usados:**
- *Mono< T>* representa 0 ou 1 elemento (buscar um curso por ID);
- *Flux< T>* representa 0, 1 ou muitos elementos (ex: listas cursos);

```java
Flux<Course> findAllByCategory(String category);
Flux<Course> findAllByAuthor(String author);
```

Esses métodos retornam **streams reativas de cursos**,. os cursos serão emitidos de forma assíncrona e sob demanda conforme o assinante (subscriber) os consome.

**Na prática:**
```java
@GetMapping("/courses")
public Flux<Course> getCourseByCategory(@RequestParams String Category) {
	return courseRepository.findAllByCategory(category);
}
```
Quando o cliente fizer uma requisição, o servidor não vai precisar carregar todos os cursos de uma vez na memória.
O Flux vai emitindo cada curso conforme o banco de dados e a rede permitem. Isso torna a aplicação altamente escalável e eficiente para cenários com muitas conexões simultâneas...

Mas quem é responsável por controlar o ritmo? Backpressure (contrapressão), é basicamente um **fluxo sob demanda.** O consumidor (subscriber) é quem pede quantos elementos quer receber de cada vez. O produtor (repository/banco) só envia o que foi solicitado. 

Podemos também definir **limites explícitos**, diretamente no **Flux**:
```java
Flux<Course> limitedCourses = courseRepository.findAllByCategory("Java")
	.take(10);
	
Flux<Course> paginated = courseRepository.findAll()
						.skip(20) // pula 20
						.take(10) // pega os próximos 10
```


Essa operações, #take, #skip, #limitRequest, fazem parte **Project Reactor** e permitem controlar manualmente sobre a quantidade de dados.

Tudo isso só funciona de verdade se o driver do banco for reativo, também.
- MongoDB - usa Reactive MongoDB Driver;
- PostgreSQL - R2DBC
- MySQL - R2DBC MySQL Driver

Se o banco **não tiver driver reativo**, o comportamento continua reativo na API, mas internamente será bloqueante, o que elimina parte da vantagem. 

---

Let's now define the Course domain model shown in the following listing:

```java
@Data
@Builder
...
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	...
}
```

This is the same #POJO class we used previously, except this time we are using the **@Document** annotation in place of the @Entity annotation, as we are using MongoDB database instead of the H2 database. MongoDB stores data records in a document. Thus, a course detail in MongoDB is a document. Let's now define the Course Controller class, as shown in the following listing.

---
No lugar do MongoDB, eu estou usando o R2BC-H2, o R2DBC (Reactive Relational Database Connectivity) é a **versão reativa do JDBC.** Ele permite comunicação **não bloqueante** com bancos **relacionais** (como H2, PostgreSQL, MySQL, etc). 

Essa dependência habilita o Spring a falar reativamente com o banco via R2DBC. Então o nosso repositório:
```java
@Repository
public interface CourseJpaRepository extends ReactiveCrudRepository<Course, Long> {
	Flux<Course> findAllByCategory(String category);
	Flux<Course> findAllByAuthor(String author);
}
```
vai executar consultas SQL assíncronas e sob demanda, via R2DBC; vai retornar os resultados como **Flux< Course >**
Só executa a query quando alguém se inscrever no Flux.


---

**Course  Controller Class**
```java
@slf4j
@RestController
@RequestMapping("/courses/")
public class CourseController {
	private CourseRepository courseRepository
	
	@Autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
}

	/* This endpoint return a Flux of courses. Recall that Flux can emit 0..N elements. Alse, notice the use of @GetMapping annotation to define the endpoint route, which is similar to what we've used in Spring MVC */
	@GetMapping
	public Flux<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	
	/* This endpoint return a Mono <ResponseEntity<Course>>. As we are getting a course by ID, we may or may not find a course with the supplied course ID. Recall that a Mono can emit 0..1 element. We are using ResponseEntity to wrap the response with HTTP status 200 OK for a successful response or HTTP status 404 Not Found if the course is not found   */
	@GetMapping
	public Mono<ReponseEntity<Course>> getCourseById(@PathVariable("id") String courseId) {
		return courseRepository.findById(courseId) Mono<Course>.map(course -> ResponseEntity.ok(course)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	// Finds all courses for the supplied category and return a Flux of courses.
	@GetMapping("category/{name}")
	public Flux<Course> getCourseByCategory(@PathVariable("name") String category) {
		return courseRepository.findAllByCategory(category)
						.doOnError(e -> log.error("Failed to create course", e.getMessage()));
	}
	
	@PutMapping("{id}")
	public Mono<ResponseEntity<Course> updateCourse(@PathVariable("id")
		String courseId, @RequestBody Course course) {
			return this.courseRepository.findById(courseId).flatMap(existingCourse -> {
			existingCourse.setName(course.getName());
			existingCourse.setRating(course.getRating());
			existingCourse.setCategory(course.getCategory());
			existingCourse.setDescription(course.getDescription());
			return this.courseRepository.save(existingCourse);
			}).map(updateCourse -> ResponseEntity.ok(updateCourse)).defaultIfEmpty(ResponseEntity.notFound.build())
					.doOnError(e -> log.error("Failed to update course", ().build()));
		
		}
	)
	
}

```

The listing 8.6, up, contains the endpoints to  perform the CRUD operations in our application. The endpoints are the same as we defined when we created a REST API with Spring MVC. Notice the declarative style of coding in the endpoints and how various operators are composed (e.g., how the map is used or the doOnSucess and doOnError are composed). Lastyle, let's define a new Spring @Configuration file and a *CommandLineRunner* bean definition to create a few courses, as shown in the following listing.

```java
@Configuration
public Class CourseConfig {
	
	@Bean
	public CommandLineRunner init(CourseRepository courseRepository) {
		return args -> {
			Course course1 = Course.builder().name("Mastering Spring Boot").category("Spring").rating(4).description("Mastering Spring Boot").build();
			Course course2 = Course.builder().name("Mastering Spring Python").category("Python").rating(5);
			Course course3 = Course.builder().name("Mastering Go").category("Go").rating(3).description("Mastering Go").build();
			
			
			Flux.just(course1, course2, course3).flatMap(courseRepository::save).thenMany(courseRepository.findAll()).subscribe(System.out::println);
		}
	}

}
```

In listing 8.7, we created three sample courses. We then used the static methods just(...) from the Fllux class to create a flux with the sample courses. Next, we used the flatMap(...) operator to save the courses and then the thenMany(...) to find all the courses. Lastly, we subscribed to Flux to start the processing and print each course in the console. Note that reactive programming is lazy, and nothing happens until we invoke the *subscribe()* method.

## 8.3.2 Technique: developing a reactive RESTful API with functional endpoints
In this technique, we'll discuss how to develop a reactive RESTful API with functional endpoints.

**Problem**
Another technique for transforming our blocking REST API in a reactive fashion is the adoption of functional endpoints.We need to build a reactive REST API based on functional endpoints.

In the previous technique, we explored building a reactive REST API with Spring WebFlux using the annotated controller approach. Spring WebFlux provides a lambda-based, lightweight, and functional programming model. This is a different model than what we've used previoslyy with the Spring MVC and WebFlux annotated controller-based approach. The functional model provides a set of utilities (Java methods), so we can define the routes to handle requests.

To explore the use of the functional endpoints further, let's build a REST API with functional endpoints. With this technique, we'll continue with our Corse Tracker application to build a REST API with the functional endpoint.



For the Spring Boot project in this technique, we can continue with the Spring Boot project used in the previous technique. We can also create a new project with de same set of dependencies as those specified in listing 8.3 and continue with the technique. Create the *CourseRepository* interface and Course domain class, as shown in listing 8.4 and 8.5, respectively.

We'll begin by defining the routes. The routes are the URLs to perform the CRUD operations. The following listing shows the *RouterContext* class.


#### Resumo
Uma API com *Functional Endpoints* (ou Programação Funcional de Endpoints) é uma **forma alternativa de construir APIs REST em Spring, sem usar anotações como** *@RestrController* e *@RequestMapping*. Em vez disso, definimos nossas rotas e manipuladores (handlers) de forma **funcional**, ou seja, usando **funções puras** que recebem uma requisição e retornam uma resposta.

**Contextualizando:**
Tradicionalmente, no Spring MVC, criamos controladores assim:
```java
@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@GetMapping
	public List<Task> getAAll() {
		return service.findAll();p
	}
	
	@PostMapping
	public Task create(@RequestBody Task task) {
		return service.save(task);
	}

}
```

Esse método é #imperativo e baseado em anotações.

Mas a partir do Spring WebFlux, surgiu uma abordagem **reativa e funcional**, que evita o uso dessas anotações e define as rotas de forma programática.

**Exemplo da API com Functional Endpoints**
```java
@Configuration
public class TaskRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(TaskHandler handler) {
		return RouterFunctions
		.route(RequestPredicates.GET("/tasks"), handler::getAll)
		.andRoute(RequeestPredicates.POST("/tasks"), handler::create);
	
	}
}
```

E o #handler (em vez do controller) seria:
```java
@Component
public class TaskHandler {
	private final TaskService service;
	
	public TaskHandler(TaskService service) {
		this.service = service;
	}
	
	public Mono<ServerResponse> getAll(ServerRequest request) {
		return  ServerResponse.ok()
			.contentType(MediaType.APPLICATION_JSON)
			.body(service.findAll(), Task.class);
	}
	
	public Mono<ServerResponse> create(ServerRequest request) {
		return request.bodyToMono(Task.class)
			.flatMap(service::save)
			.flatMap(task -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(task));
			)
	}
	
}
```


**O que caracteriza uma API construída com Functional Endpoints no Spring?**
1. Uso intensivo de anotações como *@RestController* e *@GetMapping*
2. Definição de rotas e manipuladores por funções (*RouterFunction* e *HandlerFunctiion*)
3. Base em **spring-webmvc** e operações bloqueantes
4. Utilização exclusiva de classes abstratas para os endpoints.
?
**2. Definição de rotas e manipuladores por funções (RouterFunction e HandlerFunction)**

**Qual biblioteca do Spring é geralmente usada para implementar APIs com Functional Endpoints?**
A) `spring-data-jpa`  
B) `spring-webmvc`  
C) `spring-webflux`  
D) `spring-security`
?
**C) spring-webflux**

**Qual das alternativas abaixo representa uma vantagem dos Functional Endpoints?**
A) Menor legibilidade e mais acoplamento entre rotas e lógica  
B) Desempenho inferior em aplicações reativas  
C) Maior controle funcional sobre o fluxo de requisição e resposta  
D) Exige obrigatoriamente o uso de `@RequestMapping`
?
**C) Maior controle funcional sobre o fluxo de requisição e resposta**

---

We'll begin by defining the routes. The routes are the URLs to perform the CRUD operations. The following listing shows the *RouterContext* class.

```java
@configuration
public class RouterContext {
	
	@Bean
	RouterConfiguration<ServerResponse> routes(CourseHandler courseHandler) {
		return routue(GET"/courses").and(accept(APPLICATION_JSON)),
			courseHandler::findAllCourses)
				.andRoute(GET"/courses/{id}").and(accept(APPLICATION_JSON)),
				courseHandler::findCourseById)
				.andRoute(Get"/courses").and(accept(APPLICATION_JSON)),
				courseHandler::createCourse)
				...
	}
}
```

The code above is a Spring @Configuration class with *RouterFunction* bean definition. The *RouterFunction* defines the routes to perform the CRUD operation in the reactive REST API. This bean definition requires the *CourseHandler* instance, <span style="background:#d4b106">so once there is a request to any of the routes,</span> it can be forwarded to the handler to handle the request (será encaminhado para o handler que será responsável por processar a requisição. We have defined two routes with HTTP GET requests, one for each of the POST, PUT requests and two for DELETE requests. For each of the routes, we've delegated the request processing to the appropriate methods of the *CourseHandler* class. 

**Em uma aplicação Spring WebFlux que utiliza Functional Endpoints, como a classe `RouterContext`, qual é o papel do `CourseHandler` nesse processo?**
A) A `RouterContext` é responsável por processar diretamente todas as requisições HTTP e o `CourseHandler` atua apenas como um repositório de dados.
B) A `RouterContext` define as rotas e vincula cada requisição HTTP (GET, POST, PUT, DELETE) a um método específico do `CourseHandler`, que contém a lógica para manipular e responder às requisições.
C) A `RouterContext` cria automaticamente os endpoints REST com base nas entidades do banco de dados e o `CourseHandler` serve como adaptador para o ORM.
D) A `RouterContext` gerencia o ciclo de vida das conexões reativas e o `CourseHandler` atua como um proxy para o servidor HTTP.
?
<span style="background:#affad1">B) A `RouterContext` define as rotas e vincula cada requisição HTTP (GET, POST, PUT, DELETE) a um método específico do `CourseHandler`, que contém a lógica para manipular e responder às requisições.  </span>
<!--SR:!2025-11-01,1,230-->

**No exemplo da Listing 8.10, o `RouterFunction<ServerResponse>` é o núcleo da configuração funcional da API. O que ele faz exatamente durante o processamento de uma requisição e por que ele é fundamental em uma aplicação reativa com Spring WebFlux?**
A) Ele intercepta as requisições antes do dispatcher servlet e transforma todas em chamadas síncronas.  
B) Ele define um mapeamento funcional entre os tipos de requisições HTTP e os métodos do `CourseHandler`, permitindo que as requisições sejam processadas de forma não bloqueante e reativa.  
C) Ele substitui o uso do `ResponseEntity` por `ModelAndView`, garantindo compatibilidade com o Spring MVC tradicional.  
D) Ele cria dinamicamente controladores anotados e delega as chamadas ao contexto de servlet padrão.
?
<span style="background:#affad1">B) Ele define um mapeamento funcional entre os tipos de requisições HTTP e os métodos do `CourseHandler`, permitindo que as requisições sejam processadas de forma não bloqueante e reativa.  </span>

In the Next, let's define the **CourseHandler** class, as shown in the following listing. This class contains the logic to perform the CRUD operations.

