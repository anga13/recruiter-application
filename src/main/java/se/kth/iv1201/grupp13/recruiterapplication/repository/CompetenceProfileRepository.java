package se.kth.iv1201.grupp13.recruiterapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;

/**
 * Contains all database access concerning users.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface CompetenceProfileRepository extends JpaRepository<CompetenceProfile, Long> {

    List<CompetenceProfile> findByCompetence(Competence competence);
    
    @Override
    CompetenceProfile save(CompetenceProfile competenceProfile);   
    
}