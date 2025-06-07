package org.example.sqch15ex1.service;
import java.util.ArrayList;
import java.util.List;



public class DallasRemove {
    public static void main(String[] args) {
         ArrayList<String> cities = new ArrayList<>(List.of("Dallas", "Dallas", "Rio de Janeiro", "Dallas"));

        for (int i = cities.size() -1; i >= 0; i--) {
            if (cities.get(i).equals("Dallas")) {
                cities.remove(i);
            }
        }

        System.out.println(cities);
         
    }
}
