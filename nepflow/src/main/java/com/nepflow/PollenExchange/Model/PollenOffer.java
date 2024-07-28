package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Node
@NoArgsConstructor
public class PollenOffer {
    @Id
    @GeneratedValue
    @Getter
    private String uuid;

    @Relationship(value = "PUBLISHED_BY", direction = Relationship.Direction.OUTGOING)
    @Getter
    User user;

    @Relationship(value = "FLOWERS", direction = Relationship.Direction.OUTGOING)
    SpecimenFlowerRelationshipValue specimenFlowerRelationshipValue;

    @Relationship(value = "HAS_FLOWERED", direction = Relationship.Direction.OUTGOING)
    SpecimenStoppedFloweringRelationshipValue specimenStoppedFloweringRelationshipValue;

    public PollenOffer(User user, Specimen specimen) {
        this.user = user;
        this.specimenFlowerRelationshipValue = new SpecimenFlowerRelationshipValue(specimen);
    }

    public Specimen getSpecimen() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getSpecimen() : this.specimenStoppedFloweringRelationshipValue.getSpecimen();
    }

    public LocalDate getStartDate() {
        return this.specimenFlowerRelationshipValue != null ? this.specimenFlowerRelationshipValue.getStartDate() : this.specimenStoppedFloweringRelationshipValue.getStartDate();
    }
    public void closePollenOffer() {
        this.specimenStoppedFloweringRelationshipValue = new SpecimenStoppedFloweringRelationshipValue(this.specimenFlowerRelationshipValue);
        this.specimenFlowerRelationshipValue = null;
    }


    public void openPollenOffer() {
        this.specimenFlowerRelationshipValue = new SpecimenFlowerRelationshipValue(this.getSpecimen(), this.getStartDate());
        this.specimenStoppedFloweringRelationshipValue = null;
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
