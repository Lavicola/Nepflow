package com.nepflow;

import com.nepflow.NepenthesManagement.Dto.CloneDTO;
import com.nepflow.NepenthesManagement.Model.Clones.IVNepenthesClone;
import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {



    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        modelMapper.addMappings(new PropertyMap<IVNepenthesClone, CloneDTO>() {
            @Override
            protected void configure() {
                map().setProducer(source.getProducer().getName());
                map().setLocation(source.getLocation().getName());
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
