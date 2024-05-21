package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVNepenthesCloneRepository extends Neo4jRepository<IVNepenthesClone,String> {
}
