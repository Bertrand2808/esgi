package fr.esgi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.business.Sachet;

public interface SachetRepository extends JpaRepository<Sachet, Long> {
  @Query("SELECT s FROM Sachet s WHERE s.id NOT IN (SELECT ls.id FROM LigneCommande lc JOIN lc.sachets ls)")
  List<Sachet> findSachetNotInLigneCommande();

  @Query("SELECT s FROM Sachet s JOIN s.commandes c ORDER BY c.quantite DESC")
  List<Sachet> findSachetsOrderedByQuantityDesc();
}
