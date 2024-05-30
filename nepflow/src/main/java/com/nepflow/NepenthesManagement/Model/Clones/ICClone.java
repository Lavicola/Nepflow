package com.nepflow.NepenthesManagement.Model.Clones;


import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public abstract class ICClone<L extends Label> {


    @Id
    @Getter
    // for now internal ID is only used for IV Clones where an IV Clone consists of a pool of Clones
    // The first Letter of the Sex is added in order to different between them
    protected String internalCloneId;


    @Property
    protected String cloneId;


    @Getter
    @Relationship(value = "SPECIES_OF",direction = Relationship.Direction.OUTGOING)
    protected L label;


    @Setter
    @Relationship("HAS_SEX")
    @Getter
    protected Sex sex;

    @Relationship(value = "OFFSPRING_FROM", direction = Relationship.Direction.OUTGOING)
    @Getter
    protected Grex grex;

    @Version
    private Long version;

    @Setter
    @Relationship("ORIGIN")
    Location location;
    public ICClone(L label, Sex sex, Grex grex, String cloneId){
        this.label = label;
        this.sex = sex;
        this.grex = grex;
        this.cloneId = cloneId;
        this.internalCloneId = cloneId;
    }

    public  String getCloneId() {
        return cloneId;
    }

}
