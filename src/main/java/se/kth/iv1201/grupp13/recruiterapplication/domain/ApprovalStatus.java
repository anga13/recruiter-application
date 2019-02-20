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

@Entity
@Table(name = "approvalStatus")
public class ApprovalStatus implements ApprovalStatusDTO{
	
	//UNHANDLED, ACCEPTED, REJECTED;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "approvalStatus_id")
	private Long approvalStatusId;

	@Column(name = "name")
	private String name;
	
    /**
     * Required by JPA, should not be used.
     */
	public ApprovalStatus() {
	}
	
    /**
     * <p>Creates a new instance with the specified name. </p>
     *
     * <p>A unique role id will be set on the newly created
     * instance.</p>
     *
     * @param name  The role name.
     * 
     */
    public ApprovalStatus(String name) {	       
        this.name = name;
        approvalStatusId = BeanFactory.getBean(BusinessIdGenerator.class).generateApprovalStatusId();
    }
    
    @Override
    public String toString() {
        return Util.toString(this);
    }

	/* (non-Javadoc)
	 * @see se.kth.iv1201.grupp13.recruiterapplication.domain.RoleDTO#getRoleId()
	 */
	@Override
	public Long getApprovalStatusId() {
		return approvalStatusId;
	}

	public void setApprovalStatusId(Long approvalStatusId) {
		this.approvalStatusId = approvalStatusId;
	}

	/* (non-Javadoc)
	 * @see se.kth.iv1201.grupp13.recruiterapplication.domain.RoleDTO#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
	
	
}

