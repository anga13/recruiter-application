package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.grupp13.recruiterapplication.domain.ApprovalStatus;

/**
 * Contains all database access concerning approval status.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface ApprovalStatusRepository extends JpaRepository<ApprovalStatus, Long> {   
    ApprovalStatus save(ApprovalStatus approvalStatus); 
    
    /**
     * Returns the approval status with the specified name.
     *
     * @param name The name to search for.
     * @return ApprovalStatus with the specified name.
     * @throws IncorrectResultSizeDataAccessException If more than one status with the specified name was found.
     */	   
    ApprovalStatus findByName(String name);
}
