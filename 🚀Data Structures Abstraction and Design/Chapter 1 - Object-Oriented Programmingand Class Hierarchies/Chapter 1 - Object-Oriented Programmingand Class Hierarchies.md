#flashcards/Java/Data-Structures/chapter1/chapter1
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
<!--SR:!2025-12-20,12,230-->

**Qual parte do ADT é acessível ao usuário?**
A) Os dados internos (atributos)
B) Somente o construtor
C) As operações (métodos definidos na interface)
D) A estrutura concreta usada para armazenar os dados
?
**C) As operações (métodos definidos na interface)**
<!--SR:!2025-12-19,11,248-->

**Q3 — What best describes the relationship between ADTs, interfaces, and classes in Java?**
A) An interface implements an ADT and classes just use it.
B) A class defines the ADT and the interface implements it.
C) An ADT is specified by an interface, and a class provides the concrete implementation.
D) ADT, interface, and class mean the same thing
?
**C) An ADT is specified by an interface, and a class provides the concrete implementation.**
<!--SR:!2025-12-26,12,248-->

An ADT is defined by two parts: ==abstract data (not directly accessible)== and ==operations (accessible to the user)==.
<!--SR:!2025-12-20,12,248!2026-01-02,19,268-->

In Java, an ADT is typically described by ==an interface==, and classes that implement this interface provide ==the concrete implementation== while ==hiding internal details==.
<!--SR:!2025-12-19,11,248!2025-12-27,13,248!2025-12-19,5,228-->

**Why is an interface considered a contract in Java?**
A) Because it automatically provides default implementations to all classes.
B) Because it forces any implementing class to follow the method signatures it defines.
C) Because it exposes its internal data structure to subclasses.
D) Because it allows multiple inheritance of state.
?
B) Because it forces any implementing class to follow the method signatures it defines.
<<<<<<< HEAD
<!--SR:!2025-12-19,11,247-->

=======
<!--SR:!2025-12-27,13,247-->

>>>>>>> 609e0c1c0d71724b50d2de29049903857fbdc6f5
<!--SR:!2025-11-27,2,248-->

An interface is considered a ==contract== because any class that implements it is ==obligated== to provide concrete implementations for all of its abstract methods and follow the ==exact method signatures== defined by the interface.
<!--SR:!2025-12-25,11,248!2025-12-26,12,248!2025-12-18,10,228-->


Why is this interface considered a "contract"?
```java
public interface PaymentProcessor {
    void process(double amount);
}
```
?
Because any class implementing *PaymentProcessor* must provide the method `process(double amount)` exactly as declared, fulfilling the required behavior — like signing a contract and agreeing to its terms.
<!--SR:!2025-12-19,11,248-->

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

4. What are two different uses of the term *interface* in programming?
Interface como a forma de se definir os métodos e dados abstratos e interface como forma de interação entre usuários (command line interface and Application Programming Interface) e GUI (Graphical User Interface.)
## 1.2 Introduction to OOP
In this course, we will learn to use features of Java that facilitate the practice of OOP. A major reason for the popularity of OOP is that **it enables programmers to reuse previously written code saved as classes**, reducing the time required to code new applications. Because previously written code has already been tested and debugged, the new applications should also be more reliable and therefore easier to test and debug.

However, OOP provides additional capabilities beyond the reuse of existing classes. If an application needs a new class that is similar to an existing class but not exactly the same, the programmer can create it by extending, or inheriting from, the existing class. **The new class (called the subclass) can have additional data fields and methods for increased functionality.** Its objects also inherit the data fields and methods of the original class (called the superclass). 

Inheritance in OOP is analogous to inheritance in humans. We all inherit genetic traits from our parents. If we are fortunate, we may even have some earlier ancestors who have left us an inheritance of monetary value. As we grow up, we benefit from ours ancestors' resources, knwoledege, and experiences, but our experiences will not affect how our parents or ancestors developed. Although we have two parents to inherit from, Java classes can have only one parent.

Inheritance and hierarchical organization allow we to capture the ideia that one thing may be a refinement or a extension of another. For example, an object that is a *Human* is a Mammal (the superclass of Human). This means that an object of type Human has all the data fields and methods defined by class **Mammal** (e.g., methods **drinkMothersMilk**), but it may also have more data fields and methods that are not contained in class **Mammal** (e.g., methods *thinkCreatively*). Figure 1.3 shows this simple hierarchy. The solid line in the UML class diagram shows that **Human** is a subclass of Mammal, and, therefore, Human objects can use methods **drinkMothersMilk** and **thinkCreatively**. Objects farther down the hierarchy are more complex and less general than those farther up. 

**A Superclass and Subclass Example**
To illustrate the concepts of inheritance and class hierachies, let's consider a simple case of twi classes: **Computed** and **Notebook**. A **Computed** object has a *manufacturer*, processor, Random Acess Memory(Ram), and disk. A notebook computer is a kind of computer, so it has all the properties of a computer plus some additional features (screen size and weight). There may be other subclasses, such as tablet computer or game computer, but we will ignore them for now. We can define class **Notebook** as a subclass of class **Computer**. Figure 1.4 shows the class hiearachy.

**Class *Computer***
Listing 1.2 shows class **Computer.Java**. It is defined like any other class. It contains a constructor, several accessors, a **toString** method, and a method **computePower**, which returns the product of its RAM size and processor speed as a simple measure of its power.

```java
public class Computer {
	//Data Fields
	private String manufacturer;
	private String processor;
	private int ramSize;
	private int diskSize;
	private double processorSpeed;
	
	// Methods
	public Computer(String man, String processor, int ram, int disk, double procSpeed) {
		manufacturer = man;
		this.processor = processor;
		ramSize = ram;
		diskSize = disk;
		processorSpeed = procSpeed;
	}
	
	public double computePower() {
		return ramSize * processorSpeed;}
		
		public int getRamSize() {
			return ramSize;
		}
		
		public double getProcessorSpeed() {
			return processorSpeed;
		}
		
		public int getDiskSize() {
			return diskSize
;		}

		public String toString() {
			String result = "Manufacturer: " + manufacturer +
			"\nCPU: " + processor +
			"\nRAM: " + ramSize + " gigabytes" +
			"\nDisk: " + diskSize + " gigabytes" +
			"\nProcessor speed: " + processorSpeed + " gigahertz";
			return result;
}
	}
}
```

**Use of this.**
In the constructor for the **Computer** class, the statement
*this.processor = processor;*
sets data field *processor* in the object under construction to reference the same string as parameter processor. The prefix this. makes data field processor visible in the constructor. This is necessary because the declaration of processor as a parameter hides the data field declaration.

**PITFALL**
**Not Using this. to Access a Hidden Data Field**
If we write the preceding statement as processor = processor; we will not get an error, but the data field processor in the computer object under construction will not be initialized and will retain its default value(null). If we later attempt to use data field **processor**, we may get an error or just a unexpected result. Some integrated Development Environments (DIEs) will provide a warning if this. is comitted.

**Class *Notebook***
In the Notebook class diagram in Figure 1.4, we show just the data fields declared in class **Notebook**; however, **Notebook** objects also have the data fields that are inherited from class Computer (processor, ramSize, and so forth). The first line in class Notebook (Listing 1.3):
```java
public class Notebook extends Computer {
	// indicates that class Notebook extends class Computer and inherits its data and methods. Next, we define any additional data fields
	// Data Fields
	private double screenSize;
	private double weight;
}
```

**Initializing Data Fields in a Subclass**
The constructor for class Notebook must begin by initializing the for data fields inherited from class **Computer**. Because those date fields are private to the superclass, Java requires that they be initialized by a superclass constructor. Therefore, a superclass constructor must be invoked as the first statement in the constructor body using a statement such as
super(man, proc, ram, disk, procSpeed);

