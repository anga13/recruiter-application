package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Availability;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Contains all database access concerning availabilities.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    /**
     * Returns the availabilities with the specified from_date.
     *
     * @param fromDate The from_date to search for.
     * @return A list containing all availabilities with the specified from_date.
     */	
    List<Availability> findByFromDateBefore(Date fromDate);
    
    /**
     * Returns the availabilities with the specified to_date.
     *
     * @param toDate The to_date to search for.
     * @return A list containing all availabilities with the specified to_date.
     */	    
    List<Availability> findByToDateAfter(Date toDate);

    @Override
    Availability save(Availability availability);

    /**
     * Returns the availabilities of the specified user.
     *
     * @param user The user to search for.
     * @return A list containing all availabilities of the specified user.
     */	
    List<Availability> findByUser(User user);
    
}
