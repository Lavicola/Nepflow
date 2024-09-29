package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.PollenExchange.Model.*;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.PollenExchange.Repository.*;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service which implements the business Logic to provide and maintain
 * a Pollenexchange for Nepenthes.
 *
 * @author David Schmidt
 * @version 21. Nov 2024
 */

@Service
public class PollenExchangeServiceImpl implements PollenExchangeService {


    /**
     *
     */
    @Autowired
    private PollenOfferRepository pollenOfferRepository;

    /**
     *
     */
    @Autowired
    private TradeRepository tradeRepository;

    /**
     *
     */
    @Autowired
    private TradeRatingRepository tradeRatingRepository;


    /**
     *
     */
    @Autowired
    private PollenOfferStartDateRepository pollenOfferStartDateRepository;

    /**
     *
     */
    @Autowired
    private TradeStartDateRepository tradeStartDateRepository;

    /**
     * @param specimen
     * @return
     */
    @Override
    public PollenOffer closePollenOffer(final Specimen specimen) {
        PollenOffer pollenOffer;

        String pollenOfferId = this.pollenOfferRepository.getNewestPollenOfferIdBySpecimen(specimen.getUuid());
        if (pollenOfferId != null) {
            pollenOffer = this.pollenOfferRepository.findById(pollenOfferId).get();
        } else {
            return null;
        }
        if (pollenOffer.isOpen()) {
            pollenOffer.closePollenOffer();
            this.pollenOfferRepository.save(pollenOffer);
            return pollenOffer;
        } else {
            // should never happen
            return null;
        }
    }

    /**
     * @param dates dates in format MM-yyyy
     * @return The Containers containing all PollenOffers
     */
    @Override
    public List<PollenOfferStartDate> getPollenOffersByDates(final List<String> dates) {

        return this.pollenOfferStartDateRepository.getAllOpenPollenOffersUsingDatesAndExcludeUsers(dates, new ArrayList<>());

    }

    /**
     * @param specimen
     * @return
     */
    @Override
    @Transactional("transactionManager")
    public PollenOffer createOrReOpenPollenOffer(final Specimen specimen) {
        String pollenOfferId;
        PollenOffer pollenOffer;

        pollenOfferId = this.pollenOfferRepository.getNewestPollenOfferIdBySpecimen(specimen.getUuid());

        if (pollenOfferId == null) {
            // Create a new pollen offer if none exists
            pollenOffer = createNewPollenOffer(specimen);
            this.addPollenOfferToMonthYearContainer(pollenOffer);
        } else {
            pollenOffer = this.pollenOfferRepository.findById(pollenOfferId).get();

            // Open the existing pollen offer if valid
            if (pollenOffer.openPollenOffer()) {
                this.pollenOfferRepository.save(pollenOffer);
            } else {
                // Create a new pollen offer, if the existing one cannot be opened
                pollenOffer = createNewPollenOffer(specimen);
                this.addPollenOfferToMonthYearContainer(pollenOffer);
            }
        }
        return pollenOffer;

    }


    /**
     * @param specimen
     * @return
     */
    @Override
    @Transactional("transactionManager")

    public PollenOffer createNewPollenOffer(final Specimen specimen) {
        PollenOffer pollenOffer = new PollenOffer(specimen);
        addPollenOfferToMonthYearContainer(pollenOffer);
        return pollenOffer;
    }

    /**
     * @param pollenOffer
     */
    @Override
    @Transactional("transactionManager")
    public void addPollenOfferToMonthYearContainer(final PollenOffer pollenOffer) {
        PollenOfferStartDate pollenOfferStartDate = new PollenOfferStartDate();
        Optional<PollenOfferStartDate> rPollenOfferStartDate = this.pollenOfferStartDateRepository.findById(pollenOfferStartDate.getMonthYearId());
        if (rPollenOfferStartDate.isPresent()) {
            pollenOfferStartDate = rPollenOfferStartDate.get();
        }
        pollenOfferStartDate.addPollenOffer(pollenOffer);
        this.pollenOfferStartDateRepository.save(pollenOfferStartDate);

    }


    /**
     * @param username username
     * @param dates    dates in format MM-yyyy
     * @return The Containers containing all Trades
     */
    public List<TradeStartDate> getTradesByUsernameAndDates(final String username,
                                                            final List<String> dates) {
        if (dates == null || dates.isEmpty()) {
            return null;
        }
        return this.tradeStartDateRepository.getTradesByUsernameAndDates(username, dates);
    }


    /**
     * @param initiatedUser          user which initiated the trade
     * @param pollenOfferId          pollenofferId which the user offers
     * @param pollenOfferRequestedId pollenOffer Id which the user wants
     * @return
     */
    @Override
    @Transactional("transactionManager")

