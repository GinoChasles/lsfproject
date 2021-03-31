package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.model.Letter;
import fr.gino.lsftranslate.model.Sign;
import fr.gino.lsftranslate.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/dico/alphabet")
public class SignController {
    @Autowired
    SignService signService;

    @GetMapping("/sign/{id}")
    public ResponseEntity<Optional<Sign>> findById(@PathVariable(value = "id") int id){
        Optional<Sign> sign;
        try {
            sign = signService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sign);
    }

}
