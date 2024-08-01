package com.nepflow.PollenExchange.ModelMapper;

import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.LabelCloneDefinitions;
import com.nepflow.ModelMapperConfig;
import com.nepflow.PollenExchange.Dto.PollenOfferDTO;
import com.nepflow.PollenExchange.Dto.PollenOfferDateContainerDTO;
import com.nepflow.PollenExchange.Dto.TradeDTO;
import com.nepflow.PollenExchange.Model.PollenOffer;
import com.nepflow.PollenExchange.Model.PollenOfferStartDate;
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
    public void pollenOfferStartDateToPollenOfferDateContainerDTO() {
        PollenOfferDateContainerDTO  pollenOfferDateContainerDTO;
        PollenOfferStartDate  pollenOfferStartDate = new PollenOfferStartDate();
        PollenOffer pollenOffer1;
        PollenOffer pollenOffer2;
        User user1 = LabelCloneDefinitions.user1;
        Specimen specimenM = LabelCloneDefinitions.SpecimenM;
        Specimen specimenF = LabelCloneDefinitions.SpecimenF;
        pollenOffer1 = new PollenOffer(user1, specimenM);
        pollenOffer2 = new PollenOffer(user1, specimenF);
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
