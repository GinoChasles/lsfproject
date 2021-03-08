package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Signe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SigneRepository extends JpaRepository<Signe, Long> {
}
