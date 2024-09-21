package com.example.demo.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
public class JwtUtils {

    public static final String JWT_BEARER = "Bearer "; // Pré-fixo do token
    public static final String JWT_AUTHORIZATION = "Authorization"; //valor do header
    public static final String SECRET_KEY = "a38ea1685bcaa9b816bf942227a71bec"; // chave secreta
    public static final long EXPIRE_DAYS = 0; //variaveis long para definir tempo de expiração do token
    public static final long EXPIRE_HOURS = 0;
    public static final long EXPIRE_MINUTES = 2;

    private JwtUtils() {
    }

    /*
    * This method is responsable to cripto your secret key and return the value
    * */
    private static Key generateKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private static Date toExpireDays(Date start) {
        LocalDateTime localDateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return null;
    }
}
