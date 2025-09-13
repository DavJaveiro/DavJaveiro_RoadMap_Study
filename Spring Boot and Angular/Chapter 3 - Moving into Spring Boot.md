**Spring Boot Architecture**
O Spring Boot consiste em diferentes camadas e classes para processar os dados e a lógica em nosso backend. As quatro camadas e seu uso são os seguintes:
1. Camada de Apresentação (Presentation Layer): a camada de apresentação é responsável por interpretar parâmetros JSON como objetos. Esta é a camada superior, que também é responsável por lidar com a autenticação e as requisições HTTP. Após realizar a tradução do JSON e a autenticação, passamos para a camada de negócio. 
2. Camada de Negócio (Business Layer) a camada de negócio, como o nome sugere, lida com toda a lógica de negócio da aplicação. Ela é composta por classes de serviço que realizam autorização e validações adicionais. 
3. Camada de Persistência: a camada de persistência é a principal responsável pela lógica de armazenamento, que converte objetos de e para linhas do banco de dados para inserir e recuperar dados.
4. Camada de Banco de Dados (Database Layer): a camada de banco de dados realiza as operações de Criar, Ler, Atualizar e Excluir (CRUD). Essa camada pode consistir em múltiplos bancos de dados.

## Dependency Injection
Geramos com sucesso nosso próprio projeto Spring Boot e agora começaremos a aprender os conceitos do Spring. Um dos mais importantes que precisamos entender é a injeção de dependência. Ao desenvolvermos nosso backend com Spring Boot, usaremos principalmente a injeção de dependência durante o processo, pois isso torna nosso programa Java modular e facilita a troca de implementações.

A injeção de dependência é um recurso essencial das linguagens de programação orientada a objetos, mas primeiro, vamos discutir o conceito de **inversão de controle**, que é o que a injeção de dependência busca alcançar.

## Inversão de Controle
Inversão de Controle é um padrão de projeto *design pattern* usado em linguagens de programação orientada a objetos. O IoC é um conceito de inverter o fluxo do nosso programa e é usado para desacoplar os componentes em nossa aplicação, tornando o nosso código reutilizável e modular. Assim, o padrão de projeto IoC nos fornecerá uma maneira de injetar uma classe personalizada em outras classes de nossa aplicação.

A classe injetada será instanciada em diferentes partes de nossa aplicação. Em vez de deixar nossa classe decidir suas implementações ou fazer suas próprias correções de código, permitimos que a injeção de dependência altere o fluxo, o desempenho e o código da classe, dependendo do caso. Dessa forma, o IoC oferece principalmente flexibilidade e modularidade, mas também proporciona várias outras vantagens no design de nossa aplicação:
- Tendo o controle do **ciclo de vida de um objeto**, podemos definir alguns objetos como _singleton_ (instância única), enquanto outros objetos podem ter sua própria instância.
- Torna a aplicação **mais fácil de manter**, pois a quantidade de código é reduzida devido aos componentes reutilizáveis.
- **Testar componentes** é mais gerenciável, pois podemos isolar componentes e simular (_mockar_) suas dependências, sem abranger outro código que não será incluído no teste unitário.

Aprendemos sobre o padrão IoC e como ele é vantajoso para o desenvolvimento de nossa aplicação. Agora, usaremos a injeção de dependência, que nos permite alcançar esse padrão.

## The Basics of Dependency Injection
Já discutimos como o **IoC** funciona: ele é alcançado permitindo que a implementação de um objeto seja decidida pelas dependências que lhe são fornecidas. Essa ideia é, em essência, a **injeção de dependência**. 💉

Nós permitimos que objetos ou classes aceitem outras dependências que podem fornecer implementações de diferentes classes sem que precisemos escrevê-las novamente, tornando nosso código **flexível** e **reutilizável**. A injeção de dependência pode ser realizada de diferentes maneiras, e a seguir estão as suas implementações.

**Constructor-based dependency injection**
A **injeção de dependência baseada em construtor** pode ser alcançada criando-se uma classe de objeto com um construtor, com argumentos de um tipo específico que representam a dependência que podemos definir.

Vamos dar uma olhada no seguinte exemplo de código:
```java
/* Classe para Aluno */
public class Student {
	private Grades grades;
}

public Student(grades: Grades) {
	this.grades = grades;
}

public void retrieveGrades() {
	grades.geatGrades();
}
```

