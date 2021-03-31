package fr.gino.lsftranslate.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.io.Serial;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenService implements Serializable {

    @Serial
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(removeBearer(token), Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(removeBearer(token), Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(removeBearer(token));
        return claimsResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(removeBearer(token)).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(removeBearer(token));
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        String token = doGenerateToken(claims, user.getUsername());
        if (!token.startsWith("Bearer ")) {
            token = "Bearer " + token;
        }
        return token;
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    //validate token
    public Boolean validateToken(String token, UserDetails user) {
        final String username = getUsernameFromToken(removeBearer(token));
        return (username.equals(user.getUsername()) && !isTokenExpired(removeBearer(token)));
    }

    /**
     * Retire le préfixe Bearer du jeton jwt
     * @param token le jeton avec le préfixe
     * @return le jeton sans le préfixe
     */
    public String removeBearer(String token){
        if(token != null){

        token = URLDecoder.decode(token, StandardCharsets.UTF_8);
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        }

        return token;
    }

    public Cookie generateCookie(UserDetails user) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie("Authorization", URLEncoder.encode(generateToken(user), StandardCharsets.UTF_8.toString()));
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(370000000);
        return cookie;
    }

    public void authenticate(UserDetails user){
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}