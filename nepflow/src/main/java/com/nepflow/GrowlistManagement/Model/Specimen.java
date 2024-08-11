package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

@Node
@NoArgsConstructor
public class Specimen {


    @Id
    @Getter
    @GeneratedValue
    protected String uuid;

    @Relationship(value = "INSTANCE_OF", direction = Relationship.Direction.OUTGOING)
    @Getter
    Clone clone;

    @Relationship(value = "GROWS_BY", direction = Relationship.Direction.OUTGOING)
    @Getter
    User user;

    @Getter
    @Setter
    String imagePath;

    @Property
    @Getter
    boolean isFlowering = false;


    public Specimen(Clone clone,User user) {
        if(clone  ==  null){
            throw new RuntimeException("Clone is not allowd to  be  null");
        }
        if(user ==  null){
            throw new RuntimeException("User is not allowd to  be  null");
        }
        this.clone = clone;
        this.user = user;
        this.isFlowering = false;
    }

    public String getSellerAsString(){
        return this.clone.getSellerAsString();
    }

    public String getLocationAsString(){
        return this.clone.getLocationAsString();
    }

    public String getSexAsString(){
        return this.clone.getSexAsString();
    }

    public String getNepenthesname(){
        return this.clone.getLabelName();
    }


    public String getCultivarName(){
        return this.clone.getCultivarName();
    }


    public void setClone(Clone clone){
        this.clone = clone;
    }

    public boolean getFlowerStatus(){
        return this.isFlowering;
    }

    public void setFlowerStatus(boolean isFlowering){
        this.isFlowering = isFlowering;
    }


    public boolean isSpecimenOwner(User user){
        return this.user.equals(user);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return this.uuid.equals(((Specimen) obj).uuid);

    }


}
