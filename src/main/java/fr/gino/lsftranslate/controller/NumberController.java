package fr.gino.lsftranslate.controller;

import fr.gino.lsftranslate.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/dico/number")
public class NumberController {
    @Autowired
    NumberService numberService;
}