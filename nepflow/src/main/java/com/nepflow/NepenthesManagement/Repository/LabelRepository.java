package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends Neo4jRepository<Label,String> {

Label findLabelByName(String name);
    @Query("MATCH (n:`:#{literal(#label)}`) RETURN count(n)")
    int countLabelByLabelClass(String label);



}
