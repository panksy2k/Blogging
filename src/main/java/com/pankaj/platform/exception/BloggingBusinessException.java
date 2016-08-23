package com.pankaj.platform.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by pardasap on 09/02/2016.
 */

public class BloggingBusinessException extends RuntimeException {
    private static final long serialVersionUID = 2908618315971075004L;
    private HttpStatus statusCode;

    /**
     * Creates a new exception.
     */
    public BloggingBusinessException() {}

    /**
     * Creates a new exception.
     */
    public BloggingBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new exception.
     */
    public BloggingBusinessException(String message) {
        super(message);
    }

    public BloggingBusinessException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Creates a new exception.
     */
    public BloggingBusinessException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
