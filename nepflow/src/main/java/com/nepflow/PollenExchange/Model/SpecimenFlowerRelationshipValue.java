package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;

/**
 * Custom Model which represents a Relationship property for PollenOffer.
 * The Custom Model represents the references used to represent a flowering Specimen.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@RelationshipProperties
@NoArgsConstructor
public class SpecimenFlowerRelationshipValue {
    /**
     *
     */
    @Id
    @GeneratedValue
    private String uuid;

    /**
     *
     */
    @TargetNode
    @Getter
    private Specimen specimen;

    /**
     *
     */
    @Getter
    private LocalDate startDate = LocalDate.now();


    /**
     * @param specimen
     */
    public SpecimenFlowerRelationshipValue(final Specimen specimen) {
        this.specimen = specimen;
    }

    /**
     * @param specimen
     * @param startDate
     */
    @PersistenceCreator
    public SpecimenFlowerRelationshipValue(final Specimen specimen, final LocalDate startDate) {
        this.specimen = specimen;
        this.startDate = startDate;
    }

}
