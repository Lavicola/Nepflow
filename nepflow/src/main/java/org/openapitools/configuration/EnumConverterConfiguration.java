package org.openapitools.configuration;

import com.nepflow.GrowlistManagement.Dto.CloneType;
import com.nepflow.GrowlistManagement.Dto.NepenthesType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.cloneTypeConverter")
    Converter<String, CloneType> cloneTypeConverter() {
        return new Converter<String, CloneType>() {
            @Override
            public CloneType convert(String source) {
                return CloneType.fromValue(source);
            }
        };
    }
    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.nepenthesTypeConverter")
    Converter<String, NepenthesType> nepenthesTypeConverter() {
        return new Converter<String, NepenthesType>() {
            @Override
            public NepenthesType convert(String source) {
                return NepenthesType.fromValue(source);
            }
        };
    }

}
