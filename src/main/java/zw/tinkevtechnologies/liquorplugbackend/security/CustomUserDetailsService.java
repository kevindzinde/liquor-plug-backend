package zw.tinkevtechnologies.liquorplugbackend.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.service.api.UserService;
import zw.tinkevtechnologies.liquorplugbackend.utils.SecurityUtils;
import java.util.Arrays;
import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userService.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));
        List<GrantedAuthority> authorities = Arrays.asList(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
