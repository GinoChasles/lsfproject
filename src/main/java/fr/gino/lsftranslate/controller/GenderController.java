package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Gender;
import fr.gino.lsftranslate.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("dico/genders")
public class GenderController {
    @Autowired
    GenderService genderService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Gender>> findById(@PathVariable(value = "id") int id){
        Optional<Gender> genre;
        try {
            genre = genderService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(genre);
    }

    @GetMapping
    public ResponseEntity<List<Gender>> findAll(){
        List<Gender> list;
        try {
            list = genderService.findAll();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Gender> addGenre(@RequestBody Gender gender){
        return ResponseEntity.ok().body(genderService.insert(gender));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    ResponseEntity<Gender> updateGenre(@PathVariable(value = "id") int id, @RequestBody Gender gender){
        Gender updateGender = genderService.update(id, gender);
        if(updateGender == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updateGender);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    ResponseEntity<Gender> deleteGenre(@PathVariable(value="id") int id){
        Optional<Gender> genre = genderService.findById(id);
        if(genre.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        genderService.delete(genre.get().getId());
        return ResponseEntity.accepted().build();
    }
}
