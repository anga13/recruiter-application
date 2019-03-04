package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

import javax.persistence.*;
/**
 * Applications are created in this class.
 */
@Entity
@Table(name = "application")
public class Application implements ApplicationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private User user;

    @Column(name = "application_date")
    private Date applicationDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "approval_status_id")
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

    /**
     * Sets the application's approval status.
     */
    public void setApplicationStatus(ApprovalStatus applicationStatus) {
        this.approvalStatus = applicationStatus;
    }

    /**
     * Sets the application id.
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Sets the application's owner.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Sets the application delivery date.
     */
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

}
