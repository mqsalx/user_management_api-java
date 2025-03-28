package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/** Main class to start the Spring Boot application. */
@SpringBootApplication(
    exclude = {
      SecurityAutoConfiguration.class,
      UserDetailsServiceAutoConfiguration.class,
    })
public class UserManagementApplication {

  /**
   * Main method to launch the application.
   *
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    SpringApplication.run(UserManagementApplication.class, args);
  }
}
