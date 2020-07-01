package com.westernacher.training.usersystem.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * It is an entity class and it'll store the details of
 * the users accounts that come from the database.
 *
 * @author Kristiyan SLavov
 */
@Document(collection = "accounts")
public class UserAccount {

    // Unique reference to the auto-incremented sequence
    // for the users_accounts collection.
    // Also annotated with @Transient to prevent it from
    // being persisted alongside other properties of the model.
    @Transient
    public static final String SEQUENCE_NAME = "user_accounts_sequence";

    @Id
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
