package com.nepflow.UserManagement.Model;

import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model representing the country a user lives in.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class Country {


    /**
     *
     */
    @Id
    @Property
    @Getter
    private String name;

    /**
     *
     */
    @Version
    private Long version;


    /**
     * @param name name of the country
     */
    public Country(final String name) {
        this.name = name;
    }


}
