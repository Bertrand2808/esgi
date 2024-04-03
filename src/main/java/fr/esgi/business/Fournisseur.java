package fr.esgi.business;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Fournisseur {
  @Id
  private String numeroDePortable;

  @OneToMany(mappedBy = "fournisseur")
  private List<Sachet> sachets;

  public String getNumeroDePortable() {
    return numeroDePortable;
  }

  public void setNumeroDePortable(String numeroDePortable) {
    if (!numeroDePortable.startsWith("06") || !numeroDePortable.startsWith("07")) {
      throw new IllegalArgumentException("Le numéro de portable doit commencer par 06 ou 07");
    }
    this.numeroDePortable = numeroDePortable;
  }
}
