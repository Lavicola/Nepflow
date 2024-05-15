package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Sex;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends Neo4jRepository<Sex,String> {

    Sex findSexBySex(String sex);

}
