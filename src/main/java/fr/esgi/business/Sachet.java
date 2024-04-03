package fr.esgi.business;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Sachet {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private Integer poidsEnGrammes;
  private Float prixEnEuros;

  @ManyToMany(mappedBy = "sachets")
  private List<LigneCommande> lignesCommande;

  @ManyToOne
  private TypeDeGraine typeDeGraine;

  @ManyToOne
  private Fournisseur fournisseur;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getPoidsEnGrammes() {
    return poidsEnGrammes;
  }

  public void setPoidsEnGrammes(Integer poidsEnGrammes) {
    this.poidsEnGrammes = poidsEnGrammes;
  }

  public Float getPrixEnEuros() {
    return prixEnEuros;
  }

  public void setPrixEnEuros(Float prixEnEuros) {
    this.prixEnEuros = prixEnEuros;
  }
}
