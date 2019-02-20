package se.kth.iv1201.grupp13.recruiterapplication.domain;

import java.util.Set;

public interface UserDTO {

    public Long getPersonId();

	public String getName();

	public String getSurname();

	public String getSsn();

	public String getEmail();

	public String getPassword();

	public RoleDTO getRole();

	public String getUsername();

	Set<CompetenceProfile> getCompetenceProfiles();

	Set<Availability> getAvailabilities();
}