This statement invokes the superclass constructor with the signature **Computer(String, String, double, int, double)**, passing the four arguments listed to the constructor. (A method signature consist of the method's name followed by its parameter types). The following constructor for Notebook also initializes the data fields that are not inherited. Listing 1.3 shows class **Notebook**.
public Notebook(String man, String proc, double ram, int disk, double procSpeed, double screen, double wei) {
	super(man, proc, ram, disk, procSpeed);
	screenSize = screen;
	weight = wei;
}

**SYNTAX super(...);**
FORM
super();
super(argumentList);

Example:
super(man, proc, ram, disk, procSpeed);

Meaning:
The supper() call in a class constructor invokes the superclass's constructor that has the corresponding *argumentList*. The superclass constructor initializes the inherited data fields as specified by its *argumentList*. The **super()** call must be the first statement in a constructor.

**Class Notebook**
```java
public class Notebook extends Computer {
	// Data Fields
	private double screenSize;
	private double weight;
	
	// Methods
	public Notebook(String man, String proc, int ram, int disk, double procSpeed, double screen, double wei) {
		super(man, proc, ram, disk, procSpeed);
		screenSize = screen;
		weight = wei;
	}
}
```

**The No-Parameter Constructor**
If the execution of any constructor in a subclass does not invoke a superclass constructor, Java automatically invokes the no-parameter constructor for the superclass before the subclass starts to initialize its part of the object. Otherwise, the part of the object that is inherited would remain uninitialized.

**PITFALL**
**Not Defining the No-Parameter Constructor**
If no constructors are defined for a class, the no-parameter constructor for that class **will be provided by default**. However, if any constructors are defined, the no-parameter constructor must also be defined explicitly if it needs to be invoked. Java does not provide it automatically because it may not make sense to create a new object of that type without providing initial data fields values. No entanto, se qualquer construtor for definido, o construtor sem parâmetros deverá também ser definido **explicitamente** caso precise ser utilizado. O Java não o fornece automaticamente nesse caso, pois pode não fazer sentido criar um novo objeto desse tipo sem fornecer valores iniciais para os atributos. Ele não foi definido na classe *Notebook* ou *Computer* porque queremos que o cliente especifique alguma informação sobre um objeto *Computer* quando esse objeto é criado.

If the no-parameter constructor is defined in a subclass but is not defined in the superclass, we will get a syntax erros constructor not defined. We can also get this erros if a subclass constructor does not explicitly call a superclass constructor. There will be an implicit call to the no-parameter superclass constructor, so it must be defined. 

**Protected Visibility for Superclass Data Fields**
The data fields inherited from class **Computer** have private visibility. Therefore, they can be accessed only within class Computer. Because it is fairly common for a subclass method to reference data fields declared in its superclass, Java provides a less restrictive form of visiibility called *protected visibility*. A data field (or method) with protected visibility can be accessed in the class defining it, in any subclass of that class, or in any class in the same package. Therefore, if we had used the declaration 
*protected* **String** manufacturer;

in class Computer, the following assignment statement would be valid in class Notebook:
manufacturer = man;

We will use protected visibility on occasion when we are writing a class that we intend to extend. However, in general, it is better to use private visibility because subclassses may be writeen by different programmers, and it is always a good practice to restrict and control access to the superclass data fields. We discuss visibility further in Section 1.7.

**Is-a versus Has-a Relationships**
One misuse of inheritance is confugsing: the *has-a* relationship with the *ias-a* relationship.

- *is-a* relationship between classes means that one class is a subclass of the other class. For example, a game box is not really a computer (it is a kind of entertainment device), but it has a computer as a component. 

- *has-a* relationship is achieved by declaring a Computer data field in the game box class. class car { private Engine engine;} // Car has-a Engine 
### Exercises for section 1.2
1. Explain the effect of each valid statement in the following fragment. Indicate any invalid statements.
	- Computer c1 = new Computer(); **não compila, a classe Computer não tem um construtor sem parâmetros**. *constructor Computer() is undefined*
	- Computer c2 = new Computer("Ace", "AMD", 16, 1536, 4.1);
	- Notebook c3 = new Notebook("Ace", "AMD", 32, 3584, 3.8); **gera erro de compilação, o construtor parametrizado exige 7 valores.**


	- System.out.println(c2.manufacturer + ", " + c4.processor); **não compila, pois precisamos utilizar os métodos acessadores.**

	- System.out.println(c2.getDiskSize() + ", " + c4.getRamSize());

	- System.out.println(c2.toString() + "/n" + c4.toString()); **herda de Computer e exibe apenas os valores repassados**

Can we add the following constructor to class Notebook? If so, what would we need to do to class Computer?
**public** *Notebook()* {} 
**Não compila, pois Java insere automaticamente super(), ou seja, ele tenta chamar o construtor sem parâmetros da superclasse (Computer)**.

Receberemos o erro Computer() is undefined.
What does an _is-a_ relationship represent in OOP?
A) Composition
B) Inheritance
C) Overloading
D) Encapsulation
?
B) Inheritance
<!--SR:!2025-12-27,13,247-->

What does a *has-a* relationship represent in OOP?
A) Inheritance
B) Polymorphism
C) Composition
D) Abstraction
?
C) Composition
<!--SR:!2025-12-20,12,247-->

Which class is more general in inheritance?
A) Subclass
B) Superclass
C) Interface
D) Object instance
?
B)Superclass
<!--SR:!2025-12-21,13,247-->

**If a class defines a constructor with parameters, what happens to the no-argument constructor?**
A) It is still generated automatically
B) It is removed from Java
C) It must be written explicitly if needed
D) It becomes `protected`
?
C) It mus be written explicitly if needed
<!--SR:!2025-12-20,12,247-->


**Where must `super(...)` appear inside a subclass constructor?**
A) Anywhere
B) Second line
C) Last line
D) First line
?
D) First Line
<!--SR:!2025-12-25,11,247-->

**If a subclass does not explicitly call super(...) in its constructor:**
A) Java inserts `super()` automatically
B) The code will not compile
C) The subclass fields become `null`
D) Private fields become accessible
?
A) Java inserts super() automatically.
<!--SR:!2025-12-21,13,247-->

**`Computer c = new Computer();` fails to compile when:**
A) `Computer` has only constructors with parameters
B) `Computer` is abstract
C) Private fields exist
D) Getters are not implemented
?
A) Computer has only constructors with paramters
<!--SR:!2025-12-26,12,247-->





## 1.3 Method Overriding, Method Overloading, and Polymorphism
In the preceding section, we discussed inherited data fields. We found that we could not access an inherited data field in a subclass object if tis visibility was private.  Methods generally have public visibility, so we should be able to access a method that is inherited. However, whet if there are multiple methods with the same name in a  class hierarchy? <span style="background:#affad1">How does Java determine which one to invoke?</span> We answer this question next.
### Method Overriding
Let's use the following main method to test our class hierarchy.
```java
// Tests classes Computer and Notebook. Creates an object of each and displays them.
// @paragm args[] No control paramters
public static void main(String[] args) {
	Computer myComputer = new Computer("Acme", "Intel", 32, 2560, 4.7);
	Notebook ourComputer = new Notebook("DellGate", "AMD", 8, 256, 3.4, 13.3, 2.94);
	System.out.println("My computer is :\n" + myComputer.toString());
	System.out.println("\nYour computer is:\n" + ourComputer.toString());
}
```

In the second call to println, the method call *ourComputer.toString()* applies method toString to object ourComputer (type Notebook). Because class Notebook doesn't define its own toString method, class Notebook inherits the toString method defined in class Computer. Executing this method displays the following output lines:
My computer is:
Manufacturer: Acme
CPU: Intel
RAM: 32 gigabytes
Disk: 2560 gigabytes
Speed: 4.7 gigahertz

Your computer is:
Manufacturer: DellGate
CPU: AMD
RAM: 8 gigabytes
Disk: 256 gigabytes
Speed: 3.4 gigahertz

Unfortunately, this output doesn't show the complete state of object ourComputer.  To show the complete state of a notebook computer, we need to define a *toString* method for class Notebook. If class Notebook has its own toString method, it will override the inherited method and will be invoked by the method call ourComputer.toString(). We define method toString for class Notebook next.
```java
public String toString() {
	public String toString() {
		String result = super.toString() +
			"\nScreen size: " + screenSize + " inches" +
			"\nWeight: " + weight + " pounds";
		return result;
	}
}
```

This method Notebook.toString return a string representation of the state of a Notebook object. The first line String result = super.toString() uses method call **super**.toString() to invoke the toString method of the superclass (method Computer.toString) to get the string representation of the four data fields that are inherited from the superclass. The next two lines append the data fields defined in class Notebook to this string.

FORM:
super.methodName()
super.methodName(argumentList)

