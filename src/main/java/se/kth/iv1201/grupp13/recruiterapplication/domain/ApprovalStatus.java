package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

/**
*The class ApprovalStatus creates approval status of an application. 
*The three kinds of the statues are UNHANDLED, ACCEPTED, REJECTED.
 */
@Entity
@Table(name = "approval_status")
public class ApprovalStatus implements ApprovalStatusDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "approval_status_id")
    private Long approvalStatusId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "approvalStatus", cascade = CascadeType.ALL)
    private Set<Application> applications = new HashSet<>();

    /**
     * Required by JPA, should not be used.
     */
    public ApprovalStatus() {
    }

    /**
     * <p>
     * Creates a new instance with the specified name. </p>
     *
     * <p>
     * A unique role id will be set on the newly created instance.</p>
     *
     * @param name The role name.
     *
     */
    public ApprovalStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Util.toString(this);
    }

	@Override
	public Long getApprovalStatusId() {
		return approvalStatusId;
	}

    /**
     * Sets the application's approval status Id.
     */
	public void setApprovalStatusId(Long approvalStatusId) {
		this.approvalStatusId = approvalStatusId;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	
    /**
     * Sets the approval status name.
     */
	public void setName(String name) {
		this.name = name;
	}
}
