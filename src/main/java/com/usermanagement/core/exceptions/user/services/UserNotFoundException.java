package com.usermanagement.core.exceptions.user.services;

import com.usermanagement.core.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/** Exception thrown when a user is not found in the database. */
public class UserNotFoundException extends BaseException {

  /**
   * Constructs a new {@code UserNotFoundException} with the given message.
   *
   * @param message The error message.
   */
  public UserNotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message);
  }
}
