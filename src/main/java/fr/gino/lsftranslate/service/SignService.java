package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Sign;

import java.util.Optional;

public interface SignService {
    Optional<Sign> findById(int id);
}
