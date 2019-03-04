package se.kth.iv1201.grupp13.recruiterapplication.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfileDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;

/**
 * Contains all database access concerning competence profiles.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Long> {
    /**
     * Returns the competence profiles with the specified competence.
     *
     * @param competence The competence to search for.
     * @return A list containing all competence profiles with the specified competence.
     */
    List<CompetenceProfile> findByCompetence(Competence competence);
    
    @Override
    CompetenceProfile save(CompetenceProfile competenceProfile);

    /**
     * Returns the competence profiles of the specified user.
     *
     * @param user The user to search for.
     * @return A list containing all competence profiles of the specified user.
     */
	List<CompetenceProfile> findByUser(User user);
	

	//Set<CompetenceProfile> save(Set<CompetenceProfile> competenceProfiles);

	//List<CompetenceProfileDTO> saveAll(List<CompetenceProfileDTO> competenceProfiles);   
	
    
}
