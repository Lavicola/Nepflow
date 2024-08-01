package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public ResponseEntity<List<PollenOfferDateContainerDTO>> pollenexchangePollenoffersGet(List<LocalDate> dates) {
        List<PollenOfferStartDate> pollenOfferStartDates;
        List<PollenOfferDateContainerDTO> pollenOfferDateContainerDTO  =  new ArrayList<>();
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        pollenOfferStartDates = this.pollenExchangeService.getPollenOffersByDates(dates);
        if(pollenOfferStartDates ==null){
            return  ResponseEntity.ok(pollenOfferDateContainerDTO);
        }else{
            return  ResponseEntity.ok(pollenOfferStartDates.stream().map(row -> this.modelMapper.map(row,PollenOfferDateContainerDTO.class)).collect(Collectors.toList()));
        }

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

        return ResponseEntity.ok(this.modelMapper.map(trade, TradeDTO.class));

    }


    public ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeTradesGet() {
        List<Trade> trades;
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        trades = Stream.concat(this.pollenExchangeService.getAllInitiatedTradesFromUser(user).stream(),
                this.pollenExchangeService.getAllRequestedTradesFromUser(user).stream()).collect(Collectors.toList());

        return ResponseEntity.ok(trades.stream().map(trade -> this.modelMapper.map(trade,TradeDateContainerDTO.class)).collect(Collectors.toList()));

    }

    public ResponseEntity<List<String>> pollenexchangePollenoffersDatesGet() {
        return ResponseEntity.ok(this.pollenExchangeService.getAllDatesPollenOffer());

    }

    public ResponseEntity<List<String>> pollenexchangeTradesDatesGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    }