package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Lettre;
import fr.gino.lsftranslate.repository.LettreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LettreServiceImpl implements LettreService{
    @Autowired
    LettreRepository lettreRepository;

    @Override
    public Optional<Lettre> findById(long id) {
        return lettreRepository.findById(id);
    }
}
