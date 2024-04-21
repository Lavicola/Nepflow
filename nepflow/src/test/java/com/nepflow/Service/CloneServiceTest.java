package com.nepflow.Service;

import com.nepflow.Models.Species;
import com.nepflow.Repository.SpeciesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataNeo4jTest
public class CloneServiceTest {
    // not yet working, Service always null
    @Autowired
    CloneService cloneService;

    @Autowired
    SpeciesRepository speciesRepository;

    @Test
    public void UniqueClonePerSpeciesTest(){

        System.out.println("Test if CloneID for species are unique ");

        String SAME_CLONEID = "BE-5555";
        Species villosa = new Species("villosa");
        Species truncata = new Species("truncata");
        boolean isCreatedCloneVillosa;
        boolean isCreatedCloneTruncata;
        boolean isCreatedCloneTruncataAGAIN;

        this.speciesRepository.save(villosa);
        this.speciesRepository.save(truncata);
        isCreatedCloneVillosa = this.cloneService.createNewSpeciesClone(villosa,SAME_CLONEID);
        isCreatedCloneTruncata = this.cloneService.createNewSpeciesClone(truncata,SAME_CLONEID);
        isCreatedCloneTruncataAGAIN = this.cloneService.createNewSpeciesClone(truncata,SAME_CLONEID);

        assertTrue(isCreatedCloneVillosa);
        assertTrue(isCreatedCloneTruncata);
        assertFalse(isCreatedCloneTruncataAGAIN);

    }


}
