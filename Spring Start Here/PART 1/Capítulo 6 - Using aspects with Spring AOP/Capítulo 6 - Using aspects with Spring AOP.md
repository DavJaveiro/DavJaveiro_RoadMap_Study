*This chapter covers*
- Aspect-oriented programming (AOP)
- Using aspects
- Using the aspect execution chain

Até o momento, discutimos o contexto do Spring, e a única funcionalidade que utilizamos foi a **Injeção de Dependências (DI)**, que é baseada no princípio de **Inversão de Controle (IoC)**.

Com **DI**, o framework gerencia os objetos que nós definimos, permitindo que os utilizemos onde for necessário. Como abordado nos capítulos 2 a 5, para obter a referência de um bean, na maioria dos casos utilizamos a anotação *@Autowired*. Quando solicitamos um objeto ao contexto do **Spring**, dizemos que o framework o **injeta** no local onde foi requisitado.

Neste capítulo, aprenderemos a utilizar outra técnica poderosa baseada no princípio de IoC: os #Aspects.

Os #Aspects são uma forma de o Spring interceptar chamadas de métodos e, possivelmente, modificar sua execução. Com essa técnica, é possível influenciar a execução de métodos específicos escolhidos previamente. 

Isso permite extrair partes da lógica que originalmente pertencem ao método executado. Em determinados cenários, *desacoplar* parte do código torna o método mais fácil de compreender. Dessa forma, o desenvolvedor pode focar apenas nos detalhes relevantes ao analisar a lógica do método. 

Se não forem utilizados com cuidado, podem tornar a aplicação menos **manutenível**, exatamente o oposto do que se deseja.

No contexto de Aspect-Oriented Programming (AOP), desacoplar significa separar responsabilidades que estariam misturadas dentro de um método, extraindo partes do código que não fazem parte da lógica principal desse método.

Outra razão importante para aprender sobe #Aspect é que o Spring os utiliza na implementação de diversas funcionalidades essenciais que oferece. Compreender como o framework funciona pode economizar muitas de **debuggin** no futuro, quando nos depararmos com um problema específico. 

Um exemplo relevante de uma funcionalidade do Spring que utiliza #Aspect é a #transacionalidade, que será discutida apenas no capítulo 13. A #transacionalidade é uma das principais capacidades usadas na maioria das aplicações hoje em dia para garantir a consistências dos dados persistidos.

Outra funcionalidade crucial que depende de Aspects é a **configuração de segurança**, que ajuda a proteger os dados da aplicação e garante que informações sensíveis não sejam acessados ou modificados por **usuários não autorizados**. 

Para compreender corretamente o que acontece em aplicações que utilizam essas funcionalidades, primeiro é necessário aprender sobre #Aspects.

- Na seção 6.1, começaremos com uma introdução teórica, explicando como os Aspects funcionam.

## 6.1 How aspects work in Spring
Ao dominar a implementação de #Aspects, poderemos aplicar novas técnicas para tornar nossa aplicação mais manutenível. Além disso, entenderemos como certas funcionalidades do Spring são integradas às aplicações.

**O que é um #Aspect?**
Um #Aspect é simplesmente um <span style="background:#d4b106">trecho de lógica que o framework executa quando determinados métodos são chamados</span>. Ao projetar um **Aspect**, definimos os seguintes elementos:
- #Aspect - o código que o Spring deve executar ao chamar métodos específicos;
- #Advice - o momento em que a lógica do Aspect será executada (por exemplo, antes, depois ou no lugar da chamada do método);
- #Pointcut - os métodos que o framework deve interceptar para executar o Aspect.

Outro termo importante na terminologia de Aspects é o *Join Point*, que representa o evento que dispara a execução de um #Aspect. No #Spring, esse evento **sempre** é uma chamada de método.

Assim como no caso da injeção de dependência, para usar aspectos, precisamos que o framework gerencie os objetos aos quais desejamos aplicar os aspects. O bean que declara o método interceptado por um aspect é denominado #target-object (objeto alvo):
![[Capítulo 6 - Using aspects with Spring AOP.png]]
```java
@Service
public class CommentService(Comment comment) {
	
}
```
To become an aspect target, the object needs to be a bean in the Spring context. Spring needs to know the objects it has to manage.

