package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowlistRepository extends Neo4jRepository<Growlist,String> {

    // Currently not working, because of mapping error for some reason
    Growlist findGrowlistByUser(User user);

    // https://neo4j.com/docs/ogm-manual/current/reference/#reference:session:persisting-entities
    // TODO verify the query. Producer is needed, otherwise the clone retrieval fails (since Producer is a must for IV). Therefore check if not retrieving anything results in overwriting
    // in default case it´s only necessary to retrieve clone as well,because a deeper depth won´t be updated from the ORM
    @Query("MATCH (u:User {OAuthId: $id})-[r:CONTAINS_COLLECTION]->(g:Growlist) " +
            "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)-[spr:SOLD_BY]->(p:Producer) " +
            "RETURN u, r, g, " +
            "Collect(sr) as Srelations, Collect(s) as specimens, " +
            "Collect(cr) as Crelations, Collect(c) as clones, " +
            "Collect(spr) as SPrelations, Collect(p) as producers")

    Growlist findGrowlistById(String id);

    @Query("MATCH (u:User {username: $name})-[r:CONTAINS_COLLECTION]->(g:Growlist) " +
            "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)-[spr:SOLD_BY]->(p:Producer) " +
            "RETURN u, r, g, " +
            "Collect(sr) as Srelations, Collect(s) as specimens, " +
            "Collect(cr) as Crelations, Collect(c) as clones, " +
            "Collect(spr) as SPrelations, Collect(p) as producers")

    Growlist findGrowlistByUsername(String name);

}
