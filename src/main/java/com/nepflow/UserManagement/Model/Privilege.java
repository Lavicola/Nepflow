package com.nepflow.UserManagement.Model;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Collection;

@Data
public class Privilege {
    /** The id. */
    @Id
    @GeneratedValue
    private String id;

    /** The name. */
    private String name;

    /** The description of the role. */
    private String description;

    /** The roles which have this privilege. */
    @Relationship("IS_IN")
    private Collection<Role> roles;

    public Privilege() {
        super();
    }

    public Privilege(final String name) {
        super();
        this.name = name;
    }

    public Privilege(final String name, final String description) {
        super();
        this.name = name;
        this.description = description;
    }


}
