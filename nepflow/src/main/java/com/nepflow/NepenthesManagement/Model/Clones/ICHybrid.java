package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICHybrid extends ICClone<PrimaryHybrid> {
    public ICHybrid(PrimaryHybrid label, Sex sex, Grex grex, String cloneId) {
        super(label, sex, grex,cloneId );
    }


}
