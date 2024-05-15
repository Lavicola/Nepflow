package com.nepflow.NepenthesManagement.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class MultiHybridTest {

    Nepenthes nep1 = new Nepenthes("villosa");
    Nepenthes nep2 = new Nepenthes("lowii");
    Nepenthes nep3 = new Nepenthes("hamata");
    Nepenthes nep4 = new Nepenthes("truncata");
    AbstractHybrid simpleHybrid;

    AbstractHybrid simpleHybrid2;

    @BeforeEach
    public void fillCloneMap() {
        Clone.validPlants.add(nep1.getName());
        Clone.validPlants.add(nep2.getName());
        Clone.validPlants.add(nep3.getName());
        Clone.validPlants.add(nep4.getName());
        simpleHybrid = new ICHybrid(String.format("%s x %s",
                nep1.getName(),
                nep2.getName()), null, null);

        simpleHybrid2 = new ICHybrid(String.format("%s x %s",
                nep3.getName(),
                nep4.getName()), null, null);
    }

    @Test
    public void MultiHybridFormatValidationTest() {
        Clone.validPlants.add("NAME");
        AbstractHybrid abstractHybrid = new IVMultiHybrid();
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

        abstractHybrid.createHybrid(hybrid1Valid, "", null, null);
        abstractHybrid.createHybrid(hybrid2Valid, "", null, null);

        assertThrows(AssertionError.class, () -> {
            abstractHybrid.createHybrid(hybrid3Invalid, "", null, null);
        });
        assertThrows(AssertionError.class, () -> {
            abstractHybrid.createHybrid(hybrid4InValid, "", null, null);
        });
        assertThrows(AssertionError.class, () -> {
            abstractHybrid.createHybrid(hybrid5InValid, "", null, null);
        });
        assertThrows(AssertionError.class, () -> {
            abstractHybrid.createHybrid(hybrid6InValid, "", null, null);
        });
    }


    @Test
    public void multiBybridNameTest() {
        Clone.validPlants.add("NAME");
        String hybrid2Valid = "(((NAME x NAME) x NAME) x NAME) x NAME";
        String hybrid3Valid = "(((NAME x NAME) x NAME) x NAME) x (NAME x NAME)";
        AbstractHybrid abstractHybrid = new IVMultiHybrid();

        AbstractHybrid multiHybrid2 = abstractHybrid.createHybrid(hybrid2Valid, "", null, null);
        AbstractHybrid multihybrid3 = abstractHybrid.createHybrid(hybrid3Valid, "", null, null);

        assertEquals("both should output the same", multiHybrid2.getName(), hybrid2Valid);
        assertEquals("both should output the same", multihybrid3.getName(), hybrid3Valid);

        assertEquals("multiHybrid2 Mother name is not the expected Value", "((NAME x NAME) x NAME) x NAME", multiHybrid2.getMotherName());
        assertEquals("multiHybrid2 Father name is not the expected Value", "NAME", multiHybrid2.getFatherName());

        assertEquals("multihybrid3 Mother name is not the expected Value", "((NAME x NAME) x NAME) x NAME", multihybrid3.getMotherName());
        assertEquals("multihybrid3 Father name is not the expected Value", "(NAME x NAME)", multihybrid3.getFatherName());

    }


}
