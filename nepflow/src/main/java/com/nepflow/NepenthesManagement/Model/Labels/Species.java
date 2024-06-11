package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.regex.Pattern;

@Node
public class Species extends Label {



    public Species(String name, int labelCount) {
        super(name, labelCount);
    }

    public Species(String name) {
        super(name);
    }

    public Species() {
        super();
    }


    @Override
    boolean checkLabelFormat(String name) {
        // no real way to verify since nepenthes are sometimes very badly named
        if(Pattern.compile("^(?!.*\\bx\\b)[^()]*$").matcher(name).find()){
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The PrimaryHybrid Format '%s' is not known",name));
    }

    @Override
    public ICClone createICClone(String cloneId, Sex sex, Location location, Grex grex, Seller seller) {
        return new ICNepenthesClone(sex,grex,cloneId,location,seller);
    }

    @Override
    public IVClone createIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer) {
        return new IVNepenthesClone(cloneId,sex,grex,location,producer);
    }


    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-N";
    }

}
