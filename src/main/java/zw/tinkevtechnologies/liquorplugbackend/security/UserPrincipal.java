package zw.tinkevtechnologies.liquorplugbackend.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zw.tinkevtechnologies.liquorplugbackend.model.User;
import zw.tinkevtechnologies.liquorplugbackend.utils.SecurityUtils;
import zw.tinkevtechnologies.liquorplugbackend.utils.enums.Role;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal  implements UserDetails {
    private Long id;
    private String username;

    transient  private String password; // do not show up on an searilized places
    transient  private User user; //user for only login operations , dont use in jwt

    public static UserPrincipal createSuperUser(){
        List<GrantedAuthority> authorities = Arrays.asList(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));
        return UserPrincipal.builder()
                .id(-1L)
                .username("system-administrator")
                .authorities(authorities)
                .build();
    }
    private List<GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
