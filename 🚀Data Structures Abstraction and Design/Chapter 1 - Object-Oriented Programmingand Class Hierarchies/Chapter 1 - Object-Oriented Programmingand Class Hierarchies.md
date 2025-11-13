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
In earlier programming courses, you learned how to write individual classes consisting of attributes and methods (operations). You also learned hot to use existing classes (e.g., String and Scanner) to facilitate our programming. <span style="background:#affad1">These classes are part of the Java Application Programming Interface (API)</span>.

One of our goals is to write code that can be <font color="#ffff00">reused in many different applications</font>. One way to make code reusable is to encapsulate the data elements together with the methods that operate on that data. A new program can then use the methods to manipulate an object's data **without being concerned** (sem estar preocupado) about details of the data representation or the method implementations. The encapsulate data together with its methods is called an **abstract data type (ADT)**.

Figure 1.1 shows a diagram of an ADT. The data values stored in the ADT are hidden inside the circular wall. The bricks around this wall are used to indicate that these data values cannot be accessed except by going through the ADT's methods.

A class provides one way to implement an ADT in Java. If the data fields are private, they can be accessed only through public methods. Therefore, the *methods control access* to the data and determine the way the dada is manipulated.

Another goal of this text is to show you how to write and use ADTs in programming. As you progress through this book, you will create a large collection of ADT implementations (classes) in your own program library. You will also learn about ADTs that are available for you to use through the Java API. 

Our principal focus will be on ADTs that are used for structuring data to enable our to more easily and efficiently store, organize, and process information. These ADts are often called *data structures*. We introduce the Java Collections Framework (part of the Java API), which provides implementations of these common data structures, in Chapter 2 and study it throughout the text. Using the classes that are in the Java Collections Framework will make it much easier for you to design and implement new application programs.

**Interfaces**
