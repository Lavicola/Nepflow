package com.nepflow.PollenExchange.Model;

import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Node
public class TradeStartDate {

    @Id
    @Getter
    String MonthYearId;

    @Relationship(value = "OPENED_IN",direction = Relationship.Direction.INCOMING)
    List<Trade> trades = new ArrayList<>();

    @Transient
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");


    public TradeStartDate(){
        this.MonthYearId = LocalDate.now().format(formatter);

    }

    public boolean addTrade(Trade trade){
        if( trade!= null  && trade.getTradeOpenedDate().format(this.formatter).equals(this.MonthYearId)){
            this.trades.add(trade);
            return true;
        }else{
            return false;
        }
    }

    public List<Trade> getTrades(){
        return new ArrayList<>(trades);
    }


}
