package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to retrieve and save Pollenoffers.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface PollenOfferRepository extends Neo4jRepository<PollenOffer, String> {


    /**
     * @param specimenId id(primary Key) of the specimen
     * @return Id of the latest PollenOffer
     */
    @Query("MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED]->(s:Specimen)   \n" +
            "WHERE  elementId(s)  = $specimenId\n" +
            "WITH MAX(f.startDate) as newest,s\n" +
            "MATCH (p:PollenOffer)-[f:FLOWERS|HAS_FLOWERED{startDate:newest}]->(s)\n" +
            "return elementId(p) LIMIT 1")
    String getNewestPollenOfferIdBySpecimen(String specimenId);

    /**
     * @param username username of the User
     * @return List of PollenOfferSpeciesStatisticsDTOProjection
     */
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
