#flashcards/Java/Data-Structures/chapter1 
*Chapter Objectives*
- To learn about #interfaces and their role in Java
- To understand #inheritance and how it facilitates code reuse
- To understand how Java determines which method to execute when there are multiple methods with the same name in a class hierarchy
- To become familiar with the #Exception class hierarchy and the difference between checked and uncheckd exceptions
- To learn how to define and use abstract classes as base classes in a hierarchy
- To learn the role of abstract data types and how to specify them using interfaces
- To study class Object and its methods and to learn how to override them
- To become familiar with a class hierarchy for shapes
- To understand how to create packages and to learn more about visibility

This chapter describes important features of Java that support Object-Oriented Programming (OOP) Object-oriented languages allow you to build and exploit hierarchies of classes in order to write code that may be more easily reused in new applications. We will learn how to extend an existing Java class to define a new class that **inherits** (herda) all the attributes of the original, as well as having additional attributes of its own. Because there may be many versions of the same method in a class hierarchy, we show how polymorphism enables Java to determine which version to execute at any given time.

We introduce interfaces and abstract classes and describe their relationship with each other and with actual classes. We introduce the abstract class *Number*. We also discuss class *Object*, which all classes extend, and we describe several of its methods that may be used in classes you create.

As an example of a class hierarchy and OOP, we describe the #Exception class hierarchy and explain that the Java Virtual Machine creates an #Exception object whenever an erros occurs during program execution. Finally, you will learn how to create packages in Java and about the different kinds of visibility for instance variables (data fields) and methods.

---
## Inheritance and Class Hierarchies
- 1.1 Abstract Data Types (ADTs), Interfaces, and the Java API
- 1.2 Introduction to Object-Oriented Programming
- 1.3 Method Overriding, Method Overloading, and Polymorphism
- 1.4 Abstract Classes
- 1.5 Class Object and Casting
- 1.6 A Java Inheritance Example - The Exception Class Hierarchy
- 1.7 Packages and Visibility
- 1.8 A Shape Class Hierarchy

### 1.1 Abstract Data Types (ADTs), Interfaces, and the Java API

#### **Importância/Motivações**
Entender Abstract Data Types (ADTs) é extremamente importante para quem estudar LeetCode. A grande maioria, inclusive eu, travava justamente por não entender isso.

1. **O LeetCode trabalha com ADTs o tempo todo**
Quando resolvemos problemas que envolvam estrutura de dados, usamos ADTs sem perceber:
- Stack
- Queue
- PriorityQueue
- Deque
- List
- Map
- Set

Aqui temos a gente alguns modelos abstratos de comportamento, e o que realmente importa nesses modelos é saber o que eles fazem, e não como cada um é implementado por baixo. 

2. **O LeetCode exige que decidamos o ADT mais adequado para cada problema**
Quase todo problema do LeetCode fica fácil quando a gente consegue responder a pergunta:
*Qual ADT resolve isso?*

- Valid Parentheses - Stack
- Top K Frequent Elements - PriorityQueue + HashMap
- Two Sum - HashMap
- Sliding Window Maximum - Deque
- Binary Tree Problems - Queue/Stack

Quando a gente entende ADTs, passamos a identificar a estrutural ideal para aquele problema em segundos.

3. **Entendemos a complexidade sem decorarmos**
Ao saber o comportamento abstrato, automaticamente vamos entender;
- Stack - push/pop O(1)
- Queue - enqueue/dequeue O(1)
- HashMap - busca O(1)
- PriorityQueue - extração O(log n)
- Set - busca O(1)
4. **ADT dá clareza na hora de escrever a solução**
Não precisamos reinventar a roda, só usarmos o ADT correto.
5. **O ADT permite pensarmos como engenheiro, não como copiador**
Você para de decorar as soluções, entende o propósito da estrutura, consegue se adaptar a problemas novos, parando de travar quando o problema apresenta um detalhe novo para você.


