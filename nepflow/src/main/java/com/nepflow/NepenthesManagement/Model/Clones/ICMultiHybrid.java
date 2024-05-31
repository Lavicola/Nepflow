package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICMultiHybrid extends ICClone {
    public ICMultiHybrid(Sex sex, Grex grex,String cloneId) {
        super( sex, grex,cloneId );
    }
}
