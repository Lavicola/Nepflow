package com.nepflow.PollenExchange.Exception;

public class PollenOfferIsExpired extends RuntimeException{

    public PollenOfferIsExpired(boolean isExpired1,boolean isExpired2) {
        super(String.format("PollenOffer is expired!: First Offer expired: %s and requested: %s", isExpired1, isExpired2));

    }
}


