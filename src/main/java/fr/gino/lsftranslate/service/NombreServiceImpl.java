package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.repository.NombreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NombreServiceImpl implements NombreService{
    @Autowired
    NombreRepository repository;
}