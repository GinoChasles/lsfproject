package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    SignRepository signRepository;
}
