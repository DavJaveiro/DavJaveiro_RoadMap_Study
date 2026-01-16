import java.util.ArrayList;
import java.util.List;

public class ArrayListStudy {
    public static void main(String[] args) {
        List<String> yourList = new ArrayList<>();
        List<String> myList = new ArrayList<>();

        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");

        System.out.println("My List Size is: " + myList.size());

        myList.add(1, "Blueberry");
        System.out.println("After adding Blueberry at index 1, the size of MyList is: " + myList.size());

        System.out.println("MyList object at index 2: " + myList.get(2));
        System.out.println("MyList object at index 1: " + myList.get(1));

        myList.add("Fig");
        System.out.println("After adding Fig, the size of MyList is: " + myList.size());

        String banana = myList.get(2);
        System.out.println("Object at index 2 is: " + banana);

        myList.set(2,"potato");
        System.out.println("After setting index 2 to potato, object at index 2 is: " + myList.get(2));

        System.out.println(banana + " is still stored in the variable banana.");

    }
}
