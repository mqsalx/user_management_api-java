package com.usermanagement.services.user.utils;

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

  private UserServiceUtils() {
    // Private constructor to prevent instantiation
  }
}
