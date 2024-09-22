package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * Custom Model which represents a Relationship property for Trade.
 * The Custom Model represents the references used to have property on an edge User--Trade.
 * Doing so allows to use the property to store the Answer of the User.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@RelationshipProperties
@NoArgsConstructor
public class TradeUserAnswersRelationshipValue {

    /**
     *
     */
    @Id
    @GeneratedValue
    private String uuid;

    /**
     *
     */
    @TargetNode
    @Getter
    private User user;

    /**
     *
     */
    private UserAnswers status;

    /**
     * @param user user of a Trade who answers it
     */
    public TradeUserAnswersRelationshipValue(final User user) {
        this.user = user;
        this.status = UserAnswers.WAITING;
    }

    /**
     * @return current Status of the trade as a String
     */
    public String getCurrentTradeStatus() {
        return this.status.toString();
    }

    /**
     *
     */
    public void refuseTrade() {
        if (this.status == UserAnswers.WAITING) {
            this.status = UserAnswers.REFUSED;
        }
    }

    /**
     *
     */
    public void acceptTrade() {
        if (this.status == UserAnswers.WAITING) {
            this.status = UserAnswers.ACCEPTED;
        }
    }

    /**
     *
     */
    public void setTradeToExpired() {
        this.status = UserAnswers.EXPIRED;
    }


    /**
     * @return true if trade was refused, else false
     */
    public boolean wasTradeRefused() {
        return this.status.equals(UserAnswers.REFUSED);
    }

    /**
     * @return true if trade was accepted, else false
     */
    public boolean wasTradeAccepted() {
        return this.status.equals(UserAnswers.ACCEPTED);
    }

    /**
     * @return true if trade was not yet answered
     */
    public boolean isTradeOpen() {
        return this.status.equals(UserAnswers.WAITING);
    }

    /**
     *
     */
    public enum UserAnswers {
        /**
         *
         */
        WAITING,
        /**
         *
         */
        ACCEPTED,
        /**
         *
         */
        REFUSED,
        /**
         *
         */
        EXPIRED,
    }

}