No exemplo anterior, a classe **Student** possui um construtor, public Student() {}, que aceita um **parâmetro** do tipo Grades. O construtor nos permite **injetar** um objeto Grades em Student, permitindo que todas as implementações do objeto Grades fiquem acessíveis no objeto **Student**. Agora, acessamos o método **getGrades()** em nosso **Student**. Para usar o objeto **Student**, executaremos o seguinte exemplo:
```java
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Student student = (Student) context.getBean("student");
		
		student.retrieveGrades();
	}
}
```

Podemos ver no exemplo anterior que **instanciamos** um novo **student** em nossa classe principal ao obter o bean de nosso arquivo *Beans.xml*. O arquivo *Beans.xml* é o nosso principal arquivo de configuração para a nossa injeção baseada em construtor, e é onde definiremos nossos beans juntamente com suas dependências.
```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmlns =
"http://www.springframework.org/schema/beans"
xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation =
"http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/
spring-beans-3.0.xsd">
<!-- Definition for student bean -->
<bean id = "student"
class = "com.springexample.Student">
<constructor-arg ref = "grades"/>
</bean>
<!-- Definition for grades bean -->
<bean id = "grades"
class ="com.springexample.Grades"></bean>
</beans>
```

No exemplo anterior, definimos os objetos **Student** e **Grades** como beans. A única diferença é que o objeto Student possui um constructor-arg que referencia grades; isso significa que estamos injetando o objeto Grades em nosso objeto Student.

Nós já realizamos a dependência baseada em construtor usando a configuração Beans.xml. Também podemos usar anotações (annotations) diretamente em nosso código para configurar nossos beans e suas dependências.

Vejamos o exemplo a seguir de como configurar **beans** e **dependências** com **anotações:**
```java
@Configuration
public class AppConfig
{
	@Bean
	public Student student() {
		return new Student(grades());
	}

	@Bean
	public Grades grades() {
		return new Grades();
	}

}
```

Podemos ver no exemplo anterior que, em vez de usar XML, usamos **anotações** (annotations) para identificar nossos **beans** e a **configuração**. Por exemplo, a anotação **@Configuration** indica que a classe **AppConfig** é a fonte das definições de bean, e a anotação *@Bean* define o bean em nossa aplicação. Discutiremos anotações e beans intensamente ao longo deste capítulo.

Aprendemos com sucesso como implementar a injeção de dependência baseada em construtor usando Beans.xml e anotações. Agora, vamos passar para a implementação da injeção de dependência baseada em setter.

**Setter-based dependency injection**
A **injeção de dependência baseada em construtor** pode ser alcançada criando-se uma classe de objeto com um **construtor**, com **argumentos** de um tipo específico que representam a **dependência** que podemos definir.

```java
public class Student {
	private Grades grades;
	
	public Student(grades: Grades) {
		this.grades = grades;
	}
	
	public void retrieveGrades() {
		grades.getGrades();
	}
}
```

No exemplo anterior, a classe **Student** possui um construtor, **public Student() {}**, que aceita um parâmetro do tipo Grades. O construtor nos permite injetar um objeto Grades em Student, permitindo que todas as implementações do objeto Grades fiquem acessíveis no objeto Student. Agora, acessamos o método getGrades() em nosso Student. Para usar o objeto Student, executaremos o seguinte exemplo:
```java
public class Main {
	public static void main(String[] args) {
	
	
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Student student = (Student) context.getBean("student");
		
		
		student.retrieveGrades();
	}

}
```

