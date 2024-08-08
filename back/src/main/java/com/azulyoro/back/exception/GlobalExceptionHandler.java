package com.azulyoro.back.exception;

import com.azulyoro.back.util.MessageUtil;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({CannotDeleteEntityException.class})
    public ResponseEntity<String> handleCannotDeleteEntityException(CannotDeleteEntityException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler({EntityNotFoundOrInactiveException.class})
    public ResponseEntity<String> handleEntityNotFoundOrInactiveException(EntityNotFoundOrInactiveException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> String.format("%s: %s", e.getField(), e.getDefaultMessage()))
                .toList();

        log.error(String.join(" | ", errors));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler({CannotDeleteActiveServicesException.class})
    public ResponseEntity<String> handleCannotDeleteActiveServicesException(CannotDeleteActiveServicesException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(MessageUtil.databaseError());
    }

    @ExceptionHandler({BadCredentialsException.class, UserNotFoundException.class, UserInactiveException.class})
    public ResponseEntity<String> handleAuthenticationExceptions(RuntimeException exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(MessageUtil.badCredentials());
    }

    @ExceptionHandler({UserAlreadyRegistered.class})
    public ResponseEntity<String> handleUserAlreadyRegistered(UserAlreadyRegistered exception) {
        log.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }
}
