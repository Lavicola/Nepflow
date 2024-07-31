package com.nepflow.PollenExchange.Service;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.GrowlistManagement.Service.Growlistservice;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeStartDate;
import com.nepflow.PollenExchange.Repository.PollenOfferRepository;
import com.nepflow.PollenExchange.Repository.PollenOfferStartDateRepository;
import com.nepflow.PollenExchange.Repository.TradeRepository;
import com.nepflow.PollenExchange.Repository.TradeStartDateRepository;
import com.nepflow.UserManagement.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PollenExchangeServiceImpl implements PollenExchangeService {


    // in order to prevent user opening repeatedly new offers
    final private int MIN_DURATION_POLLENOFFER = 30;

    @Autowired
    PollenOfferRepository pollenOfferRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    Growlistservice growlistservice;


    @Autowired
    PollenOfferStartDateRepository pollenOfferStartDateRepository;

    @Autowired
    TradeStartDateRepository tradeStartDateRepository;

    @Override
    public PollenOffer closePollenOffer(Specimen specimen, User user) {
        String pollenofferId = this.pollenOfferRepository.getOpenPollenOfferId(specimen.getUuid(),
                LocalDate.now().toString(),
                LocalDate.now().plusDays(MIN_DURATION_POLLENOFFER).toString());
        if (pollenofferId != null) {
            PollenOffer pollenOffer = this.pollenOfferRepository.findById(pollenofferId).get();
            pollenOffer.closePollenOffer();
            return this.pollenOfferRepository.save(pollenOffer);
        }


        return null;
    }

    @Override
    public PollenOffer createOrReOpenPollenOffer(Specimen specimen, User user) {
        PollenOffer pollenOffer;
        if (this.pollenOfferRepository.pollenOfferExists(specimen.getUuid())) {
            // open offer already exists
            return null;
        }
        if (specimen.getSexAsString().equals("")) {
            return null;
        }

        if (!this.growlistservice.belongsSpecimenToUser(user.getOAuthId(), specimen.getUuid())) {
            return null;
        }

        String pollenOfferId = this.pollenOfferRepository.getIdOfclosedPollenOfferInRangeExists(specimen.getUuid(), LocalDate.now().toString(), LocalDate.now().plusDays(MIN_DURATION_POLLENOFFER).toString());
        if (pollenOfferId != null) {
            pollenOffer = this.pollenOfferRepository.findById(pollenOfferId).get();
            pollenOffer.openPollenOffer();
            return this.pollenOfferRepository.save(pollenOffer);

        } else {
            pollenOffer = new PollenOffer(user, specimen);
            pollenOffer = this.pollenOfferRepository.save(pollenOffer);
            addPollenOfferToMonthYear(pollenOffer);
            return pollenOffer;
        }


    }

    @Override
    public void addPollenOfferToMonthYear(PollenOffer pollenOffer) {
        PollenOfferStartDate pollenOfferStartDate = new PollenOfferStartDate();
        Optional<PollenOfferStartDate> rPollenOfferStartDate = this.pollenOfferStartDateRepository.findById(pollenOfferStartDate.getMonthYearId());
        if(rPollenOfferStartDate.isPresent()){
            pollenOfferStartDate = rPollenOfferStartDate.get();
        }
        pollenOfferStartDate.addPollenOffer(pollenOffer);
        this.pollenOfferStartDateRepository.save(pollenOfferStartDate);

    }


    @Override
    public List<PollenOffer> getAllPollenOffersBySexFromOtherUsers(String username, String sexAsString) {
        return this.pollenOfferRepository.getAllOpenPollenOffersBySexExceptOwn(username, sexAsString);
    }

    @Override
    public List<PollenOffer> getAllPollenOffersFromOtherUsers(String username) {
        return this.pollenOfferRepository.getAllOpenPollenOffersExceptOwn(username);
    }

    @Override
    public List<Trade> getAllTradesFromUser(String userId) {
        return this.tradeRepository.findAllTradesForUser(userId);
    }


    @Override
    public Trade openTrade(User initiatedUser, String pollenOfferId, String pollenOfferRequested) {
        Trade newTrade;
        Optional<PollenOffer> initiatedOffer = this.pollenOfferRepository.findById(pollenOfferId);
        Optional<PollenOffer> requestedOffer = this.pollenOfferRepository.findById(pollenOfferRequested);
        if (!(initiatedOffer.isPresent() && requestedOffer.isPresent())) {
            return null;
        }
        if (!initiatedOffer.get().getUser().equals(initiatedUser)) {
            return null;
        }
        newTrade = new Trade(initiatedUser, initiatedOffer.get(), requestedOffer.get(), requestedOffer.get().getUser());
        newTrade = this.tradeRepository.save(newTrade);
        addTradeToMotnYear(newTrade );
        return newTrade;
    }

    @Override
    public void addTradeToMotnYear(Trade trade) {
        TradeStartDate tradeStartDate = new TradeStartDate();
        Optional<TradeStartDate> rPollenOfferStartDate = this.tradeStartDateRepository.findById(tradeStartDate.getMonthYearId());
        if(rPollenOfferStartDate.isPresent()){
            tradeStartDate = rPollenOfferStartDate.get();
        }
        tradeStartDate.addTrade(trade);
        this.tradeStartDateRepository.save(tradeStartDate);

    }

    @Override
    public Trade refuseTrade(User user, String tradeId) {
        Optional<Trade> trade = this.tradeRepository.findById(tradeId);
        if (!trade.isPresent()) {
            return null;
        }
        if (!trade.get().getUserWhoAnswersTrade().equals(user)) {
            return null;
        }
        trade.get().refuseTrade();
        return this.tradeRepository.save(trade.get());

    }

    @Override
    public Trade acceptTrade(User user, String tradeId) {
        Optional<Trade> trade = this.tradeRepository.findById(tradeId);
        if (!trade.isPresent()) {
            return null;
        }
        if (!trade.get().getUserWhoAnswersTrade().equals(user)) {
            return null;
        }
        trade.get().acceptTrade();
        return this.tradeRepository.save(trade.get());
    }

    @Override
    public List<Trade> getAllInitiatedTradesFromUser(User user) {
        return user != null ? this.tradeRepository.findInitiatedTrades(user.getOAuthId()) : null;
    }

    @Override
    public List<Trade> getAllRequestedTradesFromUser(User user) {
        return null;
    }


}
