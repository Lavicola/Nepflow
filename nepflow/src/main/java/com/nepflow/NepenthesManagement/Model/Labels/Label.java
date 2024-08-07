package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This Abstract Class represents the abstraction needed for the different types of subclasses of
 * Nepenthes(the species itself), hybrid (two Nepenthe's crossbreed), multi hybrids(more than three hybrids)
 */


@Node
public abstract class Label {


    @Id
    @Getter String name;


    @Relationship(value = "HAS_CLONE",direction = Relationship.Direction.OUTGOING)
    List<ICClone> cloneIcList;

    @Relationship(value = "HAS_CLONE",direction = Relationship.Direction.OUTGOING)
    List<IVClone> cloneIvList;


    public void setPrefixIfEmpty(int labelCount) {
        if(prefix == null){
            this.prefix = String.format("%s-%d",this.getLabelIdentifier(),labelCount);
        }
    }

    @Property
    @Getter
    String prefix;

    @Version
    private Long version;


    /**
     *
     * @param name Name of the Nepenthes/Hybrid etc.
     * @param labelCount The current amount of Labels of the specific Subclass
     */
    public Label(String name,int labelCount) throws InvalidLabelFormatException{
        this(name);
        this.prefix = String.format("%s-%d",this.getLabelIdentifier(),labelCount);
    }
    public Label(String name) throws InvalidLabelFormatException {
        checkLabelFormat(name);
        this.name = name;
        this.cloneIcList = new ArrayList<>();
        this.cloneIvList = new ArrayList<>();
    }


    public Label(){

    }


    abstract boolean checkLabelFormat(String name) throws InvalidLabelFormatException;


    public ICClone addICClone(Sex sex,Location location, Seller seller){
        String cloneId = String.format("%s-%s", this.getPrefix(), this.cloneIcList.size());
        ICClone icClone = createICClone(cloneId, sex, location,seller);
        this.cloneIcList.add(icClone);
        return icClone;
    }

    public ICClone addICClone(Sex sex,String cloneId, Location location, Seller seller){
        ICClone icClone = createICClone(cloneId, sex, location,seller);
        this.cloneIcList.add(icClone);
        return icClone;
    }
    //TODO using this current method  enables  to add the  same clone (id wise)  twice
    public IVClone addIVClone(String cloneId, Sex sex, Location location, Producer producer){
        IVClone icClone = createIVClone( cloneId, sex, location, producer);
        this.cloneIvList.add(icClone);
        return icClone;
    }

    public abstract ICClone createICClone(String cloneId, Sex sex, Location location, Seller seller);
    public abstract IVClone createIVClone(String cloneId, Sex sex, Location location, Producer producer);

    // Different Label Classes must have an ID
    protected abstract String getLabelIdentifier();
    public List<ICClone> getCloneIcList() {
        return new ArrayList<>(cloneIcList);
    }
    public List<IVClone> getCloneIVList() {
        return new ArrayList<>(cloneIvList);
    }

    public List<Clone> getAllClones(){
        ArrayList<Clone> clones = new ArrayList<>(cloneIvList);
        clones.addAll(cloneIcList);

        return new ArrayList<>(cloneIvList);
    }


}