### Introduction
In earlier programming courses, you learned how to write individual classes consisting of attributes and methods (operations). You also learned hot to use existing classes (e.g., String and Scanner) to facilitate our programming. <span style="background:#affad1">These classes are part of the Java Application Programming Interface (API)</span>.

One of our goals is to write code that can be <font color="#ffff00">reused in many different applications</font>. One way to make code reusable is to encapsulate the data elements together with the methods that operate on that data. A new program can then use the methods to manipulate an object's data **without being concerned** (sem estar preocupado) about details of the data representation or the method implementations. The encapsulate data together with its methods is called an **abstract data type (ADT)**.

Figure 1.1 shows a diagram of an ADT. The data values stored in the ADT are hidden inside the circular wall. The bricks around this wall are used to indicate that these data values cannot be accessed except by going through the ADT's methods.

A class provides one way to implement an ADT in Java. <span style="background:#affad1">If the data fields are private, they can be accessed only through public methods</span>. Therefore, the *methods control access* to the data and determine the way the dada is manipulated.

Another goal of this text is to show you how to write and use ADTs in programming. As you progress through this book, you will create a large collection of ADT implementations (classes) in your own program library. You will also learn about ADTs that are available for you to use through the Java API. 

Our principal focus will be on ADTs that are used for structuring data to enable our to more easily and efficiently store, organize, and process information. These ADTs are often called *data structures*. We introduce the Java Collections Framework (part of the Java API), which provides implementations of these common data structures, in Chapter 2 and study it throughout the text. Using the classes that are in the Java Collections Framework will make it much easier for you to design and implement new application programs.

**Resumo**: 
Um ADT é um modelo lógico de dados, definido pelo **comportamento** (operações permitidas) e regras, e não pela implementação. Um ADT descreve o que a estrutura faz, e não como ela faz. Em Java, isso parece como interfaces ou classes abstratas que definem operações, por exemplo:
- List
- Set
- Map

Essas interfaces definem as operações (adicionar, buscar, remover...), mas não dizem como elas são implementadas. Essa parte é feita pelas classes concretas:
- ArrayList, LinkedList (implementações de List)
- HashSet, TreeSet (implementações de Set)
- HashMap e TreeMap (implementação de Map)

ADT e um contrato de comportamento, separando interface a interface da sua implementação concreta.

**O ADT (a interface)**
Define o que a estrutura faz:
```java
public interface Counter {
	void increment();
	void decrement();
	int getValue();
}
```

2. **Implementação concreta do ADT (classe):**
Define como é feito.
```java
public class SimpleCounter implements Counter {
	private int value = 0;
	
	@Override
	public void increment() {
		value++;
	}
	
	@Override
	public void decrement() {
		value--;
	} 
	
	@Override
	public int getValue() {
		return value;
	}
}
```

### Interfaces
A Java #interface is a way to specify or describe an ADT (Abstract Data Type) to an applications programmer. An  interface is like a contract that tells the applications programmer precisely what methods are available and describes the operations they perform. It also tells the applications programmer what argument, if any, must be passed to each method and what result the method will return. Of course, in order to make use of these methods, someone else must have written a class that *implements the interface* by providing the code for these methods.

The interface tells the coder precisely what methods must be written, <span style="background:#affad1">but it does not provide a detailed algorithm or prescription for how to write them</span>. The coder must "program to the interface," which means he or she must develop the methods described without variation. **If each coder does this job well, that ensures that other programmers can use the completed class exactly as it is written, without needing to know the details of how it was coded.**

There may be more than one way to implement the methods; hence, several classes may implement the interface, but each must satisfy the contract. One class my be more efficient than the other at performing certain kinds of operations (e.g., retrieving information from a database), so that class will be used if retrieval operations are more likely in a particular application. The important point is that the particular implementation that is used will not affect other classes that interact with it because every implementation satisfies the contract.

