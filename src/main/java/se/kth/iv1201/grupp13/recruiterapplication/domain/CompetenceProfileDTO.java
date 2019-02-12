package se.kth.iv1201.grupp13.recruiterapplication.domain;

public interface CompetenceProfileDTO {
    
    public Long getCompetence_profile_id();
	
    public User getUser();

	public Competence getCompetence();

	public int getYears_of_experience();
}
