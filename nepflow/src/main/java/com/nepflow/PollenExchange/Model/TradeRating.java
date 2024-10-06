package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

/**
 * Model which represents Feedback for a Trade.
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
    @Getter
    private String comment;

    /**
     *
     */
    @Getter
    @Setter
    private String imageLocation;

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
     * the time the Rating was given.
     */
    @Getter
    private LocalDate receivedOn;


    /**
     * @param user
     */
    public TradeRating(final User user) {
        this.user = user;
        this.rating = RATING.PENDING;
    }

    /**
     * allows to set a comment to the rating if it is currently not set.
     *
     * @param comment comment for the rating
     */
    public void setComment(final String comment) {
        if (this.comment == null || this.comment.equals("")) {
            this.comment = comment;
        }

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
     * @param rating if rating should be set to success or failure
     * @return true if Rating could be set, else false
     */
    public boolean rateTrade(final RATING rating) {
        if (this.isRateableNow()) {
            this.rating = rating;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param rating  if rating should be set to success or failure
     * @param comment additional comment to the trade
     * @return true if Rating could be set, else false
     */
    public boolean rateTrade(final RATING rating, final String comment) {
        if (this.isRateableNow()) {
            this.rating = rating;
            this.comment = comment != null ? comment : "";
            this.receivedOn = LocalDate.now();
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
