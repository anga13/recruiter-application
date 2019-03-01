package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

/**
 * Defines all operation that can be performed on an {@link Availability} outside
 * the application and domain layers.
 */
public interface AvailabilityDTO {

    /**
     * Returns the availability's owner.
     */
    public User getUser();

    /**
     * Returns the availability's from_date.
     */
    public Date getFromDate();   

    /**
     * Returns the availability's to_date.
     */
    public Date getToDate();

    /**
     * Returns the availability id.
     */
    public Long getAvailabilityId();   
}
