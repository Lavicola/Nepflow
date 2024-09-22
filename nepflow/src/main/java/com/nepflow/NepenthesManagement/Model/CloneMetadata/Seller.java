package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Abstract Class which abstracts concrete types of sellers.
 * Abstraction allows optimized filtering.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Node
public abstract class Seller {

    /**
     *
     */
    @Id
    @Property
    @Getter
    private String name;

    /**
     * Link to website or other contact information.
     */
    @Property
    @Getter
    private String contact;


    /**
     *
     */
    @Version
    private Long version;


    /**
     * @param name
     * @param contact
     */
    public Seller(final String name, final String contact) {
        assert !name.equals("");
        assert !contact.equals("");
        this.name = name;
        this.contact = contact;
    }


}
