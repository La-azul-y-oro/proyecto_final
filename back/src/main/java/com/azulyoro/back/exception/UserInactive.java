package com.azulyoro.back.exception;

public class UserInactive extends RuntimeException {
    public UserInactive(String message) {
        super(message);
    }
}
