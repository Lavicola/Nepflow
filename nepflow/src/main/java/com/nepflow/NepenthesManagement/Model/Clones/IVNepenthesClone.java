package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class IVNepenthesClone extends IVClone {

    @Setter
    @Relationship("ORIGIN")
    @Getter
    Location location;
    public IVNepenthesClone(String cloneId, Sex sex, Grex grex, Producer producer, Location location) {
        super(cloneId, sex, grex, producer);
        this.location = location;
    }




}
