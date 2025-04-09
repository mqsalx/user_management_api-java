// /src/main/java/com/usermanagement/infrastructure/repositories/user/IUserRepository.java

package com.usermanagement.infrastructure.repositories.user;

import com.usermanagement.infrastructure.models.user.UserEntity;
import java.util.List;

public interface IUserRepository {
  UserEntity createUser(UserEntity user);

  UserEntity findUserByEmail(String email);

  UserEntity findUserById(String id);

  UserEntity updateUser(UserEntity user);

  List<UserEntity> findAllUsers();
}
