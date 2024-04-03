package fr.esgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/connexion")
    public String showLoginPage() {
        return "connexion"; // Nom du fichier HTML de votre template Thymeleaf sans l'extension .html
    }

    @GetMapping("/inscription")
    public String showRegisterPage() {
        return "inscription"; // Nom du fichier HTML de votre template Thymeleaf sans l'extension .html
    }
}

