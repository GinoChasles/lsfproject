package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findWordByGenderId(int genre_id);

    Page<Word> findAll(Pageable pageable);

    @Query("From Word b WHERE b.spelling=:searchText OR b.lemma=:searchText")
    Page<Word> findAllWordsBySpellingOrLemma(Pageable pageable, String searchText);


}
