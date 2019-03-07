package se.kth.iv1201.grupp13.recruiterapplication.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
 
/**
 * After verifying that the username and password are correct, generate a token and return the token to the client.
 * This class inherits from UsernamePasswordAuthenticationFilter and overrides 2 methods of them.
 * attemptAuthentication ：Receive and parse user request.
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
 
    private AuthenticationManager authenticationManager;
    
    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
 
    /**
     * attemptAuthentication ：Receive and parse user request.
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserDTO user = (UserDTO) new ObjectMapper()
                    .readValue(req.getInputStream(), UserDTO.class);
 
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * successfulAuthentication ：This method will be called after the user successfully logs in. 
     * We generate a token in this method.
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
 
        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        res.addHeader("Authorization", "Bearer " + token);
    }
 
}