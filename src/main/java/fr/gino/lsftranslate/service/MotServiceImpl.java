package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Mot;
import fr.gino.lsftranslate.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotServiceImpl implements MotService {
    @Autowired
    MotRepository motRepository;

    @Override
    public Optional<Mot> findById(int id) {
        return motRepository.findById(id);
    }
}
