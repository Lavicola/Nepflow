package com.nepflow.NepenthesManagement.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Sex {

    @Id
    private int id;

    @Getter
    @Setter
    private SEX sex;


    public Sex(String sex) {

    }


    static enum SEX {
        unkown, male, female
    }


}
