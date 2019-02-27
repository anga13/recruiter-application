package se.kth.iv1201.grupp13.recruiterapplication.domain;

/**
 * Defines all operation that can be performed on an {@link Role} outside
 * the application and domain layers.
 */
public interface RoleDTO {
    /**
     * Returns the role Id.
     */
	Long getRoleId();

    /**
     * Returns the role name.
     */
	String getName();

}