package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class ICMultiHybrid extends ICClone {
    public ICMultiHybrid(Sex sex, Grex grex, String cloneId, Location location, Seller seller) {
        super(sex, grex, cloneId,location,seller);
    }
}
