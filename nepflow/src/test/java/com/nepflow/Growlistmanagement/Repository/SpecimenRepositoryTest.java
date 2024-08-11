package com.nepflow.Growlistmanagement.Repository;

import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Repository.GrowlistRepository;
import com.nepflow.GrowlistManagement.Repository.SpecimenRepository;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataNeo4jTest

public class SpecimenRepositoryTest {

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    GrowlistRepository growlistRepository;

    @Autowired
    CloneRepository cloneRepository;


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
    public void addSpecimenToGrowlistAndUserTest(){

        Specimen specimen = LabelCloneDefinitions.specimenUser1Male;
        Growlist growlist =  new Growlist(specimen.getUser());
        Growlist rGrowlist;
        Specimen rSpecimen;
        this.cloneRepository.save(specimen.getClone());
        this.growlistRepository.save(growlist);
        rSpecimen  = this.specimenRepository.addSpecimenToGrowlistAndUser(specimen.getUser().getOAuthId(),specimen.getClone().getInternalCloneId());
        rGrowlist = this.growlistRepository.findGrowlistByUsername(specimen.getUser().getUsername());
        assertNotNull(rSpecimen);
        assertNotNull(rGrowlist);
        assertEquals(1,rGrowlist.getSpecimens().size());
        assertNotNull(rSpecimen.getClone());
        assertNotNull(rSpecimen.getClone().getLabel());
        assertEquals(rGrowlist.getSpecimens().get(0),rSpecimen);

    }


    @Test
    public void deleteSpecimenTest() {
        List<Specimen> specimenList;
        Growlist rGrowlist;
        Specimen specimen = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimen2 = new Specimen(LabelCloneDefinitions.icSpeciesClone2,specimen.getUser());

        Growlist growlist =  new Growlist(specimen.getUser());
        growlist.addSpecimen(specimen);
        growlist.addSpecimen(specimen2);
        this.growlistRepository.save(growlist);
        this.specimenRepository.deleteSpecimen(specimen.getUser().getOAuthId(),  specimen.getUuid());

        specimenList  =  this.specimenRepository.findAll();
        rGrowlist = this.growlistRepository.findGrowlistByUsername(specimen.getUser().getUsername());

        assertEquals(1,specimenList.size());
        assertEquals(specimenList.size(),rGrowlist.getSpecimens().size());
        assertEquals(specimenList.get(0),rGrowlist.getSpecimens().get(0));


    }

}
