package com.nepflow.PollenExchange.Projection;

import com.nepflow.PollenExchange.Model.TradeRating;
import lombok.Getter;

/**
 * This Projection contains attributes which shows the received Feedback of user.
 */

@Getter
public class UserRating {

    /**
     *
     */
    private String tradeId;

    /**
     * user who did rate.
     */
    private String rater;

    /**
     *
     */
    private TradeRating rating;


}


