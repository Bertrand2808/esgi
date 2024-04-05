package fr.esgi.business;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TypeDeGraine {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String nom;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Range(min = 1,max = 52)
  private Integer semaineDePlantationMin;
  @Range(min = 1,max = 52)
  private Integer semaineDePlantationMax;
  private Float espacementEntrePiedsEnCentimetres;
  private Float espacementEntreLignesEnCentimetres;
  @Column(columnDefinition = "TEXT")
  private String conseils;

  @NotNull(message = "famille ne doit pas être null")
  @ManyToOne
  private Famille famille;

  public TypeDeGraine(Long id, String nom, Integer semaineDePlantationMin, Integer semaineDePlantationMax, Float espacementEntreLignesEnCentimetres, Float espacementEntrePiedsEnCentimetres){
    this.id = id;
    this.nom = nom;
    this.semaineDePlantationMin = semaineDePlantationMin;
    this.semaineDePlantationMax = semaineDePlantationMax;
    this.espacementEntreLignesEnCentimetres = espacementEntreLignesEnCentimetres;
    this.espacementEntrePiedsEnCentimetres = espacementEntrePiedsEnCentimetres;
  }
}
