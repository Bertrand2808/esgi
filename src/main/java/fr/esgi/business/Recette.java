package fr.esgi.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Recette
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "L'intitulé ne doit pas être null ou vide")
  private String intitule;
  private String contenu;
  @ManyToOne
  private Commande commande;

  @OneToMany
  private ArrayList<TypeDeGraine> graines;

  @ManyToOne
  private Jardinier jardinier;
}
