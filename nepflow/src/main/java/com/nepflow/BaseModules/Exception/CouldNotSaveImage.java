package com.nepflow.BaseModules.Exception;

public class CouldNotSaveImage extends RuntimeException {

    /**
     * @param message body of auth0 response
     */
    public CouldNotSaveImage(final String message) {
        super(String.format("Could not save Image: %s", message));
    }


}