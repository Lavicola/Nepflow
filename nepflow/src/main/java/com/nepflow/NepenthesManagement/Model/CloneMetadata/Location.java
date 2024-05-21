package com.nepflow.NepenthesManagement.Model.CloneMetadata;


import com.google.common.util.concurrent.CycleDetectingLockFactory;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Arrays;
import java.util.stream.Collectors;

@Node
public class Location {

    @Id
    @Property
    @Getter
    String name;

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
