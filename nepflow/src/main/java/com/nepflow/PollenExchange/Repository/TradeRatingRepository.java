package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.TradeRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to retrieve and save Ratings for Trades.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public
interface TradeRatingRepository extends Neo4jRepository<TradeRating, String> {


    /**
     * @param username username of the User
     * @return List of all Trade Ratings from  an User
     */
    @Query("match(tr:TradeRating)-[r:RATED_BY]->(u:User{username:$username})\n" +
            "WITH tr,r,u\n" +
            "match (tr)-[rr:RATING_FOR]->(t:Trade)\n" +
            "return tr,collect(rr),collect(t)\n")
    List<TradeRating> getTradeRatingByUsername(String username);

}

