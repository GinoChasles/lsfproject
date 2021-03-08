package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Word;
import fr.gino.lsftranslate.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService{
    @Autowired
    WordRepository wordRepository;

    @Override
    public Optional<Word> findById(long id) {
        return wordRepository.findById(id);
    }
}
