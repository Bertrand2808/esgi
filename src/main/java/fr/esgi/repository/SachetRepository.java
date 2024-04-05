package fr.esgi.repository;

import java.util.List;

import fr.esgi.business.TypeDeGraine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.esgi.business.Sachet;

public interface SachetRepository extends JpaRepository<Sachet, Long> {
  @Query("SELECT s FROM Sachet s WHERE s.id NOT IN (SELECT ls.id FROM LigneCommande lc JOIN sachets ls)")
  List<Sachet> findSachetNotInLigneCommande();

  @Query("SELECT s FROM Sachet s JOIN LigneCommande l ORDER BY l.quantite DESC")
  List<Sachet> findSachetsOrderedByQuantityDesc();

  @Query("SELECT DISTINCT s.typeDeGraine FROM Sachet s")
  List<Object[]> findAllSachetsRaw();
}
