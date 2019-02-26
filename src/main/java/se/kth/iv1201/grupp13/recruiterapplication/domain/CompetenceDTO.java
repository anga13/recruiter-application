package se.kth.iv1201.grupp13.recruiterapplication.domain;

/**
 * Defines all operation that can be performed on an {@link Competence} outside
 * the application and domain layers.
 */
public interface CompetenceDTO {
    /**
     * Returns the competence Id.
     */   
    public Long getCompetenceId();
 
    /**
     * Returns the competence name.
     */ 	
    public String getName();

}
