package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository to retrieve and save Growlists.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface GrowlistRepository extends Neo4jRepository<Growlist, String> {


    /**
     * @param oAuth OAuth id of the User
     * @return The id of the Growlist
     */
    @Query("match(g:Growlist)<-[a]-(u:User {OAuthId: $oAuth})\n" +
            "RETURN elementId(g)\n")
    String getGrowlistIdByUserId(String oAuth);

    /**
     * @param oAuth      OAuth id of the User
     * @param growlistId id of the growlist
     * @param isPublic   true if Growlist shall be public, else false
     * @return true if update was success, else false
     */
    @Query("match(g:Growlist)\n" +
            "where elementId(g) = $growlistId\n" +
            "match (g)<-[a]-(u:User {OAuthId: $oAuth})\n" +
            "Set g.isPublic = $isPublic\n" +
            "RETURN CASE WHEN g IS NOT NULL THEN true ELSE false END AS result\n")
    boolean updateGrowlistVisibility(String oAuth, String growlistId, boolean isPublic);


    /**
     * @param oAuth OAuth id of the User
     * @return Growlist and all references EXCEPT the reference from Specimen to User
     */
    @Query(" MATCH (u:User {OAuthId: $oAuth})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)\n" +
            "OPTIONAL MATCH (c)-[spr:SOLD_BY]->(p:Producer)\n" +
            "OPTIONAL MATCH (c)-[lr:CLONE_OF_SPECIES]->(l:Label)\n" +
            "OPTIONAL MATCH (c)-[locr:ORIGIN]->(loc)\n" +
            "OPTIONAL MATCH (c)-[sexR:HAS_SEX]->(sex)\n" +
            "Match (u) -[userRel2]->(userNodes)" +
            "\n" +
            "RETURN \n" +
            "  g,COLLECT(r),\n" +
            "  COLLECT(sr), \n" +
            "  COLLECT(u),COLLECT(userRel2),COLLECT(userNodes), \n" +
            "  COLLECT(s) ,\n" +
            "  COLLECT(cr) , \n" +
            "  COLLECT(c) ,\n" +
            "  COLLECT(spr) , \n" +
            "  COLLECT(p) ,\n" +
            "  COLLECT(lr) , \n" +
            "  COLLECT(l) ,\n" +
            "  COLLECT(locr) , \n" +
            "  COLLECT(loc) ,\n" +
            "  COLLECT(sexR) , \n" +
            "  COLLECT(sex)\n ")
    Growlist findGrowlistByUserId(String oAuth);

    /**
     * @param username username of the User
     * @return Growlist and all references EXCEPT the reference from Specimen to User
     */
    @Query(" MATCH (u:User {username: $username})-[r:CONTAINS_COLLECTION]->(g:Growlist)\n" +
            "OPTIONAL MATCH (g)-[sr:CONTAINS_SPECIMEN]->(s:Specimen)-[cr:INSTANCE_OF]->(c:Clone)\n" +
            "OPTIONAL MATCH (c)-[spr:SOLD_BY]->(p:Producer)\n" +
            "OPTIONAL MATCH (c)-[lr:CLONE_OF_SPECIES]->(l:Label)\n" +
            "OPTIONAL MATCH (c)-[locr:ORIGIN]->(loc)\n" +
            "OPTIONAL MATCH (c)-[sexR:HAS_SEX]->(sex)\n" +
            "Match (u) -[userRel2]->(userNodes)" +
            "\n" +
            "RETURN \n" +
            "  g,r,\n" +
            "  COLLECT(sr) AS Srelations, \n" +
            "  COLLECT(u) AS user,COLLECT(userRel2),COLLECT(userNodes), \n" +
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
    Growlist findGrowlistByUsername(String username);


}
