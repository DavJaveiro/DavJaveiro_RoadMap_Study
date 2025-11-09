**OCP EXAM OBJECTIVES COVERED IN THIS CHAPTER:**
- Handling Date, Time, Text, Numeric and Bolean Values
Use primitives and wrapper classes. Evaluate arithmetic and boolean expressions, using the Math API and by applying precedente rules, type conversions, and casting.

**Using Object-Oriented Concepts in Java**
Declare and instantiate Java objects including nested class objects, and explain the object life-cycle including creation, reassigning references, and garbare collection.
Understand variable scopes, apply encapsulation, and create immutable objects. Use local variable type inference.

In this chapter, we present the basics of Java packages, classes, variables, and data types, along with the aspects of each that you need to know for the exam. For example, you might (pode) use java every day but be unaware that you cannot create a variable called 3map or this. Portanto, os nomes de variáveis devem sempre começar com letras ou underscore _ , além de não ser permitido o uso de palavras reservadas. 

The exam expects you to know and understand the rules behind theses principles. While most of this chapter should be review, there may be aspects of the Java language that are new to you since they don't come up in practical use often. 

## Learning About the Environment
The Java environment consists of a number of technologies. In the following sections, we go over the key terms and acronyms you need know and then discuss what software you need to study for the exam.

## Major Components of Java
The *Java Development Kit (JDK)* contains the minimum software we need to do Java development. Key commands include the following:
- #javac: converts .java source files into .class bytecode
- #java: Executes the program
- #jar: packages files together
- #javadoc: generates documentation

The *.javac* program generates instructions in a special format called *bytecode* that the *java* command can run. Then *java* launches the *Java Virtual Machine (JVM)* before running the code. The #JVM knows how to run bytecode on the actual machine it is on. You can think of the JVM as a special magic box on your machine that knows how to run your .class file whtin your particular operating system and hardware.

You might have noticed that we said the JDK contains the minimum software you need. Many developers use an *integrated development environment* (IDE) to make writing and running code easier. While we do not recommend using one while studying for the exam, it is still good to know that they exist. Common Java IDEs...

## Understanding the Class Structure
In Java programs, class are the basic building blocks. When defining a *class*, we describe all the parts and characteristics of on of those building blocks. In later chapters, you see other <span style="background:#affad1">building blocks</span> such as interfaces, records, and enums.

Building Blocks: #class, #interfaces, #records and #enums.

To use most classes, you have to create objects. An #object is a **runtime instance of a class in memory.** 

All the various objects of all the different classes represent the state of your program. A *reference is* a variable that points to an object.

In the following sections, we look at fields, methods, and comments. We also explore the relationship between classes and files.
(Nós iremos explorar a relação entre classes e arquivos).

## Fields and Methods
Java classes have two primary elements: #methods, often called functions or #procedures in other languages, and #fields more generally known as variables. Together these are called the *members* of the class. Variables hold the state of the program, and methods operate on that state. If the change is important to remember, a variable stores that change. That's all classes really do. It's the programmer's job to create and arrange these elements in such a way that the resulting code is useful and, ideally, easy for other programmers to understand. 

The simplest Java class you can write looks like this:
```java
public class Animal {
}
```

Java calls a word with special meaning a #keyword, which we've marked bold in the previous snippet. Throughout the book, we ofeten bold partes of code snippets to call attention to them. Line 1 includes the #public keyword, which allows other classes to use it. The *class* keyword indicates you're defining a class.  *Animal* gives the name of the class. Granted, this isn't an interesting class, so let's add your first field.
```java
public class Animal {
	String name;
}
```
On line 2, we define a variable named *name*. We also declare the type  of that variable to be #String. A #String is a value that we can put text into, such as "this is a string". #String is also a class supplied with Java. 
Supplied = fornecido.

Next we can add methods
```java
public class Animal {
	String name,
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
}
```
On lines 3-5, we define a method. A method is an operation that can be called (Um método é uma operação que pode ser chamada/invocada). Again, *public* <span style="background:#b1ffff">is used to signify that this method may be called from other classes</span>. Next comes the return type in this case, the method returns a String. On lines 6-8 is another method. This one has a special return type called *void*. The #void keyword means that no value at all is returned. This method requires that information be supplied to it from the calling method; this information is called a *parameter*. The *setName()* method has one #parameter named newName, and it is of type String. This means the caller should pass in one String parameter and expect nothing to be returned. 

The method name and parameter types are called the *method signature*. In this example, can you identify the method name and parameters?
```java
public int numberVisitors(int month) {
	return 10;
}
```
**numberVisitors** is the method name
**month**  is the parameter;

There's one parameter named month, which is of type int, which is a numeric type.  Therefore, the method signature is *numberVisitors*(int);
Therefore = portanto

## Comments
Another common part of the code is called a *comment*. Because comments aren't executable code, you can place them in many places. Comments can make your code easier to read. While the exam creators are trying to make the code harder to read, they still use comments to call attention to line numbers. We hope you use comment in your own code. There are three types of comments in Java. The first is a single-line comment.
```java
// comment until end of line
```
A single-line comment begins with two slashes. The compiler ignores anything you type after that on the same line. Next comes the multiple-line comment.

```java
/* Multiple
 * line comment
 */
```
A multiple-line comment (also known as a multline comment) inclues anything starting from the symbol /* untul the symbol * /. People often type an asterisk (* ) at the beginning of each line of a multine commento to make it easer to read, but  you don't have to. Finlly, this is Javadoc comment:
```java
/**
* Javadoc multiple-line comment
* @author Jeanne and Scott
*/
```
This comment is similar to a multiline comment, except it starts with / ** . This special syntax tells the Javadoc tool to pay attention to the comment. Javadoc comments have a specific structure that the Javadoc tools knows how to read. You probably won't see a Javadoc comment on the exam. Just remember it exists, so you can read up on it online when you start writing programs for others to use.

As a bit of practice, can you identify which type of comment each of the following six words is in? Is each a single-line or a multline comment?

## Classes and Source Files
Most of the time, each Java class is defined in its own .java file. In this chapter, the only top-level type is a class. A top-level type is a data structure that can be defined independently within a source file. For the majority of the book, we work with classes as the top-level type, 

**O que é um tpo-level type (tipo de nível superior)?**
É simplesmente uma classe (ou interface, ou enum) que não está dentro de outra classe.

Exemplo de tipo *top-level:*
```java
public class Pessoa {
}
```

Exemplo de **tipo não top-level** (classe de dentro de outra classe):
```java
public class Pessoa {
	class Endereco { // classe interna (inner class), não é top-level
	}
}
```
- **Pessoa é top-level**
- Endereço é classe interna (não top-level)

For the majority of the book, we work with classes as the top-level type, but in **chapter 7**, "Beyond Classes", we present other top-level types, as well as nested types.

A top-level class is often (geralmente) *public*, which means any code can call it. Interestingly, Java does not require that the type be *public*. For example, this class is just fine:
```java
class Animal {
	String name;
}
```
You can even put two types in the same file. When you do so, at most one of the top-level types in the file is allowed to be public. That means a file containing the following is also fine:
```java
public class Animal {
	private String name;
}
class Animal12 {}
```
If you do have a public type, it needs to match the filename. The declaration *public class Animal12* would not compile in a file named *Animal.java*. In Chapter 5, "Methods," we discuss what access options are available other than public.

