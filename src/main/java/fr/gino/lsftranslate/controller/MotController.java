package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Mot;
import fr.gino.lsftranslate.service.MotService;
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

    @CrossOrigin
    @GetMapping("mots/")
    public ResponseEntity<Page<Mot>> findAll(Pageable pageable){
        Page<Mot> page = motService.findAll(pageable);

        return ResponseEntity.ok().body(page);
    }
    @CrossOrigin
    @GetMapping("mots/search/{searchText}")
    public ResponseEntity<Page<Mot>> findAllMotsByOrthoOrLemme(Pageable pageable, @PathVariable(value="searchText") String searchText){
        Page<Mot> page = motService.findAllMotsByOrthoOrLemme(pageable, searchText);

        return ResponseEntity.ok().body(page);
    }

    @CrossOrigin
    @GetMapping("mots/genre/{id}")
    public ResponseEntity<List<Mot>> findMotByGenreId(@PathVariable(value = "id") int id){
        List<Mot> mot;
        try {
            mot = motService.findMotByGenreId(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(mot);
    }



    @CrossOrigin
    @PostMapping("/mots")
    public ResponseEntity<Mot> addMot(@Valid @RequestBody Mot mot){
        return ResponseEntity.ok().body(motService.insert(mot));
    }

    @CrossOrigin
    @PutMapping("/mots/{id}")
    ResponseEntity<Mot> updateMot(@PathVariable(value = "id") int id,@Valid @RequestBody Mot mot){
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

}
