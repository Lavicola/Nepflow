package com.nepflow.NepenthesManagement.Model;

import lombok.Data;
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

    SpeciesClone(String name, Nepenthes nepenthes, Location location, Sex sex) {
        assert nepenthes != null : "Nepenthes is not allowed to be null!";
        this.name = name;
        this.nepenthes = nepenthes;
        this.location = location;
        this.sex = sex;
    }

    public SpeciesClone() {
        super();
    }


    @Override
    public String getName() {
        return this.nepenthes.getName();
    }


    public SpeciesClone createNewClones(String name, String cloneId, Nepenthes nepenthes, Location location, Sex sex, Producer producer) {
        if (producer != null) {
            return new IVClone(name, cloneId, nepenthes, location, sex, producer);
        } else {
            return new ICClone(name, nepenthes, location, sex);
        }
    }

    public IVClone createNewIVClone(String name, String cloneId, Nepenthes nepenthes, Location location, Sex sex, Producer producer) {
        return new IVClone(name, cloneId, nepenthes, location, sex, producer);
    }

    public ICClone createNewICClone(String name, Nepenthes nepenthes, Location location, Sex sex) {
        return new ICClone(name, nepenthes, location, sex);
    }

    abstract IVClone asIVClone();

    abstract ICClone asICClone();

}
