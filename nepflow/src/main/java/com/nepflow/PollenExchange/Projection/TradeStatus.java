package com.nepflow.PollenExchange.Projection;

import com.nepflow.PollenExchange.Model.TradeRating;
import lombok.Getter;

import java.time.LocalDate;


/**
 * This Projection contains attributes which contains the TradeId and Status of a Trade
 * for a specific User.
 * E.g. if user got a positive Rating then the Status is SUCCESS.
 * This means the TradeStatus may differ between two users.
 */
@Getter
public class TradeStatus {

    /**
     *
     */
    private String tradeId;

    /**
     *
     */
    private TradeRating.RATING rating;

    /**
     *
     */
    private LocalDate creationDate;


}
