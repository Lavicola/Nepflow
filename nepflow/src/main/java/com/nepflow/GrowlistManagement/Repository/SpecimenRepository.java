package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository to retrieve and save Specimens.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface SpecimenRepository extends Neo4jRepository<Specimen, String> {


    /**
     * Performance Optimized custom query to add a Specimen to an User and a Growlist.
     *
     * @param oAuthid         user id (primary key)
     * @param internalCloneId
     * @return Specimen WITHOUT reference to user
     */
    @Query("MATCH (u:User {OAuthId: $oAuthid})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "MATCH (c:Clone {internalCloneId: $internalCloneId})-[cl:CLONE_OF_SPECIES]->(l)   \n" +
            "CREATE (g)-[:CONTAINS_SPECIMEN]-> (s:Specimen {isFlowering: false}) -[i:INSTANCE_OF]->(c)\n" +
            "CREATE (s)-[:GROWS_BY]-> (u)" +
            "return s,c,i,u,cl,l")
    Specimen addSpecimenToGrowlistAndUserReturnSpecimenWithoutUser(String oAuthid, String internalCloneId);


    /**
     * @param uuid primary key of the Specimen
     * @return Specimen
     */
    Specimen findSpecimenByUuid(String uuid);

    /**
     * @param oAuthid    primary key of User
     * @param specimenId primary key of Specimen
     * @return true if specimen was deleted
     */
    @Query("MATCH (u:User {OAuthId: $oAuthid} )-[r:CONTAINS_COLLECTION]->(g:Growlist)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[gr:GROWS_BY]->(u) \n" +
            "WHERE elementId(s) = $specimenId\n" +
            "detach delete gr,s,sr\n" +
            "RETURN CASE WHEN s IS NOT NULL THEN true ELSE false END AS result")
    boolean deleteSpecimen(String oAuthid, String specimenId);

}
