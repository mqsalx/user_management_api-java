// /src/main/java/com/usermanagement/api/controllers/user/UserController.java

package com.usermanagement.api.controllers.user;

import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.services.user.IUserService;
import jakarta.servlet.ServletException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class UserController {

  @Autowired private IUserService userService;

  public ServerResponse createUserRoute(ServerRequest request)
      throws ServletException, IOException {
    UserEntity user = request.body(UserEntity.class);
    UserEntity createdUser = userService.createUser(user);
    return ServerResponse.ok().body(createdUser);
  }
}
