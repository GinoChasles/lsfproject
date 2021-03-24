package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {
    @Autowired
    NumberRepository repository;
}
