package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
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

    @Getter
    @Setter
    String imagePath;

    @Property
    boolean isFlowering = false;

    public Specimen(Clone clone) {
        this.clone = clone;
        this.isFlowering = false;
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
        return this.uuid.equals(((Specimen) obj).uuid) && this.getClone().equals(((Specimen) obj).getClone());

    }


}
