// /src/main/java/com/usermanagement/utils/ResponseUtil.java

package com.usermanagement.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class ResponseUtil {

  public ServerResponse jsonResponse(HttpStatus status, String message, Map<String, Object> data) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("status_code", status.value());
    body.put("status_name", status.getReasonPhrase());
    body.put("message", message);
    body.put("data", data);

    return ServerResponse.status(status).body(body);
  }

  public ServerResponse jsonResponse(HttpStatus status, String message) {
    return jsonResponse(status, message, null);
  }

  public ServerResponse jsonResponse(HttpStatus status) {
    return jsonResponse(status, null, null);
  }
}
