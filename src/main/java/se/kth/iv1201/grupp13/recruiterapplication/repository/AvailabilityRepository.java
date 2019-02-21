package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Availability;

import java.util.Date;
import java.util.List;

/**
 * Contains all database access concerning users.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    //List<Availability> findByFromDateAndToDate(Date fromDate, Date toDate);
    List<Availability> findByFromDateBefore(Date fromDate);
    List<Availability> findByToDateAfter(Date toDate);

    
    @Override
    Availability save(Availability availability);
}
