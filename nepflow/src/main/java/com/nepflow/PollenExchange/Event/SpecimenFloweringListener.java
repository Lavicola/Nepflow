package com.nepflow.PollenExchange.Event;

import com.nepflow.GrowlistManagement.Event.SpecimenFloweringEvent;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eventlistener used to create a PollenOffer asynchronous.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */

@Component
public class SpecimenFloweringListener {

    /**
     *
     */
    @Autowired
    private PollenExchangeService pollenExchangeService;


    /**
     * @param event SpecimenFloweringEvent
     */
    @EventListener
    public void handleSpecimenFloweringEvent(final SpecimenFloweringEvent event) {

        this.pollenExchangeService.createOrReOpenPollenOffer(event.getSpecimen());


    }


}

