package fr.esgi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.esgi.business.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
  @Query("SELECT c FROM Commande c WHERE c.dateHeureDEnvoi BETWEEN :startDate AND :endDate")
  List<Commande> findByDateHeureDEnvoiBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

  @Query("SELECT c FROM Commande c JOIN c.lignesCommande l GROUP BY c.id ORDER BY SUM(l.quantite * l.prixUnitaire) DESC")
  List<Commande> findCommandesOrderedByTotalAmountDesc();

  @Query("SELECT MONTH(c.dateHeureDEnvoi) AS month, COUNT(c) FROM Commande c GROUP BY month")
  List<Object[]> findNumberOfCommandesPerMonth();
}
