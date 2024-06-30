package com.nepflow.NepenthesManagement.Exception;

public class ProducerIsNullException extends RuntimeException {
    public ProducerIsNullException(String cloneId) {
        super(String.format("The Clone(%s) has apparently no Producer set",cloneId));
    }
}

