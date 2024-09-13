package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.*;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.UserManagement.Model.User;

import java.util.List;

public interface PollenExchangeService {

    PollenOffer createOrReOpenPollenOffer(Specimen specimen);

    PollenOffer createNewPollenOffer(Specimen specimen);

    void addPollenOfferToMonthYearContainer(PollenOffer pollenOffer);

    PollenOffer closePollenOffer(Specimen specimen);

    List<PollenOfferStartDate> getPollenOffersByDates(List<String> dates);



    List<TradeStartDate> getTradesByUsernameAndDates(String username, List<String>  dates);


    Trade openTrade(User user,String pollenOfferId,String pollenOfferRequested);
    void addTradeToMonthYearContainer(Trade trade);

    Trade refuseTrade(User user,String tradeId);

    Trade acceptTrade(User user,String tradeId);

    List<PollenOfferStartDate> getAllOpenPollenOffersByDateAndExcludeUsernames(List<String> dates, List<String> usernames);

    List<String> getAllDatesTrades();

    List<String> getAllDatesPollenOffer();

    Trade getTradeById(String id);

    List<TradeRating> getTradesStatusWithDate(String username);

    void createTradeRatings(User user1,User user2,Trade trade);

    Trade acceptTradeAndCreateRatings(User user,String tradeId);

    List<PollenOfferSpeciesStatisticsDTOProjection> getPollenOfferStatistics(String username);


    }
