package se.kth.iv1201.grupp13.recruiterapplication.domain;

/**
 * Defines all operation that can be performed on an {@link ApprovalStatus} outside
 * the application and domain layers.
 */
public interface ApprovalStatusDTO {

    /**
     * Returns the application's approval status Id.
     */
    public Long getApprovalStatusId();

    /**
     * Returns the application's approval status name.
     */    
    public String getName();

}
