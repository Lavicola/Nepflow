package com.nepflow.NepenthesManagement.Model;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Location {

    @Id
    String location;

    public Location(String location) {
        this.location = location;
    }



}
