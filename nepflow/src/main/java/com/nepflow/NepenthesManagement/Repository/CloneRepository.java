package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone, String> {

    Clone findClonesByCloneIdAndNepenthesName(String cloneId,String nepenthesName);

    List<Clone> findClonesByNepenthesName(String speciesName);

    List<Clone> findClonesByCloneId(String cloneId);



    boolean existsByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
