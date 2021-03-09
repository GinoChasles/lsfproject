package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Mot;

import java.util.List;
import java.util.Optional;

public interface MotService {
    Optional<Mot> findById(int id);
    Mot insert(Mot mot);
    Mot delete(int id);
    Mot update(int id, Mot mot);
}
