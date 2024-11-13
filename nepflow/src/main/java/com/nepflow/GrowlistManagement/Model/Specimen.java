package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.*;

/**
 * Model which defines Methods in order
 * to return the right Label class at runtime.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class Specimen {


    /**
     *
     */
    @Id
    @Getter
    @GeneratedValue
    private String uuid;

    /**
     *
     */
    @Relationship(value = "INSTANCE_OF", direction = Relationship.Direction.OUTGOING)
    @Getter
    private Clone clone;

    /**
     *
     */
    @Relationship(value = "GROWS_BY", direction = Relationship.Direction.OUTGOING)
    @Getter
    private User user;

    /**
     * absolute Path of where the Image of the Specimen can be found.
     */
    @Getter
    @Setter
    private String imagePath;

    /**
     *
     */
    @Property
    @Getter
    private boolean isFlowering = false;


    /**
     * @param clone
     * @param user
     */
    public Specimen(final Clone clone, final User user) {
        if (clone == null) {
            throw new RuntimeException("Clone is not allowd to  be  null");
        }
        if (user == null) {
            throw new RuntimeException("User is not allowd to  be  null");
        }
        this.clone = clone;
        this.user = user;
        this.isFlowering = false;
    }


    /**
     * @return enum which represents the sex
     */
    public boolean isSexSet() {
        return this.clone.getSex().isSEXSet();
    }

    /**
     * @return name of the Seller as String
     */
    public String getSellerAsString() {
        return this.clone.getSellerAsString();
    }

    /**
     * @return name of the Location as String
     */
    public String getLocationAsString() {
        return this.clone.getLocationAsString();
    }

    /**
     * @return sex as String
     */
    public String getSexAsString() {
        return this.clone.getSexAsString();
    }


    /**
     * @return A clone references a Nepenthes name which will be returned
     */
    public String getNepenthesname() {
        return this.clone.getLabelName();
    }


    /**
     * @return cultivar Name of a Clone
     */
    public String getCultivarName() {
        return this.clone.getCultivarName();
    }


    /**
     * @param clone clone which belongs to the specimen
     */
    public void setClone(final Clone clone) {
        this.clone = clone;
    }

    /**
     * @return true if flowers else false
     */
    public boolean getFlowerStatus() {
        return this.isFlowering;
    }

    /**
     * @param isFlowering true if flowering else false
     */
    public void setFlowerStatus(final boolean isFlowering) {
        this.isFlowering = isFlowering;
    }


    /**
     * @param user User to compare to the owner
     * @return true if the user is owner, else false
     */
    public boolean isSpecimenOwner(final User user) {
        return this.user.equals(user);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    /**
     * @param obj
     * @return
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
        return this.uuid.equals(((Specimen) obj).uuid);

    }


}
