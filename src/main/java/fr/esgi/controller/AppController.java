package fr.esgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/connexion")
    public String showLoginPage() {
        return "connexion";
    }

    @GetMapping("/inscription")
    public String showRegisterPage() {
        return "inscription";
    }
}

