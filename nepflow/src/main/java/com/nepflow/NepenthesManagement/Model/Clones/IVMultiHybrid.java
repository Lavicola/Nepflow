package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class IVMultiHybrid extends IVClone {


    public IVMultiHybrid( String cloneId, Sex sex, Grex grex,Location location, Producer producer) {
        super( cloneId, sex, grex,location,producer);
    }




}
