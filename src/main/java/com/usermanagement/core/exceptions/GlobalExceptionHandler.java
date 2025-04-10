// src/main/java/com/usermanagement/core/exceptions/GlobalExceptionHandler.java

package com.usermanagement.core.exceptions;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleInvalidJson(HttpMessageNotReadableException ex) {
        return Map.of("status_code", HttpStatus.BAD_REQUEST.value(), "status_name",
                HttpStatus.BAD_REQUEST.getReasonPhrase(), "message",
                "Invalid JSON format. Ensure the request body is correctly formatted.");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleGenericException(Exception ex) {
        return Map.of("status_code", HttpStatus.INTERNAL_SERVER_ERROR.value(), "status_name",
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "message", ex.getMessage());
    }
}
