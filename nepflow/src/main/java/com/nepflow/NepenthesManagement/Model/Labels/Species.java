package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICSpeciesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVSpeciesClone;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.regex.Pattern;

@Node
public class Species extends Label {


    /**
     * @param name       name of the Species
     * @param labelCount The amount of unique different existing Species in the database.
     */
    public Species(final String name, final int labelCount) {
        super(name, labelCount);
    }

    /**
     * @param name name of the Species
     */
    public Species(final String name) {
        super(name);
    }

    /**
     *
     */
    public Species() {
        super();
    }


    /**
     * Checks if the Species Name is valid.
     * Due to the badly naming of these sometimes however, there is no way to actually validate it.
     * e.g. villosa, sp. #1 or even mirabilis var. echinostoma is valid.
     *
     * @param name name of the PrimaryHybrid
     * @return true if valid
     * @throws InvalidLabelFormatException getting thrown if the Naming of the PrimaryHybrid is Invalid
     */
    @Override
    boolean checkLabelFormat(final String name) throws InvalidLabelFormatException {
        // no real way to verify since nepenthes are sometimes very badly named
        if (Pattern.compile("^(?!.*\\bx\\b)[^()]*$").matcher(name).find()) {
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The PrimaryHybrid Format '%s' is not known", name));
    }

    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created ICSpecies Clone
     */
    @Override
    public ICClone createICClone(final String cloneId, final Sex sex, final Location location, final Seller seller) {
        return new ICSpeciesClone(this, sex, cloneId, location, seller);
    }

    /**
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param producer producer of the clone
     * @return successful created ICSpecies Clone
     */
    @Override
    public IVClone createIVClone(final String cloneId, final Sex sex, final Location location, final Producer producer) {
        return new IVSpeciesClone(this, cloneId, sex, location, producer);
    }


    /**
     * @return a hardcoded String which represents the Prefix for all PrimaryHybrids.
     */
    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-N";
    }

}
