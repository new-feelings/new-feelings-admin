package org.feelings.auth.config;

import org.feelings.auth.auth.AuthService;
import org.feelings.auth.auth.CustomAuthenticationEntryPoint;
import org.feelings.auth.auth.CustomAuthenticationProvider;
import org.feelings.auth.auth.CustomLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyq on 2019-12-26 3:35 下午
 * @desc 安全配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomAuthenticationEntryPoint entryPoint;
    @Autowired
    CustomAuthenticationProvider provider;
    @Autowired
    AuthService authService;
    @Autowired
    CustomPasswordEncoder encoder;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public LogoutHandler logoutHandler(){
        return new CustomLogoutHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatcher(new OAuth2RequestMatcher())
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and().logout().logoutUrl("/oauth/logout").addLogoutHandler(logoutHandler())
                .and().authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    /**
     * 创建认证管理：AuthenticationManager
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
        auth.userDetailsService(authService).passwordEncoder(encoder);
    }

    private static class OAuth2RequestMatcher implements RequestMatcher {

        @Override
        public boolean matches(HttpServletRequest request) {
            String authorization = request.getHeader("Authorization");
            boolean check_authorization = authorization != null && authorization.startsWith("Bearer ");
            boolean check_token = request.getParameter("access_token") != null;
            return check_authorization || check_token;
        }
    }
}