Besides providing the complete definition (implementation) of all methods declared in the interface, each implementer of an interface may declare data fields and define other methods not in the interface, including constructors. An **interface** <span style="background:#ff4d4f">cannot contain constructors</span> because it cannot be instatiated, that is, one one cannot create objects, or instances, of it. However, it can be represented by instances of classes that implement it.

#### Nota 1: 
**Quando um programador define bem uma interface — ou um Abstract Data Type (ADT), ele estabelece um contrato claro de uso. Isso permite que outros desenvolvedores utilizem a classe exatamente como foi projetada, sem precisar conhecer ou depender dos detalhes internos da sua implementação.**




#### Resumo
Em algoritmos, uma interface é a materialização de um tipo abstrato de dados. Quando estudamos uma Pilha, Stack, na teoria, estudamos as suas operações (push, pop, peek). Em Java, a interface define essas operações. Isso é crucial porque permite que troquemos a estrutura de dados subjacente (o "como") sem quebrar o código que usa essa estrutura. 

**Exemplo prático:** se programamos voltado para a interface *List*:
```java
List<String> data = new ArrayList<>();
```

Podemos mudar a implementação para #LinkedList no futuro se percebermos que estamos fazendo diversas inserções no meio da lista, sem alterar o resto do nosso código.

Devemos programar para a Interface, não para a implementação. No LeetCode isso aparece sutilmente: a assinatura do método que o site nos fornece (*public int solve(int[] nums*) é a interface. Não podemos mudar a entrada nem a saída, somos obrigados a cumprir o contrato, não importa quão "feio" seja o nosso código interno (desde que passe nos testes).

Diferentes classes podem implementar a mesma interface com eficiências diferentes. Isso é a anotação Big O puro. 
Uma interface Map pode ser implementada como HashMap (busca O(1) média) ou TreeMap (busca O(log n)).
Devemos **pensar qual implementação escolher para satisfazer, a interface determina se a nossa solução leetCode dará Time Limit Exceeded ou Accepted**.

**Erro comum**: um erro clássico de iniciantes é instanciar a classe concreta no tipo da variável:
```java
ArrayList<String> list = new ArrayList<>();
```
O correto é usar a interface mais genérica possível do lado esquerdo:
```java
List<String> list = new ArrayList<>();
```
**Exercícios Típicos de LeetCode**
Estes exercícios focam em *Design* e *Implementação de Interfaces/ADTs*, forçando a criarmos classes que cumprem um contrato específico.


**Texto para o Vídeo**
Muita gente acha que interface é só uma regra de sintaxe do Java, mas, eu quero deixar bem claro que: a interface é um contrato. Ela define o quê o nosso programa faz, mas não o 'como' ele faz. É a definição pura de um Tipo Abstrato de Dados, ou TAD.

Quando o os exercícios de LeetCode nos apresenta um problema, ele nos entrega a assinatura de um método. Aquilo é claramente a interface.

### Example 1.1
Uma **Máquina de Autoatendimento Bancário (ATM)** permite que um usuário realize determinadas operações bancárias a partir de um local remoto. It must support the following operations.
1. Verify a user's personal identification number (PIN);
2. Allow the user to choose a particular account.
3. Withdraw a specified amount of money.
4. Display the result of an operation
5. Display an account balance.

A class that implements an ATM must provide a method for each operation. We can write this requirement as the interface ATM and save it in file ATM.java, show in snipped code about, 1.1 The keyword *interface* on the header line indicates that an interface is being declared. If we are unfamiliar with the documentation style shown in this listing, read about Java documentation at the end of Section A.7 in Appendix A.
[[ATM.java]]

The interface definition shows the heading only for several methods. Because only the heading are shown, they are considered *abstract methods*. Each actual method with its body must be defined in a class that implements the interface. Therefore, a class that implements this interface must provide a void method called *verifyPIN* with an argument of type String. There are also two display methods with different signatures. The first is used to display the result of a withdrawal, and the second is used to display the result of a PIN verification. The *keywords* public abstract are optional (and usually omitted) in a interface <span style="background:#affad1">because all interface methods are public and abstract by default</span>.






### The implements Clause
The class headings (títulos) for two classes that implement interface ATM are:
*public class ATMbankAmerica implements ATM*
*public class ATMforAllBanks implements ATM*

Each class heading ends with the clause *implements* ATM. When compiling theses classes, Java compiler will verify that they define the required methods in the way specified by the interface. If a class implements more than one interface, list them all after implements, with commas as separators.

Figures 1.2 is a UML (Unified Modeling Language) class diagram that shows the ATM interface and these two implementing classes. Note that a dashed line from the class to the interface is used to indicate that the class implements the interface. We will use UML diagrams throughout this text to show relationships between classes and interfaces. Appendix B provides more details about UML class diagrams.

!![image-202511242935695.png](/image-202511242935695.png)

**PITFALL**
Não definir corretamente um método a ser implementado
Se deixarmos de definir o método **verifyPIN** na classe **ATMforALLBanks**, ou se usarmos uma assinatura diferente, ocorrerá o seguinte erro de sintaxe:

**class ATMforAllBanks should be declared abstract; it does not define method verifyPIN(String) in interface ATM.**

Esse erro indica que o método **verifyPIN** não foi definido corretamente. Como a classe contém um método abstrato que não foi implementado, o Java passa a acreditar (incorretamente, do seu ponto de vista) que **ATMforAllBanks** deveria ser declarada como uma classe abstrata.

Se usarmos um tipo de retorno diferente de **boolean**, também ocorrerá um erro de sintaxe.

**PITFALL**
Instantiating an Interface
An interface is not a class, so we cannot instantiate an interface. The statement
ATM anATM = new ATOM(); // invalid statement

will cause the following syntax error:
interface ATM is abstract; cannot be instantiated.



### Declaring a Variable of an Interface Type
In the previous programming pitfall, we mentioned that we cannot instantiate an interface. However, we want to declare a variable that has an interface type and use it to reference an actual object. **This is permitted if the variable references an object of a class type that implements the interface**. After the following statements execute, variable ATM1 references an ATMbankAmerica *object*, and variable ATM2 references an **ATMforAllBanks** object, but both ATM1 and ATM2 are type ATM.

ATM ATM1 = new ATMbankAmerica(); // valid statement
ATM ATM2 = new ATMforAllBanks(); // valid statement

... **podemos declarar variáveis usando o tipo da interface**, desde que elas guardem objetos de classes que implementam essa interface.
### Exercises for Section 1.1
**SELF-CHECK**
1. What are the two partes of an ADT? Which part is accessible to a user and which is not? Explain the relationships between an ADT and a class, between an ADT and an interface, and between an interface and classes that implement the interface.
Answer: um *abstract data type* possuí dados (modelo lógico do tipo, de maneira abstrata) e métodos (operações). Os atributos, ADT data's (dados) não são acessíveis diretamente e os métodos são acessíveis, que geralmente é a forma como os dados são acessados, criados e utilizados. ADT fornece uma assinatura que as classes geralmente irão implementar/utilizar, cada uma, a sua maneira. 

Geralmente, os tipos de dados abstratos são construídos através de uma interface, ou seja, uma interface é uma forma de especificar ou descrever um ADT. 

Quando uma classe implementa uma interface, ela deve implementar seus métodos abstratos.

Em Java, um ADT é normalmente descrito por uma *interface*, que especifica apenas as operações permitidas.

As classes que implementam a interface fornecem a implementação concreta dessas operações, incluindo suas próprias variáveis de instância e estruturas internas, que não são visíveis ao usuário.

2. Explain how an interface is like a contract.
An interface acts like a *contract* because it defines a set of abstract operations that any implementing class is #obligated to provide. In Java, an interface is often used to describe an Abstract Data Type (ADT): it specifies *what* operations exist, but not *how* they are implemented.

Any class that implements the interface must provide concrete implementations for all of its abstract methods and must follow the exact method signatures defined. Because of this enforced obligation and consistency, we say an interface works like a contract between the ADT specification and the classes that implement it.

A interface age como um contrato pois ela define um conjunto de operações abstratas que qualquer classe que implementá-la deverá obrigatoriamente fornecer. 




**Q1 — Quais são as duas partes de um Abstract Data Type (ADT)?**
A) Métodos públicos e construtor
B) Estrutura de dados interna e herança
C) _Dados abstratos_ (modelo lógico) e _operações_
D) Interface e implementação
?
C) _Dados abstratos_ (modelo lógico) e _operações_
<!--SR:!2025-11-26,1,230-->

