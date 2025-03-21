package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Main class to start the Spring Boot application. */
@SpringBootApplication
public final class UserManagementApplication {

  private UserManagementApplication() {
    // Private constructor to prevent instantiation
  }

  /**
   * Main method to launch the application.
   *
   * @param args Command-line arguments.
   */
  public static void main(final String[] args) {
    SpringApplication.run(UserManagementApplication.class, args);
  }
}
