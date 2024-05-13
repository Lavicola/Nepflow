package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Objects;


/**
 * An ICClone is a clone which is Unique and does not get propagated by a Laboratory
 *
 */


@Node
public class ICClone extends SpeciesClone {


    public ICClone(String name,String cloneId, Nepenthes nepenthes) {
        super(name,cloneId, nepenthes);
        this.cloneId = cloneId;
        this.nepenthes = nepenthes;
    }

    @Override
    IVClone asIVClone() {
        return new IVClone(this.name,this.cloneId, this.nepenthes);
    }

    @Override
    ICClone asICClone() {
        return this;
    }

}
