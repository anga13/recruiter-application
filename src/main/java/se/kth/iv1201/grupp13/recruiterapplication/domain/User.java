package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

/**
 * The class User creates users with the personal attributes.
 */
@Entity
@Table(name = "person")
public class User implements UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long personId;

    @NotNull(message = "{user.name.missing}")
    @Pattern(regexp = "^[a-z|A-Z]{3,15}$", message = "{user.firstName.invalid-char}")
    @Size(min = 2, max = 30, message = "{user.firstName.length}")
    @Column(name = "name")
    private String name;

    @NotNull(message = "{user.surName.missing}")
    @Pattern(regexp = "^[a-zA-Z]{2,20}$", message = "{user.surName.invalid-char}")
    @Size(min = 2, max = 30, message = "{user.surName.length}")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "{user.ssn.missing}")
    @Pattern(regexp = "^(19|20)?[0-9]{6}[- ]?[0-9]{4}$", message = "{user.ssn.invalid-char}")
    @Size(min = 1, max = 60, message = "{user.ssn.length}")
    @Column(name = "ssn")
    private String ssn;

    @NotNull(message = "{user.email.missing}")
    @Pattern(regexp = "^([A-Za-z\\d-_.]+)*@([A-Za-z\\d]+[.])[A-Za-z\\d]{2,5}$", message = "{user.email.invalid-char}")
    @Size(min = 1, max = 60, message = "{user.email.length}")
    @Column(name = "email")
    private String email;

    @NotNull(message = "{user.password.missing}")
    @Pattern(regexp = "^.*(?=.{6,15})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$", message = "{user.password.invalid-char}")
    @Size(min = 6, max = 15, message = "{user.password.length}")

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @NotNull(message = "{user.userName.missing}")
    @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "{user.userName.invalid-char}")
    @Size(min = 2, max = 30, message = "{user.userName.length}")
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
    public Set<CompetenceProfileDTO> getCompetenceProfiles() {
        Set<CompetenceProfileDTO> copyOfCompfs = new HashSet<>();
        copyOfCompfs.addAll(competenceProfiles);
        return copyOfCompfs;
    }

    /**
     * @return a set containing all availabilities owned by this user.
     */
    @Override
    public Set<AvailabilityDTO> getAvailabilities() {
        Set<AvailabilityDTO> copyOfAvas = new HashSet<>();
        copyOfAvas.addAll(availabilities);
        return copyOfAvas;
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
    }

    @Override
    public Long getPersonId() {
        return personId;
    }

    /**
     * Sets the user's person id.
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the user's surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getSsn() {
        return ssn;
    }

    /**
     * Sets the user's ssn.
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Role getRole() {
        return role;
    }

    /**
     * Sets the user's role.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's user name.
     */
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
