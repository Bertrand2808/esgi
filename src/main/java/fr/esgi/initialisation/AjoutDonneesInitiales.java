package fr.esgi.initialisation;

import fr.esgi.business.Famille;
import fr.esgi.business.TypeDeGraine;
import fr.esgi.repository.FamilleRepository;
import fr.esgi.repository.TypeDeGraineRepository;
import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

  private final TypeDeGraineRepository typeDeGraineRepository;
  private final FamilleRepository familleRepository;


  @Override
  public void run(String... args) throws Exception {
    ajouterTypeDeGraine();
  }

  private void ajouterTypeDeGraine() {
    Famille famille_1 = familleRepository.save(new Famille(1L, "Famille 1", "5F3384"));
    Famille famille_2 = familleRepository.save(new Famille(2L, "Famille 2", "237D57"));

    typeDeGraineRepository.save(new TypeDeGraine(1L, "Carotte", "description Carotte...", 13, 14, 60.0f, 5.0f, "conseils Carotte...", famille_1));
    typeDeGraineRepository.save(new TypeDeGraine(2L, "Courgette", "description Courgette...", 22, 23, 120.0f, 75.0f, "conseils Courgette...", famille_1));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Haricot", "description Haricot...", 22, 23, 100.0f, 15.0f, "conseils Haricot...", famille_1));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Laitue Pommée", "description Laitue Pommée...", 13, 14, 55.0f, 25.0f, "conseils Laitue Pommée...", famille_1));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Oignon", "description Oignon...", 14, 14, 40.0f, 8.0f, "conseils Oignon...", famille_2));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Radis", "description Radis...", 14, 16, 45.0f, 2.5f, "conseils Radis...", famille_2));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Tomate", "description Tomate...", 21, 24, 90.0f, 80.0f, "conseils Tomate...", famille_2));
  }
}
