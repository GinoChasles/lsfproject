package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Letter;

import java.util.Optional;

public interface LetterService {
    Optional<Letter> findById(int id);
}
