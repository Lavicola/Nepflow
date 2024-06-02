package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.CloneMetadata.Location;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Nepenthes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataNeo4jTest
public class NepenthesTest {



    @Test
    void NepenthesICCloneIdGenerationTest(){
        Label.addValidPlant(LabelFormats.nep1);
        Label.addValidPlant(LabelFormats.nep2);
        Nepenthes label1 =  new Nepenthes(LabelFormats.nep1,0);
        Label label2 = new Nepenthes(LabelFormats.nep2,1);

        ICClone icNepenthesClone10 = label1.addICClone(null,new Location("Borneo"),null,null);
        ICClone icNepenthesClone11 = label1.addICClone(null,null,null,null);
        ICClone icNepenthesClone20 = label2.addICClone(null,null,null,null);
        ICClone icNepenthesClone21 = label2.addICClone(null,null,null,null);

        assertEquals("Nepflow-N-0-0",icNepenthesClone10.getCloneId(),"Clone Id is wrong");
        assertEquals("Nepflow-N-0-1",icNepenthesClone11.getCloneId(),"Clone Id is wrong");
        assertEquals("Nepflow-N-1-0",icNepenthesClone20.getCloneId(),"Clone Id is wrong");
        assertEquals("Nepflow-N-1-1",icNepenthesClone21.getCloneId(),"Clone Id is wrong");

    }




}
