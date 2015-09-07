package io.sprucehill.zalando.api.exception;

/**
 * Exception to be throws if an object cannot be found
 *
 * @author Michael Duergner
 */
public class NotFoundException extends Exception {

    /**
     * Create a new NotFoundException with the specified message
     *
     * @param message    The message of the exception
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Create a new NotFoundException with the specified message and causing Throwable
     *
     * @param message    The message of the exception
     * @param cause      The cause of this exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
