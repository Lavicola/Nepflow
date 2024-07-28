package com.nepflow.PollenExchange.Repository;

import com.nepflow.PollenExchange.Model.PollenOffer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollenOfferRepository extends Neo4jRepository<PollenOffer,String> {

    // checks if a closed pollen offer exists within a time range
    @Query("MATCH (p:PollenOffer)-[f:HAS_FLOWERED]->(s)\n" +
            "WHERE f.startDate >= date($startDateAsString)\n" +
            "AND f.startDate <= date($endDateAsString)\n" +
            "  AND elementId(s) = $specimenid\n" +
            "RETURN elementId(p)\n")
    String getIdOfclosedPollenOfferInRangeExists(String specimenid, String startDateAsString,String endDateAsString);



    @Query("match(p:PollenOffer) -[f:FLOWERS]-> (s) \n" +
            "WHERE f.startDate >= date($startDateAsString)\n" +
            "AND f.startDate <= date($endDateAsString)\n" +
            "AND  elementId(s) = $specimenid\n" +
            "RETURN elementId(p)\n")
    String getOpenPollenOfferId(String specimenid, String startDateAsString,String endDateAsString);



    @Query("match(p)-[pu:PUBLISHED_BY]->(u:User)\n" +
            "Where u.username = $username\n" +
            "match(p:PollenOffer) -[f:FLOWERS]->(s:Specimen) -[i:INSTANCE_OF]->(c) -[]->(l)\n" +
            "match(clone)-[sR:HAS_SEX]->(sex)" +
            "return p,f,s,sr,sex")
    List<PollenOffer> getAllOwnOpenPollenOffers(String username);

    @Query("match(p:PollenOffer)-[pu:PUBLISHED_BY]->(u:User)" +
            "Where NOT u.username = $username\n" +
            "match(p) -[f:FLOWERS]->(s:Specimen)-[i]-(clone)-[lr:CLONE_OF_SPECIES]->(l:Label)\n" +
            "match(clone)-[sR:HAS_SEX]->(sex)" +
            "return p,pu,u,f,clone,i,s,lr,l,sR,sex")
    List<PollenOffer> getAllOpenPollenOffersBySexExceptOwn(String username, String sexAsString);


    @Query("RETURN EXISTS {\n" +
            "    MATCH (p)-[pu:PUBLISHED_BY]->(u:User)\n" +
            "    MATCH (p:PollenOffer)-[f:FLOWERS]->(s:Specimen)-[i:INSTANCE_OF]->(c)-[]->(l)\n" +
            "    MATCH (clone)-[sr:HAS_SEX]->(sex)\n" +
            "    WHERE elementid(s) = $specimenId" +
            "} AS result")
    boolean pollenOfferExists(String specimenId);

}
