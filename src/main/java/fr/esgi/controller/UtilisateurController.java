package fr.esgi.controller;

import fr.esgi.business.Utilisateur;
import fr.esgi.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/inscription")
    public String inscrireUtilisateur(@RequestParam String email, @RequestParam String motDePasse) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresseEmail(email);
        utilisateur.setMotDePasse(motDePasse);
        System.out.println("Adresse e-mail de l'utilisateur : " + utilisateur.getAdresseEmail());
        System.out.println("Mot de passe de l'utilisateur : " + utilisateur.getMotDePasse());
        utilisateurService.inscrireUtilisateur(utilisateur);
        return "redirect:/login";
    }
}

