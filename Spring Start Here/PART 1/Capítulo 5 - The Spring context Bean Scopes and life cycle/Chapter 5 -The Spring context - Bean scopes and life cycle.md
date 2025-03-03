*This Chapter covers*
- Using the singleton bean scope;
- Using eager and lazy instantiation for singleton beans
- Using the prototype bean scope


Thus far we have discussed several essential things about object instances managed by Spring (beans). We covered the important syntaxes you need to know to create beans, and we discussed establishing relationships among beans (including the necessity of using abstractions). But we didn't focus on how and when Spring creates the beans. From this perspective, we've only relied on the framework'k default approaches.

I chose not to discuss this aspect earlier in the book because I wanted you to focus on the syntaxes you'll need up-front in your projects. However, production app's scenarios are complex, and sometimes relying on the framework's default behavior is not enough. For this reason, in this chapter we need to go a bit deeper with our discussion on how Spring manages the beans in its context.

Spring has multiple <span style="background:#d4b106">different approaches for creating beans and managing their life cycle</span>, and in the Spring world we name these approaches *scopes*. In this chapter, we discuss two scopes you'll often (frequência) find in Spring apps: *singleton* and *prototype*. 

**NOTE** Later, in chapter 9, we discuss three more bean scopes that apply to web applications: *request*, *session*, and *application*.

#Singleton is the default scope of a bean in Spring, and it's what we've been using up to now. We'll deal first with how Spring manages singleton beans and then discuss essential things you need to know about using the singleton scope in real-world apps.  

In section 5.2, we continue by discussing the prototype bean scope. Our focus will be on how the prototype scope is different from singleton and real-world situations in which you'd need to apply one or another.

## 5.1 Using the singleton bean scope
The singleton bean scope defines Spring's default approach for managing the beans in its context. It is also the bean scope you'll most encounter in production apps.

In section 5.1.1, we start our discussion by learning how Spring creates and manages singleton beans, which is essential for understanding where you should use them. 

For this purpose, we'll take two examples that employ the different approaches you can use to define beans (which you learned in chapter 2) and analyze Spring's behavior for these beans. 

We'll then discuss (in section 5.1.2) the critical aspects of using singleton beans in real-world scenarios. We end this section by discussing two singleton bean instantiation approaches (eager and lazy) and where you should use them in production apps.

### 5.1.1 How singleton beans work
Vamos começar com o comportamento do Spring para gerenciar beans com escopo #singleton. É importante saber o que esperar ao usar esse escopo, especialmente porque singleton é o escopo de bean padrão (e o mais utilizado) no Spring. Nesta seção, descreverei a ligação entre o código que escrevemos e o contexto do Spring para tornar o comportamento do Spring fácil de entender. Em seguida, testaremos o comportamento com alguns exemplos.

O spring cria um *singleton bean* quando carrega o contexto e atribui a ele um nome (às vezes também chamado de **bean ID**).<span style="background:#d4b106"> Chamamos esse escopo de singleton porque sempre obtemos a mesma instância ao referenciar um determinado bean</span>. Mas devemos ter cuidado! É possível ter várias instâncias do mesmo tipo no contexto do Spring, desde que tenham nomes diferentes.

Se você conhece o *Singleton pattern*, o funcionamento no Spring pode parecer estranho, pois nele geralmente temos apenas uma instância de um tipo na aplicação. Para o Spring, o conceito de *singleton* permite múltiplas instâncias do mesmo tipo, onde *singleton* significa **único por nome**, mas não único por aplicação.

Logo, o Singleton Pattern é um design pattern que garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a essa instância. Isso é particularmente útil em situações onde a criação de múltiplas instâncias de uma classe seria ineficiente ou desnecessária. 

Por padrão, <span style="background:#d4b106">todos os beans no Spring são singleton</span>. Ou seja, uma única instância do bean é criada e compartilhada em todo o contêiner Spring.

Uma única instância significa menos uso de recurso de memória.
Simplicidade na configuração e gerenciamento de beans.
Garante que todas as solicitações ao bean compartilhem a mesma instância, mantendo consistência. 

