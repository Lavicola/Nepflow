package com.nepflow.UserManagement.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;


@Node
@Data
public class Role{

    /** The id. */
    @Id
    @GeneratedValue
    private String id;

    private Set<User> users = new HashSet<>();

    @Relationship("CONTAINS")
    private Set<Privilege> privileges = new HashSet<>();

    /** The name. */
    private String name;

    private String description;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Role(final String name, final String description) {
        super();
        this.name = name;
        this.description = description;
    }


}