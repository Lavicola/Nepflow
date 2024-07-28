package com.nepflow.PollenExchange.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.time.LocalDate;

@RelationshipProperties
@NoArgsConstructor
public class SpecimenStoppedFloweringRelationshipValue extends SpecimenFlowerRelationshipValue{

    @Getter
    LocalDate endDate = LocalDate.now();

    public SpecimenStoppedFloweringRelationshipValue(SpecimenFlowerRelationshipValue specimenFlowerRelationshipValue) {
        super(specimenFlowerRelationshipValue.specimen,specimenFlowerRelationshipValue.startDate);
    }
}
