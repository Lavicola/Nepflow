package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IVNepenthesClone extends IVClone<Nepenthes> {






    public IVNepenthesClone(Nepenthes label, String cloneId, Sex sex, Grex grex, Producer producer, Location location) {
        super(label, cloneId, sex, grex, producer);
        this.location = location;
    }


}
