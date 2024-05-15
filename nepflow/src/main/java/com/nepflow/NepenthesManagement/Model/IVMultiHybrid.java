package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Relationship;

public class IVMultiHybrid extends MultiHybrid{

    @Relationship("PROPAGATED_BY")
    Producer producer;

    IVMultiHybrid(){

    }

    public IVMultiHybrid(String name, String cloneId, Grex grex, Sex sex, Producer producer) {
        super(name, grex,sex);
        this.cloneId = cloneId;
        this.producer = producer;
    }

}
