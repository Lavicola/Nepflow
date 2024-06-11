package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clones.Clone;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@RelationshipProperties
public class RelationshipValue {

    @Id
    @GeneratedValue
    private Long graphId;

    private LocalDate date;

    @TargetNode
    Clone clone;

    public RelationshipValue(Clone clone){
        this.date = LocalDate.now();
    }



}
