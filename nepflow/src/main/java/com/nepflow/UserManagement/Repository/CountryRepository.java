package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.Country;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to retrieve and save Countries.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Repository
public interface CountryRepository extends Neo4jRepository<Country, String> {
    /**
     * @param name name of the ountry
     * @return country object
     */
    Country findCountryByName(String name);


}
