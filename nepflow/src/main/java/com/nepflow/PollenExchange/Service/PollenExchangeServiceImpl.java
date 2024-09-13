package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
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

@Service
public class PollenExchangeServiceImpl implements PollenExchangeService {


    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    TradeRatingRepository tradeRatingRepository;

    @Autowired
    Growlistservice growlistservice;


    @Autowired
    PollenOfferStartDateRepository pollenOfferStartDateRepository;

    @Autowired
    TradeStartDateRepository tradeStartDateRepository;

    @Override
    public PollenOffer closePollenOffer(Specimen specimen) {
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

    @Override
    public List<PollenOfferStartDate> getPollenOffersByDates(List<String> dates) {

        return this.pollenOfferStartDateRepository.getAllOpenPollenOffersUsingDatesAndExcludeUsers(dates, new ArrayList<>());

    }

    @Override
    @Transactional("transactionManager")
    public PollenOffer createOrReOpenPollenOffer(Specimen specimen) {
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


    @Override
    @Transactional("transactionManager")

    public PollenOffer createNewPollenOffer(Specimen specimen) {
        PollenOffer pollenOffer = new PollenOffer(specimen);
        addPollenOfferToMonthYearContainer(pollenOffer);
        return pollenOffer;
    }

    @Override
    @Transactional("transactionManager")
    public void addPollenOfferToMonthYearContainer(PollenOffer pollenOffer) {
        PollenOfferStartDate pollenOfferStartDate = new PollenOfferStartDate();
        Optional<PollenOfferStartDate> rPollenOfferStartDate = this.pollenOfferStartDateRepository.findById(pollenOfferStartDate.getMonthYearId());
        if (rPollenOfferStartDate.isPresent()) {
            pollenOfferStartDate = rPollenOfferStartDate.get();
        }
        pollenOfferStartDate.addPollenOffer(pollenOffer);
        this.pollenOfferStartDateRepository.save(pollenOfferStartDate);

    }


    public List<TradeStartDate> getTradesByUsernameAndDates(String username, List<String> dates) {
        if (dates == null || dates.isEmpty()) {
            return null;
        }
        return this.tradeStartDateRepository.getTradesByUsernameAndDates(username, dates);
    }


    @Override
    @Transactional("transactionManager")

    public Trade openTrade(User initiatedUser, String pollenOfferId, String pollenOfferRequested) {
        Trade newTrade;
        Optional<PollenOffer> initiatedOffer = this.pollenOfferRepository.findById(pollenOfferId);
        Optional<PollenOffer> requestedOffer = this.pollenOfferRepository.findById(pollenOfferRequested);
        if (!(initiatedOffer.isPresent() && requestedOffer.isPresent())) {
            return null;
        }
        if (!initiatedOffer.get().pollenOfferBelongsToUser(initiatedUser)) {
            return null;
        }
        if (this.tradeRepository.tradeOrReverseTradeExists(pollenOfferId, pollenOfferRequested)) {
            // don´t  allow reverse Trade to prevent a Case where two Trades create two/one Grex
            return null;
        }
        newTrade = new Trade(initiatedOffer.get(), requestedOffer.get());
        newTrade = this.tradeRepository.save(newTrade);
        addTradeToMonthYearContainer(newTrade);
        return newTrade;
    }

    @Override
    @Transactional("transactionManager")

    public void addTradeToMonthYearContainer(Trade trade) {
        TradeStartDate tradeStartDate = new TradeStartDate();
        Optional<TradeStartDate> rPollenOfferStartDate = this.tradeStartDateRepository.findById(tradeStartDate.getMonthYearId());
        if (rPollenOfferStartDate.isPresent()) {
            tradeStartDate = rPollenOfferStartDate.get();
        }
        tradeStartDate.addTrade(trade);
        this.tradeStartDateRepository.save(tradeStartDate);

    }

    @Override
    @Transactional("transactionManager")

    public Trade refuseTrade(User user, String tradeId) {
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

    @Override
    @Transactional("transactionManager")

    public void createTradeRatings(User user1,User user2,Trade trade){
        List<TradeRating> tradeRatings = new ArrayList<>(2);
        tradeRatings.add(new TradeRating(user1,trade));
        tradeRatings.add(new TradeRating(user2,trade));
        this.tradeRatingRepository.saveAll(tradeRatings);
    }

    @Override
    @Transactional("transactionManager")
    public Trade acceptTradeAndCreateRatings(User user, String tradeId) {
        Trade trade = this.acceptTrade(user,tradeId);
        if(trade != null){
            this.createTradeRatings(trade.getUserWhoInitiatedTrade(),trade.getUserWhoAnswersTrade(),trade);
        }else{
            return null;
        }
        return trade;
    }

    @Override
    @Transactional("transactionManager")
    public Trade acceptTrade(User user, String tradeId) {
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

    @Override
    @Transactional("transactionManager")

    public List<PollenOfferStartDate> getAllOpenPollenOffersByDateAndExcludeUsernames(List<String> dates, List<String> usernames) {
        return this.pollenOfferStartDateRepository.getAllOpenPollenOffersUsingDatesAndExcludeUsers(dates, usernames);
    }


    @Override
    @Transactional("transactionManager")
    public List<String> getAllDatesTrades() {
        return tradeStartDateRepository.getTradeDates();
    }

    @Override
    @Transactional("transactionManager")
    public List<String> getAllDatesPollenOffer() {
        return pollenOfferStartDateRepository.getPollenOfferStartDates();
    }

    @Override
    public Trade getTradeById(String id) {
        Optional<Trade> trade = this.tradeRepository.findById(id);

        return trade.orElse(null);
    }

    @Override
    public List<TradeRating> getTradesStatusWithDate(String username) {
        return this.tradeRatingRepository.getTradeRatingByUsername(username);
    }
    @Override
    public List<PollenOfferSpeciesStatisticsDTOProjection> getPollenOfferStatistics(String username){
        return this.pollenOfferRepository.getPollenOfferStatisticsBySpecimen(username);
    }
}
