package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import com.nepflow.NepenthesManagement.Model.SpeciesClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface IVCloneRepository extends Neo4jRepository<IVClone,String> {



    IVClone findIVCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
