package com.nepflow;

import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.*;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import com.nepflow.PollenExchange.Dto.*;
import com.nepflow.PollenExchange.Model.*;
import com.nepflow.PollenExchange.Projection.PollenOfferSpeciesStatisticsDTOProjection;
import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    ModelMapper modelMapper = new ModelMapper();


    @Bean
    public ModelMapper modelMapper() {

        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setUsername(source.getUsername());
                map().setCountry(source.getCountry().getName());
            }
        });

        // Mapping of Label subclasses to LabelDTO
        TypeMap<Label, LabelDTO> LabeltypeMap = modelMapper.createTypeMap(Label.class, LabelDTO.class)
                .addMapping(Label::getName, LabelDTO::setNepenthesName);
        LabeltypeMap.include(Species.class, LabelDTO.class);
        // Mapping of Clone subclasses to CloneDTO
        TypeMap<Clone, CloneDTO> CloneMap = modelMapper.createTypeMap(Clone.class, CloneDTO.class)
                .addMapping(Clone::getLabelName, CloneDTO::setNepenthesName);
        CloneMap.include(IVClone.class, CloneDTO.class);
        CloneMap.include(IVPrimaryHybrid.class, CloneDTO.class);
        CloneMap.include(IVMultiHybrid.class, CloneDTO.class);

        CloneMap.include(ICClone.class, CloneDTO.class);
        CloneMap.include(ICPrimaryHybrid.class, CloneDTO.class);
        CloneMap.include(ICMultiHybrid.class, CloneDTO.class);

        modelMapper.addMappings(new PropertyMap<IVSpeciesClone, CloneDTO>() {
            @Override
            protected void configure() {
                map().setProducer(source.getProducer().getName());
                map().setLocation(source.getLocationAsString());
            }
        });

        modelMapper.addMappings(new PropertyMap<Growlist, GrowlistDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getUuid());
                map().setIsPublic(source.isPublic());
            }

        });

        modelMapper.addMappings(new PropertyMap<Specimen, SpecimenCloneDTO>() {
            @Override
            protected void configure() {
                map().setSpecimenId(source.getUuid());
                map().setIsFlowering(source.getFlowerStatus());
                map().setFilelocation(source.getImagePath());
                map().setProducer(source.getClone().getSellerAsString());
                map().setSex(source.getClone().getSexAsString());
                map().setNepenthesName(source.getClone().getLabelName());
                map().setNickname(source.getClone().getCultivarName());
                map().setLocation(source.getClone().getLocationAsString());
            }
        });
        //  PollenExchange Mapping
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
        modelMapper.addMappings(new PropertyMap<TradeStartDate  , TradeDateContainerDTO>() {
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
        modelMapper.addMappings(new PropertyMap<TradeRating, TradeRatingDTO>() {
            @Override
            protected void configure() {
                // TODO maybe check mapping in order to not have a wrapper method
                map().setDate(source.getTrade().convertOpenedDay());
                map().setStatus(source.getRating());
                map().setTradeId(source.getTrade().getUuid());
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
        return modelMapper;


    }



}
