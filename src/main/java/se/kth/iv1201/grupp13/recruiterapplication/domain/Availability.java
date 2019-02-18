package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "competence_profile")
public class Availability implements AvailabilityDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "availability_id")
	private Long availability_id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;

	@Column(name = "from_date")
	private Date from_date;	
	
	@Column(name = "to_date")
	private Date to_date;	
	
    /**
     * Required by JPA, should not be used.
     */
	protected Availability() {
	}
	
    /**
     * <p>Creates a new instance with the specified user, from_date, 
     * to_date. </p>
     *
     * <p>A unique availability id will be set on the newly created
     * instance.</p>
     *
     * @param user  The availability's user.
     * @param from_date The availability's from_date.
     * @param to_date The availability's to_date.
     * 
     */
    public Availability(User user, Date from_date, Date to_date) {	       
        this.user = user;
        this.from_date = from_date;
        this.to_date = to_date;
        availability_id = BeanFactory.getBean(BusinessIdGenerator.class).generatePerson_id();
    }

	@Override
	public Long getAvailability_id() {
		return availability_id;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public Date getFrom_date() {
		return from_date;
	}

	@Override
	public Date getTo_date() {
		return to_date;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}


}
