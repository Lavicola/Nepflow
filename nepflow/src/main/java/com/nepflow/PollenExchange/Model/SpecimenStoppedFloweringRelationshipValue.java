package com.nepflow.PollenExchange.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.time.LocalDate;

/**
 * Custom Model which represents a Relationship property for PollenOffer.
 * The Custom Model represents the references used to represent a Specimen which stopped Flowering.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@RelationshipProperties
@NoArgsConstructor
public class SpecimenStoppedFloweringRelationshipValue extends SpecimenFlowerRelationshipValue {

    /**
     *
     */
    @Getter
    private LocalDate endDate = LocalDate.now();

    /**
     * @param specimenFlowerRelationshipValue specimenFlowerRelationshipValue
     */
    public SpecimenStoppedFloweringRelationshipValue(final SpecimenFlowerRelationshipValue specimenFlowerRelationshipValue) {
        super(specimenFlowerRelationshipValue.getSpecimen(), specimenFlowerRelationshipValue.getStartDate());
    }
}
