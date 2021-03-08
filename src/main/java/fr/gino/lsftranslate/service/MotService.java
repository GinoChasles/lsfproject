package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Mot;

import java.util.Optional;

public interface MotService {
    Optional<Mot> findById(long id);
}
