package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Sign;
import fr.gino.lsftranslate.repository.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    SignRepository signRepository;

    @Override
    public Optional<Sign> findById(int id) {
        return signRepository.findById(id);
    }
}
