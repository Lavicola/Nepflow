package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Property;

/**
 *   A Multihybrid consists of at least three species (including F2 Hybrids)
 *   Note: Hybrid and Multihybrid do share some similarities, but inheritance
 *   would result in another lable for Multi-Hybrid and therefore a bit of Code Duplication
 *   is in Hybrid and Multihybrid
 */

public class MultiHybrid extends Clone {

    @Property
    @Getter
    private String motherName;

    @Property
    @Getter
    private String fatherName;


    protected MultiHybrid(String name, String cloneId) {
        super(name, cloneId);
        assert MultiHybrid.isValidFormat(name) : "Multi-Hybrid Format is wrong";
        setParents(name);

    }

    private void setParents(String name) {
        int braceCount = 0;
        String mother = "";
        String father = "";

        if (name.charAt(0) == '(') {
            for (int i = 0; i <= name.length(); i++) {
                if ('(' == name.charAt(i)) {
                    braceCount++;
                } else if (')' == name.charAt(i)) {
                    braceCount--;
                    if (braceCount == 0) {
                        mother = name.substring(0, i+1);
                        father = name.substring(i + 4);
                        break;
                    }
                }
            }
        } else {
            for (int i = name.length() - 1; i >= 0; i--) {
                char c = name.charAt(i);
                if (c == ')') {
                    braceCount++;
                } else if (c == '(') {
                    braceCount--;
                    if (braceCount == 0) {
                        father = name.substring(i);
                        mother = name.substring(0, i - 3);
                        break;
                    }
                }
            }
        }
        this.motherName = mother.replaceAll("^\\(|\\)$","");
        this.fatherName = father.replaceAll("^\\(|\\)$","");

    }


    protected MultiHybrid(String name, String cloneId, Grex grex) {
        super(name, cloneId);
        this.checkPrecondition(grex);
        this.grex = grex;
        this.motherName = grex.mother.getName();
        this.fatherName = grex.father.getName();
    }

    public void checkPrecondition(Grex grex) {
        assert (grex != null) : "Grex is not allowed to be null";
        assert (grex.father != null) : "Father of Grex is not allowed to be null";
        assert (grex.mother != null) : "Mother of Grex is not allowed to be null";
        assert (grex.father instanceof MultiHybrid || grex.father instanceof Hybrid || grex.father instanceof SpeciesClone) :
                "Father must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (grex.mother instanceof MultiHybrid || grex.mother instanceof Hybrid || grex.mother instanceof SpeciesClone) :
                "Mother must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (!(grex.mother instanceof SpeciesClone && grex.father instanceof SpeciesClone)) :
                "Both parents are not allowed to be species";
        // Since certain clones are actually a pool of clones it is better to allow it, otherwise it is getting too complex for Users
        //assert (!father.equals(mother)): "Father and Mother cant be the same Hybrid";
    }

    private static boolean isValidFormat(String input) {
        String temp = "";
        while (!temp.equals(input)) {
            temp = input;
            // ((NAME x NAME) x NAME) = (NAME x NAME)
            input = input.replaceAll("\\(\\(\\w+ x \\w+\\) x \\w+\\)", "(N x N)");
        }
        temp = "";
        while (!temp.equals(input)) {
            temp = input;
            // (NAME x NAME) = NAME
            input = input.replaceAll("\\(\\w+ x \\w+\\)", "N");
        }
        temp = "";
        while (!temp.equals(input)) {
            temp = input;
            // NAME x NAME = ""
            input = input.replaceAll("\\w+ x \\w+", "");
        }
        return input.equals("");
    }


    @Override
    public String getName() {
        return name;
    }
}
