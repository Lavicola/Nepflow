package com.nepflow.NepenthesManagement.Service;

import com.nepflow.NepenthesManagement.DatabaseInitializationService.DataInitializationService;
import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Repository.ProducerRepository;
import com.nepflow.NepenthesManagement.Repository.SexRepository;
import jakarta.transaction.Transactional;
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

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class NepenthesServiceManagementTest {


    @MockBean
    DataInitializationService dataInitializationService;

    private static Neo4j embeddedDatabaseServer;


    @Autowired
    NepenthesManagementService nepenthesManagementService;

    @Autowired
    SexRepository sexRepository;

    @Autowired
    ProducerRepository producerRepository;


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
    @Transactional
    public void createLabelPrefixTest(){
        Label.addValidPlant(LabelFormats.nep1);
        Label.addValidPlant(LabelFormats.nep2);

        Label nepenthes1 = nepenthesManagementService.createLabel(new Nepenthes(LabelFormats.nep1));
        Label nepenthes2 = nepenthesManagementService.createLabel(new Nepenthes(LabelFormats.nep2));
        Label hybrid = nepenthesManagementService.createLabel(new PrimaryHybrid(LabelFormats.hybridFormat1));
        Label hybrid2 = nepenthesManagementService.createLabel(new PrimaryHybrid(LabelFormats.hybridFormat2));

        assertEquals("N-0",nepenthes1.getPrefix());
        assertEquals("N-1",nepenthes2.getPrefix());
        assertEquals("H-0",hybrid.getPrefix());
        assertEquals("H-1",hybrid2.getPrefix());

    }

    @Test
    @Transactional
    public void addIVCloneWithSexTest(){
        Label.addValidPlant(LabelFormats.nep1);
        Label.addValidPlant(LabelFormats.nep2);
        String cloneID = "BE-3225";
        Sex male = new Sex("Male");
        Sex female = new Sex("Female");
        Location location = new Location("Borneo");
        Producer producer = new Producer("AW");

        String maleCloneID = IVClone.generateInternalCloneId(cloneID,male);
        String femaleCloneID = IVClone.generateInternalCloneId(cloneID,female);
        String defaultCloneId = IVClone.generateInternalCloneId(cloneID,null);
        this.sexRepository.save(male);
        this.sexRepository.save(female);
        this.producerRepository.save(producer);

        Nepenthes nepenthes1 = (Nepenthes) nepenthesManagementService.createLabel(new Nepenthes(LabelFormats.nep1));

        IVClone cloneFemale = this.nepenthesManagementService.saveIVClone(nepenthes1,cloneID, female.getSexAsString(), null,location.getName(), producer.getName());
        IVClone cloneFemaleDuplicate = this.nepenthesManagementService.saveIVClone(nepenthes1,cloneID, female.getSexAsString(), null,location.getName(),producer.getName());
        IVClone cloneMale = this.nepenthesManagementService.saveIVClone(nepenthes1,cloneID, male.getSexAsString(), null,location.getName(),producer.getName());
        IVClone cloneDefault = this.nepenthesManagementService.saveIVClone(nepenthes1,cloneID, null, null,location.getName(),producer.getName());
        IVClone cloneDefaultDuplicate = this.nepenthesManagementService.saveIVClone(nepenthes1,cloneID, null, null,location.getName(),producer.getName());

        assertEquals(cloneMale.getInternalCloneId(),maleCloneID);
        assertEquals(cloneFemale.getInternalCloneId(),femaleCloneID);
        assertEquals(cloneDefault.getInternalCloneId(),defaultCloneId);
        assertEquals(cloneDefaultDuplicate,null);
        assertEquals(cloneFemaleDuplicate,null);

    }




}
