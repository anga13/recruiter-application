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
@Table(name = "person")
public class Role implements RoleDTO{
	
	//APPLICANT, RECRUITER;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "name")
	private String name;
	
	//should check All..
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
	
    /**
     * Required by JPA, should not be used.
     */
	public Role() {
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
    public Role(String name) {	       
        this.name = name;
    }
    
    @Override
    public String toString() {
        return Util.toString(this);
    }

	/* (non-Javadoc)
	 * @see se.kth.iv1201.grupp13.recruiterapplication.domain.RoleDTO#getRoleId()
	 */
	@Override
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
