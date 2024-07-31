package com.nepflow.PollenExchange.Model;

import lombok.Getter;
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


    public void TradeStartDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        this.MonthYearId = LocalDate.now().format(formatter);

    }

    public void addTrade(Trade trade){
        this.trades.add(trade);
    }

    public List<Trade> getTrades(){
        return new ArrayList<>(trades);
    }


}
