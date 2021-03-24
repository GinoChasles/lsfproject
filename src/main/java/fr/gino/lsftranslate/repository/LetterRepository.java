package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Integer> {
}
