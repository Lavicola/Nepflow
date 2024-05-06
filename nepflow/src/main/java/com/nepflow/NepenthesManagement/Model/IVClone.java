package com.nepflow.NepenthesManagement.Model;

import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Objects;

@Node
public class IVClone extends Clone{
    public IVClone(String cloneId, Nepenthes nepenthes) {
        super(cloneId, nepenthes);
    }

    @Setter
    @Relationship("PROPAGATED_BY")
    Producer producer;

    /*
    public boolean equals(Object o) {
        super.equals(o);
        if (o == this) {
            return true;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        IVClone ivClone = (IVClone) o;

        return Objects.equals(ivClone.cloneId, this.cloneId) && this.nepenthes.equals(ivClone.nepenthes);
    }
*/
}
