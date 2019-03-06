/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1201.grupp13.recruiterapplication.presentation;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.kth.iv1201.grupp13.recruiterapplication.application.UserService;
import se.kth.iv1201.grupp13.recruiterapplication.domain.AvailabilityDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfileDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.RoleDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;

/**
 *
 * @author anders
 */
@RestController
public class UserController {

    private static final String USER_BASE_URL = "/users";

    @Autowired
    private UserService userService;

    @PostMapping(USER_BASE_URL)
    public UserDTO createApplicant(@RequestBody UserRequestBody user) {
        return userService.createApplicant(user);
    }

     
}
