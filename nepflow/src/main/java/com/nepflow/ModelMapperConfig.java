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
import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {



    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();



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
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setCountry(source.getCountry().getName());
            }
        });

        return modelMapper;


    }
}
