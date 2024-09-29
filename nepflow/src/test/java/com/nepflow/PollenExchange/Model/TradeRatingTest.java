package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TradeRatingTest {


    /**
     * This Test checks if the logic within the model is valid and only allows
     * to rate once the time elapsed and the current rating is pending
     */
    @Test
    public void isRateableTest() {
        TradeRating rating = new TradeRating(new User("", ""));
        LocalDate waitingTimeInDays = LocalDate.now().plusDays(TradeRating.MIN_AGE_TO_RATE_IN_DAYS + 1);
        Assertions.assertFalse(rating.rateTradeAsSuccess(null));
        try (MockedStatic mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(waitingTimeInDays);
            assertTrue(rating.rateTradeAsSuccess(null));
            assertFalse(rating.rateTradeAsFailure(null));

        }
    }


}
