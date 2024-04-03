package fr.esgi.business;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Utilisateur {
  @Setter
  @Getter
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Setter
  @Getter
  private String nom;
  @Setter
  @Getter
  private String prenom;
  @Setter
  @Getter
  private String adresseEmail;
  @Getter
  @Setter
  private String motDePasse;

  @OneToMany(mappedBy = "utilisateur")
  private List<LigneCommande> lignesCommande;
}
