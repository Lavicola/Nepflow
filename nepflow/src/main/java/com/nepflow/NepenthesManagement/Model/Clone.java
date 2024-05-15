package com.nepflow.NepenthesManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;


@Node
@NoArgsConstructor
@AllArgsConstructor
public abstract class Clone {

    // TODO at some point use validation annotation
    public static Set<String> validPlants = new HashSet<>();

    @Property
    @Id
    protected String cloneId;

    @Getter
    protected String name;

    @Setter
    @Relationship("HAS_SEX")
    protected Sex sex;

    @Relationship(value = "OFFSPRING_FROM", direction = Relationship.Direction.OUTGOING)
    @Getter
    protected Grex grex;

    @Version
    private Long version;

    protected boolean nepenthesExists(String name){
        return Clone.validPlants.contains(name);
    }


}


