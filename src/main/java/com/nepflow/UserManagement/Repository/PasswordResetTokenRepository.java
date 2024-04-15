package com.nepflow.UserManagement.Repository;

import com.nepflow.UserManagement.Model.PasswordResetToken;
import com.nepflow.UserManagement.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Optional;

@EnableNeo4jRepositories
public interface PasswordResetTokenRepository extends Neo4jRepository<PasswordResetToken,String> {

    Optional<PasswordResetToken> findByToken(String token);

    Optional<PasswordResetToken> findByUser(User user);

    Optional<PasswordResetToken> findByTokenAndUser(String token,User user);

    //Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    //void deleteByExpiryDateLessThan(Date now);

    //void deleteAllExpiredSince(Date now);


}
