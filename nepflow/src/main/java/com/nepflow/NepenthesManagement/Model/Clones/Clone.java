package com.nepflow.NepenthesManagement.Model.Clones;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@NoArgsConstructor
public abstract class Clone {

    @Relationship(value = "CLONE_OF_SPECIES",direction = Relationship.Direction.OUTGOING)
    @Getter
    Label label;


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
    @Getter
    @Relationship("HAS_SEX")
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

    public Clone(Label label, Sex sex, String cloneId, Location location){
        this.label = label;
        this.sex = sex;
        this.cloneId = cloneId;
        this.internalCloneId = Clone.generateInternalCloneId(cloneId,sex);
        this.location = location;
    }

    // usually a cultivar is named later and not right after registering it, therefore a setter makes more sense
    public void setCultivarName(String cultivarName){
        this.cultivarName = cultivarName;
    }

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

    public String getLabelName(){return this.label != null ? this.label.getName():"";}

    abstract public String getSellerAsString();

    public static String generateInternalCloneId(String cloneId,Sex sex){
        if(sex != null){
            return String.format("%s-%s",cloneId,sex.getSexAsString().substring(0,1));
        }else{
            return cloneId;
        }
    }


    @Override
    public int hashCode() {
        return 5;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return ((Clone) obj).internalCloneId.equals(this.internalCloneId);

    }



}
