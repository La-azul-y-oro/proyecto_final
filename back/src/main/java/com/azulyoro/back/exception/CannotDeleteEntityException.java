package com.azulyoro.back.exception;

public class CannotDeleteEntityException extends RuntimeException {
    public CannotDeleteEntityException(String message){ super(message);}
}
