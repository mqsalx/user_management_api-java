// /src/main/java/com/usermanagement/services/user/impl/UserServiceImpl.java

package com.usermanagement.services.user.impl;

import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.core.exceptions.BaseException;
import com.usermanagement.core.exceptions.user.services.EmailAlreadyExistsException;
import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.infrastructure.repositories.user.IUserRepository;
import com.usermanagement.services.user.IUserService;
import com.usermanagement.services.user.utils.UserServiceUtils;
import com.usermanagement.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final IUserRepository userRepository;

  @Autowired
  public UserServiceImpl(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponseDTO createUser(UserEntity user) {
    try {

      this.checkUserEmail(user.getEmail());

      String hashedPassword = UserServiceUtils.hashPassword(user.getPassword());
      user.setPassword(hashedPassword);

      UserEntity created = userRepository.createUser(user);

      UserResponseDTO serviceResponse = UserServiceUtils.entityConvertToDTO(created);

      return serviceResponse;

    } catch (BaseException e) {
      LoggerUtil.error("Error during user creation: " + e.getMessage());
      throw e;

    } catch (Exception e) {
      LoggerUtil.error("Error during user creation: " + e.getMessage());
      throw new RuntimeException("Failed to create user", e);
    }
  }

  private void checkUserEmail(String email) {

    if (userRepository.findUserByEmail(email) != null) {
      throw new EmailAlreadyExistsException("User with email " + email + " already exists!");
    }
  }
}
