package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends Neo4jRepository<Specimen,String> {


    @Query("MATCH (u:User {OAuthId: $id})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "MATCH (c:Clone {internalCloneId: $internalCloneId})-[:CLONE_OF_SPECIES]->(l)   \n" +
            "CREATE (g)-[:CONTAINS_SPECIMEN]-> (s:Specimen {isFlowering: false}) -[i:INSTANCE_OF]->(c)\n" +
            "return s,c,i")
    Specimen addSpecimenToGrowlist(String id, String internalCloneId);

@Query("MATCH (u:User {OAuthId: $id})-[r:CONTAINS_COLLECTION]->(g:Growlist)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)\n" +
        "WHERE elementId(s) = $specimenId\n" +
        "RETURN EXISTS((u)-[r:CONTAINS_COLLECTION]->(g)-[sr:CONTAINS_SPECIMEN]->(s)) AS ownsSpecimen\n")
    boolean isSpeciesOfUser(String id,String specimenId);

    Specimen findSpecimenByUuid(String uuid);

    @Query("MATCH (u:User {OAuthId: $id})-[r:CONTAINS_COLLECTION]->(g:Growlist)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)\n" +
            "WHERE elementId(s) = $specimenId\n" +
            "detach delete s\n" +
            "RETURN CASE WHEN s IS NOT NULL THEN true ELSE false END AS result")
    boolean deleteSpecimen(String id, String specimenId);

}
