package com.nepflow.PollenExchange.ModelMapper;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.ModelMapperConfig;
import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.PollenOfferDateContainerDTO;
import com.nepflow.PollenExchange.Dto.TradeDTO;
import com.nepflow.PollenExchange.Dto.TradeDateContainerDTO;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
import com.nepflow.PollenExchange.Model.Trade;
import com.nepflow.PollenExchange.Model.TradeStartDate;
import com.nepflow.UserManagement.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = ModelMapperConfig.class)
@ExtendWith(SpringExtension.class)
public class PollenExchangeModelMapperTest {


    @Autowired
    ModelMapper modelMapper;

    @Test
    public void pollenOfferToPollenOfferDTOTest() {
        PollenOffer pollenOffer;
        PollenOfferDTO pollenOfferDTO;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        pollenOffer = new PollenOffer(specimenM);
        pollenOfferDTO = this.modelMapper.map(pollenOffer, PollenOfferDTO.class);

        PollenOfferGenericTester(pollenOffer, pollenOfferDTO);
    }

    @Test
    public void pollenOfferStartDateToPollenOfferDateContainerDTO() {
        PollenOfferDateContainerDTO  pollenOfferDateContainerDTO;
        PollenOfferStartDate  pollenOfferStartDate = new PollenOfferStartDate();
        PollenOffer pollenOffer1;
        PollenOffer pollenOffer2;
        User user1 = LabelCloneDefinitions.user1;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;
        pollenOffer1 = new PollenOffer(specimenM);
        pollenOffer2 = new PollenOffer( specimenF);
        pollenOfferStartDate.addPollenOffer(pollenOffer1);
        pollenOfferStartDate.addPollenOffer(pollenOffer2);
        pollenOfferDateContainerDTO = this.modelMapper.map(pollenOfferStartDate,PollenOfferDateContainerDTO.class);

        assertEquals(pollenOfferStartDate.getPollenOffers().size(),pollenOfferDateContainerDTO.getPollenOffers().size());

        PollenOfferGenericTester(pollenOffer1, pollenOfferDateContainerDTO.getPollenOffers().get(0));
        PollenOfferGenericTester(pollenOffer2, pollenOfferDateContainerDTO.getPollenOffers().get(1));




    }


    @Test
    public void tradeToTradeDTOTest() {
        Trade trade;
        TradeDTO tradeDTO;
        PollenOffer initiatedPollenOffer;
        PollenOffer requestedPollenOffer;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;

        initiatedPollenOffer = new PollenOffer( specimenM);
        requestedPollenOffer = new PollenOffer( specimenF);
        trade = new Trade(initiatedPollenOffer, requestedPollenOffer);
        tradeDTO = this.modelMapper.map(trade, TradeDTO.class);

        PollenOfferGenericTester(initiatedPollenOffer, tradeDTO.getInitiatedOffer());
        PollenOfferGenericTester(requestedPollenOffer, tradeDTO.getRequestedOffer());


    }

    @Test
    public void tradeDatesToTradeDTOTest() {

        Trade trade;
        TradeStartDate  tradeStartDate  = new TradeStartDate();
        TradeDateContainerDTO tradeDateContainerDTO;

        PollenOffer initiatedPollenOffer;
        PollenOffer requestedPollenOffer;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;

        initiatedPollenOffer = new PollenOffer( specimenM);
        requestedPollenOffer = new PollenOffer( specimenF);
        trade = new Trade(initiatedPollenOffer, requestedPollenOffer);
        tradeStartDate.addTrade(trade);

        tradeDateContainerDTO = this.modelMapper.map(tradeStartDate, TradeDateContainerDTO.class);

        PollenOfferGenericTester(initiatedPollenOffer, tradeDateContainerDTO.getTrades().get(0).getInitiatedOffer());
        PollenOfferGenericTester(requestedPollenOffer,  tradeDateContainerDTO.getTrades().get(0).getRequestedOffer());


    }


    @Test
    public void tradeWithRatingsToTradeDTOTest() {
        Trade trade;
        TradeDTO tradeDTO;
        PollenOffer initiatedPollenOffer;
        PollenOffer requestedPollenOffer;
        Specimen specimenM = LabelCloneDefinitions.specimenUser1Male;
        Specimen specimenF = LabelCloneDefinitions.specimenUser2Female;

        initiatedPollenOffer = new PollenOffer( specimenM);
        requestedPollenOffer = new PollenOffer( specimenF);
        trade = new Trade(initiatedPollenOffer, requestedPollenOffer);
        trade.acceptTrade();
        tradeDTO = this.modelMapper.map(trade, TradeDTO.class);

        PollenOfferGenericTester(initiatedPollenOffer, tradeDTO.getInitiatedOffer());
        PollenOfferGenericTester(requestedPollenOffer, tradeDTO.getRequestedOffer());
        assertEquals(trade.getRatings().size(),tradeDTO.getTradeRatingsDTO().size());


    }


    private void PollenOfferGenericTester(PollenOffer pollenOffer, PollenOfferDTO pollenOfferDTO) {
        // should be null since  uuid is set by Database
        assertEquals(pollenOffer.getUuid(), pollenOfferDTO.getId());
        assertEquals(pollenOffer.getUser().getUsername(), pollenOfferDTO.getUser().getUsername());
        assertEquals(pollenOffer.getSpecimen().getSexAsString(), pollenOfferDTO.getSex());
        assertEquals(pollenOffer.getSpecimen().getClone().getCloneId(), pollenOfferDTO.getCloneId());
        assertEquals(pollenOffer.getSpecimen().getClone().getLocationAsString(), pollenOfferDTO.getLocation());
        assertEquals(pollenOffer.getSpecimen().getClone().getSellerAsString(), pollenOfferDTO.getSeller());
        assertEquals(pollenOffer.getSpecimen().getNepenthesname(), pollenOfferDTO.getNepenthesName());
        assertEquals(pollenOffer.getStartDate(),pollenOfferDTO.getPollenOfferOpenedDate());
    }



}
