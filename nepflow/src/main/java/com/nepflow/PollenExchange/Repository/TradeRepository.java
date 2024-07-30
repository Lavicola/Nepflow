package com.nepflow.PollenExchange.Repository;


import com.nepflow.PollenExchange.Model.Trade;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends Neo4jRepository<Trade,String> {


    // the Trades the user initiated
    @Query("match(u:User{OAuthId:$userId})<-[i:INITIATED]-(t:Trade)" +
            "match(t)-[answers:NEEDS_TO_ANSWER]->(u2) " +
            "match(t)-[offers:OFFERS]->(initiatedOffer)-[flower:FLOWERS]->(s)-[cc:INSTANCE_OF]->(c)-[cl:CLONE_OF_SPECIES]->(l) " +
            "match(t)-[wants:WANTS]->(requestedOffer)-[flower2:FLOWERS]->(specimen)-[cloneinstance:INSTANCE_OF]->(clone)-[cloneof:CLONE_OF_SPECIES]->(label) " +
            " return t,i,u,answers,u2," +
            "offers,initiatedOffer,flower,s,cc,c,cl,l," +
            "wants,requestedOffer,flower2,specimen,cloneinstance,clone,cloneof,label" +
            " ")
    List<Trade> findInitiatedTrades(String userId);


    // the Trades where the user answers
    @Query("match(u:User{OAuthId:$userId})<-[answers:NEEDS_TO_ANSWER]-(t:Trade)\n" +
            "match(t)-[i:INITIATED]->(u2)" +
            "match(t)-[offers:OFFERS]->(initiatedOffer)-[flower:FLOWERS]->(s)-[cc:INSTANCE_OF]->(c)-[cl:CLONE_OF_SPECIES]->(l) " +
            "match(t)-[wants:WANTS]->(requestedOffer)-[flower2:FLOWERS]->(specimen)-[cloneinstance:INSTANCE_OF]->(clone)-[cloneof:CLONE_OF_SPECIES]->(label) " +
            " return t,i,u,answers,u2," +
            "offers,initiatedOffer,flower,s,cc,c,cl,l," +
            "wants,requestedOffer,flower2,specimen,cloneinstance,clone,cloneof,label" +
            " ")
    List<Trade> findRequestedTrades(String userId);


    // IMPORTANT PollenOffer does contain user as well, but we won´t reference it  in the Query again since Trade contains both users
    // Therefore the initiated/requestedOffer User are null
    @Query("MATCH (u:User {OAuthId: $userId})\n" +
            "WITH u\n" +
            "Match (u2:User)\n" +
            "WHERE NOT u2.OAuthId = $userId\n" +
            "WITH u,u2\n" +
            "Match(u)<-[i:INITIATED|NEEDS_TO_ANSWER]-(t)-[i2:INITIATED|NEEDS_TO_ANSWER]->(u2)\n" +
            "WITH u,u2,i,i2,t\n" +
            "Match (t)-[offers:OFFERS]->(initiatedOffer)-[flower:FLOWERS]->(s)-[cc:INSTANCE_OF]->(c)-[cl:CLONE_OF_SPECIES]->(l)\n" +
            "WITH u,u2,i,i2,t,offers,initiatedOffer,flower,s,cc,c,cl,l\n" +
            "MATCH (t)-[wants:WANTS]->(requestedOffer:PollenOffer)-[flower2:FLOWERS]->(specimen)-[cloneinstance:INSTANCE_OF]->(clone)-[cloneof:CLONE_OF_SPECIES]->(label)\n" +
            "RETURN u,u2,i,i2,t,offers,initiatedOffer,flower,s,cc,c,cl,l,wants,requestedOffer,flower2,specimen,cloneinstance,clone,cloneof,label\n")
    List<Trade> findAllTradesForUser(String userId);




    //List<Trade> findInitiatedTradesByStatus(String userId,String status);
    //List<Trade> findRequestedTradesByStatus(String userId,String status);


}
