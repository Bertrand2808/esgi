package fr.esgi.business;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sachet {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private Integer poidsEnGrammes;
  private Float prixEnEuros;

  @NotNull(message = "TypeDeGraine ne doit pas être null")
  @OneToOne
  private TypeDeGraine typeDeGraine;

  @ManyToMany(mappedBy = "sachets")
  private List<LigneCommande> lignesCommande;

  @ManyToOne
  private Fournisseur fournisseur;

  public Sachet(Integer poidsEnGrammes, Float prixEnEuros, TypeDeGraine typeDeGraine) {
    this.poidsEnGrammes = poidsEnGrammes;
    this.prixEnEuros = prixEnEuros;
    this.typeDeGraine = typeDeGraine;
  }
}

