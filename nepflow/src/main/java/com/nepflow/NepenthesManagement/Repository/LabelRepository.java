package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends Neo4jRepository<Label,String> {

Label findLabelByName(String name);
    @Query("MATCH (n:`:#{literal(#label)}`) RETURN count(n)")
    int countLabelByLabelClass(String label);

    @Query("match(n:`:#{literal(#labelClass)}`) <-[r:SPECIES_OF]-(c:Clone) -[p:PROPAGATED_BY]->(pr:Producer) return n,r,c,pr,p")
    List<Label> getClonesByLabelClass(String labelClass);
    @Query("match(n:`:#{literal(#labelClass)}`) <-[r:SPECIES_OF]-(c:`:#{literal(#cloneClass)}`) return n,r,c")
    List<Label> getClonesByLabelClassAndCloneClass(String labelClass,String cloneClass);


    @Query("MATCH (n:`:#{literal(#labelName)}`) RETURN n")
    List<Label> getLabelsByLabelName(String labelName);


}
