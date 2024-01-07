package com.iteesoft.validator.domains;

public interface ErrorMessage {

    int getStatusCode();

    String getCode();

    String getMessage();

    java.util.Map<String, Object> getData();

    String getRequestMarker();

}