EXAMPLE:
super.toString()

**MEANING**
Using the prefix *super.* in a call to method *methodName* class the method with that name defined in the superclass of the current class.

**RESUMO:** estamos explicitamente chamando a implementação do método que está na superclasse, mesmo que esse método tenha sido sobrescrito (override) na subclasse.

**PROGRAM STYLE**
*Calling Method toString() Is Optional*
In the println statement shown earlier, System.out.println("My computer is:\n" + myComputer.toString()); the explicit call to method toString is not required. The statement could be written as *System.out.println("My computer is:\n" + myComputer*; Java auomatically applies the toString method to an object referenced in a String expression. Normally, we will note explicitly call *toString*.
### Method Overloading
Let's assume we have decided to standardize and purchase our notebook computers from only one manufacturer. We could then introduce a new constructor with one less parameter for class **Notebook**.
public Notebook(String proc, int ram, int disk, double procSpeed, double screen, double wei) {
	this(DEFAULT_NB_MAN, proc, ram, disk, procSpeed, screen, we);
}

The method call
this(DEFAULT_NB_MAN, proc, ram, disk, procSpeed, screen, wei);
invokes six-parameter constructor begins by calling the superclass constructor, satisfying the requirement that it be classed first. We now have two constructors with different signatures in class Notebook. Having multiple methods with the same name but different signatures in a class is called *method overloading*.

Now we have two ways to create new Notebook objects. Both of the following statement are valid:
*Notebook 1TP1 = new Notebook("Intel", 16, 512, 4.6, 13.3, 3.18);*
*Notebook 1TP2 = new Notebook("MicroSys", "AMD", 8, 256, 3.9, 17, 5.4);*

Listing 1.4 shows the complete class Notebook. Figure 1.5 shows the UML diagram, revised to show that Notebook has a toString method and a constant data field. The next Pitfall discusses the reason for the @Override annotation preceding method toString.

```java
public class Notebook extends Computer {
	private static final String DEFAULT_NB_MAN = "MyBrand";
	private double screenSize;
	private double weight;
	
	public Notebook(String man, String proc, int ram, int disk, double procSpeed, double screen, double wei) {
		super(man, proc, ram, disk, procSpeed);
		screenSize = screen;
		weight = wei;
	}
	
	// Initializes a Notebook object with 6 properties specified.
	public Notebook(String man, String proc, int ram, int disk, double procSpeed, double screen, double wei) {
		super(man, proc, ram, disk, procSpeed);
		screenSize = screen;
		weight = wei;
	}

	@Override
	public String toString() {
		String result = super.toString() + ...
		return result;
	}
}
```

**PITFALL**
*Overloading a Method When Intending to Override It*
To override a method, we must use the same name and the same number and types of the parameters as the superclass method that is being overridden. If the name is the same but the number or types of the parameters are different, then the method is overloaded instead. Normally, the compiler will note detect this as an error. However, it is a sufficientyle common error that a feature was added to the Java compiler so that programmers can indicate that they intend to override a method. If we preced the declaration of the method with the annotation *@Override*, the compiler will issue an error message if the method is overloaded instead of overridden.

**Por que usar @Overridade é importante?**
Porque o compilador **confirma** que realmente estamos sobrescrevendo um método existente. 

Sem a anotação, se cometermos um erro, como digitar o nome errado, ou mudar a assinatura do método, o compilador não avisa, e acabamos criando um método novo sem perceber.

### Polymorphism
An important advantage of OOP is that it supports a feature called *polymorfphism*, which means many forms or many shapes.  #Polymorphism ou #Polimorfismo enable the JVM to determine at run time which of the classes in a hierarchy is referenced by a superclass variable or parameter. Next, we will see how this simplifies the programming process.

Suppose we are not sure whether a computer referenced in a program will be a notebook or a regular computer. IF we declare the reference variable 
*Computer theComputer*

we can use it to reference an object of either type because a type Notebook object can be referenced by a type Computer. In Java, a variable of a superclass type (general) can reference an object of a subclass type (specific). Notebook objects are Computer objects with more features. When the following statements are executed,
theComputer = new Computer("Acme", "Intel", 2, 160, 2.6);
System.out.println(theComputer.toString());

we would see for output lines, representing the state of the object referenced by theComputer.
Now suppose we have purchased a notebook computer instead. What happens when the following statements are executed,
theComputer = new Notebook("Bravo", "Intel", 4, 240, 2.4, 15.0, 7.5);
System.out.println(theComputer.toString());

Recall that theComputer is type Computer. Will the theComputer.toString() method call return a string with all seven data fields or just the five data fields defined for a Computer object? The answer is a string with all seven data fields. The reason is that the type of the object receiving the toStgring message determines which toString method is called. Even though variable theComputer is type Computer, it references a type Notebook object, and the Notebook object receives the toString message. Therefore, the method toString for class Notebook is the one called.

This is an example of polymorphism. Varible theComputer references a Computer object at one time and a Notebook object another time. At compile time, the Java compiler can't determine what type of object theComputer will reference, but at run time, the JVM knows the type of the object that receives the toString message and can call the appropriate toString method.

**Example 1.2** If we declare the array labComputers as follows:
*Computer[] labComputers = new Computer[10];*
each subscripted variable labComputers[i] can reference either a Computer object or a Notebook object because Notebook is a subclass of Computer. For the method call labComputer[i]. toString(), polymorphism ensures that the correct toString method is called. For each value or subscript i, the actual type of the object referenced by **labComputers[i]** determines which toString method will execute (Computer.toString or Notebook.toString).


Polymorphism & Method Invocation. Consider the following class hierarchy based on the text:
```java
class Computer {
    public String getDescription() { return "Generic Computer"; }
}

class Notebook extends Computer {
    public String getDescription() { return "Notebook Model"; }
}
```
Given the code snippet below:
```java
Computer myDevice = new Notebook();
System.out.println(myDevice.getDescription());
```
Which of the following statements explains the output and the mechanism used by the JVM?
A) Output: "Generic Computer". The compiler determines the method call based on the reference type (`Computer`).
B) Output: "Notebook Model". The JVM determines the method to call at runtime based on the actual object type (Dynamic Binding).
C) Output: "Notebook Model". The compiler modifies the reference type to `Notebook` during compilation.
D) Compilation Error. You cannot assign a `Notebook` object to a `Computer` reference variable.
?
**B) Output: "Notebook Model". The JVM determines the method to call at runtime based on the actual object type (Dynamic Binding).**
**Explanation:** This is the definition of **Polymorphism**. While the compiler checks if the method exists in the reference type (`Computer`), the JVM invokes the method implementation corresponding to the actual object in memory (`Notebook`) at runtime. Durante a compilação, o compilador verifica apenas o tipo de referência, se a classe *Tiver* um método **getDescription()**, o código será compilado. E durante a execução, a JVM verifica o tipo real do objecto. Esse objeto é um Notebook, então usarei o método sobrescrito dele. Isso é chamado de *Dynamic Binding* ou *Late Binding*.
<!--SR:!2025-12-21,13,247-->

Covariant Return Types (Overriding Rules). You are refactoring the `Computer` and `Notebook` classes.
```java
class Computer {
    public Computer produce() { return new Computer(); }
}

class Notebook extends Computer {
    // INSERT CODE HERE
}
```
Which of the following implementations for the **produce** method in the **Notebook** class is valid for **Method Overriding** in Java SE 21?
A) `public Object produce() { return new Notebook(); }`
B) `public Computer produce() { return new Notebook(); }`
C) `public Notebook produce() { return new Notebook(); }`
D) Both B and C are valid.
?
D) Both B and C are valid.
**Explanation:**
- **B** is valid because the return type is exactly the same.
- **C** is valid because of **Covariant Return Types**. Since Java 5, an overridden method in a subclass can return a subtype (subclass) of the return type declared in the superclass method. `Notebook` is a subclass of `Computer`.
- **A** is invalid because `Object` is a superclass, not a subclass, of `Computer`.
<!--SR:!2025-12-19,5,247-->

