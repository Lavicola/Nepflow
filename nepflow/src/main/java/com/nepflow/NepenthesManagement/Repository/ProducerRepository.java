package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * ProducerRepository which enables to save and retrieve Producers.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface ProducerRepository extends Neo4jRepository<Producer, String> {

    /**
     * @param name name of the producer
     * @return producer with the given name, else null
     */
    Producer findProducerByName(String name);

}
