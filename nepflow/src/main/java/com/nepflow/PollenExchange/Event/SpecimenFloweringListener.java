package com.nepflow.PollenExchange.Event;

import com.nepflow.GrowlistManagement.Event.SpecimenFloweringEvent;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpecimenFloweringListener {

    @Autowired
    PollenExchangeService pollenExchangeService;


    @EventListener
    public void handleSpecimenFloweringEvent(SpecimenFloweringEvent event) {

        this.pollenExchangeService.createOrReOpenPollenOffer(event.getSpecimen(),event.getUser());


    }


}

