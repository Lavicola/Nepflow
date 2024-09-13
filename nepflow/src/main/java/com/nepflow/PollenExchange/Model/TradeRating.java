package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class TradeRating {

    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    @Relationship("RATED_BY")
    @Getter
    User user;
    @Relationship("RATING_FOR")
    @Getter
    Trade trade;

    String comment;

    @Getter
    RATING rating;


    public TradeRating(User user,Trade trade){
        this.user = user;
        this.trade = trade;
        this.rating = RATING.PENDING;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void rateTradeAsSuccess(){
        this.rating = RATING.SUCCESS;
    }
    public void rateTradeAsFailure(){
        this.rating = RATING.FAILURE;
    }


    public  enum RATING{
        SUCCESS,
        FAILURE,
        PENDING

    }


}
