package com.nepflow.NepenthesManagement.Model.CloneMetadata;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@NoArgsConstructor
public class Sex {

    @Id
    @Getter
    private String sexAsString;

    public Sex(String sex) {
        this.sexAsString = sex;

    }



}
