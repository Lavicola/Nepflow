package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class ICNepenthesClone extends ICClone {

    @Setter
    @Relationship("ORIGIN")
    @Getter
    Location location;


    public ICNepenthesClone( Sex sex, Grex grex,String cloneid) {
        super( sex, grex, cloneid);
    }
}
