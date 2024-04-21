package com.nepflow.models;

import com.nepflow.Models.Region;
import com.nepflow.Repository.RegionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataNeo4jTest
public class RegionTest {


    @Autowired
    RegionRepository regionRepository;


    @Test
    public void returnStringCustomQueryTest() {
        System.out.println("Check if Custom Query to return String of Region works");
        String USA = "USA";
        String EU = "EU";
        Region USAregion = new Region(USA);
        Region EUregion = new Region(EU);
        String rUSAregion;
        String rEUregion;
        this.regionRepository.save(USAregion);
        this.regionRepository.save(EUregion);
        rUSAregion = this.regionRepository.getRegionName(USA);
        rEUregion = this.regionRepository.getRegionName(EU);

        assertThat(USA.equals(rUSAregion)).isTrue();
        assertThat(EU.equals(rEUregion)).isTrue();
        System.out.println(USAregion.getId());


    }


}
