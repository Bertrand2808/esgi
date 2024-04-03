package fr.esgi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.business.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
  @Query("SELECT r FROM Recette r JOIN TypeDeGraine t GROUP BY r.id ORDER BY COUNT(DISTINCT t.nom) DESC")
  List<Recette> findRecettesOrderedByNumberOfGraineTypes();
}
