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

/**
 * Model(Container) which contains all Trades for every Month.
 * The Container can therefore be seen as a way to optimize queries.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class TradeStartDate {

    /**
     * Primary Key in Format MM-yyyy.
     */
    @Id
    @Getter
    private String MonthYearId;

    /**
     *
     */
    @Relationship(value = "OPENED_IN", direction = Relationship.Direction.INCOMING)
    private List<Trade> trades = new ArrayList<>();

    /**
     * formatter to gain the MM-yyy Format.
     */
    @Transient
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");


    /**
     * Primary Key in Format MM-yyyy.
     */
    public TradeStartDate() {
        this.MonthYearId = LocalDate.now().format(formatter);

    }

    /**
     * @param trade trade to be added to the Container
     * @return true if trade could be added, else  false
     */
    public boolean addTrade(final Trade trade) {
        if (trade != null && trade.getTradeOpenedDate().format(this.formatter).equals(this.MonthYearId)) {
            this.trades.add(trade);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return copy of all Trades the Container contains
     */
    public List<Trade> getTrades() {
        return new ArrayList<>(trades);
    }


}
