package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Word;
import fr.gino.lsftranslate.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dico")
public class WordController {
    @Autowired
    WordService wordService;

    @CrossOrigin
    @GetMapping("words/{id}")
    public ResponseEntity<Optional<Word>> findById(@PathVariable(value = "id") int id){
        Optional<Word> word;
        try {
            word = wordService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(word);
    }

    @CrossOrigin
    @GetMapping("words/")
    public ResponseEntity<Page<Word>> findAll(Pageable pageable){
        Page<Word> page = wordService.findAll(pageable);

        return ResponseEntity.ok().body(page);
    }
    @CrossOrigin
    @GetMapping("words/search/{searchText}")
    public ResponseEntity<Page<Word>> findAllWordsBySpellingOrLemma(Pageable pageable, @PathVariable(value="searchText") String searchText){
        Page<Word> page = wordService.findAllWordsBySpellingOrLemma(pageable, searchText);

        return ResponseEntity.ok().body(page);
    }

    @CrossOrigin
    @GetMapping("words/gender/{id}")
    public ResponseEntity<List<Word>> findWordByGenderId(@PathVariable(value = "id") int id){
        List<Word> word;
        try {
            word = wordService.findWordByGenderId(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(word);
    }



    @CrossOrigin
    @PostMapping("/words")
    public ResponseEntity<Word> addMot(@Valid @RequestBody Word word){
        return ResponseEntity.ok().body(wordService.insert(word));
    }

    @CrossOrigin
    @PutMapping("/words/{id}")
    ResponseEntity<Word> updateMot(@PathVariable(value = "id") int id, @Valid @RequestBody Word word){
        Word updateWord = wordService.update(id, word);
        if(updateWord == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updateWord);
    }

    @CrossOrigin
    @DeleteMapping("words/{id}")
    ResponseEntity<Word> deleteMot(@PathVariable(value="id") int id){
        Optional<Word> mot = wordService.findById(id);
        if(mot.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        wordService.delete(mot.get().getId());
        return ResponseEntity.accepted().build();
    }

}
