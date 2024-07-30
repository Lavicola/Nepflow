package com.nepflow.PollenExchange.ModelMapper;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.ModelMapperConfig;
import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.TradeDTO;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.Trade;
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
        User user1 = LabelCloneDefinitions.user1;
        Specimen specimenM = LabelCloneDefinitions.SpecimenM;
        pollenOffer = new PollenOffer(user1, specimenM);
        pollenOfferDTO = this.modelMapper.map(pollenOffer, PollenOfferDTO.class);

        PollenOfferGenericTester(pollenOffer, pollenOfferDTO);
    }

    @Test
    public void tradeToTradeDTOTest() {
        Trade trade;
        TradeDTO tradeDTO;
        PollenOffer initiatedPollenOffer;
        PollenOffer requestedPollenOffer;
        User user1 = LabelCloneDefinitions.user1;
        User user2 = LabelCloneDefinitions.user2;
        Specimen specimenM = LabelCloneDefinitions.SpecimenM;
        Specimen specimenF = LabelCloneDefinitions.SpecimenF;

        initiatedPollenOffer = new PollenOffer(user1, specimenM);
        requestedPollenOffer = new PollenOffer(user2, specimenF);
        trade = new Trade(user1, initiatedPollenOffer, requestedPollenOffer, user2);
        tradeDTO = this.modelMapper.map(trade, TradeDTO.class);

        PollenOfferGenericTester(initiatedPollenOffer, tradeDTO.getInitiatedOffer());
        PollenOfferGenericTester(requestedPollenOffer, tradeDTO.getRequestedOffer());


    }


    private void PollenOfferGenericTester(PollenOffer pollenOffer, PollenOfferDTO pollenOfferDTO) {
        assertEquals(pollenOffer.getUser().getUsername(), pollenOfferDTO.getUser().getUsername());
        assertEquals(pollenOffer.getSpecimen().getSexAsString(), pollenOfferDTO.getSex());
        assertEquals(pollenOffer.getSpecimen().getClone().getCloneId(), pollenOfferDTO.getCloneId());
        assertEquals(pollenOffer.getSpecimen().getClone().getLocationAsString(), pollenOfferDTO.getLocation());
        assertEquals(pollenOffer.getSpecimen().getClone().getSellerAsString(), pollenOfferDTO.getSeller());
        assertEquals(pollenOffer.getSpecimen().getNepenthesname(), pollenOfferDTO.getNepenthesName());
        assertEquals(pollenOffer.getStartDate(),pollenOfferDTO.getPollenOfferOpenedDate());
    }


}
