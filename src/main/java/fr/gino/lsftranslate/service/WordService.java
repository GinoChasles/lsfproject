package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface WordService {
    Optional<Word> findById(int id);
    Word insert(Word word);
    Word delete(int id);
    Word update(int id, Word word);

    List<Word> findWordByGenderId(int genre_id);
    Page<Word> findAll(Pageable pageable);
    Page<Word> findAllWordsBySpellingOrLemma(Pageable pageable, String searchText);
}
