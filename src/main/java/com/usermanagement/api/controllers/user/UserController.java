// /src/main/java/com/usermanagement/api/controllers/user/UserController.java

package com.usermanagement.api.controllers.user;

import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.services.user.IUserService;
import com.usermanagement.utils.ResponseUtil;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class UserController {

  @Autowired private IUserService userService;
  @Autowired private ResponseUtil responseUtil;

  public ServerResponse createUserRoute(ServerRequest request)
      throws ServletException, IOException {
    UserEntity user = request.body(UserEntity.class);
    UserResponseDTO serviceResponse = userService.createUser(user);
    return responseUtil.jsonResponse(
        HttpStatus.CREATED, "User created", Map.of("user", serviceResponse));
  }
}
