package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOffer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PollenOfferRepository extends Neo4jRepository<PollenOffer,String> {



    @Query("MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED]->(s:Specimen)   \n" +
            "WHERE  elementId(s)  = $specimenId\n" +
            "WITH MAX(f.startDate) as newest,s\n" +
            "MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED{startDate:newest}]->(s)\n" +
            "return elementId(p) LIMIT 1")
    String getNewestPollenOfferIdBySpecimen(String specimenId);



}
