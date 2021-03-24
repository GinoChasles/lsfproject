package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Letter;
import fr.gino.lsftranslate.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LetterServiceImpl implements LetterService {
    @Autowired
    LetterRepository letterRepository;

    @Override
    public Optional<Letter> findById(int id) {
        return letterRepository.findById(id);
    }
}
