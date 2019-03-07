package se.kth.iv1201.grupp13.recruiterapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Role;

/**
 * Contains all database access concerning roles.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) // Support current transaction, throw an exception if there is no transaction currently.
public interface RoleRepository extends JpaRepository<Role, Long> { 
    /**
     * Returns the role with the specified role name.
     *
     * @param roleName The role name to search for.
     * @return A role with the specified name.
     * @throws IncorrectResultSizeDataAccessException If more than one role with the specified name was found.
     */
    @Override
    Role save(Role role);  
    Role findByName(Long roleName);

    Role findByName(String applicant);
}
