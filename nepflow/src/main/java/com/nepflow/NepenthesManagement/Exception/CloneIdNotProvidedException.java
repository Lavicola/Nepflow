package com.nepflow.NepenthesManagement.Exception;

public class CloneIdNotProvidedException extends RuntimeException {
    public CloneIdNotProvidedException() {
        super("The Clone does not have a Clone Id, which must be given");
    }
}

