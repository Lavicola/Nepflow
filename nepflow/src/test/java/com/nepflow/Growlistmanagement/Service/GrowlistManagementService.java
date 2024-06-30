package com.nepflow.Growlistmanagement.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import com.nepflow.UserManagement.Service.UserManagementService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * These Tests tests the integration with NepenthesManagement and UserManagement
 *
 */

@SpringBootTest
public class GrowlistManagementService {


    private static Neo4j embeddedDatabaseServer;


    @Autowired
    Growlistservice growlistservice;

    @Autowired
    DataInitializationService dataInitializationService;

    @Autowired
    UserManagementService userManagementService;

    @MockBean
    AuthenticationService authenticationService;

    User user = new User("test","id");


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


    /**
     * In order to create and add a Plant to an User, it is necessary to create the User first (which usually happens in the frontend)
     * After that a new Clone can be created and added
     */
    @Test
    public void addNewIVCloneToGrowListTest(){
        Specimen specimen;
        this.userManagementService.createMinimalUser(user.getOAuthId(),user.getUsername(),"aaa","USA");
        specimen = this.growlistservice.addNewIVCloneToGrowList(user,"clipeata","Be-3552", "","","Andreas Wistuba");
        assertNotNull(specimen);
    }


    /**
     * In order to add a Plant to an User, it is necessary to create the User first (which usually happens in the frontend)
     * After that the existing clone can be added (see startUp/clones.csv.
     */
    @Test
    public void addIVCloneToGrowListTest(){
        Specimen specimen;
        this.userManagementService.createMinimalUser(user.getOAuthId(),user.getUsername(),"aaa","USA");
        specimen = this.growlistservice.addExistingCloneToGrowList(user, "FV-030-03");
        assertNotNull(specimen);
    }




}
