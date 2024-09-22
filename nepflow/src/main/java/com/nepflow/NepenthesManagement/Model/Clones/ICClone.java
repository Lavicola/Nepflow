package com.nepflow.NepenthesManagement.Model.Clones;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Model which abstracts a unique Clone ouf of a seed which is not propagated in IV.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Node
@NoArgsConstructor

public abstract class ICClone extends Clone {

    /**
     *
     */
    @Relationship("SOLD_BY")
    @Getter
    private Seller seller;

    /**
     * @param label    the label(or more specific species/hybrid) a clone will reference
     * @param sex      the Sex of a Clone
     * @param cloneId  the id of a clone
     * @param location the origin of the clone
     * @param seller   seller of the clone
     */
    public ICClone(final Label label, final Sex sex, final String cloneId, final Location location, final Seller seller) {
        super(label, sex, cloneId, location);
        this.seller = seller;
    }

    /**
     * @return seller as a String
     */
    public String getSellerAsString() {
        return this.seller != null ? this.seller.getName() : "";
    }

    /**
     * ICClones can use the cloneId as internalCloneId, because ICClones are always truly unique
     * and never refer to a batch of "seeds" like in IV.
     *
     * @param cloneId clone Id
     * @param sex     sex
     * @return internal Clone Id
     */
    public static String generateInternalCloneId(final String cloneId, final Sex sex) {
        return cloneId;
    }

}
