package zw.tinkevtechnologies.liquorplugbackend.security.jwt.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import zw.tinkevtechnologies.liquorplugbackend.security.jwt.api.JwtProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;

    private static final List<String> AUTH_WHITELIST = Arrays.asList(
            "/api/authentication/sign-in",
            "/api/authentication/sign-up",
            "/index.html","/v2/api-docs",
            "/swagger-resources/**","/swagger-ui.html","/webjars/**","/swagger-resources/**",
            "/api/product/get-all-products",
            "/api/cart/**",
            "/api/delivery/**",
            "/api/cart/save",
            "/api/cart/user"

    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getRequestURI();

        // Skip authorization for whitelisted endpoints
        if (AUTH_WHITELIST.contains(requestPath)) {
            filterChain.doFilter(request, response);
            return;
        }

        Authentication authentication = jwtProvider.getAUthentication(request);
        if(authentication!=null && jwtProvider.validateToken(request)){
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        filterChain.doFilter(request,response);

    }
}
