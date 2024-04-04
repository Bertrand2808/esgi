package fr.esgi.business;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Fournisseur extends Utilisateur
{
  @Id
  @Pattern(regexp = "^(06|07)([0-9]*)$", message = "Le numéro de portable doit commencer par 06 ou 07")
  private String numeroDePortable;

  @OneToMany(mappedBy = "fournisseur")
  private List<Sachet> sachets;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> list = new ArrayList<>();
    list.add(new SimpleGrantedAuthority("WRITE"));
    return list;
  }
}
