package net.topic.services.exceptions;

/**
 * Basic exception thrown by {@link net.topic.services.AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
public class AccountServiceException extends ServiceException {

    /**
     * @param message   error message.
     * */
    public AccountServiceException(String message) {
        super(message);
    }

    /**
     * @param message   error message.
     * @param cause     rethrown exception.
     * */
    public AccountServiceException(String message, Exception cause) {
        super(message, cause);
    }
}