Queremos que <span style="background:#d4b106">alguma lógica</span> (aspect) seja executada <span style="background:#d4b106">antes</span> (the advice) de cada <span style="background:#d4b106">execução</span> (the Join Point) do <span style="background:#d4b106">método</span> *publishComment()* (the pointcut), que pertence ao bean *CommentService* (the target object). 

But how does Spring intercept each method call and apply the aspect logic? Primeiramente, o objeto precisa ser um bean no contexto do Spring. Mas, como tornamos o objeto um alvo, um *target object*, o Spring não fornecerá diretamente uma referência de instância para o bean quando solicitá-lo do contexto. Em vez disso, o Spring fornecerá um <span style="background:#b1ffff">objeto que chama a lógica do aspecto</span> em vez do método real. Dizemos que o Spring lhe fornece um objeto proxy em vez do bean real. Agora, receberemos um proxy em vez do bean sempre que obtiver o bean do contexto, seja usando diretamente o método *getBean()* do contexto ou usando DI. Essa abordagem é chamada de #weaving.

```java
@Configuration
public class ProjectConfig {
	@Bean 
	public CommentService commentService() {
		return new CommentService();
	}
}
```
Add the bean *commentService* in the Spring context.

```java
public class Main {
	public static void main(String[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
		var service = c.getBean(CommentService.class); // gets the proxy to the bean

		System.out.println(service.getClass());
	}

}
```

If the bean is as aspect target, Spring doesn't provide you a reference to the actual object. Instead, Spring gives you a reference to a proxy object that can manage each call to the intercepted method and apply the aspect logic. 

Na figura abaixo, encontraremos uma comparação entre chamar o método quando não é interceptado por um aspecto versus um aspecto interceptando a chamada do método. Observaremos que chamar um método com aspecto supõe que chamemos o método através do objeto proxy fornecido pelo Spring. **O proxy aplica a lógica do aspecto e delega a chamada ao método real**.

![[Capítulo 6 - Using aspects with Spring AOP-1.png]]
Quando o método não é interceptado por aspectos, alguém chama o método *publishComment()* diretamente chamando a lógica implementada na classe *CommentService*.

**With Aspect**
![[Capítulo 6 - Using aspects with Spring AOP-2.png]]
Quando nós definimos um aspect para o método, alguém fará chamada através do proxy fornecido pelo Spring. O proxy aplica a lógica de aspect que então delegará a chamada para o método atual.

## 6.2 Implementing aspects with Spring AOP
In this section, you'll learn the most relevant aspect syntaxes used in real-world examples. We'll consider a scenario and implement its requirements with aspects. At the end of this section, you'll be able to apply syntaxes to solve the most frequent problems in real-world scenarios.

Suponha que tenhamos uma **aplicação** que implementa múltiplos **casos de uso** em suas classes de serviço. Algumas novas regulamentações exigem que seu aplicativo armazene o tempo de início e término de cada execução de caso de uso. Em sua equipe, você decidiu assumir a responsabilidade de implementar uma funcionalidade para registrar todos os eventos onde um caso de uso começa e termina. Na seção 6.2.3, aprenderemos como usar **anotações** para marcar métodos que deseja interceptar para um propósito específico. Os desenvolvedores frequentemente usam anotações para marcar o método que um #aspect precisa interceptar. Muitas funcionalidades no Spring usam anotações. 

### 6.2.1 Implementing a simple aspect
Nesta seção, discutiremos a implementação de um *aspect* simples para resolver nosso cenário. Criamos um novo projeto e definimos uma classe de serviço contendo um método que usaremos para testar nossa implementação e comprovar que o *aspect* definido funciona conforme o esperado.

O projeto será chamado de "s1-ch6-ex1".
Além da dependência *spring-context*, também vamos precisar da dependência *spring-aspects* para este exemplo. In addition to the *spring-context* dependency, for this example we also need the *spring-aspects* dependency. Make sure to update your pom.xml file and add the needed dependencies. We need this dependency to implement the aspects.

