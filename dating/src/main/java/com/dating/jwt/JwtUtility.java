package com.dating.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
public class JwtUtility implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtility.class);
    private String jwtSecret = "nothing";

    public String JwtTokenGenerator(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + (60 * 60 * 24 * 30)))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
}
