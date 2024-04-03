package fr.esgi.services;

import fr.esgi.business.Utilisateur;
import fr.esgi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        // Vous pouvez ajouter ici une logique supplémentaire, comme le cryptage du mot de passe
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur connecterUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByAdresseEmail(email);
        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
            return utilisateur;
        }
        return null;
        // Dans une application réelle, vous devriez crypter et comparer les mots de passe cryptés
    }
}

