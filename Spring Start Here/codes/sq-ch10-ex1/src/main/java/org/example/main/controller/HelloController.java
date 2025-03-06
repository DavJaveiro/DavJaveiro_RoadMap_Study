package org.example.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*We use the @Controller annotation to mark the class as a Spring MVC controller*/
@Controller
public class HelloController {

    /*We use the @GetMapping for annotation to associate the GET HTTP Method and a path with the controller's action.*/
    @GetMapping("/hello")
    /*We use the @ResponseBody annotation to inform the dispatcher servlet that this method doesn't return a view name but the HTTP response directly*/
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/ciao")
    @ResponseBody
    public String ciao() {
        return "Ciao!";
    }
}
