package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.Privilege;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Optional;

@EnableNeo4jRepositories
public interface PrivilegeRepository extends Neo4jRepository<Privilege,String> {

    Optional<Privilege> findByName(String name);

    void delete(Privilege privilege);


}
