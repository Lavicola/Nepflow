package com.nepflow.PollenExchange.Exception;

public class TradePollenOfferSameSexException extends RuntimeException{

    public TradePollenOfferSameSexException(String sex1, String sex2) {
        super(String.format("Both PollenOffers have the  same Sex initiated: %s and requested: %s", sex1, sex2));

    }

}
