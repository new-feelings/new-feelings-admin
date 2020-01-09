package org.feelings.auth.auth;

import org.apache.commons.codec.binary.StringUtils;
import org.feelings.auth.config.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author lyq on 2019-12-27 4:41 下午
 * @desc 自定义认证逻辑
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AuthService authService;
    @Autowired
    CustomPasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String)authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = authService.loadUserByUsername(username);
        if (!StringUtils.equals(encoder.encode(password), userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误！");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
