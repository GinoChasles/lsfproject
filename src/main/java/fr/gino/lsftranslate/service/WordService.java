package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Word;

import java.util.List;
import java.util.Optional;

public interface WordService {
    Optional<Word> findById(long id);
}
