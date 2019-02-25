package se.kth.iv1201.grupp13.recruiterapplication.domain;

import javax.persistence.*;

import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

/**
  * The class creates a competence.
 */
@Entity
@Table(name = "competence")
public class Competence implements CompetenceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "competence_id")
    private Long competenceId;

    @Column(name = "name")
    private String name;

    /**
     * Required by JPA, should not be used.
     */
    public Competence() {
    }

    /**
     * <p>
     * Creates a new instance with the specified name. </p>
     *
     * <p>
     * A unique competence id will be set on the newly created instance.</p>
     *
     * @param name The competence name.
     *
     */
    public Competence(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Util.toString(this);
    }

    @Override
    public Long getCompetenceId() {
        return competenceId;
    }

    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Sets the competence id.
     */
    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * Sets the competence name.
     */
    public void setName(String name) {
        this.name = name;
    }

}