Podemos ver no exemplo anterior que **instanciamos** um novo student em nossa classe principal ao obter o bean de nosso arquivo Beans.xml. O arquivo Beans.xml é o nosso principal arquivo de configuração para a nossa injeção baseada em construtor, e é onde definiremos nossos beans juntamente com suas dependências.

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmlns =
"http://www.springframework.org/schema/beans"
xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation =
"http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/
spring-beans-3.0.xsd">
<!-- Definition for student bean -->
<bean id = "student"
class = "com.springexample.Student">
<property name="grades" ref = "grades"/>
</bean>
<!-- Definition for grades bean -->
<bean id = "grades"
class ="com.springexample.Grades"></bean>
</beans>
```

**Field-based dependency injection**
Como o nome sugere, a **injeção de dependência baseada em campo** (field-based dependency injection) é um conceito onde injetamos as dependências do objeto diretamente nos campos. Não criaremos um construtor ou um método setter para injetar nossas dependências, mas usaremos a anotação *@Autowired* para a injeção.

```java
/* Classe para Aluno */
public class Student {
	@Autowired
	private Grades grades;
}
```

No código do exemplo anterior, podemos ver que não criamos um construtor ou um método setter para injetar nossa dependência. Em vez disso, usamos apenas a anotação *@Autowired* para injetar o objeto **Grades**.

A injeção baseada em campo pode parecer limpa à primeira vista, por ter apenas anotações em nosso código e menos métodos, mas muitas coisas acontecem por trás da nossa dependência *@Autowired*. Por exemplo, ela usa **reflexão (reflection)** para injetar dependências, o que é mais custoso do que a injeção baseada em construtor e setter; ela também viola o **princípio da responsabilidade única**. Podemos adicionar mais dependências diretamente nos campos sem nenhum aviso.

Aprendemos os conceitos básicos de injeção de dependência e as diferentes maneiras de implementá-las em nossa aplicação Java. Agora, discutiremos o conceito e a importância das anotações e dos beans no Spring.

*Field Injection* é considerada uma má prática na maioria dos casos, justamente por dificultar testabilidades e esconder dependências.

## Annotation and beans
Anotações e beans são partes essenciais no desenvolvimento de nossas aplicações Spring. Eles são considerados os blocos de construção do Spring e tornam nosso código menos repetitivo (boilerplate) e mais fácil de manter (maintainable).

As anotações do Spring são usadas para definir os diferentes tipos de beans. Elas são simplesmente uma forma de metadados que marcam nosso código para fornecer informações. Por outro lado, os beans são objetos que são instanciados, criados e podem ser injetados com outros beans.

**Tipos de anotações**
As anotações do Spring são categorizadas em diferentes tipos, dependendo de sua funcionalidade. A seguir estão as anotações agrupadas em suas respectivas categorias.

**Core Annotations**
As anotações principais são usadas para potencializar o mecanismo de Injeção de Dependência (DI) do Spring em nossas aplicações. Elas podem ser encontradas nos pacotes *org.springframework.beans.factory.annotation* e *org.springframework.context.annotation*. A seguir, uma lista de anotações principais:
- @Required: é aplicada nos métodos setter de um bean e implica que a dependência deve ser injetada no bean durante a configuração. Caso contrário, uma exceção **BeanInitializationException** será lançada:
```java
public class Car {
	private String brand;
	@Required
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public Integer getBrand() {
		return brand;
	}

}
```
No exemplo anterior, podemos ver que o método setBrand() foi anotado com *@Required*; isso indica que a propriedade brand deve ser preenchida na inicialização.

- **@Autowired**: já encontramos a anotação auwotired, e ela é usada principalmente para injetar dependências sem o uso de construtores e métodos setter. Vejamos o exemplo a seguir de como usar a anotação *@Autowired:*
```java
public class Car {
	@Autowired
	private Brand brand;
}
```

Podemos ver no exemplo anterior que *@Autowired* é aplicada diretamente no campo. Isso ocorre porque a anotação usa **reflection** para injetar as dependências, um processo que envolve mais etapas do que a injeção via construtores e métodos setter.

- **@ComponentScan:** é uma anotação de nível de classe para indicar os pacotes que queremos que queremos que sejam escaneados; se nenhum for fornecido, o pacote atual e todos os seus subpacotes serão escaneados.
```java
@Configuration
@ComponentScan
public class SpringApp
{
	private static ApplicationContext applicationContext;
	
