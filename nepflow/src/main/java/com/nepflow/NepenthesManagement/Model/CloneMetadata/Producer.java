package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Producer extends Seller {

    public Producer(String name,String contact){
        super(name,contact);
    }

}
