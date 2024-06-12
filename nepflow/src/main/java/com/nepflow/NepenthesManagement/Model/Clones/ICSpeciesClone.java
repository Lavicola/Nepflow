package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class ICSpeciesClone extends ICClone {

    @Setter
    @Relationship("ORIGIN")
    @Getter
    Location location;

    public ICSpeciesClone(Sex sex, Grex grex, String cloneId, Location location, Seller seller) {
        super( sex, grex,cloneId,location,seller );
    }

}