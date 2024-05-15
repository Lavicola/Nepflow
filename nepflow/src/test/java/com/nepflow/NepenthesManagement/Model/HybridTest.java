package com.nepflow.NepenthesManagement.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

public class HybridTest {


    Nepenthes nep1 = new Nepenthes("villosa");
    Nepenthes nep2 = new Nepenthes("lowii");
    String validFormat = String.format("%s x %s".formatted(nep1.getName(),nep2.getName()));
    Producer producer = new Producer("AW");


    @BeforeEach
    public void fillCloneMap(){
        Clone.validPlants.add(nep1.getName());
        Clone.validPlants.add(nep2.getName());

    }

    @Test
    public void hybridNameTest() {
        Hybrid hybrid = new ICHybrid(validFormat,null,null);
        assertEquals("validFormat and Hybridname should be the same",validFormat,hybrid.getName());

    }
    @Test
    public void nepenthesNotExistingTest() {
        Clone.validPlants = new HashSet<>();
        Hybrid hybrid = new ICHybrid();
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(validFormat, null,null);
        });
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteIVHybrid(validFormat, "BE-3225",null,producer);
        });
    }



    @Test
    public void hybridValidFormatTest() {
        Clone.validPlants.add("villosa");
        Clone.validPlants.add("lowii");
        String invalidFormat = String.format("%sx%s".formatted(nep1,nep2));
        String invalidFormat2 = String.format("(%s) x (%s)".formatted(nep1,nep2));
        String invalidFormat3 = String.format("(%s) x".formatted(nep1));
        String invalidFormat4 = String.format("(%s x %s)".formatted(nep1,nep2));
        String invalidFormat5 = String.format("%s X %s".formatted(nep1,nep2));
        Hybrid hybrid = new ICHybrid();

        hybrid.createConcreteICHybrid(validFormat, null,null);

        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(invalidFormat, null,null);
        });
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(invalidFormat2, null,null);
        });
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(invalidFormat3, null,null);
        });
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(invalidFormat4, null,null);
        });
        assertThrows(AssertionError.class, () -> {
            hybrid.createConcreteICHybrid(invalidFormat5, null,null);
        });
    }
    @Test
    public void hybridGrexNoGrexTest() {
        SpeciesClone speciesClone = new ICClone();
        AbstractHybrid hybrid = new IVHybrid();
        AbstractHybrid hybrid2;
        SpeciesClone clone1 = speciesClone.createNewICClone(nep1.getName(),nep1,null,null);
        SpeciesClone clone2 = speciesClone.createNewIVClone(nep2.getName(),"KLON-ID",nep2,null,null,producer);
        Grex grex = new Grex(clone1,clone2,"id");
        hybrid = hybrid.createHybrid(validFormat,"id",grex,producer);
        hybrid2 = hybrid.createHybrid(validFormat,"id2",null,null);

        assertEquals("Both should have the same Mother name",hybrid.getMotherName(),hybrid2.getMotherName());
        assertEquals("Both should have the same Father name",hybrid.getFatherName(),hybrid2.getFatherName());
        assertNotEquals("hybrid2 should not have a Grex",hybrid.getGrex(),hybrid2.getGrex());

    }







}
