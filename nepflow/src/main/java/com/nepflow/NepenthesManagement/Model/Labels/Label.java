package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import lombok.Getter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This Abstract Class represents the abstraction needed for the different types of subclasses of
 * Nepenthes(the species itself), hybrid (two Nepenthe's crossbreed), multi hybrids(more than three hybrids)
 */


@Node
public abstract class Label {

    @Transient
    public static Set<String> validPlants = new HashSet<>();

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
     * @param name
     * @param labelCount The current amount of Labels of the specific Subclass
     */
    public Label(String name,int labelCount) {
        this(name);
        this.prefix = String.format("%s-%d",this.getLabelIdentifier(),labelCount);
    }
    public Label(String name) {
        name = name.toLowerCase();
        assert checkLabelFormat(name);
        assert isValidLabelName(name);
        this.name = name;
        this.cloneIcList = new ArrayList<>();
        this.cloneIvList = new ArrayList<>();

    }

    public Label(){

    }


    abstract boolean isValidLabelName(String name);

    abstract boolean checkLabelFormat(String name);

    boolean speciesExists(String name) {
        return Label.validPlants.contains(name);
    }

    public static void addValidPlant(String name){
        validPlants.add(name);
    }

    public abstract IVClone addIVClone(String cloneId, Sex sex, Grex grex, Producer producer);
    public abstract ICClone addICClone(Sex sex, Grex grex);

    // Different Label Classes must have an ID
    protected abstract String getLabelIdentifier();
    public List<ICClone> getCloneIcList() {
        return new ArrayList<>(cloneIcList);
    }
    public List<IVClone> getCloneIVList() {
        return new ArrayList<>(cloneIvList);
    }
}
