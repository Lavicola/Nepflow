package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepository extends Neo4jRepository<Label,String> {

    Label findLabelByName(String nepenthesName);
    @Query("MATCH (n:`:#{literal(#label)}`) RETURN count(n)")
    int countLabelByLabelClass(String label);

    @Query("match(n:`:#{literal(#labelClass)}`{name: $nepenthesName})<-[r:SPECIES_OF]-(c:`:#{literal(#cloneType)}`) -[s:SOLD_BY]->(p)" +
            "RETURN n, " +
            "COLLECT(r) as relationships, " +
            "COLLECT(c) as clones," +
            "Collect(s) as sold," +
            "COLLECT(p) as producer\n")
   Label findLabelClonesByLabelAndNepenthesNameAndCloneType(String labelClass,String nepenthesName,String cloneType);

    @Query("MATCH (n:`:#{literal(#labelClass)}`) RETURN n")
    List<Label> getNepenthesByNepenthesType(String labelClass);


}
