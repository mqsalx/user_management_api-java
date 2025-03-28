// /src/main/java/com/usermanagement/infrastructure/repositories/user/IUserRepository.java

package com.usermanagement.infrastructure.repositories.user;

import com.usermanagement.infrastructure.models.user.UserEntity;

public interface IUserRepository {
  UserEntity createUser(UserEntity user);

  UserEntity findUserByEmail(String email);
}
