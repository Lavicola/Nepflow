package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository mainly used to check for reverse Trades.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface TradeRepository extends Neo4jRepository<Trade, String> {


    /**
     * @param offerId  id of first Pollenoffer
     * @param offerId2 id of second Pollenoffer
     * @return true if either the exact trade exists or the reverse
     */
    @Query("Return EXISTS {\n" +
            "match(p:PollenOffer) -- (t:Trade) -- (p2:PollenOffer)\n" +
            "WHERE \n" +
            "    elementId(p) = $offerId \n" +
            "        AND elementId(p2) = $offerId2 \n" +
            "} as result\n")
    boolean tradeOrReverseTradeExists(String offerId, String offerId2);


}
