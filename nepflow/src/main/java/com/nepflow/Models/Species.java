package com.nepflow.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Species")
public class Species {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Property
    @Getter @Setter
    private String name;

    public Species(String name){
        this.name = name;
    }




}