Constructor Chaining (`this` vs `super`). Review the following constructor logic intended for the `Notebook` class:
```java
public class Notebook extends Computer {
    private String manufacturer;
    private int ram;

    public Notebook(String man, int ram) {
        super(man, ram); // Line 1
        this.manufacturer = man;
    }

    public Notebook(int ram) {
        this("DefaultBrand", ram); // Line 2
        super("DefaultBrand", ram); // Line 3
    }
}
```
Assuming the **Computer** class has a matching constructor, what is the result of compiling this code?
A) Compilation succeeds.
B) Compilation fails at Line 2 because `this()` cannot be used with arguments.
C) Compilation fails at Line 3 because the call to `super()` (or `this()`) must be the first statement in a constructor.
D) Compilation fails at Line 1 because `super` cannot be called if `this` is used in other constructors.
?
**C) Compilation fails at Line 3 because the call to `super()` (or `this()`) must be the first statement in a constructor.**
**Explanation:** In Java, a constructor can call `super(...)` OR `this(...)`, but **not both**, because whichever one is called must be the very first executable statement. Line 2 correctly calls another constructor in the same class, but Line 3 attempts to call the super constructor afterwards, which is illegal.
<!--SR:!2025-12-25,11,247-->

### The `@Override` Annotation
**Front (Question):** In the provided text, the author recommends using `@Override` before the `toString` method in the `Notebook` class. What is the primary technical benefit of adding this annotation regarding the Java compiler?
A) It ensures the method is executed faster at runtime by the JVM.
B) It allows the method to access `private` fields of the superclass.
C) It instructs the compiler to generate an error if the method does not correctly override a method declared in a superclass (e.g., due to a typo in the name).
D) It is mandatory; the code will not compile without it if the method exists in the parent class.
?
**Back (Answer):** **C) It instructs the compiler to generate an error if the method does not correctly override a method declared in a superclass.**
**Explanation:** The annotation is not mandatory, but it serves as a compile-time check. If you misspell the method name (e.g., `tostring()` instead of `toString()`) or get the arguments wrong, the compiler will throw an error explicitly stating "method does not override or implement a method from a supertype," preventing accidental overloading or new method creation.
<!--SR:!2025-12-19,5,247-->

Card 7: Polymorphism with Arrays. Review the following array declaration mentioned in the text:
```java
Computer[] labComputers = new Computer[10];
labComputers[0] = new Computer("Acme", ...);
labComputers[1] = new Notebook("Dell", ...);
```
If `Notebook` has a method `getScreenSize()` that `Computer` does **not** have, what happens if you execute: `System.out.println(labComputers[1].getScreenSize());`
A) It prints the screen size because `labComputers[1]` is holding a `Notebook` object.
B) It prints `0.0` (default value).
C) Runtime Exception: `ClassCastException`.
D) Compilation Error: Cannot find symbol `getScreenSize` in class `Computer`.
?
**D) Compilation Error: Cannot find symbol `getScreenSize` in class `Computer`.**
**Explanation:** Even though the object at index 1 is technically a `Notebook`, the **reference type** of the array is `Computer`. The compiler only knows about methods defined in the `Computer` class. To access `getScreenSize()`, you would need to explicitly cast the reference: `((Notebook)labComputers[1]).getScreenSize()`.

### Methods with Class Parameters
Polymorphism also simplifies programming when we write methods that have class parameters. For example, if we want to compare the power of two computers without polymorphism, we will need to write overloaded *comparePower* methods in class *Computer*, one for each subclass parameter and one with a class **Computer** paramter. However, polymorphism enables us to write one method with a **Computer** parameter.
<!--SR:!2025-12-19,5,247--> 

Method Computer.comparePowers compares the power of the **Computer** object it is applied to with the **Computer** object passed as its argument. It returns -1, 0, or +1 depending on which computer has more power. It does not matter wheter this or aComputer references a Computer or a Notebook object.

```java
// Compares power of this computer and its argument computer
public int comparePower(Computer aComputer) {
	if (this.computerPower() < aComputer.computePower())
	return -1;
	else if (this.computePower() == aComputer.computePower())
	return 0;
	else return 1;
}
```

### Exercises for Section 1.3
a) Explain the effect of each of the following statements. Which one(s) would we find in class Computer? Which one(s) would we find in class Notebook?
*super*(man, proc, ram, disk, procSpeed);
*this*(man, proc, ram, disk, procSpeed);

When must *super()* or *this()* be placed inside a constructor?
A) Anywhere inside the constructor;
B)As the first statement in the constructor;
C) Only after initializing instance variables;
D) It is optional and Java inserts it automatically anywhere
?
**B) As the first statement in the constructor**

What is the main difference between this() and super() in constructors?
A) this() calls a superclass constructor, super() calls a subclass constructor
B) this() calls another construtor in the same class, super() calls a superclass constructor;
C) `this()` can only be used in static methods  
D) `super()` can only be used in private constructors
?
B) this() calls another construtor in the same class, super() calls a superclass constructor;

Given:
```java
class Computer {
	Computer(String type) {}
}

class Notebook extends Computer {
	Notebook() {}
}
```
What will happen?
A) Code compiles normally
B) Runtime error only if Notebook is instantiated
C) Compilation error: superclass constructor not called explicitly
D) Java inserts a default call to a matching constructor automatically
?
**C) Compilation error: superclass constructor not called explicitly**
<!--SR:!2025-12-16,2,247-->

b) For the loop body in the following fragment, indicate which method is invoked for each value of i. What is printed?
```java
Computer com[] = new Computer[3];
comp[0] = new Computer("Ace", "AMD", 16, 1024, 3.5);
comp[1] = new Notebook("Dell", "Intel", 8, 512, 2.2, 15.5, 4.5);
com[2] = comp[1];
for (int i = 0; i < com.length; i++) {
	System.out.println(comp[i].getRamSize() + "\n" + com[i].toString());
}
```

Consider the following classes:
```java
class Computer {
	private int ram = 8;
	public int getRamSize() {
		return ram;
	}
	public String toString() {
		return "Computer with RAM: " + ram;
	}
}

class Notebook extends Computer {
	private int ram = 16;
	public int getRamSize() {
		return ram;
	}
}
```
```java
Computer c1 = new Computer();
Computer c2 = new Notebook();
System.out.println(c1.getRamSize() + ", " + c2.toString());
```
What is the output?
A) `8, Computer with RAM: 8`  
B) `8, Computer with RAM: 16`  
C) `8, Notebook with RAM: 16`  
D) Compilation error  
E) `16, Computer with RAM: 8`
?
A) `8, Computer with RAM: 8`  

**Question 2**
```java
class Computer {
	Computer() { System.out.println("Computer-1");}
	Computer(String model) { System.out.println(model);}
}

class Notebook extends Computer {
	Notebook() {
		this("Dell");
		System.out.println("Notebook-1");
	}
	Notebook(String model) {
		super();
		System.out.println(model);
	}
}

new Notebook();
```
What is printed?
A) Dell
B) Computer-1 then Dell
C) Computer-1, Dell, Notebook-1
D) Dell, Notebook-1
E) Compilation fails due to recursive constructor call
?
C) Computer-1, Dell, Notebook-1

**Question 3**
```java
class Computer {
	public String getType() { return "Generic";}
}

class Notebook extends Computer {
	public String getType() { return "Laptop";}
}

Computer[] comps = {
	new Computer(),
	new Notebook(),
	new Notebook()
};

for (Computer c : comps) {
	System.out.print(c.getType() + " ");
}
```
What is printed?
A) `Generic Laptop Laptop`  
B) `Laptop Laptop Laptop`  
C) `Generic Generic Generic`  
D) Compilation error  
E) `Generic Laptop` and then throws ArrayIndexOutOfBoundsException
?
A) `Generic Laptop Laptop`  
Java usa *dynamic dispatch* para chamadas de método não estáticos. Isso significa que a versão do método que é executada depende do tipo real do objeto em tempo de execução, não do tipo de referência. Super só seria usado dentro de Notebook.getType() se quiséssemos invocar explicitamente o comportamento da superclass (por exemplo, return super.getType() + " Laptop"). 

c) When does Java determine which toString method to execute for each value of i in the for statement in the preceding question: at compile time or at run time? Explain our answer.
Em tempo de execução, at run time, not compile time. Because toString() is an instance (non-static) method and Java uses dynamic method dispatch, also known as runtime polymorphism. At run time, the JVM checks the actual object type and calls the overridden method accordignly.

