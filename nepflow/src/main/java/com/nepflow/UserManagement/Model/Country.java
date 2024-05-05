package com.nepflow.UserManagement.Model;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.annotation.Version;

import java.util.Locale;

@Node
public class Country {



    @Id
    @Property
    @Getter
    private String name;

    @Version
    private Long version;


    public Country(String name) {
        this.name = name;
    }



}
