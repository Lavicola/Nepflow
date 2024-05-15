package com.nepflow.NepenthesManagement.Model;

import org.springframework.data.annotation.Transient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Hybrid extends AbstractHybrid {


    @Transient
    // The Format MUST be NAME x NAME
    static Pattern pattern = Pattern.compile("(\\w+ x \\w+)");

    public Hybrid(String name, Grex grex,Sex sex) {
        super(name, grex);
        this.sex = sex;
    }

    public Hybrid() {

    }


    @Override
    void setParents() {
        String[] motherFather = name.split(HYBRID_SEPARATOR);
        this.motherName = motherFather[0];
        this.fatherName = motherFather[1];

    }

    @Override
    boolean isValidFormat(String name) {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    @Override
    void checkPostCondition() {
        assert Clone.validPlants.contains(this.motherName) : String.format("Mother Nepenthes (%s) does not exist", this.motherName);
        assert Clone.validPlants.contains(this.fatherName) : String.format("Father Nepenthes (%s) does not exist", this.fatherName);
    }

    public AbstractHybrid createHybrid(String name, String cloneId, Grex grex, Producer producer){
        if(producer == null){
            return new ICHybrid(name, grex,sex);
        }else{
            return new IVHybrid(name, cloneId, grex,sex,producer);
        }
    }

    public AbstractHybrid createConcreteIVHybrid(String name, String cloneId, Grex grex, Producer producer) {
        return new IVHybrid(name, cloneId, grex,sex, producer);
    }

    public AbstractHybrid createConcreteICHybrid(String name, Grex grex,Sex sex) {
        return new ICHybrid(name, grex,sex);
    }

}




