package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    Optional<Gender> findById(int id);
    Gender insert(Gender gender);
    Gender update(int id, Gender gender);
    Gender delete(int id);
    List<Gender> findAll();
//    List<Mot> findAllMotsByGenre(Genre genre);

}
