package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import com.nepflow.NepenthesManagement.Repository.IVCloneRepository;
import com.nepflow.NepenthesManagement.Repository.IndividualCloneRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.harness.Neo4j;
import org.neo4j.harness.Neo4jBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataNeo4jTest
public class CloneTest {

    @Autowired
    IndividualCloneRepository individualCloneRepository;

    @Autowired
    IVCloneRepository ivCloneRepository;

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
    public void CloneSpecificClassesTest() {
        String cloneID = "BE-4544";
        String individualCloneID = "indi";
        Nepenthes villosa = new Nepenthes("villosa");
        IVClone ivClone = new IVClone(cloneID, villosa);
        ICClone ICClone = new ICClone(individualCloneID, villosa);
        IVClone r_ivClone;
        ICClone r_individualclone;
        Clone r_cloneIndividual;
        Clone r_cloneIVClone;

        this.ivCloneRepository.save(ivClone);
        this.individualCloneRepository.save(ICClone);

        //r_ivClone = this.ivCloneRepository.findIVCloneByCloneIdAndAndNepenthesName(cloneID,villosa.getName());
        r_individualclone = this.individualCloneRepository.findIndividualCloneByCloneIdAndNepenthesName(individualCloneID,villosa.getName());
        r_cloneIVClone = this.cloneRepository.findCloneByCloneIdAndNepenthesName(cloneID,villosa.getName());
        r_cloneIndividual = this.cloneRepository.findCloneByCloneIdAndNepenthesName(individualCloneID,villosa.getName());


        //assertEquals(r_ivClone, ivClone);
        assertEquals(ICClone, r_individualclone);
        assertEquals(ivClone, r_cloneIVClone);
        assertEquals(ICClone, r_cloneIndividual);



    }


}
