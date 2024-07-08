package com.azulyoro.back.util;

public interface RegexPatterns {
    String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    String PHONE_PATTERN = "\\d{10}";
}
