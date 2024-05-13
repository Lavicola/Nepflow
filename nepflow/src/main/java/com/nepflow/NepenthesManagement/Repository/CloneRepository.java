package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.*;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CloneRepository extends Neo4jRepository<Clone,String> {

    @Query("match(n:IVClone) return n")
    List<IVClone> getAllIVClones();

    @Query("match(n:ICClone) return n")
    List<ICClone> getAllICClones();

    @Query("match(n:Hybrid) return n")
    List<Hybrid> getAllHybrids();

    @Query("match(n:MultiHybrid) return n")
    List<MultiHybrid> getAllMultiHybrids();



}
