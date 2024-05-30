package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;


@EnableNeo4jRepositories
public interface UserRepository extends Neo4jRepository<User, String> {

    @Query("MATCH (u:User) return u")
    List<User> getAllUsers();

    User findUserByUsername(String username);


    User findUserByOAuthId(String OAuthId);

    boolean existsUserByOAuthId(String OAuthId);



    @Query("RETURN NOT exists {MATCH (u:User {username: $username})}")
    boolean isUsernameFree(String username);



}
