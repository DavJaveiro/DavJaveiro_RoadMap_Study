*Objectives*
- To describe why arrays are necessary in programming;
- To declare array reference variables and create arrays;
- To obtain array size using *arrayRefVar.length* and know default values in a array;
- To acess array elements using indexes;
- To declare, create, and initialize an array using an array initializer;
- To program common array operations (displaying arrays, summing all elements, finding the minimum and maximum elements, random shuffling, and shifting elements);
- To simplify programming using the foreach loops;
- To apply arrays in application development (*AnalyzeNumbers*, and *DeckOfCards*)
- To copy contents from one array to another;
- To develop and invoke methods with array arguments and return values;
- To define a method with a variable-length argument list;
- To search elements using the linear or binary search algorithm;
- To sort an array using the selection sort approach;
- To use the methods in the *java.util.Arrays* class;
- To pass arguments to the main method from the command line;

## 7.1 Introduction
*A single array variable can reference a large collection of data.*
Often (frequentemente) you will have to store a large number of values during the execution of a program. Suppose, for instance, that we need to read 100 numbers, compute their average (médias), and find out how many numbers are **above** (acima) the average. Your program first reads the numbers and computes their average, then compares each number with the average to determine whether it is above the average. In order to accomplish this task, the numbers must all be stored in variables. You have to declare 100 variables and repeatedly write almost identical code 100 times. Writing a program this way would be impractical. So, how do you solve this problem?

An efficient, organized approach is needed. Java and most other  high-level languages provide a data structure, the #array, which stores a fixed-size sequential collection of elements of the same type. In the presente case, we can store all 100 numbers into an array and access them through a single array variable.

This chapter introduces single-dimensional arrays. The next chapter will introduce two-dimensional and multidimensional arrays.

## 7.2 Array Basics
*Once an array is created, its size is fixed. An array reference variable is used to access the elements in an array using an index*. **Key Point**

An array is used to store a collection of data, but often we find it more useful to think of an array as a collection of variables of the same type. Instead of declaring individual variables, such as **number0, number1,..., and number99**, we declare one array variable such as **numbers** and use **numbers[ 0 ]**, **numbers[1]**, ..., and **numbers[99]** to represent individual variables. This section introduces how to declare array variables, create arrays, and process arrays using indexes. 

### 7.2.1 Declaring Array Variables
To use an array in a program, we must declare a variable to reference the array and specify the array's element type. Here, is the syntax for declaring an array variable.
*elementType[] arrayRefVar;*
or
*elementType arrayRefVar[];* Allowed, but not preferred

The **elementType** can be any data type, and all elements in the array will have the same data type. For example, the following code declares a variable *myList* that references an array of double elements.

**double[] myList**;

or 

**double myList[]**; Allowed, but not preferred

> Note: we can use elementType arrayRefVar[] to declare an array variable. This style comes from the C/C++ language and was adopted in Java to accommodate C/C++ programmers. The style elementType[] arrayRefVar is preferred.

### 7.2.2 Creating Arrays
Unlike declarations for primitive data type variables, the declaration of an array variables does not allocate any space in memory for the array. It creates only a storage location for the reference to an array. If a variable does not contain a reference to an array, the value of the variable is *null*. You cannot assing elements to an array unless it has already been created. After an array variable is declared, we can create an array by using the *new* operator and assign its reference to the variable with the following syntax:
**arrayRefVar = new elementType[arraySize]**;

This statement does two things:
1. it creates an array using **new elementType[arraySize]** and
2. it assigns the reference of the newly created array to the variable **arrayRefVar**. 


Declaring an array variable, creating an array, and assigning the reference of the array to the variable can be combined in one statement as 
*elementType[] arrayRefVar = new elementType[arraySize]*;

or 
*elementType arrayRefVar[] = new elementType[arraySize]*;

Here is an example of such a statement:
*double[] myList = new double[10]*;

