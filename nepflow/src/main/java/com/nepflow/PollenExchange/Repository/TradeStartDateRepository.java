package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.TradeStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeStartDateRepository extends Neo4jRepository<TradeStartDate, String> {
}
