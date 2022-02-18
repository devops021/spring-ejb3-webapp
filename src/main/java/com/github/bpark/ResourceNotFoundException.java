package com.github.bpark;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 404 Expetion.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 19:29 05.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /** Constructor. */
    public ResourceNotFoundException() {
    }

}