This statement declares an array variable, **myList**, creates an array of 10 elements of **double** type, and assigns its reference to **myList**. To assign values to the elements, use the syntax
**arrayRefVar[index] = value;**

For example, the following code initializes the array:
```java
myList[0] = 5.6;
myList[1] = 4.5;
myList[2] = 3.3;
myList[3] = 13.2;
myList[4] = 4.0;
myList[5] = 34.33;
myList[6] = 34.0;
myList[7] = 45.45;
myList[8] = 99.993;
myList[9] = 11123;
```
This array is illustrated in Figure 7.1:
!![image-202612650143.png](/image-202612650143.png)

>Note: an array variable that appears to hold an array actually contains a reference to that array. Strictly speaking, an array variable and an array are different, but most of the time the distinction can be ignored. Thus, it is all right to say, for simplicity, that **myList** is an array, instead of stating, at great length, that **myList** is a variable that contains a reference to an array of double elements.

### 7.2.3 Array Size and Default Values
When space for an array is allocated, the array size must be given, specifying the number of elements that can be stored in it. The size of an array cannot be changed after the array is created. Size can be obtained using *arrayRefVar.length*. For example, *myList.length* is 10. 

When an array is created, its elements **are assigned the default value of 0** for the numeric primitive data types, \u0000 for chat types, and false for boolean types.


```java
int[] numbersArray = new int[5]; // Array com 5  posições
```
After we crate the array with five size, the 5 positions of the array are given with with 0 element, if the array is a numeric primitive data type.

### 7.2.4 Accessing Array Elements
The array elements are accessed through the index. Array indices are 0 based; that is, they range from 0 to arrayRefVar.length -1. In the example in Figure 7.1, *myList* holds 10 **double** values, and the indices are from 0 to 9.

Each element in the array is represented using the following syntax, known as an *indexed variable:*
**arrayRefVar[index];**

For example, **myList[9]** represents the last element in the array **myList**.

>**Caution:** Some programming languages use parentheses to reference an array element, as in *myList(9), but Java uses brackets, as in myList[9]*.

An indexed variable can be used the same way as a regular variable. For example, the following code adds the values in myList[0] and myList[1] to myList[2]:
```java
myList[2] == myList[0] + myList[1];
```
The following loops assigns 0 to myList[0] and 1 to myList[1], ..., and 9 to myList[9]:
```java
for (int i = 0; i < myList.length; i++) {
	myList[i] = i;
}
```

### 7.2.5 Array Initializers
Java has a shorthand notation, known as the *array initializer*, which combines the declaration, creation, and initialization of an array in one statement using the following syntax:
*elementType[] arrayRefVar = {value0, value1, ..., valuek};*

For example, the statement
```java
double[] myList = {1.9, 2.9, 3.4, 3.5};
```
declares, creates, and initializes the array **myList** with four elements, which is equivalent to the following statements:
```java
double[] myList = new double[4];
myList[0] = 1.9;
...
myList[3] = 3.5;
```
>**Caution:** The *new* operator is not used in the array-initializer syntax. Using an array initializer, you have to declare, create, and initialize the array all in one statement. Splitting it would cause a syntax error. Thus, the next  statement is wrong:

```java
double[] myList;
myList = {1.9, 2.9, 3.4, 3.5}; // Wrong
```
### 7.2.6 Processing Arrays
When processing array elements, you will often use a *for* loop for one of two reasons:
1. All of the elements in an array are of the same type. They are evenly processed in the same fashion repeatedly using a loop.
2. Since the size of the array is knows, it is natural to use a **for** loop.

