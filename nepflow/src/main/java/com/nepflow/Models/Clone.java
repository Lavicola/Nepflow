package com.nepflow.Models;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Objects;


@Node("Clone")
public class Clone {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    Species species;

    // A clone Id has a species Scope. e.g villosa AW01/truncata AW01 are possible
    String cloneId;

    public Clone(String cloneId, Species species){
        this.cloneId = cloneId;
        this.species = species;
    }





}
