package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
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

  public TypeDeGraine() {
  }

  public TypeDeGraine(Long id, String nom, Integer semaineDePlantationMin, Integer semaineDePlantationMax, Float espacementEntreLignesEnCentimetres, Float espacementEntrePiedsEnCentimetres){
    this.id = id;
    this.nom = nom;
    this.semaineDePlantationMin = semaineDePlantationMin;
    this.semaineDePlantationMax = semaineDePlantationMax;
    this.espacementEntreLignesEnCentimetres = espacementEntreLignesEnCentimetres;
    this.espacementEntrePiedsEnCentimetres = espacementEntrePiedsEnCentimetres;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getSemaineDePlantationMin() {
    return semaineDePlantationMin;
  }

  public void setSemaineDePlantationMin(Integer semaineDePlantationMin) {
    if (semaineDePlantationMin < 1 || semaineDePlantationMin > 52) throw new IllegalArgumentException("semaineDePlantationMin doit être compris entre 1 et 52");
    this.semaineDePlantationMin = semaineDePlantationMin;
  }

  public Integer getSemaineDePlantationMax() {
    return semaineDePlantationMax;
  }

  public void setSemaineDePlantationMax(Integer semaineDePlantationMax) {
    if (semaineDePlantationMax < 1 || semaineDePlantationMax > 52) throw new IllegalArgumentException("semaineDePlantationMax doit être compris entre 1 et 52");
    this.semaineDePlantationMax = semaineDePlantationMax;
  }

  public Float getEspacementEntrePiedsEnCentimetres() {
    return espacementEntrePiedsEnCentimetres;
  }

  public void setEspacementEntrePiedsEnCentimetres(Float espacementEntrePiedsEnCentimetres) {
    this.espacementEntrePiedsEnCentimetres = espacementEntrePiedsEnCentimetres;
  }

  public Float getEspacementEntreLignesEnCentimetres() {
    return espacementEntreLignesEnCentimetres;
  }

  public void setEspacementEntreLignesEnCentimetres(Float espacementEntreLignesEnCentimetres) {
    this.espacementEntreLignesEnCentimetres = espacementEntreLignesEnCentimetres;
  }

  public String getConseils() {
    return conseils;
  }

  public void setConseils(String conseils) {
    this.conseils = conseils;
  }

  public Famille getFamille() {
    return famille;
  }

  public void setFamille(Famille famille) {
    if (famille == null) throw new IllegalArgumentException("famille ne doit pas être null");
    this.famille = famille;
  }
}
