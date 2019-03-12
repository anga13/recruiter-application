/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1201.grupp13.recruiterapplication.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.kth.iv1201.grupp13.recruiterapplication.application.UserService;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;

/**
 *
 * @author anders
 * Controls the API endpoints for users
 */
@RestController
public class UserController {

    private static final String USER_BASE_URL = "/users";

    @Autowired
    private UserService userService;

    /**
     * Creates a new user with the role of applicant
     * @param user
     * @return the created instance
     */
    @PostMapping(USER_BASE_URL)
    public UserDTO createApplicant(@RequestBody UserRequestBody user) {
        return userService.createApplicant(user);
    }
  
    /**
     * Creates a new user with the role of applicant
     * @param user
     * @return the created instance
     */
    @GetMapping(USER_BASE_URL+"/getUsers")
    public List<User> getUsers() {
        return userService.all();
    }
    
    @GetMapping(USER_BASE_URL+"/getCompetences")
    public List<Competence> getCompetences() {
        return userService.competences();
    }
    
    @PostMapping(USER_BASE_URL+"/addCompetence")
    public Competence createCompetence(@RequestBody String name) {
        return userService.createCompetence(name);
    }
    
    
    
}
