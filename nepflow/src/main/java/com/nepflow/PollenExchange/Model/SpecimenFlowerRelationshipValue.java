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

@RelationshipProperties
@NoArgsConstructor
public class SpecimenFlowerRelationshipValue {
    @Id
    @GeneratedValue
    private String uuid;

    @TargetNode
    @Getter
    Specimen specimen;

    @Getter
    LocalDate startDate = LocalDate.now();


    public SpecimenFlowerRelationshipValue(Specimen specimen){
        this.specimen = specimen;
    }

    @PersistenceCreator
    public SpecimenFlowerRelationshipValue(Specimen specimen,LocalDate startDate){
        this.specimen = specimen;
        this.startDate = startDate;
    }

}
