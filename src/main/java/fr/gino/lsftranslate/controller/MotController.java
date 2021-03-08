package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Mot;
import fr.gino.lsftranslate.service.MotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dico")
public class MotController {
    @Autowired
    MotService motService;

    @CrossOrigin
    @GetMapping("mots/{id}")
    public ResponseEntity<Optional<Mot>> findById(@PathVariable(value = "id") int id){
        Optional<Mot> mot;
        try {
            mot = motService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(mot);
    }


@RequestMapping("/")
    public String test(){
        return "test";
}
}
