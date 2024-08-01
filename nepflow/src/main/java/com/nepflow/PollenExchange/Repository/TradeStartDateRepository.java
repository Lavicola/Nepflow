package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.TradeStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeStartDateRepository extends Neo4jRepository<TradeStartDate, String> {

    @Query("match(p:TradeStartDate) return p")
    List<TradeStartDate> getTradeDatesWithoutOffers();

}
