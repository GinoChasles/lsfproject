package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.model.Mot;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findById(int id);
    Genre insert(Genre genre);
    Genre update(int id,Genre genre);
    Genre delete(int id);
    List<Genre> findAll();
//    List<Mot> findAllMotsByGenre(Genre genre);

}
