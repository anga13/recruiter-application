package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Set;
/**
 * Defines all operation that can be performed on an {@link User} outside
 * the application and domain layers.
 */
public interface UserDTO {
    /**
     * Returns the person Id.
     */
    public Long getPersonId();
    
    /**
     * Returns the user's name.
     */
    public String getName();
    /**
     * Returns the user's surname.
     */
    public String getSurname();
    /**
     * Returns the user's ssn.
     */
    public String getSsn();
    /**
     * Returns the user's email adress.
     */
    public String getEmail();
    /**
     * Returns the user's password.
     */
    public String getPassword();
    /**
     * Returns the user's role.
     */
    public RoleDTO getRole();
    /**
     * Returns the user's user name.
     */
    public String getUsername();
    /**
     * Returns the user's competence profiles.
     */
    Set<CompetenceProfileDTO> getCompetenceProfiles();
    /**
     * Returns the user's availabilities.
     */
    Set<AvailabilityDTO> getAvailabilities();
}
