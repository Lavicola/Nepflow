package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

/**
 * Repository to retrieve and save Users.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@EnableNeo4jRepositories
public interface UserRepository extends Neo4jRepository<User, String> {

    /**
     * @return List of all Users
     */
    @Query("MATCH (u:User) return u")
    List<User> getAllUsers();

    /**
     * @param username username
     * @return user with the given username
     */
    User findUserByUsername(String username);


    /**
     * @param oAuthId OAuth Id of the User
     * @return user with the given oAuthId
     */
    User findUserByOAuthId(String oAuthId);


    /**
     * @param username username to be checked
     * @return true if username is free, else false
     */
    @Query("RETURN NOT exists {MATCH (u:User {username: $username})}")
    boolean isUsernameFree(String username);


}
