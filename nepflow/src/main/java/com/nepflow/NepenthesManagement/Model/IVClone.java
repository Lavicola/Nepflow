package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * An IVClone is a clone which is propagated in a Laboratory
 * Certain IVClone represent a Pool of Clones and not one individual Clone
 */

@Node
public class IVClone extends SpeciesClone {

    @Setter
    @Relationship("PROPAGATED_BY")
    Producer producer;


    @PersistenceConstructor
    public IVClone(String name, String cloneId, Nepenthes nepenthes, Location location, Sex sex, Producer producer) {
        super(name,nepenthes,location,sex);
        assert producer != null: "Producer must exist";
        this.cloneId = cloneId;
        this.producer = producer;
    }

    public IVClone() {

    }


    @Override
    IVClone asIVClone() {
        return this;
    }

    @Override
    ICClone asICClone() {
        return new ICClone(name,nepenthes,location,sex);
    }



}
