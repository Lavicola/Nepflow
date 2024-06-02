package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MultiHybridTest {
    String nep1 = "villosa";
    String nep2 = "lowii";

    String nep3 = "hamata";
    String nep4 = "truncata";
    String simpleHybridformat1 = String.format("%s x %s", nep1, nep2);
    String simpleHybridformat2 = String.format("%s x %s", nep3, nep4);

    String multiHybridFormat1 = String.format("(%s) x (%s)", simpleHybridformat1, simpleHybridformat2);

    String multiHybridFormat2 = String.format("(%s) x %s", simpleHybridformat1, nep4);



    @BeforeEach
    public void fillKnownSpecies() {
        Label.validPlants.add(nep1);
        Label.validPlants.add(nep2);
        Label.validPlants.add(nep3);
        Label.validPlants.add(nep4);

    }

    @Test
    public void multihybridFormatTest() {

        Label.validPlants.add("NAME");
        String hybridValid = "(NAME x NAME) x (NAME x NAME)";
        String hybrid1Valid = "(((NAME x NAME) x NAME) x NAME) x NAME";
        String hybrid2Valid = "(((NAME x NAME) x NAME) x NAME) x (NAME x NAME)";

        // ambiguous
        String hybrid3Invalid = "(((NAME x NAME) x NAME) x NAME x (NAME x NAME)";
        // too many bracket
        String hybrid4InValid = "((((NAME x NAME) x NAME) x NAME) x (NAME x NAME)";
        // brackets over both parents
        String hybrid5InValid = "((((NAME x NAME) x NAME) x NAME) x (NAME x NAME))";
        // whitspace
        String hybrid6InValid = " ((((NAME x NAME) x NAME) x NAME) x (NAME x NAME))";


        new MultiHybrid(hybridValid,0);
        new MultiHybrid(hybrid1Valid,0);
        new MultiHybrid(hybrid2Valid,0);

        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid3Invalid,0);
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid4InValid,0);
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid5InValid,0);
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid6InValid,0);
        });

    }

    @Test
    public void multihybridSetParentTest() {
        String hybridValid = "(NAME x NAME) x (NAME x NAME)";
        String hybrid1Valid = "(((NAME x NAME) x NAME) x NAME) x NAME";
        String hybrid2Valid = "(((NAME x NAME) x NAME) x NAME) x (NAME x NAME)";

        MultiHybrid multiHybrid = new MultiHybrid(hybridValid,0);
        MultiHybrid multiHybrid2 =new MultiHybrid(hybrid1Valid,0);
        MultiHybrid multiHybrid3 =new MultiHybrid(hybrid2Valid,0);

        assertEquals("((NAME x NAME) x NAME) x NAME".toLowerCase(),multiHybrid2.getMotherName());
        assertEquals("NAME".toLowerCase(),multiHybrid2.getFatherName());

        assertEquals("((NAME x NAME) x NAME) x NAME".toLowerCase(),multiHybrid3.getMotherName());
        assertEquals("NAME x NAME".toLowerCase(),multiHybrid3.getFatherName());

        assertEquals("NAME x NAME".toLowerCase(),multiHybrid.getMotherName());
        assertEquals("NAME x NAME".toLowerCase(),multiHybrid.getFatherName());



    }


    @Test
    void MultiHybridICCloneIdGenerationTest(){
        Label.addValidPlant(LabelFormats.nep1);
        Label.addValidPlant(LabelFormats.nep2);
        Label label1 =  new MultiHybrid(LabelFormats.multiHybridFormat1,0);
        Label label2 =  new MultiHybrid(LabelFormats.multiHybridFormat2,1);

        ICClone icNepenthesClone10 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone11 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone20 = label2.addICClone(null,null,null);
        ICClone icNepenthesClone21 = label2.addICClone(null,null,null);

        Assertions.assertEquals("MH-0-0",icNepenthesClone10.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("MH-0-1",icNepenthesClone11.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("MH-1-0",icNepenthesClone20.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("MH-1-1",icNepenthesClone21.getCloneId(),"Clone Id is wrong");

    }


}
