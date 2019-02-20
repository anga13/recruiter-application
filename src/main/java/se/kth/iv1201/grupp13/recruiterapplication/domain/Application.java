package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Date applicationDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
	@JoinColumn(name = "approvalStatus")
	private ApprovalStatus approvalStatus; 
	
    /**
     * Required by JPA, should not be used.
     */
	protected Application() {
	}
	
    /**
     * <p>Creates a new instance with the specified user, 
     * application_date. </p>
     *
     * <p>A unique application id will be set on the newly created
     * instance.</p>
     *
     * @param user  The applicant.
     * @param application_date The application date.
     * @param approvalStatus The application status.     
     * 
     */
    public Application(User user, Date application_date, ApprovalStatus approvalStatus) {	       
        this.user = user;
        this.applicationDate = application_date;
        this.approvalStatus=approvalStatus;
        application_id = BeanFactory.getBean(BusinessIdGenerator.class).generateApplicationId();
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
		return applicationDate;
	}


	@Override
	public ApprovalStatus getApplication_status() {
		return approvalStatus;
	}

	public void setApplication_status(ApprovalStatus application_status) {
		this.approvalStatus = application_status;
	}

	public void setApplication_id(Long application_id) {
		this.application_id = application_id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setApplication_date(Date application_date) {
		this.applicationDate = application_date;
	}
	
	

}
