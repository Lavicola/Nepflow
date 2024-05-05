package com.nepflow.NepenthesManagement.Model;


import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.stream.Stream;

@Node("Mountain")
public class Mountain {

    @Id
    @Property
    String name;

    public Mountain(String mountain) {
        this.name = this.normalizeMountainName(mountain);
    }

    private String normalizeMountainName(String mountain) {
        return StringUtils.capitalize(mountain.trim());
    }


}
