package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Model.CloneMetadata.Grex;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Clones.ICHybrid;
import com.nepflow.NepenthesManagement.Model.Clones.IVClone;
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
    public IVClone addIVClone(String cloneId, Sex sex, Grex grex, Producer producer) {
        return null;
    }


    @Override
    public ICClone addICClone(Sex sex, Grex grex) {
        String cloneId = String.format("%s-%s",this.getPrefix(),this.cloneList.size());
        ICHybrid icHybrid = new ICHybrid(this,sex,grex,cloneId);
        this.cloneList.add(icHybrid);
        return icHybrid;
    }

    @Override
    protected String getLabelIdentifier() {
        return "H";
    }


    @Override
    void setParents() {

        String[] motherFather = name.substring(1, name.length() - 1).split(HYBRID_SEPARATOR);
        this.motherName = motherFather[0];
        this.fatherName = motherFather[1];
    }

}
