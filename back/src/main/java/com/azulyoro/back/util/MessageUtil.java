package com.azulyoro.back.util;

import java.util.ResourceBundle;
import java.text.MessageFormat;

public class MessageUtil {
    private MessageUtil() {
    }

    private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

    private static final String ENTITY_NOT_FOUND_MESSAGE = "entity.not_found";
    private static final String ENTITY_CANNOT_DELETE_MESSAGE = "entity.cannot_delete";
    private static final String ENTITY_CANNOT_DELETE_SERVICE_MESSAGE = "entity.cannot_delete_service";
    private static final String ENTITY_NOT_FOUND_OR_INACTIVE_MESSAGE = "entity.not_found_or_inactive";

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
        return getMessage(ENTITY_CANNOT_DELETE_SERVICE_MESSAGE, id);
    }

    public static String entityNotFoundOrInactive(Long id) {
        return getMessage(ENTITY_NOT_FOUND_OR_INACTIVE_MESSAGE, id);
    }
}