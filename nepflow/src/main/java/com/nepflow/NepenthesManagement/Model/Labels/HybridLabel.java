package com.nepflow.NepenthesManagement.Model.Labels;


import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * This Class represents the Base Class of the different types of Hybrids.
 * All of them share a common logic and therefore this Abstract Class defines the common Logic
 */
@Node
public abstract class HybridLabel extends Label {

    @Property
    @Getter
    protected String motherName;

    @Property
    @Getter
    protected String fatherName;
    static String HYBRID_SEPARATOR = " x ";

    public HybridLabel(String name,int labelCount) {
        super(name,labelCount);
        this.setParents();
    }
    public HybridLabel(String name) {
        super(name);
        this.setParents();
    }

    public HybridLabel() {

    }

    abstract void setParents();


}
