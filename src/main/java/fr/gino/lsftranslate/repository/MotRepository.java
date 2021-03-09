package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Mot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MotRepository extends JpaRepository<Mot, Integer> {
    List<Mot> findAllById(int id, Pageable pageable);
}
