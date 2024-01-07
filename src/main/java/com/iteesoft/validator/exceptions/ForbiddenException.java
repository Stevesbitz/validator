package com.iteesoft.validator.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ForbiddenException extends IteesoftWebReadyException {

    public ForbiddenException() {
        this(null, null, null);
    }

    public ForbiddenException(String type, String message) {
        this(type, message, null);
    }

    public ForbiddenException(String type, String message, Throwable cause) {
        super(
                HttpStatus.FORBIDDEN.value(),
                type,
                Optional.ofNullable(message).orElse("Access Denied"),
                cause
        );
    }

}