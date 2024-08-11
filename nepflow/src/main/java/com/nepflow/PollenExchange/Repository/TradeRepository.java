package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends Neo4jRepository<Trade,String> {


    @Query("Return EXISTS {\n" +
            "match(p:PollenOffer) -- (t:Trade) -- (p2:PollenOffer)\n" +
            "WHERE \n" +
            "    elementId(p) = $offerId \n" +
            "        AND elementId(p2) = $offerId2 \n" +
            "} as result\n")
    boolean tradeOrReverseTradeExists(String offerId,String offerId2);







}
