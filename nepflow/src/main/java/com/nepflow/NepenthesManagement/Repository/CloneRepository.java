package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone, String> {


    @Query("MATCH (n)-[r:SPECIES_OF]->(u:Nepenthes{name:$nepenthesName})\n" +
            "WHERE (labels(n) = ['IVClone'] OR labels(n) = ['ICClone']) AND n.cloneId = $cloneId\n" +
            "RETURN n,u, r\n")
    Clone findCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

   // @Query("MATCH (n)-[r:SPECIES_OF]->(u:Nepenthes{name:$nepenthesName})\n" +
  ///          "WHERE (labels(n) = ['IVClone'] OR labels(n) = ['ICClone'])\n" +
   ///         "RETURN n, r, u\n")
    List<Clone> findAllByNepenthesName(String nepenthesName);




//@Query("MATCH (n)-[r:SPECIES_OF]->(u:Nepenthes{name:$nepenthesName})\n" +
  //      "WHERE (labels(n) = ['IVClone'] OR labels(n) = ['ICClone']) AND n.cloneId = $cloneId\n" +
    //    "RETURN EXISTS((n)-[:SPECIES_OF]->(u)) AS found\n")
    boolean existsCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
