package com.nepflow.NepenthesManagement.Exception;



//Nepenthes does not exist
// Hybrid cultivar does not exists
// MultiHybrid cultivar does not exist
// IllFormedLabel
public class InvalidLabelFormatException extends RuntimeException {
    public InvalidLabelFormatException(String message) {
        super(message);
    }
}

