package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Lettre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettreRepository extends JpaRepository<Lettre, Integer> {
}
