package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Exception.CloneIdNotProvidedException;
import com.nepflow.NepenthesManagement.Exception.ProducerIsNullException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@NoArgsConstructor
public abstract class IVClone extends Clone {

    @Relationship("SOLD_BY")
    @Getter
    Producer producer;


    public IVClone(Label label, String cloneId, Sex sex, Location location, Producer producer) {
        super(label,sex, cloneId,location);
        if(producer == null){
            throw new ProducerIsNullException(cloneId);
        }
        if(cloneId.equals("") || cloneId == null){
            throw new CloneIdNotProvidedException();
        }
        this.producer = producer;

    }



    public String getSellerAsString(){
        return this.producer != null ? this.producer.getName():"";
    }




}

