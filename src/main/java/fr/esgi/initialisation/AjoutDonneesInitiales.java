package fr.esgi.initialisation;

import fr.esgi.business.TypeDeGraine;
import fr.esgi.repository.TypeDeGraineRepository;
import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

  private final TypeDeGraineRepository typeDeGraineRepository;


  @Override
  public void run(String... args) throws Exception {
    ajouterTypeDeGraine();
  }

  private void ajouterTypeDeGraine() {
    typeDeGraineRepository.save(new TypeDeGraine(1L, "Carotte", 13, 14, 60.0f, 5.0f));
    typeDeGraineRepository.save(new TypeDeGraine(2L, "Courgette", 22, 23, 120.0f, 75.0f));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Haricot", 22, 23, 100.0f, 15.0f));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Laitue Pommée", 13, 14, 55.0f, 25.0f));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Oignon", 14, 14, 40.0f, 8.0f));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Radis", 14, 16, 45.0f, 2.5f));
    typeDeGraineRepository.save(new TypeDeGraine(3L, "Tomate", 21, 24, 90.0f, 80.0f));
  }
}
