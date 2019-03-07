package se.kth.iv1201.grupp13.recruiterapplication.web;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
 
/**
 * token validation
 * This class inherits from the BasicAuthenticationFilter. 
 * In the doFilterInternal method, the token data is read from the http header, 
 * and then verify the validity of the token using the method provided by the Jwts package.
 * If the verification is passed, it is considered a legal request for authorization.
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
 
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
 
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);//When a filter receives a request, it calls chain.doFilter to access the next matching filter.
            return;
        }
        //If the verification passes, it is considered a legal request to obtain authorization.
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
 
    }
 
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey("MyJwtSecret")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
 
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
 
}

