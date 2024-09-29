package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

/**
 * Model which represents a Rating  for a Trade.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class TradeRating {


    /**
     * the transition from flower to seeds typically takes months.
     */
    @Transient
    static final int MIN_AGE_TO_RATE_IN_DAYS = 30;

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
    private String comment;

    /**
     *
     */
    @Getter
    private RATING rating;

    /**
     *
     */
    @Getter
    private LocalDate creationDate = LocalDate.now();


    /**
     * @param user
     */
    public TradeRating(final User user) {
        this.user = user;
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


    /**
     * @param comment optional additional information
     * @return true if Rating could be set, else false
     */
    public boolean rateTradeAsSuccess(final String comment) {
        if (this.isRateableNow()) {
            this.rating = RATING.SUCCESS;
            this.comment = comment != null ? comment : "";
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param comment optional additional information
     * @return true if Rating could be set, else false
     */
    public boolean rateTradeAsFailure(final String comment) {
        if (this.isRateableNow()) {
            this.rating = RATING.FAILURE;
            this.comment = comment != null ? comment : "";
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param user user to compare to
     * @return true if the Rating belongs to the user, else false
     */
    public boolean ratingFrom(final User user) {
        return this.user.equals(user);
    }


    /**
     * @return true if the waiting time elapsed and the rating is still pending.
     */
    public boolean isRateableNow() {
        return LocalDate.now().isAfter(this.creationDate.plusDays(MIN_AGE_TO_RATE_IN_DAYS)) && this.rating == RATING.PENDING;
    }


    /**
     * Helper method used for the ModelMapper.
     *
     * @return exact Date as String
     */
    public String getCreationDateAsString() {
        return this.getCreationDate().toString();
    }


}
