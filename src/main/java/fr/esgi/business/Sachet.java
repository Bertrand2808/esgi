package fr.esgi.business;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

  @ManyToMany(mappedBy = "sachets")
  private List<LigneCommande> lignesCommande;

  @ManyToOne
  private TypeDeGraine typeDeGraine;

  @ManyToOne
  private Fournisseur fournisseur;
}
