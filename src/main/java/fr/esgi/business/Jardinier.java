package fr.esgi.business;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
  @Past(message = "La date de naissance doit être antérieure à la date actuelle")
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
}
