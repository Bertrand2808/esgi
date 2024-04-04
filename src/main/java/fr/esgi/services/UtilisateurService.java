package fr.esgi.services;

import fr.esgi.business.Utilisateur;
import fr.esgi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository, BCryptPasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilisateur inscrireUtilisateur(Utilisateur utilisateur) {
        String motDePasseCrypte = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseCrypte);
        System.out.println("Mot de passe crypté de l'utilisateur : " + utilisateur.getMotDePasse());
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur connecterUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByAdresseEmail(email);
        if (utilisateur != null) {
            System.out.println("Adresse e-mail de l'utilisateur : " + utilisateur.getAdresseEmail());
            System.out.println("Mot de passe de l'utilisateur : " + utilisateur.getMotDePasse());
            if (passwordEncoder.matches(motDePasse, utilisateur.getMotDePasse())) {
                return utilisateur;
            }
        }
        return null;
    }

}