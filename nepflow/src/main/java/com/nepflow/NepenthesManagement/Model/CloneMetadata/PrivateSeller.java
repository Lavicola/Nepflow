package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class PrivateSeller extends Seller{
    public PrivateSeller(String name, String contact) {
        super(name, contact);
    }
}