Portanto, <span style="background:#d4b106">o padrão garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a essa instância</span>. Isso significa que, para uma classe específica que segue o padrão Singleton, haverá apenas uma instância dessa classe em toda a aplicação. O nome *singleton* reflete justamente a esse conceito de **único**.

Podemos ter várias classes diferentes implementando o padrão Singleton na mesma aplicação. Por exemplo, podemos ter um bean de configuração, um de conexão com o banco de dados... cada um desses beans seria único dentro do seu próprio contexto.

![[The Spring context - Bean scopes and life cycle.png]]

- **Singleton Pattern:** com o padrão Singleton, a classe gerencia a criação da instância e garante que <span style="background:#d4b106">apenas uma instância de um tipo seja criada</span>.

```java
public class CommentService {
	public static CommentService getInstance() {
		if (instanceHasNotYetBeenCreated()) {
			createCommentServiceInstance();
		}

		return commentService;
	}
}
```

- **Spring's singleton scope:** com o Spring, podemos definir tantos beans do mesmo tipo quanto precisarmos, utilizando métodos anotados com *@Bean* na classe de configuração. Cada um desses beans é um singleton. Logo, podemos ter várias instâncias da mesma classe no contexto do Spring, se a instâncias tiverem nomes diferentes.

```java
@Configuration
public class ProjectConfig {
	@Bean
	public CommentService commentService1() {
		return new CommentService();
	}

	@Bean
	public CommentService commentService2() {
		return new CommentService();
	}

	@Bean
	public CommentService commentService3() {
		return new CommentService();
	}
}

```

---
**Um pouco mais de explicação**
- **Singleton Pattern**
É um padrão de projeto da #GoF (Gang of Four) que garante que uma classe tenha *apenas uma instância* na aplicação e fornece um ponto global de acesso a ela.

*Implementação*: geralmente, é implementado com um **construtor privado** e um método estático que retorna a única instância da classe.

*Controle:* o controle da instância é feito manualmente pelo próprio código da aplicação.

*Escopo:* a instância única é válida **para toda a JVM**.

*Uso comum:* classes que representam recursos globais, como gerenciadores de conexões ou cache.
```java
public class Singleton {
	private static Singleton instance;

	private Singleton() {} // construtor privado

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
```

- **Spring Singleton Scope**
*Definição:* no Spring, um **bean singleton** significa que há apenas uma instância do bean por contexto do Spring, e não por aplicação inteira.
*Gerenciamento:* o próprio Spring gerencia a instância e injeta a mesma instância sempre que o bean for solicitado.
*Escopo:* a instância única é válida dentro do contexto do Spring, mas não para toda a JVM. Se houver múltiplos contextos do Spring na mesma aplicação, cada um pode ter sua própria instância do **singleton bean**. 
*Criação:* o Spring cria automaticamente um *bean singleton* quando o contexto é carregado, e ele fica disponível durante todo o ciclo de vida do contexto.
*Uso:* evita a necessidade de implementação manual do padrão **Singleton** dentro da classe.
```java
@Configuration
public class AppConfig {

	@Bean
	public MyService myService() {
		return new MyService();
	}

}
```

---

**Declaring Singleton-Scoped Beans With @Bean**
Vamos demonstrar o comportamento de um singleton bean com um exemplo, utilizando a anotação *@Bean* para adicionar uma instância ao contexto do Spring e, em seguida, <span style="background:#d4b106">referenciá-la múltiplas vezes na classe main. </span>Fazemos isso para provar que <span style="background:rgba(205, 244, 105, 0.55)">obtemos na mesma instância sempre que referenciamos o bean</span>.


![[The Spring context - Bean scopes and life cycle-1.png]]

A figura acima é uma representação do código próximo do contexto que configura o que precisamos obter.
O grão de café na visualização representa a instância que o Spring adiciona ao seu contexto. Observe que o contexto contém apenas uma instância (grão de café) com um nome associado *comentService()*. Como já discutimos no capítulo 2, ao usar a abordagem de anotação *@Bean* para adicionar um bean ao contexto, o nome do método anotado com *@Bean* torna-se o nome do bean.

Neste exemplo, estamos utilizando a abordagem de anotação @Bean para adicionar o bean ao contexto do Spring, mas, um Singleton, também pode ser criado utilizando anotações estereotipadas como *@Componenet* para adicionar o bean ao contexto. 

