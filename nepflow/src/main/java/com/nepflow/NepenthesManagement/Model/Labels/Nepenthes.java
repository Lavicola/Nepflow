package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICNepenthesClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Nepenthes extends Label {

    public Nepenthes(String name, int labelCount) {
        super(name, labelCount);
    }

    public Nepenthes(String name) {
        super(name);
    }

    public Nepenthes() {
        super();
    }

    @Override
    boolean isValidLabelName(String name) {
        // only one word allowed
        return this.speciesExists(name);
    }

    @Override
    boolean checkLabelFormat(String name) {
        // no real way to verify since nepenthes are sometimes very badly named
        return true;//name.matches("^[a-zA-Z]+$");
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
