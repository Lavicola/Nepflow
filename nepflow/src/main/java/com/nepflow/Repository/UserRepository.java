package com.nepflow.Repository;

import com.nepflow.Models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    User findUserByOAuthId(String OAuthId);
    User findUserByUsername(String username);



}
