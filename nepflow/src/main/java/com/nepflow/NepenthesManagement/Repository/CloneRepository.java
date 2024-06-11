package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone,String> {


    @Query("MATCH (n:`:#{literal(#label)}`)<-[r:SPECIES_OF]-(c:`:#{literal(#cloneType)}`)" +
            "WHERE n.name STARTS WITH $text "+
            "RETURN c")
    List<Clone> findClonesByLabelAndCloneTypeAndStartsWith(String label,String cloneType,String text);
    @Query("match(n:`:#{literal(#labelClass)}`{name: $nepenthesName})<-[r:SPECIES_OF]-(c:`:#{literal(#cloneType)}`) -[s:SOLD_BY]->(p)" +
            "RETURN c,s,p")
    List<Clone> findClonesByLabelAndNepenthesNameAndCloneType(String labelClass,String nepenthesName,String cloneType);


    Clone findClonesByCloneId(String cloneId);

    Clone findICCloneByInternalCloneId(String internalCloneId);


    boolean existsByInternalCloneId(String cloneId);

    boolean existsByCloneId(String cloneId);

}
