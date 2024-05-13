package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.MultiHybrid;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultiHybridRepository extends Neo4jRepository<MultiHybrid,String> {

    List<MultiHybrid> getMultiHybridByName(String name);
    MultiHybrid getMultiHybridByCloneId(String cloneId);

}
