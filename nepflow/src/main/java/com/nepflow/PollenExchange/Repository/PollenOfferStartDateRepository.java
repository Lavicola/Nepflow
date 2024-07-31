package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollenOfferStartDateRepository extends Neo4jRepository<PollenOfferStartDate, String> {



}
