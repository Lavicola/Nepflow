package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * Model which represents a MultiHybrid ouf of a seed which is propagated in IV.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class IVMultiHybrid extends IVClone {


    /**
     * @param label    the label(or more specific species/hybrid) a clone will reference
     * @param sex      the Sex of a Clone
     * @param cloneId  the id of a clone
     * @param location the origin of the clone
     * @param producer producer(normally a IV Lab) of the clone
     */
    public IVMultiHybrid(final Label label, final String cloneId, final Sex sex, final Location location, final Producer producer) {
        super(label, cloneId, sex, location, producer);
    }


}
