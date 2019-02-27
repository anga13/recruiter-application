package se.kth.iv1201.grupp13.recruiterapplication.application;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Application;
import se.kth.iv1201.grupp13.recruiterapplication.domain.ApplicationDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.ApprovalStatus;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Availability;
import se.kth.iv1201.grupp13.recruiterapplication.domain.Competence;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfile;
import se.kth.iv1201.grupp13.recruiterapplication.domain.IllegalRecruiterTransactionException;
import se.kth.iv1201.grupp13.recruiterapplication.domain.User;
import se.kth.iv1201.grupp13.recruiterapplication.repository.ApplicationRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.ApprovalStatusRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.AvailabilityRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.CompetenceProfileRepository;
import se.kth.iv1201.grupp13.recruiterapplication.repository.UserRepository;

/**
 * <p>
 * This is the application service class, which defines tasks that can be
 * performed by the domain layer.</p>
 *
 * <p>
 * Transaction demarcation is defined by methods in this class, a transaction
 * starts when a method is called from the presentation layer, and ends (commit
 * or rollback) when that method returns.</p>
 */
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CompetenceProfileRepository competenceProfileRepo;
    @Autowired
    private AvailabilityRepository availabilityRepo;
    @Autowired
    private ApplicationRepository applicationRepo;
    @Autowired
    private ApprovalStatusRepository approvalStatusRepo;
    private static final String DEFAULT_APPROVAL_STATUS = "UNHANDLED";

    /**
     * This is the method that get the current date when an application is sent.
     *
     * @return The application date.
     */
    public Date getApplicationDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date;
    }

    /**
     * This is the method to create application.
     *
     * @param user The current user.
     * @param applicationDate The date that the application is sent.
     * @return The newly created application.
     */
    public ApplicationDTO createApplication(User user, Date applicationDate) throws IllegalRecruiterTransactionException {
        ApprovalStatus status = approvalStatusRepo.findByName(DEFAULT_APPROVAL_STATUS);
        if (user != null && applicationDate != null) {
            return applicationRepo.save(new Application(user, applicationDate, status));
        }
        return null;
    }

    /**
     * This is the method to get applications.
     */
    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    /**
     * This is the method to find applications with specific time period the
     * applicant can work.
     *
     * @param requiredFromDate The required date from which the applicant can
     * begin to work.
     * @param requiredToDate The required date from which the applicant can end
     * the work.
     * @return The applications that found by the searching time period the
     * applicant can work.
     */
    public List<Application> findByAvailability(Date requiredFromDate, Date requiredToDate) {
        List<Availability> availabilities = availabilityRepo.findAll();
        List<Availability> availabilitiesBeforeStartDate = availabilityRepo.findByFromDateBefore(requiredFromDate);
        List<Availability> availabilitiesAfterToDate = availabilityRepo.findByToDateAfter(requiredToDate);
        availabilities.retainAll(availabilitiesBeforeStartDate);
        availabilities.retainAll(availabilitiesAfterToDate);
        List<User> users = userRepo.findByAvailabilities(availabilities);
        return applicationRepo.findByUserIn(users);
    }

    /**
     * This is the method to find applications with specific application date.
     *
     * @param applicationDate The application date.
     * @return The applications that found by the searching specific application
     * date.
     */
    public List<Application> findByApplicationDate(Date applicationDate) {
        return applicationRepo.findByApplicationDate(applicationDate);
    }

    /**
     * This is the method to find applications with specific competence.
     *
     * @param competence The competence that searched for.
     * @return The applications that found by the searching specific competence.
     */
    public List<Application> findByCompetence(Competence competence) {
        List<CompetenceProfile> competenceProfiles = competenceProfileRepo.findByCompetence(competence);
        List<User> users = userRepo.findByCompetenceProfiles(competenceProfiles);
        return applicationRepo.findByUserIn(users);
    }

    /**
     * This is the method to find applications with specific user's name.
     *
     * @param name The name that searched for.
     * @return The applications that found by the searching specific user's
     * name.
     */
    public List<Application> findApplicationsByName(String name) {
        List<User> users = userRepo.findByNameLike(name);
        return applicationRepo.findByUserIn(users);
    }

    /**
     * This is the method to change application's approval status.
     *
     * @param application The application which should change status.
     * @param status The new status that should be changed to.
     */
    public void changeApprovalStatus(Application application, ApprovalStatus status) {
        application.setApplicationStatus(status);
    }

}
