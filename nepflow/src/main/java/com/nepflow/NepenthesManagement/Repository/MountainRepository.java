package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Mountain;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MountainRepository extends Neo4jRepository<Mountain, String> {

    Mountain findMountainByName(String name);

}