Utilizaremos o nome do bean para obtê-lo do contexto Spring nessa demonstração. Como já aprendemos lá no capítulo 2, quando temos apenas um bean de um tipo no Spring Context, não precisar mais usar seu nome para chamá-lo. Podemos obter esse bean pelo seu tipo. Neste exemplo, usamos o nome simplesmente para garantir que estamos nos referindo ao mesmo bean. 

Vamos escrever o código e executá-lo para concluir este exemplo. Vamos precisar de: 1) uma classe *CommentService* vazia; 2) classe de configuração; 3) classe principal.

```java
@Configuration
public class ProjectConfig {
	@Bean
	public CommentService commentService() {
		return new CommentService();
	}
}

public class Main {
	public static void main(String[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
		CommentService cs1 = c.getBean("coommentService", CommentService.class);
		CommentService cs2 = c.getBean("commentService", CommentService.class);

		boolean x = cs1 == cs2;

		System.out.println(x);
	}
}
```

Running the app will print "true" in the console because, being a singleton beam, Spring returns the same reference every time;

**Declaring Singleton Bean Using Stereotype Annotations**
As mentioned earlier, Spring's behavior for singleton bean isn't any different when using stereotype annotation than when you declared them with the @Bean annotation. But in this section, i'd like to enforce this statement with an example.

Consider a class design scenario where two service classes depend on a repository. Say we have both *CommentService* and *UserService* depending on a repository name *CommentRepository*:

![[The Spring context - Bean scopes and life cycle-2.png]]

The reason these classes are dependent uma das outras não importante, e nossos serviços não farão nada (é apenas um cenário). Assumimos que este design de classe faz parte de um aplicativo mais complicado, e focamos na relação entre os beans e como o Spring estabelece os links em seu contexto. A figura 5.4 é uma representação visual do contexto próximo ao código o configura.

Let's prove this behavior by creating the three classes and comparing the references Spring injects in the service beans.. Spring injects the same reference in both service beans. In the following code snippet, you find the definition of the *CommentRepository class*...

The next code snippet presents the definition of the *CommentService* class. Observe that I used *@Autowired* to instruct Spring to inject an instance of type *CommentRepository* in an attribute declared in the class. I also defined a getter method that I intend to user later to prove Spring injects the same object reference in both service beans:

[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex21/src/main/java/org/example/sqch5ex1/comment/services/CommentService.java|CommentService]]
[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex5/src/main/java/org/example/sqch5ex3/user/service/UserService.java]]

Both service classes...

Unlike the first example in this section, the configuration class remain empty in this project. We only need to tell Spring where to find the classes annotated with stereotype annotations. As discussed in chapter 2, to tell Spring where to find classes annotated with stereotype annotations we use the @ComponentScan annotation and use the argument *basePackages* for provides the name of stereotype classes that use the annotation in top of class name. 

[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex21/src/main/java/org/example/configuration/ProjectConfig.java|ProjectConfig]]

Because the dependency (CommentRepository) is singleton, both services contain the same reference, so this line always prints "true";

## 5.1.2 Singleton beans in real-world scenarios
Thus far we've discussed how Spring manages singleton beans. It's time to also discuss things you need to be aware of when working with singleton beans. Let's start by considering some scnearios where you should or shoudn't use singleton beans.

Como o escopo do singleton bean assume que múltiplos componentes do aplicativo podem compartilhar uma instância de objeto, <span style="background:#d4b106">a coisa mais importante a considerar é que esses beans devem ser imutáveis</span>. Na maioria das vezes, um aplicativo do mundo real executa ações em múltiplas threads (por exemplo, qualquer aplicativo web). Em tal cenário, múltiplas threads compartilham a mesma instância de objeto. Se essas threads alterarem a instância, você encontrará um cenário de condição de corrida.

Uma condição de corrida *race-condition* é uma situação que pode ocorrer em arquiteturas multithread quando múltiplas threads tentam alterar um recurso compartilhado. Em caso de uma condição de corrida, o desenvolvedor precisa sincronizar adequadamente as threads para evitar resultados de execução inesperados ou erros.

