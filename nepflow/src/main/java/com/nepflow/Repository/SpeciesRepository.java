package com.nepflow.Repository;

import com.nepflow.Models.Species;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends Neo4jRepository<Species, Long> {

    Species findSpeciesByName(String name);

}
