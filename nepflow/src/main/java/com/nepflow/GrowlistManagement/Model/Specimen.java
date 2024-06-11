package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Specimen {




    @Id
    @GeneratedValue
    protected String uuid;

    // localName allows user to set a name to distinguish easier same clones
    String localName;

    @Relationship(value = "INSTANCE_OF",direction = Relationship.Direction.OUTGOING)
    Clone clone;

    RelationshipValue relationshipValue;

    public Specimen(Clone clone){
        this.clone = clone;
        this.relationshipValue  = new RelationshipValue(clone);
    }

    public Specimen(Clone clone,String localName){
        this(clone);
        this.localName = localName;


    }


}
