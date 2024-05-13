package com.nepflow.NepenthesManagement.Model;

import com.nepflow.NepenthesManagement.Repository.CloneRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import javax.xml.validation.Validator;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class HybridTest {


    String nep1 = "villosa";
    String nep2 = "lowii";
    String validFormat = String.format("%s x %s".formatted(nep1,nep2));


    @BeforeEach
    public void fillCloneMap(){
        Clone.validPlants.add(nep1);
        Clone.validPlants.add(nep2);

    }

    @Test
    public void nepenthesNotExistingTest() {
        Clone.validPlants = new HashSet<>();
        Clone.validPlants.add(nep1);

        assertThrows(AssertionError.class, () -> {
            new Hybrid(validFormat, "ddd", null);
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

        new Hybrid(validFormat, "ddd", null);
        assertThrows(AssertionError.class, () -> {
            new Hybrid(invalidFormat, "ddd");
        });
        assertThrows(AssertionError.class, () -> {
            new Hybrid(invalidFormat2, "ddd");
        });
        assertThrows(AssertionError.class, () -> {
            new Hybrid(invalidFormat3, "ddd");
        });
        assertThrows(AssertionError.class, () -> {
            new Hybrid(invalidFormat4, "ddd");
        });
        assertThrows(AssertionError.class, () -> {
            new Hybrid(invalidFormat5, "ddd");
        });
    }
    @Test
    public void hybridGrexTest() {
        SpeciesClone speciesClone = new IVClone(nep1,"111",new Nepenthes(nep1));
        SpeciesClone speciesClone2 = new IVClone(nep2,"112",new Nepenthes(nep2));
        Grex grex = new Grex(speciesClone,speciesClone2,"id");
        assertThrows(AssertionError.class, () -> {
            new Hybrid(validFormat, "ddd",null);
        });
    }

    @Test
    public void hybridNameAndGrexEqualTest() {
        SpeciesClone speciesClone = new IVClone(nep1,"111",new Nepenthes(nep1));
        SpeciesClone speciesClone2 = new IVClone(nep2,"112",new Nepenthes(nep2));
        Grex grex = new Grex(speciesClone,speciesClone2,"id");
        Hybrid hybrid = new Hybrid("name","id1",grex);
        Hybrid hybrid1 = new Hybrid(validFormat,"id2");

        assertEquals("Both father should be equal",hybrid.getFatherName(),hybrid1.getFatherName());
        assertEquals("Both Mother should be equal",hybrid.getMotherName(),hybrid1.getMotherName());
    }

    @Test
    public void hybridNameTest() {
        Hybrid hybrid = new Hybrid(validFormat,"id2");
        assertEquals("validFormat and Hybridname should be the same",validFormat,hybrid.getName());

    }

}
