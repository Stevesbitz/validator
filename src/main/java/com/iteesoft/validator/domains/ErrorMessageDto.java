package com.iteesoft.validator.domains;

import com.iteesoft.validator.domains.ErrorMessage;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorMessageDto implements ErrorMessage {

    private String code;
    private String message;
    private int statusCode;
    private Map<String, Object> data;
    private String requestMarker;

}