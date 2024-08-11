package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends Neo4jRepository<Specimen,String> {


    // for performance  increase  we dont  retrieve the whole growlist and rather  update via query
    //  Also User itself is not retrieved as well since in this context it is not  necessary
    @Query("MATCH (u:User {OAuthId: $userId})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "MATCH (c:Clone {internalCloneId: $internalCloneId})-[cl:CLONE_OF_SPECIES]->(l)   \n" +
            "CREATE (g)-[:CONTAINS_SPECIMEN]-> (s:Specimen {isFlowering: false}) -[i:INSTANCE_OF]->(c)\n" +
            "CREATE (s)-[:GROWS_BY]-> (u)" +
            "return s,c,i,u,cl,l")
    Specimen addSpecimenToGrowlistAndUser(String userId, String internalCloneId);


    Specimen findSpecimenByUuid(String uuid);

    @Query("MATCH (u:User {OAuthId: $userId} )-[r:CONTAINS_COLLECTION]->(g:Growlist)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[gr:GROWS_BY]->(u) \n" +
            "WHERE elementId(s) = $specimenId\n" +
            "detach delete gr,s,sr\n" +
            "RETURN CASE WHEN s IS NOT NULL THEN true ELSE false END AS result")
    boolean deleteSpecimen(String userId,String specimenId);

}