    public Trade openTrade(final User initiatedUser, final String pollenOfferId,
                           final String pollenOfferRequestedId) {
        Trade newTrade;
        Optional<PollenOffer> initiatedOffer = this.pollenOfferRepository.findById(pollenOfferId);
        Optional<PollenOffer> requestedOffer = this.pollenOfferRepository.findById(pollenOfferRequestedId);
        if (!(initiatedOffer.isPresent() && requestedOffer.isPresent())) {
            return null;
        }
        if (!initiatedOffer.get().pollenOfferBelongsToUser(initiatedUser)) {
            return null;
        }
        if (this.tradeRepository.tradeOrReverseTradeExists(pollenOfferId, pollenOfferRequestedId)) {
            // don´t  allow reverse Trade to prevent a Case where two Trades create two/one Grex
            return null;
        }
        newTrade = new Trade(initiatedOffer.get(), requestedOffer.get());
        newTrade = this.tradeRepository.save(newTrade);
        addTradeToMonthYearContainer(newTrade);
        return newTrade;
    }

    /**
     * @param trade trade to be added
     */
    @Override
    @Transactional("transactionManager")

    public void addTradeToMonthYearContainer(final Trade trade) {
        TradeStartDate tradeStartDate = new TradeStartDate();
        Optional<TradeStartDate> rPollenOfferStartDate = this.tradeStartDateRepository.findById(tradeStartDate.getMonthYearId());
        if (rPollenOfferStartDate.isPresent()) {
            tradeStartDate = rPollenOfferStartDate.get();
        }
        tradeStartDate.addTrade(trade);
        this.tradeStartDateRepository.save(tradeStartDate);

    }

    /**
     * @param user    user who wants to rejects a trade
     * @param tradeId id of the Trade
     * @return the refused trade
     */
    @Override
    @Transactional("transactionManager")

    public Trade refuseTrade(final User user, final String tradeId) {
        Optional<Trade> trade = this.tradeRepository.findById(tradeId);
        Trade trade1;
        if (!trade.isPresent()) {
            return null;
        }
        trade1 = trade.get();
        if (!trade1.isAllowedToAnswerTrade(user)) {
            return null;
        }
        if (trade.get().isTradeExpired()) {
            trade.get().setTradeToExpired();
        } else {
            trade.get().refuseTrade();
        }
        return this.tradeRepository.save(trade.get());

    }


    /**
     * @param user    user who wants to accept a trade
     * @param tradeId id of the Trade
     * @return the accepted trade or null in case user is not allowed to answer Trade.
     */
    @Override
    @Transactional("transactionManager")
    public Trade acceptTrade(final User user, final String tradeId) {
        Optional<Trade> trade = this.tradeRepository.findById(tradeId);
        Trade trade1;
        if (!trade.isPresent()) {
            return null;
        }
        trade1 = trade.get();
        if (!trade1.isAllowedToAnswerTrade(user)) {
            return null;
        }
        if (trade1.isTradeExpired()) {
            trade1.setTradeToExpired();
        } else {
            trade1.acceptTrade();
        }

        return this.tradeRepository.save(trade1);
    }

    /**
     * @param dates     dates in format MM-yyyy
     * @param usernames usernames to be excluded
     * @return all PollenOffer containers with their Pollenoffer excluding the specified Users
     */
    @Override
    @Transactional("transactionManager")

    public List<PollenOfferStartDate> getAllOpenPollenOffersByDateAndExcludeUsernames(final List<String> dates, final List<String> usernames) {
        return this.pollenOfferStartDateRepository.getAllOpenPollenOffersUsingDatesAndExcludeUsers(dates, usernames);
    }


    /**
     * @return all existing Dates of Trades in Format MM-yyyy
     */
    @Override
    @Transactional("transactionManager")
    public List<String> getAllDatesTrades() {
        return tradeStartDateRepository.getTradeDates();
    }

    /**
     * @return all existing Dates of PollenOffers in Format MM-yyyy
     */
    @Override
    @Transactional("transactionManager")
    public List<String> getAllDatesPollenOffer() {
        return pollenOfferStartDateRepository.getPollenOfferStartDates();
    }

    /**
     * @param id id of the trade
     * @return the Trade
     */
    @Override
    public Trade getTradeById(final String id) {
        Optional<Trade> trade = this.tradeRepository.findById(id);

        return trade.orElse(null);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public List<Trade> getTradesWithRating(final String username) {
        return this.tradeRepository.getTradesWithTradeRatingsByUsername(username);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public List<PollenOfferSpeciesStatisticsDTOProjection> getPollenOfferStatistics(final String username) {
        return this.pollenOfferRepository.getPollenOfferStatisticsBySpecimen(username);
    }
}
