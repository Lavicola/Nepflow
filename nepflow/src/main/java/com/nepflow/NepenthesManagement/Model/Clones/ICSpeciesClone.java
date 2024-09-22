package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * Model which represents a unique Species ouf of a seed which is not propagated in IV.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class ICSpeciesClone extends ICClone {


    /**
     * @param label    the label(or more specific species/hybrid) a clone will reference
     * @param sex      the Sex of a Clone
     * @param cloneId  the id of a clone
     * @param location the origin of the clone
     * @param seller   seller of the clone
     */
    public ICSpeciesClone(final Label label, final Sex sex, final String cloneId, final Location location, final Seller seller) {
        super(label, sex, cloneId, location, seller);
    }

}
