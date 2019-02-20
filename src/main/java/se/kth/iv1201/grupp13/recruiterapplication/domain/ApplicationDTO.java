package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Date;

public interface ApplicationDTO {

    public Long getApplicationId();

    public User getUser();

    public Date getApplicationDate();

    ApprovalStatus getApplicationStatus();

}
