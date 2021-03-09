package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.CatGram;
import fr.gino.lsftranslate.repository.CatGramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatGramServiceImpl implements CatGramService {
    @Autowired
    CatGramRepository catGramRepository;

    @Override
    public Optional<CatGram> findById(int id) {
        return catGramRepository.findById(id);
    }
}
