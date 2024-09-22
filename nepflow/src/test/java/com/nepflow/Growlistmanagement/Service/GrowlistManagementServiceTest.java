package com.nepflow.Growlistmanagement.Service;

import com.nepflow.BaseModules.ImageModule.Service.ImageService;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import jakarta.transaction.Transactional;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


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

    @MockBean
    ImageService imageService;

    @Autowired
    Growlistservice growlistservice;
    @Autowired
    GrowlistRepository growlistRepository;
    @Autowired
    GrowlistTestDataInserter  growlistTestDataInserter;


    String bucketname = "";
    String url = "";

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
            when(authenticationService.getAuthenticatedUser()).thenReturn(growlistTestDataInserter.user1);
            when(imageService.deleteImage(bucketname,url)).thenReturn(true);
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
     * Test to make sure that it is possible to add existing Clones the Growlist
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

    @Test
    public void deleteSpecimenFromGrowlistTest() {
        User user = growlistTestDataInserter.user1;
        Specimen ivSpecimen = new Specimen(growlistTestDataInserter.ivSpeciesCloneMale,user);

        int amountBeforeDelete;
        int amountAfterDelete;
        boolean wasDeleted;
        ivSpecimen = this.growlistservice.addExistingCloneToGrowList(user, growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId());
        this.growlistservice.addExistingCloneToGrowList(user, growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId());

        amountBeforeDelete = this.growlistservice.getGrowlist(user.getUsername()).getSpecimens().size();
        wasDeleted = this.growlistservice.deleteSpecimenFromGrowlist(user,ivSpecimen.getUuid());
        amountAfterDelete    = this.growlistservice.getGrowlist(user.getUsername()).getSpecimens().size();

        assertTrue(wasDeleted);
        assertEquals(amountBeforeDelete,amountAfterDelete+1);
    }

    @Test
    @Transactional
    public void addExistingClonesToGrowlistTest() {
        User user = growlistTestDataInserter.user1;
        Growlist growlist;
        int growlistBeforeAdd;
        List<String> cloneIds = Arrays.asList(
                growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId(),
                growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId(),
                growlistTestDataInserter.icSpeciesClone.getInternalCloneId()
        );
        growlistBeforeAdd = this.growlistservice.getGrowlist(user.getUsername()).getSpecimens().size();
        this.growlistservice.addExistingClonesToGrowlist(user, cloneIds);
        growlist = this.growlistservice.getGrowlist(user.getUsername());

        assertEquals(cloneIds.size(), growlist.getSpecimens().size()-growlistBeforeAdd);

    }

    @Test
    @Transactional
    public void addExistingClonesToGrowlistWithOneInvalidInternalCloneIdTest() {
        User user = growlistTestDataInserter.user1;
        Growlist growlist;
        int growlistBeforeAdd;

        List<String> cloneIds = Arrays.asList(
                growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId() + "M",
                growlistTestDataInserter.ivSpeciesCloneMale.getInternalCloneId(),
                growlistTestDataInserter.icSpeciesClone.getInternalCloneId()
        );
        growlistBeforeAdd = this.growlistservice.getGrowlist(user.getUsername()).getSpecimens().size();
        this.growlistservice.addExistingClonesToGrowlist(user, cloneIds);
        growlist = this.growlistservice.getGrowlist(user.getUsername());


        assertEquals(cloneIds.size()-1, growlist.getSpecimens().size()-growlistBeforeAdd);

    }



    }
