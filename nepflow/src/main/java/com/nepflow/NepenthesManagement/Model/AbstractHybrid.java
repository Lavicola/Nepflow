package com.nepflow.NepenthesManagement.Model;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Property;

public abstract class AbstractHybrid extends Clone{

    @Property
    @Getter
    protected String motherName;

    @Property
    @Getter
    protected String fatherName;
    static String HYBRID_SEPARATOR = " x ";

    public AbstractHybrid(){

    }

    public AbstractHybrid(String name, Grex grex){
        assert checkPreCondition(name);
        this.name = name;
        this.grex = grex;
        this.setParents();
        this.checkPostCondition();
    }

    abstract void setParents();
    abstract boolean isValidFormat(String name);
    protected boolean checkPreCondition(String name){
        return isValidFormat(name);
    }

    abstract void checkPostCondition();


    public abstract AbstractHybrid createHybrid(String name, String cloneId,Grex grex,Producer producer);
    public abstract AbstractHybrid createConcreteIVHybrid(String name, String cloneId,Grex grex,Producer producer);
    public abstract AbstractHybrid createConcreteICHybrid(String name,Grex grex,Sex sex);


}
