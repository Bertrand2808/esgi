package fr.esgi.repository;

import fr.esgi.business.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille,Long> {
}
