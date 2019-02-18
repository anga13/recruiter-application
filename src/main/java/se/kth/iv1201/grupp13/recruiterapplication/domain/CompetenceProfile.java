package se.kth.iv1201.grupp13.recruiterapplication.domain;

import javax.persistence.*;


import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

@Entity
@Table(name = "competence_profile")
public class CompetenceProfile implements CompetenceProfileDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "competence_profile_id")
	private Long competence_profile_id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "competence_id")
	private Competence competence;

	@Column(name = "years_of_experience")
	private int years_of_experience;	
	
    /**
     * Required by JPA, should not be used.
     */
	protected CompetenceProfile() {
	}
	
    /**
     * <p>Creates a new instance with the specified user, competence, 
     * years_of_experience. </p>
     *
     * <p>A unique competence profile id will be set on the newly created
     * instance.</p>
     *
     * @param user  The competence profile's user.
     * @param competence The competence profile's competence.
     * @param years_of_experience The competence profile's years_of_experience.
     * 
     */
    public CompetenceProfile(User user, Competence competence, int years_of_experience) {	       
        this.user = user;
        this.competence = competence;
        this.years_of_experience = years_of_experience;
        competence_profile_id = BeanFactory.getBean(BusinessIdGenerator.class).generatePerson_id();
    }


	@Override
	public Long getCompetence_profile_id() {
		return competence_profile_id;
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
	public int getYears_of_experience() {
		return years_of_experience;
	}
	
    @Override
    public String toString() {
        return Util.toString(this);
    }

	public void setCompetence_profile_id(Long competence_profile_id) {
		this.competence_profile_id = competence_profile_id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public void setYears_of_experience(int years_of_experience) {
		this.years_of_experience = years_of_experience;
	}
}
