package org.example.main.login.controller;

import org.example.main.login.service.LoggedUserManagementService;
import org.example.main.login.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();

        // gets the count form the application-scoped bean
        int count = loginCountService.getCount();

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username);

        // sends the count value to the view
        model.addAttribute("loginCount", count);

        return "main.html";
    }
}
