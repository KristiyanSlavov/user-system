package com.westernacher.training.usersystem.model.dto;

import java.time.LocalDate;

/**
 * This class represents the UserAccountDto and will acts as wrapper
 * of the {@link com.westernacher.training.usersystem.model.entity.UserAccount}.
 * It will be used in the service layer and the web/controller layer.
 *
 * @author Kristiyan SLavov
 */
public class UserAccountDto {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
