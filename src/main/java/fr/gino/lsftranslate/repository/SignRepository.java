package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<Sign, Integer> {
}
