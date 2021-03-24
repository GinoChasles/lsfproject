package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Letter;
import fr.gino.lsftranslate.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dico/alphabet")
@CrossOrigin
public class LetterController {
    @Autowired
    LetterService letterService;
    @GetMapping("letter/{id}")
    public ResponseEntity<Optional<Letter>> findById(@PathVariable(value = "id") int id){
        Optional<Letter> letter;
        try {
            letter = letterService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(letter);
    }


}
