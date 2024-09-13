package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends Neo4jRepository<Trade,String> {


    @Query("Return EXISTS {\n" +
            "match(p:PollenOffer) -- (t:Trade) -- (p2:PollenOffer)\n" +
            "WHERE \n" +
            "    elementId(p) = $offerId \n" +
            "        AND elementId(p2) = $offerId2 \n" +
            "} as result\n")
    boolean tradeOrReverseTradeExists(String offerId,String offerId2);


    @Query("MATCH (t:Trade)-[r:NEEDS_TO_ANSWER]->(u:User {username: $username}) \n" +
            "RETURN 'WAITING' AS status")
    List<TradeRating> getTradesStatusWithDate(String username);








}
