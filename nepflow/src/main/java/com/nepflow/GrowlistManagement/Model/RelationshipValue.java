package com.nepflow.GrowlistManagement.Model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.sql.Timestamp;

@RelationshipProperties
public class RelationshipValue {

    @Id
    @GeneratedValue
    private Long graphId;

    private Timestamp timestamp;

    @TargetNode
    Growlist growlist;



}
