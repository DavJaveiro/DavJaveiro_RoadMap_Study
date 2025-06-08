**Objectives**
- [ ] To use aggregate operations on collection stream to simplify coding and improve performance;

## 30.1 Introduction
Often, we need to process data in an array or a collection. Suppose, for instance, that we need to count the number of elements in a set that is greater than 60. We way write the code using a foreach loop as follows:
```java
Double[] numbers = {2.5, 55.6, 90.12, 26.6};
Set<Double> set = new HashSet<>(Arrays.asList(numbers));
int count = 0;
for (double e: set)
	if (e > 60)
		count++;
System.out.println("Count is " + count);
```

The code is fine. However, Java provides a better and simpler way for accomplishing the task. Using the aggregate operations, we can rewrite the code as follows:
```java
System.out.println("Count is "
	+ set.stream().filter(e -> e > 60).count());
```

Invoking the **stream()** method on a set return a **Stream** for the elements from a set. The **filter** method specifies a condition for selecting the elements whose value is greater than 60. The **count()** method returns the number of elements in the stream that satisfy the condition. 

A *collection stream* or simply *stream* is a sequence of elements. The operations on a stream is called *aggregate operations* (also known as stream operations) because they apply to all the data in the stream. The **filter** and **count** are the examples of aggregate operations. The code written using a foreach loop describres the process how to obtain the count, that is, for each element, if it is greater than 60, increase the count. The code written using the aggregate operations tells the program to return the count for the elements greater than 60, but it does not specify how the count is obtained. Clearly, using the aggregate operations leaves the detailed implementations to the computer, therefore, makes de code concise and simpler. Moreover, the aggregate operations on a stream can be executed in parallel to take advantage of multiple processors. So, the code written using aggregate operations usually run faster than the ones using a **foreach** loop.

Java provides many aggregate operations and many different ways of using aggregate operations. 


### *Check Point 30.1.1* - What are the benefits of using aggregate operations on collection stream for processing data?
The aggregate operations make the code concise and simpler and can be executed in parallel to take advantage of multiple processors, basically. 

## 30.2 Stream Pipelines
*A stream pipeline consists of a stream created from a data source, zero or more intermediate methods, and a final terminal method.*

