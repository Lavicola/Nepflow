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

    public IVClone<Nepenthes> addIVClone(String cloneId, Sex sex, Grex grex, Producer producer, Location location) {
        IVNepenthesClone ivNepenthesClone = new IVNepenthesClone(this, cloneId, sex, grex, producer, location);
        this.cloneList.add(ivNepenthesClone);
        return ivNepenthesClone;
    }

    @Override
    public IVClone<Nepenthes> addIVClone(String cloneId, Sex sex, Grex grex, Producer producer) {
        IVNepenthesClone ivNepenthesClone = new IVNepenthesClone(this, cloneId, sex, grex, producer, null);
        this.cloneList.add(ivNepenthesClone);
        return ivNepenthesClone;
    }

    public ICClone addICClone(Sex sex, Grex grex, Location location) {
        ICNepenthesClone icNepenthesClone = (ICNepenthesClone) this.addICClone(sex, grex);
        icNepenthesClone.setLocation(location);
        return icNepenthesClone;
    }

    @Override
    public ICClone addICClone(Sex sex, Grex grex) {
        String cloneId = String.format("%s-%s", this.getPrefix(), this.cloneList.size());
        ICNepenthesClone icNepenthesClone = new ICNepenthesClone(this, sex, grex, cloneId);
        this.cloneList.add(icNepenthesClone);
        return icNepenthesClone;
    }

    @Override
    protected String getLabelIdentifier() {
        return "N";
    }

}
