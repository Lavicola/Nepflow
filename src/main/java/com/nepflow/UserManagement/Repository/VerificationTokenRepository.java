package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Model.VerificationToken;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories
public interface VerificationTokenRepository extends Neo4jRepository<VerificationToken,String> {

    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);

}
