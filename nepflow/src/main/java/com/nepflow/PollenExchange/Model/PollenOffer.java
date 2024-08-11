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

@Node
@NoArgsConstructor
public class PollenOffer {


    @Transient
    // Within of three weeks a PollenOffer is valid and can be opened/closed several times
    final private int MIN_DURATION_POLLENOFFER = 21;

    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    @Version
    private long version;

    @Relationship(value = "FLOWERS", direction = Relationship.Direction.OUTGOING)
    SpecimenFlowerRelationshipValue specimenFlowerRelationshipValue;

    @Relationship(value = "HAS_FLOWERED", direction = Relationship.Direction.OUTGOING)
    SpecimenStoppedFloweringRelationshipValue specimenStoppedFloweringRelationshipValue;

    public PollenOffer(Specimen specimen) {
        if (specimen.getSexAsString().equals("")) {
            throw new PollenOfferSpecimenNoSexException(specimen.getUuid());
        }
        this.specimenFlowerRelationshipValue = new SpecimenFlowerRelationshipValue(specimen);
    }

    public boolean isPollenOfferValid() {
        LocalDate endDate = this.getStartDate().plusDays(MIN_DURATION_POLLENOFFER);
        if (LocalDate.now().isBefore(endDate)) {
            return true;
        } else {
            return false;
        }

    }

    public Specimen getSpecimen() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getSpecimen() : this.specimenStoppedFloweringRelationshipValue.getSpecimen();
    }

    public LocalDate getStartDate() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getStartDate() : this.specimenStoppedFloweringRelationshipValue.getStartDate();
    }

    public LocalDate getEndDateOrNull() {
        return this.specimenFlowerRelationshipValue != null ? null : this.specimenStoppedFloweringRelationshipValue.getEndDate();
    }

    public boolean closePollenOffer() {
        if (!this.isOpen()) {
            return true; // Offer is already closed
        }
        this.specimenStoppedFloweringRelationshipValue = new SpecimenStoppedFloweringRelationshipValue(this.specimenFlowerRelationshipValue);
        this.specimenFlowerRelationshipValue = null;
        return true;
    }

    public boolean isOpen() {
        return this.specimenFlowerRelationshipValue != null;
    }

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


    public User getUser() {
        if (this.specimenFlowerRelationshipValue != null) {
            return this.specimenFlowerRelationshipValue.getSpecimen().getUser();
        } else {
            return this.specimenStoppedFloweringRelationshipValue.getSpecimen().getUser();
        }
    }

    public String getSexAsString() {
        if (this.specimenFlowerRelationshipValue != null) {
            return this.specimenFlowerRelationshipValue.getSpecimen().getSexAsString();
        } else {
            return this.specimenStoppedFloweringRelationshipValue.getSpecimen().getSexAsString();
        }
    }

    public boolean pollenOfferBelongsToUser(User user) {
        return this.getUser().equals(user);
    }


    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return this.getUuid().equals(((PollenOffer) obj).getUuid());

    }


}
