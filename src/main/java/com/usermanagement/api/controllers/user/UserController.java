// /src/main/java/com/usermanagement/api/controllers/user/UserController.java

package com.usermanagement.api.controllers.user;

import com.usermanagement.core.dtos.user.UserRequestDTO;
import com.usermanagement.core.dtos.user.UserResponseDTO;
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

  public ServerResponse createUserController(ServerRequest request)
      throws ServletException, IOException {
    UserRequestDTO user = request.body(UserRequestDTO.class);
    UserResponseDTO serviceResponse = userService.createUser(user);
    return responseUtil.jsonResponse(
        HttpStatus.CREATED, "User created", Map.of("user", serviceResponse));
  }

  public ServerResponse updateUserController(ServerRequest request)
      throws ServletException, IOException {
    String id = request.pathVariable("id");
    UserRequestDTO user = request.body(UserRequestDTO.class);
    UserResponseDTO serviceResponse = userService.updateUser(id, user);
    return responseUtil.jsonResponse(
        HttpStatus.OK, "User updated", Map.of("user", serviceResponse));
  }

  public ServerResponse getAllUsersController(ServerRequest request) {
    var serviceResponse = userService.getAllUsers();
    return responseUtil.jsonResponse(HttpStatus.OK, "Founded!", serviceResponse);
  }
}
