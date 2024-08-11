package com.nepflow.PollenExchange.Exception;

public class PollenOfferIsClosedException extends RuntimeException{
    public PollenOfferIsClosedException(boolean isOpen1,boolean isOpen2){
        super(String.format("Pollenoffer is closed!: First Offer open: %s and requested: %s",isOpen1,isOpen2));

    }

}
