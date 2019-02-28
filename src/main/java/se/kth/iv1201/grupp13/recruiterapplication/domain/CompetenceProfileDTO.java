package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.math.BigDecimal;

/**
 * Defines all operation that can be performed on an {@link CompetenceProfile} outside
 * the application and domain layers.
 */

public interface CompetenceProfileDTO {

    /**
     * Returns the competence profile Id.
     */
    public Long getCompetenceProfileId();

    /**
     * Returns the competence profile's owner.
     */
    public User getUser();

    /**
     * Returns the competence profile's competence.
     */
    public Competence getCompetence();

    /**
     * Returns the competence profile's years of experience.
     */
    public BigDecimal getYearsOfExperience();
}
