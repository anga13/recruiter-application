package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

/**
 * Defines all operation that can be performed on an {@link Application} outside
 * the application and domain layers.
 */
public interface ApplicationDTO {
    /**
     * Returns the application Id.
     */
    public Long getApplicationId();

    /**
     * Returns the application user. An application always has exactly one user.
     */
    public User getUser();
    
    /**
     * Returns the application date. An application always has exactly one application date.
     */
    public Date getApplicationDate();

    /**
     * Returns the application status. An application always has exactly one application status.
     */    
    public ApprovalStatus getApplicationStatus();

}
