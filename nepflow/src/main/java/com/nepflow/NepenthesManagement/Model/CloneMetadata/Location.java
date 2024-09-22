package com.nepflow.NepenthesManagement.Model.CloneMetadata;


import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Model which represents a location/origin of a specific Clone.
 * e.g. Mt. Trusmadi
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Node
public class Location {

    /**
     *
     */
    @Id
    @Getter
    private String name;

    /**
     *
     */
    @Version
    private Long version;


    /**
     * @param locationAsString name of the location as String
     */
    public Location(final String locationAsString) {
        if (locationAsString == null || locationAsString.trim().isEmpty()) {
            throw new IllegalArgumentException("Location name cannot be empty");
        }

        this.name = Arrays.stream(locationAsString.trim().split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    /**
     *
     */
    public Location() {
    }


}
