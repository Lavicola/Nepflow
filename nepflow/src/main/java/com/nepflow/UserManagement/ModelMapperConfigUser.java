package com.nepflow.UserManagement;

import com.nepflow.UserManagement.Dto.UserDTO;
import com.nepflow.UserManagement.Model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigUser {

    ModelMapper modelMapper = new ModelMapper();

    @Bean
    public ModelMapper modelMapperUser() {

        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setUsername(source.getUsername());
                map().setCountry(source.getCountry().getName());
            }
        });

        return modelMapper;

    }
}
