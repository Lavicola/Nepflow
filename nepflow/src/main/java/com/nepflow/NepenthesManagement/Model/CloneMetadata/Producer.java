package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Arrays;
import java.util.stream.Collectors;

@Node
public class Producer {

    @Id
    @Property
            @Getter
    String name;


    @Version
    private Long version;

    public Producer(String name){
        assert !name.equals("");
        this.name = name;
    }

}
