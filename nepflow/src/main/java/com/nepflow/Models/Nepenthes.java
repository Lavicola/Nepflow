package com.nepflow.Models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Nepenthes")
public class Nepenthes {

    @Id
    @GeneratedValue
    private Long id;

}
