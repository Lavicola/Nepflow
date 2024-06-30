package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.Exception.InvalidLabelFormatException;
import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


/**
 * These Tests, test the logic to prevent the creation of invalid Primary hybrids
 *
 */


public class PrimaryHybridTest {




    @Test
    public void hybridFormatTest() {
        String invalidFormat = String.format("%sx%s".formatted(LabelFormats.nep1, LabelFormats.nep2));
        String invalidFormat2 = String.format("(%s) x (%s)".formatted(LabelFormats.nep1, LabelFormats.nep2));
        String invalidFormat3 = String.format("(%s) x".formatted(LabelFormats.nep1));
        String invalidFormat4 = String.format("%s x %s".formatted(LabelFormats.nep1, LabelFormats.nep2));
        String invalidFormat5 = String.format("%s X %s".formatted(LabelFormats.nep1, LabelFormats.nep2));

        new PrimaryHybrid(LabelFormats.hybridFormat1,0);

        assertThrows(InvalidLabelFormatException.class, () -> {
            new PrimaryHybrid(invalidFormat,0);

        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new PrimaryHybrid(invalidFormat2,0);

        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new PrimaryHybrid(invalidFormat3,0);

        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new PrimaryHybrid(invalidFormat4,0);

        });
        assertThrows(InvalidLabelFormatException.class, () -> {
            new PrimaryHybrid(invalidFormat5,0);
        });
    }



    @Test
    public void setParentsTest() {
        PrimaryHybrid primaryHybrid = new PrimaryHybrid(LabelFormats.hybridFormat1,0);
        assertEquals("Mother Name is false", primaryHybrid.getMotherName(),LabelFormats.nep1);
        assertEquals("Father Name is false", primaryHybrid.getFatherName(),LabelFormats.nep2);
    }

    @Test
    void labelICCloneIdGenerationTest(){
        Label label1 =  new PrimaryHybrid(LabelFormats.hybridFormat1,0);
        Label label2 = new PrimaryHybrid(LabelFormats.hybridFormat2,1);

        ICClone icNepenthesClone10 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone11 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone20 = label2.addICClone(null,null,null);
        ICClone icNepenthesClone21 = label2.addICClone(null,null,null);

        Assertions.assertEquals("Nepflow-H-0-0",icNepenthesClone10.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-H-0-1",icNepenthesClone11.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-H-1-0",icNepenthesClone20.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("Nepflow-H-1-1",icNepenthesClone21.getCloneId(),"Clone Id is wrong");

    }



}