//package com.myproj.JobCrud.security;
//
//import java.util.Date;
//
//
//import javax.crypto.SecretKey;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//@Service
//public class JwtProvider {
//	SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
//	
//	public String generateToken(Authentication auth) {
//		String jwt=Jwts.builder()
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(new Date().getTime()+846000000))
//				.claim("email",auth.getName())
//				.signWith(key).compact();
//		
//		return jwt;
//				
//	}
//	
//	public String getEmailFromToken(String jwt) {
//		jwt=jwt.substring(7);
//		
//		Claims claims=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
//		String email=String.valueOf(claims.get("email"));
//		
//		return email;
//	}
//	
//	
//	 public boolean validateToken(String token)  {
//	        try {
//	            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//	            return true;
//	        } catch (ExpiredJwtException ex) {
//	            System.out.println("Token expired");
//	        } catch (Exception ex) {
//	            System.out.println("Invalid signature");
//	        }
//	        return false;
//	    }
//
//}
//
//


package com.myproj.JobCrud.security;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
    private final SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 846000000))
                .claim("email", auth.getName())
                .claim("authorities", String.join(",", auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toArray(String[]::new)))
                .signWith(null, key)
                .compact();

        return jwt;
    }

    public String getEmailFromToken(String jwt) {
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }
        
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        
        return claims.get("email", String.class);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            System.out.println("Token expired");
        } catch (Exception ex) {
            System.out.println("Invalid signature");
        }
        return false;
    }
}
