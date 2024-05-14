package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * A Multi-hybrid consists of at least three species (F2 Hybrids are also multi hybrids)
 * Note: Hybrid and Multi-hybrid do share some similarities, but inheritance
 * would result in another label for Multi-Hybrid which makes filtering for hybrids harder.
 * Therefore, a bit of Code Duplication is used here
 */
@Node
public class MultiHybridClone extends Clone{
    @Property
    @Getter
    protected String motherName;

    @Property
    @Getter
    protected String fatherName;

    protected MultiHybridClone(String name, String cloneId, Grex grex) {
        super(name, cloneId, grex);
        this.checkPrecondition(grex);
        this.grex = grex;
        this.motherName = grex.mother.getName();
        this.fatherName = grex.father.getName();

    }

    protected MultiHybridClone(String name, String cloneId) {
        super(name, cloneId);
        assert MultiHybridClone.isValidFormat(name) : "Multi-Hybrid Format is wrong";
        setParents(name);

    }


    protected void setParents(String name) {
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

    protected void checkPrecondition(Grex grex) {
        assert (grex != null) : "Grex is not allowed to be null";
        assert (grex.father != null) : "Father of Grex is not allowed to be null";
        assert (grex.mother != null) : "Mother of Grex is not allowed to be null";
        assert (grex.father instanceof ICMultiHybrid || grex.father instanceof ICHybrid || grex.father instanceof SpeciesClone) :
                "Father must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (grex.mother instanceof ICMultiHybrid || grex.mother instanceof ICHybrid || grex.mother instanceof SpeciesClone) :
                "Mother must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (!(grex.mother instanceof SpeciesClone && grex.father instanceof SpeciesClone)) :
                "Both parents are not allowed to be species";
        // Since certain clones are actually a pool of clones it is better to allow it, otherwise it is getting too complex for Users
        //assert (!father.equals(mother)): "Father and Mother cant be the same Hybrid";
    }

    protected static boolean isValidFormat(String input) {
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


}
