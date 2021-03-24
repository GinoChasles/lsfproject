package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Gender;
import fr.gino.lsftranslate.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    GenderRepository genderRepository;

    @Override
    public Optional<Gender> findById(int id) {
        return genderRepository.findById(id);
    }

    @Override
    public Gender insert(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Gender update(int id, Gender gender) {
        Optional<Gender> optionalGenre = this.findById(id);

        if(optionalGenre.isPresent()){
            Gender genderToUpdate = optionalGenre.get();
            genderToUpdate.setName(gender.getName());
            genderToUpdate.setId(gender.getId());
            return genderRepository.save(genderToUpdate);
        }
        return null;
    }

    @Override
    public Gender delete(int id) {
        Optional<Gender> genre = this.findById(id);
        if(genre.isPresent()){
            genderRepository.delete(genre.get());
        }
        return null;
    }

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }
}
