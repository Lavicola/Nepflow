package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Hybrid;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class IVHybrid extends IVClone<Hybrid> {

    public IVHybrid(Hybrid label, String cloneId, Sex sex, Grex grex, Producer producer) {
        super(label, cloneId, sex, grex,producer);
    }
}
