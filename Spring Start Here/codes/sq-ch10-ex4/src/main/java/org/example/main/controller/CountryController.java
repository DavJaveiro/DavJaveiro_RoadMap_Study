package org.example.main.controller;

import org.example.main.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/all")
    public ResponseEntity<Country> france() {
        Country country = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // changes the HTTP response status to 202 Accepted
                .header("continent", "Europe") // we adds three custom headers to the response
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(country);
    }
}
