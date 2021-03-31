package fr.gino.lsftranslate.auth.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.insert(user));
    }
}
