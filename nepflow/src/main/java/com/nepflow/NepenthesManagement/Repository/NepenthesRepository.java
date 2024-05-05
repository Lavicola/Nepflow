package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Nepenthes;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NepenthesRepository extends Neo4jRepository<Nepenthes, String> {

    Nepenthes findNepenthesByName(String name);

    boolean existsByName(String name);

}
