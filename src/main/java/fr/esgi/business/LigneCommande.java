package fr.esgi.business;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommande {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private Integer quantite;

  @ManyToOne
  private Utilisateur utilisateur;

  @ManyToOne
  private Commande commande;

  @ManyToMany
  private List<Sachet> sachets;
}

