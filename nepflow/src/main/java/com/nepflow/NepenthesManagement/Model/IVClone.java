package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Objects;

/**
 * An IVClone is a clone which is propagated in a Laboratory
 * Certain IVClone represent a Pool of Clones and not one individual Clone
 */

@Node
public class IVClone extends SpeciesClone {

    @Setter
    @Relationship("PROPAGATED_BY")
    Producer producer;



    public IVClone(String name,String cloneId, Nepenthes nepenthes, Location location, Sex sex) {
        super(name,cloneId, nepenthes,location,sex);
        assert producer != null: "IV Clone without Producer makes no sense";
        this.producer = producer;
    }

    @Override
    IVClone asIVClone() {
        return this;
    }

    @Override
    ICClone asICClone() {
        return new ICClone(name,cloneId,nepenthes,location,sex);
    }


}
