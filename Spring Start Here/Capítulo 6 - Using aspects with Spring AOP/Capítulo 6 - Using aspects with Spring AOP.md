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
