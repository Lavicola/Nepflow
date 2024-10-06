package org.openapitools.configuration;

import com.nepflow.PollenExchange.Dto.ReviewType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.reviewTypeConverter")
    Converter<String, ReviewType> reviewTypeConverter() {
        return new Converter<String, ReviewType>() {
            @Override
            public ReviewType convert(String source) {
                return ReviewType.fromValue(source);
            }
        };
    }

}
