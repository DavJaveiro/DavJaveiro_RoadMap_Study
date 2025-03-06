package org.example.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*Instead of repeating the @ResponseBody annotation for each method, we replace @Controller with @RestController*/
@RestController
public class HelloControllerRest {

    @GetMapping("/hellorest")
    public String helloControllerRest() {
        return "Olá RestController";
    }

    @GetMapping("/anciao2")
    public String anciao() {
        return "olá Ancião safado!";
    }
}
