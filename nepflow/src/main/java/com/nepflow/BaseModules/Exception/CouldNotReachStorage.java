package com.nepflow.BaseModules.Exception;

public class CouldNotReachStorage extends RuntimeException {

    /**
     * @param message body of auth0 response
     */
    public CouldNotReachStorage(final String message) {
        super(String.format("Could not Reach Storage: %s", message));
    }


}