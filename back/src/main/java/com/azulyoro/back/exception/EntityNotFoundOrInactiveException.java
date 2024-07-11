package com.azulyoro.back.exception;

public class EntityNotFoundOrInactiveException extends RuntimeException {
    public EntityNotFoundOrInactiveException(String message) {
        super(message);
    }
}
