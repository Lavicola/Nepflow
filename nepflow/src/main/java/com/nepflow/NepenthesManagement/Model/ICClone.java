package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Node;

import java.util.Objects;

@Node
public class ICClone extends Clone{
    public ICClone(String cloneId, Nepenthes nepenthes) {
        super(cloneId, nepenthes);
    }

/*
    public boolean equals(Object o) {
        super.equals(o);
        if (o == this) {
            return true;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        ICClone ICClone = (ICClone) o;

        return Objects.equals(ICClone.cloneId, this.cloneId) && this.nepenthes.equals(ICClone.nepenthes);
    }

*/


}
