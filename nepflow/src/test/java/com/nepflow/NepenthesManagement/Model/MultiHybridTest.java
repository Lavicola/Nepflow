package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.MultiHybrid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        // number inside
        String hybrid7InValid = "(((NAME x NA7ME) x NAME) x NAME) x (NAME x NAME)";



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
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid7InValid,0);
        });



    }




}
