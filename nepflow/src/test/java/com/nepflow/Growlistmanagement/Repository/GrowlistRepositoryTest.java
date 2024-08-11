package com.nepflow.Growlistmanagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.UserManagement.Model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.Assert.*;

@DataNeo4jTest
public class GrowlistRepositoryTest {


    @Autowired
    GrowlistRepository growlistRepository;

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
    public void  updateGrowlistVisibilityTest() {
        User user = LabelCloneDefinitions.user1;
        Growlist growlist = new Growlist(user);
        boolean currentVisibility = growlist.isPublic();
        boolean nextVisibility = !currentVisibility;
        this.growlistRepository.save(growlist);
        this.growlistRepository.updateGrowlistVisibility(user.getOAuthId(), growlist.getUuid(),!currentVisibility);
        assertEquals(this.growlistRepository.findGrowlistByUserId(user.getOAuthId()).isPublic(),nextVisibility);
        this.growlistRepository.updateGrowlistVisibility(user.getOAuthId(), growlist.getUuid(),!nextVisibility);
        assertEquals(this.growlistRepository.findGrowlistByUserId(user.getOAuthId()).isPublic(),currentVisibility);


    }

    @Test
    public void  findGrowlistByUsernameAllSpecimenReturnedTest() {
        Growlist rGrowlist;
        Growlist rDifferentGrowlist;

        Clone clone = LabelCloneDefinitions.icSpeciesClone2;
        User user = LabelCloneDefinitions.user1;
        User differentUser = LabelCloneDefinitions.user2;
        Growlist growlist = new Growlist(user);
        Growlist differentGrowlist = new Growlist(differentUser);
        growlist.addSpecimen(new Specimen(clone, user));
        growlist.addSpecimen( new Specimen(clone, user));
        growlist.addSpecimen( new Specimen(clone, user));
        differentGrowlist.addSpecimen( new Specimen(clone, differentUser));
        differentGrowlist.addSpecimen( new Specimen(clone, differentUser));

        this.growlistRepository.save(growlist);
        this.growlistRepository.save(differentGrowlist);
        rGrowlist = this.growlistRepository.findGrowlistByUsername(user.getUsername());
        rDifferentGrowlist  = this.growlistRepository.findGrowlistByUsername(differentUser.getUsername());

        assertEquals(growlist.getSpecimens().size(),rGrowlist.getSpecimens().size());
        assertEquals(differentGrowlist.getSpecimens().size(),rDifferentGrowlist.getSpecimens().size());
    }


    @Test
    public void  findGrowlistByIdAllSpecimenReturnedTest() {
        Growlist rGrowlist;
        Growlist rDifferentGrowlist;

        Clone clone = LabelCloneDefinitions.icSpeciesClone2;
        User user = LabelCloneDefinitions.user1;
        User differentUser = LabelCloneDefinitions.user2;
        Growlist growlist = new Growlist(user);
        Growlist differentGrowlist = new Growlist(differentUser);
        growlist.addSpecimen(new Specimen(clone, user));
        growlist.addSpecimen( new Specimen(clone, user));
        growlist.addSpecimen( new Specimen(clone, user));
        differentGrowlist.addSpecimen( new Specimen(clone, differentUser));
        differentGrowlist.addSpecimen( new Specimen(clone, differentUser));

        this.growlistRepository.save(growlist);
        this.growlistRepository.save(differentGrowlist);
        rGrowlist = this.growlistRepository.findGrowlistByUserId(user.getOAuthId());
        rDifferentGrowlist  = this.growlistRepository.findGrowlistByUserId(differentUser.getOAuthId());

        assertEquals(growlist.getSpecimens().size(),rGrowlist.getSpecimens().size());
        assertEquals(differentGrowlist.getSpecimens().size(),rDifferentGrowlist.getSpecimens().size());
    }

        /**
         * This Method is used to get a Growlist of a specific  User.
         * Check if all values are retrieved
         */
    @Test
    public void  findGrowlistByIdAttributesNotNullTest(){
        Growlist rGrowlist;
        Clone clone = LabelCloneDefinitions.icSpeciesClone2;
        User user = LabelCloneDefinitions.user1;
        Growlist growlist = new Growlist(user);
        Specimen userSpecimen = new Specimen(clone,user);

        growlist.addSpecimen(userSpecimen);
        this.growlistRepository.save(growlist);
        rGrowlist=this.growlistRepository.findGrowlistByUserId(user.getOAuthId());

        assertNotNull(rGrowlist);
        assertNotNull(rGrowlist.getUser());
        assertNotNull(rGrowlist.getUser().getCountry());

        assertEquals(1,rGrowlist.getSpecimens().size());
        assertNotNull(rGrowlist.getSpecimens().get(0).getClone());
        assertNotNull(rGrowlist.getSpecimens().get(0).getClone().getLabel());
        assertNotNull("",rGrowlist.getSpecimens().get(0).getClone().getLocation());
        assertNotEquals("",rGrowlist.getSpecimens().get(0).getClone().getSellerAsString());
    }


    /**
     * This Method is used to get a Growlist of a specific  User.
     * Check if all values are retrieved
     */
    @Test
    public void  findGrowlistByUsernameAttributesNotNullTest(){
        Growlist rGrowlist;
        Clone clone = LabelCloneDefinitions.icSpeciesClone2;
        User user = LabelCloneDefinitions.user1;
        Growlist growlist = new Growlist(user);
        Specimen userSpecimen = new Specimen(clone,user);

        growlist.addSpecimen(userSpecimen);
        this.growlistRepository.save(growlist);
        rGrowlist=this.growlistRepository.findGrowlistByUsername(user.getUsername());

        assertNotNull(rGrowlist);
        assertNotNull(rGrowlist.getUser());
        assertNotNull(rGrowlist.getUser().getCountry());

        assertEquals(1,rGrowlist.getSpecimens().size());
        assertNotNull(rGrowlist.getSpecimens().get(0).getClone());
        assertNotNull(rGrowlist.getSpecimens().get(0).getClone().getLabel());
        assertNotNull("",rGrowlist.getSpecimens().get(0).getClone().getLocation());
        assertNotEquals("",rGrowlist.getSpecimens().get(0).getClone().getSellerAsString());

    }

}
