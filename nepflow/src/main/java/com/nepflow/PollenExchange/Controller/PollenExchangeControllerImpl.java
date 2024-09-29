package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeRating;
import com.nepflow.PollenExchange.Model.TradeStartDate;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.PollenExchange.Repository.PollenOfferRepository;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PollenExchangeControllerImpl implements PollenexchangeApiDelegate {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PollenExchangeService pollenExchangeService;


    public ResponseEntity<TradeDTO> pollenexchangeCreateTradePost(TradeCreationDTO tradeCreationDTO) {
        User user = this.authenticationService.getAuthenticatedUser();
        Trade trade;
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        trade = this.pollenExchangeService.openTrade(user, tradeCreationDTO.getUserInitiatedOffer(), tradeCreationDTO.getUserRequestedOffer());
        if (trade == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(this.modelMapper.map(trade, TradeDTO.class));


    }

    public ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdPut(String tradeId,
                                                                  TradeAnswerDTO tradeAnswerDTO) {
        Trade trade;
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        if (tradeAnswerDTO.getAcceptTrade()) {
            trade = this.pollenExchangeService.acceptTrade(user, tradeId);
        } else {
            trade = this.pollenExchangeService.refuseTrade(user, tradeId);
        }

        if (trade == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        if (trade.isTradeExpired()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(this.modelMapper.map(trade, TradeDTO.class));
        }

        return ResponseEntity.ok(this.modelMapper.map(trade, TradeDTO.class));

    }


    public ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeUsernameTradesGet(String username,
                                                                                       List<String> dates) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null || !user.getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<TradeStartDate> tradesByMonths = this.pollenExchangeService.getTradesByUsernameAndDates(user.getUsername(), dates);

        return ResponseEntity.ok(tradesByMonths.stream().map(tradeStartDate -> this.modelMapper.map(tradeStartDate,
                TradeDateContainerDTO.class)).collect(Collectors.toList()));


    }


    public ResponseEntity<List<PollenOfferDateContainerDTO>> pollenexchangePollenoffersOpenGet(List<String> dates) {
        List<PollenOfferStartDate> pollenOfferStartDates = this.pollenExchangeService.getAllOpenPollenOffersByDateAndExcludeUsernames(dates, new ArrayList<>());
        if (pollenOfferStartDates != null) {

            return ResponseEntity.ok(pollenOfferStartDates.stream().map(offerContainer -> this.modelMapper.map(offerContainer,
                    PollenOfferDateContainerDTO.class)).collect(Collectors.toList()));
        } else {
            return ResponseEntity.internalServerError().body(null);

        }

    }

    public ResponseEntity<List<String>> pollenexchangePollenoffersDatesGet() {
        return ResponseEntity.ok(this.pollenExchangeService.getAllDatesPollenOffer());

    }

    public ResponseEntity<List<String>> pollenexchangeTradesDatesGet() {
        return ResponseEntity.ok(this.pollenExchangeService.getAllDatesTrades());

    }

    public ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdGet(String tradeId) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        Trade trade = this.pollenExchangeService.getTradeById(tradeId);
        if (trade == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        TradeDTO tradeDTO = this.modelMapper.map(trade, TradeDTO.class);

        if (trade.isUserPartOfTrade(user)) {
            return ResponseEntity.status(HttpStatus.OK).body(this.modelMapper.map(trade, TradeDTO.class));
        } else {
            UserDTO privateUser = new UserDTO();
            tradeDTO.getInitiatedOffer().setUser(privateUser);
            tradeDTO.getRequestedOffer().setUser(privateUser);
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.modelMapper.map(trade, TradeDTO.class));


    }

    @Autowired
    PollenOfferRepository pollenOfferRepository;

    public ResponseEntity<List<TradeRatingDTO>> pollenexchangeUsernameTradeStatusGet(String username) {
        List<Trade> ratings = this.pollenExchangeService.getTradesWithRating(username);

        if (ratings == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(ratings.stream().map(rating ->
                this.modelMapper.map(rating, TradeRatingDTO.class)).collect(Collectors.toList()));
    }

    public ResponseEntity<List<PollenOfferSpeciesStatisticsDTO>> pollenexchangeUsernamePollenoffersStatisticsGet(String username) {
        List<PollenOfferSpeciesStatisticsDTOProjection> statistics = this.pollenExchangeService.getPollenOfferStatistics(username);
        if (statistics.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(statistics.stream().map(statistic ->
                this.modelMapper.map(statistic, PollenOfferSpeciesStatisticsDTO.class)).collect(Collectors.toList()));

    }
}