Assumes that the array is created as follows:
*double[] myList = new double[10]*;
The following are some examples of processing arrays:
1. *Initializing arrays with input values: the following loop initializes the array myList with user input values:* 
```java
java.util.Scanner input = new java.util.Scanner(System.in);

System.out.print("Enter " + myList.length + " values: ");
for (int i = 0; i < myList.length; i++)
	myList[i] = input.nextDouble();
```
2. *Initializing arrays with random values: the following loop initializes the array myList with random values between 0.0 and 100.0, but less than 100.0:*
```java
for (int i = 0; i < myList.length; i++) {
	myList[i] = Math.random() * 100;
}
```
3. *Displaying arrays:* to print an array, we have to print each element in the array using a loop such as the following:
```java
for (int i = 0; i < myList.length; i++) {
	System.out.println(myList[i] + " ");
}
```
>Tip: For an array of the *char[]* type, it can be printed using one print statement. For exemple, the following code displays **Dallas**:
```java
char[] city = {'D', 'a', 'l', 'l', 'a', 's'};
System.out.println(city);
```

4. *Summing all elements:* usa a variable named total to store the sum.
```java
double total = 0;
for (int i = 0; i < myList.length; i++) {
	total += myLit[i];
}
```

5. *Finding the largest element:* Use a variable name **max** to store the largest element. Initially **max** is myList[0]. To find the largest element in the array myList, compare each element with max, and update max if the element is greater than max:
```java
double max = myList[0];
for (int i = 1;i < myList.length; i++) {
	if (myList[i] > max) max = myList[i];
}
```

6. *Finding the smallest index of the largest element:* often you need to locate the largest element in an array. If an array has multiple elements with the same largest value, find the smallest index of such an element. Suppose that the array myList is {1, 5, 3, 4, 5, 5}. The largest element, and a variable named *indexOfMax* to denote the index of the largest element. Initially max is myList[0] and indexOfMax is 0. Compare each element in myList with max and updade max and indexOfMax if the element is greater than max. 
```java
double max = myList[0];
int indexOfMax = 0;
for( int i = 1; i < myList.length; i++) {
	if (myList[i] > max) {
	max = myList[i];
	indexOfMax = i;
	}
}
```

7.  *Random shuflling:* in many application, we need to randomly reorder the elements in a array. This is called #shuffling. To accomplish this, for each element.
```java
for (int i = 0; i < myList.length -1; i++) {
	// Generate an index j randomly
	int j = (int)(Math.random() * myList.length);
	
	//Swap myList[i] with myList[j]
	double temp = myList[i];
	myList[i] = myList[j];
	myList[j] = temp;
}
```

!![image-20261263211557.png](/image-20261263211557.png)

8. *Shifting elements:* sometimes we need to shift (deslocar) the elements left or right. Here is an example of shifting (deslocamento) the elements one position to the left and filling the last element with the first element:
```java
double temp = myList[0]; // Retain the first element

// Shift elements left
for (int i = 1; i < myList.length; i++) {
	myList[i - 1] = myList[i]
}

myList[myList.length - 1] = temp; 
//
```

9. *Simplifying coding:* arrays can be used to greatly simplify coding for certain tasks. For example, suppose we wish to obtain the English name of a given month by its numbers. If the month names are stored in an array, the month name for a given month can be accessed simply via the index. The following code prompts the user to enter a month number and displays its month name:
```java
String[] months = {"January", "February", ..., "December"};
System.out.println("Enter a month number (1 to 12): ");
int monthNumber = input.nextInt();
System.out.println("The month is " + months[monthNumber - 1]);
```

If we didn't use the **months** array, we would have to determine the month name using a lengthy multiway if-else statement as follows:

### 7.2.7 Foreach Loops
Java supports a convenient *for* loop, knows as a *foreach loop*, which enables we to traverse the array sequentially without using an index variable. For example, the following code displays all the elements in the array myList:
```java
for (double e: myList) {
	System.out.println(e);
}
```
We can read the code as "for each element e in myList, do the following." Note that the variable, e, must be declared as the same type as the elements in myList.

In general, the syntax for a foreach loop is
```java
for (elementType element: arrayRefVar) {
	// Porcess the element;
}
```
We still have to use an index variable if we wish to traverse the array in a different order or change the elements in the array. 

> Caution
> Access an array out of bounds is a common programming error that throws a runtime ArrayIndexOutOfBoundsException. To avoid it, make sure we do not us an index beyond arrayRefVar.length - 1 or simplify using a foreach loop if possible.

