package com.nepflow.PollenExchange.Event;

import com.nepflow.GrowlistManagement.Event.SpecimenStoppedFloweringEvent;
import com.nepflow.PollenExchange.Service.PollenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eventlistener used to close a PollenOffer asynchronous.
 *
 * @author David Schmidt
 * @version 14. Nov 2024
 */

@Component
public class SpecimenStoppedFloweringListener {

    /**
     *
     */
    @Autowired
    private PollenExchangeService pollenExchangeService;


    /**
     * @param event SpecimenStoppedFloweringEvent
     */
    @EventListener
    public void handleSpecimenStoppedFloweringEvent(final SpecimenStoppedFloweringEvent event) {
        this.pollenExchangeService.closePollenOffer(event.getSpecimen());


    }


}
