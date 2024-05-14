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


    public ICClone(String name, Nepenthes nepenthes, Location location, Sex sex) {
        super(name,nepenthes,location,sex);
        this.nepenthes = nepenthes;
    }

    protected ICClone(String name,String cloneId, Nepenthes nepenthes, Location location, Sex sex) {
        super(name,cloneId,nepenthes,location,sex);
    }

    @Override
    IVClone asIVClone() {
        return new IVClone(name,cloneId,nepenthes,location,sex);
    }

    @Override
    ICClone asICClone() {
        return this;
    }

}
