// /src/main/java/com/usermanagement/core/exceptions/BaseException.java

package com.usermanagement.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Base exception class used across the application.
 *
 * <p>
 * This class extends {@link ResponseStatusException} to provide structured HTTP
 * error responses in a consistent way.
 */
public class BaseException extends ResponseStatusException {

    /**
     * Constructs a new {@code BaseException} with the given message and status.
     *
     * @param status
     *            the HTTP status code to return (e.g. 400 BAD_REQUEST)
     * @param message
     *            the error message to return in the response body
     */
    public BaseException(HttpStatus status, String message) {
        super(status, message);
    }

    /**
     * Constructs a new {@code BaseException} with a default status of 400
     * BAD_REQUEST.
     *
     * @param message
     *            the error message to return in the response body
     */
    public BaseException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
