package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.*;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Node
@Getter
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
    protected Grex grex;

    @Version
    private Long version;

    protected Clone(String name, String cloneId, Grex grex) {
        this.name = name;
        this.cloneId = cloneId;
        this.grex = grex;
    }

    protected Clone(String name, String cloneId) {
        this.name = name;
        this.cloneId = cloneId;
    }

    protected Clone(String name) {
        this.name = name;
    }



}


