package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  private String description;

  private Integer semaineDePlantationMin;
  private Integer semaineDePlantationMax;
  private Float espacementEntrePiedsEnCentimetres;
  private Float espacementEntreLignesEnCentimetres;
  private String conseils;

  @OneToOne
  private Famille famille;

  public TypeDeGraine(Long id, String nom, Integer semaineDePlantationMin, Integer semaineDePlantationMax, Float espacementEntreLignesEnCentimetres, Float espacementEntrePiedsEnCentimetres){
    this.id = id;
    this.nom = nom;
    this.semaineDePlantationMin = semaineDePlantationMin;
    this.semaineDePlantationMax = semaineDePlantationMax;
    this.espacementEntreLignesEnCentimetres = espacementEntreLignesEnCentimetres;
    this.espacementEntrePiedsEnCentimetres = espacementEntrePiedsEnCentimetres;
  }

  public void setSemaineDePlantationMin(Integer semaineDePlantationMin) {
    if (semaineDePlantationMin < 1 || semaineDePlantationMin > 52) throw new IllegalArgumentException("semaineDePlantationMin doit être compris entre 1 et 52");
    this.semaineDePlantationMin = semaineDePlantationMin;
  }

  public void setSemaineDePlantationMax(Integer semaineDePlantationMax) {
    if (semaineDePlantationMax < 1 || semaineDePlantationMax > 52) throw new IllegalArgumentException("semaineDePlantationMax doit être compris entre 1 et 52");
    this.semaineDePlantationMax = semaineDePlantationMax;
  }

  public void setFamille(Famille famille) {
    if (famille == null) throw new IllegalArgumentException("famille ne doit pas être null");
    this.famille = famille;
  }
}
