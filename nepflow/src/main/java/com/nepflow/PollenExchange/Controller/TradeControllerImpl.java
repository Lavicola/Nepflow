package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.*;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeRating;
import com.nepflow.PollenExchange.Model.TradeStartDate;
import com.nepflow.PollenExchange.Projection.TradeStatus;
import com.nepflow.PollenExchange.Projection.UserRating;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import com.nepflow.UserManagement.Model.User;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TradeControllerImpl implements TradesApiDelegate {
    @Autowired
    @Qualifier("modelMapperPollenExchange")
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

    public ResponseEntity<TradeDTO> pollenexchangeTradeTradeIdPut(String tradeId, TradeAnswerDTO tradeAnswerDTO) {
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


    public ResponseEntity<List<TradeDateContainerDTO>> pollenexchangeTradesGet(List<String> dates) {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<TradeStartDate> tradesByMonths = this.pollenExchangeService.getTradesByUsernameAndDates(user.getUsername(), dates);

        return ResponseEntity.ok(tradesByMonths.stream().map(tradeStartDate -> this.modelMapper.map(tradeStartDate, TradeDateContainerDTO.class)).collect(Collectors.toList()));


    }


    public ResponseEntity<List<String>> pollenexchangeTradesDatesGet() {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }


        return ResponseEntity.ok(this.pollenExchangeService.getAllDatesTradesOfUser(user.getUsername()));

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

    public ResponseEntity<List<TradeDTO>> pollenexchangeTradesRateableGet() {
        User user = this.authenticationService.getAuthenticatedUser();
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        List<Trade> trades = this.pollenExchangeService.getTradesUserNeedsToRate(user.getUsername());
        if (trades == null) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.ok(trades.stream().map(trade -> this.modelMapper.map(trade, TradeDTO.class)).collect(Collectors.toList()));

    }


    public ResponseEntity<NewRatingResponseDTO> tradesTradeIdRatingPost(String tradeId,
                                                                        String comment,
                                                                        MultipartFile file,
                                                                        com.nepflow.PollenExchange.Model.TradeRating.RATING reviewType) {
        User user = this.authenticationService.getAuthenticatedUser();
        TradeRating tradeRating;
        NewRatingResponseDTO response = new NewRatingResponseDTO();

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        tradeRating = this.pollenExchangeService.setRatingForTrade(tradeId, comment, file, reviewType, user);
        if (tradeRating == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.modelMapper.map(tradeRating, NewRatingResponseDTO.class));

    }

    public ResponseEntity<RatingPage> tradesUsernameRatingsGet(String username,
                                                               Pageable pageable) {

        Page<UserRating> userRatings = this.pollenExchangeService.getUserRatings(username, pageable);
        if (userRatings != null) {
            RatingPage ratingPage = this.modelMapper.map(userRatings, RatingPage.class);
            ratingPage.setRatings(Arrays.asList(this.modelMapper.map(userRatings.getContent(), RatingDTO[].class)));
            return ResponseEntity.status(HttpStatus.OK).body(ratingPage);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    public ResponseEntity<List<TradeStatusDTO>> pollenexchangeUsernameTradesStatusGet(String username) {
        List<TradeStatusDTO> tradeStatusDTO;

        if (username != null && !username.equals("")) {
            List<TradeStatus> ratings = this.pollenExchangeService.getReceivedRatingsStatus(username);
            tradeStatusDTO = Arrays.asList(this.modelMapper.map(ratings, TradeStatusDTO[].class));
        } else {
            tradeStatusDTO = new ArrayList<>(0);
        }

        return ResponseEntity.status(HttpStatus.OK).body(tradeStatusDTO);


    }


}
