package com.nepflow.NepenthesManagement.Model;


import com.google.common.util.concurrent.CycleDetectingLockFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Arrays;
import java.util.stream.Collectors;

@Node
public class Location {

    @Id
    String name;

    public Location(String location) {
        assert location.equals("");

        this.name = Arrays.stream(location.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }


}