Programmer often mistakenly reference the first element in a array with index 1, but it should be 0. 

7.2.3 Indicate true or false for the following statements:
a. Every element in an array has the same type (correct);
b. The array size is fixed after an array reference variable is declared; (false)
c. The array size is fixed after it is created (correct)
d. The elements in an array must be of a primitive data type (false)

- 7.2.8 Write statements to do the following:
a. Create an array to hold 10 double values.
```java
double[] teenDoubles = new double[10];
```

b. Assign the value 5.5 to the last element in the array.
```java
teenDoubles[teenDoubles.length -1] = 5.5;
```

c. Display the sum of the first two elements
```java
System.out.println(teenDoubles[0] + teenDoubles[1]);
```

d. Write a loop that computes the sum of all elements in the array
```java
double total = 0.0;
for (double numbers: teenDoubles) {
	total += numbers;
}
```

e.  Write a loop that finds the minimum element in the array.
```java
double minElement = teenDoubles[0];
for (double number : teenDoubles) {
	if (number < element)
		minElement = number;
}
```

f. Randomly generate an index and display the element of this index in the array.
```java
 {
int j = (int)(Math.random() * teenDoubles.length);
System.out.println(teenDoubles[j]);
}
```
g. Use an array initializer to create another array with the initial values 3.5, 5.5, 4.52, and 5.6:
```java

```
## 7.3 Case Study: Analyzing Numbers
*The problem is to write a program that finds the number of items above the average of all items*

Now we can write a program using arrays to solve the problem proposed at the beginning of this chapter. The problem is to read 100 numbers, get the average of these numbers, and find the number of the items  greater than the average. To be flexible for handling any number of inputs, we will let the user enter the number of inputs, rather than fixing it to 100. Listing 7.1 gives a solution

#### Listing 7.1 AnalyzeNumbers.java
```java
public class AnalyzeNumber {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.prin("Enter the number of items: ");
		int n = input.nextInt();
		double[] numbers = new double[n];
		double sum = 0;
		
		System.out.prin("Enter the numbers: ");
		for (int i = 0; i < n; i++) {
		numbers[i] = input.nextDouble();
		sum += numbers[i];
		}
		
		double average = sum / n;
		
		int count = 0; // The number of elements above average
		for (int i = 0; i < n; i++)
		if(numbers[i] > average)
			cont++
			
		System.out.println("Average is " + average);
System.out.println("Number of elements above the average is " + count);
		
	}
}
```

Enter the number of items : 10
Enter the numbers: 3.4, 5, 5...
Average is 5.75
Numbers of elements above the average is 6

The program prompts the user to enter the array size (line 5) and creates an array with the specified size (line 6). The program reads the input, stores numbers into the array (line 11), adds each number to **sum** in line 12, and obtains the average (line 15). It then compares each number in the array with the average to count the numbers of values above the average (lines 7-20).

## 7.4 Case Study: Deck of Cards
*The problem is to create a program that will randomly select four cards from a deck of cards.*
Say you want to write a program that will pick four cards at random from a deck of 52 cards.
All the cards can be represented using an array name *deck*, filled with initial values 0-51, as follows:
```java
int[] deck = new int[52];

// Initialize cards
for (int i = 0; i < deck.length; i++)
	deck[i] = i;
```
Card numbers 0-12, 13-25, 26-38, and 39-51 represent 13 Spades, 13 Hearts, 13 Diamonds, and 13 Clubs, respectively, as show in Figure 7.2. **cardNumber / 13** determines the suit of the card, and *cardNumber % 13* determines the rank of the card, as shown in Figure 7.3.

After shuffling the array *deck*, pick the first four cards from *deck*. The program displays the cards from these four card numbers.

!![image-20261283419384.png](/image-20261283419384.png)

