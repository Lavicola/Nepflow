package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * CloneRepository which enables to save and retrieve any subclasses of Clones.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface CloneRepository extends Neo4jRepository<Clone, String> {


    /**
     * @param internalCloneId internalCloneId
     * @return concrete Clone
     */
    Clone findCloneByInternalCloneId(String internalCloneId);

    /**
     * @param internalCloneIds internalCloneIds
     * @return concrete clones
     */
    List<Clone> findClonesByInternalCloneIdIn(List<String> internalCloneIds);


    /**
     * @param cloneIds cloneIds
     * @return concrete clones
     */
    List<Clone> findClonesByCloneIdIn(List<String> cloneIds);

    /**
     * @param cloneId cloneId
     * @return true if a clone exists, else false
     */
    boolean existsByInternalCloneId(String cloneId);


}
