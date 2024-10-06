package com.nepflow.PollenExchange;

import com.nepflow.PollenExchange.Dto.*;
import com.nepflow.PollenExchange.Model.*;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.PollenExchange.Projection.TradeStatus;
import com.nepflow.PollenExchange.Projection.UserRating;
import com.nepflow.UserManagement.Dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

@Configuration
public class ModelMapperConfigPollenExchange {


    ModelMapper modelMapper = new ModelMapper();


    @Bean
    public ModelMapper modelMapperPollenExchange() {

        modelMapper.addMappings(new PropertyMap<PollenOffer, PollenOfferDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getUuid());
                map().setLocation(source.getSpecimen().getLocationAsString());
                map().setNepenthesName(source.getSpecimen().getNepenthesname());
                map().setSeller(source.getSpecimen().getSellerAsString());
                map().setSex(source.getSpecimen().getSexAsString());
                map().setCloneId(source.getSpecimen().getClone().getCloneId());
                map().setImageLocation(source.getSpecimen().getImagePath());
                map().setPollenOfferOpenedDate(source.getStartDate());
                map().getUser().setCountry(source.getUser().getCountry().getName());
                map().getUser().setUsername(source.getUser().getUsername());
            }
        });
        // Trade Mapping

        modelMapper.addMappings(new PropertyMap<Trade, TradeDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getUuid());
                map().setStatus(source.getTradeStatus());
                map().setTradeOpenedDate(source.getTradeOpenedDate());
                using(ctx -> modelMapper.map(((Trade) ctx.getSource()).getInitiatedOffer(), PollenOfferDTO.class))
                        .map(source, destination.getInitiatedOffer());
                using(ctx -> modelMapper.map(((Trade) ctx.getSource()).getRequestedOffer(), PollenOfferDTO.class))
                        .map(source, destination.getRequestedOffer());

                using(ctx -> modelMapper.map(((Trade) ctx.getSource()).getInitiatedOffer().getUser().getUsername(), UserDTO.class))
                        .map(source, destination.getInitiatedOffer().getUser().getUsername());

                using(ctx -> modelMapper.map(((Trade) ctx.getSource()).getRequestedOffer().getUser().getUsername(), UserDTO.class))
                        .map(source, destination.getRequestedOffer().getUser().getUsername());
            }

        });

        modelMapper.addMappings(new PropertyMap<TradeStartDate, TradeDateContainerDTO>() {
            @Override
            protected void configure() {
                map().setDate(source.getMonthYearId());

            }
        });
        modelMapper.addMappings(new PropertyMap<PollenOfferStartDate, PollenOfferDateContainerDTO>() {
            @Override
            protected void configure() {
                map().setDate(source.getMonthYearId());
            }
        });

        modelMapper.addMappings(new PropertyMap<PollenOfferSpeciesStatisticsDTOProjection, PollenOfferSpeciesStatisticsDTO>() {
            @Override
            protected void configure() {
                map().setCloneId(source.getCloneId());
                map().setNepenthesName(source.getNepenthesName());
                map().setSpecimenId(source.getSpecimenId());
                map().setFloweringCount(source.getFloweringCount());
            }

        });
        modelMapper.addMappings(new PropertyMap<Page<UserRating>, RatingPage>() {
            @Override
            protected void configure() {
                map().setPageNumber(source.getPageable().getPageNumber());
                map().setPageSize(source.getPageable().getPageSize());
                map().setTotalPages(source.getTotalPages());

            }

        });
        modelMapper.addMappings(new PropertyMap<TradeStatus, TradeStatusDTO>() {
            @Override
            protected void configure() {
                map().setTradeId(source.getTradeId());
                map().setStatus(source.getRating());
                map().setCreationDate(source.getCreationDate());

            }

        });
        modelMapper.addMappings(new PropertyMap<TradeRating, NewRatingResponseDTO>() {
            @Override
            protected void configure() {
                map().setComment(source.getComment());
                map().setReviewType(source.getRating());
                map().setImageLocation(source.getImageLocation());
            }

        });


        return modelMapper;
    }


}
