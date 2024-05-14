package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICMultiHybrid extends MultiHybridClone {


    protected ICMultiHybrid(String name, String cloneId) {
        super(name, cloneId);
    }


    protected ICMultiHybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId,grex);
    }

}
