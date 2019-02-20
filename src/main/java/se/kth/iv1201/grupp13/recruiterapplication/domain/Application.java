package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "competence_profile")
public class Application implements ApplicationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "application_id")
    private Long applicationId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private User user;

    @Column(name = "application_date")
    private Date applicationDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "approvalStatus")
    private ApprovalStatus approvalStatus;

    /**
     * Required by JPA, should not be used.
     */
    protected Application() {
    }

    /**
     * <p>
     * Creates a new instance with the specified user, application_date. </p>
     *
     * <p>
     * A unique application id will be set on the newly created instance.</p>
     *
     * @param user The applicant.
     * @param applicationDate The application date.
     * @param approvalStatus The application status.
     *
     */
    public Application(User user, Date applicationDate, ApprovalStatus approvalStatus) {
        this.user = user;
        this.applicationDate = applicationDate;
        this.approvalStatus = approvalStatus;
        applicationId = BeanFactory.getBean(BusinessIdGenerator.class).generateApplicationId();
    }

    @Override
    public Long getApplicationId() {
        return applicationId;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Date getApplicationDate() {
        return applicationDate;
    }

    @Override
    public ApprovalStatus getApplicationStatus() {
        return approvalStatus;
    }

    public void setApplicationStatus(ApprovalStatus applicationStatus) {
        this.approvalStatus = applicationStatus;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

}
