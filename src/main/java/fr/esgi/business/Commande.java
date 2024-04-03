package fr.esgi.business;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Commande {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate dateHeureDEnvoi;

  @OneToMany(mappedBy = "commande")
  private List<LigneCommande> lignesCommande;

  @OneToMany(mappedBy = "commande")
  private List<Recette> recettes;

  @ManyToOne
    private Jardinier jardinier;

  public Commande(LocalDate dateHeureDEnvoi, List<LigneCommande> lignesCommande) {
    this.dateHeureDEnvoi = dateHeureDEnvoi;
    this.lignesCommande = lignesCommande;
  }

  public Commande() {

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDateHeureDEnvoi() {
    return dateHeureDEnvoi;
  }

  public void setDateHeureDEnvoi(LocalDate dateHeureDEnvoi) {
    this.dateHeureDEnvoi = dateHeureDEnvoi;
  }

  public List<LigneCommande> getLignesCommande() {
    return lignesCommande;
  }

  public void setLignesCommande(List<LigneCommande> lignesCommande) {
    if (lignesCommande == null || lignesCommande.isEmpty()) {
      throw new IllegalStateException("lignesCommande ne doit pas être null ou vide");
    }
    this.lignesCommande = lignesCommande;
  }
}
