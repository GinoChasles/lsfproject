package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.service.SigneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/dico/alphabet/signe")
public class SigneController {
    @Autowired
    SigneService signeService;


    @RequestMapping("/")
    public String test(){
        return "test signe";
    }
}
