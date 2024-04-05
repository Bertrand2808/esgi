package fr.esgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {
    @GetMapping("/inscription")
    public String showRegisterPageInscription() {
        return "inscription";
    }

    @GetMapping("/")
    public RedirectView rootRedirectToCatalogue(){
        return new RedirectView("/catalogue");
    }

    @GetMapping("/commande-page")
    public RedirectView showRedirectToCommande(){
        return new RedirectView("/commande");
    }
}