**Qual parte do ADT é acessível ao usuário?**  
A) Os dados internos (atributos)  
B) Somente o construtor  
C) As operações (métodos definidos na interface)  
D) A estrutura concreta usada para armazenar os dados
?
**C) As operações (métodos definidos na interface)**

**Q3 — What best describes the relationship between ADTs, interfaces, and classes in Java?**  
A) An interface implements an ADT and classes just use it.  
B) A class defines the ADT and the interface implements it.  
C) An ADT is specified by an interface, and a class provides the concrete implementation.  
D) ADT, interface, and class mean the same thing
?
**C) An ADT is specified by an interface, and a class provides the concrete implementation.**  

An ADT is defined by two parts: ==abstract data (not directly accessible)== and ==operations (accessible to the user)==.

In Java, an ADT is typically described by ==an interface==, and classes that implement this interface provide ==the concrete implementation== while ==hiding internal details==.

**Why is an interface considered a contract in Java?**
A) Because it automatically provides default implementations to all classes.  
B) Because it forces any implementing class to follow the method signatures it defines.  
C) Because it exposes its internal data structure to subclasses.  
D) Because it allows multiple inheritance of state.
?
B) Because it forces any implementing class to follow the method signatures it defines.  

An interface is considered a ==contract== because any class that implements it is ==obligated== to provide concrete implementations for all of its abstract methods and follow the ==exact method signatures== defined by the interface.


