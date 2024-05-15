package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;

public class IVHybrid extends Hybrid{


    @Relationship("PROPAGATED_BY")
    Producer producer;


    public IVHybrid(){

    }
    public IVHybrid(String name,String cloneId, Grex grex,Sex sex,Producer producer) {
        super(name, grex,sex);
        this.cloneId = cloneId;
        this.producer = producer;
    }




}
