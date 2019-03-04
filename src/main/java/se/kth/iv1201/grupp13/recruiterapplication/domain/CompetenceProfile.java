package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

/**
  * The class takes in values for how long an applicant
  * has worked within a specific competence.
 */
@Entity
@Table(name = "competence_profile")
public class CompetenceProfile implements CompetenceProfileDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "competence_profile_id")
	private Long competenceProfileId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;

    @NotNull(message = "{competenceProfile.competence.missing}")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "competence_id")
	private Competence competence;

    @NotNull(message = "{competenceProfile.yearsOfExperience.missing}")
    @Pattern(regexp = "^\\d{1,2}$", message = "{competenceProfile.yearsOfExperience.invalid-char}")
    @Size(min = 1, max = 2, message = "{competenceProfile.yearsOfExperience.length}")
	@Column(name = "years_of_experience")
	private BigDecimal yearsOfExperience;	
	
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
    public CompetenceProfile(User user, Competence competence, BigDecimal yearsOfExperience) {	       
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
	public BigDecimal getYearsOfExperience() {
		return yearsOfExperience;
	}
	
    @Override
    public String toString() {
        return Util.toString(this);
    }
    /**
     * Sets the competence profile Id.
     */
	public void setCompetenceProfileId(Long competenceProfileId) {
		this.competenceProfileId = competenceProfileId;
	}

    /**
     * Sets the competence profile's owner.
     */
	public void setUser(User user) {
		this.user = user;
	}
	
    /**
     * Sets the competence profile's competence.
     */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
        
    /**
     * Sets the competence profile's years of experience.
     */
	public void setYearsOfExperience(BigDecimal yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
