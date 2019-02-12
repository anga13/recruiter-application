package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

public interface AvailabilityDTO {
    
    public Long getAvailability_id();
	
    public User getUser();
    
    public Date getFrom_date();   
    
    public Date getTo_date();   
}
