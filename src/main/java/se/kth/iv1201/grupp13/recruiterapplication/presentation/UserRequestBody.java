/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1201.grupp13.recruiterapplication.presentation;

import java.util.Set;
import se.kth.iv1201.grupp13.recruiterapplication.domain.AvailabilityDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.CompetenceProfileDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.RoleDTO;
import se.kth.iv1201.grupp13.recruiterapplication.domain.UserDTO;

/**
 *
 * @author anders
 *
 * A helper class representing a User request object
 */
class UserRequestBody implements UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String ssn;
    private String email;
    private RoleDTO role;
    private Set<CompetenceProfileDTO> competenceProfiles;
    private Set<AvailabilityDTO> availabilities;

    public UserRequestBody() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public void setCompetenceProfiles(Set<CompetenceProfileDTO> competenceProfiles) {
        this.competenceProfiles = competenceProfiles;
    }

    public void setAvailabilities(Set<AvailabilityDTO> availabilities) {
        this.availabilities = availabilities;
    }

    @Override
    public Long getPersonId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getSsn() {
        return ssn;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public RoleDTO getRole() {
        return role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Set<CompetenceProfileDTO> getCompetenceProfiles() {
        return competenceProfiles;
    }

    @Override
    public Set<AvailabilityDTO> getAvailabilities() {
        return availabilities;
    }

}
