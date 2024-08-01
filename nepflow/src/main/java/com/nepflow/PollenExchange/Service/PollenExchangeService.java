package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.UserManagement.Model.User;

import java.time.LocalDate;
import java.util.List;

public interface PollenExchangeService {

    PollenOffer createOrReOpenPollenOffer(Specimen specimen, User user);
    void addPollenOfferToMonthYearContainer(PollenOffer pollenOffer);

    PollenOffer closePollenOffer(Specimen specimen,User user);

    List<PollenOfferStartDate> getPollenOffersByDates(List<LocalDate> dates);

    // either as initiator or requester
    List<Trade> getAllTradesFromUser(String userId);
    Trade openTrade(User user,String pollenOfferId,String pollenOfferRequested);
    void addTradeToMonthYearContainer(Trade trade);

    Trade refuseTrade(User user,String tradeId);

    Trade acceptTrade(User user,String tradeId);


    List<Trade> getAllInitiatedTradesFromUser(User user);

    // trades the user needs to answer
    List<Trade> getAllRequestedTradesFromUser(User user);

    List<String> getAllDatesTrades();

    List<String> getAllDatesPollenOffer();

}
