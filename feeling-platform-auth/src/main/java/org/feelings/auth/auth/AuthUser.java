package org.feelings.auth.auth;

import org.feelings.auth.base.entity.Role;
import org.feelings.auth.base.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lyq on 2019-12-26 4:45 下午
 * @desc
 */
public class AuthUser extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        List<Role> roles = getRoles();
        roles.forEach(role -> {
            list.add(new SimpleGrantedAuthority(role.getCode()));
            role.getPermissions().forEach(permission -> {
                list.add(new SimpleGrantedAuthority(permission.getCode()));
            });
        });
        return list;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getPassword();
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
