package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
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
    ICClone father;
    @Relationship(value = "IS_MOTHER", direction = Relationship.Direction.OUTGOING)
    ICClone mother;

    public Grex(ICClone mother, ICClone father, String grexId) {
        assert (father != null);
        assert (mother != null);
        this.mother = mother;
        this.father = father;
        this.grexId = grexId;
    }

    public String getName() {
        return "";
    }

}
