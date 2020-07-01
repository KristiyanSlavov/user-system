package com.westernacher.training.usersystem.model.exception;

/**
 * It is a custom exception that will be sent to the user
 * if he tries to insert the same user account twice.
 *
 * @author Kristiyan SLavov
 */
public class UserAccountDuplicateKeyException extends Exception{
    public UserAccountDuplicateKeyException(String message) {
        super(message);
    }
}
