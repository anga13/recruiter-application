package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

@Entity
@Table(name = "person")
public class User implements UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private Long person_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "ssn")
	private String ssn;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(name = "username")
	private String username;	
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<CompetenceProfile> competence_profiles = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Availability> availabilities = new HashSet<>();

    /**
     * Returns a set containing all competence profiles owned by this user.
     */
    @Override    
    public Set<CompetenceProfileDTO> getCompetence_profiles() {
        Set<CompetenceProfileDTO> copyOfProfs = new HashSet<>();
        copyOfProfs.addAll(competence_profiles);
        return copyOfProfs;
	}

    /**
     * Returns a set containing all availabilities owned by this user.
     */
    @Override    
    public Set<AvailabilityDTO> getAvailabilities() {
        Set<AvailabilityDTO> copyOfAvlas = new HashSet<>();
        copyOfAvlas.addAll(availabilities);
        return copyOfAvlas;
	}
    
    /**
     * Adds the specified competence profile to the set of competence profiles owned by this user.
     * There is no limit on the number of competence profiles that can be owned by the same
     * user.
     *
     * @param compro The competence profile to add to this user's competence profiles.
     */
    public void addCompetenceProfile(CompetenceProfile compro) {
    	competence_profiles.add(compro);
    }

    /**
     * Adds the specified availability to the set of availabilities owned by this user.
     * There is no limit on the number of availabilities that can be owned by the same
     * user.
     *
     * @param ava The availability to add to this user's availabilities.
     */
    public void addAvailability(Availability ava) {
    	availabilities.add(ava);
    }

	/**
     * Required by JPA, should not be used.
     */
    protected User() {
	}
	
    /**
     * <p>Creates a new instance with the specified person_id, name, 
     * surname, ssn, email, password, role and username. </p>
     *
     * <p>A unique person id will be set on the newly created
     * instance.</p>
     *
     * @param name  The user first name.
     * @param surname The user surname.
     * @param ssn  The user's ssn.
     * @param email The user email.
     * @param password  The user password.
     * @param role The The user role. 
     * @param username The user's user name. 
     * 
     */
    public User(String name, String surname, String ssn, String email, String password, Role role, String username) {	       
		this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        person_id = BeanFactory.getBean(BusinessIdGenerator.class).generatePerson_id();
    }


    @Override	
    public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
    @Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @Override
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname= surname;
	}
    @Override
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
    @Override
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    @Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    @Override
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    @Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


    @Override
    public int hashCode() {
        return Long.valueOf(person_id).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User)object;
        return this.person_id == other.person_id;
    }

    @Override
    public String toString() {
        return Util.toString(this);
    }
}
