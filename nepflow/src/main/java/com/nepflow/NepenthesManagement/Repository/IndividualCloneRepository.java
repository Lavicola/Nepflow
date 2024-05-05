package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.ICClone;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface IndividualCloneRepository extends Neo4jRepository<ICClone,String> {


    ICClone findIndividualCloneByCloneIdAndNepenthesName(String cloneId, String nepenthesName);

}
