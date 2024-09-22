package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Exception.CloneIdNotProvidedException;
import com.nepflow.NepenthesManagement.Exception.ProducerIsNullException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Model which abstracts IV Clone ouf of a seed which is propagated in IV.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public abstract class IVClone extends Clone {

    /**
     *
     */
    @Relationship("SOLD_BY")
    @Getter
    private Producer producer;


    /**
     * @param label    the label(or more specific species/hybrid) a clone will reference
     * @param sex      the Sex of a Clone
     * @param cloneId  the id of a clone
     * @param location the origin of the clone
     * @param producer producer(normally a IV Lab) of the clone
     */
    public IVClone(final Label label, final String cloneId, final Sex sex, final Location location, final Producer producer) {
        super(label, sex, cloneId, location);
        if (producer == null) {
            throw new ProducerIsNullException(cloneId);
        }
        if (cloneId.equals("") || cloneId == null) {
            throw new CloneIdNotProvidedException();
        }
        this.producer = producer;

    }


    /**
     * @return seller as String
     */
    public String getSellerAsString() {
        return this.producer != null ? this.producer.getName() : "";
    }


}

