package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface IVCloneRepository extends Neo4jRepository<IVClone,String> {

  /*  @Query("match(n:IVClone{cloneId:$cloneId})" +
            " -[r:SPECIES_OF]->(s:Nepenthes{name:$nepenthesName}) " +
            "return n,r,s")
            */
    IVClone findIVCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
