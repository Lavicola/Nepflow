package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Relationship;


/**
 * A SpeciesClone is a Clone which belongs to a specific Nepenthes(species)
 * Compared to Hybrids or a Multi-hybrids
 */


public abstract class SpeciesClone extends Clone {

    @Relationship(value = "SPECIES_OF", direction = Relationship.Direction.OUTGOING)
    @Getter
    Nepenthes nepenthes;

    @Setter
    @Relationship("ORIGIN")
    Location location;

    protected SpeciesClone(String name,String cloneId,Nepenthes nepenthes) {
        super(name,cloneId);
        this.nepenthes = nepenthes;
    }


    protected SpeciesClone(String name, String cloneId, Nepenthes nepenthes, Location location, Sex sex) {
        super(name,cloneId);
        this.nepenthes = nepenthes;
        this.location = location;
        this.sex = sex;
    }
    protected SpeciesClone(String name, Nepenthes nepenthes, Location location, Sex sex) {
        super(name);
        this.nepenthes = nepenthes;
        this.location = location;
        this.sex = sex;
    }

    @Override
    public String getName() {
        return this.nepenthes.getName();
    }

    // Since they are similar and differ in just some relationships like Producer we can ease the program flow this way
    abstract IVClone asIVClone();
    abstract ICClone asICClone();

}
