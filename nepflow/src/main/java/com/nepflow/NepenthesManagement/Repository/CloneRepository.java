package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloneRepository extends Neo4jRepository<ICClone,String> {

    ICClone findClonesByCloneId(String cloneId);

    ICClone findICCloneByInternalCloneId(String internalCloneId);

    boolean existsByInternalCloneId(String cloneId);

    boolean existsByCloneId(String cloneId);

}
