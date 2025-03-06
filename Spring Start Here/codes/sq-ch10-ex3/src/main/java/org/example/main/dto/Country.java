package org.example.main.dto;

public class Country {
    private String name;
    private int population;


    /**/
    public static Country of(
            String name,
            int population) {

        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

}
