package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Node
public class Specimen {




    @Id
    @GeneratedValue
    protected String uuid;

    @Relationship(value = "INSTANCE_OF",direction = Relationship.Direction.OUTGOING)
    @Getter
    Clone clone;

    @Version
    private Long version;

    public Specimen(Clone clone){
        this.clone = clone;
    }


    public void setVersion(long version){
        this.version = version;
    }


}
