package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowlistRepository extends Neo4jRepository<Growlist,String> {



    @Query("match(g:Growlist)\n" +
            "where elementId(g) = $growlistId\n" +
            "match (g)<-[a]-(u:User {OAuthId: $oAuth})\n" +
            "Set g.isPublic = $isPublic\n" +
            "RETURN CASE WHEN g IS NOT NULL THEN true ELSE false END AS result\n")
    boolean updateGrowlistVisibility(String oAuth,String growlistId, boolean isPublic);


    @Query(" MATCH (u:User {OAuthId: $id})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)\n" +
            "OPTIONAL MATCH (c)-[spr:SOLD_BY]->(p:Producer)\n" +
            "OPTIONAL MATCH (c)-[lr:CLONE_OF_SPECIES]->(l:Label)\n" +
            "OPTIONAL MATCH (c)-[locr:ORIGIN]->(loc)\n" +
            "OPTIONAL MATCH (c)-[sexR:HAS_SEX]->(sex)\n" +
            "\n" +
            "RETURN \n" +
            "  g,r,\n" +
            "  COLLECT(sr) AS Srelations, \n" +
            "  COLLECT(s) AS specimens,\n" +
            "  COLLECT(cr) AS Crelations, \n" +
            "  COLLECT(c) AS clones,\n" +
            "  COLLECT(spr) AS SPrelations, \n" +
            "  COLLECT(p) AS producers,\n" +
            "  COLLECT(lr) AS LRelations, \n" +
            "  COLLECT(l) AS labels,\n" +
            "  COLLECT(locr) AS locRelations, \n" +
            "  COLLECT(loc) AS locations,\n" +
            "  COLLECT(sexR) AS sexRelations, \n" +
            "  COLLECT(sex) AS sexes\n ")
    Growlist findGrowlistById(String id);


   @Query("MATCH (u:User {username: $name})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
           "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)\n" +
           "OPTIONAL MATCH (c)-[spr:SOLD_BY]->(p:Producer)\n" +
           "OPTIONAL MATCH (c)-[lr:CLONE_OF_SPECIES]->(l:Label)\n" +
           "OPTIONAL MATCH (c)-[locr:ORIGIN]->(loc)\n" +
           "OPTIONAL MATCH (c)-[sexR:HAS_SEX]->(sex)\n" +
           "\n" +
           "RETURN \n" +
           "  g,r,\n" +
           "  COLLECT(sr) AS Srelations, \n" +
           "  COLLECT(s) AS specimens,\n" +
           "  COLLECT(cr) AS Crelations, \n" +
           "  COLLECT(c) AS clones,\n" +
           "  COLLECT(spr) AS SPrelations, \n" +
           "  COLLECT(p) AS producers,\n" +
           "  COLLECT(lr) AS LRelations, \n" +
           "  COLLECT(l) AS labels,\n" +
           "  COLLECT(locr) AS locRelations, \n" +
           "  COLLECT(loc) AS locations,\n" +
           "  COLLECT(sexR) AS sexRelations, \n" +
           "  COLLECT(sex) AS sexes\n")
    Growlist findGrowlistByUsername(String name);

}
