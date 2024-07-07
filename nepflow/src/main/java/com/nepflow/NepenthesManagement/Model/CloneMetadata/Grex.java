package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Grex {

    @Id
    private String grexId;


    @Version
    private Long version;

    @Relationship(value = "IS_FATHER", direction = Relationship.Direction.OUTGOING)
    Clone father;
    @Relationship(value = "IS_MOTHER", direction = Relationship.Direction.OUTGOING)
    Clone mother;

    public Grex(Clone mother, Clone father, String grexId) {
        assert (father != null);
        assert (mother != null);
        this.mother = mother;
        this.father = father;
        this.grexId = grexId;
    }


    public boolean setFather(Clone father){
        if(father != null && this.father.getCloneId().equals("unkown")){
            this.father = father;
            return true;
        }else {
            return false;
        }
    }

    public boolean setMother(Clone mother){
        if(mother != null && this.mother.getCloneId().equals("unkown")){
            this.mother = mother;
            return true;
        }else{
            return false;
        }
    }

    public String getName() {
        return "";
    }

}
