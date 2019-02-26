package se.kth.iv1201.grupp13.recruiterapplication.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Availability;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.IllegalRecruiterTransactionException;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Role;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;
import se.kth.iv1201.grupp13.recruiterapplication.repository.AvailabilityRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.CompetenceProfileRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.RoleRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.UserRepository;


/**
 * <p>This is the user service class, which defines tasks that can be
 * performed by the domain layer.</p>
 *
 * <p>Transaction demarcation is defined by methods in this class, a
 * transaction starts when a method is called from the presentation layer, and ends (commit or rollback) when that
 * method returns.</p>
 */
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private CompetenceProfileRepository competenceProfileRepo;	
    @Autowired
    private AvailabilityRepository availabilityRepo;	

    /**
     * This is the method that registers user.
     *
     * @param name The user first name.
     * @param surname The user surname.
     * @param ssn The user's ssn.
     * @param email The user email.
     * @param password The user password.
     * @param role The The user role.
     * @param username The user's user name.
     * @return The newly created user.
     */
    public UserDTO createUser(String name, String surname, String ssn, String email, String password, String roleName, String username){
        Role roleEntity = roleRepo.findByName("APPLICANT");
        return userRepo.save(new User(name, surname, ssn, email, password, roleEntity, username));
    }	

    /**
     * This is the method for user login.
     *
     * @param username The user's user name.
     * @param password The user password.
     * @return The user who has logged in.
     */
	public UserDTO userLogin(String username, String password) throws IllegalRecruiterTransactionException {
        UserDTO user= userRepo.findByUsernameAndPassword(username, password);
        if (user == null) {
            throw new IllegalRecruiterTransactionException("User does not exist," + " user: " + username);
        }
        return user;
    }	

    /**
     * This is the method that save a list of competence profiles into CompetenceProfileRepository
     * as well as into the current user's competence profile list.
     *
     * @param user The current user.
     * @param competenceProfiles The competence profiles to be inserted.
     */
    public void saveCompetenceProfiles(User user, List<CompetenceProfile> competenceProfiles) {
    	for(CompetenceProfile competenceProfile:competenceProfiles) {
			competenceProfileRepo.save(competenceProfile);
			((User) user.getCompetenceProfiles()).addCompetenceProfile(competenceProfile);
		}
    }	

    /**
     * This is the method that save a list of availabilities into AvailabilityRepository
     * as well as into the current user's availability list.
     *
     * @param user The current user.
     * @param availabilities The availabilities to be inserted.
     */
    public void saveAvailabilities(User user, List<Availability> availabilities) {
    	for(Availability availability:availabilities) {
    		availabilityRepo.save(availability);
			((User) user.getAvailabilities()).addAvailability(availability);    		
		}
    }
    
}
