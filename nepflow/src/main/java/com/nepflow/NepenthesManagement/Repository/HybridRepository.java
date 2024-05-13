package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Hybrid;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HybridRepository extends Neo4jRepository<Hybrid,String> {

    List<Hybrid> getHybridByName(String name);
    Hybrid getHybridByCloneId(String cloneId);




}
