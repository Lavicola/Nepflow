package com.nepflow.NepenthesManagement.Model.Clones;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public abstract class IVClone<L extends Label> extends Clone<L> {

    @Relationship("PROPAGATED_BY")
    Producer producer;

    public IVClone(L label, String cloneId, Sex sex, Grex grex, Producer producer) {
        super(label, sex, grex,cloneId );
        assert producer != null : "IV Clone where Producer is null makes no sense";
        assert !cloneId.equals(""): "iV Clone must have an ID";
        if(sex != null){
            this.internalCloneId = IVClone.generateInternalCloneId(cloneId,sex);
        }
        this.producer = producer;

    }

    public static String generateInternalCloneId(String cloneId,Sex sex){
        if(sex != null){
            return String.format("%s-%s",cloneId,sex.getSexAsString().substring(0,1));
        }else{
            return cloneId;
        }
    }


}

