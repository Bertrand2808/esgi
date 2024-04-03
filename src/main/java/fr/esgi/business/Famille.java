package fr.esgi.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Famille {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  private String nom;

  @Size(min = 6, max = 6)
  private String couleurRGB;

  public void setCouleurRGB(String couleurRGB) {
    if (couleurRGB.length() != 6) throw new IllegalArgumentException("couleurRGB doit contenir 6 caractères");
    this.couleurRGB = couleurRGB;
  }
}
