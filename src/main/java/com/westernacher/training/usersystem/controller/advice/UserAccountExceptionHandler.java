package com.westernacher.training.usersystem.controller.advice;

import com.westernacher.training.usersystem.model.error.ErrorResponse;
import com.westernacher.training.usersystem.model.exception.UserAccountDuplicateKeyException;
import com.westernacher.training.usersystem.model.exception.UserAccountNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserAccountExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method handles exceptions of type {@link UserAccountExceptionHandler}
     * and return a {@link ResponseEntity} instance
     * which contains custom {@link ErrorResponse} and {@link HttpStatus}
     * @param ex - the exception that would be handled
     * @return - a {@link ResponseEntity} instance
     */
    @ExceptionHandler(UserAccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserAccountNotFound(Exception ex) {
        ErrorResponse errors = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles exceptions of type {@link UserAccountDuplicateKeyException}
     * and return a {@link ResponseEntity} instance
     * which contains custom {@link ErrorResponse} and {@link HttpStatus}
     * @param ex - the exception that would be handled
     * @return - a {@link ResponseEntity} instance
     */
    @ExceptionHandler(UserAccountDuplicateKeyException.class)
    public ResponseEntity<ErrorResponse> handleMoviesDuplicateKey(Exception ex) {
        ErrorResponse errors = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * This method handles exceptions of type {@link TypeMismatchException},
     * customize and return a {@link ResponseEntity}.
     * It indicates that the server cannot or will not process the request
     * due to something that is perceived to be a client error.
     * @param ex - the exception that would be handled
     * @param headers - the headers to be written to the response
     * @param status - the selected response status
     * @param request - the current request
     * @return a {@link ResponseEntity} instance
     */
    @Override
    public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
                                                     HttpHeaders headers,
                                                     HttpStatus status,
                                                     WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles exceptions of type {@link HttpMessageNotReadableException},
     * customize and return a {@link ResponseEntity}.
     * It indicates that the server cannot or will not process the request
     * due to something that is perceived to be a client error.
     * @param ex - the exception that would be handled
     * @param headers - the headers to be written to the response
     * @param status - the selected response status
     * @param request - the current request
     * @return a {@link ResponseEntity} instance
     */
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                ex.getCause().getMessage(),
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
