package com.nepflow.NepenthesManagement;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Dto.LabelDTO;
import com.nepflow.NepenthesManagement.Model.Clones.*;
import com.nepflow.NepenthesManagement.Model.Labels.Label;
import com.nepflow.NepenthesManagement.Model.Labels.Species;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigNepenthes {


    ModelMapper modelMapper = new ModelMapper();


    @Bean
    public ModelMapper modelMapperNepenthes(){
        // Mapping of Label subclasses to LabelDTO
        TypeMap<Label, LabelDTO> labeltypeMap = modelMapper.createTypeMap(Label.class, LabelDTO.class)
                .addMapping(Label::getName, LabelDTO::setNepenthesName);
        labeltypeMap.include(Species.class, LabelDTO.class);

        // Mapping of Clone subclasses to CloneDTO
        TypeMap<Clone, CloneDTO> typeMap = modelMapper.createTypeMap(Clone.class, CloneDTO.class)
                .addMapping(Clone::getLabelName, CloneDTO::setNepenthesName)
                .addMapping(Clone::getSexAsString, CloneDTO::setSex)
                .addMapping(Clone::getLocationAsString, CloneDTO::setLocation)
                .addMapping(Clone::getSellerAsString, CloneDTO::setProducer)
                .addMapping(Clone::getCloneId, CloneDTO::setCloneId)
                .addMapping(Clone::getInternalCloneId, CloneDTO::setInternalCloneId);
        typeMap.include(ICSpeciesClone.class, CloneDTO.class);
        typeMap.include(IVSpeciesClone.class, CloneDTO.class);
        typeMap.include(IVClone.class, CloneDTO.class);
        typeMap.include(ICClone.class, CloneDTO.class);
        typeMap.include(IVPrimaryHybrid.class, CloneDTO.class);
        typeMap.include(ICPrimaryHybrid.class, CloneDTO.class);
        typeMap.include(ICMultiHybrid.class, CloneDTO.class);
        typeMap.include(IVMultiHybrid.class, CloneDTO.class);

        return modelMapper;
    }



}