To make our example shorter and allow you to focus on the syntax related to aspects, we'll only consider one service object name *CommentService* and a use case it defines name *publishComment(Comment comment)*. This method, defined in the CommentService class, receives a parameter of type Comment. Comment is a model class and is presented in the next code snippet: [[Spring Start Here/Capítulo 6 - Using aspects with Spring AOP/sq-ch6-ex1/src/main/java/org/example/sqch5ex3/comment/model/Comment.java|Comment]]
```java
public class Comment {
	private String text;
	private String author;

	// Omitted getters and setters
}
```

**NOTE:** Remember from chapter 4 that a model class is a class that models the data processed by the app. In our case, the *Comment* class describes a comment with its attributes: text and author. A service class implements use cases of an app. In chapter 4, we discussed more of these responsibilities, and we used them in examples.

In listing 6.1, you find the definition of the *CommentService* class. We annotate the *CommentService* class with the *@Service* stereotype annotation <span style="background:#b1ffff">to make it a bean in the Spring Context</span>. The *CommentService* class defines the *publishComment(Comment comment)* method, representing our scenario's use case.

You also observe in this example that instead of using *System.out*, I used an object of type *Logger* to write massages in the console. In real-world apps, you don't use System.out. You'll generally use a logging framework that offers you more flexibility in customizing the logging features and standardizing the logging messages. Some good options for a logging framework are as follows:
- Log4j (https://logging.apache.org/log4j/2.x/)
- Logback (http://logback.qos.ch/)
-  Java Logging API, which comes with the JDK (http://mng.bz/v4Xq)

The logging frameworks are compatible with any Java app, whether (independentemente) it's using Spring or not. As they are not related to Spring, I haven't use them in our examples to avoid distracting you. But we are far enough now with Spring that we can start to use these additional frameworks in our examples to familiarize you with syntaxes closer to production-ready apps.

```java
@Service
public class CommentService {
	private Logger logger = Logger.getLogger(CommentService.class.getName());

	public void publishComment(Comment comment) {
		logger.info("Publishing comment: " + comment.getText());
	}

}
```

[[Spring Start Here/Capítulo 6 - Using aspects with Spring AOP/sq-ch6-ex1/src/main/java/org/example/sqch5ex3/comment/services/CommentService.java|CommentService]]

In this example, I use the JDK logging capabilities to avoid adding other dependencies to our project. Ao declarar um objeto logger, precisamos fornecer um nome como parâmetro. Esse nome aparece nos logs e facilita a identificação da origem das mensagens de log. Frequentemente, usamos o nome da classe, como fizemos neste exemplo:
*CommentService.class.getName()*.

---
O #Logger é uma classe fornecida pelo *Java Logging API* (parte do JDK) que permite registrar mensagens de log em diferentes níveis, como #INFO, #WARNING, #SEVERE, etc. Essas mensagens são úteis para monitorar o comportamento do sistema, depurar problemas ou rastrear durante a execução do programa.

```java
private Logger logger = Logger.getLogger(CommentService.class.getName());
```
- O método estático *Logger.getLogger(String name)* cria ou obtém uma instância de *Logger* com o nome especificado. Esse nome é usado para identificar a origem das mensagens de log. Ele aparecerá nos logs gerados, permitindo que saibamos de onde veio cada mensagem.
* *CommentService.class.getName()* - retorna o nome totalmente qualificado da classe *CommentService* (por exemplo, com.example.myapp.service.CommentService). Usar o nome da classe como parâmetro é uma prática comum porque:
	* Facilita identificar a origem dos lgos;
	* É consistente e evita erros ao digitar manualmente o nome da classe.


**Por que usar o nome da classe como parâmetro?**
Quando usamos o nome da classe como parâmetro, os logs gerados incluirão esse nome. Isso ajudar a rastrear a origem das mensagens de log, especialmente em projetos grandes com muitas classes.
Por exemplo, suponhamos que tenhamos dois serviços:
- *CommentService*
- *UserService*
Se ambos registrarem mensagens de log, o nome da classe aparecerá nos logs, permitindo que a gente distinga facilmente quais mensagens foram geradas por qual serviço.

Exemplo de log:
INFO: CommentService - Comentário publicado com sucesso.
INFO: UserService - Usuário registrado com sucesso.

---

Let's write the Main class that the *publishComment()* method in the service class and observe the current behavior, as shown in the following listing.
```java
public class main { 
	public static void main(Strig[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class)
	}
}
```