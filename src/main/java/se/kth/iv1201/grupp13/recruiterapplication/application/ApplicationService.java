package se.kth.iv1201.grupp13.recruiterapplication.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
     * Fetches the users with the specified name.
     * @param name The name of the user.
     * @return The list of the users found, or null if none found.
     */
    public List<User> findUsersByName(String name) {
        return userRepo.findByNameLike(name);
    }    
    
    /**
     * This is the method that get the current date when an application is sent.
     *
     * @return The application date that can be identified by SQL.
     */
    public Date getApplicationDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return new java.sql.Date(date.getTime());
    }
    
    /**
     * This is the method that convert a string of date to the date format that SQL can identify.
     * @param dateString The dateString to be converted.
     * @return The SQL date.
     */    
    private Date convertToSqlDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(dateString);
        return new java.sql.Date(date.getTime());
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
     * @param requiredStartDate The required date from which the applicant can
     * begin to work.
     * @param requiredEndDate The required date from which the applicant can end
     * the work.
     * @return The applications that found by the searching time period the
     * applicant can work.
     */
    public List<ApplicationDTO> getApplicationsByWorkingTime(Date requiredStartDate, Date requiredEndDate){
        List<User> users = userRepo.findAll();
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        for(User user: users){
            List<Availability> availabilities = availabilityRepo.findByUser(user);
            for(Availability availability: availabilities){
                Date fromDate = availability.getFromDate();
                Date toDate = availability.getToDate();  
                if(fromDate.compareTo(requiredStartDate)<0&&toDate.compareTo(requiredEndDate)>0) {
                	ApplicationDTO app=applicationRepo.findByUser(user);
                	applicationDTOS.add(app);
                }
            }
        }
        return applicationDTOS;
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
    public List<ApplicationDTO> getApplicationsByCompetence(Competence competence){
        List<User> users = userRepo.findAll();
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        for(User user: users){
            List<CompetenceProfile> competenceProfiles = competenceProfileRepo.findByUser(user);
            for(CompetenceProfile competenceProfile: competenceProfiles){
                if(competence.equals(competenceProfile.getCompetence())) {
                	ApplicationDTO app=applicationRepo.findByUser(user);
                	applicationDTOS.add(app);
                }
            }
        }
        return applicationDTOS;
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
