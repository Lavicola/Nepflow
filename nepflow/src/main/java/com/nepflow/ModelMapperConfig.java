package com.nepflow;

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
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                map().setCountry(source.getCountry().getName());
            }
        });



        return modelMapper;
    }
}
