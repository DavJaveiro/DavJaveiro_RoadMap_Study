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

