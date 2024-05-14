package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IVHybrid extends HybridClone {
    @Setter
    @Relationship("PROPAGATED_BY")
    Producer producer;

    // TODO Producer must be linked if an IV Hybrid is added, add to constructor at some point
    protected IVHybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId, grex);
    }

    protected IVHybrid(String name, String cloneId) {
        super(name, cloneId);
    }
}
