package com.iteesoft.validator.exceptions;

import com.iteesoft.validator.domains.ErrorMessage;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends IteesoftWebReadyException {

    public UnauthorizedException() {
        this(null, null, null);
    }

    public UnauthorizedException(String message) {
        this(null, message, null);
    }

    public UnauthorizedException(String type, String message, Throwable cause) {
        super(
                HttpStatus.UNAUTHORIZED.value(),
                type,
                message != null ? message : "Unauthorized access prohibited.",
                cause
        );
    }

    public UnauthorizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

}