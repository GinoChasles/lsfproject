package fr.gino.lsftranslate.service;

import fr.gino.lsftranslate.model.Word;
import fr.gino.lsftranslate.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    WordRepository wordRepository;

    @Override
    public Optional<Word> findById(int id) {
        return wordRepository.findById(id);
    }

    @Override
    public Word insert(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word delete(int id) {
    Optional<Word> mot = this.findById(id);
    if(mot.isPresent()){
    wordRepository.delete(mot.get());
    }
        return null;
    }

    @Override
    public Word update(int id, Word word) {
        Optional<Word> optionalMot = this.findById(id);

        if(optionalMot.isPresent()) {
            Word wordToUpdate = optionalMot.get();
            wordToUpdate.setSpelling(word.getSpelling());
            wordToUpdate.setLemma(word.getLemma());
            wordToUpdate.setInfover(word.getInfover());
            wordToUpdate.setNbletters(word.getNbletters());
            wordToUpdate.setNbsyll(word.getNbsyll());
            wordToUpdate.setReverspel(word.getReverspel());
            wordToUpdate.setVideo(word.getVideo());
            wordToUpdate.setCatgram(word.getCatgram());
            wordToUpdate.setGender(word.getGender());
            wordToUpdate.setNumber(word.getNumber());
            return wordRepository.save(wordToUpdate);
        }
        return null;
    }


    @Override
    public List<Word> findWordByGenderId(int genre_id) {
        return wordRepository.findWordByGenderId(genre_id);
    }

    @Override
    public Page<Word> findAll(Pageable pageable) {
        return wordRepository.findAll(pageable);
    }

    @Override
    public Page<Word> findAllWordsBySpellingOrLemma(Pageable pageable, String searchText) {
        return wordRepository.findAllWordsBySpellingOrLemma(pageable, searchText);
    }

}
