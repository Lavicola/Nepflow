package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    /**
     * @param username username of the User
     * @return List of all Trades and Ratings references from a User
     */
    @Query("match(t:Trade)-[r]->(tr:TradeRating)-[ru]->(u:User{username:$username})\n" +
            "return t, collect(r),collect(tr),collect(ru),collect(u)\n")
    List<Trade> getTradesWithTradeRatingsByUsername(String username);


}
