package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Optional;
@EnableNeo4jRepositories
public interface UserRepository extends Neo4jRepository<User,Long> {


    Optional<User> findUserByEmailOrUsername(String email, String username);
    Optional<User> findByUsername(String username);

    void delete(User user);

}
