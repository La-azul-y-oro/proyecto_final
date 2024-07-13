package com.azulyoro.back.exception;

public class CannotDeleteActiveServicesException extends RuntimeException {
    public CannotDeleteActiveServicesException(String message) {
        super(message);
    }
}