Se você deseja obter singleton beans mutáveis (cujos atributo mudam), você precisa tornar esses beans concorrentes por conta própria (principalmente empregando a sincronização de threads). Mas singleton beans não são projetados para serem sincronizados. Eles são comumente usados para definir o design de classe backbone de um aplicativo e delegar responsabilidades uns aos outros. Tecnicamente, a sincronização é possível, mas não é uma boa prática. Sincronizar a thread em uma instância concorrente pode afetar drasticamente o desempenho do aplicativo. Na maioria dos casos, encontraremos outros meios de resolver o mesmo problema e evitar a concorrência de threads.

![[Chapter 5 -The Spring context - Bean scopes and life cycle.png]]

No capítulo 3, foi mencionado que a injeção de dependência via construtor é uma boa prática e preferível à injeção de campo? Uma das vantagens da injeção de construtor é que ela permite tornar a instância imutável (definir os campos do bean como final). No nosso exemplo anterior, podemos aprimorar a definição da classe *CommentService* substituindo a injeção de campo pela injeção via construtor. Um design melhor da classe, seria:
[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex21/src/main/java/org/example/sqch5ex1/comment/services/CommentService.java|CommentService]]

Tornar a instância imutável tem vantagens:
1. **Thread Safety**: instâncias imutáveis são inerentemente seguras para serem compartilhadas entre múltiplas threads, <span style="background:rgba(205, 244, 105, 0.55)">pois seus estados não podem ser alterados após a criação</span>. Isso elimina a necessidade de sincronização explícita, reduzindo o risco de condições de corrida. #race-condition
2. **Simplicidade e Previsibilidade:** objeto imutáveis são mais fáceis de entender e prever, já que seu estado não muda. Isso facilita o rastreamento do fluxo de dados e da lógica do programa.
3. **Evita Erros Acidentais:** com a imutabilidade, podemos evitar erros acidentais que podem ocorrer devido a modificações inesperadas nos objetos. Uma vez que o objeto é criado, sabemos que ele permanecerá o mesmo.
4. **Facilidade de Testes:** objetos imutáveis são mais fáceis de testar, já que eles não possuem efeitos colaterais. Podemos criar instâncias e ter certeza de que elas não serão alteradas durante os testes.
5. **Caching e Reuso:** como instância imutáveis não mudam, elas podem ser facilmente armazenadas em cache e reutilizadas, melhorando o desempenho do aplicativo.

*private **final** CommentRepository commentRepository;*
Marcar o campo final destaca que esse campo não pode ser intencionalmente modificado. 

### 5.1.3 Using eager and lazy instantiation

**Resume**
Singleton é um padrão de projeto (design pattern) que garante que uma classe tenha apenas uma única instância durante toda a execução do programa e fornece um ponto de acesso global a essa instância.

No Spring, os beans são singleton por padrão, ou seja, o framework já implementa o padrão Singleton automaticamente para nós. Logo, quando injetamos um bean, ele continua sendo a mesma instância em todos os locais da nossa aplicação.

---
Na maioria dos casos, o Spring cria todos os singleton beans quando inicializa o contexto - este é o comportamento padrão do Spring. Utilizamos apenas esse comportamento padrão, que também é chamado de instância ávida *eager instantiation*. Nesta seção, discutimos uma abordagem diferente do framework, a instância tardia *lazy instantiation*, e comparamos essas duas abordagens. Com a instância tardia, o Spring não cria as instâncias singleton ao criar o contexto. Em vez disso, ele cria cada instância na primeira vez que alguém se refere ao bean. 

In our initial scenario, we only need a bean to test the default (eager) initialization. I'll keep tha namings we've been using, and i'll name this class *CommentService*. You make this class a bean, either using the @Bean *annotation approach* or *stereotype annotation*, as I've done in the next code snippet. But either way, make sure to add an output to the console in the class constructor. 

[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex3/src/main/java/org/example/sqch5ex3/comment/services/CommentService.java|CommentService]]

If we use a stereotype annotation, don't forget too add the *@ComponentScan annotation* in the configuration class. The configuration class in the next cod snippet example:
[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex3/src/main/java/org/example/configuration/ProjectConfig.java|ProjectConfig]]

