package com.nepflow.NepenthesManagement.Exception;


public class CloneAlreadyHasASex extends RuntimeException {
    public CloneAlreadyHasASex(String sexAsString) {
        super(String.format("Can´t set Sex since the clone already has a sex: %s",sexAsString));
    }
}