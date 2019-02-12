package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

public interface ApplicationDTO {
    
    public Long getApplication_id();
	
    public User getUser();
     
	public Date getApplication_date();

	ApprovalStatus getApplication_status();

}
