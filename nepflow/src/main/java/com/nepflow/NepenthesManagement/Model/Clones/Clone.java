package com.nepflow.NepenthesManagement.Model.Clones;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public abstract class Clone {

    // usually a species or hybrid can be registered as a cultivar. For some reason, special in this Hobby, people really like to give their nepenthes nicknames instead of registering them.
    // in order to allow both a nickname can be set.
    @Property
    @Getter
    String nickname;


    @Id
    @Getter
    // for now internal ID is only used for IV Clones where an IV Clone consists of a pool of Clones
    // The first Letter of the Sex is added in order to different between them
    protected String internalCloneId;


    @Property
    protected String cloneId;

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
    @Getter
    @Relationship("ORIGIN")
    Location location;

    public Clone(Sex sex, Grex grex, String cloneId,Location location){
        this.sex = sex;
        this.grex = grex;
        this.cloneId = cloneId;
        this.internalCloneId = cloneId;
        this.location = location;
    }




    public  String getCloneId() {
        return cloneId;
    }


}
