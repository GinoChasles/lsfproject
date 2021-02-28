package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Word;

import java.util.List;

public interface WordService {
    List<Word> findById(long id);
}
