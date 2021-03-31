package fr.gino.lsftranslate.auth.authentification;

import fr.gino.lsftranslate.auth.ApplicationSecurityConfig;
import fr.gino.lsftranslate.auth.Role.Role;
import fr.gino.lsftranslate.auth.User.User;
import fr.gino.lsftranslate.auth.User.UserService;
import fr.gino.lsftranslate.auth.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenService jwtTokenService;


    @PostMapping("/login")
    public ResponseEntity<Collection<? extends GrantedAuthority>> login(@RequestBody User user, HttpServletResponse response) throws UnsupportedEncodingException {
        UserDetails loadUser = userService.loadUserByUsername(user.getUsername());
        if (loadUser == null) {
            return ResponseEntity.notFound().build();
        }
        boolean matches = ApplicationSecurityConfig.getPasswordEncoder().matches(user.getPassword(), loadUser.getPassword());
        if (!matches) {
            return ResponseEntity.notFound().build();
        }
        response.addCookie(jwtTokenService.generateCookie(loadUser));
        return ResponseEntity.ok(loadUser.getAuthorities());
    }

}
