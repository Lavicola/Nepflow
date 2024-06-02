package com.nepflow.NepenthesManagement.Model.Clones;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public abstract class ICClone extends Clone {

    @Relationship("SOLD_BY")
    @Getter
    Seller seller;


    public ICClone(Sex sex, Grex grex, String cloneId,Location location,Seller seller) {
        super(sex, grex, cloneId,location);
        this.seller = seller;

    }

}
