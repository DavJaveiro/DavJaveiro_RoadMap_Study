package org.example.sqch15ex1.service;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        // Create a list to store cities
        ArrayList<String> cityList = new ArrayList<>();
        
        // Add some cities in the list
        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");


        System.out.println("List size? " + cityList.size());

        System.out.println("Is miami in the list? " + cityList.contains("Miami"));

        System.out.println("The location of Denver in the list? " + cityList.indexOf("Denver"));

        System.out.println("Is the list empty?" + cityList.isEmpty());

        // Insert a new city at index 2
        cityList.add(2, "Rio de Janeiro");

        // Remove a city from the list
        cityList.remove("London");

        // Remove a city at index 1
        cityList.remove(1);

        // Display the contents in the list
        System.out.println(cityList.toString());

        // Display the contents in the list in reverse order
        for(int i = cityList.size() -1; i>= 0; i--)
            System.out.println(cityList.get(i) + " ");
        System.out.println();
    }
}
