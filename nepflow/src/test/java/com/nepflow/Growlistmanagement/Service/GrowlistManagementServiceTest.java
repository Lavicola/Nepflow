package com.nepflow.Growlistmanagement.Service;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * These Test, tests the integration with NepenthesManagement and UserManagement
 *
 */

@SpringBootTest
public class GrowlistManagementServiceTest {


    private static Neo4j embeddedDatabaseServer;

    @MockBean
    DataInitializationService dataInitializationService;

    @MockBean
    AuthenticationService authenticationService;
    @Autowired
    Growlistservice growlistservice;
    @Autowired
    GrowlistRepository growlistRepository;
    @Autowired
    GrowlistTestDataInserter  growlistTestDataInserter;


    static boolean executedOnce = false;


    @BeforeAll
    static void initializeNeo4j() {
        embeddedDatabaseServer = Neo4jBuilders.newInProcessBuilder()
                .withDisabledServer()
                .build();


    }

    @BeforeEach
    public void setUp(){
        // for now, since TestInstance.Lifecycle.PER_CLASS is not possible due to initializeNeo4j
        if(!executedOnce){
            this.growlistTestDataInserter.insertData();
            this.growlistRepository.save(new Growlist(growlistTestDataInserter.user1));
            this.growlistRepository.save(new Growlist(growlistTestDataInserter.user2));
            executedOnce = true;
        }

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
        Specimen ivSpecimen;
        Specimen icSpecimen;
        ivSpecimen = this.growlistservice.addNewIVCloneToGrowList(growlistTestDataInserter.user1,
                growlistTestDataInserter.cloneNotInDBIV.getLabelName(),
                growlistTestDataInserter.cloneNotInDBIV.getCloneId(),
                growlistTestDataInserter.cloneNotInDBIV.getSexAsString(),
                growlistTestDataInserter.cloneNotInDBIV.getLocationAsString(),
                growlistTestDataInserter.cloneNotInDBIV.getSellerAsString());
        icSpecimen = this.growlistservice.addNewICCloneToGrowList(growlistTestDataInserter.user1,growlistTestDataInserter.ivSpeciesCloneMale.getLabelName(),
                growlistTestDataInserter.cloneNotInDBIC.getCloneId(),
                growlistTestDataInserter.cloneNotInDBIC.getSexAsString(),
                growlistTestDataInserter.cloneNotInDBIC.getLocationAsString(),
                growlistTestDataInserter.cloneNotInDBIC.getSellerAsString());
        Growlist growlist = this.growlistRepository.findGrowlistByUserId(growlistTestDataInserter.user1.getOAuthId());
        assertNotNull(ivSpecimen);
        assertNotNull(icSpecimen);
        assertNotNull(growlist);
        assertTrue(growlist.getSpecimens().contains(ivSpecimen),"Growlist should contain ivSpecimen");
        assertTrue(growlist.getSpecimens().contains(icSpecimen),"Growlist should contain ivSpecimen");


    }


    /**
     * Test to make sure that it is possible to add existing  Clones the  Growlist
     *
     */
    @Test
    public void addExistingIVandICCloneToGrowListTest(){
        Specimen ivSpecimen;
        Specimen icSpecimen;
        ivSpecimen = this.growlistservice.addExistingCloneToGrowList(growlistTestDataInserter.user1, growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId());
        icSpecimen = this.growlistservice.addExistingCloneToGrowList(growlistTestDataInserter.user1, growlistTestDataInserter.icSpeciesClone.getInternalCloneId());
        Growlist growlist = this.growlistRepository.findGrowlistByUserId(growlistTestDataInserter.user1.getOAuthId());

        assertNotNull(ivSpecimen);
        assertNotNull(icSpecimen);
        assertNotNull(growlist);
        assertTrue(growlist.getSpecimens().contains(ivSpecimen),"Growlist should contain ivSpecimen");
        assertTrue(growlist.getSpecimens().contains(icSpecimen),"Growlist should contain ivSpecimen");

    }

}
