package fr.esgi.business;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getQuantite() {
    return quantite;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
  }
}

