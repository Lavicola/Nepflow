package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.TradeRating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface TradeRatingRepository extends Neo4jRepository<TradeRating, String> {


@Query("match(tr:TradeRating)-[r:RATED_BY]->(u:User{username:$username})\n" +
        "WITH tr,r,u\n" +
        "match (tr)-[rr:RATING_FOR]->(t:Trade)\n" +
        "return tr,collect(rr),collect(t)\n")
    List<TradeRating> getTradeRatingByUsername(String username);

}

