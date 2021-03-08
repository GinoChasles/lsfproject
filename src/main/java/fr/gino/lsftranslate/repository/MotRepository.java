package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Mot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotRepository extends JpaRepository<Mot, Integer> {
}
