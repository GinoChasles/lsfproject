package fr.gino.lsftranslate.controller;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @RequestMapping(value = "mots", method = RequestMethod.GET)





    @CrossOrigin
    @PostMapping("/mots")
    public ResponseEntity<Mot> addMot(@RequestBody Mot mot){
        return ResponseEntity.ok().body(motService.insert(mot));
    }

    @CrossOrigin
    @PutMapping("/mots/{id}")
    ResponseEntity<Mot> updateFruit(@PathVariable(value = "id") int id, @RequestBody Mot mot){
        Mot updateMot = motService.update(id, mot);
        if(updateMot == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updateMot);
    }

    @CrossOrigin
    @DeleteMapping("mots/{id}")
    ResponseEntity<Mot> deleteMot(@PathVariable(value="id") int id){
        Optional<Mot> mot = motService.findById(id);
        if(mot.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        motService.delete(mot.get().getId());
        return ResponseEntity.accepted().build();
    }

@RequestMapping("/")
    public String test(){
        return "test";
}
}
