package com.nepflow.UserManagement.Exception;

/**
 * Exception thrown if Auth0 endpoint could not be reached.
 */
public class CouldNotReachAuth0Endpoint extends RuntimeException {

    /**
     * @param message body of auth0 response
     */
    public CouldNotReachAuth0Endpoint(final String message) {
        super(String.format("Endpoint could not be reached: %s"));
    }


}
