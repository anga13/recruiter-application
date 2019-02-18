package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "competence_profile")
public class Application implements ApplicationDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "application_id")
	private Long application_id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;
	
	@Column(name = "application_date")
	private Date application_date;
	
    
	@Column(name = "application_status")
	private ApprovalStatus application_status;    
	
    /**
     * Required by JPA, should not be used.
     */
	protected Application() {
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
    public Application(User user, Date application_date) {	       
        this.user = user;
        this.application_date = application_date;
        application_id = BeanFactory.getBean(BusinessIdGenerator.class).generatePerson_id();
    }

	@Override
	public Long getApplication_id() {
		return application_id;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public Date getApplication_date() {
		return application_date;
	}


	@Override
	public ApprovalStatus getApplication_status() {
		return application_status;
	}

	public void setApplication_status(ApprovalStatus application_status) {
		this.application_status = application_status;
	}

	public void setApplication_id(Long application_id) {
		this.application_id = application_id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

}
