package com.nepflow.NepenthesManagement.Model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class MultiHybridTest {


    @BeforeEach
    public void fillCloneMap() {
        Clone.validPlants.add("villosa");
        Clone.validPlants.add("hamata");
        Clone.validPlants.add("lowii");
        Clone.validPlants.add("mollis");

    }


    @Test
    public void HybridPreConditionTest() {
        Hybrid hybrid = new Hybrid("villosa x hamata", "aaaa");
        Hybrid hybrid2 = new Hybrid("lowii x mollis", "bbbb");
        String multiHybridName = String.format("(%s x %s) x (%s x %s)",
                hybrid.getMotherName(), hybrid.getFatherName(),
                hybrid2.getMotherName(), hybrid2.getFatherName());
        Grex grex = new Grex(hybrid, hybrid2, "ffff");
        new MultiHybrid(multiHybridName, "aaa", grex);

        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(multiHybridName, "aaa", null);
        });

    }


    @Test
    public void MultiHybridFormatValidator() {
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

        new MultiHybrid(hybrid1Valid, "aaa");
        new MultiHybrid(hybrid2Valid, "ddd");

        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid3Invalid, "aaa");
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid4InValid, "aaa");
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid5InValid, "aaa");
        });
        assertThrows(AssertionError.class, () -> {
            new MultiHybrid(hybrid6InValid, "aaa");
        });
    }

    @Test
    public void hybridNameAndGrexEqualTest() {
        Hybrid hybrid = new Hybrid("villosa x hamata", "aaaa");
        Hybrid hybrid2 = new Hybrid("lowii x mollis", "bbbb");
        Grex grex = new Grex(hybrid, hybrid2, "ffff");
        String multiHybridName = String.format("(%s x %s) x (%s x %s)",
                hybrid.getMotherName(), hybrid.getFatherName(),
                hybrid2.getMotherName(), hybrid2.getFatherName());

        MultiHybrid multiHybrid1 = new MultiHybrid(multiHybridName, "aaa");
        MultiHybrid multiHybrid2 = new MultiHybrid(multiHybridName, "aaa", grex);

        assertEquals("Both father should be equal", multiHybrid1.getFatherName(), multiHybrid1.getFatherName());
        assertEquals("Both Mother should be equal", multiHybrid2.getMotherName(), multiHybrid2.getMotherName());
    }

    @Test
    public void MultiHybridNameAndGrexEqualTest() {
        // tODO at some point refactor, hard to understand
        Hybrid hybrid = new Hybrid("villosa x hamata", "aaaa");
        Hybrid hybrid2 = new Hybrid("lowii x mollis", "bbbb");
        Grex grex = new Grex(hybrid, hybrid2, "ffff");
        String multiHybridName = grex.getName();
        MultiHybrid multiHybrid1 = new MultiHybrid(multiHybridName, "aaa");
        MultiHybrid multiHybrid2 = new MultiHybrid(multiHybridName, "aaa", grex);
        Grex grex2 = new Grex(multiHybrid1, multiHybrid2, "ffff");
        multiHybridName = grex2.getName();
        MultiHybrid multiHybrid3 = new MultiHybrid(multiHybridName, "aaa");
        MultiHybrid multiHybrid4 = new MultiHybrid(multiHybridName, "aaa", grex2);

        assertEquals("Both Mother should be equal", multiHybrid1.getName(), multiHybrid4.getMotherName());
        assertEquals("Both Mother should be equal", multiHybrid2.getName(), multiHybrid4.getMotherName());
        assertEquals("Both Mother should be equal", multiHybrid3.getMotherName(), multiHybrid4.getMotherName());
        assertEquals("Both father should be equal", multiHybrid3.getFatherName(), multiHybrid4.getFatherName());
    }

    @Test
    public void MultiHybridClonesNameAndGrexEqualTest() {
        // tODO at some point refactor, hard to understand
        Hybrid hybrid = new Hybrid("villosa x hamata", "aaaa");
        Hybrid hybrid2 = new Hybrid("lowii x mollis", "bbbb");
        Grex grex = new Grex(hybrid, hybrid2, "ffff");
        Grex grex2 = new Grex(hybrid,new IVClone("villosa","fff",new Nepenthes("villosa")),"ddd");
        MultiHybrid multiHybrid = new MultiHybrid(grex2.getName(), "s");

        assertEquals("",multiHybrid.getName(),grex2.getName());
        assertEquals("",multiHybrid.getFatherName(),grex2.father.getName());
        assertEquals("",multiHybrid.getMotherName(),grex2.mother.getName());
        //
        MultiHybrid multiHybrid2 = new MultiHybrid(grex.getName(), "s");
        Grex grex3 = new Grex(multiHybrid,multiHybrid2,"");
        MultiHybrid multiHybrid3 = new MultiHybrid(grex3.getName(), "");

        assertEquals("",multiHybrid3.getName(),grex3.getName());
        assertEquals("",multiHybrid3.getFatherName(),grex3.father.getName());
        assertEquals("",multiHybrid3.getMotherName(),grex3.mother.getName());



    }

}

