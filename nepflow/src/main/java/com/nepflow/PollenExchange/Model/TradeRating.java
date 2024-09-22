package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Model which represents a Rating  for a Trade.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class TradeRating {

    /**
     *
     */
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    /**
     *
     */
    @Relationship("RATED_BY")
    @Getter
    private User user;
    /**
     *
     */
    @Relationship("RATING_FOR")
    @Getter
    private Trade trade;

    /**
     *
     */
    private String comment;

    /**
     *
     */
    @Getter
    private RATING rating;


    /**
     * @param user
     * @param trade
     */
    public TradeRating(final User user, final Trade trade) {
        this.user = user;
        this.trade = trade;
        this.rating = RATING.PENDING;
    }

    /**
     * @param comment
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     *
     */
    public void rateTradeAsSuccess() {
        this.rating = RATING.SUCCESS;
    }

    /**
     *
     */
    public void rateTradeAsFailure() {
        this.rating = RATING.FAILURE;
    }


    /**
     *
     */
    public enum RATING {
        /**
         *
         */
        SUCCESS,
        /**
         *
         */
        FAILURE,
        /**
         *
         */
        PENDING

    }


}