When does Java decide which overridden instance method (e.g., `toString()`) to execute?
A) At compile time, based on the reference type
B) At run time, based on the actual object type
C) Before main() starts executing
D) It always calls the superclass method first
E) During JVM class loading
?
B) At run time, based on the actual object type.
Java uses **dynamic method dispatch,** meaning overridden instance methods are determined at run time, based on the actual object stored in memory, not the reference type.
## 1.4 Abstract Classes
Uma classe abstrata é denotada usando a palavra-chave #abstract em seu cabeçalho:
```java
visbilidade abstract class nomeDaClasse
```

Uma classe abstrata difere de uma classe real (às vezes chamada de classe concreta) em dois aspectos:
- Uma classe abstrata não pode ser instanciada;
- Uma classe abstrata pode declarar métodos abstrados.

Assim como em uma interface, um método abstrato é declarado por meio de um cabeçalho de método na definição da classe abstrata. Essa cabeçalho indica o tipo de resultado (retorno), o nome do método e os parâmetros, especificando assim a forma que qualquer declaração de método real deve assumir:

`public abstract String nomeMetodo(listaParametros);`

No entanto, a definição completa do método, incluindo o corpo do método (implementação), não aparece na definição da classe abstrata.

Para compilar sem erros, uma classe real (concreta) que seja uma subclasse de uma classe abstrata, deve fornecer uma implementação para cada método abstrato de sua superclasse abstrata. O cabeçalho de cada método real deve corresponder ao cabeçalho do método abstrato correspondente. 

Introduzimos uma classe abstrata em uma hierarquia de classes quando precisamos de uma classe base para duas ou mais classes reais que compartilham alguns atributos. Podemos querer declarar alguns dos atributos e definir alguns dos métodos que são comuns a essas classes base. Se, além disso, quisermos exigir que as subclasses reais implementem certos métodos, podemos conseguir isso tornando a classe base uma classe abstrata e declarando esses métodos como abstratos.

**Exemplo 1.4**: a pirâmide alimentar fornece uma recomendação do que comer todos os dias com base em diretrizes dietéticas estabelecidas. Existem seis categorias de alimentos na pirâmide:
- Gorduras, óleos e doces
- Carnes, aves, peixes e nozes
- Leite, iogurte e queijo
- vegetais
- frutas
- pão, cereais e massas

Se quiséssemos modelar a Pirâmide Alimentar, poderíamos ter cada uma dessas categorias como subclasses reais de uma classe abstrata chamada Food (Alimento):

```java
public abstract class Food {
	// Data Field
	private double calories;
	
	// Abstract Methods
	/** Calculates the percent of protein in a Food object. */
	public abstract double percentProtein();
	
	public abstract double percentFat();
	
	public abstract double percentCarbohydrates();
	
	public double getCalories() {return calories;}
	public void setCalories(double cal) {
		calories = cal;
	}

}
```

As três declarações de métodos abstratos `public abstract double percentProtein()`
`public abstract double percentFat();`
`public abstract double percentCarbohydrates()`

impõem a exigência de que **todas as subclasses reais implementem esses três métodos**. Esperaríamos uma definição de método diferente para cada tipo de alimento. A palavra-chave **abstract** deve aparecer em todas as declarações de métodos abstratos dentro de uma classe abstrata. 

**Armadilha**
Se escrevermos a classe *Vegetable* e esquecemos de definir o método *percentProtein*, receberemos o erro de sintaxe: *class Vegetable should be declared abstract, it does not define method percentProtin in class Food*. Embora essa mensagem de erro possa nos enganar (não pretendemos que *Vegetable* fosse abstrata), qualquer classe com métodos indefinidos é abstrata por definição. A lógica do compilador é que o método não definido é intencional, portanto, `Vegetable` deve ser uma classe abstrata, com uma subclasse que defina `percentProtein`.

**Referenciando Objetos Reais** Como a classe `Food` é abstrata, não podemos criar objetos do tipo `Food`. No entanto, podemos usar uma variável do tipo Food para referencia um objeto real que pertença a uma subclasse do tipo Food. Por exemplo, um objeto do tipo **Vegetable** pode se referenciado por uma variável **Vegetable** ou **Food**, porque **Vegetable** é uma subclasse de **Food** (ou seja, um objeto **Vegetable** também é um objeto **Food**). 

```java
abstract class Food {
    private int baseCalories;

    public Food(int cal) { 
        this.baseCalories = cal; 
        System.out.print("F(" + cal + ") ");
    }
    
    // Método abstrato obrigatório
    abstract int calculateEnergy();
    
    public int getCalories() { return baseCalories; }
}

abstract class ProcessedFood extends Food {
    public ProcessedFood(int cal) { 
        super(cal); 
    }
    // Nota: Não implementa calculateEnergy() aqui
    abstract void packaging(); 
}

class EnergyBar extends ProcessedFood {
    public EnergyBar() { 
        super(200); 
    }

    // Implementação de packaging
    void packaging() { 
        System.out.print("Pack "); 
    }
    // Omissão deliberada de calculateEnergy() para análise
}

public class DietSystem {
    public static void main(String[] args) {
        // Tentativa 1
        Food snack = new Food(100) {
            int calculateEnergy() { return getCalories() * 2; }
        };
        System.out.print("E:" + snack.calculateEnergy() + " ");

        // Tentativa 2
        try {
            ProcessedFood bar = new EnergyBar();
            bar.packaging();
        } catch (Error e) {
            System.out.print("Error");
        }
    }
}
```
Qual das opções abaixo descreve corretamente o comportamento deste código ao tentar ser compilado e executado?
A) **Erro de Compilação na classe `DietSystem` (Tentativa 1):** Não é possível instanciar `new Food(100)` porque `Food` é uma classe abstrata e não pode ser instanciada diretamente, mesmo com corpo de método fornecido.
B) **Erro de Compilação na classe `EnergyBar`:** A classe `EnergyBar` não é abstrata e não sobrescreve o método abstrato `calculateEnergy()` herdado indiretamente de `Food`. O compilador exigirá que `EnergyBar` seja declarada abstrata ou implemente o método.
C) **Sucesso na Execução:** O código imprime `F(100) E:200 F(200) Pack`. A classe `EnergyBar` herda a natureza abstrata de `ProcessedFood` implicitamente, permitindo que o programa rode, mas lançará uma exceção em tempo de execução se `calculateEnergy` for chamado na instância `bar`.
D) **Erro de Compilação na classe `ProcessedFood`:** Uma classe abstrata que estende outra classe abstrata (`Food`) é obrigada a implementar todos os métodos abstratos da superclasse (`calculateEnergy`) ou redeclará-los explicitamente.
?
**Resposta Correta: B**
**Explicação Detalhada:**
1. **Análise da Tentativa 1 (Classe Anônima):** A construção `new Food(100) { ... }` na classe `Main` é **válida**. Embora o texto diga "Uma classe abstrata não pode ser instanciada", em Java, essa sintaxe cria uma **classe interna anônima** (uma subclasse sem nome) que estende `Food` e fornece a implementação do método abstrato `calculateEnergy`. Portanto, a opção A está incorreta.
2. **Análise da classe `ProcessedFood`:** Uma classe abstrata (`ProcessedFood`) que estende outra classe abstrata (`Food`) **não** é obrigada a implementar os métodos abstratos da mãe. Ela apenas repassa a "dívida" de implementação para a primeira subclasse concreta. Portanto, a opção D está incorreta.
3. **Análise da classe `EnergyBar` (O foco do problema):** `EnergyBar` é declarada como uma classe concreta (`class EnergyBar` sem `abstract`). Ela estende `ProcessedFood`.
    - `ProcessedFood` herda `abstract int calculateEnergy()` de `Food`.
    - `ProcessedFood` declara seu próprio `abstract void packaging()`.
    - Para `EnergyBar` compilar, ela **deve** implementar **ambos** os métodos: `packaging()` E `calculateEnergy()`.
    - No código, `EnergyBar` implementa `packaging()`, mas omite `calculateEnergy()`.

### Referencing Actual Objects

