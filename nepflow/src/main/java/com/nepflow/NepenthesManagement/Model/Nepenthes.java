package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Objects;

@Node("Nepenthes")
public class Nepenthes {

    @Property
    @Id
    @Getter
    private String name;

    public Nepenthes(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(this.getName(), ((Nepenthes) obj).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }


}
