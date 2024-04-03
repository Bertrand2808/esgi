package fr.esgi.business;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Jardinier {
  @Id
  private LocalDate dateDeNaissance;

  @Column(nullable = false, unique = true)
  @Email(message = "L'adresse email est invalide")
  @NotBlank(message = "L'adresse email est requise")
  private String email;

  @Column(nullable = false)
  @NotBlank(message = "Le mot de passe est requis")
  private String motDePasse;

  @OneToMany(mappedBy = "jardinier")
  private List<Commande> commandes;

  public Jardinier(LocalDate dateDeNaissance, String email, String motDePasse) {
    this.dateDeNaissance = dateDeNaissance;
    this.email = email;
    this.motDePasse = motDePasse;
  }

  public void setDateDeNaissance(LocalDate dateDeNaissance) {
    if(dateDeNaissance.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("La date de naissance doit être antérieure à la date actuelle");
    }
    this.dateDeNaissance = dateDeNaissance;
  }
}
