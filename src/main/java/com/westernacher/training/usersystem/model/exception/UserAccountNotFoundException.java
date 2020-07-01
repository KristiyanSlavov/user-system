package com.westernacher.training.usersystem.model.exception;

/**
 * It is a custom exception that will be send to the user
 * if some requested user account is not found in the database.
 *
 * @author Kristiyan SLavov
 */
public class UserAccountNotFoundException extends Exception {

    public UserAccountNotFoundException(String message) {
        super(message);
    }
}
