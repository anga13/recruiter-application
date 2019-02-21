package se.kth.iv1201.grupp13.recruiterapplication.domain;

import javax.persistence.*;


import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

@Entity
@Table(name = "competence_profile")
public class CompetenceProfile implements CompetenceProfileDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "competence_profile_id")
	private Long competenceProfileId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "competence_id")
	private Competence competence;

	@Column(name = "years_of_experience")
	private int yearsOfExperience;	
	
    /**
     * Required by JPA, should not be used.
     */
	protected CompetenceProfile() {
	}
	
    /**
     * <p>Creates a new instance with the specified user, competence, 
     * yearsOfExperience. </p>
     *
     * <p>A unique competence profile id will be set on the newly created
     * instance.</p>
     *
     * @param user  The competence profile's user.
     * @param competence The competence profile's competence.
     * @param yearsOfExperience The competence profile's yearsOfExperience.
     * 
     */
    public CompetenceProfile(User user, Competence competence, int yearsOfExperience) {	       
        this.user = user;
        this.competence = competence;
        this.yearsOfExperience = yearsOfExperience;
    }


	@Override
	public Long getCompetenceProfileId() {
		return competenceProfileId;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public Competence getCompetence() {
		return competence;
	}

	@Override
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
    @Override
    public String toString() {
        return Util.toString(this);
    }

	public void setCompetenceProfileId(Long competenceProfileId) {
		this.competenceProfileId = competenceProfileId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
