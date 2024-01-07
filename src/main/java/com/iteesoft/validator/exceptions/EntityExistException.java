package com.iteesoft.validator.exceptions;

import org.springframework.http.HttpStatus;

public class EntityExistException extends IteesoftWebReadyException {

    public EntityExistException() {
        this(null, null, null);
    }

    public EntityExistException(Throwable cause) {
        this(null, null, cause);
    }

    public EntityExistException(String message) {
        this(null, message, null);
    }

    public EntityExistException(String type, String message, Throwable cause) {
        super(
                HttpStatus.BAD_REQUEST.value(),
                type != null ? type : "ENTITY_ALREADY_EXISTS",
                message != null ? message : "Attempted to create an entity that already exists.",
                cause
        );
    }

}

