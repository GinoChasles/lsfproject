package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Lettre;

import java.util.Optional;

public interface LettreService {
    Optional<Lettre> findById(long id);
}
