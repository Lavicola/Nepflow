package com.nepflow.PollenExchange.Controller;

import com.nepflow.PollenExchange.Dto.PollenOfferDateContainerDTO;
import com.nepflow.PollenExchange.Dto.PollenOfferSpeciesStatisticsDTO;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import com.nepflow.UserManagement.Service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller

public class PollenOffersControllerImpl implements PollenoffersApiDelegate {

    @Autowired
    @Qualifier("modelMapperPollenExchange")
    ModelMapper modelMapper;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PollenExchangeService pollenExchangeService;

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

    public ResponseEntity<List<PollenOfferSpeciesStatisticsDTO>> pollenexchangeUsernamePollenoffersStatisticsGet(String username) {
        List<PollenOfferSpeciesStatisticsDTOProjection> statistics = this.pollenExchangeService.getPollenOfferStatistics(username);
        if (statistics.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(statistics.stream().map(statistic ->
                this.modelMapper.map(statistic, PollenOfferSpeciesStatisticsDTO.class)).collect(Collectors.toList()));

    }

}
