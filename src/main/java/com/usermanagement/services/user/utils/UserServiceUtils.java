package com.usermanagement.services.user.utils;

import com.usermanagement.core.dtos.user.UserResponseDTO;
import com.usermanagement.infrastructure.models.user.UserEntity;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/** Utility class for UserService-related operations such as password hashing. */
public class UserServiceUtils {

  private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /**
   * Generates a hashed password using BCrypt.
   *
   * @param rawPassword The plain text password to be hashed.
   * @return The hashed password.
   */
  public static String hashPassword(String rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }

  public static UserResponseDTO entityConvertToResponseDTO(UserEntity user) {
    return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
  }

  public static Map<String, Map<String, Object>> formatUsersAsMap(List<UserResponseDTO> users) {
    return users.stream()
        .collect(
            Collectors.toMap(
                UserResponseDTO::getId,
                user ->
                    Map.of(
                        "name", user.getName(),
                        "email", user.getEmail())));
  }

  private UserServiceUtils() {
    // Private constructor to prevent instantiation
  }
}
