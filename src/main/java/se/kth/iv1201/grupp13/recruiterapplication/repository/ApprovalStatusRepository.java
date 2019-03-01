package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.grupp13.recruiterapplication.domain.ApprovalStatus;

/**
 * Contains all database access concerning an application's approval status.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface ApprovalStatusRepository extends JpaRepository<ApprovalStatus, Long> {   
    /**
     * Returns the application's approval status with the specified status name.
     *
     * @param approvalStatusName The approval status name to search for.
     * @return The approval status with the specified approval status name.
     */
    ApprovalStatus findByName(Long approvalStatusName);
    
    ApprovalStatus save(ApprovalStatus approvalStatus);  
<<<<<<< HEAD
    ApprovalStatus findByName(String name);
=======
>>>>>>> 0c1ddcf010e61cb639f1f4fe41819d62ab76cf94
}
