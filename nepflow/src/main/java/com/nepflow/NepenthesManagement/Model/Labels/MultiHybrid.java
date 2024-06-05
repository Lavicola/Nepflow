package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICMultiHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVMultiHybrid;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.HashSet;
import java.util.Set;

@Node
public class MultiHybrid extends HybridLabel{

    // Certain MultiHybrids are known under a specific name and not under the actual MultiHybrids name
    @Transient
    public static Set<String> knownMultiHybrids = new HashSet<>();

    public MultiHybrid(String name) {
        super(name);
    }

    public MultiHybrid(String name,int labelCount) {
        super(name,labelCount);
    }


    @Override
    boolean checkLabelFormat(String name) throws InvalidLabelFormatException {
        String temp = "";
        // substitutionCount must be increased at least 4 times (3 iterations are always guranteed9
        int substitionCount = -4;
        while (!temp.equals(name)) {
            temp = name;
            // ((NAME x NAME) x NAME) = (NAME x NAME)
            name = name.replaceAll("\\(\\(\\w+ x \\w+\\) x \\w+\\)", "(N x N)");
            substitionCount++;
        }
        temp = "";
        while (!temp.equals(name)) {
            temp = name;
            // (NAME x NAME) = NAME
            name = name.replaceAll("\\(\\w+ x \\w+\\)", "N");
            substitionCount++;

        }
        temp = "";
        while (!temp.equals(name)) {
            temp = name;
            // NAME x NAME = ""
            name = name.replaceAll("\\w+ x \\w+", "");
            substitionCount++;
        }
        if(name.equals("") && substitionCount > 0){
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The MultiHybrid Format '%s' is not known",name));
    }


    @Override
    public ICClone createICClone(String cloneId, Sex sex, Location location, Grex grex, Seller seller) {
        return new ICMultiHybrid(sex,grex,cloneId,location,seller);
    }

    @Override
    public IVClone createIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer) {
        return new IVMultiHybrid(cloneId,sex,grex,location,producer);
    }

    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-MH";
    }


    @Override

    void setParents() {
        String mother = "";
        String father = "";
        if (name.charAt(0) == '(') {
            int splitIndex = findClosingBracketIndex(name, 0);
            if (splitIndex != -1) {
                mother = name.substring(1, splitIndex);
                father = name.substring(splitIndex + 4);
            }
        } else {
            int splitIndex = findOpeningBracketIndex(name, name.length() - 1);
            if (splitIndex != -1) {
                father = name.substring(splitIndex + 1);
                mother = name.substring(0, splitIndex - 3);
            }
        }

        mother = removeSurroundingBrackets(mother);
        father = removeSurroundingBrackets(father);

        this.motherName = mother;
        this.fatherName = father;
    }

    private int findClosingBracketIndex(String str, int start) {
        int braceCount = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                braceCount++;
            } else if (str.charAt(i) == ')') {
                braceCount--;
                if (braceCount == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findOpeningBracketIndex(String str, int start) {
        int braceCount = 0;
        for (int i = start; i >= 0; i--) {
            if (str.charAt(i) == ')') {
                braceCount++;
            } else if (str.charAt(i) == '(') {
                braceCount--;
                if (braceCount == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private String removeSurroundingBrackets(String input) {
        if (input.length() >= 2 && input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') {
            return input.substring(1, input.length() - 1);
        }
        return input;
    }
}