### Initializing Data Fields in an Abstract Class
Uma classe abstrata não pode ser instanciada. No entanto, uma classe abstrata pode ter construtores que inicializam seus campos de dados quando um novo objeto de subclasse é criado. O construtor da subclasse usará `super(...)` para chamar tal construtor.
### Abstract Class Number and the Java Wrapper Classes
A classe abstrata #Number é predefinida na hierarquia de classes do Java. Ela tem como subclasses todas as #wrappers classes (classes de empacotamento) para tipos numéricos primitivos (por exemplo, #Byte, #Double, #Integer, #Long e #Short). Uma classe #wrapper é usada para armazenar um valor de tipo primitivo dentro de um tipo de objeto. 

Uma classe wrapper contém um método de fábrica (factory method) estático chamado *valueOf*, que é usado para criar um objeto daquela classe. Os métodos #valueOf recebem um valor primitivo ou uma String numérica e retornam um objeto que armazena o valor correspondente do tipo primitivo. Por exemplo, Integer.valueOf(35) ou Integer.valueOf("35") retornando um objeto do tipo Integer que armazena o int 35. Uma classe wrapper também possuí métodos para converter o valor armazenado em um objeto para um tipo numérico diferente. 

A figura 1.6 mostra uma parte da hierarquia de classes com a classe base **Number**. O uso de itálico no nome da classe #Number em sua caixa indica que #Number é uma classe abstrata e, portanto, não pode ser instanciada. 

A Listagem 1.5 mostra parte da definição da classe #Number. Dois métodos abstratos são declarados (intValue e doubleValue), e um método real #byteValue é definido.
```java
public abstract class Number {
	// Abstract methods
	// returns the value of the specified number as an int.
	public abstract int intValue();
	
	public abstract double doubleValue();
	
	public byte byteValue() {}
}
```

```java
// Arquivo: CustomMath.java

abstract class AbstractMesoNumber extends Number {
    private final double value;

    // Construtor da classe abstrata
    public AbstractMesoNumber(double v) {
        this.value = v;
        System.out.print("M(" + (int)v + ") ");
    }

    // Apenas para fins deste exercício, assuma que 'Number' exige apenas 
    // a implementação de intValue e doubleValue (como simplificado no texto).
    public double doubleValue() { return value; }
    
    // Método abstrato adicional
    public abstract String getType();
}

class MesoInteger extends AbstractMesoNumber {
    public MesoInteger(int v) {
        // LINHA A
        super(v);
    }

    public int intValue() { return (int) doubleValue(); }
    public String getType() { return "Int"; }
}

class MesoFactory {
    // Método Factory similar ao valueOf
    public static AbstractMesoNumber valueOf(String s) {
        int parsed = Integer.parseInt(s);
        // LINHA B
        return new MesoInteger(parsed) {
             // Classe anônima sobrescrevendo comportamento
             public String getType() { return "Anon"; }
        };
    }
}

public class CustomMath {
    public static void main(String[] args) {
        AbstractMesoNumber num1 = new MesoInteger(10);
        System.out.print("| ");
        
        AbstractMesoNumber num2 = MesoFactory.valueOf("20");
        
        System.out.print("| " + num1.getType() + "-" + num2.getType());
    }
}
```
Analise as afirmações abaixo e determine qual descreve corretamente o comportamento do código, considerando as regras de construtores e classes abstratas.
A) **Erro de Compilação na LINHA A:** O construtor de `MesoInteger` não pode chamar `super(v)` porque `AbstractMesoNumber` é abstrata e não pode ser instanciada, logo seu construtor não pode ser invocado.
B) **Sucesso na Execução:** O código imprime: `M(10) | M(20) | Int-Anon`. A classe anônima criada dentro do método `valueOf` herda corretamente de `MesoInteger`, executa o encadeamento de construtores até a classe abstrata e sobrescreve o método `getType`.
C) **Erro de Compilação na LINHA B:** Não é possível estender `MesoInteger` com uma classe anônima dentro do método estático porque `MesoInteger` não é uma interface nem uma classe abstrata.
D) **Erro de Tempo de Execução (Runtime Error):** Ocorre um erro ao tentar instanciar a classe anônima em `valueOf`, pois classes anônimas não podem acessar o construtor da superclasse (`MesoInteger`) se este receber parâmetros.
?
**Resposta Correta: B**
1. **Construtores em Classes Abstratas:** o texto afirma explicitamente:  "<span style="background:#b1ffff">Uma classe abstrata pode ter construtores que inicializam seus campos... </span>O construtor da subclasse usará super(....) para chamar tal construtor."
	- Portanto, a Opção A está incorreta. Embora a classe abstrata não possa ser instanciada com `new AbstractMesoNumber()`, seu construtor **deve** ser chamado pelas subclasses via **super()** para inicializar o estado value.
2. Na linha B, o código cria uma classe anônima: `new MesoInteger(parsed) {...}`. É perfeitamente legal em Java criar uma classe anônima a partir de uma classe concreta (MesoInteger), desde que exista um construtor visível.

### Summary of Features of Actual Classes, Abstract Classes, and Interfaces
It is easy to confuse abstract classes, *interfaces*, and *actual classes (concrete classes).* Table 1.1 summarizes some important points about these constructs.
!![image-20251214517696.png](/image-20251214517696.png)

- *This can define constants:* Actual class, abstract class, interface. Em Java, constantes são variáveis declaradas com *final*, cujo valor não pode ser alterado após a inicialização; quando declaradas com *static final*, pertencem à classe e representam valores fixos compartilhados.
- *The can extend another class:* actual class, abstract class and interface.
- *This can declare abstract methods:* abstract class and interface.

A class (abstract or actual) can extends only one other class; however, there is no restriction on the number of interfaces a class can implement. An interface cannot extend a class.

Uma classe abstrata pode <span style="background:#d3f8b6">implementar uma interface</span> da mesma forma que uma classe concreta faz, mas, diferentemente de uma classe concreta, <span style="background:#fdbfff">ela não é obrigada a definir todos os métodos declarados na interface</span>. Ela pode deixar a implementação de alguns desses métodos abstratos para suas subclasses. 

Tanto classes abstratas quanto interfaces <span style="background:#d3f8b6">declaram métodos abstratos</span>. No entanto, ao contrário de uma interface, uma classe abstrata também pode ter campos de dados e métodos que não são abstratos. 

Podemos pensar em uma classe abstrata como uma combinação das propriedades de uma classe concreta, por fornecer campos de dados e métodos herdados para suas subclasses, e de uma interface, por especificar requisitos para suas subclasses por meio da declaração de métodos abstratos.

### Implementing Multiple Interfaces
Uma classe pode estender apenas uma outra classe, mas pode implementar mais de uma interface. Por exemplo, suponha que a interface EmployeeInt especifique os métodos exigidos para classes do tipo funcionário. O seguinte cabeçalho para a classe **StudentWorker:**
```java
public class StudentWorker implements StudentInt, EmployeeInt
```

A classe StudentWorker oferece suporte às operações exigidas pelas duas interfaces.
### Extending an Interface
Interfaces também podem estender (extend) outras interfaces. No capítulo 2, será apresentado o Java Collection Framework. Essa hierarquia de classe contém várias **interfaces** e **classes** que gerenciam coleções de objetos.

No topo dessa hierarquia está a interface #Iterable, que declara o método #iterator. No nível imediatamente abaixo está a interface #Collection, que estende #Iterable.

Isso significa que **todas as classes que implementam Collection também devem implementar Iterable** e, portanto, devem definir o método iterator.

Uma interface pode estender mais de uma outra interface. Nesse caso, a interface resultante inclui a **união dos métodos definidos nas superinterfaces**.

---
**Interface pode estender outra interface**
Quando realizamos:
```java
public interface FiscalDocumentRepository extends JpaRepository<FiscalDocument, Long> {}
```
A nossa interface está estendendo a interface #JpaRepository.

Não somos obrigados a implementar nada. E isso é por design no Spring Data JPA. 

Quem realiza a implementação desses métodos é o próprio Spring, em tempo de execução, usando:
- **Proxy dinâmico**
- **Reflection**
- **Geração automática de implementação**

Quando a aplicação sobe, o Spring cria uma **classe concreta invisível para nós**. 
✔️ Ao estender `JpaRepository`, sua interface herda todos os métodos dela.  
❌ Você **não precisa implementar nenhum método**.  
✔️ O Spring Data JPA gera automaticamente a implementação em tempo de execução.

---

