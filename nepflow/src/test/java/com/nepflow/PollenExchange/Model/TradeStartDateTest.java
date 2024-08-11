package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class TradeStartDateTest {


    @Test
    public void TradeStartDateTradePastDateTest(){
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        TradeStartDate thisMonthTrades ;
        TradeStartDate nextMonthTrades ;
        Trade thisMonthTrade;
        Trade nextMonthTrade;
        Specimen specimenM =   LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;
        PollenOffer pollenOffer  = new PollenOffer(specimenF);
        PollenOffer pollenOffer2  = new PollenOffer(specimenM);
        thisMonthTrades = new TradeStartDate();
        thisMonthTrade = new Trade(pollenOffer,pollenOffer2);

        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextMonth);
            pollenOffer  = new PollenOffer(specimenF);
            pollenOffer2  = new PollenOffer(specimenM);
            nextMonthTrades = new TradeStartDate();
            nextMonthTrade  = new Trade(pollenOffer,pollenOffer2);

        }

        assertTrue(thisMonthTrades.addTrade(thisMonthTrade));
        assertFalse(thisMonthTrades.addTrade(nextMonthTrade));

        assertTrue(nextMonthTrades.addTrade(nextMonthTrade));
        assertFalse(nextMonthTrades.addTrade(thisMonthTrade));
        assertEquals(thisMonthTrades.getTrades().size(),nextMonthTrades.getTrades().size());

    }

}
