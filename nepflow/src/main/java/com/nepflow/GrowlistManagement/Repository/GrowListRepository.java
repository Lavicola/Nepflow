package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowListRepository extends Neo4jRepository<Growlist,String> {
}
