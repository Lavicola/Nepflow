package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollenOfferRepository extends Neo4jRepository<PollenOffer,String> {



    @Query("MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED]->(s:Specimen)   \n" +
            "WHERE  elementId(s)  = $specimenId\n" +
            "WITH MAX(f.startDate) as newest,s\n" +
            "MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED{startDate:newest}]->(s)\n" +
            "return elementId(p) LIMIT 1")
    String getNewestPollenOfferIdBySpecimen(String specimenId);

    @Query("match(s:Specimen)--(u:User{username:$username})\n" +
            "WITH s\n" +
            "match(p:PollenOffer)--(s)-[i:INSTANCE_OF]->(clone)-[lab:CLONE_OF_SPECIES]-(label)\n" +
            "return p," +
            "elementId(s) as specimenId," +
            "count(p) as floweringCount," +
            "clone.cloneId as cloneId,label.name as nepenthesName\n"
    )
    List<PollenOfferSpeciesStatisticsDTOProjection> getPollenOfferStatisticsBySpecimen(String username);


}
