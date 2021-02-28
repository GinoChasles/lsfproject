package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    public List<Word> findById(long id);
}
