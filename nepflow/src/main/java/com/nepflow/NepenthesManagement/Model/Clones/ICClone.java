package com.nepflow.NepenthesManagement.Model.Clones;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@NoArgsConstructor

public abstract class ICClone extends Clone {

    @Relationship("SOLD_BY")
    @Getter
    Seller seller;

    public ICClone(Label label, Sex sex, String cloneId, Location location, Seller seller) {
        super(label, sex, cloneId, location);
        this.seller = seller;
    }

    public String getSellerAsString() {
        return this.seller != null ? this.seller.getName() : "";
    }


}
