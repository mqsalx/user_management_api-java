// /src/main/java/com/usermanagement/services/user/IUserService.java

package com.usermanagement.services.user;

import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.infrastructure.models.user.UserEntity;

public interface IUserService {
  UserResponseDTO createUser(UserEntity user);
}
