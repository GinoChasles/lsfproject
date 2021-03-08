package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.SigneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SigneServiceImpl implements SigneService{
    @Autowired
    SigneRepository signeRepository;
}
