package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
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
    public ICClone createICClone(String cloneId,Sex sex, Location location, Grex grex) {
        return new ICNepenthesClone(sex,grex,cloneId);
    }

    @Override
    public IVClone createIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer) {
        return new IVNepenthesClone(cloneId,sex,grex,producer,location);
    }


    @Override
    protected String getLabelIdentifier() {
        return "N";
    }

}
