package com.nujabness.katawemanity.services.authentification.provider;


import com.nujabness.katawemanity.services.authentification.CustomUserDetailsService;
import com.nujabness.katawemanity.services.exception.InvalidJwtAuthenticationException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Value("${authentification.security.jwtSecret}")
    private String jwtSecret;

    @Value("${authentification.security.validityInMilliseconds}")
    private long validityInMilliseconds ;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    public String createToken(String codeOperateur, List<String> roles) {

        Claims claims = Jwts.claims().setSubject(codeOperateur);
        claims.put("auth", "role");
        Date now = new Date();
        Date jwtExpiration = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(codeOperateur)
                .setIssuedAt(new Date())
                .setExpiration(jwtExpiration)
                .signWith(SignatureAlgorithm.HS512 , jwtSecret)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);

            boolean isValid = true;
            
            if (claims.getBody().getExpiration().before(new Date())) {
                isValid = false;
            }

            return isValid;
            
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }
}
