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
     */
    @Override
    Role save(Role role);  
<<<<<<< HEAD
    Role findByName(String name);
=======
    Role findByRoleId(Long roleId);

    Role findByName(String applicant);
>>>>>>> 0c1ddcf010e61cb639f1f4fe41819d62ab76cf94
}
