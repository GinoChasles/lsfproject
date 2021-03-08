package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.CatGramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatGramServiceImpl implements CatGramService {
    @Autowired
    CatGramRepository catGramRepository;
}
