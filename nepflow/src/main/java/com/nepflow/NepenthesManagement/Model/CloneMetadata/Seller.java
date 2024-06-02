package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public abstract class Seller {

    @Id
    @Property
    @Getter
    String name;

    @Property
    @Getter
    // link to FB or maybe website
    String contact;


    @Version
    private Long version;


    public Seller(String name,String contact){
        assert !name.equals("");
        assert !contact.equals("");
        this.name = name;
        this.contact = contact;
    }


}
