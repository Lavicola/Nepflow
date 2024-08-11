package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.PollenExchange.Exception.PollenOfferSpecimenNoSexException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class PollenOfferTest {

    @Test
    public void PollenOfferNoSexTest(){
        Specimen specimen =  LabelCloneDefinitions.specimenUser3NoSex;
        assertThrows(PollenOfferSpecimenNoSexException.class, () -> {
            new PollenOffer(specimen);;
        });
    }


    @Test
    public void PollenOfferCloseAndOpenOfferTest(){
        Specimen specimen =  LabelCloneDefinitions.specimenUser2Female;
        PollenOffer offer  = new PollenOffer(specimen);
        assertNull(offer.getEndDateOrNull());
        assertTrue(offer.isOpen());
        assertNotNull(offer.getUser());
        offer.closePollenOffer();
        assertNotNull(offer.getEndDateOrNull());
        assertTrue(!offer.isOpen());
        assertNotNull(offer.getUser());
        offer.openPollenOffer();
        assertNull(offer.getEndDateOrNull());
        assertTrue(offer.isOpen());
        assertNotNull(offer.getUser());



    }

}
