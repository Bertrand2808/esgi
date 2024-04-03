package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Famille {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  private String nom;
  private String couleurRGB;

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

  public String getCouleurRGB() {
    return couleurRGB;
  }

  public void setCouleurRGB(String couleurRGB) {
    if (couleurRGB.length() != 6) throw new IllegalArgumentException("couleurRGB doit contenir 6 caractères");
    this.couleurRGB = couleurRGB;
  }
}
