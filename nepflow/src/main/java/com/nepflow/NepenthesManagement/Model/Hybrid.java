package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Hybrid represent a Nepenthes which has either two different NepenthesSpecies as Parents
 * or a NepenthesSpecies and a Hybrid. Important is just that no more than three species
 * are allowed
 */

public class Hybrid extends Clone {

    @Property
    @Getter
    private String motherName;

    @Property
    @Getter
    private String fatherName;

    protected Hybrid(String name, String cloneId) {
        super(name, cloneId);
        // Since it is not feasible that every hybrid has a Grex we must also accept only Hybrids with no origin
        assert Hybrid.isValidFormat(name) : "Hybrid Format is wrong, must be e.g villosa x hamata";
        setParents(name);
        checkPostcondition();
    }

    protected Hybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId);
        this.checkPreconditionGrex(grex);
        this.grex = grex;
        this.motherName = grex.mother.getName();
        this.fatherName = grex.father.getName();
        checkPostcondition();
    }


    public void checkPreconditionGrex(Grex grex) {
        assert (grex != null) : "Grex is not allowed to be null";
        assert (grex.father != null) : "Father of Grex is not allowed to be null";
        assert (grex.mother != null) : "Mother of Grex is not allowed to be null";
        assert (grex.father instanceof SpeciesClone && grex.mother instanceof SpeciesClone) :
                "A Hybrid may only consists of two different Species";
        // Usually this would be a good assert, but since the big producers often use a Product Code for a pool of Clones it is easier to simply allow this
        // another approach would be to abstract Clone and Pool, but this is too complex/work for the User with little to no benefit
        //assert (!father.equals(mother)): "Father and Mother can´t be the same plant";
    }


    @Transient
    // The Format MUST be NAME x NAME
    static Pattern pattern = Pattern.compile("(\\w+ x \\w+)");

    public static boolean isValidFormat(String hybrid) {
        Matcher matcher = pattern.matcher(hybrid);
        return matcher.matches();
    }

    @Transient
    public void checkPostcondition() {
        // A Hybrid is only valid if both parents exist
        assert Clone.validPlants.contains(this.motherName) : String.format("Mother Nepenthes (%s) does not exist", this.motherName);
        assert Clone.validPlants.contains(this.fatherName) : String.format("Father Nepenthes (%s) does not exist", this.fatherName);
    }

    @Transient
    private void setParents(String name) {
        String[] motherFather = name.split(" x ");
        this.motherName = motherFather[0];
        this.fatherName = motherFather[1];
    }


    @Override
    public String getName() {
        return this.name;
        /* This could be used if Grex is not null
        String hybridFormat = "%s x %s";
        Clone mother = this.grex.father;
        Clone father = this.grex.mother;

        if (mother instanceof Hybrid) {
            hybridFormat = "%s x (%s)";
        } else if (father instanceof Hybrid) {
            hybridFormat = "(%s) x %s";
        }
        return String.format(hybridFormat, mother.getName(), father.getName());
        */
    }
}
