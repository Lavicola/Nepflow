package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Model.VerificationToken;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Optional;

@EnableNeo4jRepositories
public interface VerificationTokenRepository extends Neo4jRepository<VerificationToken,String> {

    Optional<VerificationToken> findByToken(String token);
    Optional<VerificationToken> findByTokenAndUser(String token, User user);
    Optional<VerificationToken> findByUser(User user);

}
