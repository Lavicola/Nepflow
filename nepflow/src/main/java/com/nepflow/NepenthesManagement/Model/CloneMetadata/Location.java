package com.nepflow.NepenthesManagement.Model.CloneMetadata;


import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.stream.Collectors;

@Node
public class Location {

    @Id
    @Getter
    String name;

    @Version
    private Long version;


    public Location(String location) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location name cannot be empty");
        }

        this.name = Arrays.stream(location.trim().split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
    public Location() {
    }


}
