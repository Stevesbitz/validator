package com.iteesoft.validator.exceptions;

import com.iteesoft.validator.domains.ErrorMessage;
import com.iteesoft.validator.domains.ErrorMessageDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.UUID;

@Getter
public class IteesoftWebReadyException extends RuntimeException {

    private final ErrorMessage error;
    private static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";

    public IteesoftWebReadyException(int statusCode, String errorCode, String message, Throwable cause) {
        super(message, cause);
        String request = UUID.randomUUID().toString();
        this.error = ErrorMessageDto.builder()
                .code(Optional.ofNullable(errorCode).orElse(UNKNOWN_ERROR))
                .requestMarker(request)
                .statusCode(statusCode)
                .message(message)
                .build();
    }

    public IteesoftWebReadyException(int statusCode, String errorCode, String message) {
        this(statusCode, errorCode, message, null);
    }

    public IteesoftWebReadyException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.error = errorMessage;
    }

    public int getStatusCode() {
        return error != null ? error.getStatusCode() : HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
