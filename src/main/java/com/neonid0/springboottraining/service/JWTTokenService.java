package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.User;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Getter
public class JWTTokenService {

//    private final String secretKey = "SecretKey";
    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public String generateToken(User user) {
        Map<String, Objects> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 300))
                .and()
                .signWith(secretKey)
                .compact();
    }

//    public Key getKey() {
//       byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//       return Keys.hmacShaKeyFor(keyBytes);
//    }
}