In the Main class, we only instantiate the Spring context. A critical aspect to observe is that no one uses the *CommentService* bean. However, Spring will create and store the instance in the context. We know that Spring creates the instance because we'll see the output from the *CommentService* bean class's constructor when running the app. The next code snippet presents the Main class:
```java
public class Main {
	public static void main(String[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
	}
}
```
The up snippet code creates the Spring context, but it doesn't use the *CommentService* bean anywhere.

Even if the app doesn't use the bean anywhere, when running the app you'll fin the following output in the console:
*CommentService instance created!*

Ok! Now change the example (project ex4) by adding the *@Lazy* annotation above the class (for stereotype annotations approach) or above the @Bean method (for the @Bean method approach). You'll observe the output no longer appears in the console when running the app because we instructed Spring to create the bean only when someone uses it. And, in our example, nobody uses the *CommentService* bean. 

```java
@Service
@Lazy
public class CommentService {
	public CommentService() {
		System.out.println("CommentService instance created!");
	}
}
```

The *@Lazy* annotation tells Spring that it needs to create the bean only when someone refers to  the bean for the first time. 

Change the Main class and add a reference to the CommentService bean, as presented in the next code snippet:
```java
public class Main {
	public static void main(String[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

		System.out.prinln("Before retrieving the CommentService");
		var service = c.getBean(CommentService.class);
		System.out.println("After retrieving the CommentService");
	}
}
```

But, when should you use eager instantiation and when should you use lazy? In most cases, it's more comfortable to let the framework create all the instances at the beginning when the context is instantiated (eager); this way, when one instance delegates to another, the second bean already exists in any situation.

In a lazy instantiation, the framework has to first check if the instance exist and eventually create it if it doesn't, so from the performance point of view, it's better to have the instances in the context already (eager) because it spares some checks the framework needs to do when one bean delegates to another. Another advantage of eager instantiation is when something is wrong and the framework cannot create a bean. With lazy instantiation, someone would observe the issue only when the app is already executing and it reaches the point that the bean needs to be created.  

But lazy instantiation is not all evil. Some time ago, i worked on a vast monolithic application. This app was installed in different locations where it was used in various scopes by its clients. In most cases, a specific client didn't use a big part of the functionality, so instantiating the beans together with de Spring context unnecessarily occupied a lot of memory. For that app, the developers designed most of the beans to be lazily instantiated so that app would create only the necessary instances.

The author advice is to go with the default, which is an eager instantiation. This approach generelly brings more benefits. If you find yourself in a situation like the one I presented with the monolithic app, first see if you can do something about the app's design. For example, in my story, it would have been better if the app had been design in a modular way or as microservices.  Such an architecture would have helped the developers deploy only what specific clients needed, and then making the instantiation of the beans lazy wouldn't have been necessary. But in the real world, not everything is possible due to other factors like cost or time. If you cannot treat the real cause of the problem, you can sometimes treat at least some of the symptoms.

## 5.2 Using the prototype bean scope
In this section, we discuss the second bean scope Spring offers: prototype. In some cases, which we'll analyzè in this section, you'd go with prototype-scoped beans *instead (em vez de)* of singleton. 
- We'll discuss the framework's behavior for beans declared as prototype in section 5.2.1 You'll then learn how to change the bean's scope to prototype, and we'll try it with a couple of examples. 
- Finally, in section 5.2.2, we'll discuss real-world situations you need to know when using the prototype scope.
## 5.2.1 How prototype beans work
Toda vez que solicitamos uma referência a um bean de escopo prototype, o Spring cria uma nova instância do objeto. Para beans protótipo, o Spring não cria e gerencia uma instância de objeto diretamente. O framework gerencia o tipo do objeto e cria uma nova instância toda vez que alguém solicita uma referência ao bean. 

Na figura 5.6, o Bean é representado como uma planta de café (toda vez que solicitamos um bean, recebe uma nova instância). Ainda usamos o termo *bean*, mas a analogia com a planta de café ajuda a compreender e memorizar rapidamente o comportamento do Spring para beans *prototype*.

Como mostrado na figura 5.6, precisamos usar uma nova anotação chamada *@Scope* para alterar o escopo do bean. Quando criamos o bean usando a abordagem com a anotação *@Bean*, a anotação *@Scope* deve ser utilizada junto com *@Bean* no método que declara o bean. Já ao declarar o bean com anotações de estereótipo, devemos usar a anotação *@Scope* juntamente com a anotação de estereótipo na classe que declara o bean.

