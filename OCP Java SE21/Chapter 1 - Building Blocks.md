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

### Writing a *main()* Method
A Java program begins execution with its *main()* method. In this section, we learn how to create one, pass a parameter, and run a program. The *main()* method is often called an entry point into the program, beacause it is the starting point that the JVM looks for when it begins running a new program. 

### Creating a main() method
The main() method lets the JVM call our code. The simples possible class with a main() method looks like this:
```java
public class Zoo {
	public static void main(String[] args) {
	System.out.println("Hello World");
	}
}
```
This code prints *Hello World*. To compile and execute this code, type it into a file called Zoo.java and execute the following:
`javac Zoo.java`
`java Zoo`

If its prints *Hello World*, we're successful. If we do get error messages, check that you've installed the Java 21 JDK, that we have added it to the PATH, and that we didn't make any typos in the example. 

To compile Java code with the *javac* command, the file must have the extension .java. The name of the file must match the name of the public class. The result is a file of bytecode with the same name but with a *.class* filename extension. Remeber that bytecode consists of instructions that the JVM knows how to execute. Notice que we must omite the .class extension to run Zoo.class.

The rules for what a Java file contains, and and in what order, are more detailed than what we have explained so far (there is more on this topic later in the chapter). To keep things simple for now, we follow this subset of the rules:
- Each file can contain only one *public* class;
- The filename must match the class name, including case, and have a .java extension;
- If the Java class is a entry point for the program, it must contain a valid *main()* method.

Let's first review the words in the main() method's signature, one at a time. The keyword *public* is what's called an *access modifier*. It declares this method's level of exposure to potential callers in the program. Naturally, *public* means full access from anywhere in the program. We learn more about access modifiers in **Chapter 5**.

The keyword *static* binds (vincula) a method to its class so it can be called by just the class name. Java doesn't need to create an object to call the *main()* method, which is good since we haven't learned about creating objects yet.

In fact, the JVM does this, more or less, when loading the class name given to it. If a main() method doesn't have the right keywords, we'll get an error trying to run it. 

We see *static* again in chapter 6, "Class Design".

The keyword *void* represents the return type. A method that returns no data returns control to the caller silently. In general, it's good practice to use void for methods that change an object's state. In that sense, the main() method changes the program state from started to finished. We explore return types in chapter 5 as well. 

Finally, we arrive at the main() method's parameter list, represented as an array of *java.lang.String* Objects. We can use any valid variable name along with any of these three formats:
String[] args
String options[]
String... friends

The compiler accepts any of these. The variable name *args* is common because it hints that this list contains values that were read in (arguments) when the JVM started. The characters [] are brackets and represent an array. An array is fixed-size list of items that are all of the same type. The characteres... are called varargs (variable arguments lists). We learn about String in this chapter. Arrays are in Chapter 4, "Core APIs," and varargs are in Chapter 5 .

**Optional Modifiers in main() Methods**
While most modifiers, such as public and static, are required for main() methods, there are some optional modifiers allowed.
*public final static void main(final String[] args {}*
In this example, both final modifiers are optional, and the main() method is a valid entry point with or without them. We cover the meaning of **final**
methods and parameters in chapter 6.

### Passing Parameters to a Java Program
Let's see how to send data to our program's main() method. First, we modify the *Zoo* program to print out the first two arguments passed in
```java
puiblic class Zoo {
	public static void main(String[] args) {
	System.out.println(args[0]);
	System.out.println(args[1]);	
}
}
```
The code args[0] access the first element of the array. That's right: array indexes begin with 0 in Java. To run it, type this:
*javac Zoo.java*
*java Zoo Bronx Zoo*

The output is what we might expect.
*Bronx*
*Zoo*

The program correctly identifies the first two "words" as the arguments. Spaces are used to separate the arguments. If we want spaces insides an argument, we need to use quotes as in this example:
*javac Zoo.java*
*java Zoo "San Diego" Zoo*

Now we have a space in the output.
*San Diego*
*Zoo*

Finally, what happens if we don't pass in enough arguments?
*javac Zoo.java*
*java Zoo Zoo*

Reading args[0] goes fine, and Zoo is printed out. Then Java panics. There's no second argument! What to do? Java prints out an exception telling we it has no ideia what to do with this argument at position 1. We learn about exceptions in Chapter 11, "Exceptions and Localization."

To review, the JDK contains a compiler. Java class files run on the JVM and therefore run on any machine with Java rather than just the machine or operating system they happened to have been compiled on.

*Single-File Source Code*
If we get tired of typing both javac and java every time we want to try a code example, there's a shortcut. We can instead run this:
*java Zoo.java Bronx Zoo*

There is a key difference here. When compiling first, we omitted the file extension when running java. When skipping the explicit compilation step, we include this extension. This feature is called lauching single-file source code programs. 

**Understanding Package Declarations and Imports**
Java comes with thousands of built-in classes, and there are countless more from developers like you. With all those classes, Java needs a way to organize them. It handles this in a way similar to a file cabinet. We put all our pieces of paper in folders. Java put classes in *packages*. There are logical groupings for classes.

We wouldn't put in front of a file cabinet and tell we to find a specific paper. Instead, we'd tell you which folder to look in. Java works the same way. It needs we to tell it which packages to look in to find code.

Suppose we try to compile this code:
```java
public class NumberPicker {
	public static void main(String[] args) {
		Random r = new Random(); // DOEST NOT COMPILE
		System.out.println(r.nextInt(100));
	}
}
```
The Java compiler helpfully gives an error that looks like this:
*error: cannot find symbol*
This error could mean we made a typo in the name of the class.
We double-check and discover that we didn't. The other cause os this erros is omitting a needed import statement. 

A *statement* is an instruction, and import statements tell java which packages to look in for classes. Since we didnt' tell Java where to look for Random, it has no clue.

Trying this again with the *import* allows the code to compile.

```java
import java.util.Random;

public class NumberPicker {
	Random r = new Random();
	System.out.prinln(r.nextInt(10));
}
```
Now the code runs; it prints out a random number betweeen 0 and 9. Just like arrays, Java likes to begin counting with 0.

In chapter 5, we cover another type of import referred to as a *static* import. It allows we to make *static* members of a class known, often so we can use variables and method names without having to keep specifying the class name. 

### Packages


