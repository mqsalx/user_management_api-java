// /src/main/java/com/usermanagement/api/controllers/AuthController.java

package com.usermanagement.api.controllers.auth;

import com.usermanagement.core.dtos.auth.AuthRequestDTO;
import com.usermanagement.core.dtos.auth.AuthResponseDTO;
import com.usermanagement.services.auth.IAuthService;
import com.usermanagement.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;

@Component
public class AuthController {

    @Autowired
    private IAuthService authService;
    @Autowired
    private ResponseUtil responseUtil;

    public ServerResponse login(ServerRequest request) {
        try {
            AuthRequestDTO credentials = request.body(AuthRequestDTO.class);
            AuthResponseDTO response = authService.authenticate(credentials);
            return responseUtil.jsonResponse(HttpStatus.OK, "Token generated!", Map.of("token", response));
        } catch (Exception e) {
            return responseUtil.jsonResponse(HttpStatus.UNAUTHORIZED, "Invalid credentials!");
        }
    }
}
