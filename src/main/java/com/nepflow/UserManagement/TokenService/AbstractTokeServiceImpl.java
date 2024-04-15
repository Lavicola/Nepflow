package com.nepflow.UserManagement.TokenService;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Model.VerificationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Base64;
import java.util.Date;

public abstract class AbstractTokeServiceImpl implements TokenService {

    public Neo4jRepository repository;

    private String KEY;
    static final SignatureAlgorithm algorithm = SignatureAlgorithm.HS512;
    static final long EXPIRATION_TIME = 864_000_000;

    public AbstractTokeServiceImpl(Neo4jRepository repository, String secret) {
        this.repository = repository;
        this.KEY = Base64.getEncoder()
                .encodeToString(secret.getBytes());
    }


    @Override
    public String generateAndStoreToken(User user) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(expireDate)
                .signWith(algorithm, KEY)
                .compact();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiryDate(expireDate);
        this.repository.save(verificationToken);


        return token;
    }

    @Override
    public boolean isAuthentic(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token).getBody();
        } catch (io.jsonwebtoken.SignatureException e) {
            return false;
        }
        return true;
    }

    public boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token).getBody();

        return new Date(System.currentTimeMillis()).after(claims.getExpiration());

    }

    @Override
    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


}
