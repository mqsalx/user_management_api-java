// /src/main/java/com/usermanagement/utils/Response.java

package com.usermanagement.utils;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Response {
  private int statusCode;
  private String statusName;
  private String message;
  private Map<String, Object> data;

  public Response(HttpStatus status, String message, Map<String, Object> data) {
    this.statusCode = status.value();
    this.statusName = status.getReasonPhrase();
    this.message = message;
    this.data = data;
  }

  public Response(HttpStatus status, String message) {
    this(status, message, null);
  }

  public Response(HttpStatus status) {
    this(status, null, null);
  }
}
