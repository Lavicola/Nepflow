package com.nepflow.PollenExchange.Model;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.UserManagement.Model.User;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

public class PollenStartDateTest {



    @Test
    public void PollenOfferStartDatePastDateTest() {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        PollenOfferStartDate thisMonthTrades;
        PollenOfferStartDate nextMonthTrades;
        User user = LabelCloneDefinitions.user1;
        User user2 = LabelCloneDefinitions.user2;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;
        PollenOffer pollenOffer = new PollenOffer(specimenF);
        PollenOffer pollenOffer2 = new PollenOffer(specimenM);
        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(nextMonth);
        }


    }
}