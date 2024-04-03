package fr.esgi.business;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Fournisseur {
  @Id
  @Pattern(regexp = "^(06|07)([0-9]*)$", message = "Le numéro de portable doit commencer par 06 ou 07")
  private String numeroDePortable;

  @OneToMany(mappedBy = "fournisseur")
  private List<Sachet> sachets;
}
