package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Hybrid {

    @Property
    @Id
    String id;

    @Relationship(value = "IS_FATHER",direction = Relationship.Direction.OUTGOING)
    Clone father;
    @Relationship(value = "IS_MOTHER",direction = Relationship.Direction.OUTGOING)
    Clone mother;

    @Relationship(value = "IS_FATHER",direction = Relationship.Direction.OUTGOING)
    Nepenthes nepenthesFather;
    @Relationship(value = "IS_MOTHER",direction = Relationship.Direction.OUTGOING)
    Nepenthes nepenthesMother;

    @Property
    String name;
    private Hybrid(){

    }

    public Hybrid(Clone father, Clone mother){
        // if father or mother is not known allow creation using Nepenthe instead of Clone
        assert(father != null);
        assert(mother != null);
        this.mother = mother;
        this.father = father;
    }

    public Hybrid(Nepenthes father, Nepenthes mother){
        assert(father != null);
        assert(mother != null);
        this.nepenthesFather = father;
        this.nepenthesMother = mother;
        this.name = String.format("(%s)x%s",mother.getName(),father.getName());
    }




}
