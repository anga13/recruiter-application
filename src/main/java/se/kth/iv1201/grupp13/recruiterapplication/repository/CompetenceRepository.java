package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;

/**
 * Contains all database access concerning users.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

    Competence findByCompetence_id(Long Competence_id);
    
    Competence save(Competence competence);  
}
