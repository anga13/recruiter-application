package se.kth.iv1201.grupp13.recruiterapplication.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Application;

/**
 * Contains all database access concerning users.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUserIn(List<User> users);
    List<Application> findByApplication_date(Date date);
    
    Application save(Application application);  

}