Com beans *prototype*, não há mais problemas de concorrência, pois cada thread que solicita o bean recebe uma instância diferente. Portanto, definir beans *prorotype* mutáveis não é um problema.
![[Chapter 5 -The Spring context - Bean scopes and life cycle-1.png]]

```java
@Configuration
public class ProjectConfig {
	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public CommentService commentService() {
		return new CommentService();
	}
}
```

Spring creates a bean and adds it to its context. Spring uses the type of the bean to create new instances each time they are requested, using the *@Bean* annotation. 

```java
public class Main {
	public static void main(String[] args) {
		var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

		var cs1 = c.getBean("commentService", CommentService.class);
		var cs2 = c.getBean("commentService", CommentService.class);

		boolean b1 = cs1 == cs2;
		System.out.println(b1); // this line always prints "false";
	}
}
```

Spring creates a new isntance every time the getBean() method is called. The variables cs1 and cs2 always contains references to two different instances.

**Declaring Prototype-Scoped Beans with @Bean**
To enforce our discussion, let's write a project "sq-ch5-ex5" and prove Spring's behavior for managing prototype beans. We create a bean named *CommentService* and declare it as prototype to prove we get a new instance every time we request that bean. The next code snippet presents the *CommentServices* class:
```java
public class CommentService {

}
```
[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex5/src/main/java/org/example/sqch5ex3/comment/services/CommentService.java|CommentService]]

[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex5/src/main/java/org/example/configuration/ProjectConfig.java|ProjectConfig]]

To prove that every time we request the bean we get a new instance, we create a Main class and request the beans twice from the context. We observe that the references we get are different. You find the definition of the *Main* class in the following listing.

[[Spring Start Here/PART 1/Capítulo 5 - The Spring context Bean Scopes and life cycle/sq-ch5-ex5/target/classes/org/example/sqch5ex3/main.class|main]]

When you run the app, you'll see it always displays "false" in the console. This output proves that the two instances received when calling the *getBean()* method are different.

---
A diferença principal entre um *bean* com escopo *prototype* e um *singleton* no Spring está no ciclo de vida e no número de instâncias criadas.

## 🔹 **Singleton (Padrão do Spring)**
```java
@Bean
public CommentService commentService() {
	return new CommentService();
}
```
- O que acontece?
	- O spring cria apenas UMA instância do *CommentService* e a reutiliza sempre que alguém solicita esse bean com *getBean()*;
	- Todos que pediram *CommentService* receberão a mesma instância;
	```java
	var cs1 = c.getBean("commentService", CommentService.class);
	var cs2 = c.getBean("commentService", CommentService.class);
	```
	- Como o Spring cria apenas uma instância única desse bean, cs1 e cs2 são o mesmo objeto na memória.


🔹 **Prototype (`@Scope(BeanDefinition.SCOPE_PROTOTYPE)`)**
```java
@Bean
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public CommentService commentService() {
	return new CommentService();
}
```
- O que acontece?
	- O spring cria uma nova instância do *CommentService* toda vez que alguém solicita esse *bean* com *getBean()*;
	- Cada solicitação gera um objeto diferente.
```java
	var cs1 = c.getBean("commentService", CommentService.class);
	var cs2 = c.getBean("commentService", CommentService.class);
```
- Como cada getBean cria uma nova instância, cs1 e cs2 são objetos diferentes na memória.









---
**Declaring Prototype-Scoped Beans using Stereotype Annotations**
Let's also create a project "sq-ch5-ex6" to observe the behavior for auto-wiring prototype-scoped beans. We'll define a *CommentRepositoty* prototype bean, and we inject the bean using *@Autowired* in two other service beans. We'll  observe that each service bean has a reference to a different instance of CommentRepository. This scenario is similar to the example we used in section 5.1 for singleton-scoped beans, but now the *CommentRepository* bean is prototype. The figure above describes the relationships between the beans.
![[Chapter 5 -The Spring context - Bean scopes and life cycle-2.png]]

