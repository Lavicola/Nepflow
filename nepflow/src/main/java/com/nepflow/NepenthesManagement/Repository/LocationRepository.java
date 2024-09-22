package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationRepository which enables to save and retrieve Locations.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface LocationRepository extends Neo4jRepository<Location, String> {

    /**
     * @param name name of the Location
     * @return Locationobject
     */
    Location findLocationByName(String name);
}
