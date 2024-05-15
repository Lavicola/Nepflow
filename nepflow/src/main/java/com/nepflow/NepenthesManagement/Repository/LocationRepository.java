package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Location;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends Neo4jRepository<Location, String> {

    Location findLocationByName(String name);

}
