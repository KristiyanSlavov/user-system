package com.westernacher.training.usersystem.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * This class represents the UserAccountDto and will acts as wrapper
 * of the {@link com.westernacher.training.usersystem.model.entity.UserAccount}.
 * It will be used in the service layer and the web/controller layer.
 *
 * @author Kristiyan SLavov
 */
public class UserAccountDto {

    private Long id;

    @NotBlank(message = "The first name is required!")
    private String firstName;

    @NotBlank(message = "The last name is required!")
    private String lastName;

    @NotBlank(message = "The email is required!")
    private String email;

    @NotBlank(message = "The date of birth is required!")
    @PastOrPresent(message = "Must be a past or present date!")
    private LocalDate dateOfBirth;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