	@Bean
	public SpringBean springBean()
	{
		return new SpringBean();
	}
	public static void main(String[] args) {
	
		applicationContext = new AnnotationConfigApplicationContext(SpringComponentScanApp.class);
	}
}
```

No exemplo anterior, vemos que **@ComponentScan** é aplicada à classe SpringApp, e geralmente é implementada junto com a anotação @Configuration. Digamos que SpringApp esteja no pacote com.example.spring.app; isso fará com que o pacote e seus subpacotes sejam escaneados em busca de beans existentes.

- @Configuration: esta também é uma anotação de nível de classe que indica que a classe é uma fonte de definições de beans que o contêiner Spring processará em tempo de execução. Vejamos o exemplo a seguir de como usar a anotação *@Configuration*:
```java
@Configuration
public class SpringApp {
	@Bean(name="demoBean")
	public DemoBean service()
	{
		// Lógica do método
	}
}
```

Podemos ver que a anotação *@Configuration* é aplicada à classe SpringApp, o que indica que SpringApp será a fonte de beans.


- @Bean: é uma anotação de nível de método, usada para indicar que um método produz um bean. Vejamos o exemplo a seguir de como usar a anotação *@Bean*:
```java
@Configuration
public class AppConfig {
	@Bean
	public BeanExample beanExample() {
	return new BeanExampleImpl();	
}
}
```

O JavaConfig encontra o método, executa e registra o valor de retorno como um bean na **BeanFactory**. O nome do bean será o mesmo do método, caso nenhum nome seja especificado.

**Stereotype annotations**
São usadas principalmente para criar beans do Spring dinamicamente (on the fly) em um contexto de aplicação (application context).

- @Component: esta é a principal anotação de estereótipo. Assim como a anotação @Bean, a @Component é usada para definir um bean ou um component Spring. A diferença entre as duas é que a @Component é aplicada no nível da classe, enquanto a @Bean é aplicada no nível do método.
A outra diferença é que uma classe com @Component não pode ser usada para criar um bean se a classe estiver fora do contêiner Spring, enquanto podemos criar um bean usando @Bean mesmo que a classe esteja fora do contêiner Spring. Vejamos o exemplo a seguir de como usar a anotação @Component:
```java
@Component
public class Car {
	// ...
}
```
No exemplo anterior, a classe **car** será criada em tempo de execução. Também precisamos lembrar que a @Component não pode ser usada com a anotação @Configuration.

- @Service: é uma especialização da anotação @Component.
- @Repository: essa anotação é usada para classes que acessam diretamente um banco de dados. É uma indicação de uma classe que desempenha o papel de um **Objeto de Acesso a Dados (Data Access Object = DAO)**.

- @Controller: a anotação usada para as classes controladoras do Spring. Também é um tipo de anotação @Component, usada para o Spring MVC e em métodos anotados com @RequestMapping, que é usada para REST.

**Anotações do Spring Boot**
Essa anotações foram criadas explicitamente para o Spring Boot e, na maioria das vezes, são uma combinação de várias outras anotações. A seguir, uma lista de anotações do Spring Boot:
- **@EnableAutoConfiguration:** essa anotação é usada para autoconfigurar os beans presentes no classpath e, em seguida, configurá-los para executar os métodos. A anotação reramente é usada hoje em dia, pois a @SpringBootApplication foi lançada no Spring 1.2.0.
- @SpringBootApplication: essa anotação é a combinação de @EnableAutoConfiguration, @ComponentScan e @Configuration.

**Anotações REST**
São anotações especializadas para criar endpoints, especificar as requisições HTTP e serializar objetos de retorno. A lista a seguir mostra as diferentes anotações REST:
- **@RequestMapping:** usada para criar endpoints e mapear requisições web. A anotação pode ser usada em uma classe ou em um método.
- @GetMapping: mapeia requsições HTTP GET e é usada para buscar dados. É o equivalente a @RequestMapping(method = RequestMethod.GET).
- @PostMapping: mapeia requisições HTTP POST e é usada para criar dados. É o equivalente a @RequestMapping(method = RequestMethod.POST);
- @DeleteMapping: mapeia requisições HTTP DELETE e é usada para deletar dados. É o equivalente a @RequestMapping(method = RequestMethod.DELETE).
- - **`@PatchMapping`**: Mapeia requisições **HTTP PATCH** e é usada para atualizações parciais de dados. É o equivalente a `@RequestMapping(method = RequestMethod.PATCH)`.

- **`@RequestBody`**: Usada para vincular o corpo de uma requisição HTTP a um objeto em um parâmetro de método. O framework Spring vincula o corpo da requisição HTTP ao parâmetro com a anotação `@RequestBody`.
    
- **`@ResponseBody`**: Anexa o valor de retorno do método ao corpo da resposta. A anotação indica que o objeto de retorno deve ser serializado para um formato como JSON ou XML.
    
- **`@PathVariable`**: Usada para obter valores da URI. É permitido definir múltiplas instâncias de `@PathVariable` em um método.
    
- **`@RequestParam`**: Usada para obter os parâmetros de consulta (_query parameters_) da URL.
    
- **`@RequestHeader`**: Usada para extrair detalhes sobre os cabeçalhos (_headers_) da requisição HTTP de entrada. Usamos esta anotação nos parâmetros de um método.
    
- **`@RestController`**: É uma combinação das anotações `@Controller` e `@ResponseBody`. A importância desta anotação é que ela evita a necessidade de anotar cada método com `@ResponseBody`, classe já assume que todos os métodos retornam dados no corpo da resposta (JSON, texto, etc).
@Controller é usado por MVC tradicional, renderizando views (HTML, JSP, Thymeleaf). 

**Understanding beans**
