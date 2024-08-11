package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import org.junit.jupiter.api.Test;

public class TradeTest {

    Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
    Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;
    PollenOffer pollenOffer  = new PollenOffer(specimenF);
    PollenOffer pollenOffer2  = new PollenOffer(specimenM);


    @Test
    public void validTradeTest() {
        new Trade(pollenOffer,pollenOffer2);;
    }



}
