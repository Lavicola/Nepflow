package com.nepflow.UserManagement.Exception;

/**
 * Exception thrown if a User does not exist in Auth0
 */
public class CouldNotRetrieveAuth0UserException extends RuntimeException {
    /**
     * @param auth0Id id of the user who supposedly exists
     */
    public CouldNotRetrieveAuth0UserException(final String auth0Id) {
        super(String.format("User of auth0 Id: %s does not exist", auth0Id));
    }
}
