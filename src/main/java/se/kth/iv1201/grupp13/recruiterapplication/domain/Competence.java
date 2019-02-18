package se.kth.iv1201.grupp13.recruiterapplication.domain;

import javax.persistence.*;


import se.kth.iv1201.grupp13.recruiterapplication.util.Util;

@Entity
@Table(name = "competence")
public class Competence implements CompetenceDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "competence_id")
	private Long competence_id;

	@Column(name = "name")
	private String name;
	
    /**
     * Required by JPA, should not be used.
     */
	public Competence() {
	}
	
    /**
     * <p>Creates a new instance with the specified name. </p>
     *
     * <p>A unique competence id will be set on the newly created
     * instance.</p>
     *
     * @param name  The competence name.
     * 
     */
    public Competence(String name) {	       
        this.name = name;
        competence_id = BeanFactory.getBean(BusinessIdGenerator.class).generateCompetence_id();
    }

	
    @Override
    public String toString() {
        return Util.toString(this);
    }

    
	@Override
	public Long getCompetence_id() {
		return competence_id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setCompetence_id(Long competence_id) {
		this.competence_id = competence_id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	


}
