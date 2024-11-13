package com.nepflow.UserManagement.Exception;

/**
 * Exception thrown in case a Token could not be generated.
 */
public class CouldNotGenerateAuth0TokenException extends RuntimeException {
    /**
     * @param message body of auth0 response
     */
    public CouldNotGenerateAuth0TokenException(final String message) {
        super(String.format("Could not generate Auth0 Token: %s", message));
    }
}
