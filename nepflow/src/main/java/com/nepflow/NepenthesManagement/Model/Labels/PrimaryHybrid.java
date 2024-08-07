package com.nepflow.NepenthesManagement.Model.Labels;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Producer;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Seller;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Sex;
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

    public PrimaryHybrid() {
        super();
    }

    @Override
    boolean checkLabelFormat(String name) throws InvalidLabelFormatException {
        // must be (NAME x NAME)
        if(Pattern.compile("^\\(\\w+ x (\\w+| )+\\)$").matcher(name).find()){
            return true;
        }
        throw new InvalidLabelFormatException(String.format("The PrimaryHybrid Format '%s' is not known",name));
    }



    @Override
    public ICClone createICClone(String cloneId, Sex sex, Location location, Seller seller) {
        return new ICPrimaryHybrid(this,sex,cloneId,location,seller);
    }

    @Override
    public IVClone createIVClone(String cloneId, Sex sex, Location location, Producer producer) {
        return new IVPrimaryHybrid(this,cloneId,sex,location,producer);
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
