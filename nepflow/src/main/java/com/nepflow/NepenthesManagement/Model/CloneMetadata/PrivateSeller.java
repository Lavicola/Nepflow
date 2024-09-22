package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import org.springframework.data.neo4j.core.schema.Node;

/**
 * Model which abstracts a private Seller.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */
@Node
public class PrivateSeller extends Seller {
    /**
     * @param name    name of the (private) Seller
     * @param contact contact information where the seller can be reached e.g website
     */
    public PrivateSeller(final String name, final String contact) {
        super(name, contact);
    }
}
