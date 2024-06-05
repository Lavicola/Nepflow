package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
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


    @Relationship(value = "SPECIES_OF",direction = Relationship.Direction.INCOMING)
    List<ICClone> cloneIcList;

    @Relationship(value = "SPECIES_OF",direction = Relationship.Direction.INCOMING)
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
        name = name.toLowerCase();
        checkLabelFormat(name);
        this.name = name;
        this.cloneIcList = new ArrayList<>();
        this.cloneIvList = new ArrayList<>();

    }

    public Label(){

    }


    abstract boolean checkLabelFormat(String name) throws InvalidLabelFormatException;


    public ICClone addICClone(Sex sex,Location location, Grex grex,Seller seller){
        String cloneId = String.format("%s-%s", this.getPrefix(), this.cloneIcList.size());
        ICClone icClone = createICClone(cloneId, sex, location, grex,seller);
        this.cloneIcList.add(icClone);
        return icClone;
    }

    public IVClone addIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer){
        IVClone icClone = createIVClone(cloneId,sex,grex,location,producer);
        this.cloneIvList.add(icClone);
        return icClone;
    }

    public abstract ICClone createICClone(String cloneId, Sex sex, Location location, Grex grex, Seller seller);
    public abstract IVClone createIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer);

    // Different Label Classes must have an ID
    protected abstract String getLabelIdentifier();
    public List<ICClone> getCloneIcList() {
        return new ArrayList<>(cloneIcList);
    }
    public List<IVClone> getCloneIVList() {
        return new ArrayList<>(cloneIvList);
    }
}
