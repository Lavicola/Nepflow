package com.nepflow.GrowlistManagement;

import com.nepflow.GrowlistManagement.Dto.GrowlistDTO;
import com.nepflow.GrowlistManagement.Dto.SpecimenCloneDTO;
import com.nepflow.GrowlistManagement.Model.Growlist;
import com.nepflow.GrowlistManagement.Model.Specimen;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigGrowlist {


    ModelMapper modelMapper = new ModelMapper();


    @Bean
    public ModelMapper modelMapperGrowlist() {

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

        return modelMapper;
    }
}