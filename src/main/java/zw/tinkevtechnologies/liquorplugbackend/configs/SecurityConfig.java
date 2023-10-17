package zw.tinkevtechnologies.liquorplugbackend.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zw.tinkevtechnologies.liquorplugbackend.security.CustomUserDetailsService;
import zw.tinkevtechnologies.liquorplugbackend.security.jwt.filter.JwtAuthorizationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable();
       http.cors();
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.authorizeRequests()
               .antMatchers("/index.html","/v2/api-docs","/api/v1/user-service/sign-in/**","/api/v1/user-service/sign-up/**",
                       "/swagger-ui.html",
                       "/v2/api-docs",
                       "/configuration/ui",
                       "/swagger-resources/**",
                       "/configuration/security",
                       "/swagger-ui.html",
                       "/swagger-ui/**",
                       "/webjars/**",
                       "/v2/**").permitAll()
               .antMatchers("api/product/save/**","api/product/delete/**","/api/product/product/**").hasRole("ADMIN")
               .anyRequest().authenticated();
       http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(){
        return  new JwtAuthorizationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}