#### 7.2 DeckOfCards.java
```java
public class DeckOfCards {
	public static void main(String[] args) {
		int[] deck = new int[52];
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		
		// Initialize the cards
		for (int i = 0; i < deck.length; i++) {
		deck[i] = i;
		}
		
		// shuffle the cards
for (int i = 0; i < deck.length; i++) {
	// Generate an index randomly
	int index = (int)(Math.random() * deck.length);
	int temp = deck[i];
	deck[i] = deck[index];
	deck[index] = temp;
}

// Display the first four cards
for (int i = 0; i < 4; i++) {
	String suit = suits[deck[i] / 13];
	String rank = ranks[deck[i] % 13];
	System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
}
	}
}
```

The program creates an array suits for four suits (line 4) and an array ranks for 13 cards in a suit (lines 5 and 6). Each element in these arrays is a string. 

The program initializes deck with values 0-51 in lines 9 and 10. The deck value 0 representes the Ace of Spades, 1 representes de card 2 of Spaces, 13 represents the Ace of Hearts, and 14 representes the 2 of Hearts.

Lines 13-19 randomly shuffle the deck. After a deck is shuffled, deck[i] contains an arbitrary value. deck[i] / 13 is 0, 1, 2, or 3, which determines the suit (line 23). deck[i] % 13 is a value between 0 and 12, which determines the rank (line 24). If the suits array is not defined, we would have to determine the suit usingin a lengthy multiway if-else statments as follows:
if (deck[i] / 13 == 0)
	System.out.print("suit is Spades");
else if (deck[i] / 13 == 1)
	System.out.print("Suit is Hearts");

## 7.5 Copying Arrays
*To copy the contents of one array into another, we have to copy the array's individual elements into the other array.*
Often, in a program, we need to duplicate an array or part of an array. In such cases, we could attempt to use the assignment statement (=), as follows:
*list2 = list1*;

However, this statement does not copy the contents of the array referenced by *list1* to *list2*, but instead merely copies the reference value from *list1* to *list2*. After this statement, *list1* and *list2* reference the same array, as show in Figure 7.4. The array previously referenced by *list2* is no longer referenced; it becomes garbare, which will be automatically collected by the Java Virtual Machine. This process is called *garbare collection*.The array previously
referenced by list2 is no longer referenced; it becomes garbage, which will be automatically
collected by the Java Virtual Machine. This process is called garbage collection.

!![image-20261282345691.png](/image-20261282345691.png)
O array list2, após a referência, se torna lixo, ou seja, ele será automaticamente coletado pela JVM.

In Java, we can use assignment statements to copy primitive to copy primitive data type variables, but not arrays. Assigning one array variable to another array variable actualy copies one reference to another and makes both variables point to the same memory location.

There are three ways to copy arrays:
1. Use a loop to copy individual elements one by one;
2. Use the static *arrayCopy* method in the System class.
3. Use the *clone* method to copy arrays; this will be introduced in Chapter 13, Abstract Classes and Interfaces.
We can write a loop to copy every element from the source array to the corresponding element in the target array. The following code, for instance, copies *sourceArray* to *targetArray* using a *for* loop:
```java
int[] sourceArray = {2, 3, 1, 5, 10};
int[] targetArray = new int[sourceArray.length];
for (int i = 0; i < sourceArray.length; i++)
	targetArray[i] = sourceArray[i];
```

Another approach is to use the **arrayCopy** method in the java.lang.System class to copy *arrayCopy* method arrays instead of using a loop. The syntax for **arraycopy** is:
```java
System.arraycopy(sourceArray, 0, targetArray, 0, sourceArray.length);
```
The *arrayCopy* method does not allocate memory space for the target array. The target array must have already been created with its memory space allocated. After the copying takes place, *targetArray* and *sourceArray* have the same content but independent memory locations.

>Note the *arrayCopy* method violates the Java naming convention. By convention, this method should name **arrayCopy** (i.e., with an uppercase C).

7.5.1 Use the *arrayCopy* method to copy the following array to a target array t: 
int[] source = {3, 4, 5};

