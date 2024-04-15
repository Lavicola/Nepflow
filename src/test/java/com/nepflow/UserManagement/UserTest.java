package com.nepflow.UserManagement;

import com.nepflow.UserManagement.Model.Privilege;
import com.nepflow.UserManagement.Model.Role;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.PrivilegeRepository;
import com.nepflow.UserManagement.Repository.RoleRepository;
import com.nepflow.UserManagement.Repository.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataNeo4jTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    RoleRepository roleRepository;

    private static Neo4j embeddedDatabaseServer;

    @BeforeAll
    static void initializeNeo4j() {

        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .build();
    }

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.neo4j.uri", embeddedDatabaseServer::boltURI);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", () -> null);
    }

    @AfterAll
    static void stopNeo4j() {

        embeddedDatabaseServer.close();
    }


    @Test
    public void UserTest(@Autowired Neo4jClient client) {
        System.out.println("Test inserting Users using Repository");
        // Assign
        User user = new User("test@aol.de", "hamata", "hello_world","");
        User user2 = new User("test@aol.de", "hamata", "hello_world","");
        Optional<Long> result1;
        Optional<Long> result2;
        // Act
        this.userRepository.save(user);
        result1 = client.query("MATCH (n) RETURN COUNT(n)")
                .fetchAs(Long.class)
                .one();
        this.userRepository.save(user2);
        result2 = client.query("MATCH (n) RETURN COUNT(n)")
                .fetchAs(Long.class)
                .one();
        // Assert
        assertEquals(1, result1.get());
        assertEquals(2, result2.get());

    }

    @Test
    public void UserTestRolePrivileges(@Autowired Neo4jClient client) {
        System.out.println("Test inserting Users, Roles and Privileges using Repository");
        // Assign
        Role standardRole = new Role("default");
        Role analysisRole = new Role("analyst");
        Privilege privilege1 = new Privilege("Read");
        Privilege privilege2 = new Privilege("Analyze");
        User user = new User("test@aol.de", "hamata", "hello_world","");
        User user2 = new User("test2@aol.de", "hamata", "hello_world","");
        standardRole.setPrivileges(Set.of(privilege1));
        analysisRole.setPrivileges(Set.of(privilege1, privilege2));
        user.setRoles(List.of(standardRole));
        user.setRoles(List.of(analysisRole));

        Optional<Long> result1;
        Optional<Long> result2;
        Optional<User> r_user;
        Optional<User> r_user2;

        // Act
        this.roleRepository.save(standardRole);
        user2.setRoles(List.of(analysisRole));
        this.userRepository.save(user);
        this.userRepository.save(user2);

        result1 = client.query("MATCH (n) RETURN COUNT(n)")
                .fetchAs(Long.class)
                .one();
        r_user2 = this.userRepository.findUserByEmailOrUsername("test2@aol.de", "");
        // Assert
        // 6 different Entities should be in the Database
        assertEquals(6, result1.get());
        assertEquals(1, r_user2.get().getRoles().size());
        assertEquals(2, r_user2.get().getRoles().get(0).getPrivileges().size());

    }


}
