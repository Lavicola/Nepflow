package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.stream.Collectors;

@Node
public class Producer {

    @Id
    String name;

    public Producer(String name){
        assert name.equals("");
        this.name = name;
    }

}
