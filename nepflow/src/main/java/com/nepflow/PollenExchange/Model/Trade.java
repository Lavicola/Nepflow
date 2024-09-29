package com.nepflow.PollenExchange.Model;

import com.nepflow.PollenExchange.Exception.PollenOfferIsClosedException;
import com.nepflow.PollenExchange.Exception.TradePollenOfferSameSexException;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Model which represents a Trade referencing PollenOffers and Users.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class Trade {
    /**
     *
     */
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    /**
     * One user must initiate a Trade, this member represents this PollenOffer.
     */
    @Relationship(value = "OFFERS", direction = Relationship.Direction.OUTGOING)
    @Getter
    private PollenOffer initiatedOffer;

    /**
     *
     */
    @Relationship(value = "WANTS", direction = Relationship.Direction.OUTGOING)
    @Getter
    private PollenOffer requestedOffer;

    /**
     *
     */
    @Relationship(value = "INITIATED", direction = Relationship.Direction.OUTGOING)
    private User userOffers;

    /**
     *
     */
    @Relationship(value = "RATING_FOR", direction = Relationship.Direction.OUTGOING)
    private List<TradeRating> ratings;

    /**
     * exact Date the Trade was initiated.
     */
    @Getter
    private LocalDate tradeOpenedDate = LocalDate.now();

    /**
     * exact Date the Trade status changed.
     */
    @Getter
    private LocalDate tradeStatusChanged;


    /**
     *
     */
    @Relationship(value = "NEEDS_TO_ANSWER", direction = Relationship.Direction.OUTGOING)
    private TradeUserAnswersRelationshipValue userWhichAnswers;

    /**
     * @param pollenOffer    one user must initiate a Trade, this PollenOffer represents this exact PollenOffer
     * @param requestedOffer the PollenOffer which the initiated user requested.
     */
    public Trade(final PollenOffer pollenOffer, final PollenOffer requestedOffer) {
        if (pollenOffer.getSexAsString().equals(requestedOffer.getSexAsString())) {
            throw new TradePollenOfferSameSexException(pollenOffer.getSexAsString(), requestedOffer.getSexAsString());
        }
        if (!pollenOffer.isOpen() || !requestedOffer.isOpen()) {
            throw new PollenOfferIsClosedException(pollenOffer.isOpen(), requestedOffer.isOpen());
        }


        this.userOffers = pollenOffer.getUser();
        this.initiatedOffer = pollenOffer;
        this.requestedOffer = requestedOffer;
        this.userWhichAnswers = new TradeUserAnswersRelationshipValue(requestedOffer.getUser());
    }

    /**
     * @param user user to be checked if allowed to answer the trade
     * @return true if given User is allowed
     */
    public boolean isAllowedToAnswerTrade(final User user) {
        return this.isTradeOpen() && this.userWhichAnswers.getUser().equals(user);
    }


    /**
     * Helper method used for the ModelMapper.
     *
     * @return exact Date as String
     */
    public String convertOpenedDay() {
        return this.getTradeOpenedDate().toString();
    }


    /**
     * @return User who is allowed to Answer the Trade
     */
    public User getUserWhoAnswersTrade() {
        return this.userWhichAnswers.getUser();
    }

    /**
     * @return User who initiated the Trade
     */
    public User getUserWhoInitiatedTrade() {
        return this.userOffers;
    }


    /**
     *
     */
    public void refuseTrade() {
        this.userWhichAnswers.refuseTrade();
    }

    /**
     * Accept the Trade and create Ratings.
     */
    public void acceptTrade() {
        this.setTradeStatusChanged();
        this.userWhichAnswers.acceptTrade();
        this.ratings = new ArrayList<>(2);
        this.ratings.add(new TradeRating(this.getUserWhoAnswersTrade()));
        this.ratings.add(new TradeRating(this.getUserWhoInitiatedTrade()));
    }

    /**
     *
     */
    public void setTradeToExpired() {
        this.setTradeStatusChanged();
        this.userWhichAnswers.setTradeToExpired();
    }


    /**
     * If not set yet, sets the TradeStatusChange value to the current Date.
     */
    private void setTradeStatusChanged() {
        if (this.tradeStatusChanged == null) {
            this.tradeStatusChanged = LocalDate.now();

        }
    }

    /**
     * @param user user to be checked if he is part of the Trade
     * @return true if user is part of Trade, else false
     */
    public boolean isUserPartOfTrade(final User user) {
        return this.userWhichAnswers.getUser().equals(user) || this.userOffers.equals(user);

    }

    /**
     * @return true if trade was refused
     */
    public boolean wasTradeRefused() {
        return this.userWhichAnswers.wasTradeRefused();
    }

    /**
     * @return true if trade was  accepted
     */
    public boolean wasTradeAccepted() {
        return this.userWhichAnswers.wasTradeAccepted();
    }

    /**
     * @return true if trade is not yet answered
     */
    public boolean isTradeOpen() {
        return this.userWhichAnswers.isTradeOpen();
    }

    /**
     * @return true if one of the PollenOffers is not open anymore
     */
    public boolean isTradeExpired() {
        return !(this.initiatedOffer.isOpen() && this.requestedOffer.isOpen());

    }

    /**
     * @return current Trading status as String
     */
    public String getTradeStatus() {
        return this.userWhichAnswers.getCurrentTradeStatus();
    }

    /**
     * @return copy of the ratings if they were created, else empty list
     */
    public List<TradeRating> getRatings() {
        return ratings == null ? new ArrayList<>(0) : new ArrayList<>(this.ratings);
    }

    /**
     * @param user user of the rating to return to
     * @return TradeRating which belongs to the given user or null
     */
    public TradeRating getRating(final User user) {
        if (!this.isUserPartOfTrade(user)) {
            return null;
        }

        return this.ratings.get(0).ratingFrom(user)
                ? this.ratings.get(0) : this.ratings.get(1);
    }


    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    /**
     * @param obj Trade
     * @return true if equal(same uuid)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.getUuid().equals(((Trade) obj).getUuid());
    }
}
