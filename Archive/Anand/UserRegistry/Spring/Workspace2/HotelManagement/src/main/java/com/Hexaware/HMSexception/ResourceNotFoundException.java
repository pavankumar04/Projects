package com.Hexaware.HMSexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for ResourceNotFound
 * @author 1000075793
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    /**
     * parameterized constructor.
     * @param msg message
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}