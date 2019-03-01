package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Availability;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import java.util.List;

/**
 * Contains all database access concerning users.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Returns the user with the specified user name and password.
     *
     * @param username The user name to search for.
     * @param password The password to search for.
     * @return A user with the specified user name and password.
     */
    User findByUsernameAndPassword(String username, String password);

    /**
     * Returns the users with the specified name.
     *
     * @param name The user's name to search for.
     * @return A list containing all users with the specified name.
     */
    List<User> findByNameLike(String name);
    
    /**
     * Returns the users with the specified availabilities.
     *
     * @param availabilities The availabilities to search for.
     * @return A list containing all users with the specified availabilities.
     */    
    List<User> findByAvailabilities(List<Availability> availabilities); 

    /**
     * Returns the users with the specified competenceProfiles.
     *
     * @param competenceProfiles The competence profiles to search for.
     * @return A list containing all users with the specified competence profiles.
     */ 
    List<User> findByCompetenceProfiles(List<CompetenceProfile> competenceProfiles);    

    @Override
    List<User> findAll();

    @Override
    User save(User user);
    
  /*  @Query("select * from person p left join ?1 on p.person_id = ?1.person_id", nativeQuery = true)
    List<User> findByAvailabilities(List<Availability> searchedAvailabilities);
    
    List<User> findByCompetenceProfiles(List<CompetenceProfile> searchedAvailabilities);    
*/    
    
}
