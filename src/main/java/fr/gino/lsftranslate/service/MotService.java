package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.model.Mot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MotService {
    Optional<Mot> findById(int id);
    Mot insert(Mot mot);
    Mot delete(int id);
    Mot update(int id, Mot mot);

    List<Mot> findMotByGenreId(int genre_id);
    Page<Mot> findAll(Pageable pageable);
    Page<Mot> findAllMotsByOrthoOrLemme(Pageable pageable, String searchText);
}
