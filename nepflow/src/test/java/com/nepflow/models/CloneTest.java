package com.nepflow.models;

import com.nepflow.Models.Clone;
import com.nepflow.Models.Region;
import com.nepflow.Models.Species;
import com.nepflow.Repository.CloneRepository;
import com.nepflow.Repository.RegionRepository;
import com.nepflow.Repository.SpeciesRepository;
import com.nepflow.Service.CloneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataNeo4jTest
public class CloneTest {

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    CloneRepository cloneRepository;

    @Test
    public void CloneRetrievalTest(){
        String SAME_CLONEID = "BE-5555";
        String OTHER_CLONEID = "BE-6666";

        Species villosa = new Species("villosa");
        Species truncata = new Species("truncata");
        Clone cloneVillosa = new Clone(SAME_CLONEID,villosa);
        Clone cloneTruncataSame = new Clone(SAME_CLONEID,truncata);
        Clone cloneTruncata2 = new Clone(OTHER_CLONEID,truncata);
        Clone rVillosa5555;
        Clone rTruncata5555;
        List<Clone> clones;

        this.speciesRepository.save(villosa);
        this.speciesRepository.save(truncata);
        this.cloneRepository.save(cloneVillosa);
        this.cloneRepository.save(cloneTruncataSame);
        this.cloneRepository.save(cloneTruncata2);
        rVillosa5555 = this.cloneRepository.findCloneByCloneIdAndSpeciesName(SAME_CLONEID,villosa.getName());
        rTruncata5555 = this.cloneRepository.findCloneByCloneIdAndSpeciesName(SAME_CLONEID,truncata.getName());
        clones = this.cloneRepository.findClonesByCloneId(SAME_CLONEID);

        assertTrue(cloneVillosa.getId() == rVillosa5555.getId());
        assertTrue(rTruncata5555.getId() == cloneTruncataSame.getId());
        assertTrue(clones.size() == 2);



    }


}
