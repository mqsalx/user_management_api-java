// /src/main/java/com/usermanagement/utils/ResponseUtil.java

package com.usermanagement.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.utils.LoggerUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class ResponseUtil {

    public ServerResponse jsonResponse(HttpStatus status, String message, Map<?, ?> data) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("status_code", status.value());
        body.put("status_name", status.getReasonPhrase());

        if (message != null) {
            body.put("message", message);
        }
        if (data != null) {
            body.put("data", data);
        }

        LoggerUtil.info(message);

        return ServerResponse.status(status).body(body);
    }

    public ServerResponse jsonResponse(HttpStatus status, String message) {
        return jsonResponse(status, message, null);
    }

    public ServerResponse jsonResponse(HttpStatus status) {
        return jsonResponse(status, null, null);
    }

    public void filterJsonResponse(HttpServletResponse response, HttpStatus status, String message, Map<?, ?> data) {
        try {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("status_code", status.value());
            body.put("status_name", status.getReasonPhrase());
            if (message != null)
                body.put("message", message);
            if (data != null)
                body.put("data", data);

            LoggerUtil.info(message);

            response.setStatus(status.value());
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getWriter(), body);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to write error response");
            } catch (IOException ignored) {
            }
        }
    }

    public void filterJsonResponse(HttpServletResponse response, HttpStatus status, String message) {
        filterJsonResponse(response, status, message, null);
    }
}
