// /src/main/java/com/usermanagement/services/user/IUserService.java

package com.usermanagement.services.user;

import com.usermanagement.core.dtos.user.UserRequestDTO;
import com.usermanagement.core.dtos.user.UserResponseDTO;

public interface IUserService {

  UserResponseDTO createUser(UserRequestDTO user);

  UserResponseDTO updateUser(String id, UserRequestDTO user);
}
