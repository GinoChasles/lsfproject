package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.model.Genre;
import fr.gino.lsftranslate.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("dico/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Genre>> findById(@PathVariable(value = "id") int id){
        Optional<Genre> genre;
        try {
            genre = genreService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(genre);
    }

    @GetMapping
    public ResponseEntity<List<Genre>> findAll(){
        List<Genre> list;
        try {
            list = genreService.findAll();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        return ResponseEntity.ok().body(genreService.insert(genre));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    ResponseEntity<Genre> updateGenre(@PathVariable(value = "id") int id, @RequestBody Genre genre){
        Genre updateGenre = genreService.update(id, genre);
        if(updateGenre == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updateGenre);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    ResponseEntity<Genre> deleteGenre(@PathVariable(value="id") int id){
        Optional<Genre> genre = genreService.findById(id);
        if(genre.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        genreService.delete(genre.get().getId());
        return ResponseEntity.accepted().build();
    }
}
