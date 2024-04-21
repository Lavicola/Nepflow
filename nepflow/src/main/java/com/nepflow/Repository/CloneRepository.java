package com.nepflow.Repository;

import com.nepflow.Models.Clone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone, Long> {

    Clone findCloneByCloneIdAndSpeciesName(String cloneId, String speciesName);

    List<Clone> findClonesByCloneId(String cloneId);

}
