package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@NoArgsConstructor
public class ICSpeciesClone extends ICClone {


    public ICSpeciesClone(Label label, Sex sex, String cloneId, Location location, Seller seller) {
        super(label,sex, cloneId,location,seller);
    }

}
