package com.nepflow.Growlistmanagement.Service;

import com.nepflow.BaseModules.ImageModule.Service.ImageService;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementMetaDataService;
import com.nepflow.NepenthesManagement.Service.NepenthesManagementService;
import com.nepflow.UserManagement.Model.Country;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Repository.CountryRepository;
import com.nepflow.UserManagement.Service.AuthenticationService;
import com.nepflow.UserManagement.Service.UserManagementService;
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

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    NepenthesManagementService nepenthesManagementService;

    @Autowired
    NepenthesManagementMetaDataService nepenthesManagementMetaDataService;

    @Autowired
    Growlistservice growlistservice;

    @Autowired
    UserManagementService userManagementService;

    @MockBean
    AuthenticationService authenticationService;

    @Autowired
    GrowlistRepository growlistRepository;


    User user = new User("test","id");
    Producer producer = LabelCloneDefinitions.producer;
    Label species = LabelCloneDefinitions.species;
    Clone icSpeciesClone = LabelCloneDefinitions.icSpeciesClone;
    Clone ivSpeciesClone = LabelCloneDefinitions.ivSpeciesClone;

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
            String country = "USA";
            this.countryRepository.save(new Country(country));
            this.userManagementService.createMinimalUser(user.getOAuthId(),user.getUsername(),"aaa","USA");
            this.nepenthesManagementService.createLabel(species);
            this.nepenthesManagementMetaDataService.saveProducer(producer.getName(),producer.getContact());
            this.nepenthesManagementService.saveIVClone(species,
                    ivSpeciesClone.getCloneId(),
                    ivSpeciesClone.getSexAsString(),
                    ivSpeciesClone.getLocationAsString(),
                    ivSpeciesClone.getSellerAsString());
            this.nepenthesManagementService.saveICCloneWithCloneId(species,
                    icSpeciesClone.getCloneId(),
                    ivSpeciesClone.getSexAsString(),
                    ivSpeciesClone.getLocationAsString(),
                    ivSpeciesClone.getSellerAsString());
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
        Clone newClone1 = new IVSpeciesClone(species,"NEUIV",null,null,producer);
        Clone newClone2 = new ICSpeciesClone(species,null,"NEUIC",null,producer);
        ivSpecimen = this.growlistservice.addNewIVCloneToGrowList(user,species.getName(),
                newClone1.getCloneId(),
                newClone1.getSexAsString(),
                newClone1.getLocationAsString(),
                newClone1.getSellerAsString());
        icSpecimen = this.growlistservice.addNewICCloneToGrowList(user,species.getName(),
                newClone2.getCloneId(),
                newClone2.getSexAsString(),
                newClone2.getLocationAsString(),
                newClone2.getSellerAsString());
        Growlist growlist = this.growlistRepository.findGrowlistById(this.user.getOAuthId());

        assertNotNull(ivSpecimen);
        assertNotNull(icSpecimen);
        assertNotNull(growlist);
        assertTrue(growlist.getSpecimens().contains(ivSpecimen),"Growlist should contain ivSpecimen");
        assertTrue(growlist.getSpecimens().contains(icSpecimen),"Growlist should contain ivSpecimen");


    }


    /**
     * In order to add a Plant to an User, it is necessary to create the User first (which usually happens in the frontend)
     * After that the existing clone can be added (see startUp/clones.csv.
     */
    @Test
    public void addIVandICCloneToGrowListTest(){
        Specimen ivSpecimen;
        Specimen icSpecimen;
        ivSpecimen = this.growlistservice.addExistingCloneToGrowList(user, ivSpeciesClone.getInternalCloneId());
        icSpecimen = this.growlistservice.addExistingCloneToGrowList(user, icSpeciesClone.getInternalCloneId());
        Growlist growlist = this.growlistRepository.findGrowlistById(this.user.getOAuthId());

        assertNotNull(ivSpecimen);
        assertNotNull(icSpecimen);
        assertNotNull(growlist);
        assertTrue(growlist.getSpecimens().contains(ivSpecimen),"Growlist should contain ivSpecimen");
        assertTrue(growlist.getSpecimens().contains(icSpecimen),"Growlist should contain ivSpecimen");

    }



}
