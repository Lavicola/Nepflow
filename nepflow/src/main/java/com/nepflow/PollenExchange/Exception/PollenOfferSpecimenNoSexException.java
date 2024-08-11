package com.nepflow.PollenExchange.Exception;

public class PollenOfferSpecimenNoSexException extends RuntimeException{


    public PollenOfferSpecimenNoSexException(String specimenId){
        super(String.format("The specimen with id %s has no sex!",specimenId));
    }
}
