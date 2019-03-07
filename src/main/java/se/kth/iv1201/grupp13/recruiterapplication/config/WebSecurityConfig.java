package se.kth.iv1201.grupp13.recruiterapplication.config;


import se.kth.iv1201.grupp13.recruiterapplication.web.JWTLoginFilter;
import se.kth.iv1201.grupp13.recruiterapplication.web.JWTAuthenticationFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
/**
 * SpringSecurity config
 * Combine JWT LoginFilter and JWTAuthenticationFilter into Spring Security configuration
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    private UserDetailsService userDetailsService;
 
    public WebSecurityConfig(UserDetailsService userDetailsService) {
    	
        this.userDetailsService = userDetailsService;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
    }
 
 
}
