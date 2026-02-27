package com.example.allTheMethods.utils;

import com.example.allTheMethods.entity.Users;
import com.example.allTheMethods.repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public class JWTUtil {
    private final UsersRepository usersRepository;
    private Key getSigninngKey(){
        byte[] keyBytes = Decoders.BASE64.decode("413F4455646B4545543265464534890489438904832904389048239043940389043V");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public JWTUtil(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSigninngKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigninngKey(), SignatureAlgorithm.HS256).compact();
    }
    public String generateToken(UserDetails userDetails, Long userId){
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userDetails.getUsername());
        claims.put("userId", userId);
        return generateToken(claims, userDetails);
    }

    public Users getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Users user = (Users) authentication.getPrincipal();
            Optional<Users> optionalUsers = usersRepository.findById(user.getId());
            return optionalUsers.orElse(null);
        }
        return null;
    }
}
