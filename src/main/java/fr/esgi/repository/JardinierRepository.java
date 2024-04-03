package fr.esgi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.business.Jardinier;

public interface JardinierRepository extends JpaRepository<Jardinier, Long> {
  // @Query("SELECT j FROM Jardinier j JOIN j.commandes c JOIN c.recettes r WHERE r.nom = 'basilic'")
  // List<Jardinier> findJardiniersWhoOrderedBasil();

  @Query("SELECT j FROM Jardinier j JOIN j.commandes c GROUP BY j.id ORDER BY COUNT(c) DESC")
  List<Jardinier> findJardiniersOrderedByNumberOfCommandesDesc();

  @Query("SELECT j FROM Jardinier j WHERE YEAR(CURRENT_DATE()) - YEAR(j.dateDeNaissance) >= 60")
  List<Jardinier> findJardiniersOver60();
}
