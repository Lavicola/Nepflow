package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.Role;
import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Optional;
@EnableNeo4jRepositories
public interface RoleRepository extends Neo4jRepository<Role,String> {

    Optional<Role> findByName(String name);

    void delete(Role role);


}
