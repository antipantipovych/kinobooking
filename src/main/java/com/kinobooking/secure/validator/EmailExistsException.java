package com.kinobooking.secure.validator;

/**
 * Created by Екатерина on 16.08.2017.
 */
@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}
