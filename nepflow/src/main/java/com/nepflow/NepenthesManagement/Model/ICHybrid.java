package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Node;

/**
 * A Hybrid represent a Nepenthes which has either two different NepenthesSpecies as Parents
 * or a NepenthesSpecies and a Hybrid. Important is just that no more than three species
 * are allowed
 */

@Node
public class ICHybrid extends HybridClone {


    protected ICHybrid(String name, String cloneId) {
        super(name, cloneId);
    }

    protected ICHybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId,grex);
    }



}
