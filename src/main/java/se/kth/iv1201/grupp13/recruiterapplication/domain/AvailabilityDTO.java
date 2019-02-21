package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

public interface AvailabilityDTO {
	
    public User getUser();
    
    public Date getFromDate();   
    
    public Date getToDate();

    public Long getAvailabilityId();   
}
