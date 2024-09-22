package com.nepflow.NepenthesManagement.Model.Labels;


import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;


/**
 * Model which abstract the different types of Hybrid types like MultiHybrid or PrimaryHybrid.
 * The Abstraction therefore defines methods every subtypes needs to be a valid type of Hybrid
 * While also providing a subgraph for Hybrids for more efficient querying.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public abstract class HybridLabel extends Label {

    /**
     *
     */
    @Property
    @Getter
    protected String motherName;

    /**
     *
     */
    @Property
    @Getter
    protected String fatherName;
    /**
     * A Hybrid is always seperated by an x.
     */
    static String HYBRID_SEPARATOR = " x ";

    /**
     * @param name       name of the Nepenthes Hybrid
     * @param labelCount The amount of unique different existing Hybrids in the database.
     */
    public HybridLabel(final String name, final int labelCount) {
        super(name, labelCount);
        this.setParents();
    }

    /**
     * @param name name of the Nepenthes Hybrid
     */
    public HybridLabel(final String name) {
        super(name);
        this.setParents();
    }

    /**
     *
     */
    public HybridLabel() {

    }

    /**
     *
     */
    abstract void setParents();


}