7.5.2 Once an array is created, its size cannot be changed. Does the following code resize the array?
```java
int[] myList;
myList = new int[10];
// Sometime later you want to assign a new array to myList
myList = new int[20];
```

## 7.6 Passing Arrays to Methods
*When passing an array to a method, the reference of the array is passed to the method*
(**Quando passamos um array para um método, a referência do array também é passada para o método**)
Just as we can pass primitive type values to methods, we can also pass arrays to methods. 

For example, the following methods displays the elements in an *int* array:
```java
public static void printArray(int[] array) {
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i] + " ");
	}
}
```

We can invoke it by passing an array. For example, the following statement invokes the **printArray** method to display 3, 1, 2, 6, 4 and 2.

`printArray(new int[]({3, 1, 2, 6, 4, 2});`

>**Note:** The preceding statement creates an array using the following syntax:
>new elementType[]{value0, value1, ..., valueK};

Java uses *pass-by-value* to pass arguments to a method. There are important differences between passing the values of variables of primitive data types and passing arrays.

- For an argument of a primitive type, the argument's value is passed.
- For an argument of an array type, the value of the argument is a reference to an array; this reference value is passed to the method. Semantically, it can be best describe as *pass-by-sharing*, that is, the array in the method is the same as the array being passed. Thus, if we change the array in the method, we will see the change outside the method.

**Explicação resumida**
- **Primitivos:** quando chamamos *m(x)*, o método recebe uma **cópia** do valor de **x**. Operações sobre esse parâmetro não tocam a variável original. 
- **Arrays/Objetos:** a variável que passamos contém uma referência (endereço) ao objeto; essa referência é um **valor** e é copiada para o parâmetro do método. Assim, **ambas as referências apontam para o mesmo objeto;** mutações no objeto são compartilhadas. 

Take the following code, for example:
```java
public class TestArrayArguments {
	public static void main(String[] args) {
		int x = 1; // x represents an int value
		int[] y = new int[10]; // y represents an array of int values;
		m(x, y); // invokes m with arguments x and y
		System.out.println("x is " + x);
		System.out.println("y[0] is " + y[0]);
		public static void m(int number, int[] numbers) {
			number = 1001; // Assign a new value to number
			numbers[0] = 5555; // Assign a new value to numbers[0];
		}
	}
}
```
A saída acima será:
>x is 1
>y[0]  is 5555

We may wonder why after *m* is invoked, *x* remais 1, but y[0] becomes 5555.

This is because *y* and *numbers*, although they are independent variables, reference the same array, as illustrated in Figure 7.5. When **m(x, y)** is invoked, the values of x and y are passed to number and *numbers*. Since *y* contains the reference value of the array, *numbers* now contains the same reference value to the same array.
!![image-2026228520.png](/image-2026228520.png)

Java sempre passa argumentos por valor; para tipos primitivos é a cópia do valor, e parra arrays/objetos é a cópia da referência (ou seja, o endereço). Isso faz com que mutações no conteúdo do array dentro do método sejam visíveis fora, enquanto atribuições ao parâmetro não alteram a variável do chamador. 
**O que está acontecendo em nosso exemplo:**
- *x* **é um primitivo:** quando chamamos *m(x,y)*, o valor 1 é copiado para o parâmetro *number*. Alterar *Number = 1001;* muda apenas essa cópia local; x no main permanecerá 1;
- *y* **é uma variável que contém uma referência ao array:** ao chamar *m(x,y)*, o valor que é copiado para *numbers* é essa referência (um ponteiro/endereçamento para o array). Assim, *numbers* e *y* apontam para o mesmo array no heap. 

Por isso o array é compartilhado (mutação visível), enquanto o primitivo não é.

**Passam por valor**
Arrays e objetos - passagem por valor da referência (pass-by-value of the reference) ou *pass-by-sharing*.

>**Note:** Arrays are object in Java (objects are introduced in Chapter 9). The JVM stores the objects in an are of memory called the *heap*, which is used for dynamic memory allocation.

