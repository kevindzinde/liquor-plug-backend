package zw.tinkevtechnologies.liquorplugbackend.security.jwt.api;

import org.springframework.security.core.Authentication;
import zw.tinkevtechnologies.liquorplugbackend.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    Authentication getAUthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
