package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Word;
import fr.gino.lsftranslate.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dico")
public class WordController {
    @Autowired
    WordService wordService;

    @CrossOrigin
    @GetMapping("mots/{id}")
    public ResponseEntity<Optional<Word>> findById(@PathVariable(value = "id") long id){
        Optional<Word> wordList;
        try {
            wordList = wordService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(wordList);
    }


@RequestMapping("/")
    public String test(){
        return "test";
}
}
