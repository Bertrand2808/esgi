package fr.esgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {
    @GetMapping("/inscription")
    public String showRegisterPage() {
        return "inscription";
    }

    @GetMapping("/")
    public RedirectView rootRedirectToCatalogue(){
        return new RedirectView("/catalogue");
    }
}

