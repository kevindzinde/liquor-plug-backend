package zw.tinkevtechnologies.liquorplugbackend.security.jwt.impl;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import zw.tinkevtechnologies.liquorplugbackend.security.UserPrincipal;
import zw.tinkevtechnologies.liquorplugbackend.security.jwt.api.JwtProvider;
import zw.tinkevtechnologies.liquorplugbackend.utils.SecurityUtils;


import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProviderImpl implements JwtProvider {
    @Value("${app.jwt.secret}")
    private String JWT_SECRET;
    private static final long JWT_EXPIRATION_IN_MS = 86400000;

    @Override
    public String generateToken(UserPrincipal auth) {
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        Date now = new Date();
        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration( new Date(now.getTime() + JWT_EXPIRATION_IN_MS))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }
    @Override
    public Authentication getAUthentication(HttpServletRequest request) {
        Claims claims = extractClaims(request);
        String username = claims.getSubject();
        Long userId = claims.get("userId",Long.class);
        List<GrantedAuthority> auuthorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertToAuthority)
                .collect(Collectors.toList());
        UserPrincipal userDeatils = UserPrincipal.builder()
                .username(username)
                .id(userId)
                .build();
        if(username == null){
            return null;
        }
        return  new UsernamePasswordAuthenticationToken(userDeatils,null,auuthorities);



    }
    @Override
    public boolean validateToken(HttpServletRequest request){
        Claims claims= extractClaims(request);
        if(claims==null){
            return  false;
        }
        if(claims.getExpiration().before(new Date())){
            return false;
        }
        return true;
    }

    private Claims extractClaims(HttpServletRequest request) {
        String token = SecurityUtils.extractAuthTokenFromRequest(request);
        if (token == null) {
            return null;
        }
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

    }


}
