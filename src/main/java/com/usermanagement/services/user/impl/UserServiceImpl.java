// /src/main/java/com/usermanagement/services/user/impl/UserServiceImpl.java

package com.usermanagement.services.user.impl;

import com.usermanagement.core.dtos.user.UserRequestDTO;
import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.core.exceptions.BaseException;
import com.usermanagement.core.exceptions.user.services.EmailAlreadyExistsException;
import com.usermanagement.core.exceptions.user.services.UserNotFoundException;
import com.usermanagement.core.mappers.user.UserMapper;
import com.usermanagement.infrastructure.models.user.UserEntity;
import com.usermanagement.infrastructure.repositories.user.IUserRepository;
import com.usermanagement.services.user.IUserService;
import com.usermanagement.services.user.utils.UserServiceUtils;
import com.usermanagement.utils.LoggerUtil;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        try {
            this.checkUserEmail(userDTO.getEmail());

            String hashedPassword = UserServiceUtils.hashPassword(userDTO.getPassword());
            userDTO.setPassword(hashedPassword);

            UserEntity user = userMapper.toEntity(userDTO);
            UserEntity created = userRepository.createUser(user);

            return userMapper.toResponseDTO(created);

        } catch (BaseException e) {
            LoggerUtil.error("Error during user creation: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LoggerUtil.error("Error during user creation: " + e.getMessage());
            throw new RuntimeException("Failed to create user", e);
        }
    }

    @Override
    public UserResponseDTO updateUser(String id, UserRequestDTO userDTO) {
        try {
            UserEntity existingUser = userRepository.findUserById(id);
            if (existingUser == null) {
                throw new UserNotFoundException("User with ID " + id + " not found!");
            }

            if (userDTO.getEmail() != null && !userDTO.getEmail().equals(existingUser.getEmail())
                    && userRepository.findUserByEmail(userDTO.getEmail()) != null) {
                throw new EmailAlreadyExistsException("Email already in use!");
            }

            if (userDTO.getPassword() != null) {
                userDTO.setPassword(UserServiceUtils.hashPassword(userDTO.getPassword()));
            }

            userMapper.updateUserFromDTO(userDTO, existingUser);

            UserEntity updated = userRepository.updateUser(existingUser);

            return userMapper.toResponseDTO(updated);

        } catch (BaseException e) {
            LoggerUtil.error("Error during user update: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LoggerUtil.error("Unexpected error during user update: " + e.getMessage());
            throw new RuntimeException("Failed to update user", e);
        }
    }

    @Override
    public Map<String, Map<String, Object>> getAllUsers() {
        List<UserResponseDTO> dtos = userRepository.findAllUsers().stream().map(userMapper::toResponseDTO).toList();

        return UserServiceUtils.formatUsersAsMap(dtos);
    }

    @Override
    public Map<String, Object> getUserById(String id) {
        UserEntity userEntity = userRepository.findUserById(id);
        if (userEntity == null) {
            throw new UserNotFoundException("User with ID " + id + " not found!");
        }

        UserResponseDTO dto = userMapper.toResponseDTO(userEntity);
        return UserServiceUtils.formatUserAsMap(dto);
    }

    @Override
    public void deleteUser(String id) {
        UserEntity user = userRepository.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with ID " + id + " not found!");
        }
        userRepository.deleteUser(user);
    }

    private void checkUserEmail(String email) {
        if (userRepository.findUserByEmail(email) != null) {
            throw new EmailAlreadyExistsException("User with email " + email + " already exists!");
        }
    }
}
