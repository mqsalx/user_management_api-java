// src/main/java/com/usermanagement/core/exceptions/GlobalErrorAttributes.java

package com.usermanagement.core.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(
      org.springframework.web.context.request.WebRequest webRequest,
      ErrorAttributeOptions options) {
    Map<String, Object> errorAttributes = new HashMap<>();

    Throwable error = getError(webRequest);
    int status = 500;
    String message = "Internal Server Error";

    if (error instanceof ResponseStatusException ex) {
      status = ex.getStatusCode().value();
      message = ex.getReason() != null ? ex.getReason() : ex.getMessage();
    }

    errorAttributes.put("status_code", status);
    errorAttributes.put("status_name", HttpStatus.valueOf(status).getReasonPhrase());
    errorAttributes.put("message", message);

    return errorAttributes;
  }
}
