package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICMultiHybrid extends ICClone<MultiHybrid> {
    public ICMultiHybrid(MultiHybrid label, Sex sex, Grex grex,String cloneId) {
        super(label, sex, grex,cloneId );
    }
}
