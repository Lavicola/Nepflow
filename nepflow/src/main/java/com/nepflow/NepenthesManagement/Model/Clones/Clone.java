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
    // Internal Id is:
    // for Seedgrown always the same as cloneId
    // for IV: combination of cloneId and first letter of Sex since IV clones are sometimes a Pool of plants
    protected String internalCloneId;

    protected String cultivarName;

    @Property
    protected String cloneId;

    @Setter
    @Relationship("HAS_SEX")
    protected Sex sex;

    @Relationship(value = "OFFSPRING_FROM", direction = Relationship.Direction.OUTGOING)
    @Getter
    protected Grex grex;

    @Version
    private Long version;

    @Setter
    @Relationship("ORIGIN")
    Location location;

    public Clone(Sex sex, String cloneId,Location location){
        this.sex = sex;
        this.cloneId = cloneId;
        this.internalCloneId = cloneId;
        this.location = location;
    }

    // usually a cultivar is named later and not right after registering it, therefore a setter makes more sense
    public void setCultivarName(String cultivarName){
        this.cultivarName = cultivarName;
    }

    public void setVersion(long version){this.version = version;}

    public void setGrex(Grex grex){
        this.grex =grex;
    }

    public  String getCloneId() {
        return cloneId;
    }

    public String getLocationAsString(){
        return this.location != null ? this.location.getName():"";
    }

    public String getSexAsString(){
        return this.sex != null ? this.sex.getSexAsString():"";
    }

    abstract public String getSellerAsString();



}
