package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Lettre;
import fr.gino.lsftranslate.model.Mot;
import fr.gino.lsftranslate.service.LettreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dico/alphabet")
@CrossOrigin
public class LettreController {
    @Autowired
    LettreService lettreService;
    @GetMapping("lettre/{id}")
    public ResponseEntity<Optional<Lettre>> findById(@PathVariable(value = "id") int id){
        Optional<Lettre> lettre;
        try {
            lettre = lettreService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lettre);
    }

    @RequestMapping("/")
    public String test(){
        return "test lettre";
    }
}
