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
    public String inscrireUtilisateur(Utilisateur utilisateur) {
        utilisateurService.inscrireUtilisateur(utilisateur);
        return "redirect:/connexion"; // Rediriger vers la page de connexion après l'inscription
    }

    @PostMapping("/connexion")
    public String connecterUtilisateur(@RequestParam String email, @RequestParam String motDePasse, Model model) {
        Utilisateur utilisateur = utilisateurService.connecterUtilisateur(email, motDePasse);
        if (utilisateur != null) {
            // Gérer la connexion réussie, par exemple en stockant l'utilisateur dans la session
            return "redirect:/accueil"; // Supposons que vous ayez une page d'accueil
        } else {
            model.addAttribute("erreur", "Identifiants invalides");
            return "connexion";
        }
    }
}