Why is this interface considered a "contract"?
```java
public interface PaymentProcessor {
    void process(double amount);
}
```
?
Because any class implementing *PaymentProcessor* must provide the method `process(double amount)` exactly as declared, fulfilling the required behavior — like signing a contract and agreeing to its terms.

3. Correct each of the following statements that is incorrect, assuming that class PDGUI and class PDConsoleUI implement interface PDUserInterface and neither is a subclass of the other.

PDGUI implements PDUserInterface
PDConsoleUI implements PDUserInterface

*Podemos precisar declarar uma variável que seja do tipo de uma interface e usá-la para referenciar um objeto.* Podemos realizar isso se a variável referenciar um objeto do tipo de classe que implementa a interface.

- PDGUI p1 = new PDConsoleUI();
PDUserInterface p1 = new PDGUI();

- PDGUI p2 = new PDUserInterface(); ->
   PDUserInterface p2 = new PDGUI();

- PDUserInterface p3 = new PDUserInterface(); A forma correta, seria utilizar uma classe implementa a interface...
- PDUserInterface p4 = new PDConsoleUI(); (Correto)
- PDGUI p5 = new PDUserInterface(); -> PDUserInterface p5 = new PDGUI();
PDUserInterface p6 = p5;
PDUserInterface p7;
## 1.2 Introduction to OOP

## 1.3 Method Overriding, Method Overloading, and Polymorphism
## 1.4 Abstract Classes
## 1.5 Class Object and Casting
## 1.6 A Java Inheritance Example - The Exception Class Hierarchy
## 1.7 Packages and Visibility
## 1.8 A Shape Class Hierarchy
