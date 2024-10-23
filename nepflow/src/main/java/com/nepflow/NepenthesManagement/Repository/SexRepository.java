package com.nepflow.NepenthesManagement.Repository;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * SexRepository which enables to save and retrieve Sexes.
 * Only Male and Female though
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface SexRepository extends Neo4jRepository<Sex, Sex.SEX> {


    /**
     * @param sex sex as string
     * @return concrete sex objects
     */
    Sex findSexBySex(Sex.SEX sex);
}
