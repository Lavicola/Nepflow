package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class ICNepenthesClone extends ICClone<Nepenthes> {

    @Setter
    @Relationship("ORIGIN")
    Location location;


    public ICNepenthesClone(Nepenthes label, Sex sex, Grex grex,String cloneid) {
        super(label, sex, grex, cloneid);
    }
}
