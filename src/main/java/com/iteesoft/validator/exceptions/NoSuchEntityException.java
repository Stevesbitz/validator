package com.iteesoft.validator.exceptions;

import com.iteesoft.validator.exceptions.IteesoftWebReadyException;
import org.springframework.http.HttpStatus;

public class NoSuchEntityException extends IteesoftWebReadyException {

    public NoSuchEntityException() {
        this(null, null, null);
    }

    public NoSuchEntityException(String message) {
        this(null, message, null);
    }

    public NoSuchEntityException(Throwable cause) {
        this(null, null, cause);
    }

    public NoSuchEntityException(String code, String message, Throwable cause) {
        super(
                HttpStatus.NOT_FOUND.value(),
                code,
                message != null ? message : "Requested item does not exist.",
                cause
        );
    }

}
