## 11.11 The ArrayList Class
Now are ready to introduce a very useful class for storing objects. You can create an array to store objects. However, <span style="background:#b1ffff">once the array is created, its size is fixed</span>. Java provides the *ArrayList* class, which can be used to store an unlimited number of objects. Figura 11.3 shows some methods in *ArrayList*:
- #ArrayList() - creates an empty list
- *add(e: E):* void - appends a new element e at the end of this list
- add(index: int, e: E): void - adds a new element e at the specified index in the list
- *clear(): void* - Remove all elements fro the list
- *contains(o: object): boolean* - returns true if this list contains the element o.
- *get(index: int)*: E - returns the element from this list at the specified index
- *indexOf(o: Object): int* - Returns the index of the first matching element in this list
- *isEmpty(): boolean* - Returns true if this list contains no elements
- *lastIndexOf(o: Object): int* - Returns the index of the last matching element in this list
- *remove(o: Object): boolean* - Removes the first element CDT from this list. Returns true if an element is removed
- *size(): int* - Removes the element at the specified index. Returns the removed element.
- *set(index: int, e: E): E* - Sets the element at the specified index.

An **ArrayList** stores an unlimited number of objects.

**ArrayList** is known as a generic class with a generic type E. You can specify a concrete type to replace E when creating an **ArrayList**. For example, the following statement creates an **ArrayList** and assigns its reference to to variable **cities**. This **ArrayList** object can be used to store strings.

```java
ArrayList<String> cities = new ArrayList<String>();
```

The following statement creates an **ArrayList** and assigns its reference to variable dates. This **ArrayList** object can be used to store dates.
```java
ArrayList<java.util.Date> dates = new ArrayList<java.util.Date>();
```
**Note**: Since JDK 7, the statement

```java
ArrayList <AConcreteType> list = new ArrayList<AConcreteType>();
```

can be simplified by

```java
ArrayList<AConcreteType> list = new ArrayList<>();
```

The concrete type is no longer required in the constructor, thanks to a feature called *type inference*. The compiler is able to infer the type from the variable declaration. More discussions on generics including how to define custom generic classes and methods will be introduced in Chapter 19, Generics.

Listing 11.8 gives an example of using **ArrayList** to store objects.

Since the **ArrayList** is in the *java.util* package, it is imported in line 1. The program creates an **ArrayList** of strings using its no-arg constructor and assigns the reference to add(Object) **cityList** (line 6). The **add** method adds strings to the end of list. Thus, after **cityList.add("London")**, the list contains [London]

After **cityList.add("Denver")**, the list contains
[London, Denver]

After adding **Paris**, **Miami**, **Seoul**, **Tokyo** (lines 13-19), the list contains
[London, Denver, Paris, Miami, Seoul, Tokyo]

Once an array is created, its size is fixed. We can access an array element using the square-bracket notation(e.g., a[index]). When an **ArrayList** is created, its size is 0. 

Differences and Similarities between Arrays and ArrayList:
- **Creating an array/ArrayList**: 
	- String[] a = new String[10]
	- ArrayList< String > list = new ArrayList <>()

- **Acessing an element**:
	- a[index]
	- list.get(index)

- **Updating an element:**
	- a[index] = "London";
	- list.set(index, "London")

- **Returning size**
	- a.length
	- list.size();

- **Adding a new element**
	- list.add("London");

- **Inserting a new element** 
	- list.add(index, "London")

- **Removing an element**
	- list.remove(index)

We cannot use the **get(index)** and **set(index, element)** methods if the element is not in the list. It is easy to add, insert, and remove elements in a list, but is rather complex to add, insert, and remove elements in an array. We have to write code to manipule the array in order to perform these operations. Note you can sort an array using the java.util.Arrays.sort(array) method. To sort an array list, use the **java.util.Collections.sort(arraylist)** method.

Suppose we want to create an ArrayList for storing integers. Can you use the following code to create a list?

ArrayList< int > listOfIntegers = new ArrayList<>();

No. This will not work because the elements stored in an **ArrayList** must be of an object type. You cannot use a primitive data type such as **int** to replace a generic type. However, you can create an **ArrayList** for storing **Integer** objects as follows:
ArrayList< Integer > listOfIntegers = new ArrayList<>(); 

Note the **remove(int index)** method removes an element at the specified index. To remove an integer value v from **listOfIntegers**, we need to use **listOfIntegers.remove(Integer.valueOf(v))**. This is not a good design in the Java API because it could easily lead to mistakes (<span style="background:#affad1">isso pode facilmente levarmos a cometer erros</span>). It would be much better if **remove(int)** is renamed **removeAt(int)**.

Listing 11.9 gives a program that prompts the user to enter a sequencer of numbers and displays the distinct numbers in the sequence. Assume the input ends with 0, and 0 is not counted as a number in the sequence.

**Listing 11.9 - DistinctNumbers.java**
```java
import java.util.ArrayList;
import java.util.Scanner;

public class DistinctNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		

		System.out.println("Enter integers (input ends with 0): ");
		int value;

		do {
			value = input.nextInt(); // Read a value from the input
			if (!list.contains(value) && value != 0)
			list.add(value); // Add the value if it is not in the list
		} while (value != 0);

		// Display the distinct numbers
		System.out.println("The distinct integers are: ");
		for (int i = 0; i < list.size(); i++)
	System.out.println(list.get(i) + " ");
	}
}
```

![[Chapter 11 - Inheritance and Polymorphism.png]]

The program creates an **ArrayList** for **Integer** objects (line 6) and <span style="background:#d4b106">repeatedly reads a value in the loop</span> (lines 12-17). For each value, if it is not in the list, add it to the list. You can rewrite this program using an array to store the elements rather than using an **ArrayList**. However, it is simpler to implement this program using an **ArrayList** for two reasons.

1. The size of an **ArrayList** is flexible so you <span style="background:#d4b106">don't have to specify its size in advance.</span> When creating an array, its size must be specified.
2. **ArrayList** contains many useful methods. For example, we can test whether an element is in the list using the **contains** method. If we use an array, we have to write additional code to implement this method.

We can traverse (percorrer) the elements in an array using a foreach loop. The elements in an array list can also be traversed using a foreach loop using the following syntax:

```java
for (elementType element: arrayList) {
	// Process the element
}
```

For example, we can replace the code in lines 20 and 21 using the following code:
```java
for (Integer number: list)
	System.out.print(number + " ");
```

Note the elements in **list** are **Integer** objects. They are automatically unboxed into **int** in this foreach loop.

