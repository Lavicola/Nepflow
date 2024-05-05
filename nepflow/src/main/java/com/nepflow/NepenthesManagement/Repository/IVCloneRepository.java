package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.Nepenthes;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IVCloneRepository extends Neo4jRepository<IVClone,String> {


    IVClone findIVCloneByCloneIdAndAndNepenthesName(String cloneId, String nepenthesName);

}
