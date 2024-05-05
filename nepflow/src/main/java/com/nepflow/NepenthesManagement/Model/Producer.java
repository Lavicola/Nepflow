package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Producer {

    @Id
    String name;

    public Producer(String name){
        this.name = name;
    }

}
