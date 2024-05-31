package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICPrimaryHybrid extends ICClone {
    public ICPrimaryHybrid(Sex sex, Grex grex, String cloneId) {
        super(sex, grex,cloneId );
    }


}
