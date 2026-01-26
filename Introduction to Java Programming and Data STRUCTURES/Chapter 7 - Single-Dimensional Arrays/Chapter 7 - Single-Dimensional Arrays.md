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

8. *Shifting elements:*
