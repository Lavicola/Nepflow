package com.nepflow.Repository;

import com.nepflow.Models.Region;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends Neo4jRepository<Region, Long> {

    @Query("MATCH (r:Region {name: $name}) RETURN r.name")
    String getRegionName(String name);


}
