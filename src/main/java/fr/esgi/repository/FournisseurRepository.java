package fr.esgi.repository;

import fr.esgi.business.Fournisseur;
import fr.esgi.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {}
