package se.kth.iv1201.grupp13.recruiterapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;

/**
 * Contains all database access concerning competences.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    /**
     * Returns the competence with the specified competence name.
     *
     * @param competenceName The competence name to search for.
     * @return A competence with the specified name.
     */
    Competence findByName(Long competenceName);
    
    @Override
    Competence save(Competence competence);  
    
    @Override
    List<Competence> findAll();
}