Listing 7.3 gives another program that shows the difference between passing a primitive data type value and an array reference variable to a method.

The program contains two methods for swapping elements in an array. The first method, name *swap*, fails to swap two *int* arguments. The second method, name *swapFistTwoInArray*, successfully swaps the first two elements in the array argument.

*Listing 7.3 TestPassArray.java*
```java
public class TestPassArray {
	public static void main(String[] args) {
		int[] a = {1, 2};
		
		// swap element using the swap method
		System.out.println("Before invoking swap");
		System.out.println("array is {" + a[0] + ", " + a[1] + "}");
		swap(a[0])
		
		
		public static void swap(int n1, int n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
	}
	
	public static void swapFirstTwoInArray(int[] array) {
		int temp = array[0];
		array[0] = array[1];
		array[1] = temp;
	}
}
```

As shown in Figure 7.6, the two elements are not swapped using the *swap* method. However, the are swapped using the *swapFirstTwoInArray* method. Since the parameters in the **swap** method are primitive type, the values of **a[0]** are passed to **n1** and **n2** inside the method when invoking **swap(a[0], a[1])**. The memory locations for **n1** and **n2** are independent of the ones for **a[0]** and **a[1]**. The contents of the array are not affected by this call..

When passing an array to a method, the reference of the array is passed to the method. 

The parameter in the **swapFirstTwoInArray** method is an array. 

>**7.6.1 - True or false?** When an array is passed to a method, a new array is created and passed to the method.

Falso, quando passamos um array para um método, estamos passando uma cópia da referência daquele array, ou seja, estamos apontando para o mesmo endereço de memória, na *heap*, do array subjacente, portanto, não criamos uma cópia do array e sim manipulamos o array referenciado. Isso se chama *pass-by-value of the reference.* Logo, o parâmetro do método e a variável do chamador **apontam para o mesmo array no heap, logo mutações no conteúdo do array dentro do método serão visíveis fora daquele método**.

## 7.7 Returning an Array from a Method
*When a method returns an array, the reference of the array is returned.*

We can pass arrays when invoking a method. A method may also return an array. For example, the following method returns an array that is the reversal of another array.
```java
public static int[] reverse(int[] list) {
	int[] result = new int[list.length];
	
	for (int i = 0, j = result.length -1; i < list.length; i++, j--) {
		result[j] = list[i];
	}
	
	return result;
}
```
Line 2 creates a new array **result**. Lines 4-7 copy elements from array list to array result. Line 9 returns the array. For example, the following statement returns a new array **list2** with elements 6, 5, 4, 3, 2, 1:
```java
int[] list1 = {1, 2, 3, 4, 5, 6};
int[] list2 = reverse(list1);
```

7.7.1 Suppose the following code is written to reverse the contents in an array, explain why it is wrong. How do you fix it?
```java
int[] list = {1, 2, 3, 5, 4};
for (int i = 0, j = list.length − 1; i < list.length; i++, j−−) {
// Swap list[i] with list[j]
int temp = list[i];
list[i] = list[j];
list[j] = temp;
}
```
Estamos criando uma variável temporário temp do tipo int. Ela armazenará apenas o valor do int atual com base no índice acessado do array, a cada iteração, e abaixo, list[j] = temp, estamos assumindo outro valor temporário para list[j] = temp. para que pudesse funcionar, temos que criar um array temporário ao invés de um int temp.

## 7.8 Case Study: Counting the Occurrences of Each Letter
*This section presents a program to count the occurrences of each letter in an array of characters.*
The program given in Listing 7.4 does the following:
1. Generates 100 lowercase letters randomly and assigns them to an array of characters, as shown in Figure 7.7a. We can obtain a random letter by using the **getRandomLowerCaseLetter()** method in the **RandomCharacter** class in Listing 6.10.
2. Count the occurrences of each letter in the array. To do so, create an array, say **counts**, of 26 int values, each of which counts the occurrences of a letter, as show in Figure 7.7b. That is, **counts[0]** counts the number of a's, counts[1] counts the number of b's, and so on.
!![image-202622547166.png](/image-202622547166.png)

