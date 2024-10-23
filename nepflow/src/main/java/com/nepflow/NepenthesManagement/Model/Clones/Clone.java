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

/**
 * Abstract Model which represents a Clone.
 * A clone is an individual out of a seed.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */
@Node
@NoArgsConstructor
public abstract class Clone {

    /**
     *
     */
    @Relationship(value = "CLONE_OF_SPECIES", direction = Relationship.Direction.OUTGOING)
    @Getter
    private Label label;


    /**
     * a Seedgrown clone is always unique, while an IV clone is not.
     * In this Domain however a clone id of an IV plant maybe a collection of clones
     * or a single, selected clone.
     * InternalCloneId therefore combines the Sex and the cloneId in order to simplify this dependency.
     */
    @Id
    @Getter
    private String internalCloneId;

    /**
     * A clone is sometimes registered as a Cultivar or known under a specific name.
     * E.g. smilodon --> rhh x diabolica from Simon Lumb
     */
    @Getter
    private String cultivarName;

    /**
     * A cloneId is either a single individual or a collection of several individuals sold under a specific Id.
     */
    @Property
    private String cloneId;

    /**
     *
     */
    @Setter
    @Getter
    @Relationship("HAS_SEX")
    private Sex sex;

    /**
     *
     */
    @Relationship(value = "OFFSPRING_FROM", direction = Relationship.Direction.OUTGOING)
    @Getter
    private Grex grex;

    /**
     *
     */
    @Version
    private Long version;

    /**
     *
     */
    @Setter
    @Getter
    @Relationship("ORIGIN")
    private Location location;

    /**
     * @param label    the label(or more specific species/hybrid) a clone will reference
     * @param sex      the Sex of a Clone
     * @param cloneId  the id of a clone
     * @param location the origin of the clone
     */
    public Clone(final Label label, final Sex sex, final String cloneId, final Location location) {
        this.label = label;
        this.sex = sex;
        this.cloneId = cloneId;
        this.internalCloneId = Clone.generateInternalCloneId(cloneId, sex);
        this.location = location;
    }

    /**
     * @param cultivarName culativarename of the clone
     */
    public void setCultivarName(final String cultivarName) {
        if (this.cultivarName == null || this.cultivarName.equals("")) {
            return;
        }
        this.cultivarName = cultivarName;
    }

    /**
     * @param grex grex where the clone belongs to
     */
    public void setGrex(final Grex grex) {
        if (this.grex == null) {
            return;
        }
        this.grex = grex;
    }

    /**
     * @return id of the clone
     */
    public String getCloneId() {
        return cloneId;
    }

    /**
     * @return location as String
     */
    public String getLocationAsString() {
        return this.location != null ? this.location.getName() : "";
    }

    /**
     * @return sex as String
     */
    public String getSexAsString() {
        return Sex.sexToSexAsString(this.sex);
    }

    /**
     * @return name of the label(e.g. species)
     */
    public String getLabelName() {
        return this.label != null ? this.label.getName() : "";
    }

    /**
     * @return name of the Seller
     */
    public abstract String getSellerAsString();

    /**
     * Due to fact mentioned in internal Clone id, this method is used to generate the internal Clone id.
     *
     * @param cloneId clone Id
     * @param sex     sex
     * @return internal Clone Id
     */
    public static String generateInternalCloneId(final String cloneId, final Sex sex) {
        if (sex != null) {
            return String.format("%s-%s", cloneId, sex.getSexAsString().charAt(0));
        } else {
            return cloneId;
        }
    }


    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return this.internalCloneId.hashCode();
    }

    /**
     * @param obj
     * @return true if internalCloneId is same, else false
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {

            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return ((Clone) obj).internalCloneId.equals(this.internalCloneId);

    }

}

