package com.nepflow.GrowlistManagement.Repository;

import com.nepflow.GrowlistManagement.Model.Specimen;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends Neo4jRepository<Specimen,String> {
}
