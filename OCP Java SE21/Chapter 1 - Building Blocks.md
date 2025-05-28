**OCP EXAM OBJECTIVES COVERED IN THIS CHAPTER:**
- Handling Date, Time, Text, Numeric and Bolean Values
Use primitives and wrapper classes. Evaluate arithmetic and boolean expressions, using the Math API and by applying precedente rules, type conversions, and casting.

**Using Object-Oriented Concepts in Java**
Declare and instantiate Java objects including nested class objects, and explain the object life-cycle including creation, reassigning references, and garbare collection.
Understand variable scopes, apply encapsulation, and create immutable objects. Use local variable type inference.

In this chapter, we present the basics of Java packages, classes, variables, and data types, along with the aspects of each that you need to know for the exam. For example, you might (pode) use java every day but be unaware that you cannot create a variable called 3map or this. Portanto, os nomes de variáveis devem sempre começar com letras ou underscore _ , além de não ser permitido o uso de palavras reservadas. 

The exam expects you to know and understand the rules behind theses principles. While most of this chapter should be review, there may be aspects of the Java language that are new to you since they don't come up in practical use often. 

## Learning About the Environment
The environment consist of a number of technologies. In the following sections, we go over the key terms and acronyms you need to know and then discuss what <span style="background:#d4b106">software you need to study for the exam</span>.

## Major Components of Java
The *Java Development Kit (JDK)* contains the minimum software you need to do Java development. Key commands include the following:
- #javac: Converts *.java* source files into *.class* bytecode
- #java: Executes the program
- #jar: packages files together
- #Javadoc: generates documentation

The *javac* program generates instructions in a special format called *bytecode* that the **java** command can run. Then **java** launches the *Java Virtual Machine (JVM)* before running the code. The JVM knows how to run bytecode on the actual machine it is on. <span style="background:#b1ffff">You can think of the JVM as a special magic box on your machine that knows to run you</span> *.class* file within your particular operating system and hardware.

---
## Where Did the JRE Go?
In Java 8 and earlier, you could download a Java Runtime Environment (JRE) instead of the full JDK. The JRE was a subset of the JDK  that was used for running a program but could not compile one. Now, people can use the full JDK when running a Java program. Alternatively, developers can supply as executable that contains the required pieces that would have bean in the JRE.

Portanto, o JRE continha apenas os componentes necessários para rodar aplicações Java, mas não permitia compilá-las.

Agora, o JRE não é mais distribuído separadamente. Em vez disso, qualquer pessoa pode usar o JDK completo para rodar programas Java. Além disso, os desenvolvedores têm a opção de fornecer executáveis que incluam apenas os elementos essenciais que antes estavam no JRE, garantindo que os programas funcionem sem exigir a instalação do JDK inteiro.

Isso reflete uma tendência de modularização no Java, tornando sua distribuição mais flexível e adaptável às necessidades dos desenvolvedores e usuários.

---

You might have noticed that we said the JDK contains the minimum software you need. Many developers use an IDE to make writing and running code easier. <span style="background:#d4b106">While we do not recommend using one while studying for the exam</span>, it is still good to know that they exist. 

## Downloading a JDK
Every six months, Oracle releases a new version of Java. Java 21 came out in September 2023. This means Java 21 will not be the latest version when you download the JDK to study for the exam. However, you should still user Java 21 to study with since this is a Java 21 exam. The rules and behavior can change with later versions of Java. You wouldn't want to get a question wrong because you studied with a different version of Java!

**Check your Version of Java**
Before we go any further, please take this opportunity to ensure you have the right version of Java on your path.

## Understanding the Class Structure
In Java programs, classes are the basic building blocks. When defining a *class*, you describe all the parts and characteristics of one of those building blocks. In later chapters, <span style="background:#affad1">you see other building blocks</span> such as #interfaces, #records, and #enums. 

To use most classes, <span style="background:#b1ffff">you have to create objects</span>. An #object is a runtime instance of a class in memory. An object if often referred to as an #instance since it represents a single representation of the class (um objeto é referenciado como uma instância desde que ele seja uma simples representação de uma classe). All the various objects of all the different classes represents the state of your program. A *reference* is a variable that points to an object (uma referência é uma variável que aponta para um objeto). 

In the following sections, we look at fields, methods, and comments. We also explore the relationship between classes and files.

## Fields and Methods
Java classes have <span style="background:#b1ffff">two primary elements</span>: *methods*, often called functions or procedures in other languages, and *fields*, more generally know as variables. Together these are called the *members* of the class or atributes. Variables hold the state of the program, and methods operate on that state. If the change is important to remember, a variable stores that change. That's all classes really do. It's the programmer's job to create and arrange these elements in such a way that the resulting code is useful and, ideally, easy for other programmers to understand. 

The simplest Java class you can write looks like this:
```java
public class Animal {
}
```
Java call a word with special meaning a *keyword*, which we've marked bold in the previous snippet. Throughout the book, we often bold parts of code snippets to call attention to them. Line 1 includes the **public** keyword, which allows other classes to use it. The **class** keyword indicates you're defining a class. **Aninal** gives the name of the class. Granted, this isn't an interesting class, so let's add your first field.
```java
public class Animal {
	String name;
}
```

**Note**: The line numbers aren't part of the program; they're just there to make the code easier to talk about.

On line 2, we define a variable named *name*. We also declare the type of that variable to be *String*. A *String* is a value that we can put text into, such as "this is a string". *String* is also a class supplied with Java. Next we can add methods.
```java
public class Animal {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
}
```

On lines 3-5, we define a method. 