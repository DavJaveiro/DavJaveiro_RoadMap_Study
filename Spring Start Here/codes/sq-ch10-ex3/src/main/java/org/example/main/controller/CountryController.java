package org.example.main.controller;

import org.example.main.dto.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {


    @GetMapping("/france")
    public Country france() {
        Country country = Country.of("France", 67);
        return country;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        List<Country> countries = new ArrayList<>();

        countries.add(Country.of("France", 67));
        countries.add(Country.of("Brazil", 68));
        countries.add(Country.of("Germany", 69));

        return countries;
    }
}
