package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@NoArgsConstructor
public class IVSpeciesClone extends IVClone {

    public IVSpeciesClone(Label label, String cloneId, Sex sex, Location location, Producer producer) {
        super(label,cloneId,sex,location,producer);
    }


}
