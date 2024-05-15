package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.neo4j.core.schema.Node;


/**
 * An ICClone is a clone which is Unique and does not get propagated by a Laboratory
 *
 */


@Node
public class ICClone extends SpeciesClone {


    public ICClone(){
        super();
    }


    protected ICClone(String name, Nepenthes nepenthes, Location location, Sex sex) {
        super(name,nepenthes,location,sex);
    }


    @Override
    IVClone asIVClone() {
        return new IVClone(name,cloneId,nepenthes,location,sex,null);
    }

    @Override
    ICClone asICClone() {
        return this;
    }

}
