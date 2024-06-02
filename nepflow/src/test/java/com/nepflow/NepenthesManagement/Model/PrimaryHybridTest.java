package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.LabelFormats;
import com.nepflow.NepenthesManagement.Model.Clones.ICClone;
import com.nepflow.NepenthesManagement.Model.Labels.PrimaryHybrid;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PrimaryHybridTest {

    String nep1 = "villosa";
    String nep2 = "lowii";

    String validFormat = String.format("(%s x %s)".formatted(nep1, nep2));


    @BeforeEach
    public void fillKnownSpecies(){
        Label.validPlants.add(nep1);
        Label.validPlants.add(nep2);

    }

    @Test
    public void hybridFormatTest() {
        String invalidFormat = String.format("%sx%s".formatted(nep1, nep2));
        String invalidFormat2 = String.format("(%s) x (%s)".formatted(nep1, nep2));
        String invalidFormat3 = String.format("(%s) x".formatted(nep1));
        String invalidFormat4 = String.format("%s x %s".formatted(nep1, nep2));
        String invalidFormat5 = String.format("%s X %s".formatted(nep1, nep2));

        new PrimaryHybrid(validFormat,0);

        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(invalidFormat,0);

        });
        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(invalidFormat2,0);

        });
        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(invalidFormat3,0);

        });
        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(invalidFormat4,0);

        });
        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(invalidFormat5,0);
        });
    }

    @Test
    public void hybridNotExistingSpeciesTest() {
        Label.validPlants= new HashSet<>();
        assertThrows(AssertionError.class, () -> {
            new PrimaryHybrid(validFormat,0);
        });
    }

    @Test
    public void setParentsTest() {
        PrimaryHybrid primaryHybrid = new PrimaryHybrid(validFormat,0);
        assertEquals("Mother Name is false", primaryHybrid.getMotherName(),nep1);
        assertEquals("Father Name is false", primaryHybrid.getFatherName(),nep2);
    }

    @Test
    void labelICCloneIdGenerationTest(){
        Label.addValidPlant(LabelFormats.nep1);
        Label.addValidPlant(LabelFormats.nep2);
        Label label1 =  new PrimaryHybrid(LabelFormats.hybridFormat1,0);
        Label label2 = new PrimaryHybrid(LabelFormats.hybridFormat2,1);

        ICClone icNepenthesClone10 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone11 = label1.addICClone(null,null,null);
        ICClone icNepenthesClone20 = label2.addICClone(null,null,null);
        ICClone icNepenthesClone21 = label2.addICClone(null,null,null);

        Assertions.assertEquals("H-0-0",icNepenthesClone10.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("H-0-1",icNepenthesClone11.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("H-1-0",icNepenthesClone20.getCloneId(),"Clone Id is wrong");
        Assertions.assertEquals("H-1-1",icNepenthesClone21.getCloneId(),"Clone Id is wrong");

    }



}