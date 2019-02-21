package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

@Entity
@Table(name = "person")
public class User implements UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id")
    private Long personId;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CompetenceProfile> competenceProfiles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Availability> availabilities = new HashSet<>();

    /**
     * @return a set containing all competence profiles owned by this user.
     */
    @Override
    public Set<CompetenceProfile> getCompetenceProfiles() {
        return competenceProfiles;
    }

    /**
     * @return a set containing all availabilities owned by this user.
     */
    @Override
    public Set<Availability> getAvailabilities() {
        return availabilities;
    }

    /**
     * Adds the specified competence profile to the set of competence profiles
     * owned by this user. There is no limit on the number of competence
     * profiles that can be owned by the same user.
     *
     * @param competenceProfile The competence profile to add to this user's
     * competence profiles.
     */
    public void addCompetenceProfile(CompetenceProfile competenceProfile) {
        competenceProfiles.add(competenceProfile);
    }

    /**
     * Adds the specified availability to the set of availabilities owned by
     * this user. There is no limit on the number of availabilities that can be
     * owned by the same user.
     *
     * @param availability The availability to add to this user's
     * availabilities.
     */
    public void addAvailability(Availability availability) {
        availabilities.add(availability);
    }

    /**
     * Required by JPA, should not be used.
     */
    protected User() {
    }

    /**
     * <p>
     * Creates a new instance with the specified personId, name, surname, ssn,
     * email, password, role and username. </p>
     *
     * <p>
     * A unique person id will be set on the newly created instance.</p>
     *
     * @param name The user first name.
     * @param surname The user surname.
     * @param ssn The user's ssn.
     * @param email The user email.
     * @param password The user password.
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
        personId = new Long(5); //BeanFactory.getBean(BusinessIdGenerator.class).generatePersonId();
    }

    @Override
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
        this.surname = surname;
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
        return personId.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return this.personId.equals(other.personId);
    }

    @Override
    public String toString() {
        return Util.toString(this);
    }
}
