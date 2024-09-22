package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICPrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVPrimaryHybrid;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.regex.Pattern;

/**
 * Model which represents PrimaryHybrid.
 * E.g. like villosa, hamata or lowii
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
public class PrimaryHybrid extends HybridLabel {


    /**
     * @param name       name of the PrimaryHybrid
     * @param labelCount The amount of unique different existing PrimaryHybrid in the database.
     */
    public PrimaryHybrid(final String name, final int labelCount) {
        super(name, labelCount);
    }

    /**
     * @param name name of the PrimaryHybrid
     */
    public PrimaryHybrid(final String name) {
        super(name);
        this.setParents();
    }

    /**
     *
     */
    public PrimaryHybrid() {
        super();
    }

    /**
     * Checks if the PrimaryHybrid Name is valid.
     *
     * @param name name of the PrimaryHybrid
     * @return true if valid
     * @throws InvalidLabelFormatException getting thrown if the Naming of the PrimaryHybrid is Invalid
     */
    @Override
    boolean checkLabelFormat(final String name) throws InvalidLabelFormatException {
        // must be (NAME x NAME)
        if (Pattern.compile("^\\(\\w+ x (\\w+| )+\\)$").matcher(name).find()) {
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The PrimaryHybrid Format '%s' is not known", name));
    }


    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created ICPrimaryHybrid Clone
     */
    @Override
    public ICClone createICClone(final String cloneId, final Sex sex, final Location location, final Seller seller) {
        return new ICPrimaryHybrid(this, sex, cloneId, location, seller);
    }

    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param producer seller of the clone
     * @return successful created IVPrimaryHybrid Clone
     */
    @Override
    public IVClone createIVClone(final String cloneId, final Sex sex, final Location location, final Producer producer) {
        return new IVPrimaryHybrid(this, cloneId, sex, location, producer);
    }


    /**
     * @return a hardcoded String which represents the Prefix for all PrimaryHybrids.
     */
    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-H";
    }


    /**
     * Method which breaks down the (valid) Name of a PrimaryHybrid into its Mother and Father Part.
     */
    @Override
    void setParents() {
        String name = this.getName();

        String[] motherFather = name.substring(1, name.length() - 1).split(HYBRID_SEPARATOR);
        this.motherName = motherFather[0];
        this.fatherName = motherFather[1];
    }

}
