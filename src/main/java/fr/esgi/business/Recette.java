package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Recette {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String intitule;
  private String contenu;
  @ManyToOne
  private Commande commande;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    if (intitule != null) throw new IllegalStateException("intitule ne doit pas être null");
    this.intitule = intitule;
  }

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }
}
