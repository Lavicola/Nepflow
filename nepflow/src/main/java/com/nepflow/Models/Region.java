package com.nepflow.Models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.stereotype.Indexed;

@Node("Region")
public class Region {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Property
    @Getter
    private String name;

    public Region(String name){
        this.name = name;
    }


}
