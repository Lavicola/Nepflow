package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone,String> {


    @Query("MATCH (n:`:#{literal(#label)}`) RETURN n")
    List<Clone> findClonesByClass(String className);

    Clone findClonesByCloneId(String cloneId);

    Clone findICCloneByInternalCloneId(String internalCloneId);

    boolean existsByInternalCloneId(String cloneId);

    boolean existsByCloneId(String cloneId);

}
