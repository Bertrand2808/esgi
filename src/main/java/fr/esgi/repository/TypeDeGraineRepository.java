package fr.esgi.repository;

import fr.esgi.business.TypeDeGraine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeDeGraineRepository extends JpaRepository<TypeDeGraine, Long> {
  @Query("SELECT t FROM TypeDeGraine t WHERE WEEK(CURRENT_DATE()) BETWEEN t.semaineDePlantationMin AND t.semaineDePlantationMax")
  List<TypeDeGraine> findGrainesToPlantToday();

  @Query("SELECT t FROM TypeDeGraine t WHERE t.famille.nom = ?1")
  List<TypeDeGraine> findByFamilleNom(String famille);
}
