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

    User findByUsernameAndPassword(String username, String password);
    List<User>  findByNameLike(String name);
    List<User> findByAvailabilities(List<Availability> availabilities);    
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
