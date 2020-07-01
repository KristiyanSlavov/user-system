package com.westernacher.training.usersystem.model.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kristiyan SLavov
 * <p>
 * The custom error response class.
 * It represent the actual error response
 * that will be sent to the user when some exception is catched.
 */
public class ErrorResponse {

    private final String message;

    private final int httpStatus;

    private final String httpError;

    private final LocalDateTime dateTime;

    public ErrorResponse(String message,
                         HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus.value();
        this.httpError = httpStatus.getReasonPhrase();
        this.dateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getHttpError() {
        return httpError;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
