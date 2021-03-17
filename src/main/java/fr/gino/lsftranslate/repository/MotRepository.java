package fr.gino.lsftranslate.repository;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.model.Mot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotRepository extends PagingAndSortingRepository<Mot, Integer> {
    List<Mot> findMotByGenreId(int genre_id);

    Page<Mot> findAll(Pageable pageable);
    List<Mot> findAll();

    @Query("From Mot b WHERE b.ortho=:searchText OR b.lemme=:searchText")
    Page<Mot> findAll(Pageable pageable, String searchText);
}
