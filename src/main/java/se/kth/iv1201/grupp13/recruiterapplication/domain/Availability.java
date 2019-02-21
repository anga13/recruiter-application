package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "availability")
public class Availability implements AvailabilityDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "availability_id")
	private Long availabilityId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private User user;

	@Column(name = "from_date")
	private Date fromDate;	
	
	@Column(name = "to_date")
	private Date toDate;	
	
    /**
     * Required by JPA, should not be used.
     */
	protected Availability() {
	}
	
    /**
     * <p>Creates a new instance with the specified user, fromDate, 
     * toDate. </p>
     *
     * <p>A unique availability id will be set on the newly created
     * instance.</p>
     *
     * @param user  The availability's user.
     * @param fromDate The availability's fromDate.
     * @param toDate The availability's toDate.
     * 
     */
    public Availability(User user, Date fromDate, Date toDate) {	       
        this.user = user;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

	@Override
	public Long getAvailabilityId() {
		return availabilityId;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public Date getFromDate() {
		return fromDate;
	}

	@Override
	public Date getToDate() {
		return toDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


}
