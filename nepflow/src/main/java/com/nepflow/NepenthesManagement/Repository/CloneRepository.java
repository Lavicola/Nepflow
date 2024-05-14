package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.*;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone,String> {


    Clone findCloneByCloneId(String cloneId);

    List<Clone> findClonesByName(String name);

    boolean existsCloneByCloneId(String cloneId);


    @Query("match(n:SpeciesClone) return n")
    List<SpeciesClone> getAllSpeciesClones();



    @Query("match(n:IVClone) return n")
    List<IVClone> getAllIVClones();

    @Query("match(n:ICClone) return n")
    List<ICClone> getAllICClones();

    @Query("match(n:HybridClone) return n")
    List<ICHybrid> getAllHybrids();

    @Query("match(n:MultiHybridClone) return n")
    List<ICMultiHybrid> getAllMultiHybrids();



}
