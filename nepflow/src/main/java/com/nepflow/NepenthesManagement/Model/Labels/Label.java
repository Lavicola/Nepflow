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
 * Model which abstract the different types of concrete Nepenthes types.
 * E.g. Species like villosa, PrimaryHybrid like villosa x hamata
 * The Abstraction can therefore be seen as an aggregate Root used to create new clones
 * for different types of Nepenthes.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */


@Node
public abstract class Label {


    /**
     *
     */
    @Id
    @Getter
    private String name;


    /**
     *
     */
    @Relationship(value = "HAS_CLONE", direction = Relationship.Direction.OUTGOING)
    private List<ICClone> cloneIcList;

    /**
     *
     */
    @Relationship(value = "HAS_CLONE", direction = Relationship.Direction.OUTGOING)
    private List<IVClone> cloneIvList;


    /**
     * Method used to generate a unique Label Id for all concrete Nepenthes subtypes.
     *
     * @param labelCount The amount of unique different subtypes of Labels
     */
    public void setPrefixIfEmpty(final int labelCount) {
        if (prefix == null) {
            this.prefix = String.format("%s-%d", this.getLabelIdentifier(), labelCount);
        }
    }

    /**
     * Prefix which determines the Id for all subtypes and their concrete objects.
     * e.g. Species --> N, Hybrid --> H
     */
    @Property
    @Getter
    private String prefix;

    /**
     *
     */
    @Version
    private Long version;


    /**
     * @param name       Name of the Nepenthes
     * @param labelCount The current amount of Labels of the specific Subclass
     */
    public Label(final String name, final int labelCount) throws InvalidLabelFormatException {
        this(name);
        this.prefix = String.format("%s-%d", this.getLabelIdentifier(), labelCount);
    }

    /**
     * @param name Name of the Nepenthes
     * @throws InvalidLabelFormatException
     */
    public Label(final String name) throws InvalidLabelFormatException {
        checkLabelFormat(name);
        this.name = name;
        this.cloneIcList = new ArrayList<>();
        this.cloneIvList = new ArrayList<>();
    }


    /**
     *
     */
    public Label() {

    }


    /**
     * Method used to guarantee consistent naming.
     *
     * @param name name of the Nepenthes
     * @return true if success, else exception
     * @throws InvalidLabelFormatException if Labelformat is invalid
     */
    abstract boolean checkLabelFormat(String name) throws InvalidLabelFormatException;


    /**
     * Method in order to add an ICClone to a specific Nepenthes.
     *
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created concrete ICClone
     */
    public ICClone addICClone(final Sex sex, final Location location, final Seller seller) {
        String cloneId = String.format("%s-%s", this.getPrefix(), this.cloneIcList.size());
        ICClone icClone = createICClone(cloneId, sex, location, seller);
        this.cloneIcList.add(icClone);
        return icClone;
    }

    /**
     * Method in order to add an ICClone with a CloneId to a specific Nepenthes.
     * Necessary due to the fact that ICClone from Producers are often already named.
     *
     * @param sex      sex of the Clone
     * @param cloneId  id of the clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created concrete ICClone
     */
    public ICClone addICClone(final Sex sex, final String cloneId, final Location location, final Seller seller) {
        ICClone icClone = createICClone(cloneId, sex, location, seller);
        this.cloneIcList.add(icClone);
        return icClone;
    }

    /**
     * Method in order to add a IVClone with a CloneId to a specific Nepenthes.
     *
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param producer producer of the clone
     * @return successful created concrete IVClone
     */
    public IVClone addIVClone(final String cloneId, final Sex sex, final Location location, final Producer producer) {
        IVClone icClone = createIVClone(cloneId, sex, location, producer);
        this.cloneIvList.add(icClone);
        return icClone;
    }

    /**
     * Method to be implemented in subclasses in order to create a concrete ICClone.
     *
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param seller   seller of the clone
     * @return successful created concrete ICClone
     */
    public abstract ICClone createICClone(String cloneId, Sex sex, Location location, Seller seller);

    /**
     * Method to be implemented in subclasses in order to create a concrete IVClone.
     *
     * @param cloneId  id of the clone
     * @param sex      sex of the Clone
     * @param location origin/location of the clone
     * @param producer produder of the clone
     * @return successful created concrete IVClone
     */
    public abstract IVClone createIVClone(String cloneId, Sex sex, Location location, Producer producer);

    /**
     * @return Label identifier
     */
    protected abstract String getLabelIdentifier();

    /**
     * @return a copy of all ICClones belonging to the Nepenthes
     */
    public List<ICClone> getCloneIcList() {
        return new ArrayList<>(cloneIcList);
    }

    /**
     * @return a copy of all IVClones belonging to the Nepenthes
     */
    public List<IVClone> getCloneIVList() {
        return new ArrayList<>(cloneIvList);
    }

    /**
     * @return a copy of all IV and IC Clones belonging to a Nepenthes
     */
    public List<Clone> getAllClones() {
        ArrayList<Clone> clones = new ArrayList<>(cloneIvList);
        clones.addAll(cloneIcList);

        return new ArrayList<>(cloneIvList);
    }


}
