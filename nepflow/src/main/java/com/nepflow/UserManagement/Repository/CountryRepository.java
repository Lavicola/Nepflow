package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.Country;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends Neo4jRepository<Country,String> {
    Country findCountryByName(String name);

    boolean existsCountryByName(String name);


}
