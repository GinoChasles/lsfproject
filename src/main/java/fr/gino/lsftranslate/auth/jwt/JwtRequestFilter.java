package fr.gino.lsftranslate.auth.jwt;

import fr.gino.lsftranslate.auth.User.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Filtre appelé avant chanque requête pour vérifier la fiabilité du jeton jwt
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    String ERROR_TOKEN_NULL = "Unable to get JWT Token";
    String ERROR_TOKEN_EXPIRED = "JWT Token has expired";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Récupération du token d'authentification  dans les cookies
        String token = getAuthorizationToken(request.getCookies());

        if(token == null) {
            chain.doFilter(request, response);
            return;
        }


        // On valide le jeton et on réauthentifie l'utilisateur dans le contexte
        validateTokenAndAuthorizeUser(jwtTokenService.removeBearer(token));

        chain.doFilter(request, response);
    }

    /**
     * Récupère le jeton dans les cookies de la requête
     * @param cookies les cookies de la requête
     * @return le jeton récupéré
     * @throws UnsupportedEncodingException Exception lancée en cas de mauvais encodage
     */
    private String getAuthorizationToken(Cookie[] cookies) throws UnsupportedEncodingException {
        String token = null;

        if (cookies != null){
            for (Cookie ck : cookies) {
                if ("Authorization".equals(ck.getName())) {
                    token = URLDecoder.decode(ck.getValue(), StandardCharsets.UTF_8.name());
                }
            }
        }
        return token;
    }

    /**
     * Récupère le username de l'utilisateur dnas le token
     * @param token le token où puiser le username
     * @return le username
     */
    private String getUsernameFromToken(String token){
        String username = null;

            try {
                username =  jwtTokenService.getUsernameFromToken(jwtTokenService.removeBearer(token));
            } catch (IllegalArgumentException e) {
                logger.warn(ERROR_TOKEN_NULL);
            } catch (ExpiredJwtException e) {
                logger.warn(ERROR_TOKEN_EXPIRED);
            }

        return username;
    }

    /**
     * Récupère le username dans le token, cherche l'utilisateur dnas la base de données depuis son username.
     * On valide le token en comparant le token et l'utilisateur
     * On réauthentifit l'utilisateur dans le contexte
     * @param token le jeton à valider
     */
    private void validateTokenAndAuthorizeUser(String token){

        String username = getUsernameFromToken(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = this.userService.loadUserByUsername(username);

            /* Comme je n'ai plus le mot de passe pour le usernamePasswordToken, spring security ne vérifie plus si l'utilisateur est disabled
             * Du coup on bloque l'authentification si l'utilisateur est disabled()
             * */
            if (jwtTokenService.validateToken(token, user)) {
                jwtTokenService.authenticate(user);
            }
        }
    }
}