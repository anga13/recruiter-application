package se.kth.iv1201.grupp13.recruiterapplication.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Role;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;
import se.kth.iv1201.grupp13.recruiterapplication.repository.RoleRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.UserRepository;

//Create a new transaction, and suspend the current transaction if one exists.
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class RecruiterService {
    @Autowired
    private UserRepository userRepo;
    private RoleRepository roleRepo;    
    
    /**
     * The method is to create/register a new user.
     *
     * @param name The user first name.
     * @param surname The user surname.
     * @param ssn The user's ssn.
     * @param email The user email.
     * @param password The user password.
     * @param role The The user role.
     * @param username The user's user name.
     * @return The newly created user(applicant).
     */
    public UserDTO createUser(String name, String surname, String ssn, String email, String password, Long roleId, String username){
        Role role = roleRepo.findbyName("APPLICANT");    	
        return userRepo.save(new User(name, surname, ssn, email, password, role, username));
    }	
}
