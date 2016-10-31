package net.topic.services.exceptions;

/**
 * Basic exception thrown by {@link net.topic.services.AuthorService}.
 *
 * @author Vlad Lukjanenko.
 */
public class AuthorServiceException extends ServiceException {

    /**
     * @param message   error message.
     * */
    public AuthorServiceException(String message) {
        super(message);
    }

    /**
     * @param message   error message.
     * @param cause     rethrown exception.
     * */
    public AuthorServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
