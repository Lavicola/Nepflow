package com.nepflow.GrowlistManagement.Model;

import com.nepflow.NepenthesManagement.Model.Clone;
import com.nepflow.NepenthesManagement.Model.SpeciesClone;
import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Node
public class NepenthesClone {
    // A NepenthesClone is a specific Clone of a specific Nepenthes which also provides more information of a specific Plant

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    @Getter
    private UUID id;

    @Relationship(value = "GROWS_AT",direction = Relationship.Direction.OUTGOING)
    @Getter
    User user;

    @Relationship(value = "IDENTICALLY_TO",direction = Relationship.Direction.OUTGOING)
    @Getter
    Clone clone;

    @Version
    private Long version;


    private NepenthesClone(){

    }

    public NepenthesClone(User user,Clone clone){
        this.user = user;
        this.clone = clone;
    }

}
