package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TradeTest {

    Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
    Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;
    PollenOffer pollenOffer  = new PollenOffer(specimenF);
    PollenOffer pollenOffer2  = new PollenOffer(specimenM);


    @Test
    public void validTradeTest() {
        new Trade(pollenOffer,pollenOffer2);;
    }

    @Test
    public void isAllowedToAnswerTradeTest() {
        Trade trade = new Trade(pollenOffer,pollenOffer2);

        assertTrue(trade.isAllowedToAnswerTrade(pollenOffer2.getUser()));
        assertFalse(trade.isAllowedToAnswerTrade(pollenOffer.getUser()));




    }




}
