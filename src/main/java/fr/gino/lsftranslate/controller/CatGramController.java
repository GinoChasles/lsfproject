package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.CatGram;
import fr.gino.lsftranslate.service.CatGramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/dico/catgram")
public class CatGramController {
    @Autowired
    CatGramService catGramService;

    @GetMapping("/{id}")
    ResponseEntity<Optional<CatGram>> findById(@PathVariable(value="id")int id){
        Optional<CatGram> catGram;
        try {
            catGram = catGramService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(catGram);
    }
}
