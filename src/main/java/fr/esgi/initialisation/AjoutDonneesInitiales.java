package fr.esgi.initialisation;

import fr.esgi.business.*;
import fr.esgi.repository.*;
import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

  private final TypeDeGraineRepository typeDeGraineRepository;
  private final FamilleRepository familleRepository;
  private final UtilisateurRepository utilisateurRepository;
  private final SachetRepository sachetRepository;
  private final JardinierRepository jardinierRepository;
  private final FournisseurRepository fournisseurRepository;

  @Override
  public void run(String... args) throws Exception
  {
    ajouterTypeDeGraine();
    ajouterUtilisateurs();
  }


  private void ajouterTypeDeGraine()
  {
    Famille famille1 = familleRepository.save(new Famille(1L, "Legumes-feuilles", "5F3384"));
    Famille famille2 = familleRepository.save(new Famille(2L, "Legumes-racines", "237D57"));
    Famille famille3 = familleRepository.save(new Famille(3L, "Legumes-fruits", "ABC123"));

    List<TypeDeGraine> graines = new ArrayList<>();

    graines.add(new TypeDeGraine(
            1L,
            "Carotte",
            "Description : La carotte est un légume racine connu pour sa couleur orange et sa richesse en bêta-carotène. Elle nécessite environ 13 à 14 semaines pour atteindre la maturité. Les carottes préfèrent un sol bien drainé et ensoleillé. Conseils de culture : Gardez le sol humide mais pas détrempé. Récoltez lorsque les racines sont fermes et colorées.",
            13,
            14,
            60.0f,
            5.0f,
            "Conseils : Arrosez régulièrement et éclaircissez les plantes pour favoriser le développement des racines.",
            famille1
    ));

    graines.add(new TypeDeGraine(
            2L,
            "Courgette",
            "Description : La courgette est un légume polyvalent appartenant à la famille des cucurbitacées. Elle pousse rapidement et nécessite environ 22 à 23 semaines pour atteindre la maturité. Les courgettes préfèrent un sol riche en matière organique et un arrosage régulier. Conseils de culture : Assurez-vous de récolter les courgettes lorsqu'elles sont jeunes pour une meilleure saveur.",
            22,
            23,
            120.0f,
            75.0f,
            "Conseils : Évitez l'excès d'eau pour prévenir les maladies fongiques.",
            famille1
    ));

    graines.add(new TypeDeGraine(
            3L,
            "Laitue",
            "Description : La laitue est une plante à feuilles vertes ou rouges largement cultivée pour ses feuilles comestibles. Elle pousse rapidement et peut être récoltée en environ 13 à 14 semaines. La laitue préfère un sol frais et un ombrage partiel en été. Conseils de culture : Arrosez régulièrement et évitez les fortes chaleurs pour éviter que la laitue ne monte en graines.",
            13,
            14,
            55.0f,
            25.0f,
            "Conseils : Récoltez les feuilles extérieures au fur et à mesure pour encourager une croissance continue.",
            famille1
    ));

    graines.add(new TypeDeGraine(
            4L,
            "Betterave",
            "Description : La betterave est une racine comestible souvent cultivée pour ses racines sucrées et riches en nutriments. Elle nécessite environ 14 à 16 semaines pour atteindre la maturité. Les betteraves préfèrent un sol bien drainé et riche en matière organique. Conseils de culture : Gardez le sol humide et évitez les sols trop compacts pour une croissance optimale.",
            14,
            16,
            80.0f,
            30.0f,
            "Conseils : Récoltez lorsque les racines atteignent la taille désirée pour une meilleure saveur.",
            famille2
    ));

    graines.add(new TypeDeGraine(
            5L,
            "Radis",
            "Description : Le radis est un légume-racine rapide à cultiver et généralement récolté en 14 à 16 semaines. Il préfère un sol meuble et frais avec un bon drainage. Conseils de culture : Semez régulièrement pour des récoltes échelonnées et arrosez fréquemment pour éviter que les radis ne deviennent piquants.",
            14,
            16,
            45.0f,
            2.5f,
            "Conseils : Récoltez lorsque les radis ont atteint une taille appropriée pour une texture croquante.",
            famille2
    ));

    graines.add(new TypeDeGraine(
            6L,
            "Tomate",
            "Description : La tomate est un fruit-légume populaire, largement cultivé pour sa variété de formes, de couleurs et de saveurs. Elle nécessite environ 20 à 25 semaines pour atteindre la maturité. Les tomates préfèrent un sol bien drainé et un ensoleillement direct. Conseils de culture : Taillez régulièrement pour encourager la croissance verticale et la production de fruits.",
            20,
            25,
            150.0f,
            100.0f,
            "Conseils : Utilisez des tuteurs pour soutenir les plantes et éviter que les fruits ne pourrissent sur le sol.",
            famille3
    ));

    graines.add(new TypeDeGraine(
            7L,
            "Poivron",
            "Description : Le poivron est un légume à fruits colorés, appartenant à la famille des solanacées. Il nécessite environ 20 à 25 semaines pour atteindre la maturité. Les poivrons préfèrent un sol bien drainé et riche en matière organique. Conseils de culture : Fertilisez régulièrement pour favoriser la croissance et la production de fruits.",
            20,
            25,
            120.0f,
            80.0f,
            "Conseils : Taillez les branches indésirables pour concentrer l'énergie de la plante sur la production de fruits.",
            famille3
    ));
    List<TypeDeGraine> savedGraines = typeDeGraineRepository.saveAll(graines);

    List<Sachet> sachets = new ArrayList<>();

    sachets.add(new Sachet(100, 2.5f, savedGraines.get(0))); // Carotte
    sachets.add(new Sachet(150, 3.0f, savedGraines.get(1))); // Courgette
    sachets.add(new Sachet(80, 1.5f, savedGraines.get(2))); // Laitue
    sachets.add(new Sachet(120, 4.0f, savedGraines.get(3))); // Betterave
    sachets.add(new Sachet(90, 2.0f, savedGraines.get(4))); // Radis
    sachets.add(new Sachet(200, 5.0f, savedGraines.get(5))); // Tomate
    sachets.add(new Sachet(180, 4.5f, savedGraines.get(6))); // Poivron

    sachetRepository.saveAll(sachets);
  }

  private void ajouterUtilisateurs()
  {
    Utilisateur user = new Utilisateur(0L, "jean", "jaurès", "jean@wanadoo.fr", new BCryptPasswordEncoder().encode("password"), new ArrayList<LigneCommande>(), "WRITE");
    Utilisateur user2 = new Utilisateur(0L, "jean", "jaurès", "jean2@wanadoo.fr", new BCryptPasswordEncoder().encode("password"), new ArrayList<LigneCommande>(), "JARDINIER");
    Utilisateur user3 = new Utilisateur(0L, "jean", "jaurès", "jean3@wanadoo.fr", new BCryptPasswordEncoder().encode("password"), new ArrayList<LigneCommande>(), "");

    utilisateurRepository.save(user);
    utilisateurRepository.save(user2);
    utilisateurRepository.save(user3);
  }
}
