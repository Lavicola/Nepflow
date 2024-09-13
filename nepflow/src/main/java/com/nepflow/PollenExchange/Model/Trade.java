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

@Node
@NoArgsConstructor
public class Trade {
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    @Relationship(value = "OFFERS", direction = Relationship.Direction.OUTGOING)
    @Getter
    PollenOffer initiatedOffer;
    @Relationship(value = "WANTS", direction = Relationship.Direction.OUTGOING)
    @Getter
    PollenOffer requestedOffer;

    @Relationship(value = "INITIATED", direction = Relationship.Direction.OUTGOING)
    User userOffers;

    @Getter
    LocalDate tradeOpenedDate = LocalDate.now();


    @Relationship(value = "NEEDS_TO_ANSWER", direction = Relationship.Direction.OUTGOING)
    TradeUserAnswersRelationshipValue userWhichAnswers;

    public Trade(PollenOffer pollenOffer, PollenOffer requestedOffer) {
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

    public boolean isAllowedToAnswerTrade(User user) {
        return this.isTradeOpen()  &&  this.userWhichAnswers.getUser().equals(user);
    }


    public String convertOpenedDay(){
        return this.getTradeOpenedDate().toString();
    }


    public User getUserWhoAnswersTrade() {
        return this.userWhichAnswers.getUser();
    }

    public User getUserWhoInitiatedTrade() {
        return this.userOffers;
    }



    public void refuseTrade() {
        this.userWhichAnswers.refuseTrade();
    }

    public void acceptTrade() {
        this.userWhichAnswers.acceptTrade();
    }

    public void setTradeToExpired(){

        ArrayList<Boolean> a = new ArrayList<>(10);


        this.userWhichAnswers.setTradeToExpired();
    }



    public boolean isUserPartOfTrade(User user){
        return this.userWhichAnswers.getUser().equals(user) || this.userOffers.equals(user);

    }

    public boolean wasTradeRefused() {
        return this.userWhichAnswers.wasTradeRefused();
    }

    public boolean wasTradeAccepted() {
        return this.userWhichAnswers.wasTradeAccepted();
    }

    public boolean isTradeOpen() {
        return this.userWhichAnswers.isTradeOpen();
    }

    public boolean isTradeExpired(){
        if(this.initiatedOffer.isOpen() && this.requestedOffer.isOpen()){
            return false;
        }else{
            return true;
        }
    }

    public String getTradeStatus() {
        return this.userWhichAnswers.getCurrentTradeStatus();
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return this.getUuid().equals(((Trade) obj).getUuid());
    }
}
