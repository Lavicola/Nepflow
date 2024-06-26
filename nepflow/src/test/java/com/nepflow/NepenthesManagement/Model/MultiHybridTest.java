package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * These Tests, test the logic to prevent the creation of invalid Multi Hybrids
 *
 */

public class MultiHybridTest {


    @Test
    public void multihybridFormatTest() {

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

        assertThrows(InvalidLabelFormatException.class, () -> {
            new MultiHybrid(hybrid3Invalid,0);
        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new MultiHybrid(hybrid4InValid,0);
        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new MultiHybrid(hybrid5InValid,0);
        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new MultiHybrid(hybrid6InValid,0);
        });

    }

    @Test
    public void multihybridSetParentTest() {
        String hybridValid = "(name x name) x (name x name)";
        String hybrid1Valid = "(((name x name) x name) x name) x name";
        String hybrid2Valid = "(((name x name) x name) x name) x (name x name)";

        MultiHybrid multiHybrid = new MultiHybrid(hybridValid,0);
        MultiHybrid multiHybrid2 =new MultiHybrid(hybrid1Valid,0);
        MultiHybrid multiHybrid3 =new MultiHybrid(hybrid2Valid,0);

        assertEquals("((name x name) x name) x name",multiHybrid2.getMotherName());
        assertEquals("name",multiHybrid2.getFatherName());

        assertEquals("((name x name) x name) x name",multiHybrid3.getMotherName());
        assertEquals("name x name",multiHybrid3.getFatherName());

        assertEquals("name x name",multiHybrid.getMotherName());
        assertEquals("name x name",multiHybrid.getFatherName());



    }


    @Test
    void MultiHybridICCloneIdGenerationTest(){
        Label label1 =  new MultiHybrid(LabelFormats.multiHybridFormat1,0);
        Label label2 =  new MultiHybrid(LabelFormats.multiHybridFormat2,1);

        ICClone icNepenthesClone10 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone11 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone20 = label2.addICClone(null,null,null);
        ICClone icNepenthesClone21 = label2.addICClone(null,null,null);

        Assertions.assertEquals("Nepflow-MH-0-0",icNepenthesClone10.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-MH-0-1",icNepenthesClone11.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-MH-1-0",icNepenthesClone20.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-MH-1-1",icNepenthesClone21.getCloneId(),"Clone Id is wrong");

    }


}
