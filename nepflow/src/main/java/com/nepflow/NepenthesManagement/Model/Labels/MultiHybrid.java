package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICMultiHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVMultiHybrid;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * Model which represents MultiHybrids.
 * E.g. like villosa x (hamata x lowii) or (truncata x villosa) x (hamata x veitchii)
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class MultiHybrid extends HybridLabel {


    /**
     * @param name name of the MultiHybrid
     */
    public MultiHybrid(final String name) {
        super(name);
    }

    /**
     * @param name       name of the MultiHybrid
     * @param labelCount The amount of unique different existing MultiHybrids in the database.
     */
    public MultiHybrid(final String name, final int labelCount) {
        super(name, labelCount);
    }

    /**
     *
     */
    public MultiHybrid() {
        super();
    }

    /**
     * Checks if the MultiHybrid Name is valid.
     *
     * @param name name of the MultiHybrid
     * @return true if valid
     * @throws InvalidLabelFormatException getting thrown if the Naming of the MultiHybrid is Invalid
     */
    @Override
    boolean checkLabelFormat(String name) throws InvalidLabelFormatException {
        String temp = "";
        // substitutionCount must be increased at least 4 times (3 iterations are always guaranteed) by MultiHybrids
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
            name = name.replaceAll("\\(([^()]*\\s+x\\s+[^()]*)\\)", "N");
            substitionCount++;

        }
        temp = "";
        while (!temp.equals(name)) {
            temp = name;
            // NAME x NAME = ""
            name = name.replaceAll("\\w+ x \\w+", "");
            substitionCount++;
        }
        if (name.equals("") && substitionCount > 0) {
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The MultiHybrid Format '%s' is not known", name));
    }


    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created ICMultiHybrid Clone
     */
    @Override
    public ICClone createICClone(final String cloneId, final Sex sex, final Location location, final Seller seller) {
        return new ICMultiHybrid(this, sex, cloneId, location, seller);
    }

    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param producer produder of the clone
     * @return successful created IVMultiHybrid Clone
     */
    @Override
    public IVClone createIVClone(final String cloneId, final Sex sex, final Location location, final Producer producer) {
        return new IVMultiHybrid(this, cloneId, sex, location, producer);
    }

    /**
     * @return a hardcoded String which represents the Prefix for all MultiHybrids.
     */
    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-MH";
    }


    /**
     * Method which breaks down the (valid) Name of a MultiHybrid into its Mother and Father Part.
     */
    @Override
    void setParents() {
        String mother = "";
        String father = "";
        String name = this.getName();
        if (name.charAt(0) == '(') {
            int splitIndex = findClosingBracketIndex(name, 0);
            if (splitIndex != -1) {
                mother = name.substring(1, splitIndex);
                //TODO why 4 again
                father = name.substring(splitIndex + 4);
            }
        } else {
            int splitIndex = findOpeningBracketIndex(name, name.length() - 1);
            if (splitIndex != -1) {
                father = name.substring(splitIndex + 1);
                //TODO why 3 again
                mother = name.substring(0, splitIndex - 3);
            }
        }

        mother = removeSurroundingBrackets(mother);
        father = removeSurroundingBrackets(father);

        this.motherName = mother;
        this.fatherName = father;
    }

    /**
     * Helper method.
     *
     * @param str   name of the MultiHybrid
     * @param start Start index
     * @return index of the closing Bracket, if not found -1
     */
    private int findClosingBracketIndex(final String str, final int start) {
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

    /**
     * Helper method.
     *
     * @param input string
     * @return String without surrounding Brackets
     */
    private String removeSurroundingBrackets(final String input) {
        if (input.length() >= 2 && input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')') {
            return input.substring(1, input.length() - 1);
        }
        return input;
    }

    /**
     * Helper method.
     *
     * @param str   name of the MultiHybrid
     * @param start Start index
     * @return index of the opening Bracket, if not found -1
     */
    private int findOpeningBracketIndex(final String str, final int start) {
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
}
