package org.openapitools.configuration;

import com.nepflow.PollenExchange.Dto.TradeStatus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.tradeStatusConverter")
    Converter<String, TradeStatus> tradeStatusConverter() {
        return new Converter<String, TradeStatus>() {
            @Override
            public TradeStatus convert(String source) {
                return TradeStatus.fromValue(source);
            }
        };
    }

}
