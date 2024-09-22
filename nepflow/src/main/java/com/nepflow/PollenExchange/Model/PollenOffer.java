package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Exception.PollenOfferSpecimenNoSexException;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

/**
 * Model which represents a PollenOffer.
 * A PollenOffer represents one unique Flower
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Node
@NoArgsConstructor
public class PollenOffer {


    /**
     * Contains a Magic Number.
     * The Magic Number determines how long a PollenOffer is Valid.
     * Meaning that a specific PollenOffer can be opened several times
     * in this Timeframe(in Days).
     */
    @Transient
    private final int MIN_DURATION_POLLENOFFER = 21;

    /**
     *
     */
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    /**
     *
     */
    @Version
    private long version;

    /**
     * If this relation is set it means that the PollenOffer is currently open.
     */
    @Relationship(value = "FLOWERS", direction = Relationship.Direction.OUTGOING)
    private SpecimenFlowerRelationshipValue specimenFlowerRelationshipValue;

    /**
     * If this relation is set it means that the PollenOffer is currently closed.
     */
    @Relationship(value = "HAS_FLOWERED", direction = Relationship.Direction.OUTGOING)
    private SpecimenStoppedFloweringRelationshipValue specimenStoppedFloweringRelationshipValue;

    /**
     * @param specimen the Specimen for which a PollenOffer shall be opened
     */
    public PollenOffer(final Specimen specimen) {
        if (specimen.getSexAsString().equals("")) {
            throw new PollenOfferSpecimenNoSexException(specimen.getUuid());
        }
        this.specimenFlowerRelationshipValue = new SpecimenFlowerRelationshipValue(specimen);
    }

    /**
     * @return true if PollenOffer is  valid (meaning it can be opened again), else false
     */
    public boolean isPollenOfferValid() {
        LocalDate endDate = this.getStartDate().plusDays(MIN_DURATION_POLLENOFFER);
        return LocalDate.now().isBefore(endDate);

    }

    /**
     * @return the Specimen to the PollenOffer
     */
    public Specimen getSpecimen() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getSpecimen() : this.specimenStoppedFloweringRelationshipValue.getSpecimen();
    }

    /**
     * @return Day the PollenOffer was created
     */
    public LocalDate getStartDate() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getStartDate() : this.specimenStoppedFloweringRelationshipValue.getStartDate();
    }

    /**
     * @return Day if the PollenOffer  is closed, else null
     */
    public LocalDate getEndDateOrNull() {
        return this.specimenFlowerRelationshipValue != null ? null : this.specimenStoppedFloweringRelationshipValue.getEndDate();
    }

    /**
     * @return true if PollenOffer could be closed
     */
    public boolean closePollenOffer() {
        if (!this.isOpen()) {
            return true; // Offer is already closed
        }
        this.specimenStoppedFloweringRelationshipValue = new SpecimenStoppedFloweringRelationshipValue(this.specimenFlowerRelationshipValue);
        this.specimenFlowerRelationshipValue = null;
        return true;
    }

    /**
     * @return true if PollenOffer is Open
     */
    public boolean isOpen() {
        return this.specimenFlowerRelationshipValue != null;
    }

    /**
     * @return true if PollenOffer can be opened, else false
     */
    public boolean openPollenOffer() {
        if (!this.isPollenOfferValid()) {
            return false; // Invalid offer cannot be opened
        }
        if (this.isOpen()) {
            return true; // Offer is already open
        }

        // Offer is valid but closed, change relationship
        this.specimenFlowerRelationshipValue = new SpecimenFlowerRelationshipValue(this.getSpecimen(), this.getStartDate());
        this.specimenStoppedFloweringRelationshipValue = null;
        return true;
    }


    /**
     * @return the user the specimen belongs to
     */
    public User getUser() {
        if (this.specimenFlowerRelationshipValue != null) {
            return this.specimenFlowerRelationshipValue.getSpecimen().getUser();
        } else {
            return this.specimenStoppedFloweringRelationshipValue.getSpecimen().getUser();
        }
    }

    /**
     * @return sex as a String of the Specimen
     */
    public String getSexAsString() {
        if (this.specimenFlowerRelationshipValue != null) {
            return this.specimenFlowerRelationshipValue.getSpecimen().getSexAsString();
        } else {
            return this.specimenStoppedFloweringRelationshipValue.getSpecimen().getSexAsString();
        }
    }


    /**
     * @param user User which should be checked against
     * @return true if the user is the same as the  reference to the PollenOffer
     */
    public boolean pollenOfferBelongsToUser(final User user) {
        return this.getUser().equals(user);
    }


    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    /**
     * @param obj PollenOffer
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
        return this.getUuid().equals(((PollenOffer) obj).getUuid());

    }


}
