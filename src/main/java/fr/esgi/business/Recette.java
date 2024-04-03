package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Recette {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "L'intitulé ne doit pas être null ou vide")
  private String intitule;
  private String contenu;
  @ManyToOne
  private Commande commande;
}