Por exemplo, podemos definir a interface ComparableCollection, que estende tanto Comparable quanto Collection, da seguinte forma:
```java
public interface ComparableCollecton extends Comparable, Collection {
}
```

Observamos que essa interface não define nenhum método próprio, mas exige que qualquer classe que a implemente implemente todos os métodos exigidos por Comparable e por Collection.
### Exercises for Section 1.4
## 1.5 Class Object and Casting
 A classe #Object é uma classe especial em Java porque é a raiz da hierarquia de classes, e toda classe possui #object como superclasse. Todas as classes herdam os métodos definidos na classe #Object; no entanto, esses métodos podem ser sobrescritos na classe atual ou em uma superclasse (se houver). A tabela 1.2 mostra alguns dos métodos da classe #Object. 

**Método toString:** devemos sempre sobrescrever o método #toString se quisermos representar o estado de um objeto (informações armazenadas). Se não sobrescrevê-lo, o método *toString* da classe object será executado e retornará uma string, mas não o que estamos esperando.

**TABELA 1.2 A Classe Object**

| **Método**                   | **Comportamento**                                             |
| ---------------------------- | ------------------------------------------------------------- |
| `boolean equals(Object obj)` | Compara este objeto com seu argumento.                        |
| `int hashCode()`             | Retorna um valor de código hash inteiro para este objeto.     |
| `String toString()`          | Retorna uma string que representa textualmente o objeto.      |
| `Class<?> getClass()`        | Retorna um objeto único que identifica a classe deste objeto. |
 **Exemplo 1.6**: Se não tivéssemos um método #toString na classe *Computer* ou *Notebook*, a chamado do método aComputer.toString() chamaria o método #toString herdado da classe #Object. Este método retornaria uma string como #Computer#Ef08879, que mostra o nome da classe do objecto e um valor inteiro especial que é seu "hash code", não seu estado. O método #hashCode será discutido mais a fundo no capítulo 7.

## Operations Determined by Type of Reference Variable
Uma variável pode referenciar um objeto cujo tipo é uma subclasse do tipo da variável. Como #object é uma *superclasse* da classe #Integer, a instrução: *Object aThing = Integer.valueOf(25);* compilará sem erro, criando a seguinte referência de objeto:
!![image-20251218656916.png](/image-20251218656916.png)

Embora *aThing* referencia um objeto do tipo *Integer*, não podemos processar esse objeto como outros objetos #Integer. Por exemplo, a chamada de método *aThing.intValue()* causaria o erro de sintaxe:
*The method intValue() is undefined for the type Object*

Em Java, o **compilador olha apenas par ao tipo da variável**, não para o objeto real em tempo de execução. 

Como dito, o **o tipo de referência**, e não o tipo do objeto referenciado, determina quais operações podem ser realizadas, e a classe *Object* não possui um método *intValue*. Durante a compilação, o Java não consegue determinar que tipo de objeto será referenciado por uma variável do tipo Object, então as únicas operações permitidas são aquelas definidas para a classe #Object. Os métodos de instância do tipo #Integer não definidos na classe Object, não podem ser invocados.

A chamada de método *aThing.equals(Integer.valueOf("25"))* compilará porque a classe #Object possui um método *equals*, e um objeto de subclasse tem tudo o que está definido em sua superclasse. Durante a execução, o método *equals* para a classe Integer é invocado, não o da classe #Object. #Polimorfismo.

Outro resultado surpreendente é que a instrução de atribuição: *Integer aNum = aThing;* são tipos incompatíveis. Mesmo que *aThing* referencie um objeto do tipo Integer, o erro de sintaxe "incompatible types: found: Java.lang.Object, requried: Java.lang.Integer" indica que o tipo da expressão está incorreta./ (Object, não tipo Integer). 
Java é uma linguagem **fortemente tipada**, então o compilador Java sempre verifica se o tipo da expressão *aThing* é do tipo #Object, sendo atribuída e se é compatível com o tipo da variável aNum é do tipo Integer. 

**Conceito de design: a importância da Tipagem Forte**
Se o Java não verificasse o tipo da expressão e simplesmente realizasse a atribuição: *Integer aNum = aAthing*. Mais adiante, poderíamos tentar aplicar um método de Integer ao objeto referenciado por aNum. Como aNum é to tipo *Integer*, o compilador permitiria isso. Se #aNum estivesse referenciando um objeto do tipo Integer, realizar essa operação não causaria danos. Mas se aNum estivesse referenciado um objeto que não fosse to tipo Integer, realizar essa operação causaria um erro em tempo de execução ou um erro de lógica não detectado. É muito melhor ter o compilador nos dizendo que a atribuição é inválida. 

- **O "Map" Invisible:** ao utilizarmos HashMap ou HashSet, a estrutura de dados usa internamente hashCode() e equals() para armazenar e recuperar chaves. Se criarmos uma classe customizada (ex: Point(x, y)) e não sobrescrevermos esses métodos de #Object, o map usará o endereço de memória. Resultado: o mapa nunca encontrará a nossa chave, mesmo que os valores de x e y sejam idênticos.

**Java e Tipagem**
- **Segurança vs. Flexibilidade:** Em Java, o compilador joga na defesa. Podemos colocar qualquer coisa dentro do *List< Object>*, mas para tirar e usar (chamar um método específico), somos obrigados a fazer o #downcasting explícito. 

- **Comparação com == :** muitas vezes esquecemos que a implementação padrão de #equals na classe #Object é comparar endereços de memória. Para comparar conteúdo (valor), a sobrescrita é obrigatória. 

**Using instanceof to Guard a Casting Operation**
Na armadilha anterior, mencionamos que uma ClassCastException ocrre se tentarmos uma operação de casting inválida. O Java fornece o operador #instanceof, que podemos usar para nos proteger contra esse tipo de erro.

**Exemplo 1.7** O array #stuff a seguir pode armazenar 10 objetos de qualquer tipo de dado, pois todo tipo de objeto é uma subclasse de #Object.
```java
Object[] stuff = new Object[10];
```
[[example1_8.java]]

Assumimos que o array #stuff foi carregado com dados e queremos encontrar a soma de todos os números que estão "embrulhados" (wrapped) em objetos. 

