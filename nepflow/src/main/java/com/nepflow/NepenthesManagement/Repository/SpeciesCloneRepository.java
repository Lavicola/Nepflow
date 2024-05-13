package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.ICClone;
import com.nepflow.NepenthesManagement.Model.IVClone;
import com.nepflow.NepenthesManagement.Model.SpeciesClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesCloneRepository extends Neo4jRepository<SpeciesClone, String> {


    IVClone findSpeciesCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

    List<SpeciesClone> findAllByNepenthesName(String nepenthesName);

    boolean existsSpeciesCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
