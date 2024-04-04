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
    Famille famille1 = familleRepository.save(new Famille(1L, "Legumes-feuilles", "5F3384"));
    Famille famille2 = familleRepository.save(new Famille(2L, "Legumes-racines", "237D57"));
    Famille famille3 = familleRepository.save(new Famille(3L, "Legumes-fruits", "ABC123"));

    typeDeGraineRepository.save(new TypeDeGraine(1L, "Carotte", "description Carotte...", 13, 14, 60.0f, 5.0f, "conseils Carotte...", famille1));
    typeDeGraineRepository.save(new TypeDeGraine(2L, "Courgette", "description Courgette...", 22, 23, 120.0f, 75.0f, "conseils Courgette...", famille1));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Laitue", "description Laitue...", 13, 14, 55.0f, 25.0f, "conseils Laitue...", famille1));

    typeDeGraineRepository.save(new TypeDeGraine(4L, "Betterave", "description Betterave...", 14, 16, 80.0f, 30.0f, "conseils Betterave...", famille2));
    typeDeGraineRepository.save(new TypeDeGraine(5L, "Radis", "description Radis...", 14, 16, 45.0f, 2.5f, "conseils Radis...", famille2));

    typeDeGraineRepository.save(new TypeDeGraine(6L, "Tomate", "description Tomate...", 20, 25, 150.0f, 100.0f, "conseils Tomate...", famille3));
    typeDeGraineRepository.save(new TypeDeGraine(7L, "Poivron", "description Poivron...", 20, 25, 120.0f, 80.0f, "conseils Poivron...", famille3));  }
}
