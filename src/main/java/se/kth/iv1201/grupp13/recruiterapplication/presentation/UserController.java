package se.kth.iv1201.grupp13.recruiterapplication.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import se.kth.iv1201.grupp13.recruiterapplication.application.UserService;
import se.kth.iv1201.grupp13.recruiterapplication.domain.IllegalRecruiterTransactionException;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;
import se.kth.iv1201.grupp13.recruiterapplication.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    private UserRepository userRepo;
    
    
	@GetMapping("/")
	public String allUsers() {
		return "hi";
		
	}
/*
	/**
     * User login with username and password.
     * The system verifies that the password is correct for the username.
     * If the verification is successful, get the role list of the user
     * After the login is successful, return the token to the header.
     */
@RequestMapping(value = "/login", method = {RequestMethod.POST})
public void login(String username, String password, HttpServletResponse response) throws IllegalRecruiterTransactionException {
	UserDTO user=service.userLogin(username, password);
    if (user != null) {    	
        List roleList = new ArrayList<>();
        String subject = user.getUsername() + "-" + roleList;
                String token = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 365 * 24 * 60 * 60 * 1000)) 
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret") 
                .compact();
        response.addHeader("Authorization", "Bearer " + token);
    }
}
}
