package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeStartDate;
import com.nepflow.UserManagement.Model.User;

import java.util.List;

public interface PollenExchangeService {

    PollenOffer createOrReOpenPollenOffer(Specimen specimen, User user);
    void addPollenOfferToMonthYear(PollenOffer pollenOffer);

    PollenOffer closePollenOffer(Specimen specimen,User user);

    List<PollenOffer> getAllPollenOffersBySexFromOtherUsers(String username,String sexAsString);

    List<PollenOffer> getAllPollenOffersFromOtherUsers(String username);

    // either as initiator or requester
    List<Trade> getAllTradesFromUser(String userId);
    Trade openTrade(User user,String pollenOfferId,String pollenOfferRequested);
    void addTradeToMotnYear(Trade trade);

    Trade refuseTrade(User user,String tradeId);

    Trade acceptTrade(User user,String tradeId);


    List<Trade> getAllInitiatedTradesFromUser(User user);

    // trades the user needs to answer
    List<Trade> getAllRequestedTradesFromUser(User user);

}
