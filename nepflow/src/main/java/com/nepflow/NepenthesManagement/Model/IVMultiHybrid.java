package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IVMultiHybrid extends MultiHybridClone{

    @Setter
    @Relationship("PROPAGATED_BY")
    Producer producer;
    protected IVMultiHybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId, grex);
    }

    protected IVMultiHybrid(String name, String cloneId) {
        super(name, cloneId);
    }
}
