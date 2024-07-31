package com.azulyoro.back.util;

import java.util.ResourceBundle;
import java.text.MessageFormat;

public class MessageUtil {
    private MessageUtil() {
    }

    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    private static final String ENTITY_NOT_FOUND_MESSAGE = "entity.not_found";
    private static final String ENTITY_CANNOT_DELETE_MESSAGE = "entity.cannot_delete";
    private static final String ENTITY_CANNOT_DELETE_RELATED_ENTITIES = "entity.cannot_delete_related_entities";
    private static final String ENTITY_NOT_FOUND_OR_INACTIVE_MESSAGE = "entity.not_found_or_inactive";
    private static final String DATABASE_ERROR = "database.error";
    private static final String EMAIL_ALREADY_REGISTERED_MESSAGE = "email.already_registered";
    private static final String IDNUMBER_ALREADY_REGISTERED_MESSAGE = "identificacion_number.already_registered";
    private static final String USER_NOT_FOUND = "user.not_found";
    private static final String USER_INACTIVE = "user.inactive";
    private static final String BAD_CREDENTIALS = "login.bad_credentials";
    private static final String FIELD_NOT_VALID = "error.field_not_valid";

    public static String getMessage(String key, Object... params) {
        String messageTemplate = messages.getString(key);
        return MessageFormat.format(messageTemplate, params);
    }

    public static String entityNotFound(Long id) {
        return getMessage(ENTITY_NOT_FOUND_MESSAGE, id);
    }

    public static String entityCannotDelete(Long id, String reason) {
        return getMessage(ENTITY_CANNOT_DELETE_MESSAGE, id, reason);
    }

    public static String entityRelatedCannotDelete(Long id) {
        return getMessage(ENTITY_CANNOT_DELETE_RELATED_ENTITIES, id);
    }

    public static String entityNotFoundOrInactive(Long id) {
        return getMessage(ENTITY_NOT_FOUND_OR_INACTIVE_MESSAGE, id);
    }

    public static String databaseError() {
        return getMessage(DATABASE_ERROR);
    }

    public static String badCredentials(){
        return getMessage(BAD_CREDENTIALS);
    }

    public static String emailAlreadyRegistered(String email) {
        return getMessage(EMAIL_ALREADY_REGISTERED_MESSAGE, email);
    }

    public static String idNumberAlreadyRegistered(Long identificationNumber) {
        return getMessage(IDNUMBER_ALREADY_REGISTERED_MESSAGE, identificationNumber);
    }

    public static String userNotFound(String email) {
        return getMessage(USER_NOT_FOUND, email);
    }

    public static String userInactive(String email) {
        return getMessage(USER_INACTIVE, email);
    }

    public static String fieldNotValid(String field, String reason) {
        return getMessage(FIELD_NOT_VALID, field, reason);
    }
}