A condição *if (stuff[i] instanceof Number)* é verdadeira se o objeto referenciado por *stuff[i]* for uma subclasse de *Number*. Ela seria falsa se *stuff[i]* referenciasse uma String ou outro objeto não numérico. A instrução: *Number next = (Number) stuff[i];* faz o cast (converte) o objeto referenciado por stuff[i] (tipo Object) para o tipo Number e, em seguida, o referencia através da variável next (Tipo Number). A variável next contém uma referência para o mesmo objeto que *stuff[i]*, mas o tipo de referência é diferente (tipo Number em vez de tipo Object). Então, a instrução
*sum += next.doubleValue()*, invoca o método **doubleValue** apropriado para extrair o valor numérico e adicioná-lo à soma. Em vez de declarar next, podemos escrever a instrução if como 
*if (stuff[i] isntanfeceof Number) sum += ((Number) stuff[i].doubleValue();*

**Estilo de Programação: polimorfismo Elimina Declarações if Aninhadas**: Se o Java não suportasse polimorfismo, a declaração *if* no exemplo 1.7 seria muito mais complicada. Precisaríamos escrever algo como o seguinte:
```java
if (stuff[i] isntanceof Integer)
	sum += ((Integer) stuff[i]).doubleValue();
else if (stuff[i] instanceof Double)
	sum += ((Double) stuff[i].doubleValue();
else if (stuff[i] instaceof Float)
	sum += ((Float) stuff[i]).doubleValue();
```

Cada condição aqui usa o operador *instanceof* para determinar o tipo de dado do objeto real referenciado por *stuff[i]*. Uma vez que o tipo é conhecido, fazemos o cast para esse tipo e chamamos seu método *doubleValue*. Obviamente, esse código é muito trabalhoso e mais propenso a falhas do que a instrução *if* original. Mas importante, se uma nova classe wrapper for definida para números, precisaríamos modificar a instrução *if* para processar objetos desse novo tipo de classe. Portanto, desconfie de instruções de seleção como a mostrada aqui; a presença delas frequentemente indica que não estamos aproveitando polimorfismo.

*Insights Valiosos*
- **Pattern Matching for instanceof:**  o texto mostra o jeito "antigo" de fazer as coisas. Desde o Java 16, não precisamos fazer o cast manual dentro do *if*.
	- Antigo: *if (obj instanceof String) { String s = (String) obj; ... }*
	- Novo: *if (obj instanceof String s) {...}* (o Java já cria a variável s tipada automaticamente). 

- **Coleções Heterogêneas:** Em Java, *ArrayList< Object>* é possível, mas raramente usado em algoritmos eficientes porque o custo do casting ((Type) obj) e da verificação (instance of) degrada a performance se feito milhões de vezes. Estruturas de dados eficientes geralmente são homogêneas (todos os itens do mesmo tipo).

- **Hierarquia de Interfaces:** o exemplo usa *Number*. Em problemas de LeetCode, muitas vezes lidamos com interfaces gráficas. Saber que Integer, Double e Long herdam de Number permite escrevermos algoritmos que somam valores sem se importar com o tipo específico, economizando linhas de código.

**Exemplo 1.8**: suponhamos que temos uma classe *Employee* (funcionário) com os seguintes campos de dados:
```java
public class Employee {
	// Campos de Dados
	private String name;
	private double hours;
	private double rate;
	private Address address;
}
```
Para determinar se dois objetos **Employee** são iguais, poderíamos comparar todos os quatro campos de dados. No entanto, faz mais sentido determinar se dois objetos são o mesmo funcionário comparando seus campos de nome e endereço. Abaixo, mostramos um método *equals* que sobrescreve o método *equals* definido na classe **Object**.

Ao sobrescrever este método, garantimos que o método *equals* da classe #Employee será sempre chamado quando o método **equals** for aplicado a um objeto Employee. Se tivéssemos declarado o tipo do parâmetro para `Employee.equals` como do tipo `Employee` em vez de `Object`, então o método `Object.equals` seria chamado se o argumento fosse qualquer tipo de dado exceto `Employee` (isso seria sobrecarga, não sobrescrita).

[[example1_8.java]]
Se o objeto referenciado por obj não for do tipo Employee, retornamos false. Se for do tipo **Employee**, fazemos o *downcast* desse objeto para o tipo *Employee*. Após o *downcast*, a instrução de retorna chama o método *String.equals* para comparar o campo de nome do objeto atual com o campo de nome do objeto **other**, e o método Addres.equals para comparar os dois campos de dados de endereço. Portanto, o método **equals** também deve estar definido na 
**Address**. O resultado do método é **true** se ambos os campos, nome e endereço, correspondem, e é **false** se um ou ambos os campos não corresponderem. O resultado do método também é **false** se o *downcast* não puder ser realizado porque o argumento é um tipo incorreto ou nulo.

**Algoritmos e Performance**
- **Curto-circuito de Performance:** Note na primeira linha: *if (obj == this) return true;* Em algoritmos complexos, comparar referências é $O(1)$, enquanto comparar campos (como Strings longas ou objetos aninhados) pode ser custoso. Sempre comece verificando a identidade da memória.
- **Strictness (Rigor):** o código usar **getClass()** em vez de *intanceof*. #getClass exige que seja exatamente a mesma classe.
- Para o LeetCode, geralmente **getClass()** é mais seguro para evitar comportamentos estranhos de herança, a menos que o problema especifique o contrário. 

**A classe Class**
Toda classe possui um objeto do tipo **Class** que é criado automaticamente quando a classe é carregada em uma aplicação. A classe **Class** fornece métodos que, em sua maioria, estão além do escopo deste texto.

O ponto importante é que **cada objeto** Class **é único para a sua classe**, e o método **getClass** (um membro da classe **Object**) retorna uma referência para esse objeto único.

Assim, se a expressão:
```java
this.getClass() == obj.getClass()
```
no Exemplo 1.8 for verdadeira, então sabemos que **obj** e **this** são ambos da classe **Employee**.

## 1.6 A Java Inheritance Example - The Exception Class Hierarchy
A seguir, mostraremos como o Java utiliza herança para construir uma hierarquia de classes que é fundamental para detectar e corrigir erros durante a execução do programa (erros de tempo de execução). Um erro de **tempo de execução** ocorre quando a JVM detecta uma operação que sabe ser incorreta.

Esse erro fará com que a JVM lance uma exceção, isto é, crie um objeto de um tipo de exceção que identifica o tipo de operação incorreta e interrompa o processamento normal. A tabela 1.3 mostrar alguns exemplos de exceções que são erros de tempo de execução. Todas são subclasses da classe *RuntimeException*.
!![image-202512224829401.png](/image-202512224829401.png)

### Divisão por Zero
Se *count* represente um número de itens sendo processados e é possível que *count* seja zero, a instrução de atribuição *avarege = sum /count;* pode causar um erro de divisão por zero. Se sum e count forem variáveis int, esse erro é indicado pela JVM lançando uma #ArithmeticException. Podemos facilmente nos prevenir contra tal divisão com uma instrução *if*, para que a operação não seja realizada quando *count* for zero. Normalmente, ao calcular uma média como double, o erro não é lançado; em vez disso, o resultado seria Infinity ou NaN.
```java
if (count == 0)
	average = 0;
else
	average = sum / count;
```

### Array Index Out of Bounds
Uma `ArrayIndexOutOfBoundsException` é lançada pela JVM quando um valor de índice (subscrito) usado para acessar um elemento em um array é menor que zero ou maior ou igual ao comprimento do array. Por exemplo, suponha que definimos o array `scores` da seguinte forma:
`int[] scores = new int[500];`
A variável indexada scores[i] usa i (tipo int) como o índice do array. A exceção será lançada se i for menor do que zero ou maior que 499.

Erros de índice fora dos limites podem ser evitados verificando cuidadosamente os valores de limite para um índice que também é uma variável de controle de loop. Um erro comum é usar o tamanho do array como o limite superior, em vez do tamanho do array menos 1.

**Exemplo 1.9:** o loop a seguir causaria um *ArrayIndexOutOfBoundsException* na última iteração, quando *i* é igual a *x.lenght*.
```java
for (int i = 0; i <= x.lenght; i++)
	x[i] = i * i;
```

O teste de repetição do loop deveria ser i < x.lenght.

```run-java
public class example1_9 {
    public static void main(String[] args) {
        int[] scores = new int[500];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i + i;
        }
    }
}
```

**NumberFormatException** e **InputMistmatchException**
A #NumberFormatException é lançada quando um programa tenta converter uma string não numérica (geralmente um valor de entrada) para um valor numérico. Por exemplo, se o usuário digitar a string "2.6e", o método **parseDouble** no código a seguir:
```java
String speedStr = JOptionPane.showInputDialog("Enter speed");
double speed = Double.parseDouble(speedStr);
```
lançaria uma `NumberFormatException` porque `"2.6e"` não é uma string numérica válida (não tem um expoente após o `e`). Não há uma forma geral de evitar essa exceção, pois é impossível se proteger contra todos os possíveis erros de entrada de dados que o usuário pode cometer.

Um erro similar pode ocorrer se estivermos usando um objeto *Scanner* para entrada de dados. Se *scan* é um *Scanner*, a declaração:
```java
double speed = scan.nextDouble();
```
Lançara uma InputMismatchException se o próximo token escaneado for "2.6e".

## Null Pointer
A *NullPointerException* é lançada quando há uma tentativa de acessar um objeto que não existe; isto é, a variável de referência sendo acessada contém um valor especial, conhecido como *null*. Podemos nos prevenir contra isso testando se o valor é *null* antes de invocar um método.

### The Exception Class Hierarchy
As exceções na Tabela 1.3 são todas subclasses de *RuntimeException*. Todas as classes Exception são definidas dentro de uma hierarquia de classes que tem a classe #Throwable como sua superclasse (veja o diagrama UML na Figura 1.8). O diagrama UML mostra que as classes Error e Exception são subclasses de *Throwable*. Cada uma dessas classes possui subclasses mostradas na figura. Focaremos na classe #Exception e suas subclasses neste capítulo. Como RuntimeException é uma subclasse de #Exception, ela também é uma subclasse de #Throwable (a relação de subclasse é transitiva).

### A Classe Throwable

## 1.7 Packages and Visibility
## 1.8 A Shape Class Hierarchy
<!--SR:!2025-12-16,2,247-->