The next code snippet gives definition of the *CommentRepository* class. Observe the *@Scope* annotation used over the class to change the scope of the bean to prototype:
```java
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepository {
	
}
```

The two service class request an instance of type *CommentRepository* using the *@Autowired* annotation. The next code snippet presents the *CommentService* class:
```java
@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public CommentRepository getCommentRepository() {
		return commentRepository;
	}
}
```

In the previous code snippet, the *UserService* class algo request an instance of the CommentRepository bean. In the configuration class, we need to use the *@ComponentScan* annotation to tell Spring where to fin the classes annotated with stereotype annotations:
```java
@Configuration
@ComponentScan(basePackages = {"services", "repositories"})
public class ProjectConfig {
	
}
```

---

### 5.2.2 Prototype Beans in real-world scenarios
So far we've discussed how Spring manages ptototype beans by focusing on the behavior. In this section, we focus more on the use cases and where you should (deve) use prototype-scoped beans in production apps. Just as we did (assim como fizemos) with singleton  in section 5.1.2, we'll consider the discussed characteristics and analyze which scenarios prototype beans are good for and where *should (deve)* you *avoid them (evitar eles)* (by using singleton beans). 

You won't find prototype beans as *often (frequentemente)* as you'll find singleton beans. But there is a good pattern you can use to decide if a bean should be prototype. Mas existe um bom padrão que pode usar para decidir se um bean deve ser do tipo *prototype*. Lembre-se de que beans singleton não são muito compatíveis com objetos mutáveis. Imagine que projetemos um objeto chamado *CommentProcessor*, responsável por processar e validar comentários. Um serviço utiliza o objeto *CommentProcessor* para implementar um caso de uso. No entanto, o objeto *CommentProcessor* armazena o comentário a ser processado como um atributo, e seus métodos alteram esse atributo (figura 5.9):
![[Chapter 5 -The Spring context - Bean scopes and life cycle-3.png]]

The **service class** uses a mutable object to implement the logic of a use case. 

## 1. Por que criar um pacote *processor*?
- Separação de responsabilidades: o pacote *processor* pode ser dedicado a classes que realizam processamento específico, como validação, transformação ou manipulação de dados. Isso mantém o código organizado e alinhado com o princípio de **responsabilidade única**.
- **Facilidade de localização:** ao criar um pacote específico para processadores, fica mais fácil encontrar classes relacionada ao processamento de dados, como *CommentProcessor*.

The code above shows the implementation of the CommentProcessor bean:
[[CommentProcessor.java]]
```java
public void processComment() {
	// changing the comment attribute
}

public void validateComment() {
	// validating and changing the comment attribute
}
```
These two methods alter the value of Comment attribute.

The code above presents this services that uses the *CommentProcessor* class to implement a use case. The service method creates an instance of *CommentProcessor* using the class's constructor and then ueses the instance in the method's logic:


---
## Summary
- No Spring, o escopo dos beans define como o framework gerencia as instâncias dos objetos.
- O Spring oferece dois escopos principais para beans: *singleton* e *prototype*. 
- No escopo #Singleton, o Spring gerencia diretamente as instâncias no seu contexto. <span style="background:#d4b106">Cada instância possui um nome único, e ao referenciá-lo, sempre se obtém essa mesma instância.</span> <span style="background:#b1ffff">O escopo #Singleton é o padrão do Spring.</span>
- No escopo #Prototype, o Spring considera apenas o tipo do objeto. Cada tipo possui um nome único associado a ele. <span style="background:#d4b106">O Spring cria uma instância desse tipo sempre que o bean for referenciado.</span>

- É possível configurar o Spring para instanciar um bean #singleton de forma antecipada #eager quando o contexto é inicializado, ou sob demanda #lazy na primeira vez que o bean for referenciado. Por padrão, os beans são instanciados #eagerly.

- Na maioria das aplicações, utilizamos **beans singleton**. Como qualquer referência ao mesmo nome retorna a mesma instância, múltiplas threads podem acessá-la simultaneamente. Por isso, é recomendável que a instância seja *imutável*. No entanto, se houver necessidade de modificar atributos do bean, a responsabilidade pela **sincronização de threads** recai sobre o desenvolvedor.

- Se for necessário um **objeto mutável**, o uso do escopo #prototype pode ser uma boa opção.

