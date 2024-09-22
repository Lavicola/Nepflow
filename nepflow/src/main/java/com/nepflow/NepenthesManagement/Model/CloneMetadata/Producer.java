package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import org.springframework.data.neo4j.core.schema.Node;

/**
 * Model which represents a commercial Seller (also called Producer).
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Node
public class Producer extends Seller {

    /**
     * @param name    name of the (private) Seller
     * @param contact contact information where the seller can be reached e.g website
     */
    public Producer(final String name, final String contact) {
        super(name, contact);
    }

}
