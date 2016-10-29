package net.topic.services.exceptions;

/**
 * Exception thrown by {@link net.topic.services.BasicOperationsService}.
 *
 * @author Vlad Lukjanenko.
 */
public class ServiceException extends Exception {

    /**
     * @param message   error message.
     * */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @param message   error message.
     * @param cause     rethrown exception.
     * */
    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
