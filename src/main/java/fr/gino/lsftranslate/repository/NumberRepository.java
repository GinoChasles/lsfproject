package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<Number, Integer> {
}
