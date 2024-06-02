package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.*;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICPrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
import com.nepflow.NepenthesManagement.Model.Clones.IVPrimaryHybrid;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.regex.Pattern;

@Node
public class PrimaryHybrid extends HybridLabel {
    public PrimaryHybrid(String name, int labelCount) {
        super(name,labelCount);
    }

    public PrimaryHybrid(String name) {
        super(name);
        this.setParents();
    }

    @Override
    boolean isValidLabelName(String name) {
        for (String nepenthes : name.substring(1, name.length() - 1).split(HYBRID_SEPARATOR)) {
            if (!this.speciesExists(nepenthes)) {
                return false;
            }
        }
        return true;
    }


    @Override
    boolean checkLabelFormat(String name) {
        // must be (NAME x NAME)
        return Pattern.compile("^\\(\\w+ x \\w+\\)$").matcher(name).find();
    }

    @Override
    public ICClone createICClone(String cloneId, Sex sex, Location location, Grex grex, Seller seller) {
        return new ICPrimaryHybrid(sex,grex,cloneId,location,seller);
    }

    @Override
    public IVClone createIVClone(String cloneId, Sex sex, Grex grex, Location location, Producer producer) {
        return new IVPrimaryHybrid(cloneId,sex,grex,location,producer);
    }


    @Override
    protected String getLabelIdentifier() {
        return "Nepflow-H";
    }


    @Override
    void setParents() {

        String[] motherFather = name.substring(1, name.length() - 1).split(HYBRID_SEPARATOR);
        this.motherName = motherFather[0];
        this.fatherName = motherFather[1];
    }

}
