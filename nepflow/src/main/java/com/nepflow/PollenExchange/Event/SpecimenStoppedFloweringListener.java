package com.nepflow.PollenExchange.Event;

import com.nepflow.GrowlistManagement.Event.SpecimenStoppedFloweringEvent;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpecimenStoppedFloweringListener {

    @Autowired
    PollenExchangeService pollenExchangeService;


    @EventListener
    public void handleSpecimenStoppedFloweringEvent(SpecimenStoppedFloweringEvent event) {
        this.pollenExchangeService.closePollenOffer(event.getSpecimen());


    }



}
