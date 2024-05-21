package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class MultiHybrid extends HybridLabel{


    public MultiHybrid(String name,int labelCount) {
        super(name,labelCount);
    }
    public MultiHybrid(String name) {
        super(name);
    }

    @Override
    boolean isValidLabelName(String name) {
        return true;
    }

    @Override
    boolean checkLabelFormat(String name) {
        String temp = "";
        // substitutionCount must be increased at least 4 times (3 iterations are always guranteed9
        int substitionCount = -4;
        while (!temp.equals(name)) {
            temp = name;
            // ((NAME x NAME) x NAME) = (NAME x NAME)
            name = name.replaceAll("\\(\\([a-zA-Z]+ x [a-zA-Z]+\\) x [a-zA-Z]+\\)", "(N x N)");
            substitionCount++;
        }
        temp = "";
        while (!temp.equals(name)) {
            temp = name;
            // (NAME x NAME) = NAME
            name = name.replaceAll("\\([a-zA-Z]+ x [a-zA-Z]+\\)", "N");
            substitionCount++;

        }
        temp = "";
        while (!temp.equals(name)) {
            temp = name;
            // NAME x NAME = ""
            name = name.replaceAll("[a-zA-Z]+ x [a-zA-Z]+", "");
            substitionCount++;
        }
        return name.equals("") && substitionCount > 0;
    }

    @Override
    public IVClone addIVClone(String cloneId, Sex sex, Grex grex, Producer producer) {
        return null;
    }


    @Override
    public ICClone addICClone(Sex sex, Grex grex) {
        return null;
    }

    @Override
    protected String getLabelIdentifier() {
        return "MH";
    }


    @Override
    void setParents() {
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
                        // the first bracket belongs to the whole
                        mother = name.substring(1, i);
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
                        father = name.substring(i+1);
                        mother = name.substring(0, i - 3);
                        break;
                    }
                }
            }
        }
        this.motherName = mother;
        this.fatherName = father;

    }
}