The **createArray** method generates an array of 100 random lowercase letters.
Line 5 invokes the method and assigns the array to chars. What would be wrong if we rewrote the code as follows?
char[] chars = new char[100];
chars = createArray();

You would be creating two arrays. The first line would create an array by using new char[100]. The second line would create an array by invoking **createArray()** and assign the reference of the array to **chars**. The array created in the first line would be garbare because it is no longer referenced, and as mentioned earlier, Java automatically collects garbage behind the scenes. Our program would compile and run correctly, but it would create an array unnecessarily. 

Invoking **getRandomLowerCaseLetter()** (line 28) return a random lowercase letter. This method is defined in the **RandomCharacter** class in Listing 6.10.

The **countLetters** method return an array of 26 int values, each of which stores the number of occurrences of a letter. The method processes each letter in the array and increases its count by one. A brute-force approach to count the occurrences of each letter might be as follows:
```java
for (int = 0; i chars.length; i++)
	if (chars[i] == 'a')
		counts[0]++;
	else if (chars[i] == 'b')
		counts[1]++;
```

However, a better solution is given in lines 51 and 52
```java
for (int i = 0; i < chars.length; i++)
	counts[chars[i] - 'a']++;
```
If the letter (chars[i]) is a, the corresponding count is counts['a' − 'a'] (i.e.,
counts[0]). If the letter is b, the corresponding count is counts['b' − 'a'] (i.e.,
counts[1]), since the Unicode of b is one more than that of a. If the letter is z, the
corresponding
count is counts['z' − 'a'] (i.e., counts[25]), since the Unicode of z is
25 more than that of a.
The code example above is:
[[CountLettersInArray.java]]

#### 7.8.1 Show the output of the following two programs:

## 7.9 Variable-Length Argument Lists
*A variable number of arguments of the same type can be passed to a method and treated as an array*

We can pass a variable number of arguments of the same type to a method. The parameter in the method is declared as follows:
`typeName... parameterName`

In the method declaration, we specify the type followed by an ellipsis (...). <span style="background:#fff88f">Only one variable-length parameter may be specified in a method</span>, and this parameter must be the last parameter. Any regular parameters must precede it.

Java treats a variable-length parameter as an array. We can pass an array or variable number of arguments to a variable-length parameter. When invoking a method with a variable number of arguments, Java creates an array and passes the arguments to it. Listing 7.5 presents a method that prints the maximum value in a list of an unspecified number of values.

```java
public class VarArgDemo {
	public static void main(String[] args) {
		printMax(34, 3, 3, 2, 56.5);
		printMax(new double[]{1, 2, 3});
	}
	
	public static void printMax(double... numbers) {
		if (numbers.length == 0) {
		System.out.println("No argument passed");
		return;
		}
		
		double result = numbers[0];
		for(int i = 1; i < numbers.length; i++)
			if (numbers[i] > result)
			result = numbers[i];
		
		System.out.println("The max value is " + result);
		
	}
}
```

Portanto, em Java um parâmetro varargs aceita tanto argumentos individuais (valores primitivos) quanto um array do mesmo tipo; internamente o compilador trata varargs como um array. 

7.9.1 What is wrong with each of the following method headers?
a. public static void print(String... strings, double...numbers)
Estamos passando dois varargs como argumento para o método print, o que é errado em Java;



b. public static void print(double...numbers, String name)
O *varargs* deve ser o último parâmetro passado como argumento

c. public static double... print(double d1, double d2)
Aqui, o ... está fora, essa sintaxe está incorreta. Não existe, os ... devem vir dentro dos parênteses como tipo ... < nomeref > varargs não pode ser tipo de retorno.

## 7.10 Searching Arrays
*If an array is sorted, binary search is more efficient than linear search for finding an element in the array*.
