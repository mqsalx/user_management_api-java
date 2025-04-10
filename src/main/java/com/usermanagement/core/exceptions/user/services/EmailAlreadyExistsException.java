// /src/main/java/com/usermanagement/core/exceptions/user/services/EmailAlreadyExistsException.java

package com.usermanagement.core.exceptions.user.services;

import com.usermanagement.core.exceptions.BaseException;
import org.springframework.http.HttpStatus;

/** Exception thrown when a user email is already registered in the system. */
public class EmailAlreadyExistsException extends BaseException {

    /**
     * Constructs a new {@code EmailAlreadyExistsException} with the given message.
     *
     * @param message
     *            The error message.
     */
    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
