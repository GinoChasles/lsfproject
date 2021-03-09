package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.CatGram;

import java.util.Optional;

public interface CatGramService {
    Optional<CatGram> findById(int id);
}
