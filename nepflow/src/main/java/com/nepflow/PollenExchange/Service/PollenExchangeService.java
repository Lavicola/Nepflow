package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.*;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.UserManagement.Model.User;

import java.util.List;

/**
 * Service which defines the business Logic to provide and maintain
 * a Pollenexchange for Nepenthes.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

public interface PollenExchangeService {

    /**
     * @param specimen Specimen which is or will be referenced in the PollenOffer
     * @return newly created PollenOffer or opened PollenOffer
     */
    PollenOffer createOrReOpenPollenOffer(Specimen specimen);

    /**
     * @param specimen Specimen which will be referenced in the PollenOffer
     * @return newly created PollenOffer
     */
    PollenOffer createNewPollenOffer(Specimen specimen);

    /**
     * @param pollenOffer pollenOffer to be added
     */
    void addPollenOfferToMonthYearContainer(PollenOffer pollenOffer);

    /**
     * @param specimen specimen which is referenced in the PollenOffer
     * @return the newly closed PollenOffer
     */
    PollenOffer closePollenOffer(Specimen specimen);

    /**
     * @param dates dates in format MM-yyyy
     * @return The Containers containing all PollenOffers
     */
    List<PollenOfferStartDate> getPollenOffersByDates(List<String> dates);


    /**
     * @param username username
     * @param dates    dates in format MM-yyyy
     * @return The Containers containing all Trades
     */
    List<TradeStartDate> getTradesByUsernameAndDates(String username, List<String> dates);


    /**
     * @param user                   user which initiated the trade
     * @param pollenOfferId          pollenofferId which the user offers
     * @param pollenOfferRequestedId pollenOffer Id which the user wants
     * @return the opened Trade
     */
    Trade openTrade(User user, String pollenOfferId, String pollenOfferRequestedId);

    /**
     * @param trade trade to be added
     */
    void addTradeToMonthYearContainer(Trade trade);

    /**
     * @param user    user who wants to rejects a trade
     * @param tradeId id of the Trade
     * @return the refused trade
     */
    Trade refuseTrade(User user, String tradeId);

    /**
     * @param user    user who wants to accept a trade
     * @param tradeId id of the Trade
     * @return the accepted trade
     */
    Trade acceptTrade(User user, String tradeId);

    /**
     * @param dates     dates in format MM-yyyy
     * @param usernames usernames to be excluded
     * @return all PollenOffer containers with their Pollenoffer excluding the specified Users
     */
    List<PollenOfferStartDate> getAllOpenPollenOffersByDateAndExcludeUsernames(List<String> dates, List<String> usernames);

    /**
     * @return all existing Dates of Trades in Format MM-yyyy
     */
    List<String> getAllDatesTrades();

    /**
     * @return all existing Dates of PollenOffers in Format MM-yyyy
     */
    List<String> getAllDatesPollenOffer();

    /**
     * @param id id of the trade
     * @return the Trade
     */
    Trade getTradeById(String id);

    /**
     * TODO might need refactoring
     *
     * @param username
     * @return
     */
    List<Trade> getTradesWithRating(String username);


    /**
     * @param username username the statistics shall be loaded
     * @return PollenOfferSpeciesStatisticsDTOProjection
     */
    List<PollenOfferSpeciesStatisticsDTOProjection> getPollenOfferStatistics(String username);


}
